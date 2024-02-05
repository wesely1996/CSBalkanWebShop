import './App.css';
import { useState, useEffect } from 'react';
import axios from '../../api/AxiosConfig';
import { Routes, Route } from 'react-router-dom';
import Home from '../home/Home';
import LogInPage from '../loginPage/LogInPage';
import RegisterPage from '../registerPage/RegisterPage';
import Cart from '../cart/Cart';

function App() {

    const emptyUser = {
        username: "", 
        email: "",  
        password: null,  
        firstName: "",  
        lastName: "",
        displayName: ""
    }

    const [loggedIn, setLoggedIn] = useState(false)
    const [mainuser, setUser] = useState(emptyUser)
    const [products, setProducts] = useState([]);
    const [cart, setCart] = useState([])
    const [cartSize, setCartSize] = useState(0)

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
            const response = await axios.get('/shop/getUserCartItems?userName='+mainuser.username);
            setCart(response.data);
        }catch (error) {
            console.log('Error getting cart items', error);
        }
    }

    useEffect(()=>{
        console.log(mainuser)
        getProducts();
        if(loggedIn===false){
            setUser(emptyUser);
            setCart([]);
            setCartSize(0);
        }else{
            getCartItems();
            setCartSize(AmountOfCartItems());
        }
    }, []);

    const AddToCart = async (id, int) => {
        try{
            const response = await axios.get('/shop/addToCart', { params: mainuser.username });
            setCart(response.data);
            setCartSize(AmountOfCartItems());
        } catch(err){
          console.log("Error getting products", err);
        }
    }

    const AmountOfCartItems = () => {
        var i = 0;
        for(var ci in cart){
            console.log(ci.amount)
        }
    }

    return (
        <div className='App'>
            <Routes>
                <Route path="/" element={<Home data={products} loggedIn={loggedIn} setLoggedIn={setLoggedIn} 
                                      displayName={mainuser.username} AddToCart={AddToCart} AmountOfCartItems={cartSize}/>} />
                <Route path="/login" element={<LogInPage setUser={setUser} setLoggedIn={setLoggedIn}/>} />
                <Route path="/cart"element={<Cart user={mainuser.username}/>} />
                <Route path="/register" element={<RegisterPage />} />
            </Routes>
        </div>
    );
}

export default App;
