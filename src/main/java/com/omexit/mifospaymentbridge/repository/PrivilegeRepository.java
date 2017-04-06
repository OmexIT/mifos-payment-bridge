package com.omexit.mifospaymentbridge.repository;

import com.omexit.mifospaymentbridge.domain.privilage.Privilege;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by aomeri on 9/3/16.
 */
@Repository
public interface PrivilegeRepository extends JpaRepository<Privilege, Long> {
    Privilege findByName(String name);

}
