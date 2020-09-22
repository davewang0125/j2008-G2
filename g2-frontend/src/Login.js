import React from 'react';
import { Form, Button } from "react-bootstrap";
import { FacebookLoginButton, GithubLoginButton, GoogleLoginButton } from 'react-social-login-buttons';


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
                    <GoogleLoginButton onClick={() => { console.log('Google button clicked') }} />
                </Form.Group>
                <Form.Group className="facebook-button">
                    <FacebookLoginButton onClick={() => console.log("Facebook login")} />
                </Form.Group>
                <Form.Group>
                    <GithubLoginButton onClick={() => alert("Hello")} />
                </Form.Group>
                <Button variant="primary" type="submit">
                    Submit
                </Button>

            </Form>
        );
    }
}

export default Login;