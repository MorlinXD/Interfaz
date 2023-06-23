package xyz.cumaki.interfazandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TextView txtDatos = (TextView)findViewById(R.id.txtDatos);

        Bundle bundle = this.getIntent().getExtras();
txtDatos.setText(bundle.getString("CEDULA")+"\n"+bundle.getString("NOMBRE")+"\n"+
        bundle.getString("CIUDAD")+"\n"+bundle.getString("TELEFONO"));

    }
}