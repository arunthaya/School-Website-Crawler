import React, { Component } from 'react';
import '../css/App.css';
import Gallery from 'react-grid-gallery';

class SchoolAboutPage extends Component{
    constructor(props){
        super(props);
    }

    render(){
        return(
            <div id="about">
                <h1>{this.props.titleOfPage}</h1>
                {/*//<p>{this.props.aboutPageContent}</p>*/}
            </div>,
            <div>
                <h1>Images from {this.props.titleOfPage}</h1>
                <Gallery images={this.props.imagesToRender}/>
            </div>
        )
    }
}

export default SchoolAboutPage;
