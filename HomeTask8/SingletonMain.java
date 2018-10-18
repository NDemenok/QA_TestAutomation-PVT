import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Main {

	public static void main(String[] args)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException {

		// Singleton
		System.out.println(TesterSingleton.getTesterSingleton().toString());
		System.out.println(TesterSingleton.getTesterSingleton().toString());

		TesterSingleton.getTesterSingleton().addTestInfo("First info...");
		TesterSingleton.getTesterSingleton().addTestInfo("Second info...");
		TesterSingleton.getTesterSingleton().addTestInfo("Third info...");

		TesterSingleton.getTesterSingleton().showTestInfo();

		// Reflection
		Class c = Class.forName("TesterSingleton");
		String name = c.getName();
		System.out.println("Name- " + name);

		Constructor[] constr = c.getConstructors();

		for (int i = 0; i < constr.length; i++) {
			System.out.println(constr[i]);
		}

		Method[] methods = c.getMethods();

		for (int i = 0; i < methods.length; i++) {
			System.out.println(methods[i]);
		}

		Field[] fields = c.getFields();

		for (int i = 0; i < fields.length; i++) {
			System.out.println(fields[i]);
		}

	}

}
