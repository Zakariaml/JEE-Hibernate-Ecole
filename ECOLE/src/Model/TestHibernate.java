package Model;

import java.util.List;

public class TestHibernate {

	public static void main(String[] args) {
		//Enseignant ens = new Enseignant("Z572873", "MiloudiUPDATED", "ZAKARIAUpdated", "0600000000");
		/*Enseignant en1 = new Enseignant("Z57775", "Sissani", "Younes", "0654670912");
		Enseignant en2 = new Enseignant("Z579816", "Touzani", "Asmae", "0688954321");*/
		//Eleve e = new Eleve("","CCCC", "WWWWWW");
		IOperationOnModel model = new OperationOnModel();
		
		//model.addEleve(e);
	//	model.addEleve(ee);
	//	model.updateEleve(e);
		//model.addEnseignant(ens);
		//model.addEnseignant(en1);
	//	model.addEnseignant(en2);
		/*
		 * List<Eleve> All = model.SearchByKeyInEleve("1");
		for (Eleve eleve : All) {
			System.out.println("eleve cne : ---"+eleve.getCne_eleve());
			System.out.println("eleve nom : ---"+eleve.getNom_eleve());
			System.out.println("eleve prenom : ---"+eleve.getPrenom_eleve());
		}
		model.updateEnseignant(ens);
		
		List<Enseignant> AllEn = model.AllEnseignant();
		for (Enseignant en : AllEn) {
			System.out.println("cin : ---"+en.getCIN());
			System.out.println("nom : ---"+en.getNom_ensignant());
			System.out.println("prenom : ---"+en.getPrenom_enseignant());
			System.out.println("numero de telephone : --"+en.getNum_tele());
		}
		model.deleteEnseignant("Z572873");
		List<Enseignant> AllEns = model.AllEnseignant();
		for (Enseignant en : AllEns) {
			System.out.println("cin : ---"+en.getCIN());
			System.out.println("nom : ---"+en.getNom_ensignant());
			System.out.println("prenom : ---"+en.getPrenom_enseignant());
			System.out.println("numero de telephone : --"+en.getNum_tele());
		}
		 *  
		 *  
		 *  model.addEnseignant(ens);
		Enseignant ensi = model.getEnseignant("Z572873");
		System.out.println("GET :: "+ensi.getNom_ensignant());
		 *  */
		
		//------------------TEST module Class----------------------
		
		//module m1 = new module("M15-UPDATED", "Programmation");
		//module m2 = new module("M16", "Programmation WEB");
		//module m3 = new module("M17", "Conception");
		
		//model.addModule(m1);
		//model.addModule(m2);
		//model.addModule(m3);
		/* 
		List<module> Allm = model.AllModule();
		for (module m : Allm) {
			System.out.println("id module : ---"+m.getModule_id());
			System.out.println("nom module : ---"+m.getModule_libelle());
		}
		
		model.updateModule(m1);
		
		Allm = model.AllModule();
		for (module m : Allm) {
			System.out.println("id module : ---"+m.getModule_id());
			System.out.println("nom module : ---"+m.getModule_libelle());
		}
		
		System.out.println("-------SEARCH BY KEYWORD : ----------------------");
		Allm = model.SearchByKeyInModule("Con");
		for (module m : Allm) {
			System.out.println("id module : ---"+m.getModule_id());
			System.out.println("nom module : ---"+m.getModule_libelle());
		}
		
		System.out.println("-------GET 1 module : ----------------------");
		m1 = model.getModule("M16");
		System.out.println("Libelle Module : ---"+m1.getModule_libelle());
		
		System.out.println("----------DELETE LIBELLE--------------");
		
		model.deleteModule("M16");
		Allm = model.AllModule();
		for (module m : Allm) {
			System.out.println("id module : ---"+m.getModule_id());
			System.out.println("nom module : ---"+m.getModule_libelle());
		}
		*/
		//ModuleEleve Id = new ModuleEleve("M15-UPDATED","4444");
		//model.deleteNote(me);
		
		
		//Eleve e = new Eleve("4444","CCCC", "WWWWWW");
		//module m = new module("M15-UPDATED", "Programmation");
		//Note nn = new Note(m, e, 17);
		//model.addNote(nn);
		
		//model.updateNote(Id,18.0);
		//System.out.println(model.getNote(Id).getNote());
		
		/*
		 * 
		 *  List<Note> Alln = model.getListForSpecificModule("M15");
		for (Note n : Alln) {
			System.out.println(n.getModule().getModule_libelle());
			
		}*/
		
		
	}

}
