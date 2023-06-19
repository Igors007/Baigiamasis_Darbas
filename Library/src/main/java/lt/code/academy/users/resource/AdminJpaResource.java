package lt.code.academy.users.resource;

import lt.code.academy.users.Admin;
import lt.code.academy.users.Client;
import lt.code.academy.users.User;
import lt.code.academy.users.repository.AdminJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AdminJpaResource extends UserJpaResource {

    private AdminJpaRepository adminJpaRepository;

    @Override
    @GetMapping("/users/admin")
    public List<Admin> getUsers() {
        return adminJpaRepository.findAll();
    }

    @Override
    @GetMapping(path = "users/admin/{field}")
    public List<Admin> getUsersByField(@PathVariable String username) {
        List<Admin> admins = adminJpaRepository.findByUsername(username);
        return admins;
    }

    @Override
    @DeleteMapping("/users/admin/{id}")
    public ResponseEntity<Void> deleteUser(Long id) {
        throw new IllegalStateException("This operation is illegal!");
    }


    @Override
    @PutMapping("/users/admin/{id}")
    public ResponseEntity<Admin> updateUser(Long id, Client user) {
        throw new IllegalStateException("This operation is illegal!");
    }

    @Override
    @PostMapping("/users/admin")
    public ResponseEntity<Void> create(Client user){
        throw new IllegalStateException("This operation is illegal!");
    }
}

