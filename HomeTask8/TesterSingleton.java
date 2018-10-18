
public class TesterSingleton {

	private static TesterSingleton testerSingleton;
	
	private static String testfile = "This is test file.";
	
	public static synchronized TesterSingleton getTesterSingleton() {
		if (testerSingleton == null) {
			testerSingleton = new TesterSingleton();
		}
		return testerSingleton;
	}
	
	private TesterSingleton() {
		
	}
	public void addTestInfo(String testinfo) {
		testfile += testinfo + "\n";
	}
	
	public void showTestInfo() {
		System.out.println(testfile);
	}
}
