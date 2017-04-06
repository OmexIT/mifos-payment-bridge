package com.omexit.mifospaymentbridge.mifos.api;

import com.omexit.mifospaymentbridge.mifos.domain.client.Client;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by aomeri on 4/5/17.
 */
public interface ClientInterface {
    @GET("clients/{clientId}")
    Call<Client> getClientById(@Path("clientId") Long clientId,
                               @Query("tenantIdentifier") String tenantIdentifier,
                               @Query("pretty") boolean isPretty);

    @GET("clients/{clientId}")
    Call<Client> getClientById(@Path("clientId") Long clientId,
                               @Query("tenantIdentifier") String tenantIdentifier,
                               @Query("pretty") boolean isPretty,
                               @Query("fields") String fields);
}
