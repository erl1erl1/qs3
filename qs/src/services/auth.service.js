import axios from 'axios'

class AuthService {
    signIn(user){
        return axios.post(
            "http://localhost:8080/auth", {
                username: user.username,
                password: user.password
            }
        ).then(response => {
            if(response.data.jwt) {
                console.log(response.data.jwt)
                sessionStorage.setItem('token', JSON.stringify(response.data.jwt));
                sessionStorage.setItem('user', JSON.stringify(response.data.person));
            }
            return response.data.person;
        });
    }

    signOut(){
        sessionStorage.removeItem('user');
        sessionStorage.removeItem('token');
        return true;
    }

    register(user){
        return axios.post(
            "http://localhost:8080/persons/register", {
                name: user.name,
                username: user.username,
                password: user.password,
                role: user.role
            }
        );
    }
}

export default new AuthService();