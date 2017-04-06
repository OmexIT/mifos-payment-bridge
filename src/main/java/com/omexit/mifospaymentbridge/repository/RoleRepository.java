package com.omexit.mifospaymentbridge.repository;

import com.omexit.mifospaymentbridge.domain.role.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by omexic on 6/14/2015.
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
