import React from 'react';
//React-Router-Dom
import { Switch, Route, Redirect } from 'react-router-dom';
//Pages
import LoginPage from './components/pages/LoginPage.js'
import RegisterPage from './components/pages/RegisterPage.js'
import Profile from './components/pages/ProfilePage'
import NewsPage from './components/pages/NewsPage.js';
//Mocks
import { useSelector } from 'react-redux';

const AppRoutes = () => {

    const user = useSelector(state => state.auth.user);

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
                <Route path="/newsfeed" exact component={NewsPage} />
                <Route path="/users/:username" exact component={Profile} />
                <Redirect to="/newsfeed" />
            </Switch>
        );
    }
}

export default AppRoutes;