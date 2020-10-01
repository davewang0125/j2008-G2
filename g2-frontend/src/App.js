import React from 'react';
import Login from './Login';
import Main from './Main';
import { BrowserRouter, Route } from 'react-router-dom';

function App() {
  return (
    <BrowserRouter>
        <Route path="/" exact component={Login}></Route>
        <Route path="/login" component={Login}></Route>
        <Route path="/main" component={Main}></Route>
    </BrowserRouter>
  );
}

export default App;
