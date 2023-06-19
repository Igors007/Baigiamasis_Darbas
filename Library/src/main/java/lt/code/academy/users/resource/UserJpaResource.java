package lt.code.academy.users.resource;

import lt.code.academy.users.Client;
import lt.code.academy.users.User;
import lt.code.academy.users.repository.UserJpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
@CrossOrigin(origins="http://localhost:4200")
public abstract class UserJpaResource {

    //@GetMapping(path = "/users/{type}")
    public abstract List<? extends User> getUsers();

    //   @GetMapping(path = "users/{type}/{field}")
    public abstract List<? extends User> getUsersByField( @PathVariable String field);

    //  @DeleteMapping("/users/{type}/{id}")
    public abstract ResponseEntity<Void> deleteUser(@PathVariable Long id);

    //@PutMapping("/users/{type}/{id}")
    public abstract ResponseEntity<? extends User> updateUser (@PathVariable Long id, @RequestBody Client user);

    // @PostMapping("/users/{type}")
    public abstract ResponseEntity<Void> create (@RequestBody Client user);
}

