package com.omexit.mifospaymentbridge.mifos;

import com.omexit.mifospaymentbridge.mifos.api.ClientInterface;
import com.omexit.mifospaymentbridge.mifos.api.SavingsAccountInterface;
import com.omexit.mifospaymentbridge.mifos.domain.client.Client;
import com.omexit.mifospaymentbridge.mifos.domain.savingsaccount.deposit.SavingsAccountDepositRequest;
import com.omexit.mifospaymentbridge.mifos.domain.savingsaccount.deposit.SavingsAccountDepositResponse;
import com.omexit.mifospaymentbridge.mifos.domain.savingsaccount.transaction.SavingsAccountTransaction;
import com.omexit.mifospaymentbridge.mifos.domain.savingsaccount.withdraw.SavingsAccountWithdrawRequest;
import com.omexit.mifospaymentbridge.mifos.domain.savingsaccount.withdraw.SavingsAccountWithdrawResponse;
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
    private SavingsAccountInterface savingsAccountInterface = null;

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
        } else {
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
        Response<Client> response = call.execute();
        boolean isSuccessful = response.isSuccessful();
        int code = response.code();
        if (isSuccessful) {
            client = response.body();
            if (client != null) {
                logger.info("- getClientByID({},{},{},{}) :Response [isSuccessful: {}, code: {}, client: {}]", clientId, tenantIdentifier, isPretty, fields, isSuccessful, code, client);
            }
        } else {
            ResponseBody errorResponse = response.errorBody();
            if (errorResponse != null) {
                logger.info("- getClientByID({},{},{}, {}) :Response [isSuccessful: {}, code: {}, error: {}]", clientId, tenantIdentifier, isPretty, fields, isSuccessful, code, errorResponse.string());
            }
        }
        return client;
    }

    @Override
    public SavingsAccountDepositResponse depositSavingsAccountDeposit(Long accountsId, SavingsAccountDepositRequest depositRequest, boolean isPretty, String tenantIdentifier) throws IOException {
        SavingsAccountDepositResponse depositResponse = null;
        Call<SavingsAccountDepositResponse> call = savingsAccountInterface.deposit(accountsId, depositRequest, isPretty, tenantIdentifier);
        Response<SavingsAccountDepositResponse> response = call.execute();
        boolean isSuccessful = response.isSuccessful();
        int code = response.code();
        if (isSuccessful) {
            depositResponse = response.body();
            if (depositResponse != null) {
                logger.info("- depositSavingsAccountDeposit({}, {}, {}, {}) :Response [isSuccessful: {}, code: {}, depositResponse: {}]", accountsId, depositRequest, isPretty, tenantIdentifier, isSuccessful, code, depositResponse);
            } else {
                ResponseBody errorResponse = response.errorBody();
                if (errorResponse != null) {
                    logger.info("- depositSavingsAccountDeposit({}, {}, {}, {}) :Response [isSuccessful: {}, code: {}, error: {}]", accountsId, depositRequest, isPretty, tenantIdentifier, isSuccessful, code, errorResponse.string());
                }
            }
        } else {
            ResponseBody errorResponse = response.errorBody();
            if (errorResponse != null) {
                logger.info("- depositSavingsAccountDeposit({}, {}, {}, {}) :Response [isSuccessful: {}, code: {}, error: {}]", accountsId, depositRequest, isPretty, tenantIdentifier, isSuccessful, code, errorResponse.string());
            }
        }
        return depositResponse;
    }

    @Override
    public SavingsAccountWithdrawResponse withdrawSavingsAccountDeposit(Long accountsId, SavingsAccountWithdrawRequest withdrawRequest, boolean isPretty, String tenantIdentifier) throws IOException {
        SavingsAccountWithdrawResponse withdrawResponse = null;
        Call<SavingsAccountWithdrawResponse> call = savingsAccountInterface.withdraw(accountsId, withdrawRequest, isPretty, tenantIdentifier);
        Response<SavingsAccountWithdrawResponse> response = call.execute();
        boolean isSuccessful = response.isSuccessful();
        int code = response.code();
        if (isSuccessful) {
            withdrawResponse = response.body();
            if (withdrawResponse != null) {
                logger.info("- withdrawSavingsAccountDeposit({}, {}, {}, {}) :Response [isSuccessful: {}, code: {}, withdrawResponse: {}]", accountsId, withdrawRequest, isPretty, tenantIdentifier, isSuccessful, code, withdrawResponse);

            } else {
                ResponseBody errorResponse = response.errorBody();
                if (errorResponse != null) {
                    logger.info("- depositSavingsAccountDeposit({}, {}, {}, {}) :Response [isSuccessful: {}, code: {}, error: {}]", accountsId, withdrawRequest, isPretty, tenantIdentifier, isSuccessful, code, errorResponse.string());
                }
            }
        } else {
            ResponseBody errorResponse = response.errorBody();
            if (errorResponse != null) {

            }
        }
        return withdrawResponse;
    }

    @Override
    public SavingsAccountTransaction getSavingsAccountTransaction(Long accountsId, Long transactionId, boolean isPretty, String tenantIdentifier) throws IOException {
        SavingsAccountTransaction accountTransaction = null;
        Call<SavingsAccountTransaction> call = savingsAccountInterface.getTransaction(accountsId, transactionId, isPretty, tenantIdentifier);
        Response<SavingsAccountTransaction> response = call.execute();
        boolean isSuccessful = response.isSuccessful();
        int code = response.code();
        if (isSuccessful) {
            accountTransaction = response.body();
            if (accountTransaction != null) {
                logger.info("- withdrawSavingsAccountDeposit({}, {}, {}, {}) :Response [isSuccessful: {}, code: {}, accountTransaction: {}]", accountsId, transactionId, isPretty, tenantIdentifier, isSuccessful, code, accountTransaction);
            } else {
                ResponseBody errorResponse = response.errorBody();
                if (errorResponse != null) {
                    logger.info("- getSavingsAccountTransaction({}, {}, {}, {}) :Response [isSuccessful: {}, code: {}, error: {}]", accountsId, transactionId, isPretty, tenantIdentifier, isSuccessful, code, errorResponse.string());
                }
            }
        }else {
            ResponseBody errorResponse = response.errorBody();
            if (errorResponse != null) {
                logger.info("- getSavingsAccountTransaction({}, {}, {}, {}) :Response [isSuccessful: {}, code: {}, error: {}]", accountsId, transactionId, isPretty, tenantIdentifier, isSuccessful, code, errorResponse.string());
            }
        }
        return accountTransaction;
    }
}
