package project.db.resource.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;
import project.db.service.exception.Obj404Exception;

@ControllerAdvice//Estou dizendo com essa anotation q essa classe é responsavel por tartar óssiveis erros na minha requisição
public class ResourceExceptionHandler {

	@ExceptionHandler(Obj404Exception.class)
	public ResponseEntity<StandardError> obj404(Obj404Exception e, HttpServletRequest req){
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(System.currentTimeMillis(), status.value(), "Não Encontrado!", e.getMessage(), req.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}	
}
