import React, { Component } from 'react';
import '../css/App.css';
import $ from "jquery";
import SchoolChecker from "./SchoolChecker";
import SchoolUrl from "./SchoolUrl";

class AddSchool extends Component{
    constructor(props){
        super(props);
        this.state ={
            websiteChecked: false,
            schoolChecked: false,
            value: [],
        };
        this.onUpdate = this.onUpdate.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    onUpdate = (val) => {
        this.setState({
            value: val
        })
    };

    handleSubmit(event){
        console.log('submit button pressed');
        const self = this;
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

    render(){
        return(
            <div>
                <SchoolUrl onUpdate={this.onUpdate} handleSubmit={this.handleSubmit}/>
                <SchoolChecker hasWebsiteBeenChecked={this.state.websiteChecked}/>
            </div>
        );
    };
}

//add modal dialogue that will open up upon submission from tester, start off with the loading icon, then show the dialog, once they close it will run something else
//send all information up from tester back up to add school
//this will turn on school checker as needed
/*
- add the png logo applyboard
- make the nav bar look like applyboard
- show the preview of the page
- ask the user to select images in one section


asdfasdf
 */
export default AddSchool;