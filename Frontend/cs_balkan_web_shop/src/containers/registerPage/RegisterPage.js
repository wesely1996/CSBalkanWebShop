import React from 'react'
import { useNavigate } from 'react-router-dom';
import { useState } from 'react';
import axios from '../../api/AxiosConfig';

function RegisterPage() {

    let navigate = useNavigate();

    const [username, setUsername] = useState("")
    const [email, setEmail] = useState("")
    const [password, setPassword] = useState("")
    const [role, setRole] = useState("USER")

    const createNewUser = (event) => {
        event.preventDefault();
        const data = {
            username: username.trim(), 
            email: email.toLowerCase().trim(),  
            password: password,
            role: role
        }
        try{
            axios.post('/auth/registerUser', data)
            .then((res) => {
                if(res.status === 200){
                    navigate('/')
                }
            }).catch((err)=>{
                alert('Error in creating new user! Please check your information and try again.');
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
                Email:
                <input
                    type="email"
                    name="email"
                    value={email}
                    onChange={(e) => setEmail(e.target.value)}
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

export default RegisterPage