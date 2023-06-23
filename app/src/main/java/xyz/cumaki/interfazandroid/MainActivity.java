package xyz.cumaki.interfazandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
public void MostraDataPicker (View view){
        EditText txtFecha = findViewById(R.id.editTextDate);
        Calendar calendar= Calendar.getInstance();

        int Año =calendar.get(Calendar.YEAR);
        int Mes= calendar.get(Calendar.MONTH);
        int Dia= calendar.get(Calendar.DAY_OF_MONTH);

    DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener(){

        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            calendar.set(year, month, dayOfMonth);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
            String formattedDate = sdf.format(calendar.getTime());
            txtFecha.setText(formattedDate);
        }
    }, Año, Mes, Dia);

    datePickerDialog.show();
}
    public void  btnEnviar (View view){
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);

        EditText txtCedula = (EditText) findViewById(R.id.txtCedula);
        EditText txtNombre= (EditText) findViewById(R.id.txtNombre);
        EditText txtCiudad= (EditText) findViewById(R.id.txtCiudad);
        EditText txtTelefono=(EditText) findViewById(R.id.txtTelefono);
        RadioButton rbMasculino = findViewById(R.id.RadM);
        RadioButton rbFemenino = findViewById(R.id.radF);
        EditText txtCorreo=(EditText) findViewById(R.id.txtCorreo);
        EditText txtFecha = findViewById(R.id.editTextDate);





        String Cedula= txtCedula.getText().toString();
        String Nombre= txtNombre.getText().toString();
        String Ciudad= txtCiudad.getText().toString();
        String Telefono= txtTelefono.getText().toString();
        String genero;
        String Correo=txtCorreo.getText().toString();
        String Fecha=txtFecha.getText().toString();

        if (rbMasculino.isChecked()) {
            genero = "Masculino";
        } else if (rbFemenino.isChecked()) {
            genero = "Femenino";
        } else {
            Toast.makeText(getApplicationContext(), "Selecciona un género", Toast.LENGTH_SHORT).show();
            return; // Sale del método sin enviar los datos si no se ha seleccionado un género
        }

        Bundle b = new Bundle();
        b.putString("CEDULA", txtCedula.getText().toString());
        b.putString("NOMBRE", txtNombre.getText().toString());
        b.putString("GENERO",genero);
        b.putString("CIUDAD", txtCiudad.getText().toString());
        b.putString("CORREO",txtCorreo.getText().toString());
        b.putString("TELEFONO", txtTelefono.getText().toString());
        b.putString("FECHA",txtFecha.getText().toString());



        intent.putExtras(b);
        if(!Cedula.isEmpty()&&!Nombre.isEmpty()&&!Ciudad.isEmpty()&&!Telefono.isEmpty()
        &&(rbMasculino.isChecked()||rbFemenino.isChecked())&&!Correo.isEmpty()&&!Fecha.isEmpty())
        {
            startActivity(intent);
        }else {
            Toast.makeText(getApplicationContext(), "Completa todos los campos", Toast.LENGTH_SHORT).show();
        }

    }

        public void btBorrar(View view) {
            EditText txtCedula = (EditText) findViewById(R.id.txtCedula);
            EditText txtNombre= (EditText) findViewById(R.id.txtNombre);
            EditText txtCiudad= (EditText) findViewById(R.id.txtCiudad);
            EditText txtTelefono=(EditText) findViewById(R.id.txtTelefono);
            RadioButton rbMasculino = findViewById(R.id.RadM);
            RadioButton rbFemenino = findViewById(R.id.radF);
            EditText txtCorreo=(EditText) findViewById(R.id.txtCorreo);
            EditText txtFecha = findViewById(R.id.editTextDate);

            txtCedula.setText("");
            txtNombre.setText("");
            txtCiudad.setText("");
            txtTelefono.setText("");
            rbMasculino.setChecked(false);
            rbFemenino.setChecked(false);
            txtCorreo.setText("");
            txtFecha.setText("");
        }


}