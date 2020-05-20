package com.weightServlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaClass.Inheritance;
import com.model.InheritanceModel;
import com.servlet.codeServlet;

/**
 * Servlet implementation class WeightInheirtanceServlet
 */
@WebServlet("/WeightInheirtanceServlet")
public class WeightInheirtanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WeightInheirtanceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String button = request.getParameter("submit");
		
		String ziro =  request.getParameter("ziro");
		String one =  request.getParameter("one");
		String two =  request.getParameter("two");
		String three =  request.getParameter("three");
		String four =  request.getParameter("four");
		
		if(button.equals("save")) {
			Inheritance i = new Inheritance();
			
			i.setWeights(Integer.parseInt(ziro), Integer.parseInt(one), Integer.parseInt(two), Integer.parseInt(three), Integer.parseInt(four));
			
			codeServlet cs = new codeServlet();
			String code = cs.returnCode();
			//System.out.println(code);
			//Inheritance inheritance = new Inheritance();
			i.setCode(code);
			List<InheritanceModel> inheritanceList = i.getComplexity();
			request.setAttribute("inheritanceList", inheritanceList);
			request.getRequestDispatcher("inheritance.jsp").forward(request, response);
		}
		doGet(request, response);
	}

	}
