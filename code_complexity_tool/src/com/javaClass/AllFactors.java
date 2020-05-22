package com.javaClass;

import com.servlet.codeServlet;

public class AllFactors {

	private String code;	
	int[] ccpValue ;
	int[] ccsValue;
	int totccpValue = 0;
	int totccsValue = 0;

	public void getCCPValue() {		
		Coupling c = new Coupling();
		c.setCode(code);		
		ccpValue = c.getccpValue();
//		for(int i = 0; i < c.getccpValue().length; i++) {
//			
//			System.out.println(c.getccpValue()[i]);
//		}
//		System.out.println(ccpValue.length);
	}
	public void getCCSValue() {
		ControllStructure cnts = new ControllStructure();
		cnts.setCode(code);
		ccsValue = cnts.getccsValue();
		
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	public String gettable() {
		getCCPValue();
		getCCSValue();
		String output = "";
		String test = "";
		String[] lines = code.split("\\r?\\n");
		int totCCP = 0;
		int totCCS = 0;
		int total = 0;
		
		output = "<table class= 'table table-hover' border='1'>"
				+ "<tr><th bgcolor= '#839192 '>Line NO.</th><th bgcolor= '#839192 '>Code Lines</th><th bgcolor= '#839192' >Cs</th><th bgcolor= '#839192'  >Cv</th><th bgcolor= '#839192' >Cm</th>"
				+"<th bgcolor= '#839192 '>Ci</th>><th bgcolor= '#839192 '>Ccp</th> <th bgcolor= '#839192 '>Ccs</th> <th bgcolor= '#839192 '>TCPS</th></tr>";
		int i = 0;
		int k = 1;
		int j = lines.length;
		while(j > 0) {
			
			totCCP = totCCP + ccpValue[i];
			totCCS = totCCS + ccsValue[i];
			
			output += "<tr><th>" + k++ + "</th>";
			output += "<td>" + lines[i] + "</td>";
			output += "<td>" + test + "</td>";
			output += "<td>" + test + "</td>";
			output += "<td>" + test + "</td>";
			output += "<td>" + test + "</td>";
			output += "<td>" + ccpValue[i] + "</td>";
			output += "<td>" + ccsValue[i] + "</td>";
			output += "<td>" + (ccpValue[i] + ccsValue[i]) + "</td></tr>";
			i++;
			j--;
		}
		
		total = totCCP + totCCS;
		
		output += "<tr><th bgcolor= '#FDEDEC '></th>";
		output += "<th bgcolor= '#FDEDEC '>" +"TOTAL"+"</th>";
		output += "<th bgcolor= '#FDEDEC '>" +test+"</th>";
		output += "<th bgcolor= '#FDEDEC '>" +test+"</th>";
		output += "<th bgcolor= '#FDEDEC '>" +test+"</th>";
		output += "<th bgcolor= '#FDEDEC '>" +test+"</th>";
		output += "<th bgcolor= '#FDEDEC '>" +totCCP+"</th>";
		output += "<th bgcolor= '#FDEDEC '>" +totCCS+"</th>";
		output += "<th bgcolor= '#FDEDEC '>" +total+"</th></tr>";
		
		output += "</table>"; 
		return output;
	}
	public void getTotCCP() {
		
		Coupling c = new Coupling();
		c.setCode(code);
		ccpValue = c.getccpValue();
		String[] lines = code.split("\\r?\\n");
		int i = 0;
		int j = lines.length;
		while(j > 0) {
			totccpValue = totccpValue + ccpValue[i];
			i++;
			j--;
		}
	}	
		public void getTotCCS() {
			
			ControllStructure cnts = new ControllStructure();
			cnts.setCode(code);
			ccsValue = cnts.getccsValue();
			String[] lines = code.split("\\r?\\n");
			int i = 0;
			int j = lines.length;
			while(j > 0) {
				totccpValue = totccpValue + ccpValue[i];
				totccsValue = totccsValue + ccsValue[i];
				i++;
				j--;
			}
		
	}
	public int[] gettotalValue() {
		getTotCCP();
		getTotCCS();
		int[] tot = new int[6];
		tot[0] = 0;
		tot[1] = 0;
		tot[2] = 0;
		tot[3] = 0;
		tot[4] = totccpValue;
		tot[5] = totccsValue;		
		//System.out.println(totccpValue);
		return tot;
	}
}
