import React from 'react';
import { Switch, Route } from 'react-router-dom';
import Tester from './Tester';
import Searchbar from './Searchbar';
import About from './About';


// The Main component renders one of the three provided
// Routes (provided that one matches). Both the /roster
// and /schedule routes will match any pathname that starts
// with /roster or /schedule. The / route will only match
// when the pathname is exactly the string "/"
const Main = () => (
    <main>
        <Switch>
            <Route exact path='/' component={About}/>
            <Route exact path='/tester' component={Tester}/>
            <Route path='/searchbar' component={Searchbar}/>
        </Switch>
    </main>
)

export default Main;