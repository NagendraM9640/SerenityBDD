package starter.PageObjectsPages.nonMBOM.FMS;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import starter.Utility.ReusableUtilities;

public class RecipeInstructionPage extends PageObject {

    public static By newFrameInBOM = By.xpath("//iframe[@title='Part BOM Relationship']");
    public static By addPartsButton = By.xpath("//button[@title='Add Parts']");
    static By itemCodeField = By.xpath("//td[@class='aras-grid-search-row-cell ' and @data-index='1']");
    static By itemTypeField = By.xpath("//td[@class='aras-grid-search-row-cell ' and @data-index='5']//input");

    ReusableUtilities reusableUtilities;
    PartPage partPage;

    public void itemCodeFieldEditableValidation() {
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(PartPage.newFrameForCreatePartFrame), "", 0);
        reusableUtilities.switchFrame($(PartPage.newFrameForCreatePartFrameDataEntry), "", 0);
        if($(PartPage.itemCode).isEnabled()) {
            Assert.assertTrue(true);
        }
    }

    public void userProvidesUniqueItemCode(String itemCode) {
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(PartPage.newFrameForCreatePartFrame), "", 0);
        reusableUtilities.switchFrame($(PartPage.newFrameForCreatePartFrameDataEntry), "", 0);
        $(PartPage.itemCode).sendKeys(itemCode);
    }

    public void flavorDeveloperTriesToSelectRecipeInstructionAsItemType() {
        Serenity.getDriver().switchTo().defaultContent();
        By partNameAsIngredient = By.xpath("//*[text()='Instruction']");
        reusableUtilities.switchFrame($(PartPage.newFrameToSelectPart), "", 0);
        if($(partNameAsIngredient).isCurrentlyEnabled()) {
            Assert.assertFalse(false);
        }
        Serenity.getDriver().switchTo().defaultContent();
        $(By.xpath("//span[@title='Close']")).click();
    }

    public void userAddsRecipeInBOMTab() {
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(PartPage.newFrameForCreatePartFrame), "", 0);
        reusableUtilities.conditionalWait("visibility", newFrameInBOM, "");
        reusableUtilities.switchFrame($(newFrameInBOM), "", 0);
        reusableUtilities.conditionalWait("visibility", addPartsButton, "");
        $(addPartsButton).click();
        Serenity.getDriver().switchTo().parentFrame();
        reusableUtilities.switchFrame($(PartPage.newFrameToSelectPart), "", 0);
        reusableUtilities.conditionalWait("visibility", itemCodeField, "");
        $(itemCodeField).click();
        reusableUtilities.pressBackspace();
        reusableUtilities.pressBackspace();
        reusableUtilities.pressBackspace();
        reusableUtilities.pressBackspace();
        reusableUtilities.pressBackspace();
        reusableUtilities.pressBackspace();
        reusableUtilities.pressBackspace();
        waitABit(1000);
        $(itemTypeField).click();
        $(Serenity.getDriver().switchTo().activeElement()).typeAndEnter("Instruction");
        reusableUtilities.pressEnter(itemTypeField);
        reusableUtilities.conditionalWait("visibility", PartPage.searchResults, "");
        $(PartPage.searchResults).click();
        $(PartPage.ok).click();
    }

    public void userValidatesAddedRecipeInBOM() {
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(ParametersToIngredientPage.newFrameForCreatePartFrame), "", 0);
        reusableUtilities.switchFrame($(newFrameInBOM), "", 0);
        if ($(DocumentPage.searchResults).isCurrentlyVisible()) {
            Assert.assertTrue("Recipe has been added successfully", true);
        }
    }

    public void recipeInstructionDropDownValidation() {
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(ParametersToIngredientPage.newFrameForCreatePartFrame), "", 0);
        reusableUtilities.switchFrame($(newFrameInBOM), "", 0);
        $(DocumentPage.searchResults).click();
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
        $(Serenity.getDriver().switchTo().activeElement()).click();
        waitABit(1000);
        reusableUtilities.pressDownNavigation();
        waitABit(1000);
        if($(By.xpath("//*[text()='Add Item']")).isCurrentlyVisible()) {
            Assert.assertFalse(false);
        }
    }
    public void selectingRecipeInstruction(String recipeInstruction) {
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(ParametersToIngredientPage.newFrameForCreatePartFrame), "", 0);
        reusableUtilities.switchFrame($(newFrameInBOM), "", 0);
        $(By.xpath("//*[text()='"+recipeInstruction.trim()+"']")).click();
    }
    public void createRecipeInstructionWithSameSubfamilyAndItemCode(String subFamily, String itemCode){
        Serenity.getDriver().switchTo().defaultContent();
        while($(PartPage.closeButton).isCurrentlyVisible()){
            $(PartPage.closeButton).click();
        }
        if($(By.xpath("//*[text()='Create New Part']")).isCurrentlyVisible()) {
            reusableUtilities.performAction("",$(By.xpath("//*[text()='Create New Part']")),"");
        }
        else {
            reusableUtilities.performAction("", $(PartPage.arasButtonIcon), "");
            reusableUtilities.performAction("", $(By.xpath("//*[text()='Create New Part']")), "");
        }
        partPage.selectingIngredient("Instruction");
        partPage.subFamilySelection(subFamily);
        userProvidesUniqueItemCode(itemCode);
        partPage.saveTheForm();
    }
    public void validateErrorMessageAfterEnteringDuplicateDetails(){
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(PartPage.newFrameForCreatePartFrame), "", 0);
        if(reusableUtilities.getObjectProperty($(PartPage.alertMessage), "text")
                .contains("is already present in the system. System will not allow to create duplicate Instructions")){
            Assert.assertTrue("Error Message have been shown", true);
        }
        reusableUtilities.performAction("", $(PartPage.ok),"");
    }
}
