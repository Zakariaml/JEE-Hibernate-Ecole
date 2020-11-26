package Model;

import java.util.List;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import Util.hibernateUtil;

public class OperationOnModel implements IOperationOnModel{

	@Override
	public void addEleve(Eleve e) {
		Session session = hibernateUtil.getSessionf().getCurrentSession();
		session.beginTransaction();
		try {
			session.save(e);
		} catch (HibernateException e1) {
			session.getTransaction().rollback();
			e1.printStackTrace();
		}
		session.getTransaction().commit();
		List<module> allModule = AllModule();
		Note n = new Note();
		for (module module : allModule) {
			n.setNote(0);
			n.setEleve(e);
			n.setModule(module);
			addNote(n);
		}
		
	}

	@Override
	public void deleteEleve(String cne) {
		List<module> allModule = AllModule();
		ModuleEleve id = new ModuleEleve();
		id.setEleveId(cne);
		for (module module : allModule) {
			id.setModuleId(module.getModule_id());
			deleteNote(id);
		}
		
		Session session = hibernateUtil.getSessionf().getCurrentSession();
		session.beginTransaction();
		try {
			Eleve e = session.get(Eleve.class, cne);
			session.delete(e);
			
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		session.getTransaction().commit();
		
		
	}

	@Override
	public List<Eleve> AllEleve() {
		List<Eleve> allEleve = null;
		Session session = hibernateUtil.getSessionf().getCurrentSession();
		session.beginTransaction();
		try {
			
			allEleve = session.createQuery("select e from Eleve e").list();
			
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		session.getTransaction().commit();
		return allEleve;
	}

	@Override
	public void updateEleve(Eleve e) {
		Session session = hibernateUtil.getSessionf().getCurrentSession();
		session.beginTransaction();
		try {
			session.update(e);
			
		} catch (HibernateException e1) {
			session.getTransaction().rollback();
			e1.printStackTrace();
		}
		
		session.getTransaction().commit();
	}

	@Override
	public Eleve getEleve(String cne) {
		Eleve e = null;
		Session session = hibernateUtil.getSessionf().getCurrentSession();
		session.beginTransaction();
		try {
			
			e = session.get(Eleve.class, cne);
			
		} catch (HibernateException e1) {
			session.getTransaction().rollback();
			e1.printStackTrace();
		}
		session.getTransaction().commit();
		return e;
	}

	@Override
	public List<Eleve> SearchByKeyInEleve(String Key) {
		List<Eleve> AllEleve =null;
		Session session = hibernateUtil.getSessionf().getCurrentSession();
		session.beginTransaction();
		try {
			
			Query req = session.createQuery("SELECT e FROM Eleve e WHERE e.cne_eleve LIKE :x "
					+ "OR e.nom_eleve LIKE :y"
					+ " OR e.prenom_eleve LIKE :z");
			String KeyIsLike = "%"+Key+"%";
			req.setString("x", KeyIsLike);
			req.setString("y", KeyIsLike);
			req.setString("z", KeyIsLike);
			AllEleve = req.list();
			
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		session.getTransaction().commit();
		return AllEleve;
	}

	// --------------------Operation on Enseignant CLASS-------------------------//
	
	@Override
	public void addEnseignant(Enseignant en) {
		Session session = hibernateUtil.getSessionf().getCurrentSession();
		session.beginTransaction();
		try {
			
			session.save(en);
			
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		session.getTransaction().commit();
	}

	@Override
	public void deleteEnseignant(String CIN) {
		Session session = hibernateUtil.getSessionf().getCurrentSession();
		session.beginTransaction();
		try {
			
			module en = session.get(module.class,CIN);
			session.delete(en);
			
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		session.getTransaction().commit();
	}

	@Override
	public List<Enseignant> AllEnseignant() {
		List<Enseignant> allEnseignant = null;
		Session session = hibernateUtil.getSessionf().getCurrentSession();
		session.beginTransaction();
		try {
			
			allEnseignant = session.createQuery("select e from Enseignant e").list();
			
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		session.getTransaction().commit();
		return allEnseignant;
	}

	@Override
	public void updateEnseignant(Enseignant en) {
		Session session = hibernateUtil.getSessionf().getCurrentSession();
		session.beginTransaction();
		try {
			
			session.update(en);
			
		} catch (HibernateException e1) {
			session.getTransaction().rollback();
			e1.printStackTrace();
		}
		session.getTransaction().commit();
	}

	@Override
	public Enseignant getEnseignant(String CIN) {
		Enseignant en = null;
		Session session = hibernateUtil.getSessionf().getCurrentSession();
		session.beginTransaction();
		try {
			
			en = session.get(Enseignant.class, CIN);
			
		} catch (HibernateException e1) {
			session.getTransaction().rollback();
			e1.printStackTrace();
		}
		session.getTransaction().commit();
		return en;
	}

	@Override
	public List<Enseignant> SearchByKeyInEnseignant(String Key) {
		List<Enseignant> AllEnseignant =null;
		Session session = hibernateUtil.getSessionf().getCurrentSession();
		session.beginTransaction();
		try {
			
			Query req = session.createQuery("SELECT en FROM Enseignant en WHERE en.CIN LIKE :x "
					+ "OR en.nom_enseignant LIKE :y"
					+ " OR en.prenom_enseignant LIKE :z "
					+ "OR en.num_tele LIKE :w");
			String KeyIsLike = "%"+Key+"%";
			req.setString("x", KeyIsLike);
			req.setString("y", KeyIsLike);
			req.setString("z", KeyIsLike);
			req.setString("w", KeyIsLike);
			AllEnseignant = req.list();
			
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		session.getTransaction().commit();
		return AllEnseignant;
	}

		//------------------------Operation On Module Class--------------------
	
	@Override
	public void addModule(module m) {
		Session session = hibernateUtil.getSessionf().getCurrentSession();
		session.beginTransaction();
		try {
			session.save(m);
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		session.getTransaction().commit();
		
		List<Eleve> allEleve = AllEleve();
		Note n = new Note();
		for (Eleve eleve : allEleve) {
			n.setNote(0);
			n.setEleve(eleve);
			n.setModule(m);
			addNote(n);
		}
		
	}

	@Override
	public void deleteModule(String ID) {
		List<Eleve> allEleve = AllEleve();
		ModuleEleve id = new ModuleEleve();
		id.setModuleId(ID);
		for (Eleve eleve : allEleve) {
			id.setEleveId(eleve.getCne_eleve());
			deleteNote(id);
		}
		
		Session session = hibernateUtil.getSessionf().getCurrentSession();
		session.beginTransaction();
		try {
			module m = session.get(module.class,ID);
			session.delete(m);
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		session.getTransaction().commit();
	}

	@Override
	public List<module> AllModule() {
		
		List<module> AllM = null;
		Session session = hibernateUtil.getSessionf().getCurrentSession();
		session.beginTransaction();
		try {
			
			Query request = session.createQuery("SELECT m FROM module m");
			AllM= request.getResultList();
			
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		session.getTransaction().commit();
		return AllM;
	}

	@Override
	public void updateModule(module m) {
		Session session = hibernateUtil.getSessionf().getCurrentSession();
		session.beginTransaction();
		try {
			session.update(m);
		} catch (HibernateException e1) {
			session.getTransaction().rollback();
			e1.printStackTrace();
		}
		session.getTransaction().commit();
	}

	@Override
	public module getModule(String ID) {
		module m = null;
		Session session = hibernateUtil.getSessionf().getCurrentSession();
		session.beginTransaction();
		try {
			m = session.get(module.class, ID);
		} catch (HibernateException e1) {
			session.getTransaction().rollback();
			e1.printStackTrace();
		}
		session.getTransaction().commit();
		return m;
	}

	@Override
	public List<module> SearchByKeyInModule(String Key) {
		List<module> AllModule =null;
		Session session = hibernateUtil.getSessionf().getCurrentSession();
		session.beginTransaction();
		try {
			Query req = session.createQuery("SELECT m FROM module m WHERE m.module_id LIKE :x "
					+ "OR m.module_libelle LIKE :y");
			String KeyIsLike = "%"+Key+"%";
			req.setString("x", KeyIsLike);
			req.setString("y", KeyIsLike);
			AllModule = req.list();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		session.getTransaction().commit();
		return AllModule;
	}

	
	//--------------------------------OPERATION ON Note Class------------------------------
	
	@Override
	public void addNote(Note n) {
		Session session = hibernateUtil.getSessionf().getCurrentSession();
		session.beginTransaction();
		try {
			session.save(n);
		} catch (HibernateException e1) {
			session.getTransaction().rollback();
			e1.printStackTrace();
		}
		session.getTransaction().commit();
	}
	
	@Override
	public List<Note> AllNote(){
		List<Note> Allnote = null;
		Session session = hibernateUtil.getSessionf().getCurrentSession();
		session.beginTransaction();
		try {
			Query request = session.createQuery("SELECT n FROM Note n");
			Allnote= request.getResultList();
			
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		session.getTransaction().commit();
		return Allnote;
	}

	@Override
	public void deleteNote(ModuleEleve Id) {
		Session session = hibernateUtil.getSessionf().getCurrentSession();
		session.beginTransaction();
		try {
			
			Note n = session.get(Note.class, Id);
			
			if (n != null) {
				session.delete(n);
			}
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		session.getTransaction().commit();
	}

	@Override
	public void updateNote(ModuleEleve Id,Double note) {
		Note n = getNote(Id);
		Session session = hibernateUtil.getSessionf().getCurrentSession();
		session.beginTransaction();
		try {
			n.setNote(note);
			session.update(n);
			
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		session.getTransaction().commit();
	}

	@Override
	public Note getNote(ModuleEleve Id) {
		Note n = null;
		Session session = hibernateUtil.getSessionf().getCurrentSession();
		session.beginTransaction();
		try {
			n = session.get(Note.class, Id);
			
		} catch (HibernateException e1) {
			session.getTransaction().rollback();
			e1.printStackTrace();
		}
		session.getTransaction().commit();
		return n;
	}

	@Override
	public List<Note> getListForSpecificModule(String module) {
		Session session = hibernateUtil.getSessionf().getCurrentSession();
		session.beginTransaction();
		List<Note> notes = null;
		try {
			Query req = session.createQuery("SELECT n FROM Note n WHERE n.module.module_id = :x");
			req.setString("x", module);
			notes = req.list();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		session.getTransaction().commit();
		return notes;
	}

	@Override
	public List<Note> getListForSpecificEleve(String eleve) {
		Session session = hibernateUtil.getSessionf().getCurrentSession();
		session.beginTransaction();
		List<Note> notes = null;
		try {
			Query req = session.createQuery("SELECT n FROM Note n WHERE n.eleve.cne_eleve = :x");
			req.setString("x", eleve);
			notes = req.list();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		session.getTransaction().commit();
		return notes;
	}
}
