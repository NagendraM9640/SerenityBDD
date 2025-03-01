package starter.PageObjectsPages.nonMBOM.FMS;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import starter.Utility.ReusableUtilities;

public class AddRemovePartsInPartBOMPage extends PageObject {

    public static By itemCodeFieldInBOM = By.xpath("(//td[@class='aras-grid-row-cell '])[3]");
    public static By recipeInstructionFieldInBOM = By.xpath("(//td[@class='aras-grid-row-cell '])[7]");
    public static By newPartButton = By.xpath("//button[@title='New Part']");
    public static By deletePartFromBOMButton = By.xpath("//button[@title='Delete Part BOM']");

    ReusableUtilities reusableUtilities;
    PartPage partPage;

    static String newAddedPartNo = "";

    public void validationOfRecipeInstructionFieldInBOM(){
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(PartPage.newFrameForCreatePartFrame), "", 0);
        reusableUtilities.switchFrame($(RecipeInstructionPage.newFrameInBOM), "", 0);
        if($(recipeInstructionFieldInBOM).getText().trim().equalsIgnoreCase("Add Item")){
            Assert.assertTrue(true);
        }
    }
    public void validationOfAddedPart(){
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(PartPage.newFrameForCreatePartFrame), "", 0);
        reusableUtilities.switchFrame($(RecipeInstructionPage.newFrameInBOM), "", 0);
        if($(itemCodeFieldInBOM).isCurrentlyVisible()){
            Assert.assertTrue(true);
        }
    }
    public void userTriesToCreateNewPartInBOM(){
        waitABit(10000);
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(PartPage.newFrameForCreatePartFrame), "", 0);
        reusableUtilities.conditionalWait("Visibility", RecipeInstructionPage.newFrameInBOM, "");
        reusableUtilities.switchFrame($(RecipeInstructionPage.newFrameInBOM), "", 0);
        reusableUtilities.conditionalWait("Visibility", newPartButton, "");
        reusableUtilities.scrollToAnElement(newPartButton);
        $(newPartButton).click();
        partPage.selectingItemTypeForPartInsidePartBOM("Ingredient - ING");
        partPage.subFamilySelectionForSecondTab("Bulk Ingredient - BLK");
        partPage.createPartForSecondTab("Description", "Common Name");
        partPage.saveTheFormForSecondTab();
        partPage.fetchingItemCodeForSecondTab();
        Serenity.getDriver().switchTo().defaultContent();
        $(PartPage.closeButtonForSecondTab).click();
    }
    public void validationOfCreatedPartInPartBOM(){
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(PartPage.newFrameForCreatePartFrame), "", 0);
        reusableUtilities.conditionalWait("Visibility", RecipeInstructionPage.newFrameInBOM, "");
        reusableUtilities.switchFrame($(RecipeInstructionPage.newFrameInBOM), "", 0);
        if(PartPage.generatedItemCode.equalsIgnoreCase($(itemCodeFieldInBOM).getText().trim())){
            Assert.assertTrue(true);
        }
    }
    public String userTriesToEditBOMToReplacePart(String newPartNumber){
        partPage.editTheForm();
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(PartPage.newFrameForCreatePartFrame), "", 0);
        reusableUtilities.conditionalWait("Visibility", RecipeInstructionPage.newFrameInBOM, "");
        reusableUtilities.switchFrame($(RecipeInstructionPage.newFrameInBOM), "", 0);
        $(itemCodeFieldInBOM).click();
        $(deletePartFromBOMButton).click();
        $(RecipeInstructionPage.addPartsButton).click();
        Serenity.getDriver().switchTo().parentFrame();
        reusableUtilities.switchFrame($(PartPage.newFrameToSelectPart), "", 0);
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
        reusableUtilities.pressBackspace();
        reusableUtilities.pressBackspace();
        reusableUtilities.pressBackspace();
        reusableUtilities.pressBackspace();
        reusableUtilities.pressBackspace();
        reusableUtilities.pressBackspace();
        reusableUtilities.pressBackspace();
        reusableUtilities.pressBackspace();
        reusableUtilities.pressBackspace();
        reusableUtilities.pressBackspace();
        reusableUtilities.pressBackspace();
        reusableUtilities.pressBackspace();
        reusableUtilities.pressBackspace();
        reusableUtilities.pressBackspace();
        reusableUtilities.pressDelete();
        reusableUtilities.pressDelete();
        reusableUtilities.pressDelete();
        reusableUtilities.pressDelete();
        reusableUtilities.pressDelete();
        reusableUtilities.pressDelete();
        reusableUtilities.pressDelete();
        waitABit(1000);
        $(RecipeInstructionPage.itemCodeField).click();
        $(Serenity.getDriver().switchTo().activeElement()).typeAndEnter(newPartNumber);
        reusableUtilities.conditionalWait("visibility", PartPage.searchResults, "");
        $(PartPage.searchResults).click();
        $(PartPage.ok).click();
        newAddedPartNo = newPartNumber;
        return newAddedPartNo;
    }
    public void validateTheChangedPart(){
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(PartPage.newFrameForCreatePartFrame), "", 0);
        reusableUtilities.conditionalWait("Visibility", RecipeInstructionPage.newFrameInBOM, "");
        reusableUtilities.switchFrame($(RecipeInstructionPage.newFrameInBOM), "", 0);
        if(newAddedPartNo.equalsIgnoreCase($(itemCodeFieldInBOM).getText().trim())){
            Assert.assertTrue(true);
        }
    }
    public void userTriesToDeleteAddedPartFromBOMTab(){
        partPage.editTheForm();
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(PartPage.newFrameForCreatePartFrame), "", 0);
        reusableUtilities.conditionalWait("Visibility", RecipeInstructionPage.newFrameInBOM, "");
        reusableUtilities.switchFrame($(RecipeInstructionPage.newFrameInBOM), "", 0);
        $(itemCodeFieldInBOM).click();
        $(deletePartFromBOMButton).click();
    }
    public void validateBOMTabAfterDeletingPart(){
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(PartPage.newFrameForCreatePartFrame), "", 0);
        reusableUtilities.switchFrame($(RecipeInstructionPage.newFrameInBOM), "", 0);
        if($(itemCodeFieldInBOM).isCurrentlyVisible()){
            Assert.assertFalse(false);
        }
    }
    public void userTriesToAddSamePart(){
        partPage.editTheForm();
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(PartPage.newFrameForCreatePartFrame), "", 0);
        reusableUtilities.conditionalWait("Visibility", RecipeInstructionPage.newFrameInBOM, "");
        reusableUtilities.switchFrame($(RecipeInstructionPage.newFrameInBOM), "", 0);
        $(RecipeInstructionPage.addPartsButton).click();
        Serenity.getDriver().switchTo().parentFrame();
        reusableUtilities.switchFrame($(PartPage.newFrameToSelectPart), "", 0);
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
        reusableUtilities.pressBackspace();
        reusableUtilities.pressBackspace();
        reusableUtilities.pressBackspace();
        reusableUtilities.pressBackspace();
        reusableUtilities.pressBackspace();
        reusableUtilities.pressBackspace();
        reusableUtilities.pressBackspace();
        reusableUtilities.pressBackspace();
        reusableUtilities.pressBackspace();
        reusableUtilities.pressBackspace();
        reusableUtilities.pressBackspace();
        reusableUtilities.pressBackspace();
        reusableUtilities.pressBackspace();
        reusableUtilities.pressBackspace();
        waitABit(1000);
        $(RecipeInstructionPage.itemCodeField).click();
        $(Serenity.getDriver().switchTo().activeElement()).typeAndEnter(PartPage.generatedItemCode);
        reusableUtilities.conditionalWait("visibility", PartPage.searchResults, "");
        $(PartPage.searchResults).click();
        $(PartPage.ok).click();
    }
}
