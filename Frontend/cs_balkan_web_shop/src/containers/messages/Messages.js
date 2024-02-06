import React, { useState, useEffect } from 'react';

function Messages({username, mymessages, getMessages}) {
    const [subject, setSubject] = useState("");
    const [receiver, setReciver] = useState("");
    const [message, setMessage] = useState("");

    const SendMessage = async () =>{
        const request = { message: message,
                        subject: subject,
                        sender: username,
                        reciver: receiver }
        console.log(request);
        const url = 'http://localhost:8088/CSBalkanWebShop/msg/send'
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
                console.log("Message has been sent.");
                setSubject("");
                setReciver("");
                setMessage("");
                getMessages();
            }else{
                return Promise.reject(res.status)
            }
        })
    }

    return (
        <div>
            <div>
                <div>
                <label htmlFor="subject">Subject:</label>
                <input
                    type="text"
                    id="subject"
                    name="subject"
                    value={subject}
                    placeholder={`Subject...`} 
                    onChange={(e) => setSubject(e.target.value)}
                />
                </div>
                <div>
                <label htmlFor="receiver">Receiver:</label>
                <input
                    type="text"
                    id="receiver"
                    name="receiver"
                    value={receiver}
                    placeholder={`Reciver...`} 
                    onChange={(e) => setReciver(e.target.value)}
                />
                </div>
                <div>
                <label htmlFor="message">Message:</label>
                <textarea
                    id="message"
                    name="message"
                    value={message}
                    placeholder={`Subject...`} 
                    onChange={(e) => setMessage(e.target.value)}
                />
                </div>
                <div>
                <button onClick={() => SendMessage()}>Send</button>
                </div>
            </div>
            <div>
            {mymessages.map((item, index) => (
                <div key={index}>
                    <div>{index}. {item.timestamp}</div>
                    <div>{item.subject}</div>
                    <div>{item.message}</div>
                </div>
            ))}
            </div>
        </div>
    )
}

export default Messages;