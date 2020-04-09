package com.javaClass;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class Coupling {
	//charitha
	String code;
	
	public void setCode(String code) {
		this.code = code;
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
	
	
	public String[] getCount() {
		// TODO Auto-generated method stub
		File file = new File("F://charitha//test.txt");
		if(file.exists()) {
			try {
				FileReader fr = new FileReader(file);
				LineNumberReader lnr = new LineNumberReader(fr);
				int lineNOCount = 0;
				String[]  code;
				try {
					BufferedReader br = new BufferedReader(fr);
					String line;
					code = new String[20];
					while((line = br.readLine()) != null) {
						
						lineNOCount ++;
						code[lineNOCount] = (lineNOCount +" : "+line);
						
						
					}
					return code;
					//System.out.println("LINE: " +lineNOCount);
					//return lineNOCount;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		String[] test = {"s", "g"};
		return test;
	}
	
	
	
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
	 
	 
	 public int[] isRecursive(String code)
     {
		 
		int i = 0;
		 checkRegularMethod(code);
         Boolean flag = false;
         String method = null;
        // System.out.println("svsv");
         //separate code into lines
         String[] lines = code.split("\\r?\\n");
         int[] score = new int[lines.length];
         //String[] words = code.Split(' ');
        
         //retrieve each line and check for a method
         	for (String line : lines) {
         		String tLine = line.trim();
         		//System.out.println(tLine);
         		score[i] = 0;
         		 System.out.println(score[i]);
            	 i++;
             if (method != null)
             {
                 if(getMethod(tLine) != null)
                 {
                     method = getMethod(tLine);
                    // System.out.println(method);
                     //Console.WriteLine(method);
                     continue;
                     
                 }
                 String[] words = tLine.split(" ");

                 for (String word : words)
                 {
                	
                	
                     String tWord = word.trim();
                    // System.out.println(tWord);
                     //Console.WriteLine(tWord);
                     if (tWord.contains(method))
                     {	
                    	 
                    	 //System.out.println(method);
                         //Console.WriteLine(word);
                         flag = true;
                         score[i] = 1;
                        
                        // System.out.println(score[i]);
                         i++;
                         break;
                     }
                     else
                     {
                         flag = false;
                        
                     }
                 }
             }
             else {

                 method = getMethod(tLine);
                // System.out.println(method);
             }

             if (flag == true)
             {
                 break;
             }
         }
         	
         return score;
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
	  public void checkRegularMethod(String code) {

		  String[] lines = code.split("\\r?\\n");
		  String method = null;
		  for (String line : lines) {
       		String tLine = line.trim();
       		
       		if(getMethod(tLine) != null ) {
       		 String[] cusLines = tLine.split("\\} ");
       		
       		 for(String cusLine : cusLines) {
       			 
       			 
       			if(cusLine.contains("public") || cusLine.contains("private") || cusLine.contains("void")) {
       				if(getMethod(cusLine) != null) {
       					method = getMethod(cusLine);
       				}
       				
       			}
       		 }
	  }
  }
	  }
	  
	 public int getCodeLength(String code) {
		  String[] lines = code.split("\\r?\\n");
	      int codeLength = lines.length;
	      return codeLength;
	 }


}
