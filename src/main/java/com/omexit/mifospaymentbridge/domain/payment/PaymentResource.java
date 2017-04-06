package com.omexit.mifospaymentbridge.domain.payment;

import org.springframework.hateoas.Resource;

/**
 * Created by aomeri on 3/25/17.
 */
public class PaymentResource extends Resource<Payment> {
    public PaymentResource(Payment content) {
        super(content);
    }
}
