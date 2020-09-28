import { createSlice } from '@reduxjs/toolkit';
import { signIn, getMe, signUp, signOut } from '../../api/AxiosQueries'


const initialState = {
    user: null,
    isLoading: false,
    error: null,
    isSessionChecked: false,
};

const { reducer: authReducer, actions } = createSlice({
    name: 'auth',
    initialState,
    reducers: {
        authStart: (state) => {
            state.isLoading = true;
        },
        authSuccess: (state, action) => {
            state.isLoading = false;
            state.user = action.payload;
            state.error = null;
        },
        authFailure: (state, action) => {
            state.isLoading = false;
            state.user = null;
            state.error = action.payload;
        },
        markSessionChecked: state => {
            state.isSessionChecked = true;
        },
        registerStart: (state) => {
            state.isLoading = true;
            state.error = null;
        },
        registerSuccess: (state, action) => {
            state.isLoading = false;
            state.user = action.payload;
            state.error = null;
        },
        registerFailure: (state, action) => {
            state.isLoading = false;
            state.user = null;
            state.error = action.payload;
        },
        clearErrors: (state) => {
            state.error = null;
        },
        logoutStart: (state) => {
            state.isLoading = true;
            state.error = null;
        },
        logoutSuccess: (state, action) => {
            state.isLoading = false;
            state.user = null;
            state.error = null;
        },
        logoutFailure: (state, action) => {
            state.isLoading = false;
            state.user = null;
            state.error = action.payload;
        },
    },
});

//Actions
export const login = ({ username, password }) => {
    return async (dispatch, getState) => {
        const isLoading = getState().auth.isLoading;

        if (isLoading) {
            return
        }

        try {
            dispatch(actions.authStart());
            const user = await signIn({ username, password });
            dispatch(actions.authSuccess(user));
        } catch (err) {
            dispatch(actions.authFailure(err?.response?.data?.message));
        }
    }

};

export const register = ({ firstname, lastname, username, password }) => {
    return async (dispatch, getState) => {
        const isLoading = getState().auth.isLoading;

        if (isLoading) {
            return
        }

        try {
            dispatch(actions.registerStart());
            const name = firstname + " " + lastname;
            const user = await signUp({ name, username, password });
            dispatch(actions.registerSuccess(user));
        } catch (err) {
            dispatch(actions.registerFailure(err?.response?.data?.message));
        }
    }

};

export const logout = () => {
    return async (dispatch, getState) => {
        const isLoading = getState().auth.isLoading;
        if (isLoading) {
            return
        }
        try {
            dispatch(actions.logoutStart());
            await signOut();
            dispatch(actions.logoutSuccess());
        } catch (err) {
            dispatch(actions.logoutFailure(err?.response?.data?.message));
        }
    }
};

export const checkSession = () => {
    return async (dispatch) => {
        try {
            const user = await getMe();
            dispatch(actions.authSuccess(user));
        } catch (err) { }
        dispatch(actions.markSessionChecked())
    }
}

export const clearErrors = () => {
    return async (dispatch) => {
        dispatch(actions.clearErrors());
    }
}

export { authReducer };

