package ro.sda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.sda.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
