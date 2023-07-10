import axios from 'axios';

 axios.defaults.baseURL = "http://localhost:8080";

const RequestAxios = async (path, method, databody) => {

    try {
   
        let options = {
            url:path,
            method: method,
            data: databody
        }

        let res = await axios(options);
        return res
    }
    catch (err) {
        throw err;
    }
}

export default RequestAxios;