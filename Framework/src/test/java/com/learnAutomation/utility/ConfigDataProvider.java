package com.learnAutomation.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ConfigDataProvider {
	Properties prop;

	public ConfigDataProvider() {
		File src = new File("./Config/Config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			prop = new Properties();
			prop.load(fis);

		} catch (Exception e) {
			System.out.println("unable to load the propfile" + e.getMessage());

		}

	}

	public String getdatafromprop(String keytosearch) {
		return prop.getProperty(keytosearch);
	}

	public String getbrowser() {
		return prop.getProperty("Browser");
	}

	public String getUrl() {
		return prop.getProperty("URl");

	}

}
