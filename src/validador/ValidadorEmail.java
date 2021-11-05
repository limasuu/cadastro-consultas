package validador;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("validadorEmail")
public class ValidadorEmail implements Validator{

	@Override
	public void validate(FacesContext contexto, UIComponent componente, Object objeto) throws ValidatorException {
		
		String email= objeto.toString();
		
		if(!email.contains("@")) {
			
			FacesMessage msg= new FacesMessage("Insira um e-mail válido!");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			
			throw new ValidatorException(msg);
		}		
	}
}
