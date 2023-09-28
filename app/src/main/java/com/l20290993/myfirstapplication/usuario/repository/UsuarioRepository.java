package com.l20290993.myfirstapplication.usuario.repository;

import com.l20290993.myfirstapplication.usuario.model.Usuario;

import java.util.HashMap;

public class UsuarioRepository {
    private static UsuarioRepository repository = null;
    private HashMap< String, HashMap< String, Usuario>> registeredUsers;

    private UsuarioRepository() {
        Usuario u1 = new Usuario("Molly", "12345", "Veronica", 21, "vgma5@hotmail.com");
        Usuario u2 = new Usuario("Kala", "12345", "Miriam", 21, "vgma3@hotmail.com");
        Usuario u3 = new Usuario("Chiquilina", "12345", "Myrania", 21, "vero_mtz_08@hotmail.com");

        this.registeredUsers = new HashMap<String, HashMap<String, Usuario>>();

        //Agregar usuario 1
        registeredUsers.put(u1.getUsuario(), new HashMap<String, Usuario>());
        registeredUsers.get(u1.getUsuario()).put(u1.getPasss(), u1);

        //Agregar usuario 2
        registeredUsers.put(u2.getUsuario(), new HashMap<String, Usuario>());
        registeredUsers.get(u2.getUsuario()).put(u2.getPasss(), u2);

        //Agregar usuario 3
        registeredUsers.put(u3.getUsuario(), new HashMap<String, Usuario>());
        registeredUsers.get(u3.getUsuario()).put(u3.getPasss(), u3);
    }
    
    public static UsuarioRepository getInstance() {
        if(repository == null)
          repository = new UsuarioRepository();

        return repository;
    }

    public HashMap<String, HashMap<String, Usuario>> getRegisteredUsers() {
        return registeredUsers;
    }
}
