package com.qspiders.genericutility;

import java.time.LocalDateTime;
/**
 * @author Rajlaxmi
 */
public class JavaUtility {
	/**
	 * This method will capture System Date and Time and return
	 * @return System date and time
	 */
public String getSystemTime() {
	return LocalDateTime.now().toString().replace(":", "-");
}
}
