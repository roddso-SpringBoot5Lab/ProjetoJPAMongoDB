package rodso.tech.udemy.spring.boot.jpa.mongodb.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import rodso.tech.udemy.spring.boot.jpa.mongodb.entity.User;

public interface UserRepository extends MongoRepository<User, Long>{
	
	User findByName(String name);

	User findByNameIgnoreCase(String name);
	
	User findByNameIgnoreCaseLike(String name);
	
	@Query("{ 'email' : ?0 }")
	User findByEmailQualquerCoisa(String email);
	
	
	List<User> findByEmail(String email);

	

	
}
