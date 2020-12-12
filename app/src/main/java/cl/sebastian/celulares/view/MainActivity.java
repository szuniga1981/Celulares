package cl.sebastian.celulares.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import cl.sebastian.celulares.R;
import cl.sebastian.celulares.viewModel.TelefonosViewModel;


/*
 *********Requerimientos***************
 * MVVM
 * consumo de API http://my-json-server.typicode.com/Himuravidal/FakeAPIdata/
 * Livedata
 * ViewBinding
 * ReciclerView
 * Glide
 * Test Unitarios
 *
 * Lista de tareas
 * []crear y subir a GIthub
 * [] Adapter
 *1. [x]Retrofit (retrofitclient,api interfase(@GET), añadir los permisos de internet
 * []Activar viewBinding e implementar
 * 2.[x]POJO
 *   []lista
 *   [x]detalle
 * []Layout
 *   []layout lista
 *   []detalle
 *   []elemento
 * []Implementar Adapter y Recyclerview
 * []Test Unitarios a modelo y Viewmodel
 * []Crear clase Viewmodel
 *
 */
public class MainActivity extends AppCompatActivity {
    TelefonosViewModel viewModel;// se agrega la instancia para que el main activity pueda ver el viewmodel(TelefonosViewModel)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewModel = new ViewModelProvider(this).get(TelefonosViewModel.class);
        viewModel.loadInfo();// se agrega loadinfo del viewModel
        getSupportFragmentManager().beginTransaction().add(R.id.frameLayout, ListFragment.newInstance("","")).commit();

    }
}