package com.omexit.mifospaymentbridge.mifos;

import com.omexit.mifospaymentbridge.mifos.domain.client.Client;
import com.omexit.mifospaymentbridge.mifos.domain.savingsaccount.deposit.SavingsAccountDepositRequest;
import com.omexit.mifospaymentbridge.mifos.domain.savingsaccount.deposit.SavingsAccountDepositResponse;
import com.omexit.mifospaymentbridge.mifos.domain.savingsaccount.transaction.SavingsAccountTransaction;
import com.omexit.mifospaymentbridge.mifos.domain.savingsaccount.withdraw.SavingsAccountWithdrawRequest;
import com.omexit.mifospaymentbridge.mifos.domain.savingsaccount.withdraw.SavingsAccountWithdrawResponse;

import java.io.IOException;

/**
 * Created by aomeri on 4/5/17.
 */
public interface MifosService {
    public Client getClientByID(Long clientId, String tenantIdentifier, boolean isPretty) throws IOException;

    public Client getClientByID(Long clientId, String tenantIdentifier, boolean isPretty, String fields) throws IOException;

    public SavingsAccountDepositResponse depositSavingsAccountDeposit(Long accountsId, SavingsAccountDepositRequest depositRequest, boolean isPretty, String tenantIdentifier) throws IOException;

    public SavingsAccountWithdrawResponse withdrawSavingsAccountDeposit(Long accountsId, SavingsAccountWithdrawRequest withdrawRequest, boolean isPretty, String tenantIdentifier) throws IOException;

    public SavingsAccountTransaction getSavingsAccountTransaction(Long accountsId, Long transactionId, boolean isPretty, String tenantIdentifier) throws IOException;
}
