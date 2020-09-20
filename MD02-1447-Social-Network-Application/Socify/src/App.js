import React from 'react';
//Navigation Bar
import NavigationBar from './components/NavigationBar.js';
//Routes
import AppRoutes from './AppRoutes';
//React-Router-Dom
import {
  BrowserRouter as Router,
} from "react-router-dom";
//Authentication Context Provider
import { AuthContextProvider } from './contexts/AuthContext';

function App() {

  return (
    <Router>
      <AuthContextProvider>
        <NavigationBar />
        <AppRoutes />
      </AuthContextProvider>
    </Router>

  )
}

export default App;