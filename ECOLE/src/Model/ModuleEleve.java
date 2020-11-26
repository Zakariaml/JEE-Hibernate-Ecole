package Model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class ModuleEleve implements Serializable{
	
	private String moduleId;
	private String eleveId;
	
	public String getModuleId() {
		return moduleId;
	}
	public String getEleveId() {
		return eleveId;
	}
	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}
	public void setEleveId(String eleveId) {
		this.eleveId = eleveId;
	}
	public ModuleEleve(String moduleId, String eleveId) {
		this.moduleId = moduleId;
		this.eleveId = eleveId;
	}
	public ModuleEleve() {
		super();
	}
	
	
}
