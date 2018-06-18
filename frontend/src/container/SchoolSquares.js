import React, { Component } from 'react';
import '../css/App.css';
var list;

// function RenderSquare(){
//     return(
//         <p>Testing 123</p>
//     );
// }
//
// class SchoolSquares extends Component{
//     constructor(props){
//         super(props);
//         this.list = [];
//     }
//
//     componentDidMount(){
//         const renderSquares = this.props.numberOfSquares;
//         for(let i=0; i<renderSquares; i++){
//             this.list.push(<RenderSquare/>);
//         }
//     }
//
//     renderSquares(i){
//         let numberOfSquares = i;
//         return <RenderSquare/>
//     }
//
//     render(){
//         const squaresNumber = this.props.numberOfSquares;
//         return(
//             <div>
//                 {list}
//             </div>
//         )
//     }
// };

class Card extends React.Component {
    constructor(props){
        super(props);
        this.clickHandler = this.clickHandler.bind(this);
    }

    clickHandler(e){
        this.props.onClick(e);
    }


    render() {
        return (
            <div class="card">
                <h1>{ this.props.value }</h1>
                <button onClick={(e)=>this.clickHandler(this.props.value)}>Learn More!</button>
            </div>
        );
    }
}

class SchoolSquares extends React.Component {
    constructor(props){
        super(props);
        this.handleClick = this.handleClick.bind(this);
    }

    handleClick(index){
        console.log(`hello : ${index}`);
        this.props.onClick(index);
    }

    render() {
        var arr=this.props.val;
        var elements=[];
        for(var i=0;i<arr.length;i++){
            // push the component to elements!
            elements.push(<Card key={i} value={ arr[i]} onClick={this.handleClick}/>);
        }
        /* the for loop above is essentially the same as
        elements = arr.map( item => <Card value={ item } /> );
        The result is an array of four Card components. */
        return (
            <div>
                {elements}
            </div>
        );
    }
}


export default SchoolSquares;