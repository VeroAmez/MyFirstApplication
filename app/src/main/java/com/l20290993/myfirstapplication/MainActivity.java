package com.l20290993.myfirstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.l20290993.myfirstapplication.usuario.DashboardUsuario;
import com.l20290993.myfirstapplication.usuario.repository.UsuarioRepository;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    //private HashMap<String, String> registeredUsers = new HashMap<String, String>();

    private UsuarioRepository ur;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ur = UsuarioRepository.getInstance();

        /*
        registeredUsers.put("Molly", "12345");
        registeredUsers.put("Kala", "123456789");
        registeredUsers.put("Miriam", "123456");
         */
    }

    private AlertDialog createAlertDialog(String title, String message) {
                        //Mensaje interactivo o invasivo refactorizado
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        //Investigar valores mutables y no mutables
        //Los tipos de datos son aquello que cuando accedemos son cuando puedes modificar los resultados

        builder.setTitle(title)
                .setMessage(message);  //Invocaciones de método anidado
        return builder.create();
    }


    public void onBtnIngresarTap(View view) {
                        //Mensaje invasiso
        //AlertDialog.Builder builder = new AlertDialog.Builder(this);

        //AlertDialog dialog = builder.create();

        EditText etUsuario = findViewById(R.id.etUsuario);
        EditText etPass = findViewById(R.id.etPass);

        String user, pass;
        user = etUsuario.getText().toString();
        pass = etPass.getText().toString();

        if(!ur.getRegisteredUsers().containsKey(user)) {
            //dialog.setTitle("Felicidades presionaste el botón");
            //dialog.setMessage("Usuario no registrado");
            //dialog.show();

            this.createAlertDialog("Atención", "Usuario no registrado").show(); //Invocaciones no anidados
            return;
        }

        if(!ur.getRegisteredUsers().get(user).containsKey(pass)) {
            //dialog.setTitle("Atención");
            //dialog.setMessage("La contraseña no conincide");
            //dialog.show();

            this.createAlertDialog("Atención", "La contraseña no coincide").show();
            return;
        }

        //user = user.toUpperCase();
        //dialog.setTitle("Felicidades has iniciado sesión");
        //dialog.setMessage(String.format("Datos ingresados\nUsuario: %s\nPassword: %s", user, pass));
        //dialog.show();

        //Mensaje con el que no se ocupa interacuar
        //no invasivo
        String message = "Felicidades ha iniciado sesión con éxito";
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();

        //Cambiar de pantalla
        // Primer parametro quien lo va invocar
        //Segundo parametro quien esta siendo invocado
        Intent i = new Intent(this, DashboardUsuario.class);
        i.putExtra("usuario", user);
        i.putExtra("pass", pass);
        startActivity(i);

    }
}