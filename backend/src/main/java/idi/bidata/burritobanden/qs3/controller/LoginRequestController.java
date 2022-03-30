package idi.bidata.burritobanden.qs3.controller;

import idi.bidata.burritobanden.qs3.entity.login.LoginRequest;
import idi.bidata.burritobanden.qs3.entity.login.LoginResponse;
import idi.bidata.burritobanden.qs3.service.LoginRequestService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/login")
@EnableAutoConfiguration
@CrossOrigin
public class LoginRequestController {
    LoginRequestService loginRequestService;

    @PostMapping("")
    @ResponseStatus(value = HttpStatus.CREATED)
    public LoginResponse login(@RequestBody LoginRequest loginRequest){
        if(loginRequestService.authenticate(loginRequest.getUsername(), loginRequest.getPassword())){
            return new LoginResponse("Success");
        }
        return new LoginResponse("Failed");
    }
}
