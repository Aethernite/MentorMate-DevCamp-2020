import { createSlice } from "@reduxjs/toolkit";
import * as api from "../../api/AxiosQueries";

const initialState = {
    isLoading: false,
    user: null,
}

const { reducer: userReducer, actions } = createSlice({
    name: 'users',
    initialState,
    reducers: {
        fetchUserStart: (state) => {
            state.isLoading = true;
            state.error = null;
            state.user = null;
        },
        fetchUserSuccess: (state, action) => {
            state.isLoading = false;
            state.error = null;
            state.user = action.payload;
        },
        fetchUserFailure: (state, action) => {
            state.isLoading = false;
            state.error = action.payload;
            state.user = null;
        },
        clearUser: (state) => {
            state.user = null;
        },
        followStart: (state) => {
            state.isLoading = true;
        },
        followSuccess: (state, action) => {
            state.isLoading = false;
            state.user.following = action.payload.success;
            state.user.followersCount++;
            state.error = null;
        },
        followFailure: (state, action) => {
            state.isLoading = false;
            state.error = action.payload;
        },
        unfollowStart: (state) => {
            state.isLoading = true;
        },
        unfollowSuccess: (state, action) => {
            state.isLoading = false;
            state.user.following = !action.payload.success;
            state.user.followersCount--;
            state.error = null;
        },
        unfollowFailure: (state, action) => {
            state.isLoading = false;
            state.error = action.payload;
        },

        avatarChangeStart: (state) => {
            state.isLoading = true;
        },
        avatarChangeSuccess: (state, action) => {
            state.isLoading = false;
            state.user = action.payload;
            state.error = null;
        },
        avatarChangeFailure: (state, action) => {
            state.isLoading = false;
            state.error = action.payload;
        },


    },
});


export const fetchUserByUsername = ({ username }) => {
    return async (dispatch) => {

        try {
            dispatch(actions.fetchUserStart());
            const fetchedUser = await api.fetchUserByUsername({ username });
            dispatch(actions.fetchUserSuccess(fetchedUser));
        }
        catch (err) {
            dispatch(actions.fetchUserFailure(err?.response?.data?.message));
        }
    }
};

export const clearUser = () => {
    return async (dispatch) => {
        dispatch(actions.clearUser());
    }
};

export const followUserById = (userId) => {
    return async (dispatch) => {
        try {
            dispatch(actions.followStart());
            const result = await api.followUser(userId);
            dispatch(actions.followSuccess(result));
        } catch (err) {
            dispatch(actions.followFailure(err?.response?.data?.message));
        }
    };
};

export const unfollowUserById = (userId) => {
    return async (dispatch) => {
        try {
            dispatch(actions.unfollowStart());
            const result = await api.unfollowUser(userId);
            dispatch(actions.unfollowSuccess(result));
        } catch (err) {
            dispatch(actions.unfollowFailure(err?.response?.data?.message));
        }
    };
};

export const uploadUserPhoto = ({ userId, photoId }) => {
    return async (dispatch) => {
        try {
            dispatch(actions.avatarChangeStart());
            const user = await api.updatePhoto(photoId);
            dispatch(actions.avatarChangeSuccess(user));
        } catch (err) { }
    };
};


export { userReducer };