import React from 'react';
import { Form, Button } from "react-bootstrap";
import { FacebookLoginButton, GithubLoginButton, GoogleLoginButton } from 'react-social-login-buttons';
import {Link} from 'react-router-dom';

class Login extends React.Component {
    constructor(props) {
        super(props);
        this.state = { email: "", password: "" };
    }

    setEmail = e => {
        this.setState({ email: e.target.value });
    }

    setPassword = e => {
        this.setState({ password: e.target.value });
    }

    validateForm = () => {
        const { email, password } = this.state;
        return email.length > 0 && password.length > 0;
    }

    handleSubmit = () => {
        console.log("login success");
    }

    render() {
        return (
            <Form className="login-form">
                <Form.Group controlId="formBasicEmail">
                    <Form.Label>Email address</Form.Label>
                    <Form.Control type="email" placeholder="Enter email" />
                    <Form.Text className="text-muted">
                        We'll never share your email with anyone else.
                    </Form.Text>
                </Form.Group>

                <Form.Group controlId="formBasicPassword">
                    <Form.Label>Password</Form.Label>
                    <Form.Control type="password" placeholder="Password" />
                </Form.Group>
                <Form.Group controlId="formBasicCheckbox">
                    <a href="http://www.google.com">sign up</a>
                </Form.Group>
                <Form.Group>
                    <Link to="/main">
                        <GoogleLoginButton onClick={() => { console.log("login from goole") }} />
                    </Link>
                </Form.Group>
                <Form.Group className="facebook-button">
                <Link to="/main">
                    <FacebookLoginButton onClick={() => console.log("Facebook login")} />
                    </Link>
                </Form.Group>
                <Form.Group>
                <Link to="/main">
                    <GithubLoginButton onClick={() => console.log("Github login")} />
                    </Link>
                </Form.Group>
                <Button variant="primary" type="submit">
                    Submit
                </Button>

            </Form>
        );
    }
}

export default Login;