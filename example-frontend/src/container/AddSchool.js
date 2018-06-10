import React, { Component } from 'react';
import '../css/App.css';
import $ from "jquery";
import SchoolChecker from "./SchoolChecker";
import SchoolUrl from "./SchoolUrl";
import Loader from "./Loader";
import SchoolPageCrawled from "./SchoolPageCrawled";
import Searchbar from "./Searchbar";

function DisplayLoader(props){
    if(props.renderLoader == true){
        return <Loader onMount={props.onMount}/>;
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
            renderLoader: false,
            renderAboutUsPage: false,
            aboutUsPageData: " ",
            aboutUsPageTitle: " "
        };
        this.onUpdate = this.onUpdate.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
        this.parseSchoolPage = this.parseSchoolPage.bind(this);
    }

    onUpdate = (val) => {
        this.setState({
            value: val,
            websiteChecked: false
        })
    };

    onAboutSchoolUpdate = (val) => {
        this.setState({
            aboutUsPageData: val,
        })
    };

    parseSchoolPage(){
        console.log('HELLO PARSE SCHOOL PAGE REACHED');
        const self = this;
        $.ajax({
            type: "POST",
            url: "http://localhost:8080/urlToParse",
            data: {urlToParse: this.state.value},
            success: function(msg){
                let response = JSON.parse(msg);
                // console.log(`response from server is ${response}`);
                // console.log(`response from server stringified is ${response.toString()}`);
                let imageUrls;
                imageUrls = response.images;
                imageUrls = imageUrls.replace(/[\[\]']+/g,'');
                let tempTest = {};
                tempTest = imageUrls.toString();
                let individualImageUrls = tempTest.split(",");
                for(let i=0; i<individualImageUrls.length; i++){
                    let tempString3000 = JSON.parse(individualImageUrls[i]);
                    console.log(`tempString3000 url is ${tempString3000.url}`);
                    individualImageUrls[i] = JSON.parse(individualImageUrls[i]);
                    console.log(`individualImageUrl.url at ${i} is -> ${individualImageUrls[i].url}`);
                }
                // console.log(`imageUrls from server is ${imageUrls.toString()}`);
                console.log(`imageUrls from server without .toString() method is ${imageUrls}`);
                //console.log(`3rd element from images is ${imageUrls[2]}`);
                // let temp;
                // temp = JSON.parse(imageUrls);
                //console.log(`imageUrls json.parsed is ${temp}`)
                self.setState({
                    renderLoader: false,
                    renderAboutUsPage: true,
                    aboutUsPageData: response.aboutData,
                    aboutUsPageTitle: response.aboutTitle,
                });
            },
            error: function(XMLHttpRequest, textStatus, errorThrown){
                alert('error');
            }
        });
    }

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
                <DisplayLoader renderLoader={this.state.renderLoader} onMount={this.parseSchoolPage}/>
                <SchoolPageCrawled onUpdate={this.onAboutSchoolUpdate} titleOfPage={this.state.aboutUsPageTitle} aboutPageContent={this.state.aboutUsPageData}/>
            </div>
        );
    };
}

//TODO - ADD other functionality for other segments of the University Page, including pictures and text boxes for the person to edit
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