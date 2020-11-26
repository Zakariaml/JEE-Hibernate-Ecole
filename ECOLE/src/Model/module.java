package Model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "module")
public class module {
	@Id
	@Column(name = "module_id")
	private String module_id;
	
	@Column(name = "module_nom")
	private String module_libelle;
	
	@OneToMany(mappedBy = "module")
	private List<Note> notes;
	
	 
	public List<Note> getNotes() {
		return notes;
	}

	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}

	public String getModule_id() {
		return module_id;
	}

	public String getModule_libelle() {
		return module_libelle;
	}

	public void setModule_id(String module_id) {
		this.module_id = module_id;
	}

	public void setModule_libelle(String module_libelle) {
		this.module_libelle = module_libelle;
	}

	public module(String module_id, String module_libelle) {
		this.module_id = module_id;
		this.module_libelle = module_libelle;
	}

	public module() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
