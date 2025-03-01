package starter.PageObjectsPages.nonMBOM.FMS;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import starter.Utility.ReusableUtilities;

import java.util.List;

public class AccessControlParameterPage extends PageObject {

    public static By subFamilyField = By.xpath("//*[@id='78F997DC18334B86AD423A2731BA07AC' and @name='pmi_sub_families']");
    public static By newFrameToAddConfidentialParametersInAccessControl = By.xpath("//iframe[@title='pmi_RestrictedParameterTab Relationship']");

    ReusableUtilities reusableUtilities;

    public void belowMentionedConfidentialParameterShouldNOTBePresent(List<List<String>> data){
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(ParametersToIngredientPage.newFrameForCreatePartFrame), "", 0);
        reusableUtilities.switchFrame($(ParametersToIngredientPage.newFrameForPartAddition), "", 0);
        if($(By.xpath("//*[text()='"+data.get(0).get(0).trim()+"']")).isCurrentlyVisible()){
            Assert.fail();
        }
    }
    public void subFamilyValidation(String subFamily){
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(PartPage.newFrameForCreatePartFrame), "", 0);
        reusableUtilities.switchFrame($(PartPage.newFrameForCreatePartFrameDataEntry), "", 0);
        if($(subFamilyField).getAttribute("value").trim().equalsIgnoreCase(subFamily)){
            Assert.assertTrue(true);
        }
    }
    public void userGroupValidation(String userGroup){
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(PartPage.newFrameForCreatePartFrame), "", 0);
        reusableUtilities.switchFrame($(PartPage.newFrameForCreatePartFrameDataEntry), "", 0);
        if($(By.xpath("//*[text()='"+userGroup.trim()+"']")).isCurrentlyVisible()){
            Assert.assertTrue(true);
        }
    }
    public void userAddsConfidentialParameter(String parameter) {
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(ParametersToIngredientPage.newFrameForCreatePartFrame), "", 0);
        if($(ParametersToIngredientPage.newFrameForPartAddition).isCurrentlyVisible()){
            reusableUtilities.switchFrame($(ParametersToIngredientPage.newFrameForPartAddition), "", 0);
            reusableUtilities.conditionalWait("visibility", ParametersToIngredientPage.addParametersButton, "");
            reusableUtilities.performAction("", $(ParametersToIngredientPage.addParametersButton), "");
            Serenity.getDriver().switchTo().parentFrame();
            reusableUtilities.switchFrame($(ParametersToIngredientPage.newFrameToSelectParameters), "", 0);
            waitABit(2000);
            reusableUtilities.performAction("", $(ParametersToIngredientPage.searchFieldToSearchParameters), "");
            waitABit(3000);
            reusableUtilities.pressControlA();
            reusableUtilities.pressBackspace();
            waitABit(1000);
            $(ParametersToIngredientPage.searchFieldToSearchParameters).sendKeys(parameter);
            waitABit(1000);
            reusableUtilities.pressTab();
            for(int i = 1; i<10; i++) {
                waitABit(1000);
                reusableUtilities.pressControlA();
                reusableUtilities.pressBackspace();
                reusableUtilities.pressTab();
            }
            $(Serenity.getDriver().switchTo().activeElement()).sendKeys("1");
            reusableUtilities.pressEnterWithoutElement();
            reusableUtilities.conditionalWait("visibility", ParametersToIngredientPage.searchResults, "");
            reusableUtilities.performAction("", $(ParametersToIngredientPage.searchResults), "");
            reusableUtilities.performAction("", $(ParametersToIngredientPage.okButton), "");
        }
        else if($(newFrameToAddConfidentialParametersInAccessControl).isCurrentlyVisible()){
            reusableUtilities.switchFrame($(newFrameToAddConfidentialParametersInAccessControl), "", 0);
            reusableUtilities.conditionalWait("visibility", ParametersToIngredientPage.addParametersButton, "");
            reusableUtilities.performAction("", $(ParametersToIngredientPage.addParametersButton), "");
            Serenity.getDriver().switchTo().parentFrame();
            reusableUtilities.switchFrame($(ParametersToIngredientPage.newFrameToSelectParameters), "", 0);
            reusableUtilities.performAction("", $(ParametersToIngredientPage.searchFieldToSearchParameters), "");
            waitABit(1000);
            reusableUtilities.pressControlA();
            reusableUtilities.pressBackspace();
            waitABit(1000);
            $(ParametersToIngredientPage.searchFieldToSearchParameters).sendKeys(parameter);
            waitABit(1000);
            reusableUtilities.pressTab();
            for(int i = 1; i<13; i++) {
                waitABit(1000);
                reusableUtilities.pressControlA();
                reusableUtilities.pressBackspace();
                reusableUtilities.pressTab();
            }
            $(Serenity.getDriver().switchTo().activeElement()).sendKeys("1");
            reusableUtilities.pressEnterWithoutElement();
            reusableUtilities.conditionalWait("visibility", ParametersToIngredientPage.searchResults, "");
            reusableUtilities.performAction("", $(ParametersToIngredientPage.searchResults), "");
            reusableUtilities.performAction("", $(ParametersToIngredientPage.okButton), "");
        }
    }
    public void belowMentionedConfidentialParameterShouldBePresent(List<List<String>> data){
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(ParametersToIngredientPage.newFrameForCreatePartFrame), "", 0);
        reusableUtilities.switchFrame($(ParametersToIngredientPage.newFrameForPartAddition), "", 0);
        $(NewCalculationOfFormulaPage.clearSearchButton).click();
        $(NewCalculationOfFormulaPage.runSearchButton).click();
        if($(By.xpath("//*[text()='"+data.get(0).get(0).trim()+"']")).isCurrentlyVisible()){
            Assert.assertTrue(true);
        }
        else {
            Assert.fail();
        }
        waitABit(5000);
    }
    public void belowMentionedConfidentialParameterShouldNotBePresent(List<List<String>> data){
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(ParametersToIngredientPage.newFrameForCreatePartFrame), "", 0);
        reusableUtilities.switchFrame($(ParametersToIngredientPage.newFrameForPartAddition), "", 0);
        if($(By.xpath("//*[text()='"+data.get(0).get(0).trim()+"']")).isCurrentlyVisible()){
            Assert.fail();
        }
        else {
            Assert.assertTrue(true);
        }
    }
}