import React from 'react';
import { Button, DropdownButton, Dropdown } from 'react-bootstrap';
import { addAudio } from './utils';
import MicRecorder from 'mic-recorder-to-mp3';
import { AiOutlineToTop } from 'react-icons/ai';

const Mp3Recorder = new MicRecorder({ bitRate: 128 });

class Main extends React.Component {
    constructor(props) {
        super(props);
        this.state = { audioList: [{ time: "00:00:01", content: "我是一个粉刷匠, 粉刷本领强" }], isRecording: false, blob: "", file: "", buttonText: "Language" }
    }

    startRecording = () => {
        Mp3Recorder
            .start()
            .then(() => {
                this.setState({ isRecording: true });
            }).catch((e) => console.error(e));
    }


    stopRecording = () => {
        Mp3Recorder
            .stop()
            .getMp3()
            .then(([buffer, blob]) => {
                let file = new File([blob], `${Date.now()}.mp3`, {
                    type: blob.type,
                    lastModified: Date.now()
                });
                addAudio(file).then(res => {
                    this.setState({ isRecording: false });
                    console.log(res);
                })
            }).catch((e) => console.log(e));
    }

    handleUpload = e => {
        e.preventDefault();
        addAudio(this.state.file).then(res => {
            console.log("upload success");
        });
    }

    handleInput = e => {
        this.setState({ file: e.target.files[0] });
    }

    render() {

        return <div>
            <div className="sign-out-info">
                <div className="main-username">davewang@gmail.com</div>
                <div className="sign-out-bt"><Button variant="primary">Sign out</Button></div>
            </div>
            <div className="main-audio-list">
                <div className="bt-container">
                    <label htmlFor="upload-button"><AiOutlineToTop className="main-icon" /></label>
                    <input type="file" style={{ display: "none" }} onChange={this.handleInput} id="upload-button" />
                    <Button variant="outline-primary" onClick={this.handleUpload}>Upload</Button>
                    <Button variant="outline-secondary" onClick={this.startRecording}>Start Record</Button>
                    <Button variant="outline-success" onClick={this.stopRecording}>End Record</Button>
                    <DropdownButton id="dropdown-basic-button" title={this.state.buttonText}>
                        <Dropdown.Item onClick={() => this.setState({buttonText: "Chinese"})}>Chinese</Dropdown.Item>
                        <Dropdown.Item onClick={() => this.setState({buttonText: "English"})}>English</Dropdown.Item>
                        <Dropdown.Item onClick={() => this.setState({buttonText: "Japanese"})}>Japanese</Dropdown.Item>
                        <Dropdown.Item onClick={() => this.setState({buttonText: "Italian"})}>Italian</Dropdown.Item>
                    </DropdownButton>
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