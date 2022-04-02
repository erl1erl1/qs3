export default function authHeader() {
    let token = JSON.parse(localStorage.getItem('user'));
  
    if (token) {
      console.log(token)
      return { Authorization: 'Bearer ' + token }
    } else {
      return {};
    }
  }