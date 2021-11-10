package controle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import modelo.Paciente;

@ManagedBean
@SessionScoped
public class CadastrarPacienteMBean {

	private Paciente paciente;
	private List<Paciente> pacientes;
	public static List<Paciente> listagem= new ArrayList<Paciente>();

	public CadastrarPacienteMBean() {

		paciente= new Paciente();	
		pacientes= new ArrayList<Paciente>();
	}

	public String entrarCadastro() {

		return "/cadastro-paciente.jsf";
	}

	public String voltar() {

		return "/index.jsf";
	}

	public String listar() {

		return "/lista-pacientes.jsf";
	}

	public String cadastrar() {

		pacientes.add(paciente);
		listagem.add(paciente);
		paciente= new Paciente();

		FacesMessage msg= new FacesMessage("Paciente cadastrado com sucesso!");
		msg.setSeverity(FacesMessage.SEVERITY_INFO);

		FacesContext.getCurrentInstance().addMessage("", msg);

		return "/cadastro-paciente.jsf";
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public List<Paciente> getPacientes() {
		return pacientes;
	}

	public void setPacientes(List<Paciente> pacientes) {
		this.pacientes = pacientes;
		listagem= pacientes;
	}	
}
