import React, { useState } from 'react'
import NavBar from '../../components/navbar/NavBar';
import Products from '../products/Products';
import Profile from '../profile/Profile';
import Cart from '../cart/Cart';
import './Home.css';

function Home({products, loggedIn, setLoggedIn, username, AddToCart, appState, setAppState, cart, RemoveFromCart, Buy, myrole, getProducts}) {

    return (
        <div>
            <NavBar loggedIn={loggedIn} setLoggedIn={setLoggedIn} username={username} setAppState={setAppState}/>
            {
                appState === "HOME" ?
                <Products  data={products} AddToCart={AddToCart} loggedIn={loggedIn} username={username}/>
                :
                appState === "CART" ?
                <Cart cart={cart} RemoveFromCart={RemoveFromCart} Buy={Buy}/>
                :
                appState === "PROFILE" ?
                <Profile username={username} myrole={myrole} getProducts={getProducts}/>
                :
                <div></div>
            }
        </div>
    )
}

export default Home