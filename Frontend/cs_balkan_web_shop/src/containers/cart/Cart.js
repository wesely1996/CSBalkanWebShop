import React, { useState, useEffect } from 'react'
import ProductCard from '../../components/cartCard/CartCard';
import axios from '../../api/AxiosConfig';

function Cart({user}) {

    const [data, setData] = useState([]);

    const getCartItems = async (user) => {
        try{
            const response = await axios.get('/shop/getUserCartItems?userName='+user);
            setData(response.data);
        }catch (error) {
            console.log('Error getting cart items', error);
        }
    }

    useEffect(()=>{
        getCartItems(user);
    }, []);

    return (
        <div>
            {data.map((item, index) => (
                <ProductCard key={index} 
                id={item.idProducts}
                name={item.name}  
                price={item.price} 
                image={item.image}
                description={item.description}
                RemoveFromCart={RemoveFromCart}/>
            ))}
        </div>
    )
}

export default Cart;