import React, { useState, useEffect } from 'react'
import History from "../history/History";
import Favorites from  "../favorites/Favorites";
import Freinds from "../friends/Friends";
import Messages from '../messages/Messages';
import axios from '../../api/AxiosConfig';
import './Profile.css';

function Profile({username}) {

    const [profileState, SetProfileState] = useState("NONE"); // NONE | HISTORY | FRIENDS | MESSAGES | FAVORITES
    const [data, setData] = useState([]);
    const [favorites, setFavorites] = useState([]);
    const [myfriends, setMyFriends] = useState([]);
    const [mymessages, setMyMessages] = useState([]);

    const getHistory = async () => {
        try{
            const response = await axios.get('/shop/shoppingHistory/'+username);
            setData(response.data);
        } catch(err){
          console.log("Error getting products", err);
        }
    }

    const getFavorites = async () => {
        try{
            const response = await axios.get('/shop/favorites/'+username);
            setFavorites(response.data);
        } catch(err){
          console.log("Error getting products", err);
        }
    }

    const getFriends = async () => {
        try{
            const response = await axios.get('/user/getFriends/'+username);
            setMyFriends(response.data);
        } catch(err){
          console.log("Error getting products", err);
        }
    }

    const getMessages = async () => {
        try{
            const response = await axios.get('/msg/getAll/'+username);
            setMyMessages(response.data.body);
        } catch(err){
          console.log("Error getting products", err);
        }
    }

    useEffect(()=>{
        getHistory();
        getFavorites();
        getFriends();
        getMessages();
    }, []);

    useEffect(()=>{
        getHistory();
        getFavorites();
        getFriends();
        getMessages();
    }, [profileState]);

    useEffect(()=>{
        getFriends();
    }, [myfriends])

    useEffect(()=>{
        getMessages();
    }, [mymessages])

    return (
        <div>
            <div>
                <button  onClick={() => SetProfileState("FRIENDS")} className="btn btn-primary">Friends</button>
                <button  onClick={() => SetProfileState("FAVORITES")} className="btn btn-primary">Favorites</button>
                <button  onClick={() => SetProfileState("HISTORY")} className="btn btn-primary">History</button>
                <button  onClick={() => SetProfileState("MESSAGES")} className="btn btn-primary">Messages</button>
            </div>
            <div className='profile-display'>
                {   
                profileState==="HISTORY"?
                <History data={data}/> :
                profileState==="NONE"?
                <h1>Profile of user: {username}</h1> :
                profileState==="FAVORITES"?
                <Favorites data={favorites} username={username} getFavorites={getFavorites}/>:
                profileState==="FRIENDS"?
                <Freinds username={username} myfriends={myfriends} getFriends={getFriends} getMessages={getMessages}/>:
                profileState==="MESSAGES"?
                <Messages username={username} mymessages={mymessages}/>:
                <div>UNDER CONSTRUCTION</div>
                }
            </div>
        </div>
    )
}

export default Profile;