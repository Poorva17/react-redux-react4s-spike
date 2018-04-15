import React, {Component} from 'react';
import Comment from './Comment';
import CommentForm from './CommentForm';


class CommentBox extends Component {

    constructor() {
        super();

        this.state = {
            showComments: false,
            commentList: []
        };

        this._getComments = this._getComments.bind(this);
        this._handleClick = this._handleClick.bind(this);
        this._alert = this._alert.bind(this);
        this._addComment = this._addComment.bind(this)
    }

    _getComments() {
        return this.state.commentList.map((comment) => {
            return <Comment author={comment.author} comment={comment.comment} alert={this._alert}/>
        })
    }

    _addComment(author, comment) {
        this.setState({
         commentList: this.state.commentList.concat([{author, comment}])})
    }


    _handleClick() {
        this.setState({
            showComments: !this.state.showComments
        })

    }

    _alert() {
        window.alert("Alert notified")
    }


    render() {
        let commentNodes;
        let buttonText = "Show Comments";
        const comments = this._getComments();
        if (this.state.showComments) {
            buttonText = "Hide Comments";
            commentNodes = <div className="comment-list">{comments}</div>
        }

        if(comments.length > 2) {
            this.props.notify()
        }

        return (
            <div className="comment-box">
                <h3>Comments</h3>
                < button onClick={this._handleClick}> {buttonText} </button>
                {commentNodes}
                <CommentForm add={this._addComment}/>
            </div>
        );
    }
}

export default CommentBox;