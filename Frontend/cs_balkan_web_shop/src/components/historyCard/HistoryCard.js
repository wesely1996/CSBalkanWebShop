import React, { useState } from 'react';

function HistoryCard({data}) {

    return (
        <div>
            {data.map((item, index) => (
                <div key={index}>
                    <div>ProductId: {item.id}</div>
                    <div>Price per product: {item.price}</div>
                    <div>Quantity: {item.quantity}</div>
                </div>
            ))}
        </div>
    )

}

export default HistoryCard