import React, { Component } from 'react';
import '../css/App.css';

const About = () => (
    <div>
        <h1>Welcome!</h1>
        <p>This web application was developed in the hopes of automating crawling websites and adding data to a database.
        The steps to use this application are outlined before.</p>
        <ol>
            <li>Find school website</li>
            <li>Navigate to the Add School Page</li>
            <li>Paste website into the search bar</li>
            <li>Application does the rest! View the school by clicking search or view.</li>
        </ol>
    </div>
);

export default About;