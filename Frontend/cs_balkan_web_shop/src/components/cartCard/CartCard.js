import React, { useState } from 'react'

function CartCard(props) {

    const {id, name, description, price, image, RemoveFromCart} = props;
    const [amount, setAmount] = useState(0);

    const ConfirmAmount = (id, int) => {
        console.log(id + " " + int);
    }

    return (
        <div>
            <h2>{name}</h2>
            <img src={image} alt="" />
            <p>{description}</p>
            <span>${price.toFixed(2)}</span>
            <input  type="number" value={amount} onChange={e => setAmount(Number(e.target.value))}/>
            <button onClick={() => ConfirmAmount(id, amount)}>ConfirmAmount</button>
            <button onClick={() => RemoveFromCart(id)}>Remove From Cart</button>
        </div>
    )

}

export default CartCard