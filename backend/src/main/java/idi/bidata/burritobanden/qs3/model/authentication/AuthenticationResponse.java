package idi.bidata.burritobanden.qs3.model.authentication;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import idi.bidata.burritobanden.qs3.entity.Person;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AuthenticationResponse {

    final private String jwt;
    final private Person person;

    public AuthenticationResponse(String jwt, Person person) {
        this.jwt = jwt;
        this.person = person;
    }

    public String getJwt() {
        return jwt;
    }

    public Person getPerson() {
        return person;
    }
}
