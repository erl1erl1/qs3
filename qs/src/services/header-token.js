export default function authHeader() {
    let token = JSON.parse(sessionStorage.getItem('token'));
  
    if (token) {
      return { Authorization: 'Bearer ' + token }
    } else {
      return {};
    }
  }