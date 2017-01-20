package itesm.mx.a01328426_laboratoriobienvenida;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String MENSAJE_KEY = "" ;
    private Button btnSaludar;
    private TextView tvMensaje;
    private EditText etNombre;

    //Declarar las variables de los objetos diseñados en la interface


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNombre = (EditText) findViewById(R.id.edit_Nombre);
        tvMensaje = (TextView) findViewById(R.id.text_mensaje_saludo);
        btnSaludar = (Button) findViewById(R.id.button_saludar);


        //Implementar listener para el botón
        View.OnClickListener onClick = new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                String nombre = etNombre.getText().toString();
                String mensaje = getResources().getString(R.string.mensaje_bienvenida_1) +
                        " " + nombre + " " +
                        getResources().getString(R.string.mensaje_bienvenida_2);
                tvMensaje.setText(mensaje);



            }

        };

        //Si existen datos guardados
        if(savedInstanceState != null){
            //Restaura los valores del estado anterior
            tvMensaje.setText(savedInstanceState.getString(MENSAJE_KEY));
        }

        btnSaludar.setOnClickListener(onClick);

    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        //Almacenar el estado de los datos
        savedInstanceState.putString(MENSAJE_KEY, tvMensaje.getText().toString());
        super.onSaveInstanceState(savedInstanceState);

    }

}
