package testing;

import org.junit.Before;
import org.junit.Test;

import net.sourceforge.jwebunit.junit.WebTester;

/**
 * This class performs a system test on the PersonGUI using JWebUnit.
 * 
 * @author Islam
 *
 */
public class PersonGUIWebTestCase {
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
	public void testregisterNewUser() {
		// Start testing for persongui
		tester.beginAt("persongui");
		
		// Check all components of the Registering form
		tester.assertTitleEquals("Movies Rate Application");
		tester.assertFormPresent();
		
		tester.assertTextPresent("Name");
		tester.assertFormElementPresent("name");
		tester.assertTextPresent("Email");
		tester.assertFormElementPresent("email");
		tester.assertTextPresent("Age");
		tester.assertFormElementPresent("Age");
		tester.assertTextPresent("Password");
		tester.assertFormElementPresent("password");
		tester.assertButtonPresent("register");
		
		// Submit the form with given parameters
		tester.setTextField("name", "Ahmed");
		tester.setTextField("email", "ahmed@gmail.com");
		tester.setTextField("Age", "20");
		tester.setTextField("password","12");

		tester.clickButton("register");
		// Check the representation of the register process for an 
     
        tester.assertTextPresent("you Registered successfully");
	}
}
