package com.AppWillyWonka.Interface;

import com.AppWillyWonka.Model.User;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Developer Willsanc
 */
public interface InterfaceUser extends CrudRepository<User, Integer> {

    Optional<User> findByEmailAndPassword(String email, String password);

    Optional<User> findByEmail(String email);



}
