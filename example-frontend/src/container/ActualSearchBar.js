import React, { Component } from 'react';
import '../css/App.css';
import Autosuggest from 'react-autosuggest';
import '../css/Search.css';

class ActualSearchBar extends React.Component {
    constructor() {
        super();
        this.onChange = this.onChange.bind(this);
        this.onSuggestionsFetchRequested = this.onSuggestionsFetchRequested.bind(this);
        this.onSuggestionsClearRequested = this.onSuggestionsClearRequested.bind(this);
    }

    onChange = (event, { newValue, method }) => {
        this.props.parentOnChange(newValue);
    };

    onSuggestionsFetchRequested = ({ value }) => {
        // this.setState({
        //     suggestions: getSuggestions(value)
        // });
        this.props.parentOnSuggestionsFetchRequested(value);
    };

    onSuggestionsClearRequested = () => {
        // this.setState({
        //     suggestions: []
        // });
        this.props.parentOnSuggestionsClearRequested();
    };

    render() {
        return (
            <Autosuggest
                suggestions={this.props.suggestions}
                onSuggestionsFetchRequested={this.onSuggestionsFetchRequested}
                onSuggestionsClearRequested={this.onSuggestionsClearRequested}
                getSuggestionValue={this.props.getSuggestionValue}
                renderSuggestion={this.props.renderSuggestion}
                inputProps={this.props.inputProps} />
        );
    }
}
export default ActualSearchBar;