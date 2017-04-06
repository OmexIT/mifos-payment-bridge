package com.omexit.mifospaymentbridge.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Antony Omeri
 */
public abstract class BaseController {

    public Logger logger = LoggerFactory.getLogger(this.getClass());

    public static final int REST_DEFAULT_PAGE_SIZE = 200;
    public static final int REST_DEFAULT_PAGE = 0;

    public static final String API_PATH = "/api/v1";
    //User URL
    public static final String USER_URL = "/user";
    public static final String GET_USER_URL = "/user/{userId}";
    public static final String UPDATE_USER_URL = "/user/{userId}";
    public static final String GET_USER_BY_USERNAME_URL = "/user/{username}/getByUsername";
    //Channel URL
    public static final String CHANNEL_URL = "/channel";
    public static final String GET_CHANNEL_URL = "/channel/{channelId}";
    public static final String GET_CHANNEL_PAYMENT_URL = "/channel/{channelId}/payment";
    //Payment URL
    public static final String PAYMENT_URL = "/payment";
    public static final String GET_PAYMENT_URL = "/payment/{paymentId}";
    public static final String UPDATE_PAYMENT_URL = "/payment/{paymentId}";
    //Role URL
    public static final String ROLE_URL = "/role";
    public static final String GET_ROLE_URL = "/role/{roleId}";
    public static final String UPDATE_ROLE_URL = "/role/{roleId}";
    public static final String GET_ROLE_PRIVILEGES_URL = "/role/{roleId}/privilege";
    //Privilage URL
    public static final String PRIVILEGE_URL = "/privilege";
    public static final String GET_PRIVILEGE_URL = "/privilege/{privilageId}";
    public static final String UPDATE_PRIVILEGE_URL = "/privilege/{privilageId}";
}
