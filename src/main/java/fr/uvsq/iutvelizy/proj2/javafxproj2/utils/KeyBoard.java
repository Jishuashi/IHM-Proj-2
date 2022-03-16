// auteur : Claude Delannoy - Programmer en Java, éditions Eyrolles
//Translate by Me
package fr.uvsq.iutvelizy.proj2.javafxproj2.utils;


import java.io.*;

public class KeyBoard {
	
  public static String readString (){
    String lineRead = new String();
    try {
      InputStreamReader reader = new InputStreamReader(System.in);
      BufferedReader bufferEntree = new BufferedReader (reader);
      lineRead = bufferEntree.readLine();
    } // try
	catch (IOException pExc) {
      System.exit(0);
    }  // catch
	return lineRead;
  }  // lireString

public static int readInt () {
	int intRead = 0;
	try { 
	  String lineRead = readString();
      intRead = Integer.parseInt (lineRead);
    } // try
	catch (NumberFormatException pExc) {
      System.err.println ("Erreur dans la saisie");
      System.exit(0);
      }  // catch
	return intRead;
}  // lireInt

public static float readFloat () {
    float floatRead = 0;
	try {
      String lineRead = readString();
      floatRead = Float.parseFloat (lineRead);
    } // try
	catch (NumberFormatException pExc) {
      System.err.println ("Erreur dans la saisie");
      System.exit(0);
    }  // catch
	return floatRead;
}  // readFloat

} // class KeyBoard