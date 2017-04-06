package com.omexit.mifospaymentbridge.mifos.api;

import com.omexit.mifospaymentbridge.mifos.domain.savingsaccount.deposit.SavingsAccountDepositRequest;
import com.omexit.mifospaymentbridge.mifos.domain.savingsaccount.deposit.SavingsAccountDepositResponse;
import com.omexit.mifospaymentbridge.mifos.domain.savingsaccount.transaction.SavingsAccountTransaction;
import com.omexit.mifospaymentbridge.mifos.domain.savingsaccount.withdraw.SavingsAccountWithdrawRequest;
import com.omexit.mifospaymentbridge.mifos.domain.savingsaccount.withdraw.SavingsAccountWithdrawResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by aomeri on 4/6/17.
 */
public interface SavingsAccountInterface {
    @GET("savingsaccounts/{accountsId}/transactions?command=deposit")
    Call<SavingsAccountDepositResponse> deposit(@Path("accountsId") Long accountsId,
                                                @Body SavingsAccountDepositRequest depositRequest,
                                                @Query("pretty") boolean isPretty,
                                                @Query("tenantIdentifier") String tenantIdentifier);

    @GET("savingsaccounts/{accountsId}/transactions?command=withdraw")
    Call<SavingsAccountWithdrawResponse> withdraw(@Path("accountsId") Long accountsId,
                                                  @Body SavingsAccountWithdrawRequest withdrawRequest,
                                                  @Query("pretty") boolean isPretty,
                                                  @Query("tenantIdentifier") String tenantIdentifier);

    @GET("savingsaccounts/{accountsId}/transactions/transactions/{transactionId}")
    Call<SavingsAccountTransaction> getTransaction(@Path("accountsId") Long accountsId,
                                                   @Path("transactionId") Long transactionId,
                                                   @Query("pretty") boolean isPretty,
                                                   @Query("tenantIdentifier") String tenantIdentifier);
}
