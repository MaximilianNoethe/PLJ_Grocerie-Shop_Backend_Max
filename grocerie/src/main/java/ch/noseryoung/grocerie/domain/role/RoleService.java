package ch.noseryoung.grocerie.domain.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    public RoleService() {
    }
    @Autowired
    RoleRepository roleRepository;
}
