package controle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import modelo.Medico;

@ManagedBean
@SessionScoped
public class CadastrarMedicoMBean {

	private Medico medico;
	private List<Medico> medicos;

	public CadastrarMedicoMBean() {

		medico= new Medico();
		medicos= new ArrayList<Medico>();
	}

	public String entrarCadastro() {

		return "/cadastro-medico.jsf";
	}

	public String voltar() {

		return "/index.jsf";
	}

	public String listar() {

		return "/lista-medicos.jsf";
	}

	public String cadastrar() {

		medicos.add(medico);
		medico= new Medico();

		FacesMessage msg= new FacesMessage("Médico cadastrado com sucesso!");
		msg.setSeverity(FacesMessage.SEVERITY_INFO);

		FacesContext.getCurrentInstance().addMessage("", msg);

		return "/cadastro-medico.jsf"; 
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public List<Medico> getMedicos() {
		return medicos;
	}

	public void setMedicos(List<Medico> medicos) {
		this.medicos = medicos;
	}	
}
