package com.pdf.book.pdfbook;

import java.io.File;
import java.util.Properties;

/**
 * Hello world!
 *
 */
public class App 
{
    private static PropertyLoader pl;

	public static void main( String[] args )
    {
        pl = new PropertyLoader();
        System.out.println(pl.getDefaultProps().getProperty("name"));
        System.out.println(pl.getApplicationProps().getProperty("inupt.folder"));
        
        String [] listefichiers; 
//        File repertoire=new File(pl.getApplicationProps().getProperty("inupt.folder"));  
        File repertoire=new File("src/ressources/EditionENI_UnivLyon");  
        //EditionENI_UnivLyon
        int i; 
        listefichiers=repertoire.list(); 
        for (String fichier : listefichiers) {
			System.out.println(fichier);
		}
        for(i=0;i<listefichiers.length;i++){ 
        if(listefichiers[i].endsWith(".java")==true){ 

        System.out.println(listefichiers[i].substring(0,listefichiers[i].length()-5));// on choisit la sous chaine - les 5 derniers caracteres ".java" 
        } 
        } 
        }
    }

