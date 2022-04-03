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
                localStorage.setItem('token', JSON.stringify(response.data.jwt));
            }
            return response.data.person;
        });
    }

    signOut(){
        localStorage.removeItem('token');
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