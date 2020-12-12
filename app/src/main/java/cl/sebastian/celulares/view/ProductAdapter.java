package cl.sebastian.celulares.view;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import cl.sebastian.celulares.R;
import cl.sebastian.celulares.model.Producto;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductVH> {
    private static final String TAG = "ProductAdapter";
    List<Producto> listProduct; //se agrega constructor

    public LiveData<Producto> getSelected() {
        return selected;
    }

    MutableLiveData<Producto> selected= new MutableLiveData<>(); //se debe crear un getter
    Context context;


    public ProductAdapter(List<Producto> listProduct,Context context) {
        this.listProduct = listProduct;
        this.context=context;
    }

    @NonNull
    @Override
    public ProductVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false);// se infla en el layout fragment_list
        return new ProductVH(view);
    }

    @Override
    public int getItemCount() {
        return listProduct.size();// se agrega
    }

    @Override
    public void onBindViewHolder(@NonNull ProductVH holder, int position) {
        Producto p= listProduct.get(position);
        holder.bind (p);


    }

    public void updateItems(List<Producto> pListProduct){
        listProduct.clear();// lienas nuevas
        listProduct.addAll(pListProduct);// lienas nuevas
        notifyDataSetChanged();// lienas nuevas

    }

    public class  ProductVH extends RecyclerView.ViewHolder{
        private TextView tvName;// lienas nuevas
        private TextView tvId;
        private TextView tvPrice;
        private ImageView imgPhone;
        private Button btVerDetalle;




        public ProductVH(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.nameView);// lienas nuevas
            tvId = itemView.findViewById(R.id.idView);
            tvPrice= itemView.findViewById(R.id.priceView);
            imgPhone=itemView.findViewById(R.id.imageView);
            btVerDetalle=itemView.findViewById(R.id.button);

        }

        public void bind(Producto p) {
            tvName.setText(p.getName());// lienas nuevas
            tvId.setText(String.valueOf(p.getId()));
            tvPrice.setText(String.valueOf(p.getPrice()));
            Glide.with(context).load(p.getImage()).into(imgPhone);
            btVerDetalle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    selected.setValue(p);
                    //Llamar a un callback para mostar el detalle de un telefono
                    Log.d(TAG, "onClick: "+p.toString());

                }
            });
        }
    }
}
