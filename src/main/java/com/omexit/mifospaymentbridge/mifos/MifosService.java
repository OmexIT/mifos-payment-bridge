package com.omexit.mifospaymentbridge.mifos;

import com.omexit.mifospaymentbridge.mifos.domain.client.Client;

import java.io.IOException;

/**
 * Created by aomeri on 4/5/17.
 */
public interface MifosService {
    public Client getClientByID(Long clientId, String tenantIdentifier, boolean isPretty) throws IOException;

    public Client getClientByID(Long clientId, String tenantIdentifier, boolean isPretty, String fields) throws IOException;
}
