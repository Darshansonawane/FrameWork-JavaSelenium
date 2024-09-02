package Utilities;

public class rdg {
	
	 static String uniqueEmail = "d" + System.currentTimeMillis() + "@gmail.com";

	public static String getUniqueEmail() {
		return uniqueEmail;
	}

	public static void setUniqueEmail(String uniqueEmail) {
		rdg.uniqueEmail = uniqueEmail;
	}

}
