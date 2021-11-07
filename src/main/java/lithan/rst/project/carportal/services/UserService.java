package lithan.rst.project.carportal.services;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lithan.rst.project.carportal.daos.RoleRepository;
import lithan.rst.project.carportal.daos.UserRepository;
import lithan.rst.project.carportal.entities.Role;
import lithan.rst.project.carportal.entities.User;
import java.util.HashSet;

@Service
@Transactional
public class UserService {
	@Autowired
	UserRepository repo;

	@Autowired
    private RoleRepository roleRepository;
	
	public void save(User user) {		
		System.out.println("----------------------------------"+roleRepository.findAll());
		 // user.setRoles(new HashSet<>(Arrays.asList(new Role("Users"))));
		 // user.setRoles(new HashSet<>(roleRepository.findAll()));
		 user.setRoles(new HashSet<>(roleRepository.findBySpecificRoles("Users")));
		 
        repo.save(user);	
	}

	public List<User> listAll() {
		return (List<User>) repo.findAll();
	}

	public User get(Long id) {
		return repo.findById(id).get();
	}

	public void delete(Long id) {
		repo.deleteById(id);
	}
	
	
}