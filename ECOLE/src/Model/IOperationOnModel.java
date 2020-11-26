package Model;

import java.util.List;

public interface IOperationOnModel {
	
	//-------------Operation on Eleve Class----------------------
	public void addEleve(Eleve e);
	public void deleteEleve(String cne);
	public List<Eleve> AllEleve();
	public void updateEleve(Eleve e);
	public Eleve getEleve(String cne);
	public List<Eleve> SearchByKeyInEleve(String Key);
	
	//-------------Operation on Enseignant class----------------
	public void addEnseignant(Enseignant en);
	public void deleteEnseignant(String CIN);
	public List<Enseignant> AllEnseignant();
	public void updateEnseignant(Enseignant en);
	public Enseignant getEnseignant(String CIN);
	public List<Enseignant> SearchByKeyInEnseignant(String Key);
	
	
	//----------Operation on module Class------------------
	public void addModule(module m);
	public void deleteModule(String ID);
	public List<module> AllModule();
	public void updateModule(module m);
	public module getModule(String ID);
	public List<module> SearchByKeyInModule(String Key);
	
	//-------------Operation On Note Class-------------------
	
	public void addNote(Note n);
	public List<Note> AllNote();
	public void deleteNote(ModuleEleve Id);
	public void updateNote(ModuleEleve Id,Double note);
	public Note getNote(ModuleEleve Id);
	public List<Note> getListForSpecificModule(String module);
	public List<Note> getListForSpecificEleve(String eleve);
}
