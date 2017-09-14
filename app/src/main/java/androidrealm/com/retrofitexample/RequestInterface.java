package androidrealm.com.retrofitexample;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;


public interface RequestInterface {
    @GET("categories/4/products")
    Call<List<ProductResponse>> getJSON();

}
