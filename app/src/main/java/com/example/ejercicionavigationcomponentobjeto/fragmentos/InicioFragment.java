package com.example.ejercicionavigationcomponentobjeto.fragmentos;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ejercicionavigationcomponentobjeto.Persona;
import com.example.ejercicionavigationcomponentobjeto.R;

//Creamos la clase InicioFragmento que extiende de Fragment que representa una interfaz particular
// que se ejecuta dentro de un Activity
public class InicioFragment extends Fragment {

    public InicioFragment() {
        // Required empty public constructor
    }

    //Método llamado para que el fragmento cree una instancia de su vista de interfaz de usuario
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_inicio, container, false);
    }

    //Método que se llama justo después que el anterior, haya regresado, pero antes de que se haya
    //restaurado cualquier estado guardado en la vista
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Declaramos las siguientes variables de cada componente para que encuentre ese componente
        //en la vista
        final NavController navController = Navigation.findNavController(view);
        final EditText ed1 = view.findViewById(R.id.edNombre);
        final EditText ed2 = view.findViewById(R.id.edApellidos);
        final EditText ed3 = view.findViewById(R.id.edTelefono);
        final Button boton = view.findViewById(R.id.btSegundaPantalla);

        //Definimos un escuchador mediante el método setOnClickListener que esta asociado al boton
        //con su vista, cuando se pulsa el botón, comento línea a línea
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Si los editText en la vista están vacíos, nos muestra un aviso con el texto
                //introducido, sino lo que hace es guardar en un objeto persona nuevo los
                //editText de la vista puesto que son los atributos del objeto persona
                if (ed1.getText().toString().isEmpty() || ed2.getText().toString().isEmpty() ||
                ed3.getText().toString().isEmpty()) {
                    Toast.makeText(getContext(), "Debes introducir valores en todos los campos",
                            Toast.LENGTH_SHORT).show();
                } else {
                    //Creamos un objeto persona, capturando los valores de los EditText
                    Persona registro = new Persona(ed1.getText().toString(), ed2.getText().toString(),
                            Integer.parseInt(ed3.getText().toString()));

                    //Creamos un objeto de tipo Bundle en el que guardamos el objeto persona que queremos
                    //mandar a la siguiente activity
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("persona", registro);

                    //Navegamos a un destino desde el gráfico de navegación actual y mandando el bundle
                    navController.navigate(R.id.action_inicioFragment_to_segundoFragment, bundle);
                }
            }
        });
    }
}