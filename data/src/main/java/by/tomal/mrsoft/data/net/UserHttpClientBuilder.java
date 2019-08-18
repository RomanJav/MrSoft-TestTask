package by.tomal.mrsoft.data.net;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

class UserHttpClientBuilder {

    static OkHttpClient getHttpClient() {
        return new OkHttpClient.Builder().connectTimeout(5, TimeUnit.SECONDS).build();
    }
}
