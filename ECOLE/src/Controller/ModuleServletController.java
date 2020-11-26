package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.IOperationOnModel;
import Model.OperationOnModel;
import Model.module;

public class ModuleServletController extends HttpServlet{
	
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
		module m = new module();
		boolean error;
		String successUpdate = null;
		if (action != null) {
			if(action.equalsIgnoreCase("add")) {
				
				request.getRequestDispatcher("Views/addModule.jsp").forward(request, response);
			}
			else if (action.equalsIgnoreCase("update")) {
				m= model.getModule(request.getParameter("ref"));
				request.setAttribute("module", m);
				request.getRequestDispatcher("Views/addModule.jsp").forward(request, response);
			}
			else if (action.equalsIgnoreCase("save")) {
				String addOrUpdate = request.getParameter("addOrUpdate");
				String moduleId = request.getParameter("moduleId");
				String moduleName = request.getParameter("moduleName");
				m.setModule_id(moduleId);
				m.setModule_libelle(moduleName);	
					if (addOrUpdate.equalsIgnoreCase("add")) {
						if (model.getModule(m.getModule_id())!= null) {
							m.setModule_id(null);
							error = true;
							request.setAttribute("error", error);
							request.setAttribute("module", m);
							request.getRequestDispatcher("Views/addModule.jsp").forward(request, response);
						}
						else {
							error = false;
							model.addModule(m);
							//this attribute to check in module page after an add|
							//so if everything goes well a card shows to tell the user that the module added succefully!
							successUpdate = "added";
							request.setAttribute("ConfirmSuccess", successUpdate);
						}
					}
					if (addOrUpdate.equalsIgnoreCase("update")) {
						model.updateModule(m);
						//this attribute to check in module page after an update|
						//so if everything goes well a card shows to tell the user that the module updated succefully!
						successUpdate = "updated";
						request.setAttribute("ConfirmSuccess", successUpdate);
					}
				
			}
			else if(action.equalsIgnoreCase("delete")){
				model.deleteModule(request.getParameter("ref"));
			}
			
		}
		
			request.setAttribute("modules", model.AllModule());
			request.getRequestDispatcher("Views/Modules.jsp").forward(request, response);
	}
}
