package ch.noseryoung.grocerie.domain.authority;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorityService {
    public AuthorityService(){
    }
    @Autowired
    AuthorityRepository authorityRepository;
}