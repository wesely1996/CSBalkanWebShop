import React, { useState } from 'react'
import './ProductCard.css';

function ProductCard(props) {

    const {id, name, description, price, image, quantity, AddToCart, loggedIn, AddToFav} = props;
    const [amount, setAmount] = useState(0);

    return (
        <div className='product-card'>
            <div className='product-title'>{name}</div>
            {
                image ?
                    <img src={image} alt="" />
                :
                    <img src="/images/CSBalkanLogo.png" alt="" width="100px" height="100px"/>
            }
            <p>{description}</p>
            <span>${price.toFixed(2)}</span>
            {
                loggedIn ?
                    quantity > 0?
                        <div>
                            <input  type="number" value={amount} onChange={e => setAmount(Number(e.target.value))}/>
                            <button onClick={() => AddToCart(id, amount)}>Add to Cart</button>
                            <button onClick={() => AddToFav(id)}>Add to Favorites</button>
                        </div>:
                        <div>
                            SOLD OUT
                            <button onClick={() => AddToFav(id)}>Add to Favorites</button>
                        </div>
                : <div></div>
            }
        </div>
    )

}

export default ProductCard