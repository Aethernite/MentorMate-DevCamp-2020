import React from 'react';
//History Hook
import { useHistory } from 'react-router-dom';
//Axios functions and queries
import { signIn, signOut, getMe, signUp } from './AxiosQueries';

import { generateUser } from '../FakerMocks';
const AuthContext = React.createContext()

const AuthContextProvider = ({ children }) => {
    const [isSessionChecked, setIsSessionChecked] = React.useState(false);
    const [user, setUser] = React.useState(null);
    const [error, setError] = React.useState(null);
    const [loading, setLoading] = React.useState(false);

    const [mockedUser] = React.useState(generateUser());

    const history = useHistory();

    //Handle Login
    const login = async ({ username, password }) => {
        if (loading) {
            return;
        }
        try {
            setLoading(true);
            const user = await signIn({ username, password });
            setUser(user);
            history.push("/");
        } catch (err) {
            setError(err?.response?.data);
        } finally {
            setLoading(false);
        }
    };

    //Handle Register
    const register = async ({ name, username, password }) => {
        if (loading) {
            return;
        }
        try {
            setLoading(true);
            setError(null);
            await signUp({ name, username, password });
            const user = await getMe();
            setUser(user);
            history.push('/newsfeed');
        } catch (err) {
            setError(err?.response?.data);
        } finally {
            setLoading(false);
        }
    };

    //Handle Logout
    const logout = async () => {
        await signOut();
        setUser(null);
        setError(null);
        history.push('/login');
    }

    //Handle Session Check
    React.useEffect(() => {
        const checkSession = async () => {
            try {
                const user = await getMe();
                setUser(user);
            } catch (ok) { }
            setIsSessionChecked(true);

        };
        checkSession();
    }, []);


    return <AuthContext.Provider value={{ user, loading, error, login, logout, register, mockedUser }}>{isSessionChecked ? children : null}</AuthContext.Provider>;
};

//Custom Auth Hook
const useAuth = () => {
    return React.useContext(AuthContext);
}

export { AuthContextProvider, useAuth };