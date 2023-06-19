package lt.code.academy.users.repository;

import lt.code.academy.users.Admin;
import lt.code.academy.users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminJpaRepository extends JpaRepository<Admin, Long> {

    List<Admin> findByUsername(String username);
}
