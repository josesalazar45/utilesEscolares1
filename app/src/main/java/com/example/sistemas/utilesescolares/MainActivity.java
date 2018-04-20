package com.example.sistemas.utilesescolares;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int[] Imagenes = {R.mipmap.cuaderno,R.mipmap.goma,R.mipmap.lapiz2,R.mipmap.regla2,R.mipmap.sacapuntas};
    int posicion=0;
    private EditText texto;
    private int correctas=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cambiarImagen();
    }

    public void cambiarImagen() {
        ImageView imagen = (ImageView) findViewById(R.id.imgRandom);
        Random numeros = new Random();
        posicion = numeros.nextInt(5);
        imagen.setImageResource(Imagenes[posicion]);
    }

    public void siguiente(View view) {
        cambiarImagen();
    }

    public void verificar(View view)
    {
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        texto=(EditText) findViewById(R.id.texto);
        String datos=texto.getText().toString();


        if(correctas==5)
        {
            Intent i=new Intent(this,felicitaciones.class);
            startActivity(i);

        }
        else
        {
            String idioma1=getResources().getString(R.string.txt1);
            String idioma2=getResources().getString(R.string.txt2);
            if((posicion==0 && datos.equalsIgnoreCase("book") ) || (posicion==1 && datos.equalsIgnoreCase("rubber") ) || (posicion==2 && datos.equalsIgnoreCase("pencil") ) || (posicion==3 && datos.equalsIgnoreCase("rule") ) || (posicion==4 && datos.equalsIgnoreCase("sharpener") ) )
            {
                correctas++;
                Toast toast = Toast.makeText(context, ""+idioma1, duration);
                toast.show();

            }
            else
            {

                Toast toast = Toast.makeText(context, ""+idioma2, duration);
                toast.show();
            }

            cambiarImagen();
            //texto.setText("");
        }}


    public void acerca(View view) {
        Intent i=new Intent(this,Acerca_de.class);
        startActivity(i);
    }
}