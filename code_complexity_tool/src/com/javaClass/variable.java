package com.javaClass;

public class variable {
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
	
	public String getTable() {
		String[] lines = displayCode();
		String output = "";
		
		output =  "<table border=\"1\">"
				+ "<tr><th> Code Lines </th>"
				+"<th>Wvs</th>"
				+ "<th>Npdtv</th"
				+"<th>Ncdtv</th>"
				+"<th>Cv</th></tr>";
		int i = 0;
		int j = lines.length;
		while(j >0) {
			output += "<tr><td>" +lines[i]+"</td></tr>";
			i++;
			j--;
		}
		output +="</table>";
		
		return output;
		
	}

}
