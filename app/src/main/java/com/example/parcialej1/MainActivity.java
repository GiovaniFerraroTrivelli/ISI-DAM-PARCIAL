package com.example.parcialej1;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText nombre;
    Spinner sexo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre = findViewById(R.id.nombre);

        sexo = (Spinner)findViewById(R.id.sexo);
        ArrayList<String> listaSexos = new ArrayList<String>();
        listaSexos.add("Hombre");
        listaSexos.add("Mujer");
        sexo.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, listaSexos));
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void onClickMostrarNotificacion(android.view.View v) {
        new Tarea(this).execute(((EditText) nombre).getText().toString(), ((Spinner) sexo).getSelectedItem().toString());
    }
}