package starter.PageObjectsPages.nonMBOM.FMS;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import starter.Utility.ReusableUtilities;

public class QuantumSatisPage extends PageObject {

    public static By quantumSatisForSecondPartAddedInBOM = By.xpath("(//span[@class='aras-checkbox__check-button'])[2]");

    ReusableUtilities reusableUtilities;

    double totalQuantityInInt;

    public void userChecksInQuantumSatisForSecondPartInBOM(){
        waitABit(3000);
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(PartPage.newFrameForCreatePartFrame), "", 0);
        reusableUtilities.conditionalWait("visibility", RecipeInstructionPage.newFrameInBOM, "");
        reusableUtilities.switchFrame($(RecipeInstructionPage.newFrameInBOM), "", 0);
        $(PartPage.searchResults).click();
        waitABit(1000);
        $(quantumSatisForSecondPartAddedInBOM).click();
        waitABit(1000);
        waitABit(2000);
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(PartPage.newFrameForCreatePartFrame), "", 0);
        reusableUtilities.conditionalWait("visibility", RecipeInstructionPage.newFrameInBOM, "");
        reusableUtilities.switchFrame($(RecipeInstructionPage.newFrameInBOM), "", 0);
        String totalQuantityInString = $(QuantitySumPage.totalQuantityField).getAttribute("value");
        totalQuantityInInt = Double.parseDouble(totalQuantityInString);
    }
    public void userAddsR101235ParameterButTargetValueAs0(String targetValue){
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(ParametersToIngredientPage.newFrameForCreatePartFrame), "", 0);
        reusableUtilities.switchFrame($(ParametersToIngredientPage.newFrameForPartAddition), "", 0);
        reusableUtilities.conditionalWait("visibility", ParametersToIngredientPage.addParametersButton, "");
        reusableUtilities.performAction("", $(ParametersToIngredientPage.addParametersButton), "");
        Serenity.getDriver().switchTo().parentFrame();
        reusableUtilities.switchFrame($(ParametersToIngredientPage.newFrameToSelectParameters), "", 0);
        reusableUtilities.performAction("", $(ParametersToIngredientPage.searchFieldToSearchParameters), "");
        reusableUtilities.pressBackspace();
        reusableUtilities.pressBackspace();
        reusableUtilities.pressBackspace();
        reusableUtilities.pressBackspace();
        reusableUtilities.pressBackspace();
        reusableUtilities.pressBackspace();
        reusableUtilities.pressBackspace();
        reusableUtilities.pressBackspace();
        reusableUtilities.performAction("text", $(ParametersToIngredientPage.searchFieldToSearchParameters), "R10135*");
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
        reusableUtilities.pressDelete();
        reusableUtilities.pressDelete();
        reusableUtilities.pressDelete();
        reusableUtilities.pressDelete();
        reusableUtilities.pressDelete();
        reusableUtilities.pressDelete();
        reusableUtilities.pressDelete();
        reusableUtilities.pressDelete();
        reusableUtilities.pressDelete();
        reusableUtilities.pressDelete();
        waitABit(1000);
        reusableUtilities.performAction("", $(ParametersToIngredientPage.searchFieldToSearchParameters), "");
        reusableUtilities.pressEnter(ParametersToIngredientPage.searchFieldToSearchParameters);
        waitABit(1000);
        reusableUtilities.conditionalWait("visibility", ParametersToIngredientPage.searchResults, "");
        reusableUtilities.performAction("", $(ParametersToIngredientPage.searchResults), "");
        reusableUtilities.performAction("", $(ParametersToIngredientPage.okButton), "");
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(ParametersToIngredientPage.newFrameForCreatePartFrame), "", 0);
        reusableUtilities.switchFrame($(ParametersToIngredientPage.newFrameForPartAddition), "", 0);
        reusableUtilities.performAction("", $(ParametersToIngredientPage.searchResults), "");
        for(int i = 1; i <= 15; i++) {
            reusableUtilities.pressTab();
            waitABit(500);
        }
        $(Serenity.getDriver().switchTo().activeElement()).typeAndTab(targetValue);
    }
    public void userPutsTargetValueSameAsQuantitySum(){
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(ParametersToIngredientPage.newFrameForCreatePartFrame), "", 0);
        reusableUtilities.switchFrame($(ParametersToIngredientPage.newFrameForPartAddition), "", 0);
        $(By.xpath("//td[text()='0.000']")).click();
        reusableUtilities.pressBackspace();
        reusableUtilities.pressBackspace();
        reusableUtilities.pressBackspace();
        reusableUtilities.pressBackspace();
        reusableUtilities.pressBackspace();
        $(Serenity.getDriver().switchTo().activeElement()).typeAndTab(String.valueOf(totalQuantityInInt));
    }
    public void userPutsTargetValueAs(String targetValue){
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(ParametersToIngredientPage.newFrameForCreatePartFrame), "", 0);
        reusableUtilities.switchFrame($(ParametersToIngredientPage.newFrameForPartAddition), "", 0);
        $(By.xpath("//td[text()='"+String.valueOf(totalQuantityInInt).trim()+".000']")).click();
        reusableUtilities.pressBackspace();
        reusableUtilities.pressBackspace();
        reusableUtilities.pressBackspace();
        reusableUtilities.pressBackspace();
        reusableUtilities.pressBackspace();
        $(Serenity.getDriver().switchTo().activeElement()).typeAndTab(targetValue);
    }
    public void quantityOfQuantumSatisCheckedPartShouldBe(String quantity){
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(PartPage.newFrameForCreatePartFrame), "", 0);
        reusableUtilities.conditionalWait("visibility", RecipeInstructionPage.newFrameInBOM, "");
        reusableUtilities.switchFrame($(RecipeInstructionPage.newFrameInBOM), "", 0);
        $(QuantitySumPage.secondQuantityField).click();
        if($(QuantitySumPage.secondQuantityField).getText().equalsIgnoreCase(quantity)){
            Assert.assertTrue(true);
        }
        else{
            Assert.fail();
        }
    }
    public void summationOfQuantityOfTheAddedPartsShouldBe(String totalQuantity) {
        waitABit(2000);
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(PartPage.newFrameForCreatePartFrame), "", 0);
        reusableUtilities.conditionalWait("visibility", RecipeInstructionPage.newFrameInBOM, "");
        reusableUtilities.switchFrame($(RecipeInstructionPage.newFrameInBOM), "", 0);
        if($(QuantitySumPage.totalQuantityField).getAttribute("value").equalsIgnoreCase(totalQuantity)){
            Assert.assertTrue(true);
        }
        else{
            Assert.fail();
        }
    }
    public void userChangesTargetValueAs(String targetValue){
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(ParametersToIngredientPage.newFrameForCreatePartFrame), "", 0);
        reusableUtilities.switchFrame($(ParametersToIngredientPage.newFrameForPartAddition), "", 0);
        reusableUtilities.performAction("", $(ParametersToIngredientPage.searchResults), "");
        for(int i = 1; i <= 15; i++) {
            reusableUtilities.pressTab();
            waitABit(500);
        }
        reusableUtilities.pressBackspace();
        reusableUtilities.pressBackspace();
        reusableUtilities.pressBackspace();
        reusableUtilities.pressBackspace();
        reusableUtilities.pressBackspace();
        $(Serenity.getDriver().switchTo().activeElement()).typeAndTab(targetValue);
    }
}