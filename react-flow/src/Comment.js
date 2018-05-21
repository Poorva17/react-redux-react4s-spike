// @flow

import * as React from 'react';
import {Component} from 'react';

type Props = {
  author: string,
  comment: string,
};

class Comment extends Component<Props> {
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