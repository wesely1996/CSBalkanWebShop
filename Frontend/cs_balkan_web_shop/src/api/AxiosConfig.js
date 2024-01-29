import axios from "axios";

export default axios.create({
    baseURL: 'http://localhost:8088/CSBalkanWebShop',
    headers: {"ngrok-skip-browser-warning": "true"}
});