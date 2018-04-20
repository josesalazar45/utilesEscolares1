package com.example.sistemas.utilesescolares;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class felicitaciones extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_felicitaciones);
    }
    public void regresar(View view) {
        Intent i = new Intent(this, MainActivity.class );
        startActivity(i);
    }
}
