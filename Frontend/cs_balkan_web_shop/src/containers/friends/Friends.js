import React, { useState } from 'react'

function Freinds({username, myfriends, getFriends}) {

    const [friend, setFriend] = useState("");

    const AddFriend = async () =>{
        const request = { username: username, friend: friend }
        console.log(request);
        const url = 'http://localhost:8088/CSBalkanWebShop/user/addFriend'
        const response = await fetch(url, {
            method: 'POST',
            cache: 'no-cache',
            credentials: 'same-origin',
    
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(request)
        }).then(res => {
            if(res.ok){
                console.log("Friend has been added.");
                getFriends();
            }else{
                return Promise.reject(res.status)
            }
        })
    }

    const RemoveFriend = async () =>{
        const request = { username: username, friend: friend }
        console.log(request);
        const url = 'http://localhost:8088/CSBalkanWebShop/user/removeFriend'
        const response = await fetch(url, {
            method: 'POST',
            cache: 'no-cache',
            credentials: 'same-origin',
    
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(request)
        }).then(res => {
            if(res.ok){
                console.log("Friend has been removed.");
                getFriends();
            }else{
                return Promise.reject(res.status)
            }
        })
    }

    return (
        <div>
            <div className='product-card'>
                <div>Select a friend:</div>
                <input  type="text" placeholder={`Add ${username}'s friend...`} value={friend} onChange={(e) => setFriend(e.target.value)}/>
                <div>
                    <button  onClick={() => AddFriend()}>Add Friend</button>
                    <button  onClick={() => RemoveFriend()}>Remove Friend</button>
                </div>
            </div>
            <div>
                <div>Friends list: </div>
                {
                    myfriends.map((item, index) => (
                        <div key={index}>
                            <div>{index}. {item.value}</div>
                        </div>
                    ))
                }
            </div>
        </div>
    )

}

export default Freinds;