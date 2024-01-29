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
        firstName: "",  
        lastName: "",
        displayName: ""
    }

    const [loggedIn, setLoggedIn] = useState(false)
    const [mainuser, setUser] = useState(emptyUser)
    const [products, setProducts] = useState([]);
    const [cart, setCart] = useState([])

    const getProducts = async () => {
        try{
            const response = await axios.get('/shop/products');
            setProducts(response.data);
        } catch(err){
          console.log(err);
        }
    }

    useEffect(()=>{
        getProducts();
        if(loggedIn===false){
            setUser(emptyUser);
            setCart([])
        }
    }, []);

    const AddToCart = (id) => {
        console.log("add to cart " + id);
    }

    return (
        <div className='App'>
            <Routes>
                <Route path="/" element={<Home data={products} loggedIn={loggedIn} setLoggedIn={setLoggedIn} 
                                      displayName={mainuser.username} AddToCart={AddToCart}/>} />
                <Route path="/login" element={<LogInPage setUser={setUser} setLoggedIn={setLoggedIn}/>} />
                <Route path="/register" element={<RegisterPage />} />
            </Routes>
        </div>
    );
}

export default App;
