import React from 'react'

function NavBar({loggedIn, setLoggedIn, displayName}) {

    return (
        <div>
            <div>
                <img src='/images/CSBalkanLogo.png' alt='CS Balkan Web Shop'  id="logo" width="40px" height="40px"/>
                <h3>CS Balkan Web Shop</h3>
            </div>
            <div>
                {
                loggedIn ? 
                    <div>
                        <a href='/profile'>{displayName}</a>
                        <a href='/cart'>Cart (X)</a>
                        <button  onClick={() => setLoggedIn(false)}>Logout</button>
                    </div>
                    :
                    <div>
                        <a href='/login'>Login</a>
                        <a href="/register">Register</a>
                    </div>
                }
                
            </div>
        </div>
    )
}

export default NavBar