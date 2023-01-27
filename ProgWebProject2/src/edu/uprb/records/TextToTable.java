package edu.uprb.records;

import java.io.*;

public class TextToTable
{
	
	
private static void makeHead(PrintWriter pw) {
	pw.println("<!DOCTYPE html>\r\n" + 
			"<html>\r\n" + 
			"<head>\r\n" + 
			"<style>\r\n" + 
			"table, th, td {\r\n" + 
			"  border: 1px solid black;\r\n" + 
			"  border-collapse: collapse;\r\n" + 
			"}\r\n" + 
			".center {\r\n" + 
			"  text-align: center;\r\n" + 
			"}\r\n" + 
			"\r\n" + 
			".pagination {\r\n" + 
			"  display: inline-block;\r\n" + 
			"}\r\n" + 
			"\r\n" + 
			".pagination a {\r\n" + 
			"  color: black;\r\n" + 
			"  float: left;\r\n" + 
			"  padding: 8px 16px;\r\n" + 
			"  text-decoration: none;\r\n" + 
			"  transition: background-color .3s;\r\n" + 
			"  border: 1px solid #ddd;\r\n" + 
			"  margin: 0 4px;\r\n" + 
			"}\r\n" + 
			"\r\n" + 
			".pagination a.active {\r\n" + 
			"  background-color: #4CAF50;\r\n" + 
			"  color: white;\r\n" + 
			"  border: 1px solid #4CAF50;\r\n" + 
			"}\r\n" + 
			"\r\n" + 
			".pagination a:hover:not(.active) {background-color: #ddd;}\r\n" + 
			"</style>\r\n" + 
			"</head>\r\n" + 
			"<body>\r\n" + 
			"</style>\r\n" + 
			"</head>\r\n" + 
			"<body>\r\n" + 
			"\r\n" + 
			"<h1 style=\"text-align:center;\">Informe de las 321 Escuelas</h1>\r\n" + 
			"<h2 style=\"color:blue;text-align:center;\">Departamento de Educacion</h2>\r\n" + 
			"<h3 style=\"color:blue;text-align:center;\">Gobierno de Puerto Rico</h3>\r\n" + 
			"\r\n" + 
			"\r\n" + 
			"<table style=\"width:100%\">");
	
}


private static void makeTables(String[] arrOfStr, PrintWriter pw)
	{
 
	    for (int i = 0; i < arrOfStr.length-1; i++)
		{    		
			if (i%7==0)
			{
				pw.println("<tr>");
				pw.println("<td>"+arrOfStr[i]+"</td>");
			} else
			{
				pw.println("<td>"+arrOfStr[i]+"</td>");
			}
					
		}
	}


private static void makeFoot(PrintWriter pw)
	{
		pw.println("</table>\r\n" + 
				"\r\n" + 
				"<div class=\"center\">\r\n" + 
				"  <div class=\"pagination\">\r\n" + 
				"  <a href=\"#\">&laquo;</a>\r\n" + 
				"  <a href=\"#\">1</a>\r\n" + 
				"  <a href=\"#\" class=\"active\">2</a>\r\n" + 
				"  <a href=\"#\">3</a>\r\n" + 
				"  <a href=\"#\">4</a>\r\n" + 
				"  <a href=\"#\">5</a>\r\n" + 
				"  <a href=\"#\">6</a>\r\n" + 
				"  <a href=\"#\">&raquo;</a>\r\n" + 
				"  </div>\r\n" + 
				"</div>\r\n" + 
				"\r\n" + 
				"</body>\r\n" + 
				"</html>\r\n" + 
				"");
		
	}
	
	
public static void main(String[] args) throws IOException
	{

		File file = new File("escuelas.html");
		FileWriter fw = new FileWriter(file);
		PrintWriter pw = new PrintWriter(fw);
	    BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Lightning\\Pictures\\Saved Pictures\\321Escuelas.txt"));
	    StringBuilder sb = new StringBuilder();

	    
	    makeHead(pw);
	    
	    
	    String line = br.readLine();
	    while (line != null) {
	      sb.append(line).append("\n");
	      line = br.readLine();
	    }

	    String fileAsString = sb.toString();
	    String[] arrOfStr = fileAsString.split("[|\\r?\\n]", -1);
	    
	    
	    makeTables(arrOfStr, pw);
	    
	    
	    makeFoot(pw);
	    
	    
	    br.close();
	}


}
