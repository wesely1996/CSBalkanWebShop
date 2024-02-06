import React, { useState, useEffect } from 'react';
import HistoryCard from '../../components/historyCard/HistoryCard';

function History({data}) {

    return (
        <div>
            {data.map((item, index) => (
                <div key={index}>
                    <div>{index}. Date: {item.timestamp}</div> 
                    <HistoryCard data={item.shoppinglistitems} />
                </div>
            ))}
        </div>
    )
}

export default History;