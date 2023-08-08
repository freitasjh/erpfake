import axios from 'axios';

const http = axios.create({
    timeout: 10000,
    headers: {
        "Content-Type": "application/json",
      },    
});

export default http;