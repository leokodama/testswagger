package com.br.testlabs.controller;

import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.PATCH;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.br.testlabs.domain.User;
import com.br.testlabs.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value= "/user", description = "Operations about User")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "Create User", response = User.class, responseContainer = "User", code = 204)
    @ApiResponses(value = { @ApiResponse(code = 204, message = "OK"), @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 500, message = "Internal Server Error") })
    @ResponseStatus(NO_CONTENT)
    @RequestMapping(method = { POST })
    public void createUser(@RequestBody User user) {
        userService.save(user);
    }

    @ApiOperation(value = "Update User", response = User.class, responseContainer = "User", code = 204)
    @ApiResponses(value = { @ApiResponse(code = 204, message = "OK"), @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 500, message = "Internal Server Error") })
    @ResponseStatus(NO_CONTENT)
    @RequestMapping(method = { PATCH })
    public void updateUser(@RequestBody User user) {
        userService.save(user);
    }

    @ApiOperation(value = "Delete User by id", response = User.class, responseContainer = "User", code = 204)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 500, message = "Internal Server Error") })
    @ResponseStatus(OK)
    @RequestMapping(path = "/{id}", method = { DELETE })
    public void removeUser(@PathVariable String id) {
        userService.remove(Long.valueOf(id));
    }

    @ApiOperation(value = "Return User by Id", response = User.class, responseContainer = "User", code = 204)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 500, message = "Internal Server Error") })
    @ResponseBody
    @RequestMapping(path = "/{id}", method = { GET })
    public ResponseEntity<User> getUserById(@PathVariable String id) {
        return new ResponseEntity<User>(userService.findOne(Long.valueOf(id)), OK);
    }

    @ApiOperation(value = "Return all Users", response = User.class, responseContainer = "User", code = 204)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 500, message = "Internal Server Error") })
    @ResponseBody
    @RequestMapping(method = { GET })
    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<List<User>>(userService.findAll(), OK);
    }

}
