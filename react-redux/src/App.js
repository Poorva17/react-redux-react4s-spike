import React, {Component} from 'react';
import './App.css';
import CommentBox from "./commentbox/CommentBox";
import Notification from "./notification/Notification";

class App extends Component {
  render() {
    return (
        <div>
          <CommentBox/>
          <Notification/>
        </div>
    );
  }
}

export default App;
