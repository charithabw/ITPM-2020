package com.javaClass;

import com.servlet.codeServlet;
import com.sun.org.apache.xpath.internal.operations.Variable;

public class AllFactors {

	private String code;	
	int[] ccpValue ;
	int[] ccsValue;
	int[] csValue;
	int[] cmValue;
	int[] cvValue;
	int totccpValue = 0;
	int totccsValue = 0;
	int totcsValue =0;
	int totcmValue = 0;
	int totcvValue = 0;

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
	public void getCSValue() {
		Size si = new Size();
		si.setCode(code);
		csValue = si.getcsValue();
		
	}
	public void getCMValue() {
		SizeVariable me = new SizeVariable();
		me.setCode(code);
		cmValue = me.getcmValue();
		
	}
	public void getCVValue() {
		variable va = new variable();
		va.setCode(code);
		cvValue = va.getcvValue();
		
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	public String gettable() {
		getCCPValue();
		getCCSValue();
		getCSValue();
		getCMValue();
		getCVValue();
		String output = "";
		String test = "0";
		String[] lines = code.split("\\r?\\n");
		int totCCP = 0;
		int totCCS = 0;		
		int totCS = 0;
		int totCM = 0;
		int totCV = 0;
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
			totCS = totCS + csValue[i];
			totCM = totCM + cmValue[i];
			totCV = totCV + cvValue[i];
			
			output += "<tr><th>" + k++ + "</th>";
			output += "<td>" + lines[i] + "</td>";
			output += "<td>" + csValue[i] + "</td>";
			output += "<td>" + cvValue[i] + "</td>";
			output += "<td>" + cmValue[i] + "</td>";
			output += "<td>" + test + "</td>";
			output += "<td>" + ccpValue[i] + "</td>";
			output += "<td>" + ccsValue[i] + "</td>";
			output += "<td>" + (ccpValue[i] + ccsValue[i] + csValue[i] + cmValue[i] + cvValue[i]) + "</td></tr>";
			i++;
			j--;
		}
		
		total = totCCP + totCCS + totCS + totCM + totCV;
		
		output += "<tr><th bgcolor= '#FDEDEC '></th>";
		output += "<th bgcolor= '#FDEDEC '>" +"TOTAL"+"</th>";
		output += "<th bgcolor= '#FDEDEC '>" +totCS+"</th>";
		output += "<th bgcolor= '#FDEDEC '>" +totCV+"</th>";
		output += "<th bgcolor= '#FDEDEC '>" +totCM+"</th>";
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
				totccsValue = totccsValue + ccsValue[i];
				i++;
				j--;
			}
		
	}
public void getTotCS() {
			
			Size si = new Size();
			si.setCode(code);
			csValue = si.getcsValue();
			String[] lines = code.split("\\r?\\n");
			int i = 0;
			int j = lines.length;
			while(j > 0) {
				totcsValue = totcsValue + csValue[i];
				i++;
				j--;
			}
		
	}
public void getTotCM() {
	
	SizeVariable me = new SizeVariable();
	me.setCode(code);
	cmValue = me.getcmValue();
	String[] lines = code.split("\\r?\\n");
	int i = 0;
	int j = lines.length;
	while(j > 0) {
		totcmValue = totcmValue + cmValue[i];
		i++;
		j--;
	}

}
public void getTotCV() {
	
	variable va = new variable();
	va.setCode(code);
	cvValue = va.getcvValue();
	String[] lines = code.split("\\r?\\n");
	int i = 0;
	int j = lines.length;
	while(j > 0) {
		totcvValue = totcvValue + cvValue[i];
		i++;
		j--;
	}

}
	
	public int[] gettotalValue() {
		getTotCCP();
		getTotCCS();
		getTotCS();
		getTotCM();
		getTotCV();
		int[] tot = new int[6];
		tot[0] = totcsValue;
		tot[1] = totcvValue;
		tot[2] = totcmValue;
		tot[3] = 0;
		tot[4] = totccpValue;
		tot[5] = totccsValue;		
		//System.out.println(totccpValue);
		return tot;
	}
}
