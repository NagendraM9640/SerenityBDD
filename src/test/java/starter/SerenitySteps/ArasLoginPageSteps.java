
package starter.SerenitySteps;

import net.serenitybdd.annotations.Step;
import starter.PageObjectsPages.ARASLoginPageObjects;

public class ArasLoginPageSteps {

    public static ARASLoginPageObjects arasLogin=new ARASLoginPageObjects();

    @Step
    public static void LoadArasApplication()
    {
         arasLogin.open();
    }
    @Step
    public void LoginToARASApplication(String userRole)
    {
        arasLogin.Login(userRole);
    }
    @Step
    public void logOutAndLogin() {
        arasLogin.logOutAndLogin();
    }

}
