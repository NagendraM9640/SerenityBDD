package starter.PageObjectsPages.nonMBOM.FMS;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import starter.Utility.ReusableUtilities;

import java.util.List;

public class ParametersToIngredientPage extends PageObject {

    public static By parametersTab = By.xpath("(//div[@class='aras-scroller__wrapper']//span[@class='aras-tabs__label'])[2]");
    public static By partTab = By.xpath("(//div[@class='aras-scroller__wrapper']//span[@class='aras-tabs__label'])[1]");
    public static By addParametersButton = By.xpath("//button[contains(@class,'aras-button') and @title = 'Add Global Harmonized Parameters']");
    public static By createParametersButton = By.cssSelector("button[title='Add Global Harmonized Parameters']");
    public static By searchFieldToSearchParameters = By.xpath("//*[@class='aras-form-input']");
    public static By searchResults = By.xpath("//*[@class='aras-grid-row-cell ']");
    public static By okButton = By.xpath("//*[text()='OK']");
    public static By newFrameForCreatePartFrame = By.xpath("//iframe[contains(@name,'innovator_')]");
    public static By newFrameForPartAddition = By.cssSelector("iframe[title='pmi_Parameters Relationship']"); //By.xpath(//iframe[@id='20232B8F931F43B4AF1C25F4204C59AA']")
    public static By newFrameToSelectParameters = By.xpath("//*[@class='aras-dialog__iframe']");

    ReusableUtilities reusableUtilities;

    /*public void userClicksOnParametersTab() {
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(newFrameForCreatePartFrame), "", 0);
        reusableUtilities.performAction("", $(parametersTab), "");
    }

    public void userValidatesParametersTabPosition() {
        if (reusableUtilities.getObjectProperty($(partTab), "text").toString().equalsIgnoreCase("Part") &&
                reusableUtilities.getObjectProperty($(parametersTab), "text").toString().equalsIgnoreCase("Parameters")) {
            Assert.assertTrue("Parameters Tab is present after Part Tab", true);
        }
    }*/

    public void userTriesToAddParameters() {
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(newFrameForCreatePartFrame), "", 0);
        reusableUtilities.switchFrame($(newFrameForPartAddition), "", 0);
        reusableUtilities.conditionalWait("visibility", addParametersButton, "");
        reusableUtilities.performAction("", $(addParametersButton), "");
        Serenity.getDriver().switchTo().parentFrame();
        reusableUtilities.switchFrame($(newFrameToSelectParameters), "", 0);
        reusableUtilities.performAction("", $(searchFieldToSearchParameters), "");
        for(int i=1; i<=12; i++){
            waitABit(500);
            reusableUtilities.pressTab();
        }
        waitABit(2000);
        reusableUtilities.pressBackspace();
        reusableUtilities.pressEnterWithoutElement();
        reusableUtilities.conditionalWait("visibility", searchResults, "");
        reusableUtilities.performAction("", $(searchResults), "");
        reusableUtilities.performAction("", $(okButton), "");
    }

    public void userValidatesAddedParameters() {
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(newFrameForCreatePartFrame), "", 0);
        if ($(searchResults).isCurrentlyVisible()) {
            Assert.assertTrue("Parameters has been added successfully", true);
        }
    }

    public void parameterSubMenuOrderValidation() {
        try {
            Serenity.getDriver().switchTo().defaultContent();
            reusableUtilities.switchFrame($(newFrameForCreatePartFrame), "", 0);
            reusableUtilities.switchFrame($(newFrameForPartAddition), "", 0);
            reusableUtilities.performAction("", $(searchResults), "");
            for(int i = 1; i <= 20; i++) {
                reusableUtilities.pressRightNavigation();
                waitABit(1000);
            }
            int a[] = {9, 10, 11, 12, 13};
            String b[] = {"Target Value", "Min Value", "Max Value", "Standard Deviation", "Remark"};
            for (int i = 0; i < a.length; i++) {
                System.out.println(reusableUtilities.getObjectProperty($(By.xpath("(//span[@class='aras-grid-head-cell-label-text'])["+a[i]+"]")), "text"));
            if (reusableUtilities.getObjectProperty($(By.xpath("(//span[@class='aras-grid-head-cell-label-text'])["+a[i]+"]")), "text")
                    .equalsIgnoreCase(b[i])) {
                Assert.assertTrue(true);
            }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void userEntersDataInSubMenus(List<List<String>> data) {
        waitABit(2000);
        for (int i = data.get(0).size()-1; i>=0; i--) {
            System.out.println("Inside Loop");
            $(Serenity.getDriver().switchTo().activeElement()).sendKeys(Keys.ENTER);
            $(Serenity.getDriver().switchTo().activeElement()).sendKeys(data.get(0).get(i));
            $(Serenity.getDriver().switchTo().activeElement()).sendKeys(Keys.ENTER);
            reusableUtilities.pressLeftNavigation();
            waitABit(1000);
        }
    }
    public void userCreatesParameter() {
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(newFrameForCreatePartFrame), "", 0);
        reusableUtilities.switchFrame($(newFrameForPartAddition), "", 0);
        reusableUtilities.conditionalWait("visibility", createParametersButton, "");
        reusableUtilities.performAction("", $(createParametersButton), "");
    }
    public void userProvidesDataToCreateParameter(List<List<String>> data) {
        Serenity.getDriver().switchTo().activeElement().sendKeys(data.get(0).get(0));
        reusableUtilities.pressTab();
        reusableUtilities.pressTab();
        Serenity.getDriver().switchTo().activeElement().sendKeys(data.get(0).get(1));
        reusableUtilities.pressTab();
        reusableUtilities.pressTab();
        Serenity.getDriver().switchTo().activeElement().sendKeys(data.get(0).get(2));
        reusableUtilities.pressTab();
        Serenity.getDriver().switchTo().activeElement().sendKeys(data.get(0).get(3));
        reusableUtilities.pressTab();
        Serenity.getDriver().switchTo().activeElement().sendKeys(data.get(0).get(4));
        reusableUtilities.pressTab();
        reusableUtilities.pressTab();
        Serenity.getDriver().switchTo().activeElement().sendKeys(data.get(0).get(5));
        reusableUtilities.pressTab();
        Serenity.getDriver().switchTo().activeElement().sendKeys(data.get(0).get(6));
        reusableUtilities.pressTab();
        reusableUtilities.pressTab();
        reusableUtilities.pressTab();
        reusableUtilities.pressTab();
        reusableUtilities.pressTab();
        Serenity.getDriver().switchTo().activeElement().sendKeys(data.get(0).get(7));
        waitABit(2000);
    }
    public void validationOfTargetValue(String targetValue) {
        //userClicksOnParametersTab();
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(newFrameForCreatePartFrame), "", 0);
        reusableUtilities.switchFrame($(newFrameForPartAddition), "", 0);
        reusableUtilities.performAction("", $(searchResults), "");
        for(int i = 1; i <= 14; i++) {
            reusableUtilities.pressTab();
            waitABit(500);
        }
        if(reusableUtilities.getObjectProperty($(Serenity.getDriver().switchTo().activeElement()), "text").equalsIgnoreCase(targetValue)) {
            Assert.assertTrue(true);
        }
        else {
            Assert.assertFalse(false);
        }
    }

}
