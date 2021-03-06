package testing;

import org.junit.Before;
import org.junit.Test;

import net.sourceforge.jwebunit.junit.WebTester;

public class UserGUIWebTestCase {
	private WebTester tester;
	/**
	 * Create a new WebTester object that performs the test.
	 */
	@Before
	public void prepare() {
		tester = new WebTester();
		tester.setBaseUrl("http://localhost:8080/MRapp/");
	}
	@Test
	public void TestLogin () {
		// Start testing for usergui
		tester.beginAt("usergui?action=signIn");
		
		// Check all components of the login form
		tester.assertTitleEquals("Movies Rate Application");
		tester.assertFormPresent();
		
		
		tester.assertTextPresent("Username");
		tester.assertFormElementPresent("uname");
		
		tester.assertTextPresent("Password");
		tester.assertFormElementPresent("psw");
	
		// Submit the form with given parameters
			tester.setTextField("uname", "Ahmed");
			tester.setTextField("psw", "12");


		tester.clickButton("login");
	}
	
}
