package ch.noseryoung.grocerie.domain.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity<User> getUserInfos(@RequestBody User user) {
        User loadedUser = userService.loadUser(user.getFirstName());
        return ResponseEntity.status(200).body(loadedUser);
    }
}
