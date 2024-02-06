import React from 'react';
import "./NavBar.css";

function NavBar({loggedIn, setLoggedIn, username, setAppState}) {

    return (
        <div>
            <div onClick={() => setAppState("HOME")}>
                <img src='/images/CSBalkanLogo.png' alt='CS Balkan Web Shop'  id="logo" width="40px" height="40px"/>
                <h3>CS Balkan Web Shop</h3>
            </div>
            <div  className="navbar"> 
                {
                loggedIn ? 
                    <div className='nav-items'>
                        <button onClick={()=>setAppState("PROFILE")} className="btn btn-primary">{username}</button>
                        <button onClick={()=>setAppState("CART")} className="btn btn-primary">Cart</button>
                        <button onClick={() => setLoggedIn(false)} className="btn btn-primary">Logout</button>
                    </div>
                    :
                    <div className='nav-items'>
                        <a href='/login'>Login</a>
                        <a href="/register">Register</a>
                    </div>
                }
                
            </div>
        </div>
    )
}

export default NavBar