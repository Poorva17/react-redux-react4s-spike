import React, {Component} from 'react';

class Notification extends Component {
    render() {
        return (
            <div className="notification">
                {
                    this.props.noOfComments > 5 &&
                   window.alert("Alert - More than 5 comments!!!")
                }
            </div>
        );
    }
}

export default Notification;