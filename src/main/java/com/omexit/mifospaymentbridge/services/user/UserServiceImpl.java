package com.omexit.mifospaymentbridge.services.user;

import com.omexit.mifospaymentbridge.domain.privilage.Privilege;
import com.omexit.mifospaymentbridge.domain.user.User;
import com.omexit.mifospaymentbridge.repository.UserRepository;
import com.omexit.mifospaymentbridge.domain.role.Role;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by aomeri on 7/26/15.
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private PasswordEncoder passwordEncoder;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder();
    }

    public Collection<User> findAll() {
        return userRepository.findAll();
    }


    public User findUserById(Long userId) {
        return userRepository.findById(userId);
    }

    @Transactional
    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Transactional
    public User findByUsernameCaseInsensitive(String username) {
        return userRepository.findByUsernameCaseInsensitive(username);
    }

    public User create(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return userRepository.save(user);
    }

    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    public User update(User user) {
        return userRepository.save(user);
    }


    public void delete(Long id) {
        userRepository.delete(id);
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("loadUserByUsername({}).", username);
        User user = findByUsernameCaseInsensitive(username);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("User with username: %s not found!", username));
        }
        logger.info("loadUserByUsername({}) - {}.", username, user.toString());
        UserDetailsService detailsService= new UserDetailsService(user);

        logger.info("UserDetailsService({}).", detailsService.toString());
        return detailsService;
    }


    private static class UserDetailsService extends User implements UserDetails {

        private static final long serialVersionUID = 1L;
        protected Logger logger = LoggerFactory.getLogger(this.getClass());

        User user;

        UserDetailsService(User user) {
            super(user);
            this.user = user;
            logger.debug("UserDetailsService({})", user.toString());
            logger.debug("isAccountNonLocked - {}",user.isEnabled());
            logger.debug("isAccountNonExpired - {}",!user.isAccountExpired());
            logger.debug("isCredentialsNonExpired - {}",!user.isCredentialsExpired());
        }

        public Collection<? extends GrantedAuthority> getAuthorities() {
            logger.info("Creating user granted authorities ...");
            List<Role> roles=user.getRoles();

            return getGrantedAuthorities(getPrivileges(roles));
        }


        private List<String> getPrivileges(Collection<Role> roles) {
            List<String> privileges = new ArrayList<>();
            List<Privilege> collection = new ArrayList<>();
            for (Role role : roles) {
                collection.addAll(role.getPrivileges());
            }
            for (Privilege item : collection) {
                privileges.add(item.getName());
            }
            return privileges;
        }

        private List<GrantedAuthority> getGrantedAuthorities(List<String> privileges) {
            List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
            for (String privilege : privileges) {
                authorities.add(new SimpleGrantedAuthority(privilege));
            }
            return authorities;
        }

        @Override
        public boolean isAccountNonExpired() {
            return !user.isAccountExpired();
        }

        @Override
        public boolean isAccountNonLocked() {
            return user.isEnabled();
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return !user.isCredentialsExpired();
        }

    }


}
