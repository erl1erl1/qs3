export default function authHeader() {
    let token = JSON.parse(sessionStorage.getItem('token'));
  
    if (token) {
      return { Authorization: 'Bearer ' + token }
    } else {
      return {};
    }
}

export function authHeaderCSV() {
    let token = JSON.parse(localStorage.getItem('token'));

    if (token) {
        return {
            'Authorization': 'Bearer ' + token,
            'Content-Type': 'multipart/form-data'
        }
    }
    return {}
}