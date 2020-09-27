import { combineReducers } from 'redux';
import { postsReducer } from './slices/posts';
import { authReducer } from './slices/auth';
import { commentsReducer } from './slices/comments';
import { uploadReducer } from './slices/upload';
import { userReducer } from './slices/users';

const rootReducer = combineReducers({
    auth: authReducer,
    posts: postsReducer,
    comments: commentsReducer,
    upload: uploadReducer,
    user: userReducer,
});
export { rootReducer };