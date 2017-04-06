package com.omexit.mifospaymentbridge.controller.user;

import com.omexit.mifospaymentbridge.domain.user.User;
import com.omexit.mifospaymentbridge.exception.ResourceNotFoundException;
import com.omexit.mifospaymentbridge.services.user.UserService;
import com.omexit.mifospaymentbridge.types.ReasonCode;
import com.omexit.mifospaymentbridge.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Collection;

import static com.omexit.mifospaymentbridge.util.BaseController.API_PATH;

/**
 * The BaseController class is a RESTful web service controller. The
 * <code>@RestController</code> annotation informs Spring that each
 * <code>@RequestMapping</code> method returns a <code>@ResponseBody</code>.
 *
 * @author Antony Omeri
 */
@RestController
@RequestMapping(value = API_PATH)
public class UserController extends BaseController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Web service endpoint to fetch all User entities. The service returns the collection of User entity in JSON
     *
     * @return A ResponseEntity containing a Collection of User Objects
     */
    @RequestMapping(
            value = USER_URL,
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<User>> getUsers() {
        Collection<User> users = userService.findAll();

        return new ResponseEntity<Collection<User>>(users, HttpStatus.OK);
    }


    /**
     * Web service endpoint to fetch a single User entity by primary key identifier
     * <p>
     * If found the User is returned as JSON with HTTP status 200
     * <p>
     * If not found, the service returns an empty response body with HTTP status 404
     *
     * @param id
     * @return A ResponseEntity containing a single User object,
     */
    @RequestMapping(
            value = GET_USER_URL,
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getUser(@PathVariable("userId") Long id) throws ResourceNotFoundException {
        User user = userService.findUserById(id);
        if (user == null) {
            throw new ResourceNotFoundException(String.format("User with Id: %s not found", id),
                    "Resource not found!",
                    ReasonCode.RESOURCE_NOT_FOUND);

        }

        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @RequestMapping(
            value = GET_USER_BY_USERNAME_URL,
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getUserByUsername(@PathVariable("username") String username) {
        User user = userService.findUserByUsername(username);
        if (user == null) {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    /**
     * Web service endpoint to create a single User entity. The HTTP request
     * body is expected to contain a User object in JSON format. The
     * User is persisted in the data repository.
     * <p>
     * If created successfully, the persisted User is returned as JSON with
     * HTTP status 201.
     * <p>
     * If not created successfully, the service returns an empty response body
     * with HTTP status 500.
     *
     * @param user The User object to be created.
     * @return A ResponseEntity containing a single User object, if created
     * successfully, and a HTTP status code as described in the method
     * comment.
     * @throws Exception Thrown if a problem occurs completing the request.
     */
    @RequestMapping(
            value = USER_URL,
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User savedUser = userService.create(user);

        return new ResponseEntity<User>(savedUser, HttpStatus.CREATED);
    }

    /**
     * Web service endpoint to update a single User entity. The HTTP request
     * body is expected to contain a User object in JSON format. The
     * User is updated in the data repository.
     * <p>
     * If updated successfully, the persisted User is returned as JSON with
     * HTTP status 200.
     * <p>
     * If not found, the service returns an empty response body and HTTP status
     * 404.
     * <p>
     * If not updated successfully, the service returns an empty response body
     * with HTTP status 500.
     *
     * @param user The User object to be updated.
     * @return A ResponseEntity containing a single User object, if updated
     * successfully, and a HTTP status code as described in the method
     * comment.
     * @throws Exception Thrown if a problem occurs completing the request.
     */
    @RequestMapping(
            value = UPDATE_USER_URL,
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> updateUser(@PathVariable("userId") Long id,
                                           @RequestBody User user) {
        User updatedUser = userService.update(user);

        return new ResponseEntity<User>(updatedUser, HttpStatus.OK);
    }

    /**
     * Return the principal identifying the logged in user
     *
     * @param principal
     * @return
     */
    @RequestMapping("/me")
    public User getCurrentLoggedInUser(Principal principal) {
        return userService.findUserByUsername(principal.getName());
    }
}
