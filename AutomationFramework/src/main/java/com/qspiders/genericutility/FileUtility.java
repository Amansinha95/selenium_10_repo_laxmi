package com.qspiders.genericutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * @Author Rajlaxmi
 */

public class FileUtility {
	/**
	 * this data is used to get data from property file
	 * @param key
	 * @return
	 * @throws IOException
	 */
public String getDataFromProperty(String key) throws IOException {
	FileInputStream fis=new FileInputStream("./src/test/resources/TestData/commondata.properties");
	Properties prop=new Properties();
	prop.load(fis);
	return prop.getProperty(key);
}

}

