package com.omexit.mifospaymentbridge.controller.role;

import com.omexit.mifospaymentbridge.domain.role.Role;
import com.omexit.mifospaymentbridge.exception.ResourceNotFoundException;
import com.omexit.mifospaymentbridge.domain.privilage.Privilege;
import com.omexit.mifospaymentbridge.domain.role.RoleResource;
import com.omexit.mifospaymentbridge.domain.role.RoleResourceAssembler;
import com.omexit.mifospaymentbridge.services.role.RoleService;
import com.omexit.mifospaymentbridge.types.ReasonCode;
import com.omexit.mifospaymentbridge.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.omexit.mifospaymentbridge.util.BaseController.API_PATH;

@RestController
@RequestMapping(value = API_PATH)
public class RoleController extends BaseController {

    private final RoleService roleService;
    private final RoleResourceAssembler roleResourceAssembler;

    @Autowired
    public RoleController(RoleService roleService, RoleResourceAssembler roleResourceAssembler) {
        this.roleService = roleService;
        this.roleResourceAssembler = roleResourceAssembler;
    }

    /**
     * Web service endpoint to fetch all Role entities. The service returns the collection of Role entity in JSON
     *
     * @return A ResponseEntity containing a Collection of Role Objects
     */
    @RequestMapping(
            value = ROLE_URL,
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<PagedResources<RoleResource>> getRoles(@PageableDefault(size = REST_DEFAULT_PAGE_SIZE, page = REST_DEFAULT_PAGE) Pageable pageable,
                                                                 PagedResourcesAssembler<Role> assembler) {
        Page<Role> roles = roleService.findAll(pageable);

        return new ResponseEntity<>(assembler.toResource(roles, roleResourceAssembler), HttpStatus.OK);
    }


    /**
     * Web service endpoint to fetch a single Role entity by primary key identifier
     * <p>
     * If found the Role is returned as JSON with HTTP status 200
     * <p>
     * If not found, the service returns an empty response body with HTTP status 404
     *
     * @param id
     * @return A ResponseEntity containing a single Role object,
     */
    @RequestMapping(
            value = GET_ROLE_URL,
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Resource<Role>> getRoleById(@PathVariable("roleId") Long id) throws ResourceNotFoundException {
        Role role = roleService.findRoleById(id);
        if (role == null) {
            throw new ResourceNotFoundException(String.format("Role with Id: %s not found", id),
                    "Resource not found!",
                    ReasonCode.RESOURCE_NOT_FOUND);

        }

        return new ResponseEntity<>(roleResourceAssembler.toResource(role), HttpStatus.OK);
    }

    /**
     * Web service endpoint to create a single Role entity. The HTTP request
     * body is expected to contain a Role object in JSON format. The
     * Role is persisted in the data repository.
     * <p>
     * If created successfully, the persisted Role is returned as JSON with
     * HTTP status 201.
     * <p>
     * If not created successfully, the service returns an empty response body
     * with HTTP status 500.
     *
     * @param role The Role object to be created.
     * @return A ResponseEntity containing a single Role object, if created
     * successfully, and a HTTP status code as described in the method
     * comment.
     * @throws Exception Thrown if a problem occurs completing the request.
     */
    @RequestMapping(
            value = ROLE_URL,
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Resource<Role>> createRole(@RequestBody Role role) {
        Role savedRole = roleService.create(role);

        return new ResponseEntity<>(roleResourceAssembler.toResource(savedRole), HttpStatus.CREATED);
    }

    /**
     * Web service endpoint to update a single Role entity. The HTTP request
     * body is expected to contain a Role object in JSON format. The
     * Role is updated in the data repository.
     * <p>
     * If updated successfully, the persisted Role is returned as JSON with
     * HTTP status 200.
     * <p>
     * If not found, the service returns an empty response body and HTTP status
     * 404.
     * <p>
     * If not updated successfully, the service returns an empty response body
     * with HTTP status 500.
     *
     * @param id   ID of the role to be updated
     * @param role The Role object to be updated.
     * @return A ResponseEntity containing a single Role object, if updated
     * successfully, and a HTTP status code as described in the method
     * comment.
     * @throws Exception Thrown if a problem occurs completing the request.
     */
    @RequestMapping(
            value = UPDATE_ROLE_URL,
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Resource<Role>> updateRole(@PathVariable("roleId") Long id,
                                                     @RequestBody Role role) {
        Role updatedRole = roleService.update(role);

        return new ResponseEntity<>(roleResourceAssembler.toResource(updatedRole), HttpStatus.OK);
    }

    @RequestMapping(
            value = GET_ROLE_PRIVILEGES_URL,
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Privilege>> getRolePrivileges(@PathVariable("roleId") Long id) throws ResourceNotFoundException {
        Role role = roleService.findRoleById(id);
        if (role == null) {
            throw new ResourceNotFoundException(String.format("Role with Id: %s not found", id),
                    "Resource not found!",
                    ReasonCode.RESOURCE_NOT_FOUND);

        }

        return new ResponseEntity<>(role.getPrivileges(), HttpStatus.OK);
    }
}
