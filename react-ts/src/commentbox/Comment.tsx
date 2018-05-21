import * as React from 'react';
import { Component } from 'react';


interface IProps {
    author: string,
    comment: string
}

class Comment extends Component<IProps> {
    public render() {
        const {
            author,
            comment
        } = this.props;

        return (
            <div className="comment">
                <p>Comment Author - {author}</p>
                <p>Comment - {comment}</p>
            </div>
        );
    }
}

export default Comment;