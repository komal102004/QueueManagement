package QueueManagement.QueueManagement.repository;

import QueueManagement.QueueManagement.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Long> {
    // Admin ko email se fetch karne ke liye
    Optional<Admin> findByEmail(String email);
}
