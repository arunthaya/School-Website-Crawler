import React, { Component } from 'react';
import '../css/App.css';
import $ from 'jquery';
import SchoolSquares from "./SchoolSquares";
import SchoolAboutPage from "./SchoolAboutPage";

function RenderIndividualSchool(props){
    if(props.renderIndividualSchool){
        return <SchoolAboutPage titleOfPage={props.titleOfPage} imagesToRender={props.imagesToRender}/>
    }
    return null;
}

function RenderSchoolSquares(props){
    if(props.renderSquares)
        return<SchoolSquares numberOfSquares={props.numberOfSquares} val={props.val} onClick={props.onClick}/>
    return null;
}

class Searchbar extends Component {
    constructor(props){
        super(props);
        this.state ={
            selectedOption: '',
            val: [],
            renderSquares: false,
            numberSquares: 0,
            renderIndividualSchool: false,
            importantInfo: []
        }
        this.cardHandleClick = this.cardHandleClick.bind(this);
    }

    componentWillMount(){
        const self = this;
        $.ajax({
            type: "GET",
            url: "http://localhost:8080/school_list",
            success: function(msg){
                console.log(JSON.parse(msg));
                let tempArray = JSON.parse(msg);
                let imagesArray = [];
                for(let i in tempArray){
                    tempArray[i].images = JSON.parse(tempArray[i].images);
                    tempArray[i].images = tempArray[i].images.substr(1, tempArray[i].images.length - 1);
                    console.log(tempArray[i].images);
                    imagesArray.push(tempArray[i].aboutTitle);
                }
                let tester3000 = tempArray[0].aboutTitle;
                self.setState({
                    val: imagesArray,
                    renderSquares: true,
                    numberSquares: tempArray.length,
                    importantInfo: msg,
                });
            },
            error: function(error){
                alert(error);
            }
        });
    }

    handleChange = (selectedOption) => {
        this.setState({ selectedOption });
        // selectedOption can be null when the `x` (close) button is clicked
        if (selectedOption) {
            console.log(`Selected: ${selectedOption.label}`);
        }
    }

    handleSubmit(e){
        console.log('hello');
    }

    cardHandleClick(e){
        const selfCard = this;
        console.log(`hello from thhe searchbar ${e}`);
        console.log(`tempArr is ${selfCard.state.importantInfo}`);
        let msg = selfCard.state.importantInfo;
        let tempArray = JSON.parse(msg);
        console.log(tempArray);
        console.log(selfCard.state.val);
        console.log(`type of object ${typeof selfCard.state.val} + length ${selfCard.state.val.length}`);
        let imagesArray;
        let imagesToRenderTemp = [];
        for(let i in tempArray) {
            console.log(`e is ${e} , tempArray.title at ${i} is ${tempArray[i].aboutTitle}`);
            if(e.localeCompare(tempArray[i].aboutTitle)) {
                tempArray[i].images = JSON.parse(tempArray[i].images);
                tempArray[i].images = tempArray[i].images.substr(1, tempArray[i].images.length - 1);
                imagesArray = tempArray[i].images;
                console.log(`type of object for imagesArray is ${typeof imagesArray}`);
                let tempString = imagesArray.split(",");
                console.log(`tempString's length is ${tempString.length}`);
                console.log(`imagesArray is ${tempString}`);
                let urlArray = [];
                for(let j in tempString){
                    urlArray[i] = JSON.parse(tempString[i]);
                    console.log(urlArray[i]);
                    console.log(`parsed is ${JSON.parse(tempString[i])}`);
                    let tempJSObject = {};
                    tempJSObject.src = urlArray[i].url;
                    tempJSObject.thumbnail = urlArray[i].url;
                    tempJSObject.thumbnailWidth = 150;
                    tempJSObject.thumbnailHeight = 150;
                    imagesToRenderTemp.push(tempJSObject);
                }
            }
        }
        selfCard.setState({
            selectedOption: e,
            renderSquares: false,
            renderIndividualSchool: true,
            imagesToRender: imagesToRenderTemp,
        });
    }

    render() {
        const { selectedOption } = this.state;

        return (
            <div className="Main">
                <header className="App-header">
                    <h1>Find A School</h1>
                    <p>These are schools that you have added to the database.</p>
                    {/*<div id="search">*/}
                        {/*<form onSubmit={this.handleSubmit}>*/}
                            {/*<div className="nice-wrap">*/}
                                {/*<Select id="searchBarSelect"*/}
                                    {/*name="form-field-name"*/}
                                    {/*value={selectedOption}*/}
                                    {/*onChange={this.handleChange}*/}
                                    {/*options={[*/}
                                        {/*{ value: 'one', label: 'One' },*/}
                                        {/*{ value: 'two', label: 'Two' },*/}
                                    {/*]}/>*/}
                                {/*<input id="btn" type="submit" value="Submit" onClick={this.handleSubmit}/>*/}
                            {/*</div>*/}
                        {/*</form>*/}
                    {/*</div>*/}
                </header>
                <div class="restOfApp">
                    <RenderSchoolSquares
                        renderSquares={this.state.renderSquares}
                        numberOfSquares={this.state.numberSquares}
                        val={this.state.val}
                        onClick={this.cardHandleClick}
                    />
                    <RenderIndividualSchool
                        titleOfPage={this.state.selectedOption}
                        imagesToRender={this.state.imagesToRender}
                        renderIndividualSchool={this.state.renderIndividualSchool}
                    />
                </div>
            </div>
        );
    }
}



/*
class Searchbar extends React.Component {
    constructor() {
        super();
        this.state = {
            value: '',
            suggestions: []
        };
    }

    render() {
        return (
            <p>Hello!</p>
        );
    }
}
*/
export default Searchbar;

