package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Eleve;
import Model.IOperationOnModel;
import Model.OperationOnModel;

public class EleveServletController extends HttpServlet{
		
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
		if (action != null) {
			String ConfirmSuccess;
			boolean error = false;
			Eleve e = new Eleve();
			if (action.equalsIgnoreCase("add")) {
				request.getRequestDispatcher("Views/addEleve.jsp").forward(request, response);
			}
			else if (action.equalsIgnoreCase("save")) {
				
				e.setCne_eleve(request.getParameter("cne"));
				e.setNom_eleve(request.getParameter("EleveName"));
				e.setPrenom_eleve(request.getParameter("ElevePrenom"));
					if (request.getParameter("addOrUpdate").equalsIgnoreCase("add")) {
						if (model.getEleve(e.getCne_eleve()) != null) {
							error = true;
							e.setCne_eleve(null);
							request.setAttribute("error", error);
							request.setAttribute("eleve", e);
							request.getRequestDispatcher("Views/addEleve.jsp").forward(request, response);
						} else {
							model.addEleve(e);
							ConfirmSuccess = "added";
							request.setAttribute("ConfirmSuccess", ConfirmSuccess);
						} 
					}
					else{
						model.updateEleve(e);
						ConfirmSuccess = "updated";
						request.setAttribute("ConfirmSuccess", ConfirmSuccess);
					}
			}
			else if(action.equalsIgnoreCase("update")) {
				e = model.getEleve(request.getParameter("ref"));
				request.setAttribute("eleve", e);
				request.getRequestDispatcher("Views/addEleve.jsp").forward(request, response);
			}
			else if (action.equalsIgnoreCase("delete")) {
				model.deleteEleve(request.getParameter("ref"));
				ConfirmSuccess = "deleted";
				request.setAttribute("ConfirmSuccess",ConfirmSuccess);
			}
		}
		
		
		request.setAttribute("eleves", model.AllEleve());
		request.getRequestDispatcher("Views/Eleves.jsp").forward(request, response);
		
	}
	
	
}
