package ro.sapi.retrofitpost;

public class ApiUtils {

    private ApiUtils() {}

    //public static final String BASE_URL = "http://jsonplaceholder.typicode.com/";
    public static final String BASE_URL = "http://192.168.0.3/androidlogin/";

    public static APIService getAPIService() {

        return RetrofitClient.getClient(BASE_URL).create(APIService.class);
    }
}