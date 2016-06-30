package com.developerandroid.applab11;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    // Atributes
    private Button btnGuardar;
    private Button btnCargar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        btnGuardar = (Button) findViewById(R.id.BtnGuardar);
        btnCargar  = (Button)  findViewById(R.id.BtnCargar);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Saving the preferences
                SharedPreferences prefs = getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putString("email", "modificado@gmail.com");
                editor.putString("nombre", "Prueba");
                editor.commit();
            }
        });

        btnCargar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                // Getting back preferences
                SharedPreferences prefs = getSharedPreferences("MisPreferencias",Context.MODE_PRIVATE);
                String correo = prefs.getString("email", "por_defecto@email.com");
                String nombre = prefs.getString("nombre", "nombre_por_defecto");
                String otra = prefs.getString("otra", "otra_por_defecto");

                Toast.makeText(getApplicationContext(), "Correo: " +correo, Toast.LENGTH_LONG).show();
                Toast.makeText(getApplicationContext(), "Nombre: " +nombre, Toast.LENGTH_LONG).show();
                Toast.makeText(getApplicationContext(), "Otra: " + otra, Toast.LENGTH_LONG).show();
            }

        });
    } // Ends onCreate

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
