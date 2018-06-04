import React, { Component } from 'react';
import '../css/App.css';
import Tester from "./Tester";
import SchoolChecker from "./SchoolChecker";

class AddSchool extends Component{
    constructor(props){
        super(props);
        this.state ={
            schoolChecked: false,
            value: [],
        };
    }

    render(){
        <Tester/>,
        <SchoolChecker/>
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