package idi.bidata.burritobanden.qs3.controller;

import idi.bidata.burritobanden.qs3.entity.Person;
import idi.bidata.burritobanden.qs3.model.authentication.AuthenticationRequest;
import idi.bidata.burritobanden.qs3.model.authentication.AuthenticationResponse;
import idi.bidata.burritobanden.qs3.service.person.PersonService;
import idi.bidata.burritobanden.qs3.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/auth")
@EnableAutoConfiguration
@CrossOrigin
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PersonService personService;

    @Autowired
    private JWTUtil jwtUtil;

    @PostMapping("")
    public AuthenticationResponse createAuthToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
        } catch (BadCredentialsException e){
            throw new Exception("Incorrect username or password");
        }
        final Person person = personService.findPersonByUsername(authenticationRequest.getUsername());
        final String jwt = jwtUtil.generateToken(person);
        return new AuthenticationResponse(jwt, person);
    }
}
