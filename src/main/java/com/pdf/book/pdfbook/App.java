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
        File repertoire=new File(Constante.DOSSIER_PERE);  

        int i; 
        listefichiers=repertoire.list(); 
        for (String fichier : listefichiers) {
			System.out.println(fichier);
		}
    
    }
    
}

