package com.melardev.android.crud.datasource.remote.interceptors;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class HttpRequestsInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request originalRequest = chain.request();

        // Adding Authorization Header
        // Request newRequest = originalRequest.newBuilder().addHeader("Authorization", "Bearer ....").build();

        /* Adding Access token as query parameter
        HttpUrl originalUrl = originalRequest.url();
        HttpUrl url = originalUrl.newBuilder()
                .addQueryParameter("access_token", ".......")
                .build();

        Request.Builder requestBuilder = originalRequest.newBuilder().url(url);
        Request newRequest = requestBuilder.build();
        */
        return chain.proceed(originalRequest);
    }
}
