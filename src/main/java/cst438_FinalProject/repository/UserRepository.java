package cst438_FinalProject.repository;

import java.util.List;
import javax.persistence.Table;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import cst438_FinalProject.domain.User;


@Repository
@Table(name="user")
public interface UserRepository extends JpaRepository<User,Long>{
	List<User> findByEmail(String email);
}
