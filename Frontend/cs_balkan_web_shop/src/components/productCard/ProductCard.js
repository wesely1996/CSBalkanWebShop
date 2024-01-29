import React, { useState } from 'react'

function ProductCard(props) {

    const {id, name, description, price, image, AddToCart} = props;

    return (
        <div>
            <h2>{name}</h2>
            <img src={image} alt="" />
            <p>{description}</p>
            <span>${price.toFixed(2)}</span>
            <button onClick={() => AddToCart(id)}>Add to Cart</button>
        </div>
    )

}

export default ProductCard