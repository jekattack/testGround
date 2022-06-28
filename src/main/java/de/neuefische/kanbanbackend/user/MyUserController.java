package de.neuefische.kanbanbackend.user;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class MyUserController {

    private final MyUserService myUserService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void postNewUser(@RequestBody MyUser newUser){
        myUserService.createNewUser(newUser);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public MyUserDTO getLoggedInUser(Principal principal){
        String username = principal.getName();
        return myUserService
                .findByName(username)
                .orElseThrow();
    }


}
