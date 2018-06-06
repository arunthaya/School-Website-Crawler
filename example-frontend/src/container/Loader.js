import React, { Component} from 'react';
import '../css/App.css';
import $ from 'jquery';

class Loader extends Component {
    constructor(props){
        super(props);
    }

    componentDidMount(){
      this.props.onMount();
    }

    render() {
        return (
            <div>
                <p>Please wait while all relevant information is retrieved. This can take 5 mins.</p>,
                <img src="https://upload.wikimedia.org/wikipedia/commons/b/b1/Loading_icon.gif"/>
            </div>
        );
    }
}

export default Loader;
