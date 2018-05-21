import * as React from 'react';
import { Component } from 'react';


interface IProps {
    noOfComments: number
}

class Notification extends Component<IProps> {

    constructor(props: IProps) {
        super(props);

        this.showNotification = this.showNotification.bind(this);
    }


    public render() {
        return (
            <div className="notification">
                {
                    this.showNotification()
                }
            </div>
        );
    };

    private showNotification = (): JSX.Element => {
        if(this.props.noOfComments > 2) {
            return <h1>Too many Comments. Reduce those</h1>
        } else {
            return <h1/>
        }
    };
}

export default Notification;