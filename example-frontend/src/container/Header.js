import React, { Component } from 'react';
import '../css/App.css';
import { Link } from 'react-router-dom';

const Header = () => (
    <header>
        <nav>
            <div class="table">
                <ul id="navbar">
                    <li><Link to='/'>Home</Link></li>
                    <li><Link to='/tester'>Add School</Link></li>
                    <li><Link to='/searchbar'>Search / View</Link></li>
                </ul>
            </div>
        </nav>
    </header>
);

export default Header;