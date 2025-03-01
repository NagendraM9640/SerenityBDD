package starter.PageObjectsPages.nonMBOM.FMS;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import starter.Utility.ReusableUtilities;

public class NewCalculationOfFormulaPage extends PageObject {

    public static By clearSearchButton = By.xpath("//button[@title='Clear Search Criteria']");
    public static By runSearchButton = By.xpath("//button[@title='Run Search']");

    ReusableUtilities reusableUtilities;

    double minValueInteger;
    double maxValueInteger;

    public void selectMinValueAs(String minValue) {
        minValueInteger = Double.parseDouble(minValue);
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(ParametersToIngredientPage.newFrameForCreatePartFrame), "", 0);
        reusableUtilities.switchFrame($(ParametersToIngredientPage.newFrameForPartAddition), "", 0);
        $(ParametersToIngredientPage.searchResults).click();
        for (int i = 0; i <= 16; i++) {
            reusableUtilities.pressTab();
            waitABit(1000);
        }
        $(Serenity.getDriver().switchTo().activeElement()).click();
        waitABit(2000);
        $(Serenity.getDriver().switchTo().activeElement()).sendKeys(minValue);
    }
    public void selectMaxValueAs(String maxValue) {
        maxValueInteger = Double.parseDouble(maxValue);
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(ParametersToIngredientPage.newFrameForCreatePartFrame), "", 0);
        reusableUtilities.switchFrame($(ParametersToIngredientPage.newFrameForPartAddition), "", 0);
        reusableUtilities.pressTab();
        waitABit(1000);
        $(Serenity.getDriver().switchTo().activeElement()).click();
        waitABit(2000);
        $(Serenity.getDriver().switchTo().activeElement()).sendKeys(maxValue);
    }
    public void validationOfN10114TargetValue() {
        double result = ((minValueInteger + maxValueInteger)/2)*0.99704;
        String resultString = String.valueOf(result);
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(ParametersToIngredientPage.newFrameForCreatePartFrame), "", 0);
        reusableUtilities.switchFrame($(ParametersToIngredientPage.newFrameForPartAddition), "", 0);
        if($(By.xpath("//td[text()='"+resultString.trim()+"']")).isCurrentlyVisible()){
            Assert.assertTrue(true);
        }
        else {
            Serenity.getDriver().switchTo().defaultContent();
            reusableUtilities.switchFrame($(ParametersToIngredientPage.newFrameForCreatePartFrame), "", 0);
            reusableUtilities.switchFrame($(ParametersToIngredientPage.newFrameForPartAddition), "", 0);
            $(clearSearchButton).click();
            $(runSearchButton).click();
            if($(By.xpath("//td[text()='"+resultString.trim()+"']")).isCurrentlyVisible()){
                Assert.assertTrue(true);
            }
            else {
                Assert.fail();
            }
        }
    }
}