import React, { Component } from 'react';
import '../css/App.css';
import '../css/SchoolPageCrawled.css';

class SchoolPageCrawled extends Component{
    constructor(props){
        super(props);
        this.state = {
            inputValue: props.aboutPageContent
        };
        this.handleChange = this.handleChange.bind(this);
    }

    /* TODO - look into component life cycles
 componentDidMount(){
         //     this.setState({
         //         inputValue: this.props.aboutPageContent
         //     });
         // }
*/

    handleChange(e){
        this.props.onUpdate(e.target.value);
    }

    render(){
        return(
            <div id="about">
                <h1>{}</h1>
                <p>{this.props.aboutPageContent}</p>
                <input value={this.state.inputValue} onChange={this.handleChange}></input>
            </div>
        );
    }

}

export default SchoolPageCrawled;