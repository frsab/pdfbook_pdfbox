package com.pdf.book.pdfbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyLoader {
	 
	private static final String PROPERTIES_FOLDER     = "src/ressources/properties/";
	private  Properties defaultProps ;
	private  Properties applicationProps;
	
	public  PropertyLoader(){
		 defaultProps = new Properties();
		 FileInputStream in;
		try {
			in = new FileInputStream(PROPERTIES_FOLDER+"defaultProperties");
			defaultProps.load(in);
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		 applicationProps = new Properties(defaultProps);

		 try {
			in = new FileInputStream(PROPERTIES_FOLDER+"appProperties");
			applicationProps.load(in); 
			
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	 
	 }

	public Properties getDefaultProps() {
		return defaultProps;
	}

	public void setDefaultProps(Properties defaultProps) {
		this.defaultProps = defaultProps;
	}

	public Properties getApplicationProps() {
		return applicationProps;
	}

	public void setApplicationProps(Properties applicationProps) {
		this.applicationProps = applicationProps;
	}

}
	