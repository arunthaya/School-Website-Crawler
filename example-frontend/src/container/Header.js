import React, { Component } from 'react';
import '../css/App.css';
import { Link } from 'react-router-dom';

const Header = () => (
    <header id="navheader">
        <div id="logo">
            <img id="applyboard_logo" src={require("../assets/applyboard_logo.png")} width="65" height="20.4"/>
        </div>
        <nav>
            <div class="table">
                <ul id="navbar">
                    <li><Link class="sliding-middle-out" to='/'>Home</Link></li>
                    <li><Link class="sliding-middle-out" to='/tester'>Add School</Link></li>
                    <li><Link class="sliding-middle-out" to='/searchbar'>Search / View</Link></li>
                </ul>
            </div>
        </nav>
    </header>
);

export default Header;