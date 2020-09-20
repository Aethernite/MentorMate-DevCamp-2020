import React from 'react';
//React-Router-Dom
import { Switch, Route, Redirect } from 'react-router-dom';
//Pages
import LoginPage from './components/LoginPage.js'
import RegisterPage from './components/RegisterPage.js'
import Profile from './components/ProfilePage'
import NewsPage from './components/NewsPage.js';
//Authorization
import { useAuth } from './contexts/AuthContext';
//Mocks
import { generatePosts } from './FakerMocks.js';

const AppRoutes = () => {

    const { user } = useAuth();
    const mockedPosts = generatePosts(20);

    if (!user) {
        return (
            <Switch>
                <Route path="/login" exact component={LoginPage} />
                <Route path="/signup" exact component={RegisterPage} />
                <Redirect to="/login" />
            </Switch>
        );
    }
    else {
        return (
            <Switch>
                <Route path="/newsfeed" exact component={() => <NewsPage mockedPosts={mockedPosts} />} />
                <Route path="/me" exact component={Profile} />
                <Redirect to="/newsfeed" />
            </Switch>
        );
    }
}

export default AppRoutes;