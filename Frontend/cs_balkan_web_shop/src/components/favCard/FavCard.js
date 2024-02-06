import React, { useState } from 'react'
import './FavCard.css';

function ProductCard(props) {

    const {id, name, description, price, image, RemoveFromFav} = props;

    return (
        <div className='fav-card'>
            <div className='fav-title'>{name}</div>
            {
                image ?
                    <img src={image} alt="" />
                :
                    <img src="/images/CSBalkanLogo.png" alt="" width="100px" height="100px"/>
            }
            <p>{description}</p>
            <span>${price.toFixed(2)}</span>
            <button onClick={() => RemoveFromFav(id)}>Remove from favorites</button>
        </div>
    )

}

export default ProductCard