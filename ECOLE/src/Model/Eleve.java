package Model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "eleve")
public class Eleve implements Serializable{
	@Id	
	@Column(name = "cne_eleve")
	private String cne_eleve;
	
	@Column(name = "nom_eleve")
	private String nom_eleve;
	
	@Column(name = "prenom_eleve")
	private String prenom_eleve;

	@OneToMany(mappedBy = "eleve")
	private List<Note> notes;
	
	public String getCne_eleve() {
		return cne_eleve;
	}

	
	public String getNom_eleve() {
		return nom_eleve;
	}

	
	public String getPrenom_eleve() {
		return prenom_eleve;
	}

	public void setCne_eleve(String cne_eleve) {
		this.cne_eleve = cne_eleve;
	}

	public void setNom_eleve(String nom_eleve) {
		this.nom_eleve = nom_eleve;
	}

	public void setPrenom_eleve(String prenom_eleve) {
		this.prenom_eleve = prenom_eleve;
	}


	public List<Note> getNotes() {
		return notes;
	}


	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}


	public Eleve(String cne_eleve,String nom_eleve, String prenom_eleve) {
		this.cne_eleve = cne_eleve;
		this.nom_eleve = nom_eleve;
		this.prenom_eleve = prenom_eleve;
	}

	public Eleve() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
