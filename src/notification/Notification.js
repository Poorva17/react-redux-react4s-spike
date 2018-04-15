import React, {Component} from 'react';

class Notification extends Component {
    render() {
        return (
            <div className="notification">
                {
                    this.props.alert &&
                        window.alert("Too many comments")
                }
            </div>
        );
    }
}

export default Notification;