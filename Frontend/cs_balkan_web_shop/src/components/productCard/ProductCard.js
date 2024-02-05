import React, { useState } from 'react'

function ProductCard(props) {

    const {id, name, description, price, image, AddToCart, isLoggedIn} = props;
    const [amount, setAmount] = useState(0);

    return (
        <div>
            <h2>{name}</h2>
            <img src={image} alt="" />
            <p>{description}</p>
            <span>${price.toFixed(2)}</span>
            {
                isLoggedIn ?
                    <div>
                        <input  type="number" value={amount} onChange={e => setAmount(Number(e.target.value))}/>
                        <button onClick={() => AddToCart(id)}>Add to Cart</button>
                    </div>
                : <div></div>
            }
        </div>
    )

}

export default ProductCard