import React, { Component } from 'react';
import '../css/App.css';
import $ from "jquery";
import SchoolChecker from "./SchoolChecker";
import SchoolUrl from "./SchoolUrl";
import Loader from "./Loader";

function DisplayLoader(props){
    if(props.renderLoader == true){
        return <Loader />;
    }
    else {
        return null;
    }
}

function DisplaySchool(props){
    const websiteChecked = props.websiteChecked;
    const validSchoolUrl = props.validSchoolUrl;
    if(websiteChecked){
        if(validSchoolUrl == true){
            return <SchoolChecker message={'Valid school url entered'}/>;
        }else {
            return <SchoolChecker message={'Invalid school url entered, please try again.'}/>;
        }
    }
    return null;
}

class AddSchool extends Component{
    constructor(props){
        super(props);
        this.state ={
            websiteChecked: false,
            schoolChecked: false,
            value: [],
            validSchoolUrl: false,
            renderLoader: false
        };
        this.onUpdate = this.onUpdate.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    onUpdate = (val) => {
        this.setState({
            value: val,
            websiteChecked: false
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
                console.log(`incoming message is ${msg}`);
                if(msg.toString() == "true"){
                    setTimeout(() => {
                        self.setState({
                            websiteChecked: false,
                            renderLoader: true
                        })
                    }, 4000);
                }
                self.setState({
                    websiteChecked: true,
                    validSchoolUrl: msg,
                });
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
                <DisplaySchool websiteChecked={this.state.websiteChecked} validSchoolUrl={this.state.validSchoolUrl}/>
                <DisplayLoader renderLoader={this.state.renderLoader}/>
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