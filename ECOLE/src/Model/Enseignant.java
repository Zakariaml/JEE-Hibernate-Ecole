package Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "enseignant")
public class Enseignant implements Serializable{
	@Id
	@Column(name = "cin",length = 7)
	private String CIN;
	
	@Column(name = "nom_enseignant")
	private String nom_enseignant;
	
	@Column(name = "prenom_enseignant")
	private String prenom_enseignant;
	
	@Column(name = "num_tele")
	private String num_tele;
	
	public String getCIN() {
		return CIN;
	}
	public String getNom_ensignant() {
		return nom_enseignant;
	}
	public String getPrenom_enseignant() {
		return prenom_enseignant;
	}
	public String getNum_tele() {
		return num_tele;
	}
	public void setCIN(String cIN) {
		CIN = cIN;
	}
	public void setNom_ensignant(String nom_enseignant) {
		this.nom_enseignant = nom_enseignant;
	}
	public void setPrenom_enseignant(String prenom_enseignant) {
		this.prenom_enseignant = prenom_enseignant;
	}
	public void setNum_tele(String num_tele) {
		this.num_tele = num_tele;
	}
	public Enseignant(String cIN, String nom_enseignant, String prenom_enseignant, String num_tele) {
		CIN = cIN;
		this.nom_enseignant = nom_enseignant;
		this.prenom_enseignant = prenom_enseignant;
		this.num_tele = num_tele;
	}
	public Enseignant() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
