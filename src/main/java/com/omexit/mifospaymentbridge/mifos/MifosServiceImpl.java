package com.omexit.mifospaymentbridge.mifos;

import com.omexit.mifospaymentbridge.mifos.api.ClientInterface;
import com.omexit.mifospaymentbridge.mifos.domain.client.Client;
import com.omexit.mifospaymentbridge.util.ApiClient;
import okhttp3.ResponseBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

/**
 * Created by aomeri on 4/5/17.
 */
@Service
public class MifosServiceImpl implements MifosService {
    private ClientInterface clientInterface = null;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public MifosServiceImpl(MifosProperties mifosProperties) {
        String mifosApiUrl = mifosProperties.getBaseUrl() + mifosProperties.getApiVersion();
        logger.info("Creating mifos service with baseUrl: {}", mifosApiUrl);
        clientInterface = ApiClient.getClient(mifosApiUrl, mifosProperties.getUsername(), mifosProperties.getPassword()).create(ClientInterface.class);
    }

    @Override
    public Client getClientByID(Long clientId, String tenantIdentifier, boolean isPretty) throws IOException {
        Client client = null;
        Call<Client> call = clientInterface.getClientById(clientId, tenantIdentifier, false);
        Response<Client> clientResponse = call.execute();
        boolean isSuccessful = clientResponse.isSuccessful();
        int code = clientResponse.code();
        if (isSuccessful) {
            client = clientResponse.body();
            if (client != null) {
                logger.info("- getClientByID({},{},{}) :Response [isSuccessful: {}, code: {}, client: {}]", clientId, tenantIdentifier, isPretty, isSuccessful, code, client);
            }
        }else {
            ResponseBody errorResponse = clientResponse.errorBody();
            if (errorResponse != null) {
                logger.info("- getClientByID({},{},{}) :Response [isSuccessful: {}, code: {}, error: {}]", clientId, tenantIdentifier, isPretty, isSuccessful, code, errorResponse.string());
            }
        }
        return client;
    }

    @Override
    public Client getClientByID(Long clientId, String tenantIdentifier, boolean isPretty, String fields) throws IOException {
        Client client = null;
        Call<Client> call = clientInterface.getClientById(clientId, tenantIdentifier, false, fields);
        Response<Client> clientResponse = call.execute();
        boolean isSuccessful = clientResponse.isSuccessful();
        int code = clientResponse.code();
        if (isSuccessful) {
            client = clientResponse.body();
            if (client != null) {
                logger.info("- getClientByID({},{},{},{}) :Response [isSuccessful: {}, code: {}, client: {}]", clientId, tenantIdentifier, isPretty,fields, isSuccessful, code, client);
            }
        } else {
            ResponseBody errorResponse = clientResponse.errorBody();
            if (errorResponse != null) {
                logger.info("- getClientByID({},{},{}, {}) :Response [isSuccessful: {}, code: {}, error: {}]", clientId, tenantIdentifier, isPretty,fields, isSuccessful, code, errorResponse.string());
            }
        }
        return client;
    }
}
