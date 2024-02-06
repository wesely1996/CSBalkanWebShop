import React, { useState, useEffect } from 'react';
import FavCard from '../../components/favCard/FavCard';
import './Favorites.css';

function Favorites({data, username, getFavorites}) {

    const RemoveFromFav = async (id) =>{
        const request = { user: username, product: id }
        console.log(request);
        const url = 'http://localhost:8088/CSBalkanWebShop/shop/removeFromFavorites'
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
                console.log(res.json());
                getFavorites();
            }else{
                return Promise.reject(res.status)
            }
        })
    }

    return (
        <div className='favorites-display'>
            {
            data.map((item, index) => (
                <FavCard key={index} 
                id={item.idProducts}
                name={item.name}  
                price={item.price} 
                image={item.image}
                description={item.description}
                RemoveFromFav={RemoveFromFav}/>
            ))}
        </div>
    )
}

export default Favorites;