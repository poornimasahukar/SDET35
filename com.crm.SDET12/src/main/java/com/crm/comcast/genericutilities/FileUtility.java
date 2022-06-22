
package com.crm.comcast.genericutilities;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * 
 * @author indir
 *
 */
public class FileUtility {
	/**
	 * it is used to get the common data from property file based on the key which you have specified as a argument
	 * @return
	 * @throws Throwable
	 */
	public String getPropertyKeyValue(String key) throws Throwable {
		FileInputStream Fis=new FileInputStream(IpathConstants.filepath);
		Properties pres = new Properties();
		pres.load(Fis);
		String value = pres.getProperty(key);
		return value;

	}
}

