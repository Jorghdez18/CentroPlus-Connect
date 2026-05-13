package es.ies.puerto.repositories;

import es.ies.puerto.models.Usuario;
import java.util.ArrayList;
import java.util.List;

public class UsuarioRepository {

    private List<Usuario> usuarios = new ArrayList<>();

    public List<Usuario> findAll() {
        return usuarios;
    }

    public Usuario findById(int id) {
        for (Usuario u : usuarios) {
            if (u.getId() == id) {
                return u;
            }
        }
        return null;
    }

    public void save(Usuario u) {
        usuarios.add(u);
    }

    public void delete(int id) {
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getId() == id) {
                usuarios.remove(i);
                break;
            }
        }
    }
}