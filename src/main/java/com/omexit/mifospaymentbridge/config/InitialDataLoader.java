package com.omexit.mifospaymentbridge.config;

import com.omexit.mifospaymentbridge.domain.privilage.Privilege;
import com.omexit.mifospaymentbridge.domain.role.Role;
import com.omexit.mifospaymentbridge.domain.user.User;
import com.omexit.mifospaymentbridge.repository.PrivilegeRepository;
import com.omexit.mifospaymentbridge.repository.RoleRepository;
import com.omexit.mifospaymentbridge.services.user.UserService;
import com.omexit.mifospaymentbridge.types.IdType;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by aomeri on 9/3/16.
 */
@Component
public class InitialDataLoader implements ApplicationListener<ContextRefreshedEvent> {
    private boolean alreadySetup = false;

    private final UserService userService;
    private final RoleRepository roleRepository;

    private final PrivilegeRepository privilegeRepository;
    private org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public InitialDataLoader(PrivilegeRepository privilegeRepository,
                             UserService userService,
                             RoleRepository roleRepository) {
        this.privilegeRepository = privilegeRepository;
        this.userService = userService;
        this.roleRepository = roleRepository;
    }

    @Override
    @Transactional(value = "transactionManager")
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        logger.info("Loading data ...");
        if (alreadySetup)
            return;
        List<Privilege> adminPrivileges = new ArrayList<>();
        Privilege readPrivilege = createPrivilegeIfNotFound("READ_PRIVILEGE");
        adminPrivileges.add(readPrivilege);
        Privilege writePrivilege = createPrivilegeIfNotFound("WRITE_PRIVILEGE");
        adminPrivileges.add(writePrivilege);

        createRoleIfNotFound("ROLE_ADMIN", adminPrivileges);
        createRoleIfNotFound("ROLE_USER", Arrays.asList(readPrivilege));


        Role adminRole = roleRepository.findByName("ROLE_ADMIN");

        User user = userService.findUserByUsername("mifos");

        if (user == null) {
            user = new User();
            user.setFirstName("Antony");
            user.setLastName("Omeri");
            user.setMiddleName("Ezekiel");
            user.setPhoneNumber("76728547954");
            user.setUsername("mifos");
            user.setPassword("password");
            user.setEmail("test@test.com");
            user.setIdType(IdType.NATIONAL_ID);
            user.setIdNumber("25492841");
            user.setDesignation("Software Engineer");
            user.setRoles(Arrays.asList(adminRole));
            user.setEnabled(true);
            user.setAccountExpired(false);
            user.setCredentialsExpired(false);

            userService.create(user);
        }

        alreadySetup = true;

    }

    @Transactional(value = "transactionManager")
    private Privilege createPrivilegeIfNotFound(String name) {
        Privilege privilege = privilegeRepository.findByName(name);
        if (privilege == null) {
            privilege = new Privilege();
            privilege.setName(name);
            privilegeRepository.save(privilege);
        }
        return privilege;
    }

    @Transactional(value = "transactionManager")
    private Role createRoleIfNotFound(String name, List<Privilege> privileges) {
        Role role = roleRepository.findByName(name);
        if (role == null) {
            role = new Role();
            role.setName(name);
            role.setPrivileges(privileges);
            roleRepository.save(role);
        }
        return role;
    }
}
