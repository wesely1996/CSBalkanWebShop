import React, { useState, useEffect } from 'react';

function Creator({getProducts}) {
    const [name, setName] = useState("");
    const [description, setDescription] = useState("");
    const [price, setPrice] = useState(0.0);
    const [image, setImage] = useState("");
    const [type, setType] = useState("");
    const [quantity, setQuantinty] = useState(0);

    const [restockName, setRestockName] = useState("");
    const [amount, setAmount] = useState(1);

    const AddNewProduct = async () =>{
        const request = { name: name,
                        description: description,
                        price: price,
                        image: image,
                        type: type,
                        quantity: quantity
                    };
        console.log(request);
        const url = 'http://localhost:8088/CSBalkanWebShop/adm/addProduct'
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
                console.log("Product has been created.");
                setName("");
                setDescription("");
                setImage("");
                setType("");
                setPrice(0.0);
                setQuantinty(0);
                getProducts();
            }else{
                return Promise.reject(res.status)
            }
        })
    }

    const UpdateStock = async () =>{
        const request = { name: restockName,
                        description: description,
                        price: price,
                        image: image,
                        type: type,
                        quantity: amount};
        console.log(request);
        const url = 'http://localhost:8088/CSBalkanWebShop/adm/changeProductAmount'
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
                console.log("Product has been created.");
                setRestockName("");
                setAmount(0);
                getProducts();
            }else{
                console.log(res.json())
                return Promise.reject(res.status)
            }
        })
    }

    return (
        <div>
            <div>
                <div>Ceate new product.</div>
                <div>
                    <label htmlFor="name">Name:</label>
                    <input
                        type="text"
                        id="name"
                        name="name"
                        value={name}
                        placeholder={`Name...`} 
                        onChange={(e) => setName(e.target.value)}
                    />
                </div>
                <div>
                    <label htmlFor="description">Description:</label>
                    <input
                        type="text"
                        id="description"
                        name="description"
                        value={description}
                        placeholder={`Description...`} 
                        onChange={(e) => setDescription(e.target.value)}
                    />
                </div>
                <div>
                    <label htmlFor="image">Image URL:</label>
                    <input
                        type='text'
                        id="image"
                        name="image"
                        value={image}
                        onChange={(e) => setImage(e.target.value)}
                    />
                </div>
                <div>
                    <label htmlFor="price">Price:</label>
                    <input
                        type='number'
                        id="price"
                        name="price"
                        value={price}
                        onChange={(e) => setPrice(e.target.value)}
                    />
                </div>
                <div>
                    <label htmlFor="quantity">Quantity:</label>
                    <input
                        type='number'
                        id="quantity"
                        name="quantity"
                        value={quantity}
                        onChange={(e) => setQuantinty(e.target.value)}
                    />
                </div>
                <div>
                    <label htmlFor="type">Tags:</label>
                    <input
                        type='text'
                        id="type"
                        name="type"
                        value={type}
                        onChange={(e) => setType(e.target.value)}
                    />
                </div>
                <div>
                    <button onClick={() => AddNewProduct()}>Create new item</button>
                </div>
            </div>
            <div>
                <div>Change stock</div>
                <div>
                    <label htmlFor="amount">Quantity:</label>
                    <input
                        type='number'
                        id="amount"
                        name="amount"
                        value={amount}
                        onChange={(e) => setAmount(e.target.value)}
                    />
                </div>
                <div>
                    <label htmlFor="restockName">Product name:</label>
                    <input
                        type='text'
                        id="restockName"
                        name="restockName"
                        value={restockName}
                        onChange={(e) => setRestockName(e.target.value)}
                    />
                </div>
                <div>
                    <button onClick={() => UpdateStock()}>Update Product Stock</button>
                </div>
            </div>
        </div>
    )
}

export default Creator;