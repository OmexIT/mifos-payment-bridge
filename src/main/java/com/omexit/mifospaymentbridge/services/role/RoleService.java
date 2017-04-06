package com.omexit.mifospaymentbridge.services.role;

import com.omexit.mifospaymentbridge.domain.role.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author Antony Ezekiel Omeri
 */
public interface RoleService {
    Page<Role> findAll(Pageable pageable);

    Role findRoleById(Long id);

    Role create(Role role);

    Role update(Role role);

    void delete(Long id);
}
