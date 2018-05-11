import React, {Component} from 'react';

class CommentForm extends Component {

    constructor() {
        super();
        this._handleSubmit = this._handleSubmit.bind(this);
        this._updateAuthor = this._updateAuthor.bind(this);
        this._updateComment = this._updateComment.bind(this);

        this.state = {
            author: "",
            comment: ""
        }

    }

    render() {
        return (
            <form className="comment-form" onSubmit={this._handleSubmit}>
                <input placeholder ="author" value={this.state.author} onChange={this._updateAuthor}/>
                <input placeholder="comment" value={this.state.comment} onChange={this._updateComment}/>
                <button type="submit">Post Comment</button>
            </form>
        );
    }

    _handleSubmit(event) {
        event.preventDefault();
        this.props.add(this.state.author, this.state.comment);
        this.setState({ author: "", comment: ""});
    }

    _updateAuthor(event) {
        this.setState({
            author : event.target.value
        })
    }

    _updateComment(event) {
        this.setState({
            comment : event.target.value
        })
    }
}

export default CommentForm;