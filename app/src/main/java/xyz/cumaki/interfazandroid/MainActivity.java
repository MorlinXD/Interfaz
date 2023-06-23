package xyz.cumaki.interfazandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void  btnEnviar (View view){
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);

        EditText txtCedula = (EditText) findViewById(R.id.txtCedula);
        EditText txtNombre= (EditText) findViewById(R.id.txtNombre);
        EditText txtCiudad= (EditText) findViewById(R.id.txtCiudad);
        EditText txtTelefono=(EditText) findViewById(R.id.txtTelefono);
        RadioButton Genero= (RadioButton) findViewById(R.id.RadM);

        String Cedula= txtCedula.getText().toString();
        String Nombre= txtNombre.getText().toString();
        String Ciudad= txtCiudad.getText().toString();
        String Telefono= txtTelefono.getText().toString();
        String genero= Genero.isChecked()?"Masculino":"Femenino";

        Bundle b = new Bundle();
        b.putString("CEDULA", txtCedula.getText().toString());
        b.putString("NOMBRE", txtNombre.getText().toString());

        b.putString("CIUDAD", txtCiudad.getText().toString());
        b.putString("TELEFONO", txtTelefono.getText().toString());



        intent.putExtras(b);
        if(!Cedula.isEmpty()&&!Nombre.isEmpty()&&!Ciudad.isEmpty()&&!Telefono.isEmpty())
        {
            startActivity(intent);
        }else {
            Toast.makeText(getApplicationContext(), "Completa todos los campos", Toast.LENGTH_SHORT).show();
        }

    }



}