package validador;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import controle.CadastrarPacienteMBean;

@FacesValidator("validadorPaciente")
public class ValidadorPaciente implements Validator{

	@Override
	public void validate(FacesContext contexto, UIComponent componente, Object objeto) throws ValidatorException {

		String CPF= objeto.toString();
		boolean cadastrado= CadastrarPacienteMBean.contemPaciente(CPF);			

		if(!cadastrado) {

			FacesMessage msg= new FacesMessage("Paciente não cadastrado!");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);

			throw new ValidatorException(msg);
		}

	}

}
