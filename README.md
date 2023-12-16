# patient-tracker-system

# Setting up the database locally

1. Install PostgreSQL: https://www.postgresql.org/download/
2. During installation, set the superuser to 'postgres' and the password to 'postgres' as well.
3. Open the psql shell. Log in as 'postgres'. 
4. Enter the following into the shell:  CREATE DATABASE patient_tracker;
5. Enter the following into the shell:  \c patient_tracker;

Now, the database is set up locally and ready to use.

# Running the front-end

In the project directory, you can run:

### `npm start`

Runs the app in the development mode.\
Open [http://localhost:3000](http://localhost:3000) to view it in your browser.

The page will reload when you make changes.\
You may also see any lint errors in the console.

### `npm test`

Launches the test runner in the interactive watch mode.\
See the section about [running tests](https://facebook.github.io/create-react-app/docs/running-tests) for more information.

### `npm run build`

Builds the app for production to the `build` folder.\
It correctly bundles React in production mode and optimizes the build for the best performance.

The build is minified and the filenames include the hashes.\
Your app is ready to be deployed!

See the section about [deployment](https://facebook.github.io/create-react-app/docs/deployment) for more information.

# Running the tests

The tests can be run using 'mvn clean verify'. The coverage report is found here: target > site > jacoco > index.html. 