package com.softulp.tp2lunes23.ui;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.softulp.tp2lunes23.R;
import com.softulp.tp2lunes23.databinding.ActivityMainBinding;
import com.softulp.tp2lunes23.modelo.Inmueble;

import java.util.List;

public class MainActivity extends AppCompatActivity {
private ActivityMainBinding binding;
private MainActivityViewModel mv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        mv= ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainActivityViewModel.class);
        mv.getInmuebleMutable().observe(this, new Observer<List<Inmueble>>() {
            @Override
            public void onChanged(List<Inmueble> inmuebles) {
                InmuebleAdapter2 ia=new InmuebleAdapter2(MainActivity.this,R.layout.item,inmuebles);
                ListView lv=binding.lista;
                lv.setAdapter(ia);
            }
        });

        mv.crearLista();

    }
}