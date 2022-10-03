package retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.net.URI;

public class ConnectionTestApiCaller {
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/";

    public static ConnectionTestApi getApiService() {
        return getInstance().create(ConnectionTestApi.class);
    }

    private static Retrofit getInstance() {
        Gson gson = new GsonBuilder()
                .setLenient().create();

        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

}
