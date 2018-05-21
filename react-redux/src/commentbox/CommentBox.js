import React, {Component} from 'react';
import Comment from './Comment';
import CommentForm from './CommentForm';
import {connect} from 'react-redux';
import PropTypes from 'prop-types';
import {addComment} from "../actions/CommentsActions";


class CommentBox extends Component {

  constructor() {
    super();

    this.state = {
      showComments: false,
    };

    this.getComments = this._getComments.bind(this);
    this.handleClick = this._handleClick.bind(this);
    this.addComment = this._addComment.bind(this)
  }

  _getComments = () => {
    return this.props.comments.map((comment, index) => {
      return <Comment author={comment.author} comment={comment.comment} key={index}/>
    })
  };

  _addComment = (author, comment) => {
    const newComment = {
      author: author,
      comment: comment
    };

    this.props.addComment(newComment);
  };

  _handleClick = () => {
    this.setState({
      showComments: !this.state.showComments
    })
  };

  render() {
    let commentNodes;
    let buttonText = "Show Comments";
    const comments = this._getComments();
    if (this.state.showComments) {
      buttonText = "Hide Comments";
      commentNodes = <div className="comment-list">{comments}</div>
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

CommentBox.propTypes = {
  comments: PropTypes.array
};

const mapStateToProps = (store) => {
  return {
    comments: store.comments
  };
};

const mapDispatchToProps = dispatch => {
  return {
    addComment: (comment) => {
      dispatch(addComment(comment));
    }
  }
};

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(CommentBox);