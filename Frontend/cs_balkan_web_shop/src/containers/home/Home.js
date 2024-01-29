import React, { useState } from 'react'
import ProductCard from '../../components/productCard/ProductCard';
import NavBar from '../../components/navbar/NavBar';

function Home({data, loggedIn, setLoggedIn, displayName, AddToCart}) {

    const [selectedType, setSelectedType] = useState("");

    const filteredData = selectedType !== ""
    ? data.filter(item => item.type === selectedType)
    : data;

    return (
        <div>
            <NavBar loggedIn={loggedIn} setLoggedIn={setLoggedIn} displayName={displayName}/>
            <label>
                Search:
                <input
                    type="text"
                    name="search"
                    value={selectedType}
                    onChange={(e) => setSelectedType(e.target.value)}
                />
            </label>
            {data.filter(item => { return item.type.toLowerCase().includes(selectedType.toLowerCase()) 
                                || item.name.toLowerCase().includes(selectedType.toLowerCase()) })
            .map((item, index) => (
                <ProductCard key={index} 
                id={item.idProducts}
                name={item.name}  
                price={item.price} 
                image={item.image}
                description={item.description}
                AddToCart={AddToCart}/>
            ))}
        </div>
    )
}

export default Home