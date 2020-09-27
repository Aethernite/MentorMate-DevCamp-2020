import axios from 'axios';

const instance = axios.create({
    baseURL: 'https://reactdevcampapi.com',
    withCredentials: true
});

//Authorization
export const signIn = async ({ username, password }) => {
    const res = await instance.post('/signin', { username, password });
    return res.data;
}

export const signUp = async ({ name, username, password }) => {
    const res = await instance.post('/signup', { name, username, password });
    return res.data;
}

export const signOut = async () => {
    const res = await instance.post('/signout');
    return res.data;
}

//User related
export const getMe = async () => {
    const res = await instance.get('/users/me');
    return res.data;
}

export const getPostsForUser = async ({ userId, cursor, limit }) => {
    const res = await instance.get(`/v1/users/${userId}/posts`, { params: { cursor, limit } });
    return res.data;
}

export const searchUsers = async (query) => {
    const res = await instance.get(`/users`, { params: { search: query } });
    return res.data;
}

export const fetchUserByUsername = async ({ username }) => {
    const res = await instance.get(`/users/${username}`);
    return res.data;
}

export const followUser = async (userId) => {
    const res = await instance.post(`/users/${userId}/follow`);
    return res.data;
};

export const unfollowUser = async (userId) => {
    const res = await instance.post(`/users/${userId}/unfollow`);
    return res.data;
};

export const getUser = async (identifier) => {
    const res = await instance.get(`/users/${identifier}`);
    return res.data;
};

//Generic
export const getNewsFeedPosts = async ({ cursor, limit }) => {
    const res = await instance.get('/v1/posts/', { params: { cursor, limit } });
    return res.data;
}

export const uploadMedia = async (file) => {
    const formData = new FormData();
    formData.append('media', file);

    const res = await instance.post('/media', formData, {
        headers: {
            'Content-Type': 'multipart/form-data'
        }
    });

    return res.data;
}

export const updatePhoto = async (photoId) => {
    const res = await instance.patch(`/users/me`, {
        'avatarId': photoId,
    });
    return res.data;
};

//Post related
export const createPost = async ({ title, content, mediaId }) => {
    const res = await instance.post('/posts', { title, content, mediaId });

    return res.data;
}

export const deletePost = async (id) => {
    const res = await instance.delete(`/posts/${id}`);
    return res.data;
};

export const likePost = async (id) => {
    const res = await instance.post(`/posts/${id}/like`);
    return res.data;
}

export const dislikePost = async (id) => {
    const res = await instance.post(`/posts/${id}/dislike`);
    return res.data;
}

export const getCommentsForPost = async (postId, { cursor, limit }) => {
    const res = await instance.get(`/v1/posts/${postId}/comments`, {
        params: { cursor, limit },
    });

    return res.data;
};

//Comments
export const createComment = async ({ postId, content, mediaId }) => {
    const res = await instance.post(`/comments`, { postId, content, mediaId });
    return res.data;
};

export const deleteComment = async (id) => {
    const res = await instance.delete(`/comments/${id}`);
    return res.data;
};

export const likeComment = async (id) => {
    const res = await instance.post(`/comments/${id}/like`);
    return res.data;
};

export const dislikeComment = async (id) => {
    const res = await instance.post(`/comments/${id}/dislike`);
    return res.data;
};

