import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';

class App extends Component {

  constructor(props) {
      super(props);
      this.state = {
          users: [],
          isLoading: false
      }
  }

  render() {
    return (
      <div className="App">
        <header className="App-header">
          <img src={logo} className="App-logo" alt="logo" />
          <h1 className="App-title">Welcome to React</h1>
        </header>
        <p className="App-intro">
            My name is Clark Murray
        </p>
      </div>
    );
  }

  componentDidMount() {
      this.setState({isLoading: true});

      fetch('http://localhost:8080/users')
          .then(response => response.json())
          .then(data => this.setState({users: data, isLoading: false}))
          .then(console.log(this.state.users));

  }

}

export default App;
