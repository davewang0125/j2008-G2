import React from 'react';
import { Button } from 'react-bootstrap';

class Main extends React.Component {
    constructor(props) {
        super(props);
        this.state={audioList: [{time: "00:00:01", content: "我是一个粉刷匠, 粉刷本领强"}]}
    }

    render() {
        return <div>
            <div className="sign-out-info">
                <div className="main-username">davewang@gmail.com</div>
                <div className="sign-out-bt"><Button variant="primary">Sign out</Button></div>
            </div>
            <div className="main-audio-list">
                <div className="bt-container">
                <Button variant="outline-primary">Upload</Button>
                <Button variant="outline-secondary">Start Record</Button>
                <Button variant="outline-success">End Record</Button>
                <Button variant="outline-warning">Language</Button>
                </div>
                {
                    this.state.audioList.map(audio => {
                        return <div className="translation-container" key={audio.time}>
                            <div className="translation-time">{audio.time}</div>
                            <div>{audio.content}</div>
                        </div>
                    })
                }
            </div>

        </div>
    }
}

export default Main;