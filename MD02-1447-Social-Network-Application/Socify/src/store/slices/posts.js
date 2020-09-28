import { createSlice } from "@reduxjs/toolkit";
import * as api from "../../api/AxiosQueries";

const initialState = {
    posts: [],
    isLoading: false,
    error: null,
    isCreating: false,
    creationError: null,
    cursor: null,
    limit: 5,
    isMutating: false,
};

const { reducer: postsReducer, actions } = createSlice({
    name: 'posts',
    initialState,
    reducers: {
        clearPosts: (state) => {
            state = initialState;
        },
        fetchPostsStart: (state) => {
            state.isLoading = true;
        },
        fetchPostsSuccess: (state, action) => {
            state.isLoading = false;
            state.posts.push(...action.payload.results.filter((x) => !state.posts.some((post) => post.id === x.id)));
            state.error = null;
            state.cursor = action.payload.cursor;
        },
        fetchPostsFailure: (state, action) => {
            state.isLoading = false;
            state.posts = [];
            state.error = action.payload;
        },
        createPostStart: (state) => {
            state.isCreating = true;
        },
        createPostSuccess: (state, action) => {
            state.isCreating = false;
            state.posts.unshift(action.payload);
            state.creationError = null;
            state.media = null;
        },
        createPostFailure: (state, action) => {
            state.isCreating = false;
            state.creationError = action.payload;
        },
        postLikeStart: (state) => {
            state.isLoading = true;
            state.error = null;
        },
        postLikeSuccess: (state, action) => {
            state.posts.forEach(post => {
                if (post.id === action.payload) {
                    if (post.disliked) {
                        post.dislikesCount--;
                        post.disliked = false;
                    }

                    if (post.liked) {
                        post.likesCount--;
                        post.liked = false;
                    }
                    else {
                        post.likesCount++;
                        post.liked = true;
                    }
                }
            })
            state.isLoading = false;
        },
        postLikeFailure: (state, action) => {
            state.isLoading = false;
            state.error = action.payload;
        },
        postDislikeStart: (state) => {
            state.isLoading = true;
            state.error = null;
        },
        postDislikeSuccess: (state, action) => {
            state.posts.forEach(post => {
                if (post.id === action.payload) {
                    if (post.liked) {
                        post.likesCount--;
                        post.liked = false;
                    }

                    if (post.disliked) {
                        post.dislikesCount--;
                        post.disliked = false;
                    }
                    else {
                        post.dislikesCount++;
                        post.disliked = true;
                    }
                }
            })
            state.isLoading = false;
        },
        postDislikeFailure: (state, action) => {
            state.isLoading = false;
            state.error = action.payload;
        },
        deletePostStart: (state) => {
            state.isMutating = true;
        },
        deletePostSuccess: (state, action) => {
            state.isMutating = false;
            state.posts = state.posts.filter((post) => post.id !== action.payload);
            state.mutationError = null;
        },
        deletePostFailure: (state, action) => {
            state.isMutating = false;
            state.mutationError = action.payload;
        },

    },
});


export const fetchNewsFeedPosts = () => {
    return async (dispatch, getState) => {
        const { cursor, limit } = getState().posts;
        try {
            dispatch(actions.fetchPostsStart());
            const { results, cursor: nextCursor } = await api.getNewsFeedPosts({ cursor, limit });
            dispatch(actions.fetchPostsSuccess({ results, cursor: nextCursor }));
        } catch (err) {
            dispatch(actions.fetchPostsFailure(err?.response?.data?.message));
        }
    }
}

export const fetchUserPosts = (userId) => {
    return async (dispatch, getState) => {
        const { cursor, limit } = getState().posts;
        console.log(userId);
        try {
            dispatch(actions.fetchPostsStart());
            const { results, cursor: nextCursor } = await api.getPostsForUser({ userId, cursor, limit });
            dispatch(actions.fetchPostsSuccess({ results, cursor: nextCursor }));
        } catch (err) {
            dispatch(actions.fetchPostsFailure(err?.response?.data?.message));
        }
    }
}

export const createPost = ({ title, content, mediaId }) => {
    return async (dispatch) => {
        console.log(content);
        try {
            dispatch(actions.createPostStart());
            const post = await api.createPost({ title, content, mediaId });
            dispatch(actions.createPostSuccess(post));
        } catch (err) {
            dispatch(actions.createPostFailure(err?.response?.data?.message));
        }
    }
}

export const likePost = (id) => {
    return async (dispatch) => {
        try {
            dispatch(actions.postLikeStart());
            await api.likePost(id);
            dispatch(actions.postLikeSuccess(id));
        } catch (err) {
            dispatch(actions.postLikeFailure(err?.response?.data?.message));
        }
    }
}

export const dislikePost = (id) => {
    return async (dispatch) => {
        try {
            dispatch(actions.postDislikeStart());
            await api.dislikePost(id);
            dispatch(actions.postDislikeSuccess(id));
        } catch (err) {
            dispatch(actions.postDislikeFailure(err?.response?.data?.message));
        }
    }
}

export const deletePost = (id) => {
    return async (dispatch) => {
        try {
            dispatch(actions.deletePostStart());
            await api.deletePost(id);
            dispatch(actions.deletePostSuccess(id));
        } catch (err) {
            dispatch(actions.deletePostFailure(err?.response?.data?.message));
        }
    }
};



export const clearPosts = () => {
    return async (dispatch) => {
        dispatch(actions.clearPosts());
    }
}


export { postsReducer };