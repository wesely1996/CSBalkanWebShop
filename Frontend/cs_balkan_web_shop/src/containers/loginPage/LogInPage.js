import React from 'react'
import { useNavigate } from 'react-router-dom';
import { useState } from 'react';
import axios from '../../api/AxiosConfig';

function LogInPage({setUser, setLoggedIn}) {
    let navigate = useNavigate();

    const [username, setUsername] = useState("")
    const [password, setPassword] = useState("")

    const createNewUser = (event) => {
        event.preventDefault();
        const data = {
            username: username.trim(),  
            password: password
        }
        try{
            axios.post('/auth/logInUser', data)
            .then((res) => {
                if(res.status === 200){
                    setUser(data);
                    setLoggedIn(true);
                    navigate('/');
                }
            }).catch((err)=>{
                alert('Error logging in! Please check your credentials and try again.');
            })
        } catch(err){
            console.log(err);
        }
      }

    return (
        <div>
            <h2>RegisterPage</h2>
            <form onSubmit={createNewUser}>
                <label>
                Username:
                <input
                    type="text"
                    name="username"
                    value={username}
                    onChange={(e) => setUsername(e.target.value)}
                />
                </label>
                <br />
                <label>
                Password:
                <input
                    type="password"
                    name="password"
                    value={password}
                    onChange={(e) => setPassword(e.target.value)}
                />
                </label>
                <br />
                <button type="submit">Submit</button>
            </form>
        </div>
    )
}

export default LogInPage