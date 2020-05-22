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

import com.servlet.codeServlet;
import com.sun.org.apache.regexp.internal.RE;

import sun.security.util.Length;

public class Coupling {
	//charitha
	//bandara
	//codeServlet cs = new codeServlet();
	
	private int wNr = 2;
	private int wNmcms = 2;
	private int wNmcmd = 3;
	private int wNmcrms = 3;
	private int wNmcrmd = 4;
	private int wNrmcrms = 4;
	private int wNrmcrmd =5;
	private int wNrmcms = 3;
	private int wNrmcmd = 4;
	private int wNmrgvs = 1;
	private int wNmrgvd = 2;
	private int wNrmrgvs =1;
	private int wNrmrgvd =2;
	
	private ArrayList<String> RECURSIVEMETHODARRAY = new ArrayList<String>();
	private ArrayList<String> AlLMETHODARRAY = new ArrayList<String>();
	
	private boolean Status ;
	
	private String code ;
	 boolean recursive;
	public void setCode(String code) {
		this.code = code;
		
		System.out.println(code);
	}
	public String getCode() {
		return code;
	}
//	
	public String[] displayCode() {
		
	
		 String[] lines = getCode().split("\\r?\\n");
	        for(String line : lines) {
	        	String tLine = line.trim();
	        	//return (tLine);
	        	
		}
	     
		return lines;
	}
	
	public void weights(int wNr,int wNmcms,int wNmcmd,int wNmcrms,int wNmcrmd,int wNrmcrms,int wNrmcrmd,int wNrmcms,int wNrmcmd,int wNmrgvs,int wNmrgvd,int wNrmrgvs,int wNrmrgvd) {
		this.wNr = wNr;
		this.wNmcms = wNmcms;
		this.wNmcmd = wNmcmd;
		this.wNmcrms =wNmcrms;
		this.wNmcrmd =wNmcrmd;
		this.wNrmcrms=wNrmcrms;
		this.wNrmcrmd=wNrmcrmd;
		this.wNrmcms=wNrmcms;
		this.wNrmcmd=wNrmcmd;
		this.wNmrgvs=wNmrgvs;
		this.wNmrgvd=wNmrgvd;
		this.wNrmrgvs=wNrmrgvs;
		this.wNrmrgvd=wNrmrgvd;
	}
//	
	
	
	 public String getMethod(String statement)
     {
		
         String newStr = statement;
         String method = null;
         String[] words = newStr.split(" ");                
       
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
	 
	 public void checkAllMethods() {
		 String[] lines = code.split("\\r?\\n");
				for(String line : lines) {
			if(getMethod(line) != null) {
				AlLMETHODARRAY.add(getMethod(line));
			}
		}
	 }
	 
	 
	 public int[] checkRecursive(String code) {
		 
			//System.out.println(wNr);
			String[] lines = code.split("\\r?\\n");
			int[] score = new int[lines.length];
			//System.out.println(score.length);
			Stack<String> methodsStack = new Stack<String>();
			Stack<Integer> stackback = new Stack<Integer>();
			ArrayList<String> reverseMethodArray = new ArrayList<String>();
			String method ;  
			ArrayList<String> cusCodeArray = new ArrayList<String>();
			
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
		 
		 String myCode0 = null;
		 for(int i = 0; i < lines.length; i++) {
			 
			 if((lines[i].contains("String")|| lines[i].contains("int")) && (lines[i].contains("[") && lines[i].contains("{"))) {
				 if (getMethod(lines[i]) == null) {
				 myCode0 = myCode0 + lines[i].replace(lines[i], "THIS IS A ARRAY") + "\n";
				 }
				 else {
				 myCode0 = myCode0 + lines[i] +"\n";
				 }
			 }
			 else {
				 myCode0 = myCode0 + lines[i] +"\n";
						
			 }
		 }
		 // System.out.println(myCode0);
		  
		  
		  String myCode1 = null;
		  String[] myLine1 = myCode0.split("\\r?\\n");
		  int iR = 0;
		  int jR =0;
		  int kR = 0;
		  
		  for( iR = 0; iR < myLine1.length; iR++) {
			  
			  if(myLine1[iR].contains("if ") && myLine1[iR].contains("{")) {
				  myCode1 = myCode1 + myLine1[iR].replace("if ", "ep") + "\n";
				  for(jR = iR + 1; jR < myLine1.length; jR++) { 
					  if(myLine1[jR].contains("if ") && myLine1[jR].contains("{")) {
						  myCode1 = myCode1 + myLine1[jR].replace("if ", "epa") + "\n";
						  for(kR = jR + 1; kR < myLine1.length; kR++) {
							  if(myLine1[kR].contains("}")) {
								  myCode1 = myCode1 + myLine1[kR].replace("}", "*") + "\n";
								  //System.out.println(myCode);
								  break;
							  }
							  else {
								  myCode1 = myCode1 + myLine1[kR] + "\n";
							  }
						  }
						  jR = kR;
						  
						  
					  }
					  else if(myLine1[jR].contains("}")) {
					    myCode1 = myCode1 + myLine1[jR].replace("}", "*") + "\n";
									  //System.out.println(myCode);
									  break;
									 
								  }
					  else {
						  myCode1 = myCode1 + myLine1[jR] + "\n";
					  }
							   
						   }
				  iR = jR;
				   }
			  else{
				 myCode1 = myCode1 + myLine1[iR] + "\n";
			  }
		  }
		  
		  String myCode2 = null;
		  String[] myLine2 = myCode1.split("\\r?\\n");
		  int xR = 0;
		  int yR =0;
		  
		  
		  for( xR = 0; xR < myLine2.length; xR++) {
			  
			  if(myLine2[xR].contains("else ") && myLine2[xR].contains("{")) {
				  myCode2 = myCode2 + myLine2[xR].replace("else ", "ZZZz") + "\n";
				  for(yR = xR + 1; yR < myLine2.length; yR++) { 
					  if(myLine2[yR].contains("}")) {
					    myCode2 = myCode2 + myLine2[yR].replace("}", "*") + "\n";
									  //System.out.println(myCode);
									  break;
									 
								  }
					  else {
						  myCode2 = myCode2 + myLine2[yR] + "\n";
					  }
							   
						   }
				  xR = yR;
				   }
			  else{
				 myCode2 = myCode2 + myLine2[xR] + "\n";
			  }
		  }
		  
		  String myCode3 = null;
		  String[] myLine3 = myCode2.split("\\r?\\n");
		  int pR = 0;
		  int qR =0;
		  
		  
		  for( pR = 0; pR < myLine3.length; pR++) {
			  
			  if(myLine3[pR].contains("switch ") && myLine3[pR].contains("{")) {
				  myCode3 = myCode3 + myLine3[pR].replace("switch ", "XXXxx") + "\n";
				  for(qR = pR + 1; qR < myLine3.length; qR++) { 
					  if(myLine3[qR].contains("}")) {
					    myCode3 = myCode3 + myLine3[qR].replace("}", "*") + "\n";
									  //System.out.println(myCode);
									  break;
									 
								  }
					  else {
						  myCode3 = myCode3 + myLine3[qR] + "\n";
					  }
							   
						   }
				  pR = qR;
				   }
			  else{
				 myCode3 = myCode3 + myLine3[pR] + "\n";
			  }
		  }
		  
		  
		  
		  String myCode4 = null;
		  String[] myLine4 = myCode3.split("\\r?\\n");
		  int aR = 0;
		  int bR =0;
		  
		  for( aR = 0; aR < myLine4.length; aR++) {
			  
			  if(myLine4[aR].contains("for") && myLine4[aR].contains("{")) {
				  myCode4 = myCode4 + myLine4[aR].replace("for", "FFF") + "\n";
				  for(bR = aR + 1; bR < myLine4.length; bR++) { 
					  if(myLine4[bR].contains("}")) {
					    myCode4 = myCode4 + myLine4[bR].replace("}", "*") + "\n";
									  //System.out.println(myCode);
									  break;
									 
								  }
					  else {
						  myCode4 = myCode4 + myLine4[bR] + "\n";
					  }
							   
						   }
				  aR = bR;
				   }
			  else{
				 myCode4 = myCode4 + myLine4[aR] + "\n";
			  }
		  }
		  
		
		  
		  for(int i = 0; i < myCode4.length(); i++) {
			  char c = myCode4.charAt(i);
		  
			  if(c == '}') {
				  stackback.push(i);

			  }
		  }
	//	  System.out.println(stackback.pop());
		  ArrayList<Integer> reverseBackArray = new ArrayList<Integer>();
		  int backLength = stackback.size();
		  //System.out.println(stackback.size());
		  for(int i = 0; i < backLength; i++) {
			  reverseBackArray.add(stackback.pop());
			  	//System.out.println(reverseBackArray.get(i));
		  }
		  for(int i = 0; i < reverseBackArray.size();i++) {
			  stackback.push(reverseBackArray.get(i));
		  }
		
		  
		 
		  
		 
		 
			
		  int l = code.length();
		  String cusCode;
		  int s = 0;
		  
		  int peekValue = 0;
		  
		  for(String line : lines) {
		
			  for(int i =0; i < stackback.size(); i++) {
			  cusCode = myCode4.substring(peekValue,stackback.peek()-1).trim();
			  cusCodeArray.add(cusCode);

			  peekValue = stackback.pop();

			  }
			  }
			 //System.out.println(lines.length);
		   
			  
			  for(int i =0 ; i < cusCodeArray.size();i++) {
				  String[] cusCodeLines = cusCodeArray.get(i).split("\\r?\\n");
				  for(String cusCodeLine : cusCodeLines) {
					  if(getMethod(cusCodeLine) == null) {
						  if(!methodsStack.isEmpty()) {
							  //System.out.println(methodsStack.peek());
						  if(cusCodeLine.contains(methodsStack.peek())) {
						      score[s] = 1 ;
						      s++;
						      RECURSIVEMETHODARRAY.add(methodsStack.peek());
						      //System.out.println(cusCodeLine);
							  
						  }
						  else {
							  score[s] = 0;
							  s++;
						  }}
			  
			  }else {
				  score[s] = 0;
				  s++;
			  }
			  
			  }
				  if(!methodsStack.isEmpty()) {
				  methodsStack.pop();
			  } }
			   
		  
			return score;
		
		}
	
	 public int[] checkRecursiveCallWithReguralerMethod(String code) {
		 
			//System.out.println(wNr);
			String[] lines = code.split("\\r?\\n");
			int[] score = new int[lines.length];
			//System.out.println(score.length);
			Stack<String> methodsStack = new Stack<String>();
			Stack<Integer> stackback = new Stack<Integer>();
			ArrayList<String> reverseMethodArray = new ArrayList<String>();
			String method ;  
			ArrayList<String> cusCodeArray = new ArrayList<String>();
			
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

		 String myCode0 = null;
		 for(int i = 0; i < lines.length; i++) {
			 
			 if((lines[i].contains("String")|| lines[i].contains("int")) && (lines[i].contains("[") && lines[i].contains("{"))) {
				 if (getMethod(lines[i]) == null) {
				 myCode0 = myCode0 + lines[i].replace(lines[i], "THIS IS A ARRAY") + "\n";
				 }
				 else {
				 myCode0 = myCode0 + lines[i] +"\n";
				 }
			 }
			 else {
				 myCode0 = myCode0 + lines[i] +"\n";
						
			 }
		 }
		 // System.out.println(myCode0);
		  
		  
		  String myCode1 = null;
		  String[] myLine1 = myCode0.split("\\r?\\n");
		  int iR = 0;
		  int jR =0;
		  int kR = 0;
		  
		  for( iR = 0; iR < myLine1.length; iR++) {
			  
			  if(myLine1[iR].contains("if ") && myLine1[iR].contains("{")) {
				  myCode1 = myCode1 + myLine1[iR].replace("if ", "ep") + "\n";
				  for(jR = iR + 1; jR < myLine1.length; jR++) { 
					  if(myLine1[jR].contains("if ") && myLine1[jR].contains("{")) {
						  myCode1 = myCode1 + myLine1[jR].replace("if ", "epa") + "\n";
						  for(kR = jR + 1; kR < myLine1.length; kR++) {
							  if(myLine1[kR].contains("}")) {
								  myCode1 = myCode1 + myLine1[kR].replace("}", "*") + "\n";
								  //System.out.println(myCode);
								  break;
							  }
							  else {
								  myCode1 = myCode1 + myLine1[kR] + "\n";
							  }
						  }
						  jR = kR;
						  
						  
					  }
					  else if(myLine1[jR].contains("}")) {
					    myCode1 = myCode1 + myLine1[jR].replace("}", "*") + "\n";
									  //System.out.println(myCode);
									  break;
									 
								  }
					  else {
						  myCode1 = myCode1 + myLine1[jR] + "\n";
					  }
							   
						   }
				  iR = jR;
				   }
			  else{
				 myCode1 = myCode1 + myLine1[iR] + "\n";
			  }
		  }
		  
		  String myCode2 = null;
		  String[] myLine2 = myCode1.split("\\r?\\n");
		  int xR = 0;
		  int yR =0;
		  
		  
		  for( xR = 0; xR < myLine2.length; xR++) {
			  
			  if(myLine2[xR].contains("else ") && myLine2[xR].contains("{")) {
				  myCode2 = myCode2 + myLine2[xR].replace("else ", "ZZZz") + "\n";
				  for(yR = xR + 1; yR < myLine2.length; yR++) { 
					  if(myLine2[yR].contains("}")) {
					    myCode2 = myCode2 + myLine2[yR].replace("}", "*") + "\n";
									  //System.out.println(myCode);
									  break;
									 
								  }
					  else {
						  myCode2 = myCode2 + myLine2[yR] + "\n";
					  }
							   
						   }
				  xR = yR;
				   }
			  else{
				 myCode2 = myCode2 + myLine2[xR] + "\n";
			  }
		  }
		  
		  String myCode3 = null;
		  String[] myLine3 = myCode2.split("\\r?\\n");
		  int pR = 0;
		  int qR =0;
		  
		  
		  for( pR = 0; pR < myLine3.length; pR++) {
			  
			  if(myLine3[pR].contains("switch ") && myLine3[pR].contains("{")) {
				  myCode3 = myCode3 + myLine3[pR].replace("switch ", "XXXxx") + "\n";
				  for(qR = pR + 1; qR < myLine3.length; qR++) { 
					  if(myLine3[qR].contains("}")) {
					    myCode3 = myCode3 + myLine3[qR].replace("}", "*") + "\n";
									  //System.out.println(myCode);
									  break;
									 
								  }
					  else {
						  myCode3 = myCode3 + myLine3[qR] + "\n";
					  }
							   
						   }
				  pR = qR;
				   }
			  else{
				 myCode3 = myCode3 + myLine3[pR] + "\n";
			  }
		  }
		  
		  
		  
		  String myCode4 = null;
		  String[] myLine4 = myCode3.split("\\r?\\n");
		  int aR = 0;
		  int bR =0;
		  
		  for( aR = 0; aR < myLine4.length; aR++) {
			  
			  if(myLine4[aR].contains("for") && myLine4[aR].contains("{")) {
				  myCode4 = myCode4 + myLine4[aR].replace("for", "FFF") + "\n";
				  for(bR = aR + 1; bR < myLine4.length; bR++) { 
					  if(myLine4[bR].contains("}")) {
					    myCode4 = myCode4 + myLine4[bR].replace("}", "*") + "\n";
									  //System.out.println(myCode);
									  break;
									 
								  }
					  else {
						  myCode4 = myCode4 + myLine4[bR] + "\n";
					  }
							   
						   }
				  aR = bR;
				   }
			  else{
				 myCode4 = myCode4 + myLine4[aR] + "\n";
			  }
		  }
		  
		  //System.out.println(myCode4);

		  
//		  System.out.println(lines.length);
//		  System.out.println(myLine4.length);
		 
		  
		  for(int i = 0; i < myCode4.length(); i++) {
			  char c = myCode4.charAt(i);
		  
			  if(c == '}') {
				  stackback.push(i);
//				  System.out.println(i);
//				  System.out.println(c);
			  }
		  }
	//	  System.out.println(stackback.pop());
		  ArrayList<Integer> reverseBackArray = new ArrayList<Integer>();
		  int backLength = stackback.size();
		  //System.out.println(stackback.size());
		  for(int i = 0; i < backLength; i++) {
			  reverseBackArray.add(stackback.pop());
			  	//System.out.println(reverseBackArray.get(i));
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
		 
//			 System.out.println(line);
//			 System.out.println(">>>>>>>>>>>>>>>>..");
		
			  for(int i =0; i < stackback.size(); i++) {
			  cusCode = myCode4.substring(peekValue,stackback.peek()-1).trim();
			  cusCodeArray.add(cusCode);
			  //System.out.println(cusCode.length());
//			  if(cusCode.contains(".*[a-z].*")) {
//				  System.out.println("empty");
//			  }
//			  else {
			  peekValue = stackback.pop();
//			  System.out.println(cusCode.trim());
//			  System.out.println(">>>>>>>>>>>>>");
			  }
			  }
			 //System.out.println(lines.length);
		   
			  
			  for(int i =0 ; i < cusCodeArray.size();i++) {
				  String[] cusCodeLines = cusCodeArray.get(i).split("\\r?\\n");
				  for(String cusCodeLine : cusCodeLines) {
					  if(getMethod(cusCodeLine) == null) {
						  if(!methodsStack.isEmpty()) {
							  //System.out.println(methodsStack.peek());
						  if(cusCodeLine.contains(methodsStack.peek())) {
							  score[s] = 1;						 
						      //System.out.println(cusCodeLine);
							  s++;
						  } 
						  
						 
						  else {
							  score[s] = 0;
							  s++;
						  }}
			  
			  }else {
				  score[s] = 0;
				  s++;
			  }
			  
			  }
				  if(!methodsStack.isEmpty()) {
				  methodsStack.pop();
			  } }
			  
		  
			return score;
		
		}

	 
	
	public boolean isRecursive() {
		
		 String[] lines = code.split("\\r?\\n");
		 int[] score = new int[lines.length];
		 score = checkRecursive(code);
		 
		for(int i =0; i < score.length; i++) {
			 if(score[i] == 1) {
				 score[i] = 1 ;
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
		  ArrayList<String> classMethodArray = new ArrayList<String>();
		  
		  String cuscode2  = code;
		 
		  for(String line : lines) {
			  if(line.contains("public") || line.contains("private") && line.contains("class")) {
				  if(line.contains("implements")) {
					  
					  String[] cusCuts = line.split("implements");
					 String [] classMethods = cusCuts[1].split("[,{]");	
					  for(String classMethod : classMethods ) {
						  classMethodArray.add(classMethod.trim());
					  }
					  
				  }
			  }
		  }
//		  for(int i = 0; i < classMethodArray.size(); i++) {
//			  System.out.println(classMethodArray.get(i));
//		  }
		  
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
		  
		 if(classMethodArray.size() > 0) {
		  for(int i = 0; i < classMethodArray.size(); i++) {
			  if(tStatment.contains(classMethodArray.get(i))) {
				 
				  if(tStatment.contains("public") || tStatment.contains("private") && tStatment.contains("class")) {
				  }
				  else {
					  regular = true;
					  break;
			  }
		  }else {
		  
		 
		  for(int k = 0; k < methodsArray.size(); k++) {
			  
			 
			  
			  if(tStatment.contains(methodsArray.get(k))) {
				  
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
		  }}}}
		 else {
			 for(int k = 0; k < methodsArray.size(); k++) {
				  
				 
				  
				  if(tStatment.contains(methodsArray.get(k))) {
					  
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

		 }}
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
			 score[s] = 1  ;
			 s++;
		 }
		 else {
			 score[s] = 0;
			 s++;
		 }
	 }
	 return score;
	 
 }
 
 public int[] checkRegularCallToRegunalCall() {
	 String [] lines = code.split("\\r?\\n");
	 int[] score = new int[lines.length];
	 int[] recursiveScores = checkRecursive(code);
	 int[] regularScore = isRegular();
	 int s =0;
	
	 
	 for(int i =0 ; i < lines.length; i++) {
		 if(regularScore[i] == 1) {
			 if(recursiveScores[i] == 1) {
				 score[s] = 0;
				 s++;
			 }else {
				 score[s] = 1;
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
 
 public int[] checkRegularCallToRecursiveCall() {
	 String [] lines = code.split("\\r?\\n");
	 int[] score = new int[lines.length];
	 
	 
	 Stack<String> methodsStack = new Stack<String>();
		Stack<Integer> stackback = new Stack<Integer>();
		ArrayList<String> reverseMethodArray = new ArrayList<String>();
		String method ;  
		ArrayList<String> cusCodeArray = new ArrayList<String>();
		
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
//	
	 String myCode0 = null;
	 for(int i = 0; i < lines.length; i++) {
		 
		 if((lines[i].contains("String")|| lines[i].contains("int")) && (lines[i].contains("[") && lines[i].contains("{"))) {
			 if (getMethod(lines[i]) == null) {
			 myCode0 = myCode0 + lines[i].replace(lines[i], "THIS IS A ARRAY") + "\n";
			 }
			 else {
			 myCode0 = myCode0 + lines[i] +"\n";
			 }
		 }
		 else {
			 myCode0 = myCode0 + lines[i] +"\n";
					
		 }
	 }
	 // System.out.println(myCode0);
	  
	  
	  String myCode1 = null;
	  String[] myLine1 = myCode0.split("\\r?\\n");
	  int iR = 0;
	  int jR =0;
	  int kR = 0;
	  
	  for( iR = 0; iR < myLine1.length; iR++) {
		  
		  if(myLine1[iR].contains("if ") && myLine1[iR].contains("{")) {
			  myCode1 = myCode1 + myLine1[iR].replace("if ", "ep") + "\n";
			  for(jR = iR + 1; jR < myLine1.length; jR++) { 
				  if(myLine1[jR].contains("if ") && myLine1[jR].contains("{")) {
					  myCode1 = myCode1 + myLine1[jR].replace("if ", "epa") + "\n";
					  for(kR = jR + 1; kR < myLine1.length; kR++) {
						  if(myLine1[kR].contains("}")) {
							  myCode1 = myCode1 + myLine1[kR].replace("}", "*") + "\n";
							  //System.out.println(myCode);
							  break;
						  }
						  else {
							  myCode1 = myCode1 + myLine1[kR] + "\n";
						  }
					  }
					  jR = kR;
					  
					  
				  }
				  else if(myLine1[jR].contains("}")) {
				    myCode1 = myCode1 + myLine1[jR].replace("}", "*") + "\n";
								  //System.out.println(myCode);
								  break;
								 
							  }
				  else {
					  myCode1 = myCode1 + myLine1[jR] + "\n";
				  }
						   
					   }
			  iR = jR;
			   }
		  else{
			 myCode1 = myCode1 + myLine1[iR] + "\n";
		  }
	  }
	  
	  String myCode2 = null;
	  String[] myLine2 = myCode1.split("\\r?\\n");
	  int xR = 0;
	  int yR =0;
	  
	  
	  for( xR = 0; xR < myLine2.length; xR++) {
		  
		  if(myLine2[xR].contains("else ") && myLine2[xR].contains("{")) {
			  myCode2 = myCode2 + myLine2[xR].replace("else ", "ZZZz") + "\n";
			  for(yR = xR + 1; yR < myLine2.length; yR++) { 
				  if(myLine2[yR].contains("}")) {
				    myCode2 = myCode2 + myLine2[yR].replace("}", "*") + "\n";
								  //System.out.println(myCode);
								  break;
								 
							  }
				  else {
					  myCode2 = myCode2 + myLine2[yR] + "\n";
				  }
						   
					   }
			  xR = yR;
			   }
		  else{
			 myCode2 = myCode2 + myLine2[xR] + "\n";
		  }
	  }
	  
	  String myCode3 = null;
	  String[] myLine3 = myCode2.split("\\r?\\n");
	  int pR = 0;
	  int qR =0;
	  
	  
	  for( pR = 0; pR < myLine3.length; pR++) {
		  
		  if(myLine3[pR].contains("switch ") && myLine3[pR].contains("{")) {
			  myCode3 = myCode3 + myLine3[pR].replace("switch ", "XXXxx") + "\n";
			  for(qR = pR + 1; qR < myLine3.length; qR++) { 
				  if(myLine3[qR].contains("}")) {
				    myCode3 = myCode3 + myLine3[qR].replace("}", "*") + "\n";
								  //System.out.println(myCode);
								  break;
								 
							  }
				  else {
					  myCode3 = myCode3 + myLine3[qR] + "\n";
				  }
						   
					   }
			  pR = qR;
			   }
		  else{
			 myCode3 = myCode3 + myLine3[pR] + "\n";
		  }
	  }
	  
	  
	  
	  String myCode4 = null;
	  String[] myLine4 = myCode3.split("\\r?\\n");
	  int aR = 0;
	  int bR =0;
	  
	  for( aR = 0; aR < myLine4.length; aR++) {
		  
		  if(myLine4[aR].contains("for") && myLine4[aR].contains("{")) {
			  myCode4 = myCode4 + myLine4[aR].replace("for", "FFF") + "\n";
			  for(bR = aR + 1; bR < myLine4.length; bR++) { 
				  if(myLine4[bR].contains("}")) {
				    myCode4 = myCode4 + myLine4[bR].replace("}", "*") + "\n";
								  //System.out.println(myCode);
								  break;
								 
							  }
				  else {
					  myCode4 = myCode4 + myLine4[bR] + "\n";
				  }
						   
					   }
			  aR = bR;
			   }
		  else{
			 myCode4 = myCode4 + myLine4[aR] + "\n";
		  }
	  }
	  

	  
	  for(int i = 0; i < myCode4.length(); i++) {
		  char c = myCode4.charAt(i);
	  
		  if(c == '}') {
			  stackback.push(i);
//			
		  }
	  }
//	  System.out.println(stackback.pop());
	  ArrayList<Integer> reverseBackArray = new ArrayList<Integer>();
	  int backLength = stackback.size();
	  //System.out.println(stackback.size());
	  for(int i = 0; i < backLength; i++) {
		  reverseBackArray.add(stackback.pop());
		  	//System.out.println(reverseBackArray.get(i));
	  }
	  for(int i = 0; i < reverseBackArray.size();i++) {
		  stackback.push(reverseBackArray.get(i));
	  } 
	 
		
	 
	  String cusCode;
	  int s = 0;
	  
	  int peekValue = 0;
	  String myMethod = null;
	  
	  for(String line : lines) {
	  
		  for(int i =0; i < stackback.size(); i++) {
		  cusCode = myCode4.substring(peekValue,stackback.peek()-1).trim();
		  cusCodeArray.add(cusCode);
		  
		  peekValue = stackback.pop();//		 
		  }
		  }
	  
	  for(int i =0 ; i < cusCodeArray.size(); i++) {
		  String[] cusCodeLines = cusCodeArray.get(i).split("\\r?\\n");
		  for(String line : cusCodeLines) {
		  if(checkRegularMethod(line)) {
			  Status = true;
			  break;
		  }
		  else {
			  Status = false;
		  }
		  }
		  if(Status) {
			  for(String line : cusCodeLines) {
				if(getMethod(line) != null) {
					myMethod = getMethod(line);
					 score[s] = 0;
					 s++;
				}
				else {
			  for(int k = 0; k < RECURSIVEMETHODARRAY.size(); k++) {
					 if(line.contains(RECURSIVEMETHODARRAY.get(k))) {
						if(line.contains(myMethod)) {
							score[s] = 0;;
						}else {
						 score[s] = 1;						
						 break;
						 
					 }}
					 else {
						 score[s] = 0;
						 
					 }
					
				 }
			  s++;
				} }
		  }else {
			  for(String line : cusCodeLines) {
					 
						 score[s] = 0;
//						 s++;
			  }
		  }
	  }
	  
	 
	 
	 return score;
 }

 public int[] checkRecursiveCallToRegularCall() {
	 
	 checkAllMethods();
	 String [] lines = code.split("\\r?\\n");
	 int[] score = new int[lines.length];
	 
	 
	 Stack<String> methodsStack = new Stack<String>();
		Stack<Integer> stackback = new Stack<Integer>();
		ArrayList<String> reverseMethodArray = new ArrayList<String>();
		String method ;  
		ArrayList<String> cusCodeArray = new ArrayList<String>();
		
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
//	
	 String myCode0 = null;
	 for(int i = 0; i < lines.length; i++) {
		 
		 if((lines[i].contains("String")|| lines[i].contains("int")) && (lines[i].contains("[") && lines[i].contains("{"))) {
			 if (getMethod(lines[i]) == null) {
			 myCode0 = myCode0 + lines[i].replace(lines[i], "THIS IS A ARRAY") + "\n";
			 }
			 else {
			 myCode0 = myCode0 + lines[i] +"\n";
			 }
		 }
		 else {
			 myCode0 = myCode0 + lines[i] +"\n";
					
		 }
	 }
	 // System.out.println(myCode0);
	  
	  
	  String myCode1 = null;
	  String[] myLine1 = myCode0.split("\\r?\\n");
	  int iR = 0;
	  int jR =0;
	  int kR = 0;
	  
	  for( iR = 0; iR < myLine1.length; iR++) {
		  
		  if(myLine1[iR].contains("if ") && myLine1[iR].contains("{")) {
			  myCode1 = myCode1 + myLine1[iR].replace("if ", "ep") + "\n";
			  for(jR = iR + 1; jR < myLine1.length; jR++) { 
				  if(myLine1[jR].contains("if ") && myLine1[jR].contains("{")) {
					  myCode1 = myCode1 + myLine1[jR].replace("if ", "epa") + "\n";
					  for(kR = jR + 1; kR < myLine1.length; kR++) {
						  if(myLine1[kR].contains("}")) {
							  myCode1 = myCode1 + myLine1[kR].replace("}", "*") + "\n";
							  //System.out.println(myCode);
							  break;
						  }
						  else {
							  myCode1 = myCode1 + myLine1[kR] + "\n";
						  }
					  }
					  jR = kR;
					  
					  
				  }
				  else if(myLine1[jR].contains("}")) {
				    myCode1 = myCode1 + myLine1[jR].replace("}", "*") + "\n";
								  //System.out.println(myCode);
								  break;
								 
							  }
				  else {
					  myCode1 = myCode1 + myLine1[jR] + "\n";
				  }
						   
					   }
			  iR = jR;
			   }
		  else{
			 myCode1 = myCode1 + myLine1[iR] + "\n";
		  }
	  }
	  
	  String myCode2 = null;
	  String[] myLine2 = myCode1.split("\\r?\\n");
	  int xR = 0;
	  int yR =0;
	  
	  
	  for( xR = 0; xR < myLine2.length; xR++) {
		  
		  if(myLine2[xR].contains("else ") && myLine2[xR].contains("{")) {
			  myCode2 = myCode2 + myLine2[xR].replace("else ", "ZZZz") + "\n";
			  for(yR = xR + 1; yR < myLine2.length; yR++) { 
				  if(myLine2[yR].contains("}")) {
				    myCode2 = myCode2 + myLine2[yR].replace("}", "*") + "\n";
								  //System.out.println(myCode);
								  break;
								 
							  }
				  else {
					  myCode2 = myCode2 + myLine2[yR] + "\n";
				  }
						   
					   }
			  xR = yR;
			   }
		  else{
			 myCode2 = myCode2 + myLine2[xR] + "\n";
		  }
	  }
	  
	  String myCode3 = null;
	  String[] myLine3 = myCode2.split("\\r?\\n");
	  int pR = 0;
	  int qR =0;
	  
	  
	  for( pR = 0; pR < myLine3.length; pR++) {
		  
		  if(myLine3[pR].contains("switch ") && myLine3[pR].contains("{")) {
			  myCode3 = myCode3 + myLine3[pR].replace("switch ", "XXXxx") + "\n";
			  for(qR = pR + 1; qR < myLine3.length; qR++) { 
				  if(myLine3[qR].contains("}")) {
				    myCode3 = myCode3 + myLine3[qR].replace("}", "*") + "\n";
								  //System.out.println(myCode);
								  break;
								 
							  }
				  else {
					  myCode3 = myCode3 + myLine3[qR] + "\n";
				  }
						   
					   }
			  pR = qR;
			   }
		  else{
			 myCode3 = myCode3 + myLine3[pR] + "\n";
		  }
	  }
	  
	  
	  
	  String myCode4 = null;
	  String[] myLine4 = myCode3.split("\\r?\\n");
	  int aR = 0;
	  int bR =0;
	  
	  for( aR = 0; aR < myLine4.length; aR++) {
		  
		  if(myLine4[aR].contains("for") && myLine4[aR].contains("{")) {
			  myCode4 = myCode4 + myLine4[aR].replace("for", "FFF") + "\n";
			  for(bR = aR + 1; bR < myLine4.length; bR++) { 
				  if(myLine4[bR].contains("}")) {
				    myCode4 = myCode4 + myLine4[bR].replace("}", "*") + "\n";
								  //System.out.println(myCode);
								  break;
								 
							  }
				  else {
					  myCode4 = myCode4 + myLine4[bR] + "\n";
				  }
						   
					   }
			  aR = bR;
			   }
		  else{
			 myCode4 = myCode4 + myLine4[aR] + "\n";
		  }
	  }
	  

	  
	  for(int i = 0; i < myCode4.length(); i++) {
		  char c = myCode4.charAt(i);
	  
		  if(c == '}') {
			  stackback.push(i);
//			
		  }
	  }
//	  System.out.println(stackback.pop());
	  ArrayList<Integer> reverseBackArray = new ArrayList<Integer>();
	  int backLength = stackback.size();
	  //System.out.println(stackback.size());
	  for(int i = 0; i < backLength; i++) {
		  reverseBackArray.add(stackback.pop());
		  	//System.out.println(reverseBackArray.get(i));
	  }
	  for(int i = 0; i < reverseBackArray.size();i++) {
		  stackback.push(reverseBackArray.get(i));
	  } 
	 
		
	 
	  String cusCode;
	  int s = 0;
	  
	  int peekValue = 0;
	  String myMethod = null;
	  
	  for(String line : lines) {
	  
		  for(int i =0; i < stackback.size(); i++) {
		  cusCode = myCode4.substring(peekValue,stackback.peek()-1).trim();
		  cusCodeArray.add(cusCode);
		  
		  peekValue = stackback.pop();//		 
		  }
		  }
	  
	  for(int i =0 ; i < cusCodeArray.size();i++) {
		  String[] cusCodeLines = cusCodeArray.get(i).split("\\r?\\n");
		  for(String cusCodeLine : cusCodeLines) {
			  if(getMethod(cusCodeLine) == null) {
				  if(!methodsStack.isEmpty()) {
					  //System.out.println(methodsStack.peek());
				  if(cusCodeLine.contains(methodsStack.peek())) {
				      methodsStack.pop();
					  Status = true;
				     break;
				      //System.out.println(cusCodeLine);
					  
				  }
				  else {
					  Status = false;
					 
				  }}
	  
	  }else {
		  Status = false;
		  //break;
	  }
		  }
	  
		  if(Status) {
			  
			 
		  for(String myline : cusCodeLines) {			 
			  for(int k = 0; k < AlLMETHODARRAY.size(); k++) {
				  if(myline.contains(AlLMETHODARRAY.get(k))) {					  
					if(myline.contains(methodsStack.peek())) {
						score[s] =0;	
					}
					else if(getMethod(myline) != null) {
						score[s] =0;
					}
					else {
					  score[s] = 1;
					break;
					} 
				  }
				  else {
					  score[s] =0;	  
					  
					  
				  }
			  }
			  s++;
			  
		  }
	  }
	  else {
		  for(String myline : cusCodeLines) {	
			  score[s]=0;
			 // s++;
		  }  
	  }
		  
		  
		  if(!methodsStack.isEmpty()) {
		  methodsStack.pop();
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
		 else if((tline.contains("private") || tline.contains("public") || tline.contains("static"))  && (tline.contains("int") || tline.contains("String") 
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
					 if(tvar.contains("private") || tvar.contains("public") ||tvar.contains("static")) {
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
	 
		
		 
			 variable = true;
			 continue;
			 
		 
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
		 else if((tline.contains("private") || tline.contains("public") || tline.contains("static")) && (tline.contains("int") || tline.contains("String") 
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
					 if(tvar.contains("private") || tvar.contains("public") || tvar.contains("static")) {
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
//	
	
	
	
	
	
	int[] score = new int[lines.length];
	int s = 0;
	score[s] = 0;
	
	for(String line : lines) {
		String tline = line.trim();
		
		if(isGlobleVariable(tline)) {
			if(tline.contains("public") || tline.contains("private") || tline.contains("static")) {
				score[s] = 0;
				s++;
			}
			else {
			String [] myWords = tline.split(";|\\.|\\(|\\,|\\ ");
			for(String  myWord : myWords) {
			
				
			for(int i = 0; i < variableArray.size(); i++) {
				if(myWord.equals(variableArray.get(i))) {				
					score[s] = score[s] + 1 ;
				}
			}}
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
 
 
	  
	    
	
	 public String  getTable() {
	 
		 String test = "";
		 String[] lines = displayCode();
		 int[] recursiveScores = checkRecursive(code);		
		 int[] globleVariable = checkGloblevariable();		
		 int[] regularToRegular = checkRegularCallToRegunalCall();
		 int[] recursiveToregular = checkRecursiveCallToRegularCall();
		 int[] regularToRecursive = checkRegularCallToRecursiveCall();
		 
		 int totRecursiveScores = 0;
		 int totRegularScore = 0;
		 int totGlobleVariable = 0;
		 int totRegularToRecursive = 0;
		 int totRecursiveToRegular = 0;
		
		 int total = 0;
		 
		
		 
		 
		 
		 
		String output = "";
		output = "<table class= 'table table-hover' border='1'>"
				+ "<tr><th bgcolor= '#839192 '>Line NO.</th><th bgcolor= '#839192 '>Code Lines</th><th bgcolor= '#839192' >Nr</th><th bgcolor= '#839192'  >Nmcms</th><th bgcolor= '#839192' >Nmcmd</th>"
				+ "<th bgcolor= '#839192' >Nmcrms</th><th bgcolor= '#839192' >Nmcrmd</th><th bgcolor= '#839192' >Nrmcrms</th>"
				+ "<th bgcolor= '#839192' >Nrmcrmd </th><th bgcolor= '#839192' >Nrmcms </th><th bgcolor= '#839192' >Nrmcmd </th>"
				+ "<th bgcolor= '#839192 '>Nmrgvs </th><th bgcolor= '#839192' >Nmrgvd </th><th bgcolor= '#839192' >Nrmrgvs </th><th bgcolor= '#839192' >Nrmrgvd  </th> </th><th bgcolor= '#839192' >Cpp</th></tr>";
		int i = 0;
		int k = 1;
		int j = lines.length;
		while(j > 0) {
			
			totRecursiveScores = totRecursiveScores + recursiveScores[i] ;
			totRegularScore = totRegularScore + regularToRegular[i];
			totGlobleVariable = totGlobleVariable + globleVariable[i];
			totRegularToRecursive = totRegularToRecursive + regularToRecursive[i];
			totRecursiveToRegular = totRecursiveToRegular + recursiveToregular[i];
			
			
			output += "<tr><th>" + k++ + "</th>";
			output += "<td>" + lines[i] + "</td>";
			output += "<td>" + recursiveScores[i] + "</td>";
			output += "<td>" + regularToRegular[i] + "</td>";
			output += "<td>" + test + "</td>";
			output += "<td>" + regularToRecursive[i] + "</td>";
			output += "<td>" + test + "</td>";
			output += "<td>" + test + "</td>";
			output += "<td>" + test + "</td>";
			output += "<td>" + recursiveToregular[i] + "</td>";
			output += "<td>" + test + "</td>";
			output += "<td>" + globleVariable[i] + "</td>";
			output += "<td>" + test + "</td>";
			output += "<td>" + test + "</td>";
			output += "<td>" + test + "</td>";
			output += "<td>" + (recursiveScores[i] * wNr + regularToRecursive[i] * wNmcrms + recursiveToregular[i] * wNrmcms  +regularToRegular[i] *wNmcms + globleVariable[i] * wNmrgvs) + "</td> </tr>";
			i++;
			j--;
		}
		
		total = totRecursiveScores * wNr + totRegularScore *wNmcms + totRegularToRecursive * wNmcrms + totGlobleVariable* wNmrgvs + totRecursiveToRegular* wNrmcms;
		
		output += "<tr><th bgcolor= '#FDEDEC '></th>";
		output += "<th bgcolor= '#FDEDEC '>" +"TOTAL"+"</th>";
		output += "<th bgcolor= '#FDEDEC '>" +totRecursiveScores+"</th>";
		output += "<th bgcolor= '#FDEDEC '>" +totRegularScore+"</th>";
		output += "<th bgcolor= '#FDEDEC '>" +test+"</th>";
		output += "<th bgcolor= '#FDEDEC '>" +totRegularToRecursive+"</th>";
		output += "<th bgcolor= '#FDEDEC '>" +test+"</th>";
		output += "<th bgcolor= '#FDEDEC '>" +test+"</th>";
		output += "<th bgcolor= '#FDEDEC '>" +test+"</th>";
		output += "<th bgcolor= '#FDEDEC '>" +totRecursiveToRegular+"</th>";
		output += "<th bgcolor= '#FDEDEC '>" +test+"</th>";
		output += "<th bgcolor= '#FDEDEC '>" +totGlobleVariable+"</th>";
		output += "<th bgcolor= '#FDEDEC '>" +test+"</th>";
		output += "<th bgcolor= '#FDEDEC '>" +test+"</th>";
		output += "<th bgcolor= '#FDEDEC '>" +test+"</th>";
		output += "<th bgcolor= '#FDEDEC '>" +total+"</th></tr>";
		output += "</table>"; 
		
		return output;
	}
	public int[] getccpValue() {
		String[] lines = displayCode();
		int[] ccp = new int [lines.length];	
		int[] recursiveScores = checkRecursive(code);
		int[] regularToRegular = checkRegularCallToRegunalCall();
		int[] regularToRecursive = checkRegularCallToRecursiveCall();
		int[] recursiveToregular = checkRecursiveCallToRegularCall();
		int[] globleVariable = checkGloblevariable();
		
		int i = 0;
		int j = lines.length;
		
		while(j > 0) {
			ccp[i] = recursiveScores[i]* wNr + regularToRegular[i] *wNmcms  +  regularToRecursive[i]*wNmcrms + recursiveToregular[i]*wNrmcms + globleVariable[i]*wNmrgvs;
			
			//System.out.println(ccp[i]);
			i++;
			j--;
		}
		
		
		return ccp;
	}
	
	public int[] gettotalValue() {
		int[] tot = new int[13];
		String[] lines = displayCode();
		int[] recursiveScores = checkRecursive(code);
		int[] regularToRegular = checkRegularCallToRegunalCall();
		int[] regularToRecursive = checkRegularCallToRecursiveCall();
		int[] recursiveToregular = checkRecursiveCallToRegularCall();
		int[] globleVariable = checkGloblevariable();
		int totRecursiveScores = 0;
		int totRegularScore = 0;
		int totRegularToRecursive = 0;
		int totRecursiveToregular = 0;
		int totGlobleVariable = 0;
		int i = 0;
		int j = lines.length;
		while(j > 0) {
			totRecursiveScores = totRecursiveScores + recursiveScores[i];
			totRegularScore = totRegularScore + regularToRegular[i];
			totRegularToRecursive = totRegularToRecursive + regularToRecursive[i];
			totRecursiveToregular = totRecursiveToregular + recursiveToregular[i];
			totGlobleVariable = totGlobleVariable + globleVariable[i];
			
			i++;
			j--;
		}
		tot[0] = totRecursiveScores;
		tot[1] = totRegularScore;
		tot[2] = 0;
		tot[3] = totRegularToRecursive;
		tot[4] = 0;
		tot[5] = 0;
		tot[6] = 0;
		tot[7] = totRecursiveToregular;
		tot[8] = 0;
		tot[9] = totGlobleVariable;
		tot[10] = 0;
		tot[11] = 0;
		tot[12] = 0;
		
		return tot;
	}
	


}
