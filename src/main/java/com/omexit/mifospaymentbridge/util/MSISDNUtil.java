package com.omexit.mifospaymentbridge.util;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;
import com.omexit.mifospaymentbridge.exception.ValidationException;
import com.omexit.mifospaymentbridge.types.ReasonCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by aomeri on 3/13/17.
 */
public class MSISDNUtil {
    private static Logger logger = LoggerFactory.getLogger(MSISDNUtil.class);

    /***
     *
     * @param phoneNumber
     * @param defaultRegion
     * @return
     * @throws NumberParseException
     * @throws ValidationException
     */
    public static String getE164FormatShort(String phoneNumber, String defaultRegion) throws NumberParseException, ValidationException {
        PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();
        Phonenumber.PhoneNumber numberProto = phoneUtil.parse(phoneNumber, defaultRegion);
        if (!phoneUtil.isValidNumber(numberProto)) {
            throw new ValidationException(String.format("Phone number: %s is not valid!", phoneNumber), "Not a valid phone number", ReasonCode.INVALID_PHONE_NUMBER);
        }
        String e164 = phoneUtil.format(numberProto, PhoneNumberUtil.PhoneNumberFormat.E164);
        return e164.substring(1);
    }

    /***
     *
     * @param phoneNumber
     * @param defaultRegion
     * @return
     * @throws NumberParseException
     * @throws ValidationException
     */
    public static String getE164Format(String phoneNumber, String defaultRegion) throws NumberParseException, ValidationException {
        PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();
        Phonenumber.PhoneNumber numberProto = phoneUtil.parse(phoneNumber, defaultRegion);
        if (!phoneUtil.isValidNumber(numberProto)) {
            throw new ValidationException(String.format("Phone number: %s is not valid!", phoneNumber), "Not a valid phone number", ReasonCode.INVALID_PHONE_NUMBER);
        }
        return phoneUtil.format(numberProto, PhoneNumberUtil.PhoneNumberFormat.E164);
    }

    /***
     *
     * @param phoneNumber
     * @param defaultRegion
     * @return
     */
    public static boolean isValidNumber(String phoneNumber, String defaultRegion) {
        boolean isValidNumber = false;
        PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();
        try {
            Phonenumber.PhoneNumber numberProto = phoneUtil.parse(phoneNumber, defaultRegion);
            isValidNumber = phoneUtil.isValidNumber(numberProto);
        } catch (NumberParseException e) {
            logger.error(e.getMessage());
        }
        logger.info("isValidNumber({}, {})", phoneNumber, defaultRegion);
        return isValidNumber;
    }
}
