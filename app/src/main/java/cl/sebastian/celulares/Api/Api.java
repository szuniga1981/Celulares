package cl.sebastian.celulares.Api;



import java.util.List;

import cl.sebastian.celulares.model.Producto;
import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    @GET("products")
    Call<List<Producto>> getAllProducts();

}
