package starter.PageObjectsPages.nonMBOM.FMS;/*
package starter.PageObjectsPages.FMS;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.util.EnvironmentVariables;
//import net.thucydides.core.util.SystemEnvironmentVariables;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class ARASNewParts extends PageObject {

    //static int tabno;
    static Random random = new Random();
    //public static EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();
    static By iFrame=By.xpath("//iframe[contains(@id,'innovator')]");
    static By itemNumber=By.name("item_number");
    static By name=By.name("name");
    static By type=By.name("classification");
    static By description=By.name("description");
    static By doneButton=By.xpath("//span[contains(text(),'Done')]");
    static By editButton=By.xpath("//span[contains(text(),'Edit')]");
    static By searchCloseButton=By.xpath("//span[@class='aras-icon-close']");
    //static By closeTabCross=By.xpath("//aras-header-tabs/div[1]/div[1]/ul[1]/li["+String.valueOf(tabno)+"]/span[1]/span[1]");
    static By okButton=By.xpath("//body/dialog[1]/div[2]/div[2]/button[1]");
    static By mandetoryerrorMessage=By.xpath("//span[contains(text(),'The \"Part Number\" field is required.')]");
    //static String partNumber = variables.getProperty("partNumber")+random.nextInt(1000);
    //String partName = variables.getProperty("partName");
    //String longDescription = variables.getProperty("longDescription");
    static By successMessage = By.xpath("//span[@class='aras-notification__message']");
    //String scenarioName_Create = variables.getProperty("scenarioName_Create");
    By createNewButton = (By.xpath("//button[@class='aras-button aras-secondary-menu__create-button']//span[text()='"+scenarioName_Create+"']"));
    public boolean mandetoryErrorMessage()
    {
        withTimeoutOf(90, TimeUnit.SECONDS).waitForPresenceOf(okButton);
        boolean result= $(mandetoryerrorMessage).isCurrentlyVisible();
        $(okButton).click();
        return result;
    }
    public boolean verifyOnNewPartsPage()
    {

        withTimeoutOf(90, TimeUnit.SECONDS).waitForPresenceOf(iFrame);
        withTimeoutOf(90, TimeUnit.SECONDS).waitFor(ExpectedConditions.invisibilityOf($(ARAS_HomePage.arasSpinner)));
        WebElement frame=$(iFrame);
        Serenity.getDriver().switchTo().frame(frame);
        Serenity.getDriver().switchTo().frame("instance");
        withTimeoutOf(90, TimeUnit.SECONDS).waitForPresenceOf(itemNumber);
        return $(itemNumber).isCurrentlyVisible();
    }
    public boolean onNewPartPage()
    {
        return $(itemNumber).isCurrentlyVisible();
    }
    public void enterPartNumber(String partNo)
    {
        Serenity.getDriver().switchTo().frame("instance");
        $(itemNumber).waitUntilClickable().click();//typeAndEnter(partNo);
        Serenity.getDriver().switchTo().activeElement().sendKeys(partNo);
        // $(itemNumber).type(partNo);
    }
    public void enterName(String Name)
    {
        $(name).waitUntilClickable().click();//typeAndEnter(partNo);
        Serenity.getDriver().switchTo().activeElement().sendKeys(Name);
    }
    public void selectType(String Type)
    {
        $(type).waitUntilClickable().click();//typeAndEnter(partNo);
        Serenity.getDriver().switchTo().activeElement().sendKeys(Type);

    }
    public void enterLongDescription(String desc)
    {
        $(description).waitUntilClickable().click();//typeAndEnter(partNo);
        Serenity.getDriver().switchTo().activeElement().sendKeys(desc);
    }
    public void click_On_DoneButton()
    {   Serenity.getDriver().switchTo().defaultContent();

        WebElement frame=$(iFrame);
        Serenity.getDriver().switchTo().frame(frame);
        $(doneButton).click();
    }
    public boolean checkSuccessMessage()
    {
        withTimeoutOf(90, TimeUnit.SECONDS).waitForPresenceOf(editButton);
        return $(editButton).isCurrentlyVisible();
    }
    public void closeTab(int tabIndex)
    {

        Serenity.getDriver().switchTo().defaultContent();
        $(By.xpath("//aras-header-tabs/div[1]/div[1]/ul[1]/li["+String.valueOf(tabIndex)+"]/span[1]/span[1]")).click();
    }
    public boolean enterPartDetails()
    {
        waitABit(4000);
        withTimeoutOf(90, TimeUnit.SECONDS).waitForPresenceOf(iFrame);
        //withTimeoutOf(90, TimeUnit.SECONDS).waitFor(ExpectedConditions.visibilityOf($(ARAS_HomePage.arasSpinner)));
        withTimeoutOf(90, TimeUnit.SECONDS).waitFor(ExpectedConditions.invisibilityOf($(ARAS_HomePage.arasSpinner)));
        WebElement frame=$(iFrame);
        Serenity.getDriver().switchTo().frame(frame);
        Serenity.getDriver().switchTo().frame("instance");
        // comm.performAction("Text", $(itemNumber),partNumber);
        $(name).waitUntilClickable().click();
        Serenity.getDriver().switchTo().activeElement().sendKeys(partName);
        $(description).waitUntilClickable().click();
        Serenity.getDriver().switchTo().activeElement().sendKeys(longDescription);
        withTimeoutOf(90, TimeUnit.SECONDS).waitForPresenceOf(itemNumber);
        $(itemNumber).waitUntilClickable().click();
        Serenity.getDriver().switchTo().activeElement().sendKeys(partNumber);
        $(type).waitUntilClickable().click();//typeAndEnter(partNo);
        Serenity.getDriver().switchTo().activeElement().clear();
        $(type).waitUntilClickable().click();//typeAndEnter(partNo);
        Serenity.getDriver().switchTo().activeElement().sendKeys("");
        Serenity.getDriver().switchTo().defaultContent();
        Serenity.getDriver().switchTo().frame(frame);
        $(doneButton).click();
        waitABit(1000);
        boolean result= $(successMessage).isCurrentlyVisible();
        System.out.println(result);
        return result;

    }

    public void enterDocumentDetails() {
        withTimeoutOf(90, TimeUnit.SECONDS).waitForPresenceOf(createNewButton);
        $(createNewButton).click();
        withTimeoutOf(90, TimeUnit.SECONDS).waitForPresenceOf(iFrame);
        //withTimeoutOf(90, TimeUnit.SECONDS).waitFor(ExpectedConditions.visibilityOf($(ARAS_HomePage.arasSpinner)));
        withTimeoutOf(90, TimeUnit.SECONDS).waitFor(ExpectedConditions.invisibilityOf($(ARAS_HomePage.arasSpinner)));
        WebElement frame=$(iFrame);
        Serenity.getDriver().switchTo().frame(frame);
        Serenity.getDriver().switchTo().frame("instance");
        // comm.performAction("Text", $(itemNumber),partNumber);
        $(name).waitUntilClickable().click();
        Serenity.getDriver().switchTo().activeElement().sendKeys(partName);
        $(description).waitUntilClickable().click();
        Serenity.getDriver().switchTo().activeElement().sendKeys(longDescription);
        withTimeoutOf(90, TimeUnit.SECONDS).waitForPresenceOf(itemNumber);
        $(itemNumber).waitUntilClickable().click();
        Serenity.getDriver().switchTo().activeElement().sendKeys(partNumber);

    }
    public void closeOpenedTab()
    {
        Serenity.getDriver().switchTo().defaultContent();
        $(searchCloseButton).click();
    }
}
*/
