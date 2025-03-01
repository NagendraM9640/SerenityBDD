
package starter.PageObjectsPages;

import net.serenitybdd.core.environment.WebDriverConfiguredEnvironment;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.environment.*;
import org.joda.time.Seconds;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

public class ARAS_LoginPage extends PageObject {

static By userName=By.id("Username");
static By passWord=By.id("Password");
static By loginButton=By.id("Login");

   /* public void OpenARASApplication()
    {
        Serenity.getDriver().manage().timeouts().setScriptTimeout(10,TimeUnit.SECONDS);

        try {
            Serenity.getDriver().navigate().to("https://ec2amaz-ig95t65/InnovatorServer/Client/");
           // evaluateJavascript("window.location.href='https://ec2amaz-ig95t65/InnovatorServer/Client/'");
            //
            //          getJavascriptExecutorFacade().executeScript("window.location.href='https://ec2amaz-ig95t65/InnovatorServer/Client/'");
            waitABit(20000);
            Robot rb= new Robot();
            rb.keyPress(KeyEvent.VK_TAB);
            rb.keyRelease(KeyEvent.VK_TAB);
            rb.keyPress(KeyEvent.VK_TAB);
            rb.keyRelease(KeyEvent.VK_TAB);
            rb.keyPress(KeyEvent.VK_TAB);
            rb.keyRelease(KeyEvent.VK_TAB);
            rb.keyPress(KeyEvent.VK_ENTER);
            rb.keyRelease(KeyEvent.VK_ENTER);
            System.out.println("I m in try");
            resetImplicitTimeout();
            withTimeoutOf(60, TimeUnit.SECONDS).waitForPresenceOf(loginButton);
        }catch(Exception e)
        {
            try {
                waitABit(20000);
                Robot rb= new Robot();
                rb.keyPress(KeyEvent.VK_TAB);
                rb.keyRelease(KeyEvent.VK_TAB);
                rb.keyPress(KeyEvent.VK_TAB);
                rb.keyRelease(KeyEvent.VK_TAB);
                rb.keyPress(KeyEvent.VK_TAB);
                rb.keyRelease(KeyEvent.VK_TAB);
                rb.keyPress(KeyEvent.VK_ENTER);
                rb.keyRelease(KeyEvent.VK_ENTER);
                System.out.println("I m in catch");
                resetImplicitTimeout();
                withTimeoutOf(60, TimeUnit.SECONDS).waitForPresenceOf(loginButton);
            } catch (AWTException awtException) {
                awtException.printStackTrace();
            }
        }
    }*/

    public void enter_UserName(String user)
    {
        withTimeoutOf(90, TimeUnit.SECONDS).waitForPresenceOf(userName);
        $(userName).sendKeys(user);
    }

    public void enter_Password(String password)
    {
        $(passWord).sendKeys(password);
    }

    public void clickOnLoginButton()
    {

        $(loginButton).click();
    }
}
