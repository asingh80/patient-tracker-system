import React from 'react';
import { useNavigate, BrowserRouter as Router, Route, Routes, Link } from 'react-router-dom';
import './stylesheets/App.css';
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

  const handleButtonClick = () => {
    navigate('/path'); // Replace '/path' with the desired route
  };

  return (
    <div>
      {/* <h1 className="welcomeText">Welcome to Medisync</h1>
      <div className="login-buttons">
          <button onClick={() => handleLogin('doctor')}>I am a patient</button>
          <button onClick={() => handleLogin('patient')}>I am a doctor</button>
        </div> */}
    </div>
  );
};

const App = () => {
  return (
    <Router>
      {/* <div>hi</div> */}
      <NavBar></NavBar>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/doctor" element={<WelcomePage />} />
        <Route path="/patient" element={<WelcomePage />} />
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
        <h1>Hello Doctor!</h1>
        <p>Overview</p>
        <div className="login-buttons">
          <button onClick={() => handleLogin('teacher')}>Teacher Login</button>
          <button onClick={() => handleLogin('student')}>Student Login</button>
        </div>
      </div>
    </div>
  );
};