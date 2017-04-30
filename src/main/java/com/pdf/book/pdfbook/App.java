package com.pdf.book.pdfbook;

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
        System.out.println(pl.getApplicationProps().getProperty("nom"));
    }
}
