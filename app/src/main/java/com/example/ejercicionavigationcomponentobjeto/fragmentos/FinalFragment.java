package com.example.ejercicionavigationcomponentobjeto.fragmentos;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.ejercicionavigationcomponentobjeto.R;

//Creamos la clase SegundoFragmento que extiende de Fragment que representa una interfaz particular
// que se ejecuta dentro de un Activity
public class FinalFragment extends Fragment {

    public FinalFragment() {
        // Required empty public constructor
    }

    //Método llamado para que el fragmento cree una instancia de su vista de interfaz de usuario
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_final, container, false);
    }

    //Método que se llama justo después que el anterior, haya regresado, pero antes de que se haya
    //restaurado cualquier estado guardado en la vista
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Declaramos la siguiente variable del componente para que encuentre ese componente
        //en la vista
        Button boton = view.findViewById(R.id.btVolverInicio);

        //Definimos un escuchador mediante el método setOnClickListener que esta asociado al boton
        //con su vista, cuando se pulsa el botón, navegamos a un destino desde el gráfico de
        //navegación actual
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_finalFragment_to_inicioFragment);
            }
        });
    }
}