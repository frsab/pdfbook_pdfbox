package com.pdf.book.pdfbook;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.pdfbox.io.MemoryUsageSetting;
import org.apache.pdfbox.multipdf.PDFMergerUtility;

/**
 * Hello world!
 *
 */
public class App {
	private static PropertyLoader pl;
	  // initialize the Merger utility and add pdfs to be merged
	private static PDFMergerUtility mergerUtility = new PDFMergerUtility();

	public static void main(String[] args) {
		pl = new PropertyLoader();
		//System.out.println(pl.getDefaultProps().getProperty("name"));
		//System.out.println(pl.getApplicationProps().getProperty("inupt.folder"));

		//afficher(Constante.DOSSIER_PERE, 0);
		mergeFiles(Constante.DOSSIER_PERE, Constante.DOSSIER_TARGET);

	}

	private static void mergeFiles(String dossierPere, String dossierTarget) {
		File repertoire = new File(dossierPere);
		String[] listefichiers=repertoire.list();
		for (String rep : listefichiers) {
			System.out.println("merge de docs :"+rep);
			File repFile=new File(dossierPere+"/"+rep);
			System.out.println("nombre de fichier est "+repFile.list().length);
			String[] listefichiersRep=repFile.list();
			
			List<InputStream> sourcePDFs= new ArrayList<InputStream>();
			
			for (String filePdfName : listefichiersRep) {
				try {
					sourcePDFs.add(new FileInputStream(repFile+"/"+filePdfName));
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					System.out.println(repFile+"/"+filePdfName+" est introuvale !!");
				}
				
			}
			PDFMergerUtility mergerUtilityFile = new PDFMergerUtility();
			mergerUtilityFile.addSources(sourcePDFs);
			 // set the destination pdf name and merge input pdfs
			mergerUtilityFile.setDestinationFileName(Constante.DOSSIER_TARGET+"/"+rep+".pdf");
			//org.apache.pdfbox.io.MemoryUsageSetting)
			try {
				MemoryUsageSetting.setupMixed(1000000);
				MemoryUsageSetting memoryUsageSetting = new MemoryUsageSetting(false, true, 0, 0);
				mergerUtilityFile.mergeDocuments(memoryUsageSetting);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
//			try {
//				mergerUtilityFile.mergeDocuments();
//				
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}
	}

	private static void afficher(String folder, int tabulation) {
		File repertoire = new File(folder);
		String[] listefichiers;
		if (repertoire.isDirectory()) {
			listefichiers = repertoire.list();
			for (String subfolder : listefichiers) {
				System.out.println("folder" + "/" + "subfolder,  tabulation+1");
				afficher(folder + "/" + subfolder, tabulation + 1);
				//List<FileInputStream> sourcePDFs = new ArrayList<FileInputStream>();
			List<InputStream> sourcePDFs= new ArrayList<InputStream>();
				//	List<String>str=new ArrayList<String>();
				mergerUtility.addSources(sourcePDFs);
				File subfolderFile=new File(subfolder);
				if(!subfolderFile.isDirectory()){
					try {
						sourcePDFs.add(new FileInputStream(subfolderFile));
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			  // set the destination pdf name and merge input pdfs
			  mergerUtility.setDestinationFileName(Constante.DOSSIER_TARGET+"/merged.pdf");
			  try {
				mergerUtility.mergeDocuments();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for (String subfolder : listefichiers) {
				System.out.println("folder" + "/" + "subfolder,  tabulation+1");
				afficher(folder + "/" + subfolder, tabulation + 1);
			}
		}
		else {
			for (int i = 0; i < tabulation; i++) {
				System.out.print("		");
			}
			System.out.println(folder);
		}
	}
}
