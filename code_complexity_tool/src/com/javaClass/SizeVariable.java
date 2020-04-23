package com.javaClass;

public class SizeVariable {
	
	String code;
	public void setCode(String code) {
		this.code = code;
		}
	public String getCode() {
		return code;
	}

	public String[] displayCode() {
		String[] lines = getCode().split("\\r?\\n");
		for(String line : lines) {
			String tLine = line.trim();
			
			
		}
		return lines;
	}
	
	
	public String getMethod(String statement) {
		String newStr = statement;
		String method = null;
		String[] words = newStr.split(" ");
		
		if(statement.contains("public") ||statement.contains("private") || statement.contains("void")) 
		{
			for(String word :words) {
				if(word.contains("("))
				{
					method = word.substring(0, word.indexOf("(") +1);
					break;
				}
			}
			
		}
		return method;
		
	}
	
	
	/*public String primitive(String statement) {
		String newStr = statement;
		String type = null;
		String[] words = newStr.split(" ");
		
		if(statement.contains("int") ||statement.contains("char") || statement.contains("String") || statement.contains("boolean")) 
		{
			for(String word :words) {
				if(word.contains("("))
				{
					type = word.substring(0, word.indexOf("(") +1);
					break;
				}
			}
			
		}
		return type;
	}*/
	
	public int[] ismethod(){
		String[] lines = code.split("\\r?\\n");
		int[] score = new int[lines.length];
		int s =0;
		for(String line : lines) {
			String tline = line.trim();
			if(getMethod(tline) != null){
				score[s] = 1;
				s++;
			}
			else
			{
				score[s] = 0;
				s++;
			}
			
		
		}
		return score;
		
		
	}
	/*public int[] isPrimitive(){
		String[] lines = code.split("\\r?\\n");
		int[] score = new int[lines.length];
		int s =0;
		for(String line : lines) {
			String tline = line.trim();
			if(primitive(tline) != null){
				score[s] = 1;
				s++;
			}
			else
			{
				score[s] = 0;
				s++;
			}
			
		
		}
		return score;
		
		
	}
	*/
	
	
	public String getTable() {
		String[] lines = displayCode();
		int[] method = ismethod();
		//int[] primit = isPrimitive();
		String output = "";
		
		output =  "<table border=\"1\">"
				+ "<tr><th> Code Lines </th>"
				+"<th>Wmrt</th>"
				+ "<th>Npdtp</th"
				+"<th>Ncdtp</th>"
				+"<th>Cm</th></tr>";
		int i = 0;
		int j = lines.length;
		while(j >0) {
			output += "<tr><td>" +lines[i]+"</td>";
			output += "<td>"+method[i]+"</td></tr>";
			
			i++;
			j--;
		}
		output +="</table>";
		
		return output;
		
	}
}
