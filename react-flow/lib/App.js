//      

import React, { Component } from 'react';
import './App.css';
import Comment from "./Comment";

class App extends Component     {
  render() {
    return (
      <div className="App">
        <Comment author="Author1" comment="Hello flow!!"/>
        <Comment author="Author2" comment="Hello flow!!"/>
      </div>
    );
  }
}

export default App;
