import * as React from 'react';
import { Component } from 'react';

interface IState {
    author: string
    comment: string
}


interface IProps {
    add: (author: string, comment: string) => void
}

class CommentForm extends Component<IProps, IState> {

    constructor(props: IProps) {
        super(props);
        this.handleSubmit = this.handleSubmit.bind(this);
        this.updateAuthor = this.updateAuthor.bind(this);
        this.updateComment = this.updateComment.bind(this);

        this.state = this.getInitialState();
    }

    public render() {
        return (
            <form className="comment-form" onSubmit={this.handleSubmit}>
                <input placeholder ="author" value={this.state.author} onChange={this.updateAuthor}/>
                <input placeholder="comment" value={this.state.comment} onChange={this.updateComment}/>
                <button type="submit">Post Comment</button>
            </form>
        );
    }

    private getInitialState: () => IState = () => {
      return {author: "", comment: ""}
    };

    private handleSubmit = (event: React.FormEvent<HTMLElement>) => {
        event.preventDefault();
        this.props.add(this.state.author, this.state.comment);
        this.setState(this.getInitialState());
    };

    private updateAuthor = (event: React.ChangeEvent<HTMLInputElement>) => {
        this.setState({
            author : event.target.value
        })
    };

    private updateComment = (event: React.ChangeEvent<HTMLInputElement>) => {
        this.setState({
            comment : event.target.value
        })
    };
}

export default CommentForm;