package project.db.service.exception;

public class Obj404Exception extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public Obj404Exception(String msg) {
		super(msg);
	}
}
