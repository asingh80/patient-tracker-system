import React from 'react';
import { useNavigate, BrowserRouter as Router, Route, Routes, Link } from 'react-router-dom';
import LoginForm from './LoginSignup';
import './stylesheets/App.css';
import './stylesheets/WelcomePage.css'
const NavBar = () => {
  return (
    <div>
      <nav>
        <ul className="main-nav">
          <li className="logo">
            <Link to="/">
              <img src="/logo512.png" alt="" className="logo-img" />
              Medisync
            </Link>
          </li>
        </ul>
      </nav>
    </div>
  );
};

const Home = () => {
  const navigate = useNavigate();

  const handleLogin = (userType) => {
    navigate(`/${userType}/${userType}`);
  };

  return (
    <div className="container">
      <h1 className="welcomeText">Welcome to Medisync</h1>
      <div className="login-buttons">
          <button onClick={() => handleLogin('patient')}>I am a patient</button>
          <button onClick={() => handleLogin('doctor')}>I am a doctor</button>
      </div>
    </div>
  );
};

const App = () => {
  return (
    <Router>
      <NavBar></NavBar>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/doctor/:userType" element={<LoginForm />} />
        <Route path="/patient/:userType" element={<LoginForm />} />
        {/* Other routes */}
      </Routes>
    </Router>
  );
};

export default App;

export const WelcomePage = () => {
  const navigate = useNavigate();

  const handleLogin = userType => {
    console.log(`Logging in as ${userType}`);
    // You can add login logic here
  };

  return (
    <div className="welcome-container">
      <div className="welcome-content">
        <h1>Hello!</h1>
        <p>Overview</p>
        <div className="login-buttons">
          <button onClick={() => handleLogin('')}>Sign up</button>
          <button onClick={() => handleLogin('')}>Login</button>
        </div>
      </div>
    </div>
  );
};