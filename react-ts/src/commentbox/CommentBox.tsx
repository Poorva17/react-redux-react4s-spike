import * as React from 'react';
import { Component } from 'react';
import Comment from './Comment';
import CommentForm from './CommentForm';

interface ICommentModel {
    author: string
    comment: string
}

interface IState {
    comments: ICommentModel[]
    showComments: boolean
}

interface IProps {
    updateNoOfComments: (noOfComments: number) => void
}

class CommentBox extends Component<IProps, IState> {

    constructor(props: IProps) {
        super(props);

        this.state = this.getInitialState();

        this.getComments = this.getComments.bind(this);
        this.handleClick = this.handleClick.bind(this);
        this.addComment = this.addComment.bind(this)
    }

    public render() {
        let commentNodes;
        let buttonText = "Show Comments";
        const comments = this.getComments();
        if (this.state.showComments) {
            buttonText = "Hide Comments";
            commentNodes = <div className="comment-list">{comments}</div>
        }

        return (
            <div className="comment-box">
                <h3>Comments</h3>
                < button onClick={this.handleClick}> {buttonText} </button>
                {commentNodes}
                <CommentForm add={this.addComment}/>
            </div>
        );
    }

    private getInitialState = () => {
      return {
          comments: [],
          showComments: false
      }
    };

    private getComments = (): any => {
        return this.state.comments.map((newComment, index) => {
            return <Comment author={newComment.author} comment={newComment.comment} key={index}/>
        });



    };

    private addComment = (author: string, comment: string): void => {
        this.setState({
         comments: this.state.comments.concat([{author, comment}])});
        this.props.updateNoOfComments(this.state.comments.length + 1)
    };

    private handleClick = (): void => {
        this.setState({
            showComments: !this.state.showComments
        })
    };
}

export default CommentBox;