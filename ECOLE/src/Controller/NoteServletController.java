package Controller; 

import java.io.IOException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.IOperationOnModel;
import Model.ModuleEleve;
import Model.Note;
import Model.OperationOnModel;

public class NoteServletController extends HttpServlet{

	private IOperationOnModel model;
	@Override
	public void init() throws ServletException {
		model = new OperationOnModel();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action != null){
			if (action.equalsIgnoreCase("show") || action.equalsIgnoreCase("updateNoteForModule")) {
				String ReferenceModule = request.getParameter("ref");
				request.setAttribute("moduleName", model.getModule(ReferenceModule));
				//get the list of notes for specific module by his reference "ref"
				request.setAttribute("notes",
						model.getListForSpecificModule(ReferenceModule));
				if (action.equalsIgnoreCase("show")) {
					request.getRequestDispatcher("Views/NoteShow.jsp").forward(request, response);
				}
				else
					request.getRequestDispatcher("Views/NoteShowAndEdit.jsp").forward(request, response);
			}
			else if (action.equalsIgnoreCase("saveNote")) {
				//geting a list of values from jsp page! 
				// a list of notes to update the notes inserted in the form
				// a list of CNE of all eleve objects
				// and an attribute Id Module to create an id of Note (ID Note is type ModuleEleve ) 
				String[] listNotes= request.getParameterValues("note");
				String[] listCNE= request.getParameterValues("listCneEleve");
				String IdModule = request.getParameter("IdModule");
				
				//We need to iterate over this two string[] in the same time!! the solution is to use Iterator<String>
				//So to put the String[] in Iterator variable it must be an Arraylist because we can't use iterator() method on String[]
				
				//Put all the values from the Two String[] listNotes and listCNE To the ArrayList's
				ArrayList<String> LsNotes = new ArrayList<String>();
				ArrayList<String> LsCNE = new ArrayList<String>();
				for (String n : listNotes) {
					LsNotes.add(n);
				}
				for (String c : listCNE) {
					LsCNE.add(c);
				}
				//Create the iterator attributes!
				Iterator<String> LNotes = LsNotes.iterator();
				Iterator<String> LCNE = LsCNE.iterator();
				//Create the Id for Note object! and set the moduleid NOW because we will not change it||
				// We will change the note for differents Eleves for specific Module!
				ModuleEleve idnote = new ModuleEleve();
				idnote.setModuleId(IdModule);
				//Now iterate over the two iterator attributes and set every next value the CNE id and call the update method for the NOTE object!
				while (LCNE.hasNext() && LNotes.hasNext()) {
					idnote.setEleveId(LCNE.next());
					model.updateNote(idnote, Double.parseDouble(LNotes.next()));
				}
				//then redirect to the show note page for the previous specific module!
				
				request.setAttribute("moduleName", model.getModule(IdModule));
				//get the list of notes for specific module by his reference "IdModule"
				request.setAttribute("notes",model.getListForSpecificModule(IdModule));
				request.getRequestDispatcher("Views/NoteShow.jsp").forward(request, response);
			}
			else if(action.equalsIgnoreCase("ParRapportModule")){
				request.setAttribute("modules", model.AllModule());
				request.getRequestDispatcher("Views/NoteCategoryModule.jsp").forward(request, response);
			}
			else if (action.equalsIgnoreCase("ParRapportEleve")) {
				request.setAttribute("eleves", model.AllEleve());
				request.getRequestDispatcher("Views/NoteCategoryEleve.jsp").forward(request, response);
			}
			//New task: Complete modifier les notes des modules pour chaque élève!!!!!//
			else if (action.equalsIgnoreCase("showNoteEleve") || action.equalsIgnoreCase("updateNoteForEleve")) {
				String ReferenceEleve = request.getParameter("ref");
				request.setAttribute("eleve", model.getEleve(ReferenceEleve));
				request.setAttribute("modules", model.AllModule());
				//get the list of notes for specific eleve by his reference "ref"
				request.setAttribute("notes",
						model.getListForSpecificEleve(ReferenceEleve));
				if (action.equalsIgnoreCase("showNoteEleve")) {
					request.getRequestDispatcher("Views/NoteShowForEleve.jsp").forward(request, response);
				}
				else
					request.getRequestDispatcher("Views/NoteShowAndEditForEleve.jsp").forward(request, response);
			}
			else if (action.equalsIgnoreCase("saveNoteForEleve")) {
				//the update note for a speific eleve! 
				//will go the same way as when the action equals saveNote! 
				
				//geting a list of values from jsp page! 
				// a list of notes to update the notes inserted in the form
				// a list of Id of all module objects
				// and an attribute Cne Eleve to create an id of Note (ID Note is type ModuleEleve ) 
				String[] listNotes= request.getParameterValues("note");
				String[] listIdsModule= request.getParameterValues("listIdsModule");
				String CneEleve = request.getParameter("IdEleve");
				
				//We need to iterate over this two string[] in the same time!! the solution is to use Iterator<String>
				//So to put the String[] in Iterator variable it must be an Arraylist because we can't use iterator() method on String[]
				
				//Put all the values from the Two String[] listNotes and listIdsModule To the ArrayList's
				ArrayList<String> LsNotes = new ArrayList<String>();
				ArrayList<String> IdsModule = new ArrayList<String>();
				for (String n : listNotes) {
					LsNotes.add(n);
				}
				for (String c : listIdsModule) {
					IdsModule.add(c);
				}
				//Create the iterator attributes!
				Iterator<String> LNotes = LsNotes.iterator();
				Iterator<String> LIds = IdsModule.iterator();
				//Create the Id for Note object! and set the CneEleve NOW because we will not change it||
				// We will change the note for differents Modules for specific Eleve!
				ModuleEleve idnote = new ModuleEleve();
				idnote.setEleveId(CneEleve);;
				//Now iterate over the two iterator attributes and set every next value the Module id and call the update method for the NOTE object!
				while (LIds.hasNext() && LNotes.hasNext()) {
					idnote.setModuleId(LIds.next());
					model.updateNote(idnote, Double.parseDouble(LNotes.next()));
				}
				//then redirect to the show note page for the previous specific module!
				
				request.setAttribute("eleve", model.getEleve(CneEleve));
				
				//get the list of notes for specific eleve by his reference "CneEleve"
				request.setAttribute("notes",model.getListForSpecificEleve(CneEleve));
				request.getRequestDispatcher("Views/NoteShowForEleve.jsp").forward(request, response);
				
			}
		}
		request.getRequestDispatcher("Views/NoteShowCategory.jsp").forward(request, response);
	}
}






