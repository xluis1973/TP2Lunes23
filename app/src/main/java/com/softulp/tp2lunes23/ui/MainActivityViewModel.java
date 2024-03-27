package com.softulp.tp2lunes23.ui;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.softulp.tp2lunes23.R;
import com.softulp.tp2lunes23.modelo.Inmueble;

import java.util.ArrayList;
import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {
private MutableLiveData<List<Inmueble>> inmueblesMutable;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);

    }

    public LiveData<List<Inmueble>> getInmuebleMutable(){
        if(inmueblesMutable==null){
            this.inmueblesMutable=new MutableLiveData<>();
        }
        return inmueblesMutable;
    }

    public void crearLista(){
        ArrayList<Inmueble> lista=new ArrayList<>();
        lista.add(new Inmueble("Colon 323",70000,R.drawable.casa1));
        lista.add(new Inmueble("Mitre 345",50000, R.drawable.casa2));
        lista.add(new Inmueble("Salta 1234",45000, R.drawable.casa3));
        lista.add(new Inmueble("Belgrano 812",32000, R.drawable.casa4));
        lista.add(new Inmueble("Santa Fe 402",27000, R.drawable.casa5));
        inmueblesMutable.setValue(lista);

    }
}
