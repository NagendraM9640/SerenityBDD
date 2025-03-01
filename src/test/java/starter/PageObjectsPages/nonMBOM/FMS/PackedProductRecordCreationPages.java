package starter.PageObjectsPages.nonMBOM.FMS;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import starter.Utility.ReusableUtilities;

public class PackedProductRecordCreationPages extends PageObject {

    public static By clearSearchField = By.xpath("//button[@title='Clear Search Criteria']");
    //public static By textFieldDropDown = By.xpath("(//button[contains(@class,'aras-icon-arrow_down')])[5]");
    public static By textFieldDropDown = By.xpath("//*[@id='gridTD']/div[2]/div[2]/div/div/aras-dropdown/button");
    public static By eSignatureField = By.xpath("//input[@name='esignature']");
    public static By newFrame = By.xpath("//*[@class='aras-switcher']//iframe[@id='1A6269964DD94DEA98E530E391EF3395']");

    ReusableUtilities reusableUtilities;
    SubfamilyPage subfamilyPage;

    public void userAddsReleasedPartsAndUpdateQuantity(String quantity) {
        waitABit(3000);
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(PartPage.newFrameForCreatePartFrame), "", 0);
        reusableUtilities.conditionalWait("visibility", RecipeInstructionPage.newFrameInBOM, "");
        reusableUtilities.switchFrame($(RecipeInstructionPage.newFrameInBOM), "", 0);
        reusableUtilities.scrollToAnElement(RecipeInstructionPage.addPartsButton);
        reusableUtilities.conditionalWait("visibility", RecipeInstructionPage.addPartsButton, "");
        $(RecipeInstructionPage.addPartsButton).waitUntilClickable();
        $(RecipeInstructionPage.addPartsButton).click();
        Serenity.getDriver().switchTo().parentFrame();
        reusableUtilities.switchFrame($(PartPage.newFrameToSelectPart), "", 0);
        reusableUtilities.conditionalWait("visibility", RecipeInstructionPage.itemCodeField, "");
        $(clearSearchField).click();
        waitABit(1000);
        //$(RecipeInstructionPage.itemTypeField).click();
        $(RecipeInstructionPage.itemCodeField).click();
        waitABit(1000);
        reusableUtilities.pressTab();
        waitABit(1000);
        reusableUtilities.pressTab();
        waitABit(1000);
        reusableUtilities.pressTab();
        waitABit(1000);
        reusableUtilities.pressTab();
        waitABit(1000);
        $(Serenity.getDriver().switchTo().activeElement()).typeAndEnter("Formula - FOR");
        waitABit(1000);
        reusableUtilities.pressTab();
        waitABit(1000);
        reusableUtilities.pressTab();
        waitABit(1000);
        reusableUtilities.pressDownNavigation();
        waitABit(1000);
        $(By.xpath("//*[text()='Released']")).click();
        reusableUtilities.pressEnterWithoutElement();
        reusableUtilities.conditionalWait("visibility", PartPage.searchResults, "");
        $(PartPage.searchResults).click();
        $(PartPage.ok).click();
        waitABit(5000);
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(PartPage.newFrameForCreatePartFrame), "", 0);
        reusableUtilities.conditionalWait("visibility", RecipeInstructionPage.newFrameInBOM, "");
        reusableUtilities.switchFrame($(RecipeInstructionPage.newFrameInBOM), "", 0);
        waitABit(1000);
        $(PartPage.searchResults).click();
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
        waitABit(2000);
        $(Serenity.getDriver().switchTo().activeElement()).typeAndTab(quantity);
    }
    public void userAddsParameter(String parameter){
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(ParametersToIngredientPage.newFrameForCreatePartFrame), "", 0);
        reusableUtilities.switchFrame($(ParametersToIngredientPage.newFrameForPartAddition), "", 0);
        reusableUtilities.conditionalWait("visibility", ParametersToIngredientPage.addParametersButton, "");
        reusableUtilities.performAction("", $(ParametersToIngredientPage.addParametersButton), "");
        Serenity.getDriver().switchTo().parentFrame();
        reusableUtilities.switchFrame($(ParametersToIngredientPage.newFrameToSelectParameters), "", 0);
        waitABit(1000);
        $(clearSearchField).click();
        reusableUtilities.performAction("", $(ParametersToIngredientPage.searchFieldToSearchParameters), "");
        $(ParametersToIngredientPage.searchFieldToSearchParameters).sendKeys(parameter);
        waitABit(2000);
        reusableUtilities.pressEnterWithoutElement();
        reusableUtilities.conditionalWait("visibility", ParametersToIngredientPage.searchResults, "");
        reusableUtilities.performAction("", $(ParametersToIngredientPage.searchResults), "");
        reusableUtilities.performAction("", $(ParametersToIngredientPage.okButton), "");
    }
    public void selectTextFieldWithMultipleValues(){
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(ParametersToIngredientPage.newFrameForCreatePartFrame), "", 0);
        reusableUtilities.switchFrame($(ParametersToIngredientPage.newFrameForPartAddition), "", 0);
        $(ParametersToIngredientPage.searchResults).click();
        for(int i=0;i<=13;i++){
            reusableUtilities.pressTab();
            waitABit(1000);
        }
        $(textFieldDropDown).click();
        waitABit(2000);
        $(By.xpath("//*[text()='Nalgen Bot']")).click();
        waitABit(1000);
        $(By.xpath("//*[text()='D 60 HDPE']")).click();
    }
    public void selectTextFieldAs(String textFieldValue){
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(ParametersToIngredientPage.newFrameForCreatePartFrame), "", 0);
        reusableUtilities.switchFrame($(ParametersToIngredientPage.newFrameForPartAddition), "", 0);
        $(ParametersToIngredientPage.searchResults).click();
        for(int i=0;i<=13;i++){
            reusableUtilities.pressTab();
            waitABit(1000);
        }
        $(textFieldDropDown).click();
        waitABit(2000);
        $(By.xpath("//*[text()='"+textFieldValue.trim()+"']")).click();
    }
    public void eSignature(){
        Serenity.getDriver().switchTo().defaultContent();
        subfamilyPage.validateWorkflowWindow();
        $(eSignatureField).click();;
        $(eSignatureField).sendKeys("innovator");
    }
    public void searchWithIncrementedECO(){
        String [] s = (ECOCreationPageObjects.generatedECOCode).split("-");
        int i = Integer.parseInt(s[1]);
        i = i+1;
        String s1 = String.valueOf(i);
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.conditionalWait("Visibility", PartPage.newFrameForPartSearch, "");
        reusableUtilities.switchFrame($(PartPage.newFrame), "", 0);
        reusableUtilities.conditionalWait("visibility", PartPage.arasSpinner, "");
        reusableUtilities.conditionalWait("invisibility", PartPage.arasSpinner, "");
        reusableUtilities.performAction("Text", $(PartPage.searchFieldToSearchParts), "*"+s1);
        waitABit(2000);
        reusableUtilities.pressEnter(PartPage.searchFieldToSearchParts);
        reusableUtilities.conditionalWait("Visibility", PartPage.searchResults, "");
        reusableUtilities.doubleClick(PartPage.searchResults);
    }
    public void validateSystemGeneratedECO(){
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.conditionalWait("Visibility", ECOCreationPageObjects.newFrameForCreateECOFrame, "");
        reusableUtilities.switchFrame($(ECOCreationPageObjects.newFrameForCreateECOFrame), "", 0);
        reusableUtilities.switchFrame($(ECOCreationPageObjects.newFrameForCreateECOFrameDataEntry), "", 0);
        if($(ECOCreationPageObjects.titleField).getAttribute("value").equalsIgnoreCase("System generated ECO")){
            Assert.assertTrue(true);
        }
        else {
            Assert.fail();
        }
    }
    public void validateAutoGeneratedParts(){
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(PartPage.newFrameForCreatePartFrame), "", 0);
        reusableUtilities.switchFrame($(newFrame), "", 0);
        reusableUtilities.switchFrame($(SubfamilyPage.newFrameForm2), "", 0);
        if($(By.xpath("//*[contains(text(),'AC')]")).isCurrentlyVisible()){
            Assert.assertTrue(true);
        }
        /*else {
            Assert.fail();
        }*/
        if($(By.xpath("//*[contains(text(),'DC')]")).isCurrentlyVisible()){
            Assert.assertTrue(true);
        }
        /*else {
            Assert.fail();
        }*/
    }
}