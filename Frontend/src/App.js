import React from 'react';
import './stylesheets/WelcomePage.css'
import { useNavigate } from 'react-router-dom';
import { BrowserRouter as Route, Router, Routes } from 'react-router-dom';


const Home = () => {
  const navigate = useNavigate();

  const handleButtonClick = () => {
    navigate('/path'); // Replace '/path' with the desired route
  };

  return (
    <div>
      <button onClick={handleButtonClick}>Navigate</button>
    </div>
  );
};

const App = () => {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<Home />} />
        {/* Other routes */}
      </Routes>
    </Router>
  );
};

export default App;




export const WelcomePage = () => {
  const navigate = useNavigate()

  const handleLogin = userType => {
    console.log(`Logging in as ${userType}`);
    // You can add login logic here
  };

  return (
    <div className="welcome-container">
      <div className="welcome-content">
        <h1>Welcome!</h1>
        <p>Please select your user type to login:</p>
        <div className="login-buttons">
          <button onClick={() => handleLogin('teacher')}>Teacher Login</button>
          <button onClick={() => handleLogin('student')}>Student Login</button>
        </div>
      </div>
    </div>
  );
};



// export default App;