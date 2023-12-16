import React, { useState } from 'react';
import './stylesheets/LoginSignup.css'
import { useParams } from 'react-router-dom';

const LoginForm = () => {
  const { userType } = useParams()
  const [loginData, setLoginData] = useState({ username: '', password: '' });
  const [signupUserData, setGeneralsignupUserData] = useState({
    username: '',
    password: '',
    firstName: '',
    lastName: '',
    dob: '',
    gender: '',
    userType: userType === 'patient' ? 'P' : 'D'
  });
  const [signupSpecificData, setSpecificsignupUserData] = userType === 'patient' ? 
    useState({
      history: '',
      allergies: '',
      chronicConditions: ''
    })
    :
    useState({
      specialization: '',
      yoe: undefined,
      qualification: '',
      hospital: ''
    })
  const [mode, setMode] = useState('login'); // 'login' or 'signup'
  if (userType === '') {
    console.log("NO USER TYPE SPECIFIED: SHOWING DOCTOR SIGN UP")
  }

  const handleLoginChange = (e) => {
    const { name, value } = e.target;
    setLoginData((prevData) => ({ ...prevData, [name]: value }));
  };

  const handleGeneralSignupChange = (e) => {
    const { name, value } = e.target;
    setGeneralsignupUserData((prevData) => ({ ...prevData, [name]: value }));
  };

  const handleSpecificSignupChange = (e) => {
    const { name, value } = e.target;
    setSpecificsignupUserData((prevData) => ({ ...prevData, [name]: value }));
  };


  const handleModeChange = (newMode) => {
    setMode(newMode);
  };

  const handleLoginSubmit = (e) => {
    e.preventDefault();
    // Add login logic here
    console.log('Login data submitted:', loginData);
  };

  const handleSignupSubmit = async (e) => {
    e.preventDefault();
    // Add signup logic here
    // const res = await fetch('http://localhost:4000/posts', {
    //   method: 'POST',
    //   headers: {
    //     'Content-Type': 'application/json',
    //   },
    //   body: JSON.stringify({ title }),
    // });
    const result = {};
    result['user'] = signupUserData;
    result[userType === '' ? 'doctor' : userType] = signupSpecificData;
    console.log('Signup data submitted:', result);
  };

  return (
    <div>
      <form onSubmit={mode === 'login' ? handleLoginSubmit : handleSignupSubmit}>
        {mode === 'login' ? (
          <>
            <label>Username:</label>
            <input type="username" name="username" value={loginData.username} onChange={handleLoginChange} required />
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
          userType === 'patient' ? (
            <>
              {/* General */}
              <label>Username:</label>
              <input type="username" name="username" value={signupUserData.username} onChange={handleGeneralSignupChange} required />
              <label>Password:</label>
              <input type="password" name="password" value={signupUserData.password} onChange={handleGeneralSignupChange} required />
              <label>Confirm Password:</label>
              <input type="password" name="confirmPassword" value={signupUserData.confirmPassword} onChange={handleGeneralSignupChange} required />
              <label>First name:</label>
              <input type="text" name="firstName" value={signupUserData.firstName} onChange={handleGeneralSignupChange} required />
              <label>Last name:</label>
              <input type="text" name="lastName" value={signupUserData.lastName} onChange={handleGeneralSignupChange} required />
              
              {/* Date of birth is being buggy */}
              
              {/* <label>Data of birth:</label>
              <input type="text" name="dateOfBirth" value={signupUserData.dob} onChange={handleGeneralSignupChange} required /> */}
              
              <label>Gender:</label>
              <input type="text" name="gender" value={signupUserData.gender} onChange={handleGeneralSignupChange} required />
              {/* Patient things */}
              <label>History:</label>
              <input type="text" name="history" value={signupSpecificData.history} onChange={handleSpecificSignupChange} />
              <label>Allergies:</label>
              <input type="text" name="allergies" value={signupSpecificData.allergies} onChange={handleSpecificSignupChange} />
              <label>Chronic Condiction:</label>
              <input type="text" name="chronicConditions" value={signupSpecificData.chronicConditions} onChange={handleSpecificSignupChange} />
              {/* Submit button */}
              <button type="submit">Sign Up</button>
              <p>
                Already have an account?{' '}
                <span className="signup-link" onClick={() => handleModeChange('login')}>
                  Login
                </span>
              </p>
            </>
          ) : (
            <>
              {/* General user info */}
              <label>Username:</label>
              <input type="username" name="username" value={signupUserData.username} onChange={handleGeneralSignupChange} required />
              <label>Password:</label>
              <input type="password" name="password" value={signupUserData.password} onChange={handleGeneralSignupChange} required />
              <label>Confirm Password:</label>
              <input type="password" name="confirmPassword" value={signupUserData.confirmPassword} onChange={handleGeneralSignupChange} required />
              <label>First name:</label>
              <input type="text" name="firstName" value={signupUserData.firstName} onChange={handleGeneralSignupChange} required />
              <label>Last name:</label>
              <input type="text" name="lastName" value={signupUserData.lastName} onChange={handleGeneralSignupChange} required />
              <label>Data of birth:</label>
              <input type="date" name="dateofbirth" value={signupUserData.dob} onChange={handleGeneralSignupChange} required />
              <label>Gender:</label>
              <input type="text" name="gender" value={signupUserData.gender} onChange={handleGeneralSignupChange} required />
              {/* Doctor things */}
              <label>Specialization:</label>
              <input type="text" name="specialization" value={signupSpecificData.specialization} onChange={handleSpecificSignupChange} required />
              <label>Years of experience:</label>
              <input type="text" name="yoe" value={signupSpecificData.yoe} onChange={handleGeneralSignupChange} required />
              <label>Qualification:</label>
              <input type="text" name="qualification" value={signupSpecificData.qualification} onChange={handleGeneralSignupChange} required />
              <label>Hospital:</label>
              <input type="text" name="hospital" value={signupSpecificData.hospital} onChange={handleGeneralSignupChange} required />
              {/* BUtton */}
              <button type="submit">Sign Up</button>
              <p>
                Already have an account?{' '}
                <span className="signup-link" onClick={() => handleModeChange('login')}>
                  Login
                </span>
              </p>
            </>
          )
        )}
      </form>
    </div>
  );
};

export default LoginForm;