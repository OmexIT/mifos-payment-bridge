package com.omexit.mifospaymentbridge.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import javax.sql.DataSource;

/**
 * Since the "me" endpoint needs to be protected to be accessed only after the
 * OAuth2 authentication is successful; the server also becomes a resource
 * server.
 *
 * @author anilallewar
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

    private static final String CSRF_COOKIE_NAME = "XSRF-TOKEN";
    private static final String CSRF_ANGULAR_HEADER_NAME = "X-XSRF-TOKEN";

    @Autowired
    private DataSource dataSource;

    @Bean
    public JdbcTokenStore tokenStore() {
        return new JdbcTokenStore(dataSource);
    }

    /**
     * Configure security to allow access to the /me endpoint only if the OAuth
     * authorization returns "read" scope.<br>
     * <br>
     * <p>
     * If you look at
     * {@link OAuthConfiguration#configure(org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer)}
     * to check that by default the authorization server allows "read" scope
     * only.
     */
    @Override
    public void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/v1/payment-hook", "/v1/payment-hook/").permitAll()
                .and()
                .authorizeRequests().anyRequest().authenticated()
                .and()
                .csrf().disable();
        ;
        // @formatter:off
//        http.authorizeRequests()
//                .antMatchers("/externalApi/v1/payment-hook").permitAll()
//                .and()
//                .requestMatchers().antMatchers("/me")
//                .and()
//                .authorizeRequests()
//                .antMatchers("/me").access("#oauth2.hasScope('read')")
//                .and()
//                .authorizeRequests()
//                .anyRequest().authenticated();
        // @formatter:on
    }

    /**
     * Id of the resource that you are letting the client have access to.
     * Supposing you have another externalApi ("say api2"), then you can customize the
     * access within resource server to define what externalApi is for what resource id.
     * <br>
     * <br>
     * <p>
     * So suppose you have 2 APIs, then you can define 2 resource servers.
     * <ol>
     * <li>Client 1 has been configured for access to resourceid1, so he can
     * only access "api1" if the resource server configures the resourceid to
     * "api1".</li>
     * <li>Client 1 can't access resource server 2 since it has configured the
     * resource id to "api2"
     * </li>
     * </ol>
     */
    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.tokenStore(tokenStore())
                .resourceId("apis");
    }

//    private static class OAuthRequestedMatcher implements RequestMatcher {
//        public boolean matches(HttpServletRequest request) {
//            String auth = request.getHeader("Authorization");
//            // Determine if the client request contained an OAuth Authorization
//            boolean haveOauth2Token = (auth != null) && auth.startsWith("Bearer");
//            boolean haveAccessToken = request.getParameter("access_token") != null;
//            return haveOauth2Token || haveAccessToken;
//        }
//    }
}