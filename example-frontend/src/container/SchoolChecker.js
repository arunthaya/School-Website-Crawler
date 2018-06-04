import React, { Component } from 'react';
import '../css/App.css';

function WebsiteChecked(props){
    console.log(props.checked);
    return null;
}

const SchoolChecker = (props) => {
    return <WebsiteChecked checked={props.hasWebsiteBeenChecked}/>
};

export default SchoolChecker;