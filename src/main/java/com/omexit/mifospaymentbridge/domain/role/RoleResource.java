package com.omexit.mifospaymentbridge.domain.role;

import com.omexit.mifospaymentbridge.domain.role.Role;
import org.springframework.hateoas.Resource;

/**
 * Created by aomeri on 3/24/17.
 */
public class RoleResource extends Resource<Role> {
    public RoleResource(Role content) {
        super(content);
    }
}
