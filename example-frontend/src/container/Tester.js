import React, { Component } from 'react';
import '../css/App.css';
import axios from 'axios';
import $ from 'jquery';

class Tester extends Component {

  constructor(props) {
    super(props);
    this.state = {
      ponged: 'Not Ponged',
      value: [],
    };
    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
    this.ping = this.ping.bind(this);
  }

  handleChange(event){
    console.log("A handl vnt ");
    this.setState({value: event.target.value});
    console.log(`The resulting value is ${this.state.value}`)
  }

  handleSubmit(event){
    //alert(`The resulting value is ${this.state.value}`);
    // axios.post('http://localhost:8080/urlsubmitted',{
    //   data: 'hello everyone',
    // }).then(function (response){
    //   console.log(response);
    // });
      $.post(
          "http://localhost:8080/urlsubmitted",
          {suggest: this.state.value},
          function(data, status){
            alert(`Data is ${data}, status is ${status}`);
          }
      );
      event.preventDefault();
  }

  ping() {
    axios.get("http://localhost:8080/pong").then(res => {
      alert("Received Successful response from server!" + this.state.value);
      this.setState({ponged: 'Ponged! '});
    }, err => {
      alert("Server rejected response with: " + err);
    });
  }

  render() {
    return (
      <div className="Main">
        <header className="App-header">
          <h1 className="App-title">School Page Parser</h1>
            <form onSubmit={this.handleSubmit}>
              <div className="nice-wrap">
                  <input className="nice-textbox" type="text" placeholder="School website" value={this.state.value} onChange={this.handleChange}/>
                  <input type="submit" value="Submit"/>
              </div>
            </form>
        </header>
        <p className="App-intro">
          {/*<div>*/}
            {/*<button onClick={this.ping}>Ping!</button>*/}
            {/*<div>Ponged: {this.state.ponged}</div>*/}
          {/*</div>*/}
        </p>
      </div>
    );
  }
}

export default Tester;
