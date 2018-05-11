import React, {Component} from 'react';
import CommentBox from "./commentbox/CommentBox";
import Notification from "./notification/Notification";

class Connector extends Component {
    constructor() {
        super();
        this.state = {
            noOfComments: 0
        };

        this.updateNoOfComments = this.updateNoOfComments.bind(this)

    }
    render() {
        return (
            <div className="Connector">
                <CommentBox updateNoOfComments={this.updateNoOfComments}/>
                <Notification noOfComments={this.state.noOfComments}/>
            </div>
        );
    }

    updateNoOfComments(commetsNumber) {
      this.setState({noOfComments: commetsNumber})
    }
}

export default Connector;