import * as api from '../../api/AxiosQueries';
import { createSlice } from "@reduxjs/toolkit";
import { removeCommentMedia } from './upload';

const initialState = {};

const { reducer, actions } = createSlice({
    name: "comments",
    initialState,
    reducers: {
        fetchCommentsStart: (state, action) => {
            state[action.payload.postId] = {
                ...state[action.payload.postId],
                isLoading: true,
            };
        },
        fetchCommentsSuccess: (state, action) => {
            const currentCommentsForPost = state[action.payload.postId]?.data || [];
            state[action.payload.postId] = {
                ...state[action.payload.postId],
                isLoading: false,
                error: null,
                cursor: action.payload.cursor,
                limit: 5,
                data: [
                    ...currentCommentsForPost,
                    ...action.payload.results.filter(
                        (x) =>
                            !currentCommentsForPost.some((comment) => comment.id === x.id)
                    ),
                ],
            };
            state.error = null;
        },
        fetchCommentsFailure: (state, action) => {
            state[action.payload.postId] = {
                ...state[action.payload.postId],
                isLoading: false,
                error: action.payload.errorMsg,
            };
        },

        createCommentsStart: (state, action) => {
            state[action.payload.postId] = {
                ...state[action.payload.postId],
                isMutating: true,
            };
        },

        createCommentsSuccess: (state, action) => {
            const currentCommentsForPost = state[action.payload.postId]?.data || [];
            currentCommentsForPost.push(action.payload.createdComment);

            state[action.payload.postId] = {
                ...state[action.payload.postId],
                isMutating: false,
                data: currentCommentsForPost,
                mutationError: null
            };
            state.media = null;
        },

        createCommentsFailure: (state, action) => {
            state[action.payload.postId] = {
                ...state[action.payload.postId],
                isMutating: false,
                mutationError: action.payload.errorMsg,
            };
            state.media = null;
        },
        deleteCommentsStart: (state, action) => {

            state[action.payload.postId] = {
                ...state[action.payload.postId],
                isMutating: true,
            };
        },

        deleteCommentsSuccess: (state, action) => {

            const currentCommentsForPost = state[action.payload.postId]?.data || [];
            debugger
            const newCurrentCommentsForPost = currentCommentsForPost.filter(
                (comment) => comment?.id !== action?.payload?.commentId);
            debugger
            state[action.payload.postId] = {
                ...state[action.payload.postId],
                isMutating: false,
                data: newCurrentCommentsForPost,
                mutationError: null,
            };
        },

        deleteCommentsFailure: (state, action) => {
            state[action.payload.postId] = {
                ...state[action.payload.postId],
                isMutating: false,
                mutationError: action.payload.errorMsg,
            };
        },

        likeCommentStart: (state) => {
            state.isMutating = true;
        },
        likeCommentSuccess: (state, action) => {
            state[action.payload.postId].data.forEach(comment => {
                if (comment.id === action.payload.commentId) {
                    if (comment.disliked) {
                        comment.dislikesCount--;
                        comment.disliked = false;
                    }

                    if (comment.liked) {
                        comment.likesCount--;
                        comment.liked = false;
                    }
                    else {
                        comment.likesCount++;
                        comment.liked = true;
                    }
                }
            });
            state.isMutating = false;
            state.mutationError = null;
        },

        likeCommentFailure: (state, action) => {
            state.isMutating = false;
            state.mutationError = action.payload;
        },

        dislikeCommentStart: (state) => {
            state.isMutating = true;
            state.mutationError = null;
        },
        dislikeCommentSuccess: (state, action) => {
            state[action.payload.postId].data.forEach(comment => {
                if (comment.id === action.payload.commentId) {
                    if (comment.liked) {
                        comment.likesCount--;
                        comment.liked = false;
                    }

                    if (comment.disliked) {
                        comment.dislikesCount--;
                        comment.disliked = false;
                    }
                    else {
                        comment.dislikesCount++;
                        comment.disliked = true;
                    }
                }
            })
            state.isMutating = false;
            state.mutationError = null;
        },

        dislikeCommentFailure: (state, action) => {
            state.isMutating = false;
            state.mutationError = action.payload;
        },
        reset: () => initialState,
    },
});
export { reducer as commentsReducer };

export const fetchCommentsForPost = (postId) => {
    return async (dispatch, getState) => {
        const { cursor = null, limit = 5 } = getState().comments?.[postId] || {};

        try {
            dispatch(actions.fetchCommentsStart({ postId }));

            const { results, cursor: nextCursor } = await api.getCommentsForPost(
                postId,
                {
                    cursor,
                    limit,
                }
            );
            dispatch(
                actions.fetchCommentsSuccess({ postId, results, cursor: nextCursor })
            );
        } catch (err) {
            dispatch(
                actions.fetchCommentsFailure({
                    postId,
                    errorMsg: err?.response?.data?.message,
                })
            );
        }
    };
};

export const createComment = ({ postId, content, mediaId }) => {
    return async (dispatch) => {
        try {
            dispatch(actions.createCommentsStart({ postId }));

            const createdComment = await api.createComment({
                postId,
                content,
                mediaId,
            });
            dispatch(actions.createCommentsSuccess({ postId, createdComment }));
        } catch (err) {
            dispatch(
                actions.createCommentsFailure({
                    postId,
                    errorMsg: err?.response?.data?.message,
                })
            );
        } finally {
            dispatch(removeCommentMedia({ postId }));
        }
    };
};

export const removeComment = ({ postId, commentId }) => {

    return async (dispatch) => {

        try {
            dispatch(actions.deleteCommentsStart({ postId }));
            await api.deleteComment(commentId);
            dispatch(actions.deleteCommentsSuccess({ postId, commentId }));
        } catch (err) {
            dispatch(actions.deleteCommentsFailure(err?.response?.data?.message));
        }
    }
};

export const likeComment = ({ commentId, postId }) => {
    return async (dispatch) => {
        try {
            dispatch(actions.likeCommentStart());
            await api.likeComment(commentId);
            dispatch(actions.likeCommentSuccess({ commentId, postId }));
        } catch (err) {
            console.log(err);
            console.log(commentId + ' ' + postId);
            dispatch(actions.likeCommentFailure(err?.response?.data?.message));
        }
    };
};

export const dislikeComment = ({ commentId, postId }) => {
    return async (dispatch) => {
        try {
            dispatch(actions.dislikeCommentStart());
            await api.dislikeComment(commentId);
            dispatch(actions.dislikeCommentSuccess({ commentId, postId }));
        } catch (err) {
            dispatch(actions.dislikeCommentFailure(err?.response?.data?.message));
        }
    };
};
