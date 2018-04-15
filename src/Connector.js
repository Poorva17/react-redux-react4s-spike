import React, {Component} from 'react';
import CommentBox from "./commentbox/CommentBox";
import Notification from "./notification/Notification";

class Connector extends Component {
    constructor() {
        super();
        this.state = {
            alert: false
        };

        this.notify = this.notify.bind(this)

    }
    render() {
        return (
            <div className="Connector">
                <CommentBox notify={this.notify}/>
                <Notification alert={this.state.alert}/>
            </div>
        );
    }

    notify() {
      this.setState({alert: true})
    }
}

export default Connector;