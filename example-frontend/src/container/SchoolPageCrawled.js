import React, { Component } from 'react';
import '../css/App.css';
import '../css/SchoolPageCrawled.css';

class SchoolPageCrawled extends Component{
    constructor(props){
        super(props);
    }

    /* TODO - look into component life cycles
 componentDidMount(){
         //     this.setState({
         //         inputValue: this.props.aboutPageContent
         //     });
         // }
*/

    render(){
        return(
            <div id="about">
                <h1>{this.props.titleOfPage}</h1>
                <p>{this.props.aboutPageContent}</p>
            </div>
        );
    }

}

export default SchoolPageCrawled;