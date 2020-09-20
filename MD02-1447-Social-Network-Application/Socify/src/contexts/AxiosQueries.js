import axios from 'axios';

const instance = axios.create({
    baseURL: 'https://reactdevcampapi.com',
    withCredentials: true
});


export const signIn = async ({ username, password }) => {
    const res = await instance.post('/signin', { username, password });
    return res.data;
}

export const signUp = async ({ name, username, password }) => {
    const res = await instance.post('/signup', { name, username, password });
    return res.data;
}

export const getMe = async () => {
    const res = await instance.get('/users/me');
    return res.data;
}

export const signOut = async () => {
    const res = await instance.post('/signout');
    return res.data;
}
