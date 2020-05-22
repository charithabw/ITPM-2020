package com.weightServlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import com.javaClass.Coupling;
import com.javaClass.WeightsCoupling;
import com.servlet.codeServlet;


@WebServlet("/WeightCouplingServlet")
public class WeightCouplingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public WeightCouplingServlet() {
        super();
       
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//request.getRequestDispatcher("coupling.jsp").forward(request, response);
		
//		
			}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String button = request.getParameter("submit");
		
		
		String wNr =  request.getParameter("wNr");
		String wNmcms =  request.getParameter("wNmcms");
		String wNmcmd =  request.getParameter("wNmcmd");
		String wNmcrms =  request.getParameter("wNmcrms");
		String wNmcrmd =  request.getParameter("wNmcrmd");
		String wNrmcrms =  request.getParameter("wNrmcrms");
		String wNrmcrmd =  request.getParameter("wNrmcrmd");		
		String wNrmcms =  request.getParameter("wNrmcms");
		String wNrmcmd =  request.getParameter("wNrmcmd");
		String wNmrgvs =  request.getParameter("wNmrgvs");
		String wNmrgvd =  request.getParameter("wNmrgvd");
		String wNrmrgvs =  request.getParameter("wNrmrgvs");
		String wNrmrgvd =  request.getParameter("wNrmrgvd");
		
		if(button.equals("save")) {
		Coupling c = new Coupling();
		c.weights(Integer.parseInt(wNr), Integer.parseInt(wNmcms), Integer.parseInt(wNmcmd), Integer.parseInt(wNmcrms), Integer.parseInt(wNmcrmd), Integer.parseInt(wNrmcrms), Integer.parseInt(wNrmcrmd), Integer.parseInt(wNrmcms), Integer.parseInt(wNrmcmd), Integer.parseInt(wNmrgvs), Integer.parseInt(wNmrgvd), Integer.parseInt(wNrmrgvs), Integer.parseInt(wNrmrgvd));
		
		
		
		codeServlet cs = new codeServlet();
		String code = cs.returnCode();
		//System.out.println(code);
		//Coupling couling = new Coupling();
		c.setCode(code);
		String tb =	c.getTable();
		request.setAttribute("tb", tb);
		request.getRequestDispatcher("coupling.jsp").forward(request, response);
		
		
		}
		doGet(request, response);
	}

}
