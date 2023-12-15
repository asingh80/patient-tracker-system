import React from 'react';
import { createRoot } from 'react-dom/client';
import App, { WelcomePage } from './App';

createRoot(document.getElementById('root')).render(
  <React.StrictMode>
    {/* <WelcomePage /> */}
    <App />
  </React.StrictMode>
);
