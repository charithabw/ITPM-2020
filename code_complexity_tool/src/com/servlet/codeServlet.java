package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaClass.ControllStructure;
import com.javaClass.Coupling;
import com.javaClass.Inheritance;
import com.javaClass.SizeVariable;


/**
 * Servlet implementation class codeServlet
 */
@WebServlet("/codeServlet")
public class codeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public codeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String code =  request.getParameter("code");
		String button = request.getParameter("button");
		
		if(button.equals("SizeVariable")) {
			
			SizeVariable sizeVariable = new SizeVariable();
			
			
			
			request.getRequestDispatcher("size_variable_method.jsp").forward(request, response);
		}
		if(button.equals("Inheritance")) {
			
			Inheritance inheritance = new Inheritance();
			
			
			
			request.getRequestDispatcher("inheritance.jsp").forward(request, response);
		}
		if(button.equals("ControlStructure")) {
			
			ControllStructure controllStructure = new ControllStructure();
			
			
			
			request.getRequestDispatcher("control_structures.jsp").forward(request, response);
		}
		if(button.equals("Coupling")) {
			
			Coupling couling = new Coupling();
			couling.setCode(code);
		String tb =	couling.getTable();
//			String[] codeLines = couling.displayCode();
//			int[] score = couling.isRecursive(code);
//			request.setAttribute("codelines", codeLines);
//			request.setAttribute("score", score);
		request.setAttribute("tb", tb);
			
			request.getRequestDispatcher("coupling.jsp").forward(request, response);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
