package project.db.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import project.db.domain.User;
import project.db.service.UserService;

@RestController
@RequestMapping(value="/users")
public class UserResource {

	@Autowired
	private UserService userService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<User>> findAll(){
		List<User> list = userService.findAll();
		/*List<UserDTO> lisyDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		 * expressão lambda para chamar o DTO e converter na entidade esclhida
		 * Para fazer isso precisa add as variaveis e o construtor la na "classe DTO"
		 * essa praatica é usada nop get pata que não venha informações desnecessarias 
		 * no console de REDE no navegador "network", Para isso tmb é 
		 * preciso mexer no DTO e colocar la as informações q eu desejo requuisitar*/
		return ResponseEntity.ok().body(list);
	}
}
