package com.l20290993.myfirstapplication.usuario;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.TextView;

import com.l20290993.myfirstapplication.R;
import com.l20290993.myfirstapplication.usuario.model.Usuario;
import com.l20290993.myfirstapplication.usuario.repository.UsuarioRepository;

public class DashboardUsuario extends AppCompatActivity {
    private UsuarioRepository ur;

    private Usuario userInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_usuario);

        //Declare los text view
        TextView tvNombre = findViewById(R.id.tvNombre);
        TextView tvEdad = findViewById(R.id.tvEdad);
        TextView tvCorreo = findViewById(R.id.tvCorreo);

        //Aqui creamos la instancia del Usuario Repository
        ur = UsuarioRepository.getInstance();

        //Esta es la manera en la que recibimos información de otro activity
        String usuario = getIntent().getStringExtra("usuario");
        String pass = getIntent().getStringExtra("pass");

        //Obtenemos información del usuario logueado
        userInfo = ur.getRegisteredUsers().get(usuario).get(pass);
        //Mando la información a los text View
        tvNombre.setText("Usuario: " + userInfo.getNombre());
        tvEdad.setText("Edad: " + userInfo.getEdad());
        tvCorreo.setText("Correo: " + userInfo.getEmail());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Toolbar toolbar = findViewById(R.id.toolbar);

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar_menu, menu);


        return super.onCreateOptionsMenu(menu);
    }
}