package starter.PageObjectsPages.nonMBOM.FMS;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import starter.Utility.ReusableUtilities;

public class QuantitySumPage extends PageObject {

    public static By secondSearchResults = By.xpath("//tr[@class='aras-grid-row' and @data-index='1']//td[@class='aras-grid-row-cell ']");
    public static By secondQuantityField = By.xpath("//*[@id='gridTD']/div[2]/div[2]/div/table/tr[2]/td[8]");
    public static By totalQuantityField = By.xpath("//*[@id='relationship-toolbars']/aras-toolbar[2]/div/span[4]/input");

    ReusableUtilities reusableUtilities;
    BOMTabValidationPage bomTabValidationPage;

    double firstPartQuantity;
    double secondPartQuantity;

    public void userAddsPartInBOMTabAndUpdateQuantity(String quantity){
        firstPartQuantity = Double.parseDouble(quantity);
        bomTabValidationPage.userAddsPartInBOMTab();
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
    public void userAddsSecondPartInBOMTabAndUpdateQuantity(String quantity){
        secondPartQuantity = Double.parseDouble(quantity);
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
        waitABit(1000);
        $(ParameterTemplatePage.clearSearchField).click();
        waitABit(1000);
        reusableUtilities.conditionalWait("visibility", RecipeInstructionPage.itemCodeField, "");
        $(RecipeInstructionPage.itemCodeField).click();
        reusableUtilities.pressBackspace();
        reusableUtilities.pressBackspace();
        reusableUtilities.pressBackspace();
        reusableUtilities.pressBackspace();
        reusableUtilities.pressBackspace();
        reusableUtilities.pressBackspace();
        reusableUtilities.pressBackspace();
        waitABit(1000);
        $(RecipeInstructionPage.itemTypeField).click();
        $(Serenity.getDriver().switchTo().activeElement()).typeAndEnter("Ingredient - ING");
        reusableUtilities.pressEnter(RecipeInstructionPage.itemTypeField);
        reusableUtilities.conditionalWait("visibility", secondSearchResults, "");
        $(secondSearchResults).click();
        $(PartPage.ok).click();
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(PartPage.newFrameForCreatePartFrame), "", 0);
        reusableUtilities.conditionalWait("visibility", RecipeInstructionPage.newFrameInBOM, "");
        reusableUtilities.switchFrame($(RecipeInstructionPage.newFrameInBOM), "", 0);
        waitABit(1000);
        $(secondQuantityField).click();
        waitABit(1000);
        $(Serenity.getDriver().switchTo().activeElement()).typeAndTab(quantity);
    }
    public void validateTotalQuantityField(){
        waitABit(2000);
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(PartPage.newFrameForCreatePartFrame), "", 0);
        reusableUtilities.conditionalWait("visibility", RecipeInstructionPage.newFrameInBOM, "");
        reusableUtilities.switchFrame($(RecipeInstructionPage.newFrameInBOM), "", 0);
        String totalQuantityInString = $(totalQuantityField).getAttribute("value");
        int totalQuantityInInt = Integer.parseInt(totalQuantityInString);
        if(totalQuantityInInt == firstPartQuantity + secondPartQuantity){
            Assert.assertTrue(true);
        }
        else {
            Assert.fail();
        }
    }
    public void userUpdatesQuantityFieldForSecondPartInBOM(){
        secondPartQuantity = 5;
        waitABit(2000);
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(PartPage.newFrameForCreatePartFrame), "", 0);
        reusableUtilities.conditionalWait("visibility", RecipeInstructionPage.newFrameInBOM, "");
        reusableUtilities.switchFrame($(RecipeInstructionPage.newFrameInBOM), "", 0);
        $(secondQuantityField).click();
        reusableUtilities.pressBackspace();
        reusableUtilities.pressBackspace();
        reusableUtilities.pressBackspace();
        $(Serenity.getDriver().switchTo().activeElement()).typeAndTab(String.valueOf(secondPartQuantity));
    }
    public void userTriesToEditQuantitySumField(){
        waitABit(2000);
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(PartPage.newFrameForCreatePartFrame), "", 0);
        reusableUtilities.conditionalWait("visibility", RecipeInstructionPage.newFrameInBOM, "");
        reusableUtilities.switchFrame($(RecipeInstructionPage.newFrameInBOM), "", 0);
        if($(totalQuantityField).isCurrentlyEnabled()){
            Assert.assertFalse(false);
        }
    }
    public void validateDecimalInQuantitySumField(String quantity){
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(PartPage.newFrameForCreatePartFrame), "", 0);
        reusableUtilities.conditionalWait("visibility", RecipeInstructionPage.newFrameInBOM, "");
        reusableUtilities.switchFrame($(RecipeInstructionPage.newFrameInBOM), "", 0);
        waitABit(2000);
        reusableUtilities.pressShiftTab();
        System.out.println("Print "+reusableUtilities.getObjectProperty($(Serenity.getDriver().switchTo().activeElement()), "value"));
        if(reusableUtilities.getObjectProperty($(Serenity.getDriver().switchTo().activeElement()), "value").equalsIgnoreCase(quantity)){
            Assert.assertTrue(true);
        }
        else {
            Assert.fail();
        }
    }
}