package ro.sapi.retrofitstudents;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static Retrofit retrofit;
    //private static final String BASE_URL = "https://jsonplaceholder.typicode.com";
    //sprivate static final String BASE_URL = "http://10.0.2.2/laravel/api/studentsapi/public/api/";
    //private static final String BASE_URL = "http://10.0.2.2/laravel/oktatas/sapistudents4_m/public/api/";
    private static final String BASE_URL = "http://192.168.0.4/laravel/oktatas/todo/public/api/";

    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

}
