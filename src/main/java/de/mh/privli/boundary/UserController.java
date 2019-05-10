package de.mh.privli.boundary;

import de.mh.privli.boundary.bean.UserInfo;
import java.security.Principal;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @RequestMapping("/user")
    public UserInfo user(Principal principal) {
        if (principal == null) {
            return null;
        }
        return new UserInfo(principal.getName());
    }
}
