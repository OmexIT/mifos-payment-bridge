package com.omexit.mifospaymentbridge.mifos.api;

import com.omexit.mifospaymentbridge.mifos.domain.client.Client;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by aomeri on 4/5/17.
 *
 * Provides REST client for Mifos Clients using Retrofit
 */
public interface ClientInterface {

    /**
     * Search client information using client ID
     *
     * @param clientId Client ID
     * @param tenantIdentifier Mifos Tenant Identifier
     * @param isPretty Flag whether to format JSON
     * @return
     */
    @GET("clients/{clientId}")
    Call<Client> getClientById(@Path("clientId") Long clientId,
                               @Query("tenantIdentifier") String tenantIdentifier,
                               @Query("pretty") boolean isPretty);

    /**
     * Search client information using client ID
     *
     * @param clientId Client ID
     * @param tenantIdentifier Mifos Tenant Identifier
     * @param isPretty Flag whether to format JSON
     * @param fields Specifies the fields you want in the result set
     * @return
     */
    @GET("clients/{clientId}")
    Call<Client> getClientById(@Path("clientId") Long clientId,
                               @Query("tenantIdentifier") String tenantIdentifier,
                               @Query("pretty") boolean isPretty,
                               @Query("fields") String fields);
}
