import React, { Component } from 'react';
import '../css/App.css';
import Select from 'react-select';
import 'react-select/dist/react-select.css';

class Searchbar extends Component {
    constructor(props){
        super(props);
        this.state ={
            selectedOption: '',
        }
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

    render() {
        const { selectedOption } = this.state;

        return (
            <div id="search">
                <form onSubmit={this.handleSubmit}>
                    <div className="nice-wrap">
                        <Select id="searchBarSelect"
                            name="form-field-name"
                            value={selectedOption}
                            onChange={this.handleChange}
                            options={[
                                { value: 'one', label: 'One' },
                                { value: 'two', label: 'Two' },
                            ]}/>
                        <input id="btn" type="submit" value="Submit" onClick={this.handleSubmit}/>
                    </div>
                </form>
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

