package com.javaClass;

import com.servlet.codeServlet;

public class AllFactors {
	codeServlet cs = new codeServlet();
	private String code = cs.returnCode();
	
	
	
	public String gettable() {
		String output = "";
		String test = "";
		String[] lines = code.split("\\r?\\n");
		
		output = "<table class= 'table table-hover' border='1'>"
				+ "<tr><th bgcolor= '#839192 '>Code Lines</th><th bgcolor= '#839192' >Cs</th><th bgcolor= '#839192'  >Cv</th><th bgcolor= '#839192' >Cm</th>"
				+"<th bgcolor= '#839192 '>Ci</th>><th bgcolor= '#839192 '>Ccp</th> <th bgcolor= '#839192 '>Ccs</th> <th bgcolor= '#839192 '>TCPS</th></tr>";
		int i = 0;
		int j = lines.length;
		while(j > 0) {
			
			
			output += "<tr><td>" + lines[i] + "</td>";
			output += "<td>" + test + "</td>";
			output += "<td>" + test + "</td>";
			output += "<td>" + test + "</td>";
			output += "<td>" + test + "</td>";
			output += "<td>" + test + "</td>";
			output += "<td>" + test + "</td>";
			output += "<td>" + test + "</td></tr>";
			i++;
			j--;
		}
		output += "</table>"; 
		return output;
	}
}