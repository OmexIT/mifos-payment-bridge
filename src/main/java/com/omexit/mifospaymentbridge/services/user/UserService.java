package com.omexit.mifospaymentbridge.services.user;

import com.omexit.mifospaymentbridge.domain.user.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Collection;

/**
 * @author Antony Ezekiel Omeri
 */

public interface UserService extends UserDetailsService {
    Collection<User> findAll();

    User findUserById(Long id);

    User create(User user);

    User update(User user);

    void delete(Long id);

    User findUserByUsername(String username);

    User findByUsernameCaseInsensitive(String username);
}
