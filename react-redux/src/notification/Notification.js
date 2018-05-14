import React, {Component} from 'react';
import {connect} from 'react-redux';
import PropTypes from 'prop-types';

class Notification extends Component {

    constructor() {
        super();

        this._showNotification = this._showNotification.bind(this);
    }


    _showNotification() {
        if(this.props.noOfComments > 2) {
            return <h1>Too many Comments. Reduce those</h1>
        }
    }

    render() {
        return (
            <div className="notification">
                {
                    this._showNotification()
                }
            </div>
        );
    };


}

Notification.propTypes = {
  comments: PropTypes.array
};

const mapStateToProps = (store) => {
  return {
    noOfComments: store.comments.length
  };
};

export default connect(
  mapStateToProps
)(Notification);