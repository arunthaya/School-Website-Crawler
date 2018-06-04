import React, { Component } from 'react';
import '../css/App.css';
import $ from 'jquery';

class SchoolUrl extends Component{
    constructor(props){
        super(props);
        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleChange(e){
        console.log(`handlechange event occured + ${e.target.value}`);
        this.props.onUpdate(e.target.value);
    }

    handleSubmit(event){
        this.props.handleSubmit(event);
    }

    render(){
        return(<div className="Main">
            <header className="App-header">
                <h1 className="App-title">School Page Parser</h1>
                <form onSubmit={this.handleSubmit}>
                    <div className="nice-wrap">
                        <input className="nice-textbox" type="text" placeholder="School website" onChange={this.handleChange}/>
                        <input id="btn" type="submit" value="Submit" onClick={this.handleSubmit}/>
                    </div>
                </form>
            </header>
            <div className="App-intro">
            </div>
        </div>);
    }
}


export default SchoolUrl;
