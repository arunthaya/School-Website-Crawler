import React, { Component } from 'react';
import '../css/App.css';
import $ from 'jquery';

class Tester extends Component {

  constructor(props) {
    super(props);
    this.state = {
        value: [],
        websiteChecked: false,
    };
    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  handleChange(event){
    console.log("A handl event ");
    this.setState({value: event.target.value});
    console.log(`The resulting value is ${this.state.value}`)
  }

  handleSubmit(event){
      const self = this;
      if(this.state.value == null){
          alert("Please enter something valid");
          return;
      }
      $.ajax({
          type: "POST",
          url: "http://localhost:8080/urlsubmitted",
          data: {suggest: this.state.value},
          success: function(msg){
              self.setState({websiteChecked: true});
          },
          error: function(XMLHttpRequest, textStatus, errorThrown){
              alert(`There was an error processing request: ${errorThrown}`);
          }
      });
      event.preventDefault();
  }

  render() {
    return (
      <div className="Main">
        <header className="App-header">
          <h1 className="App-title">School Page Parser</h1>
            <form onSubmit={this.handleSubmit}>
              <div className="nice-wrap">
                  <input className="nice-textbox" type="text" placeholder="School website" value={this.state.value} onChange={this.handleChange}/>
                  <input id="btn" type="submit" value="Submit" onClick={this.handleSubmit}/>
              </div>
            </form>
        </header>
        <div className="App-intro">
        </div>
      </div>
    );
  }
}

export default Tester;
