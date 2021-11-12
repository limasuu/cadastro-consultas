package controle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import modelo.Consulta;
import modelo.Medico;
import modelo.Paciente;

@ManagedBean
@SessionScoped
public class CadastrarConsultaMBean {

	private Consulta consulta;
	private List<Consulta> consultas;

	public CadastrarConsultaMBean() {

		inicializar();
		consultas= new ArrayList<Consulta>();
	}

	private void inicializar() {

		consulta= new Consulta();
		consulta.setMedico(new Medico());
		consulta.setPaciente(new Paciente());
	}

	public String entrarCadastro() {

		return "/cadastro-consulta.jsf";
	}

	public String voltar() {

		return "/index.jsf";
	}

	public String listar() {

		return "/lista-consultas.jsf";
	}

	public String cadastrar() {
		
		Paciente paciente= CadastrarPacienteMBean.getPaciente(consulta.getPaciente().getCPF());
		Medico medico= CadastrarMedicoMBean.getMedico(consulta.getMedico().getCRM());
		consulta.setPaciente(paciente);
		consulta.setMedico(medico);

		consultas.add(consulta);
		inicializar();

		FacesMessage msg= new FacesMessage("Consulta cadastrada com sucesso!");
		msg.setSeverity(FacesMessage.SEVERITY_INFO);

		FacesContext.getCurrentInstance().addMessage("", msg);

		return "/cadastro-consulta.jsf";
	}

	public Consulta getConsulta() {
		return consulta;
	}

	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}

	public List<Consulta> getConsultas() {
		return consultas;
	}

	public void setConsultas(List<Consulta> consultas) {
		this.consultas = consultas;
	}
}
