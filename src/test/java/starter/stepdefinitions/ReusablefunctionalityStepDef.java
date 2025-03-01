
package starter.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.*;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.Serenity;
import org.junit.Assert;
import starter.PageObjectsPages.ARASLoginPageObjects;
import starter.PageObjectsPages.nonMBOM.FMS.PartPage;
import starter.SerenitySteps.ArasLoginPageSteps;
import starter.SerenitySteps.HomePageStep;
import starter.Utility.ReusableUtilities;

public class ReusablefunctionalityStepDef {

    @Steps
    public static ArasLoginPageSteps loginSteps=new ArasLoginPageSteps();

    @Steps
    HomePageStep home;

    @Steps
    PartPage partPage;


    @Given("^Login to the ARAS Application as (.*)$")
    public void login_to_the_ARAS_Application_as_Admin(String userRole) {
        loginSteps.LoginToARASApplication(userRole);
        Assert.assertTrue(home.verifyOnHomePage());
    }
    @When("Logout and login to the ARAS Application as (.*)$")
    public void logout_and_login_to_the_ARAS_Application_as_Admin(String userRole) {
        loginSteps.logOutAndLogin();
        loginSteps.LoginToARASApplication(userRole);
        Assert.assertTrue(home.verifyOnHomePage());
    }
    @Then("^Navigate to (.*)$")
    public void navigate_to(String NavigationPath) {
       home.NavigateToContent(NavigationPath);
    }

    @BeforeAll
    @Given("ARAS Application is loaded in the Browser")
    public static void before_or_after_all() {
        if (Serenity.getWebdriverManager().getCurrentDriver() != null) {
            Serenity.getWebdriverManager().getCurrentDriver().close();
            Serenity.getWebdriverManager().getCurrentDriver().quit();
        }
        loginSteps.LoadArasApplication();
        ReusableUtilities reUtil=new ReusableUtilities();
        reUtil.conditionalWait("visibility", ARASLoginPageObjects.userID, "Waiting for user name field to be appeared");
    }
    @After
    @And("User logs out of the ARAS Application")
    public void userLogsOutOfTheARASApplication() {
        loginSteps.logOutAndLogin();
    }
}
