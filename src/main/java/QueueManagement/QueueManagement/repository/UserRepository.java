package QueueManagement.QueueManagement.repository;

import QueueManagement.QueueManagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByMobileNumber(String mobileNumber);
}
