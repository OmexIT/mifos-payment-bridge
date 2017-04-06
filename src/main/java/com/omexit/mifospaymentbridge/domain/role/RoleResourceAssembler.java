package com.omexit.mifospaymentbridge.domain.role;


import com.omexit.mifospaymentbridge.controller.role.RoleController;
import com.omexit.mifospaymentbridge.exception.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * Created by aomeri on 23/03/2017.
 * @author Omeri Antony
 */
@Component
public class RoleResourceAssembler implements ResourceAssembler<Role, RoleResource> {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public RoleResource toResource(Role role) {
        long roleId=role.getId();
        RoleResource roleResource=new RoleResource(role);
        try {
            roleResource.add(linkTo(methodOn(RoleController.class).getRoleById(roleId)).withSelfRel());
            roleResource.add(linkTo(methodOn(RoleController.class).getRolePrivileges(roleId)).withRel("privilages"));

        } catch (ResourceNotFoundException e) {
            logger.error(e.getMessage(),e);
        }
        return roleResource;
    }
}
