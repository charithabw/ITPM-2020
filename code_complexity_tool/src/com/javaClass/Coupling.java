package com.javaClass;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.Stack;

import org.apache.tomcat.jni.Sockaddr;

import sun.security.util.Length;

public class Coupling {
	//charitha
	//bandara
	String code ;
	 boolean recursive;
	public void setCode(String code) {
		this.code = code;
		//System.out.println(code);
	}
	public String getCode() {
		return code;
	}
	
	public String[] displayCode() {
		
//		String r= "ccc";
//		int value = 0;
		 String[] lines = getCode().split("\\r?\\n");
	        for(String line : lines) {
	        	String tLine = line.trim();
	        	//return (tLine);
	        	
		}
	     
		return lines;
	}
	
	
//	public String[] getCount() {
//		// TODO Auto-generated method stub
//		File file = new File("F://charitha//test.txt");
//		if(file.exists()) {
//			try {
//				FileReader fr = new FileReader(file);
//				LineNumberReader lnr = new LineNumberReader(fr);
//				int lineNOCount = 0;
//				String[]  code;
//				try {
//					BufferedReader br = new BufferedReader(fr);
//					String line;
//					code = new String[20];
//					while((line = br.readLine()) != null) {
//						
//						lineNOCount ++;
//						code[lineNOCount] = (lineNOCount +" : "+line);
//						
//						
//					}
//					return code;
//					//System.out.println("LINE: " +lineNOCount);
//					//return lineNOCount;
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			} catch (FileNotFoundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		String[] test = {"s", "g"};
//		return test;
//	}
//	
	
	
	 public String getMethod(String statement)
     {
		
         String newStr = statement;
         String method = null;
         String[] words = newStr.split(" ");
        
//         String[] methodTypeWords = new String[] { "public", "private", "void" };
//         List <String> list = Arrays.asList(methodTypeWords);
//         CharSequence s = "public";
       
         if (statement.contains("public") || statement.contains("private") || statement.contains("void"))
         {	
        	// System.out.println("ccc"); 
             for (String word : words) {
            	//System.out.println(word);
                 if (word.contains("("))
                 {
                     method = word.substring(0, word.indexOf("(") + 1);
                   // System.out.println(method);
                     break;
                 }

             }
         }

         return method;
     }
	 
	 
	 public int[] checkRecursive(String code) {
			
			
			String[] lines = code.split("\\r?\\n");
			int[] score = new int[lines.length];
			//System.out.println(score.length);
			Stack<String> methodsStack = new Stack<String>();
			Stack<Integer> stackback = new Stack<Integer>();
			ArrayList<String> reverseMethodArray = new ArrayList<String>();
			String method ;  
			
		 for(String line: lines) {
				  if(getMethod(line) != null) {
					  methodsStack.push(getMethod(line));
				  }
			  }	
		 
		 
		  int methodLength = methodsStack.size();
		  
		  //System.out.println(stackback.size());
		  for(int i = 0; i < methodLength; i++) {
			  	reverseMethodArray.add(methodsStack.pop());
			  	//System.out.println(reverseArray.get(i));
		 }
		  for(int i = 0; i < reverseMethodArray.size();i++) {
			  methodsStack.push(reverseMethodArray.get(i));
		  }
//		  System.out.println(methodsStack.pop());
//		  System.out.println(methodsStack.pop());
		 
//		 for(int j = 0; j < methodsArray.size(); j++) {
//			  	System.out.println(methodsArray.get(j));
//			}
			
		// System.out.println(code.length());
		  
		  for(int i = 0; i < code.length(); i++) {
			  char c = code.charAt(i);
		  
			  if(c == '}') {
				  stackback.push(i);
//				  System.out.println(i);
//				  System.out.println(c);
			  }
		  }
		  
		  
		  ArrayList<Integer> reverseBackArray = new ArrayList<Integer>();
		  int backLength = stackback.size();
		  //System.out.println(stackback.size());
		  for(int i = 0; i < backLength; i++) {
			  	reverseBackArray.add(stackback.pop());
			  //	System.out.println(reverseBackArray.get(i));
		 }
		  for(int i = 0; i < reverseBackArray.size();i++) {
			  stackback.push(reverseBackArray.get(i));
		  }
			
		  int l = code.length();
		  String cusCode;
		  int s = 0;
		  
		  int peekValue = 0;
		  
		  for(String line : lines) {
		  //char c = code.charAt(i);
		  
		 // score[s] = 0;
		  if((line.contains("public") || line.contains("private")) && line.contains("{")) {
//			 System.out.println(line);
//			 System.out.println(">>>>>>>>>>>>>>>>..");
		
			  for(int i =0; i < stackback.size(); i++) {
			  cusCode = code.substring(peekValue,stackback.peek()-1).trim();
			  //System.out.println(cusCode.length());
//			  if(cusCode.contains(".*[a-z].*")) {
//				  System.out.println("empty");
//			  }
//			  else {
			  peekValue = stackback.pop();
			  
//			  System.out.println(cusCode);
//			  System.out.println(">>>>>>>>>>>>>");
			  
	  
			 String [] cusLines = cusCode.split("\\r?\\n");
			 for(String cusLine : cusLines) {
				
			
					
				
					
					 
					  if(!methodsStack.isEmpty()) {
						  if(getMethod(cusLine) != null) {
								 method = getMethod(cusLine);
								 //System.out.println(method);
								 score[s] = 0;
								 s++;
							 }
						  else  if(cusLine.contains(methodsStack.peek())) {
							 score[s] = 1;
							 s++;
								 }
						  else {
							  
							  score[s] = 0;
							  s++;
						  }
					 }
					
				
			  
			 
			 } 
			 //System.out.println(">>>>>>>>>>");
			 if(!methodsStack.isEmpty()) {
			 methodsStack.pop();
			 }
		  }  
		 
		  }
		  }	
			return score;
			
		}
	 
	
	public boolean isRecursive() {
		
		 String[] lines = code.split("\\r?\\n");
		 int[] score = new int[lines.length];
		 score = checkRecursive(code);
		 
		for(int i =0; i < score.length; i++) {
			 if(score[i] == 1) {
				 recursive = true; 
				 break;
			 }
			 continue;
			 
		}
		 			 
		 return recursive;
	 }
	 
	 
	  public String[] separateMethods(String code)
      {
          String[] methodsArray = new String[] { };
          String[] methodLines = new String[] { };

          int startIndex = 0;
          int endIndex = 0;
          int counter = 0;
          String temp = null;
          Boolean flag = false;

          String[] lines = code.split("\\r?\\n");

          for( String line : lines)
          {
              if(flag == true && getMethod(line) != null)

              if(getMethod(line) != null)
              {
                  //startIndex = counter;
                  methodLines[counter] = line;
                  flag = true;
                  temp = getMethod(line);
                  
              }

              if(temp != getMethod(line))
              {
                  
              }

              counter++;
          }

          return methodsArray;
      }
 public boolean checkRegularMethod(String statment) {
		  
	 	 
	 	  boolean regular = false;
	 	  String tStatment = statment.trim();
		  String[] lines = code.split("\\r?\\n");
		  String [] words = code.split(" ");
		  String method = null;
		  String cusmethod = null;
		  int s = 0;
		 // int[] score = new int[lines.length];
		 // System.out.println(score.length);
		  Stack<String> twordArray = new Stack<String>();
		  int peekValue = 0;
		  ArrayList<String> methodsArray = new ArrayList<String>();
		  ArrayList<Character> wordsArray = new ArrayList<Character>();
          
		  Stack<Character> stack = new Stack<Character>();
		  Stack<Character> stackfront = new Stack<Character>();
		  Stack<Integer> stackback = new Stack<Integer>();
		  Stack <String> methodsStack = new Stack<String>();
		  ArrayList<String> reverseMethodArray = new ArrayList<String>();
		  ArrayList<String> cusMethodArray = new ArrayList<String>();
		  
		  String cuscode2  = code;
		 
		  for(String line: lines) {
			  if(getMethod(line) != null) {
				  methodsStack.push(getMethod(line));
			  }
		  }	
	 
	 
	  int methodLength = methodsStack.size();
	  
	  //System.out.println(stackback.size());
	  for(int i = 0; i < methodLength; i++) {
		  	reverseMethodArray.add(methodsStack.pop());
		  	//System.out.println(reverseArray.get(i));
	 }
	  for(int i = 0; i < reverseMethodArray.size();i++) {
		  methodsStack.push(reverseMethodArray.get(i));
		  methodsArray.add(reverseMethodArray.get(i));
	  }
//
//		 System.out.println(methodsStack.pop());
//		 System.out.println(methodsStack.pop());
		 
//			for(int j = 0; j < methodsArray.size(); j++) {
//			  	System.out.println(methodsArray.get(j));
//			}
//			System.out.println("mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm");
		  
		 // System.out.println(code.length());
		  for(int i = 0; i < code.length(); i++) {
			  char c = code.charAt(i);
		  
			  if(c == '}') {
				  stackback.push(i);
//				  System.out.println(i);
//				  System.out.println(c);
			  }
		  }
		  
		  
		  ArrayList<Integer> reverseArray = new ArrayList<Integer>();
		  int value = stackback.size();
		  //System.out.println(stackback.size());
		  for(int i = 0; i < value; i++) {
			  	reverseArray.add(stackback.pop());
			  	//System.out.println(reverseArray.get(i));
		 }
		  for(int i = 0; i < reverseArray.size();i++) {
			  stackback.push(reverseArray.get(i));
		  }
		  
		 // System.out.println(stackback.peek());
		  
//		  System.out.println( stackback.pop());
//		  System.out.println( stackback.pop());
//		  System.out.println( stackback.pop());
		  int l = code.length();
		  
//		  if(isRecursive()) {
//			  System.out.println("recu");
//		  }
//		  else {
//			  System.out.println("not");
//		  }
		  
		  
		 	  	  
		  for(int i = 0; i < methodsArray.size(); i++) {
			  
			  if(tStatment.contains(methodsArray.get(i))) {
				  
				  if(getMethod(tStatment) != null) {
					  regular = false;
				  }
				  else {
				  regular = true;
				  break;
				  }
		  }
			  else {
			  regular =  false;
			  
		  }
		  }
		  return regular;
 }
 
 public int[] isRegular() {
	 String [] lines = code.split("\\r?\\n");
	 int[] score = new int[lines.length];
	 int s =0;
	 for(String line : lines) {
		 String tLine = line.trim();
		 boolean regular = checkRegularMethod(tLine);
		 
		 if(regular) {
			 score[s] = 1;
			 s++;
		 }
		 else {
			 score[s] = 0;
			 s++;
		 }
	 }
	 return score;
	 
 }
 
 public boolean isGlobleVariable(String statment) {
	 
	 String myStatement = statment;
	 boolean variable = false;
	 
	 String[] lines = code.split("\\r?\\n");
	 
	 ArrayList<String> variableArray = new ArrayList<String>();
	 
	 
	 for(String line : lines) {
		 String tline = line.trim();
		 
		 if(getMethod(tline)!= null) {
			 
		 }
		 else if((tline.contains("private") || tline.contains("public")) && (tline.contains("int") || tline.contains("String") 
				 || tline.contains("char") || tline.contains("double") || tline.contains("Dimension"))) {
			 	
			 if(tline.contains("=")) {
				 String[] vars = tline.split("=");
				 for(String var : vars) {
					 String[] myvar = var.split(" ");
					 variableArray.add(myvar[2]);
					 //System.out.println(myvar[2]);
					 break;
				 }
			 }
			 else if(tline.contains(",")) {
				 String[] vars = tline.split(",");
				 for(String var : vars) {
					 String tvar = var.trim();
					 if(tvar.contains("private") || tvar.contains("public")) {
						 String[] myvar = tvar.split(" ");
						 variableArray.add(myvar[2]);
						 
					 }
					 else if(tline.contains(";")) {
						 String[] myvar = tvar.split(";");
						 variableArray.add(myvar[0]);
						 break;
					 }
					 else {
						 variableArray.add(tvar);
					 }
				 }
				 //System.out.println(vars[1]);
			 }
			 else {
				 //System.out.println(tline);
				 String[] vars = tline.split(";");
				 for(String var : vars) {
					 String[] myvar = var.split(" ");
					 variableArray.add(myvar[2]);
					// System.out.println(myvar[2]);
					 break;
					 
				 }
			 }
		 }
	 }
//	 for(int i = 0; i < variableArray.size(); i++) {
//		 System.out.println(variableArray.get(i));
//	 }
	 
	 for(int i =0 ; i < variableArray.size(); i++) {
	 if(myStatement.contains(variableArray.get(i))) {
	 
		 if(getMethod(myStatement) != null){
			 variable = false;
						 
		 }
		 else {
			 variable = true;
			 continue;
			 
		 }
	 }
	
	 }
	 return variable;
	 
 }
 
public int[] checkGloblevariable() {
	
	
	
 String[] lines = code.split("\\r?\\n");
	 
	 ArrayList<String> variableArray = new ArrayList<String>();
	 
	 
	 for(String line : lines) {
		 String tline = line.trim();
		 
		 if(getMethod(tline)!= null) {
			 
		 }
		 else if((tline.contains("private") || tline.contains("public")) && (tline.contains("int") || tline.contains("String") 
				 || tline.contains("char") || tline.contains("double") || tline.contains("Dimension"))) {
			 	
			 if(tline.contains("=")) {
				 String[] vars = tline.split("=");
				 for(String var : vars) {
					 String[] myvar = var.split(" ");
					 variableArray.add(myvar[2]);
					 //System.out.println(myvar[2]);
					 break;
				 }
			 }
			 else if(tline.contains(",")) {
				 String[] vars = tline.split(",");
				 for(String var : vars) {
					 String tvar = var.trim();
					 if(tvar.contains("private") || tvar.contains("public")) {
						 String[] myvar = tvar.split(" ");
						 variableArray.add(myvar[2]);
						 
					 }
					 else if(tline.contains(";")) {
						 String[] myvar = tvar.split(";");
						 variableArray.add(myvar[0]);
						 break;
					 }
					 else {
						 variableArray.add(tvar);
					 }
				 }
				 //System.out.println(vars[1]);
			 }
			 else {
				 //System.out.println(tline);
				 String[] vars = tline.split(";");
				 for(String var : vars) {
					 String[] myvar = var.split(" ");
					 variableArray.add(myvar[2]);
					// System.out.println(myvar[2]);
					 break;
					 
				 }
			 }
		 }
	 }
//	 for(int i = 0; i < variableArray.size(); i++) {
//		 System.out.println(variableArray.get(i));
//	 }
	
	
	
	
	
	
	int[] score = new int[lines.length];
	int s = 0;
	score[s] = 0;
	
	for(String line : lines) {
		String tline = line;
		
		if(isGlobleVariable(tline)) {
			if(tline.contains("public") || tline.contains("private")) {
				score[s] = 1;
				s++;
			}
			else {
			for(int i = 0; i < variableArray.size(); i++) {
			if(tline.contains(variableArray.get(i))) {
				score[s] = score[s] + 1;
			}
			}
			s++;
		}
		}
		else {
			score[s] = 0;
			s++;
		}
	}
	return score;
	
}
 
 
 
	  //ArrayList<String> xline = new ArrayList<String>();
	  
	  //System.out.println(twordArray.get(1));
//		 
//	  for(String line : lines) {
//		  String tline = line.trim();
//		  //System.out.println(twordArray.peek());
//		  //System.out.println(s.toString());
//		  
//		  String s = twordArray.peek();
//		  	if(tline.contains)) {
//		  		System.out.println(tline);
//		  	}
//		  	twordArray.pop(); 
//		  	System.out.println("hiiiiiiiiiiiiiiiiiiiii");
//		  	
//	  }
//	  
	 // System.out.println(">>>>>>>>>>>>>>>>>>>>>>");
	  
//		  for(String line: lines) {
//			  if(getMethod(line) != null) {
//				  methodsArray.add(getMethod(line));
//			  }
//		  }
//		  String braket = code;
//
//		  braket = braket.substring(braket.indexOf("{") + 1);
//		  braket = braket.substring(0, braket.indexOf("}"));
//
//		  //System.out.println(braket);	
//		  
//		  String [] cuswords = braket.split(" ");
//		 // System.out.println(">>>>>>>>>>>>>>>" +methodsArray.get(0));
//		  
//		  for(String word : cuswords) {
//			  String tword = word.trim();
//			  
//			  if (tword.contains("("))
//              {
//				  //System.out.println(tword);
//                   cusmethod = tword.substring(0, tword.indexOf("(") + 1);
//                   //System.out.println(cusmethod);
//                 
//               
//			 
//                  if(methodsArray.contains(cusmethod)) {
//                	  System.out.println(cusmethod);
//                  }
//                  else {
//                	  System.out.println("not");
//                  }
//              }
//		  
//		  }
//	  }	  
//			
		  
//		  	for(int j = 0; j < methodsArray.size(); j++) {
//		  	System.out.println(methodsArray.get(j));
//		  	}
//		  	}
//		  		for(String line : lines) {
//				  if(getMethod(line) != null) {
//					  
//				  }
//			  }
		  
//       		 for(String cusLine : cusLines) {
//       			 
//       			 
//       			if(cusLine.contains("public") || cusLine.contains("private") || cusLine.contains("void")) {
//       				if(getMethod(cusLine) != null) {
//       					method = getMethod(cusLine);
//       				}
//       				
//       			}
//       		 }
//	  }
//  }
//	  }
	    
	 public void getmethods(String code) {
		  String[] lines = code.split("\\r?\\n");
		  String[] words = null;
		  for (String line : lines) {
			  
		  }
	 }
	 
	 public String  getTable() {
//		 String d = getCode();
//		 System.out.println(">>>>>>>>>>>"+d);
//		String[] lines = d.split("\\r?\\n");	
		 
		 String[] lines = displayCode();
		 int[] recursiveScores = checkRecursive(code);
		 int[] regularScore = isRegular();
		 int[] globleVariable = checkGloblevariable();
		 
		String output = "";
		output = "<table border=\"1\">"
				+ "<tr><th>Code Lines</th><th>Nr</th><th>Nmcms</th><th>Nmcmd</th>"
				+ "<th>Nmcrms</th><th>Nmcrmd</th><th>Nrmcrms</th>"
				+ "<th>Nrmcrmd </th><th>Nrmcms </th><th>Nrmcmd </th>"
				+ "<th>Nmrgvs </th><th>Nmrgvd </th><th>Nrmrgvs </th><th>Nrmrgvd  </th> </th><th>Cpp</th></tr>";
		int i = 0;
		int j = lines.length;
		while(j > 0) {
			
			output += "<tr><td>" + lines[i] + "</td>";
			output += "<td>" + recursiveScores[i] + "</td>";
			output += "<td>" + regularScore[i] + "</td>";
			output += "<td>" + globleVariable[i] + "</td></tr>";
			i++;
			j--;
		}
		
		output += "</table>"; 
		
		return output;
	}
	


}
