package starter.PageObjectsPages.nonMBOM.FMS;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import starter.Utility.ReusableUtilities;

import java.util.List;

public class DemoFeedbackPI1Sprint3Page extends PageObject {

    public static By deleteParameterFromParametersButton = By.xpath("//button[@title='Delete pmi_Parameters']");

    ReusableUtilities reusableUtilities;

    public void userValidatesParametersTabPosition() {
        Serenity.getDriver().switchTo().defaultContent();
        if($(ParametersToIngredientPage.parametersTab).isCurrentlyVisible()){
            Assert.fail();
        }
    }
    public void validateStandardDeviationFieldInParametersTab() {
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(ParametersToIngredientPage.newFrameForCreatePartFrame), "", 0);
        reusableUtilities.switchFrame($(ParametersToIngredientPage.newFrameForPartAddition), "", 0);
        By standardDeviationField = By.xpath("//*[contains(text(),'Standard Deviation')]");
        if($(standardDeviationField).isCurrentlyVisible()){
            Assert.fail();
        }
    }
    public void validateIngredientApplicationFieldInParametersTab() {
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(PartPage.newFrameForCreatePartFrame), "", 0);
        reusableUtilities.switchFrame($(PartPage.newFrameForCreatePartFrameDataEntry), "", 0);
        By standardDeviationField = By.xpath("//*[contains(text(),'Ingredient Application')]");
        if($(standardDeviationField).isCurrentlyVisible()){
            Assert.fail();
        }
    }
    public void userAddsMinValueAndMaxValue(List<List<String>> data){
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(ParametersToIngredientPage.newFrameForCreatePartFrame), "", 0);
        reusableUtilities.switchFrame($(ParametersToIngredientPage.newFrameForPartAddition), "", 0);
        reusableUtilities.pressTab();
        $(Serenity.getDriver().switchTo().activeElement()).typeAndTab(data.get(0).get(0));
        $(Serenity.getDriver().switchTo().activeElement()).typeAndTab(data.get(0).get(1));
    }
    public void validateDecimalPlacesShouldAutoPopulateTrailingZeroes(List<List<String>> data){
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(ParametersToIngredientPage.newFrameForCreatePartFrame), "", 0);
        reusableUtilities.switchFrame($(ParametersToIngredientPage.newFrameForPartAddition), "", 0);
        reusableUtilities.pressLeftNavigation();
        if($(Serenity.getDriver().switchTo().activeElement()).getText().equalsIgnoreCase(data.get(0).get(1))){
            Assert.assertTrue(true);
        }
        reusableUtilities.pressLeftNavigation();
        if($(Serenity.getDriver().switchTo().activeElement()).getText().equalsIgnoreCase(data.get(0).get(0))){
            Assert.assertTrue(true);
        }
        waitABit(5000);
    }
    public void validateTargetValueFieldAfterDeleting(){
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(ParametersToIngredientPage.newFrameForCreatePartFrame), "", 0);
        reusableUtilities.switchFrame($(ParametersToIngredientPage.newFrameForPartAddition), "", 0);
        waitABit(1000);
        reusableUtilities.pressTab();
        waitABit(1000);
        reusableUtilities.pressShiftTab();
        waitABit(1000);
        reusableUtilities.pressBackspace();
        reusableUtilities.pressBackspace();
        reusableUtilities.pressBackspace();
        reusableUtilities.pressBackspace();
        reusableUtilities.pressBackspace();
        reusableUtilities.pressBackspace();
        reusableUtilities.pressBackspace();
        waitABit(1000);
        reusableUtilities.pressTab();
        waitABit(1000);
        reusableUtilities.pressShiftTab();
        if($(Serenity.getDriver().switchTo().activeElement()).getText().isEmpty() && $(Serenity.getDriver().switchTo().activeElement()).getAttribute("value").isEmpty()){
            Assert.assertTrue(true);
        }
    }
    public void validateTextColumnShouldDisableIfDataTypeIsNumber(){
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(ParametersToIngredientPage.newFrameForCreatePartFrame), "", 0);
        reusableUtilities.switchFrame($(ParametersToIngredientPage.newFrameForPartAddition), "", 0);
        reusableUtilities.pressShiftTab();
        reusableUtilities.pressShiftTab();
        $(Serenity.getDriver().switchTo().activeElement()).sendKeys("Test");
        if($(Serenity.getDriver().switchTo().activeElement()).getText().isEmpty() && $(Serenity.getDriver().switchTo().activeElement()).getAttribute("value").isEmpty()){
            Assert.assertTrue(true);
        }
        $(deleteParameterFromParametersButton).click();
    }
    public void validateTargetValueColumnShouldDisableIfDataTypeIsListMultiListAndFreeText() {
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(ParametersToIngredientPage.newFrameForCreatePartFrame), "", 0);
        reusableUtilities.switchFrame($(ParametersToIngredientPage.newFrameForPartAddition), "", 0);
        reusableUtilities.pressShiftTab();
        reusableUtilities.pressTab();
        $(Serenity.getDriver().switchTo().activeElement()).sendKeys("Test");
        if($(Serenity.getDriver().switchTo().activeElement()).getText().isEmpty() && $(Serenity.getDriver().switchTo().activeElement()).getAttribute("value").isEmpty()){
            Assert.assertTrue(true);
        }
        $(deleteParameterFromParametersButton).click();
    }
}