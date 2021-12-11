package com.AppWillyWonka.Service;

import com.AppWillyWonka.Model.User;
import com.AppWillyWonka.Repository.RepositoryUser;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Developer Wllsanc
 */
@Service
public class ServiceUser {

    @Autowired
    private RepositoryUser metodosCrud;

    public List<User> getAll() {
        return metodosCrud.getAll();
    }

    public Optional<User> getUser(int id) {
        return metodosCrud.getUser(id);
    }
//-------------validar si funciona----------------//
    public User save(User user) {
        if (user.getId() == null) {
            return metodosCrud.save(user);
        } else {
            Optional<User> evt = metodosCrud.getUser(user.getId());
            if (evt.isEmpty()) {
                return metodosCrud.save(user);
            } else {
                return user;
            }
        }
    }
//----------------------//

    public boolean existeEmail(String email) {
        return metodosCrud.existeEmail(email);
    }

    public User autenticarUsuario(String email, String password) {
        Optional<User> usuario = metodosCrud.autenticarUsuario(email, password);

        if (usuario.isEmpty()) {
            return new User(null, email, password, "NO DEFINIDO");
        } else {
            return usuario.get();
        }
    }

}
