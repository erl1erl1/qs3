package idi.bidata.burritobanden.qs3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginRequestServiceImpl implements LoginRequestService{
    @Autowired PersonService personService;

    @Override
    public boolean authenticate(String username, String password) {
        return personService.authenticate(username, password);
    }
}
