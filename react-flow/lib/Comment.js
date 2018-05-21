//      

import * as React from 'react';
import {Component} from 'react';

              
                 
                  
  

class Comment extends Component        {
    render() {
        return (
            <div className="comment">
                <p>Comment Author - {this.props.author}</p>
                <p>Comment - {this.props.comment}</p>
            </div>
        );
    }
}

export default Comment;