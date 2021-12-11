package com.AppWillyWonka.Repository;

import com.AppWillyWonka.Interface.InterfaceUser;
import com.AppWillyWonka.Model.User;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Developer Willsanc
 */
@Repository
public class RepositoryUser {

    @Autowired
    private InterfaceUser crud;

    public List<User> getAll() {
        return (List<User>) crud.findAll();
    }

    public Optional<User> getUser(int id) {
        return crud.findById(id);
    }

    public User save(User user) {
        return crud.save(user);
    }

    public boolean existeEmail(String email) {
        Optional<User> usuario = crud.findByEmail(email);
        return !usuario.isEmpty();
    }

    public Optional<User> autenticarUsuario(String email, String password) {
        return crud.findByEmailAndPassword(email, password);
    }

}
