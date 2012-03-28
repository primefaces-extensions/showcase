package org.primefaces.extensions.showcase.util;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ShowcaseUtil {
	
	public static String getFileContentFromWeb(String fileName) {
		try {
			FacesContext fc = FacesContext.getCurrentInstance();
			ExternalContext ec = fc.getExternalContext();
			InputStream is = ec.getResourceAsStream(fileName);
			return convertStreamToString(is);
		}
		catch (Exception e) {
			return null;
		}
	}
	public static String getFileContentFromClasspath(String fileName) {
		try {
			InputStream is = ShowcaseUtil.class.getResourceAsStream(fileName);
			return convertStreamToString(is);
		}
		catch (Exception e) {
			return null;
		}
	}
	
	private static String convertStreamToString(InputStream is) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(is));
 
    	StringBuilder sb = new StringBuilder();
 
    	String line;
    	while ((line = br.readLine()) != null) {
    		sb.append(line);
    		sb.append("\n");
    	} 
 
    	return sb.toString();
	}
}
