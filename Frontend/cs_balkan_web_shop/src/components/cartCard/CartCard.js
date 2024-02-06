import React, { useState } from 'react';
import './CartCard.css';

function CartCard(props) {

    const {idProduct, name, price, quantity, RemoveFromCart} = props;
    const [amount, setAmount] = useState(quantity);

    return (
        <div className='cart-card'>
            <div className='cart-title'>{name}</div>
            <span>${price.toFixed(2)}</span>
            <input  type="number" value={amount} onChange={e => setAmount(Number(e.target.value))}/>
            <button onClick={() => RemoveFromCart(idProduct, amount)}>Set Amount</button>
        </div>
    )

}

export default CartCard