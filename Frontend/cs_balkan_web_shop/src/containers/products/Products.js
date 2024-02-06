import React, { useState } from 'react';
import ProductCard from '../../components/productCard/ProductCard';
import './Products.css';

function Products({data, loggedIn, AddToCart, username}) {

    const [selectedType, setSelectedType] = useState("");

    const filteredData = selectedType !== ""
    ? data.filter(item => item.type === selectedType)
    : data;

    const AddToFav = async (id) =>{
        const request = { user: username, product: id }
        console.log(request);
        const url = 'http://localhost:8088/CSBalkanWebShop/shop/addFavorite'
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
            }else{
                return Promise.reject(res.status)
            }
        })
    }

    return (
        <div  className="products">
            <label>
                Search:
                <input
                    type="text"
                    name="search"
                    value={selectedType}
                    onChange={(e) => setSelectedType(e.target.value)}
                />
            </label>
            <div className='products-display'>
                {data.filter(item => { return item.type.toLowerCase().includes(selectedType.toLowerCase()) 
                                    || item.name.toLowerCase().includes(selectedType.toLowerCase()) })
                .map((item, index) => (
                    <ProductCard key={index} 
                    id={item.idProducts}
                    name={item.name}  
                    price={item.price} 
                    image={item.image}
                    description={item.description}
                    AddToCart={AddToCart}
                    loggedIn={loggedIn}
                    AddToFav={AddToFav}/>
                ))}
            </div>
        </div>
    )
}

export default Products;