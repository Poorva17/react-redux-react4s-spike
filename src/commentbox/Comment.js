import React, {Component} from 'react';

class Comment extends Component {
    render() {
        const {
            author,
            comment
        } = this.props;

        return (
            <div className="comment">
                <p>Comment Author - {author}</p>
                <p>Comment - {comment}</p>
                {
                    author === "Poorva" &&
                    window.alert("Important Comment")
                }
            </div>
        );
    }
}

export default Comment;