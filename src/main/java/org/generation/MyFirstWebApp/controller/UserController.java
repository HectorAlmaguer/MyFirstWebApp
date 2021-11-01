package org.generation.MyFirstWebApp.controller;

import org.generation.MyFirstWebApp.model.User;
import org.generation.MyFirstWebApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController
{
    final UserService userService;

    public UserController( @Autowired UserService userService )
    {
        this.userService = userService;
        userService.add( new User( 1, "Santiago", "Carrillo" ) );
        userService.add( new User( 2, "Amado", "Carrillo" ) );
        userService.add( new User( 3, "Joaquin", "Guzman" ) );
        userService.add( new User( 4, "Hector", "Almaguer" ) );
    }

    @GetMapping( "/user" )
    public User getUser()
    {
        return userService.getUser( 0 );
    }

    @GetMapping( "/user/all" )
    public int TotalUser()
    {
        return userService.size();
    }

    @GetMapping( "/user/list" )
        public List<User> getAll(){
            return userService.getAll();
        }

}
