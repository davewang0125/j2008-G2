import { API_BASE_URL } from "../constants";
import axios from "axios";

export function addAudio(file) {
    //let file = new File([blob], "/Users/zhuoruli/Desktop/Second.mp3");
    let formData = new FormData();
    formData.append('file', file);
    return axios.post(API_BASE_URL + "/s3", formData)
                .then(res => {
                    console.log(res);
                })
}