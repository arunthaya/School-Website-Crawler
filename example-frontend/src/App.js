import React, { Component } from 'react';
import Header from './container/Header';
import Main from './container/Main';
import './css/App.css';

class App extends Component {

  render() {
    return (
      <div className="App">
        <Header/>
        <Main />
      </div>
    );
  }
}

export default App;
