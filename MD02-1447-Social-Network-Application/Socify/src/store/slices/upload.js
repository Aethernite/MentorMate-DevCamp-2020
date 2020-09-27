


import { createSlice } from "@reduxjs/toolkit";
import * as api from "../../api/AxiosQueries";

const initialState = {
    isLoading: false,
    error: null,
    media: null,

}

const { reducer: uploadReducer, actions } = createSlice({
    name: 'upload',
    initialState,
    reducers: {
        uploadFileStart: (state) => {
            state.isLoading = true;
            state.error = null;
            state.media = null;
        },
        uploadFileSuccess: (state, action) => {
            state.isLoading = false;
            state.error = null;
            state.media = action.payload;
        },
        uploadFileFailure: (state, action) => {
            state.isLoading = false;
            state.error = action.payload;
            state.media = null;
        },
        uploadCommentFileStart: (state, action) => {
            state.isLoading = true;
            state.error = null;
            state[action.payload] = null;
        },
        uploadCommentFileSuccess: (state, action) => {
            state.isLoading = false;
            state.error = null;
            state[action.payload.postId] = action.payload.media
        },
        uploadCommentFileFailure: (state, action) => {
            state.isLoading = false;
            state.error = action.payload.error;
            state[action.payload.postId] = null;
        },
        removeMedia: (state) => {
            state.media = null;
        },
        removeCommentMedia: (state, action) => {
            state[action.payload.postId] = null;
        },
    },
});


export const uploadFile = (file) => {
    return async (dispatch) => {
        if (!file) {
            return;
        }

        try {
            dispatch(actions.uploadFileStart());
            const media = await api.uploadMedia(file);
            dispatch(actions.uploadFileSuccess(media));
        }
        catch (err) {
            dispatch(actions.uploadFileFailure(err?.response?.data?.message));
        }
    }
}

export const uploadCommentFile = ({ file, postId }) => {
    return async (dispatch) => {
        if (!file) {
            return;
        }
        try {
            dispatch(actions.uploadCommentFileStart(postId));
            const media = await api.uploadMedia(file);
            dispatch(actions.uploadCommentFileSuccess({ media, postId }));
        }
        catch (err) {
            dispatch(actions.uploadCommentFileFailure({ error: err?.response?.data?.message, postId }));
        }
    }
}

export const removeMedia = () => {
    return async (dispatch) => {
        dispatch(actions.removeMedia());
    }
}

export const removeCommentMedia = ({ postId }) => {
    return async (dispatch) => {
        dispatch(actions.removeCommentMedia({ postId }));
    }
}

export { uploadReducer };