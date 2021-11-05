package modelo;

public class Medico extends Pessoa{
	
	private String CRM;
	private String especialidade;
	private String turno;
	
	public String getCRM() {
		return CRM;
	}
	
	public void setCRM(String cRM) {
		CRM = cRM;
	}
	
	public String getEspecialidade() {
		return especialidade;
	}
	
	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}
	
	public String getTurno() {
		return turno;
	}
	
	public void setTurno(String turno) {
		this.turno = turno;
	}
}
