import React from 'react';
//Navigation Bar
import NavigationBar from './components/NavigationBar.js';
//Routes
import AppRoutes from './AppRoutes';
//React-Router-Dom
import {
  BrowserRouter as Router,
} from "react-router-dom";
import { useDispatch, useSelector } from 'react-redux';
import { checkSession } from './store/slices/auth.js';
//Authentication Context Provider

function App() {

  const isSessionChecked = useSelector(state => state.auth.isSessionChecked);
  const dispatch = useDispatch();
  React.useEffect(() => {
    dispatch(checkSession());
  }, [dispatch]);

  if (!isSessionChecked) {
    return null;
  }

  return (
    <Router>
      <NavigationBar />
      <AppRoutes />
    </Router>

  )
}

export default App;