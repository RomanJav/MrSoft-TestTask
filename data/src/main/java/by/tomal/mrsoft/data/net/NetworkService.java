package by.tomal.mrsoft.data.net;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkService {
    private static NetworkService networkServiceInstance;
    private static final String BASE_URL = "https://api.backendless.com/6F5DF07E-FDF1-2BD3-FF19-4EEA42398B00/39FC19A7-6FB0-409E-FFC9-89CD05F24F00/data/";
    private Retrofit retrofit;

    private NetworkService() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(UserHttpClientBuilder.getHttpClient())
                .build();
    }

    public static NetworkService getInstance() {
        if (networkServiceInstance == null) {
            networkServiceInstance = new NetworkService();
        }
        return networkServiceInstance;
    }

    public ApiRest getApi() {
        return retrofit.create(ApiRest.class);
    }
}