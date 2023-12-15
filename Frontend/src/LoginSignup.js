import React, { useState } from 'react';
import './stylesheets/LoginSignup.css'

const LoginForm = () => {
  const [loginData, setLoginData] = useState({ email: '', password: '' });
  const [signupData, setSignupData] = useState({ email: '', password: '', confirmPassword: '' });
  const [mode, setMode] = useState('login'); // 'login' or 'signup'

  const handleLoginChange = (e) => {
    const { name, value } = e.target;
    setLoginData((prevData) => ({ ...prevData, [name]: value }));
  };

  const handleSignupChange = (e) => {
    const { name, value } = e.target;
    setSignupData((prevData) => ({ ...prevData, [name]: value }));
  };

  const handleModeChange = (newMode) => {
    setMode(newMode);
  };

  const handleLoginSubmit = (e) => {
    e.preventDefault();
    // Add login logic here
    console.log('Login data submitted:', loginData);
  };

  const handleSignupSubmit = (e) => {
    e.preventDefault();
    // Add signup logic here
    console.log('Signup data submitted:', signupData);
  };

  return (
    <div>
      <form onSubmit={mode === 'login' ? handleLoginSubmit : handleSignupSubmit}>
        {mode === 'login' ? (
          <>
            <label>Email:</label>
            <input type="email" name="email" value={loginData.email} onChange={handleLoginChange} required />
            <label>Password:</label>
            <input type="password" name="password" value={loginData.password} onChange={handleLoginChange} required />
            <button type="submit">Login</button>
            <p>
              Don't have an account?{' '}
              <span className="signup-link" onClick={() => handleModeChange('signup')}>
                Sign up
              </span>
            </p>
          </>
        ) : (
          <>
            <label>Email:</label>
            <input type="email" name="email" value={signupData.email} onChange={handleSignupChange} required />
            <label>Password:</label>
            <input type="password" name="password" value={signupData.password} onChange={handleSignupChange} required />
            <label>Confirm Password:</label>
            <input
              type="password"
              name="confirmPassword"
              value={signupData.confirmPassword}
              onChange={handleSignupChange}
              required
            />
            <button type="submit">Sign Up</button>
            <p>
              Already have an account?{' '}
              <span className="signup-link" onClick={() => handleModeChange('login')}>
                Login
              </span>
            </p>
          </>
        )}
      </form>
    </div>
  );
};

export default LoginForm;