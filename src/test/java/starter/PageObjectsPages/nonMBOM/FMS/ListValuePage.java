package starter.PageObjectsPages.nonMBOM.FMS;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import starter.Utility.ReusableUtilities;

public class ListValuePage extends PageObject {

    //public static By labelDropdown = By.xpath("//aras-dropdown[@class='aras-filter-list aras-dropdown-container aras-grid-multi-list']");
    public static By labelDropdown = By.xpath("//button[@class='aras-filter-list__button aras-btn aras-icon-arrow aras-icon-arrow_down']");
    public static By deleteParametersButton = By.xpath("//button[@title='Delete pmi_Parameters']");

    ReusableUtilities reusableUtilities;

    public void validationOfTextValueField(){
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(ParametersToIngredientPage.newFrameForCreatePartFrame), "", 0);
        reusableUtilities.switchFrame($(ParametersToIngredientPage.newFrameForPartAddition), "", 0);
        reusableUtilities.conditionalWait("visibility", ParametersToIngredientPage.addParametersButton, "");
        By defaultAttribute = By.xpath("//*[contains(text(),'Text Value')]");
        if($(defaultAttribute).isCurrentlyVisible()){
            Assert.fail();
        }
    }
    public void validationOfTextField(){
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(ParametersToIngredientPage.newFrameForCreatePartFrame), "", 0);
        reusableUtilities.switchFrame($(ParametersToIngredientPage.newFrameForPartAddition), "", 0);
        reusableUtilities.conditionalWait("visibility", ParametersToIngredientPage.addParametersButton, "");
        By defaultAttribute = By.xpath("//*[contains(text(),'Text')]");
        if($(defaultAttribute).isCurrentlyVisible()){
            Assert.assertTrue(true);
        }
    }
    public void validationOfListValueField(){
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(ParametersToIngredientPage.newFrameForCreatePartFrame), "", 0);
        reusableUtilities.switchFrame($(ParametersToIngredientPage.newFrameForPartAddition), "", 0);
        waitABit(2000);
        $(ParametersToIngredientPage.searchResults).click();
        reusableUtilities.pressTab();
        reusableUtilities.pressTab();
        reusableUtilities.pressTab();
        reusableUtilities.pressTab();
        reusableUtilities.pressTab();
        reusableUtilities.pressTab();
        reusableUtilities.pressTab();
        reusableUtilities.pressTab();
        reusableUtilities.pressTab();
        reusableUtilities.pressTab();
        reusableUtilities.pressTab();
        reusableUtilities.pressTab();
        reusableUtilities.pressTab();
        reusableUtilities.pressTab();
        $(Serenity.getDriver().switchTo().activeElement()).click();
        $(Serenity.getDriver().switchTo().activeElement()).sendKeys("test");
        if($(Serenity.getDriver().switchTo().activeElement()).getText().equalsIgnoreCase("test")){
            Assert.fail();
        }
        $(deleteParametersButton).click();
    }
    public void userAddsDataTypeListParameter(){
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(ParametersToIngredientPage.newFrameForCreatePartFrame), "", 0);
        reusableUtilities.switchFrame($(ParametersToIngredientPage.newFrameForPartAddition), "", 0);
        reusableUtilities.conditionalWait("visibility", ParametersToIngredientPage.addParametersButton, "");
        reusableUtilities.performAction("", $(ParametersToIngredientPage.addParametersButton), "");
        Serenity.getDriver().switchTo().parentFrame();
        reusableUtilities.switchFrame($(ParametersToIngredientPage.newFrameToSelectParameters), "", 0);
        reusableUtilities.performAction("", $(ParametersToIngredientPage.searchFieldToSearchParameters), "");
        reusableUtilities.pressTab();
        waitABit(1000);
        reusableUtilities.pressTab();
        waitABit(1000);
        reusableUtilities.pressTab();
        waitABit(1000);
        reusableUtilities.pressTab();
        waitABit(1000);
        reusableUtilities.pressTab();
        waitABit(1000);
        reusableUtilities.pressTab();
        waitABit(1000);
        reusableUtilities.pressTab();
        waitABit(1000);
        reusableUtilities.pressTab();
        waitABit(1000);
        reusableUtilities.pressEnd();
        waitABit(1000);
        reusableUtilities.pressBackspace();
        waitABit(1000);
        reusableUtilities.pressBackspace();
        waitABit(1000);
        reusableUtilities.pressBackspace();
        waitABit(1000);
        reusableUtilities.pressBackspace();
        waitABit(1000);
        reusableUtilities.pressBackspace();
        waitABit(1000);
        reusableUtilities.pressBackspace();
        waitABit(1000);
        reusableUtilities.pressBackspace();
        waitABit(1000);
        reusableUtilities.pressBackspace();
        waitABit(1000);
        reusableUtilities.pressBackspace();
        waitABit(1000);
        reusableUtilities.pressBackspace();
        waitABit(1000);
        reusableUtilities.pressDownNavigation();
        waitABit(1000);
        $(By.xpath("//*[text()='List']")).click();
        waitABit(1000);
        reusableUtilities.performAction("", $(ParametersToIngredientPage.searchFieldToSearchParameters), "");
        reusableUtilities.pressEnter(ParametersToIngredientPage.searchFieldToSearchParameters);
        waitABit(1000);
        reusableUtilities.conditionalWait("visibility", ParametersToIngredientPage.searchResults, "");
        waitABit(1000);
        reusableUtilities.performAction("", $(ParametersToIngredientPage.searchResults), "");
        reusableUtilities.performAction("", $(ParametersToIngredientPage.okButton), "");
    }
    public void selectTextFieldFromDropdown(){
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(ParametersToIngredientPage.newFrameForCreatePartFrame), "", 0);
        reusableUtilities.switchFrame($(ParametersToIngredientPage.newFrameForPartAddition), "", 0);
        $(ParametersToIngredientPage.searchResults).click();
        reusableUtilities.pressTab();
        waitABit(1000);
        reusableUtilities.pressTab();
        waitABit(1000);
        reusableUtilities.pressTab();
        waitABit(1000);
        reusableUtilities.pressTab();
        waitABit(1000);
        reusableUtilities.pressTab();
        waitABit(1000);
        reusableUtilities.pressTab();
        waitABit(1000);
        reusableUtilities.pressTab();
        waitABit(1000);
        reusableUtilities.pressTab();
        waitABit(1000);
        reusableUtilities.pressTab();
        waitABit(1000);
        reusableUtilities.pressTab();
        waitABit(1000);
        reusableUtilities.pressTab();
        waitABit(1000);
        reusableUtilities.pressTab();
        waitABit(1000);
        reusableUtilities.pressTab();
        waitABit(1000);
        reusableUtilities.pressDownNavigation();
        waitABit(1000);
        reusableUtilities.pressDownNavigation();
        waitABit(1000);
        reusableUtilities.pressEnterWithoutElement();
    }
    public void userAddsDataTypeMultiListParameter(){
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(ParametersToIngredientPage.newFrameForCreatePartFrame), "", 0);
        reusableUtilities.switchFrame($(ParametersToIngredientPage.newFrameForPartAddition), "", 0);
        reusableUtilities.conditionalWait("visibility", ParametersToIngredientPage.addParametersButton, "");
        reusableUtilities.performAction("", $(ParametersToIngredientPage.addParametersButton), "");
        Serenity.getDriver().switchTo().parentFrame();
        reusableUtilities.switchFrame($(ParametersToIngredientPage.newFrameToSelectParameters), "", 0);
        reusableUtilities.performAction("", $(ParametersToIngredientPage.searchFieldToSearchParameters), "");
        $(ParametersToIngredientPage.searchFieldToSearchParameters).sendKeys("Arup*");
        reusableUtilities.pressTab();
        waitABit(1000);
        reusableUtilities.pressTab();
        waitABit(1000);
        reusableUtilities.pressTab();
        waitABit(1000);
        reusableUtilities.pressTab();
        waitABit(1000);
        reusableUtilities.pressTab();
        waitABit(1000);
        reusableUtilities.pressTab();
        waitABit(1000);
        reusableUtilities.pressTab();
        waitABit(1000);
        reusableUtilities.pressTab();
        waitABit(1000);
        reusableUtilities.pressEnd();
        waitABit(1000);
        reusableUtilities.pressBackspace();
        waitABit(1000);
        reusableUtilities.pressBackspace();
        waitABit(1000);
        reusableUtilities.pressBackspace();
        waitABit(1000);
        reusableUtilities.pressBackspace();
        waitABit(1000);
        reusableUtilities.pressBackspace();
        waitABit(1000);
        reusableUtilities.pressBackspace();
        waitABit(1000);
        reusableUtilities.pressBackspace();
        waitABit(1000);
        reusableUtilities.pressBackspace();
        waitABit(1000);
        reusableUtilities.pressBackspace();
        waitABit(1000);
        reusableUtilities.pressBackspace();
        waitABit(1000);
        reusableUtilities.pressDownNavigation();
        waitABit(1000);
        $(By.xpath("//*[text()='Multi List']")).click();
        waitABit(1000);
        reusableUtilities.performAction("", $(ParametersToIngredientPage.searchFieldToSearchParameters), "");
        reusableUtilities.pressEnter(ParametersToIngredientPage.searchFieldToSearchParameters);
        waitABit(1000);
        reusableUtilities.conditionalWait("visibility", ParametersToIngredientPage.searchResults, "");
        waitABit(1000);
        reusableUtilities.performAction("", $(ParametersToIngredientPage.searchResults), "");
        reusableUtilities.performAction("", $(ParametersToIngredientPage.okButton), "");
    }
    public void selectMultipleLabelsInTextFieldForTheMultiList(){
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(ParametersToIngredientPage.newFrameForCreatePartFrame), "", 0);
        reusableUtilities.switchFrame($(ParametersToIngredientPage.newFrameForPartAddition), "", 0);
        $(ParametersToIngredientPage.searchResults).click();
        waitABit(1000);
        reusableUtilities.pressDownNavigation();
        waitABit(1000);
        reusableUtilities.pressTab();
        waitABit(1000);
        reusableUtilities.pressTab();
        waitABit(1000);
        reusableUtilities.pressTab();
        waitABit(1000);
        reusableUtilities.pressTab();
        waitABit(1000);
        reusableUtilities.pressTab();
        waitABit(1000);
        reusableUtilities.pressTab();
        waitABit(1000);
        reusableUtilities.pressTab();
        waitABit(1000);
        reusableUtilities.pressTab();
        waitABit(1000);
        reusableUtilities.pressTab();
        waitABit(1000);
        reusableUtilities.pressTab();
        waitABit(1000);
        reusableUtilities.pressTab();
        waitABit(1000);
        reusableUtilities.pressTab();
        waitABit(1000);
        reusableUtilities.pressTab();
        waitABit(1000);
        $(labelDropdown).click();
        waitABit(1000);
        $(By.xpath("//*[text()='Gold']")).click();
        reusableUtilities.pressTab();
        reusableUtilities.pressShiftTab();
        waitABit(1000);
        $(labelDropdown).click();
        $(By.xpath("//*[text()='Star']")).click();
        reusableUtilities.pressTab();
        waitABit(1000);
        if($(By.xpath("//*[text()='Gold, Star']")).isCurrentlyVisible()){
            Assert.assertTrue(true);
        }
        else{
            Assert.fail();
        }
    }
    public void validatingListValueColumnForListTypeParameter(){
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(ParametersToIngredientPage.newFrameForCreatePartFrame), "", 0);
        reusableUtilities.switchFrame($(ParametersToIngredientPage.newFrameForPartAddition), "", 0);
        reusableUtilities.pressUpNavigation();
        if($(Serenity.getDriver().switchTo().activeElement()).getText().isEmpty()){
            Assert.fail();
        }
    }
    public void validatingListValueColumnForMultiListTypeParameter(){
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(ParametersToIngredientPage.newFrameForCreatePartFrame), "", 0);
        reusableUtilities.switchFrame($(ParametersToIngredientPage.newFrameForPartAddition), "", 0);
        reusableUtilities.pressDownNavigation();
        if($(Serenity.getDriver().switchTo().activeElement()).getText().isEmpty()){
            Assert.fail();
        }
    }
}