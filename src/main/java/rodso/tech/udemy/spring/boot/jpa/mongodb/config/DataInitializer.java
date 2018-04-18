package rodso.tech.udemy.spring.boot.jpa.mongodb.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import rodso.tech.udemy.spring.boot.jpa.mongodb.entity.User;
import rodso.tech.udemy.spring.boot.jpa.mongodb.repository.UserRepository;

@Component
public class DataInitializer implements ApplicationListener<ContextRefreshedEvent>{
	
	@Autowired
	UserRepository userRepository;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		// TODO Auto-generated method stub
		List<User> users = userRepository.findAll();
		
		if (users.isEmpty())
		{
			createUser("System Administrator","admin@rodtech.com.br");
			createUser("Rodrigo Santos de Oliveira","roddso@gmail.com");
			createUser("Guilherme Correa de Oliveira","guicorrea@gmail.com");
			createUser("Beatriz Correa de Oliveira","biacorrea@gmail.com");
			
		}
		users = null;
		
		//User user = userRepository.getOne(2L);
		//System.out.println("email: "+ user.getEmail());
		//user.setName("Rodrigo S Oliveira");
		//userRepository.save(user);
		
//		User user = null;
	//	User user = userRepository.findByName("Rodrigo Santos de Oliveira");
//		User user = userRepository.findByNameLike("Rodrigo");
		//User user = userRepository.findByNameIgnoreCaseLike("RoDrIgO");
		User user = userRepository.findByEmailQualquerCoisa("biacorrea@gmail.com");
		System.out.println(user.getName());
		
		//userRepository.deleteById(3L);
	
	}
	
	public void createUser(String name, String email)
	{
		User user = new User(name,email);
		userRepository.save(user);
	}

}
