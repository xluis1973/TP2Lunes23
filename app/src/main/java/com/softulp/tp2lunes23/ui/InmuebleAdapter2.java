package com.softulp.tp2lunes23.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.softulp.tp2lunes23.R;
import com.softulp.tp2lunes23.databinding.Item2Binding;
import com.softulp.tp2lunes23.databinding.ItemBinding;
import com.softulp.tp2lunes23.modelo.Inmueble;

import java.util.List;

public class InmuebleAdapter2 extends ArrayAdapter<Inmueble> {
    private List<Inmueble> listadoDeInmuebles;
    private Context context;
    private int itemAMostrar;

    private LayoutInflater li;

    private ItemBinding binding;

    public InmuebleAdapter2(@NonNull Context context, int item, @NonNull List<Inmueble> listaInmueble){
        super(context,item,listaInmueble);
        this.listadoDeInmuebles=listaInmueble;
        this.context=context;
        this.li=LayoutInflater.from(context);
        this.itemAMostrar=item;

    }

    @NonNull
    @Override
    public View getView(int position, @NonNull View itemView, @NonNull ViewGroup parent) {

        if(itemView==null){
            binding=ItemBinding.inflate(li,parent,false);
            itemView=binding.getRoot();
            itemView.setTag(binding);
        }else{
            binding=(ItemBinding) itemView.getTag();
        }
        Inmueble inmueble=listadoDeInmuebles.get(position);
        binding.direccion.setText(inmueble.getDireccion());
        binding.precio.setText(inmueble.getPrecio()+"");
        binding.foto.setImageResource(inmueble.getFoto());


        return itemView;
    }

    public int getCount(){
        return listadoDeInmuebles.size();
    }
}
