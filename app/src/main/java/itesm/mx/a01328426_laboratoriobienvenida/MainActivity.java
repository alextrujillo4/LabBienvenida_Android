package itesm.mx.a01328426_laboratoriobienvenida;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.EditText;
import android.widget.TextView;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //Declarar las variables de los objetos diseñados en la interface
    private static final String MENSAJE_KEY = "" ;
    private Button btnSaludar;
    private Button btnCambiar;
    private TextView tvMensaje;
    private EditText etNombre;
    private ImageView ivImagen;
    int [] idImagenes;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNombre = (EditText) findViewById(R.id.edit_Nombre);
        tvMensaje = (TextView) findViewById(R.id.text_mensaje_saludo);
        btnSaludar = (Button) findViewById(R.id.button_saludar);
        btnCambiar = (Button) findViewById(R.id.button_cambiar_img);
        ivImagen = (ImageView) findViewById(R.id.image_Android);
        idImagenes = new int []{ R.drawable.android_image_01,
                R.drawable.android_image_02,
                R.drawable.android_image_03};
        btnCambiar.setOnClickListener(this);

        //Implementar listener para el botón

        //Si existen datos guardados
        if(savedInstanceState != null){
            //Restaura los valores del estado anterior
            tvMensaje.setText(savedInstanceState.getString(MENSAJE_KEY));
        }

        btnSaludar.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.button_cambiar_img:
                Random rand = new Random();
                int indiceImage = rand.nextInt(3);

                Bitmap imagen = BitmapFactory.decodeResource(getResources(), idImagenes[indiceImage]);
                imagen = Bitmap.createScaledBitmap(imagen, 200, 200, true);
                ivImagen.setImageBitmap(imagen);
                break;


            case R.id.button_saludar:
                String nombre = etNombre.getText().toString();
                String mensaje = getResources().getString(R.string.mensaje_bienvenida_1) +
                        " " + nombre + " " +
                        getResources().getString(R.string.mensaje_bienvenida_2);
                tvMensaje.setText(mensaje);
                break;

        }

    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        //Almacenar el estado de los datos
        savedInstanceState.putString(MENSAJE_KEY, tvMensaje.getText().toString());
        super.onSaveInstanceState(savedInstanceState);

    }

}
