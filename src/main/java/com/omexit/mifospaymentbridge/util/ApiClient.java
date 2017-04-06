package com.omexit.mifospaymentbridge.util;

import org.springframework.stereotype.Component;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

@Component
public class ApiClient {

    private static Retrofit retrofit = null;

    public static Retrofit getClient(String url, String token) {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(JacksonConverterFactory.create())
                    .client(HttpClientHelper.getUnsafeOkHttpClientToken(token))
                    .build();
        }
        return retrofit;
    }

    public static Retrofit getClient(String url, String clientId, String clientPassword) {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(JacksonConverterFactory.create())
                    .client(HttpClientHelper.getUnsafeOkHttpClientUsernameAndPassword(clientId, clientPassword))
                    .build();
        }
        return retrofit;
    }
}