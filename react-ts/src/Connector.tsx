import * as React from 'react'
import {Component} from 'react';
import CommentBox from "./commentbox/CommentBox";
import Notification from "./notification/Notification";

interface IState {
    noOfComments: number
}


class Connector extends Component<{}, IState> {
    constructor(props: {}) {
        super(props);
        this.state = this.getInitialState();

        this.updateNoOfComments = this.updateNoOfComments.bind(this)

    }
    public render() {
        return (
            <div className="Connector">
                <CommentBox updateNoOfComments={this.updateNoOfComments}/>
                <Notification noOfComments={this.state.noOfComments}/>
            </div>
        );
    }

    public updateNoOfComments = (commetsNumber: number): void => {
        this.setState({noOfComments: commetsNumber})
    };

    private getInitialState = (): IState => {
      return {noOfComments: 0}
    };
}

export default Connector;