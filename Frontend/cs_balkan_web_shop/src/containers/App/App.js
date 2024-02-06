import './App.css';
import { useState, useEffect } from 'react';
import axios from '../../api/AxiosConfig';
import { Routes, Route } from 'react-router-dom';
import Home from '../home/Home';
import LogInPage from '../loginPage/LogInPage';
import RegisterPage from '../registerPage/RegisterPage';

function App() {

    const emptyUser = {
        username: "", 
        email: "",  
        password: null,
        role: "USER"
    }

    const [loggedIn, setLoggedIn] = useState(false);
    const [mainuser, setUser] = useState(emptyUser);
    const [products, setProducts] = useState([]);
    const [cart, setCart] = useState([]);
    const [appState, setAppState] = useState("HOME") // HOME | CART | PROFILE

    const getProducts = async () => {
        try{
            const response = await axios.get('/shop/products');
            setProducts(response.data);
        } catch(err){
          console.log("Error getting products", err);
        }
    }

    const getCartItems = async () => {
        try{
            
            const response = await axios.get('/shop/cart/'+mainuser.username);
            setCart(response.data);
        }catch (error) {
            console.log('Error getting cart items', error);
        }
    }

    useEffect(()=>{
        getProducts();
    }, []);

    useEffect(()=>{
        if(loggedIn===false){
            setUser(emptyUser);
            setCart([]);
        }else{
            getCartItems();
        }
    }, [loggedIn]);

    const AddToCart = async (id, amount) => {
        const data = { user: mainuser.username, product: id, amount: amount }
        console.log(data);
        const url = 'http://localhost:8088/CSBalkanWebShop/shop/addToCart'
        const response = await fetch(url, {
            method: 'POST',
            cache: 'no-cache',
            credentials: 'same-origin',
    
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
        }).then(res => {
            if(res.ok){
                console.log(res.json());
                getCartItems();
            }else{
                return Promise.reject(res.status)
            }
        })
    }

    const RemoveFromCart = async (id, amount) =>{
        const data = { user: mainuser.username, product: id, amount: amount }
        console.log(data);
        const url = 'http://localhost:8088/CSBalkanWebShop/shop/removeFromCart'
        const response = await fetch(url, {
            method: 'POST',
            cache: 'no-cache',
            credentials: 'same-origin',
    
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
        }).then(res => {
            if(res.ok){
                console.log(res.json());
                getCartItems();
            }else{
                return Promise.reject(res.status)
            }
        })
    }

    const Buy = async () => {
        const data = { value: mainuser.username}
        const url = 'http://localhost:8088/CSBalkanWebShop/shop/buy'
        const response = await fetch(url, {
            method: 'POST',
            cache: 'no-cache',
            credentials: 'same-origin',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
        }).then(res => {
            if(res.ok){
                console.log(res.json());
                getCartItems();
                getProducts();
                setAppState("HOME");
            }else{
                return Promise.reject(res.status)
            }
        })
    }

    return (
        <div className='App'>
            <Routes>
                <Route path="/" element={<Home products={products} loggedIn={loggedIn} setLoggedIn={setLoggedIn} 
                                      username={mainuser.username} AddToCart={AddToCart} 
                                      appState={appState} setAppState={setAppState} cart={cart} RemoveFromCart={RemoveFromCart}
                                      Buy={Buy} myrole={mainuser.role} getProducts={getProducts}/>} />
                <Route path="/login" element={<LogInPage setUser={setUser} setLoggedIn={setLoggedIn}/>} />
                <Route path="/register" element={<RegisterPage />} />
            </Routes>
        </div>
    );
}

export default App;
