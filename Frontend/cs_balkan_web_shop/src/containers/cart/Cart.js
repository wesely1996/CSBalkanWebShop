import CartCard from '../../components/cartCard/CartCard';
import './Cart.css';

function Cart({cart, RemoveFromCart, Buy}) {

    return (
        <div>
            <div id='cart-products-display'>
                {cart.map((item, index) => (
                    <CartCard key={index} 
                    idProduct={item.id}
                    name={item.name}  
                    price={item.price}
                    quantity={item.amount} 
                    RemoveFromCart={RemoveFromCart}/>
                ))}
            </div>
            <button onClick={()=>Buy()}>BUY</button>
        </div>
    )
}

export default Cart;