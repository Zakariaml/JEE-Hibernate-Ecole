package Model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "note")
public class Note implements Serializable{
	@Id
	@EmbeddedId
	private ModuleEleve idNote = new ModuleEleve();
	
	@ManyToOne
	@MapsId("moduleId")
	private module module;
	
	@ManyToOne
	@MapsId("eleveId")
	private Eleve eleve;
	
	private double note;

	public ModuleEleve getIdNote() {
		return idNote;
	}

	public module getModule() {
		return module;
	}

	public Eleve getEleve() {
		return eleve;
	}

	public double getNote() {
		return note;
	}

	public void setIdNote(ModuleEleve idNote) {
		this.idNote = idNote;
	}

	public void setModule(module module) {
		this.module = module;
	}

	public void setEleve(Eleve eleve) {
		this.eleve = eleve;
	}

	public void setNote(double note) {
		this.note = note;
	}

	public Note(Model.module module, Eleve eleve, double note) {
		super();
		this.module = module;
		this.eleve = eleve;
		this.note = note;
	}

	public Note() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
