package cl.sebastian.celulares.viewModel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import cl.sebastian.celulares.Api.RetrofitClient;
import cl.sebastian.celulares.model.Producto;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class TelefonosViewModel extends ViewModel {
    private static final String TAG = "ViewModel";
    private MutableLiveData<List<Producto>> listaProducto = new MutableLiveData<>();

    public LiveData<List<Producto>> getListaProducto() {
        return listaProducto;
    }

    // se comunica con el modelo para obtener datos
    //se comunica con la vista para que haga algo con estos datos
    public void loadInfo(){
        Log.d(TAG, "loadInfo: Ocupando loadInfo ");
        //usando Retrofit(deben modificarse unos detalles en el retrofitclient
        RetrofitClient.getRetrofitInstance().getAllProducts().enqueue(new Callback<List<Producto>>() {
            @Override
            public void onResponse(Call<List<Producto>> call, Response<List<Producto>> response) {
                Log.d(TAG, "onResponse: obteniendo list<Producto<"+response.body());
                listaProducto.setValue(response.body());

            }

            @Override
            public void onFailure(Call<List<Producto>> call, Throwable t) {
                Log.d(TAG, "onFailure: "+t.toString());

            }
        });

    }
}
