This project is a example demo app implemented in react, reac4s, react-redux app

# 1. React implementation -

This project was bootstrapped with [Create React App](https://github.com/facebookincubator/create-react-app).

Below you will find some information on how to perform common tasks.<br>
You can find the most recent version of this guide [here](https://github.com/facebookincubator/create-react-app/blob/master/packages/react-scripts/template/README.md).

## Table of Contents

- [Folder Structure](#folder-structure)
- [Available Scripts](#available-scripts)
  - [npm start](#npm-start)
  - [npm test](#npm-test)
  - [npm run build](#npm-run-build)
  

## Folder Structure

```
react-redux-react4s-spike/
  README.md
  react/
    node_modules/
    package.json
    public/
       index.html
       favicon.ico
    src/
      App.css
      App.js
      App.test.js
      index.css
      index.js
      logo.svg
      commentBox/
      notification/
```

For the project to build, **these files must exist with exact filenames**:

* `public/index.html` is the page template;
* `src/index.js` is the JavaScript entry point.

You can delete or rename the other files.

You may create subdirectories inside `src`. For faster rebuilds, only files inside `src` are processed by Webpack.<br>
You need to **put any JS and CSS files inside `src`**, otherwise Webpack won’t see them.

Only files inside `public` can be used from `public/index.html`.<br>
Read instructions below for using assets from JavaScript and HTML.

You can, however, create more top-level directories.<br>
They will not be included in the production build so you can use them for things like documentation.

## Available Scripts

In the project directory, you can run:

### `npm start`

Runs the app in the development mode.<br>
Open [http://localhost:3000](http://localhost:3000) to view it in the browser.

The page will reload if you make edits.<br>
You will also see any lint errors in the console.

### `npm test`

Launches the test runner in the interactive watch mode.<br>
See the section about [running tests](#running-tests) for more information.

# 2. Work for react4s - 

This project is implemented using reference examples provided [react4s-samples](https://github.com/Ahnfelt/react4s-samples)

- [Project Structure](#project-structure)
- [Available sbt tasks](#available-sbt-tasks)
  - [npm start](#npm-start)
  - [npm test](#npm-test)
  - [npm run build](#npm-run-build)
  
##Project Structure

```
react-redux-react4s-spike/
  README.md
  react4s/
    project/
    target/
    src/
      main/
        scala/
            samples/
               commentListExample/
    build.sbt
    index.html
     etc 
```

##Available sbt tasks

### sbt test:compile
Compile project in test mode

###sbt fastOptJS
Produce JavaScript file from your code.
This will perform fast Scala.js-specific optimizations and write the resulting code to a single JavaScript file. 
This JavaScript file is used in index.html. Open index.html from browser and play with running commentBox example 

# 3. Work for react-redux - in progress