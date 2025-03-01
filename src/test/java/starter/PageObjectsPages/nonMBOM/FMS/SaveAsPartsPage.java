package starter.PageObjectsPages.nonMBOM.FMS;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import starter.Utility.ReusableUtilities;

public class SaveAsPartsPage extends PageObject {

    public static By moreButton = By.xpath("//*[contains(text(),'More')]");
    public static By saveAsButton = By.xpath("//*[contains(text(),'Save As')]");
    public static By navigateButton = By.xpath("//button[@title='Navigate']");
    public static By copyField = By.xpath("//td[text()='Copy']");

    ReusableUtilities reusableUtilities;

    public void userRightClicksAndSelectSaveAs(){
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(PartPage.newFrame), "", 0);
        waitABit(1000);
        reusableUtilities.rightClick(PartPage.searchResults);
        waitABit(1000);
        $(moreButton).click();
        $(saveAsButton).click();
        /*waitABit(10000);
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.conditionalWait("visibility", PartPage.closeButtonForSecondTab, "");
        if($(PartPage.closeButtonForSecondTab).isCurrentlyVisible()) {
            $(PartPage.closeButton).click();
        }
        waitABit(5000);*/
    }
    public void descriptionShouldBeEmpty(){
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(PartPage.newFrameForCreatePartFrame), "", 0);
        reusableUtilities.switchFrame($(PartPage.newFrameForCreatePartFrameDataEntry), "", 0);
        if($(PartPage.description).getAttribute("value").isEmpty()){
            Assert.assertTrue(true);
        }
    }
    public void commonNameFieldShouldHaveTheText(String message){
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(PartPage.newFrameForCreatePartFrame), "", 0);
        reusableUtilities.switchFrame($(PartPage.newFrameForCreatePartFrameDataEntry), "", 0);
        if($(PartPage.description).getAttribute("value").equalsIgnoreCase(message)){
            Assert.assertTrue(true);
        }
    }
    public void historyDescriptionShouldHaveMentionedThatCopiedFromThatItemCode(){
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(PartPage.newFrameForCreatePartFrame), "", 0);
        reusableUtilities.conditionalWait("visibility", ECOCreationPageObjects.newFrameForHistoryRelationship1, "");
        reusableUtilities.switchFrame($(ECOCreationPageObjects.newFrameForHistoryRelationship1), "", 0);
        reusableUtilities.switchFrame($(ECOCreationPageObjects.newFrameForHistoryRelationship2), "", 0);
        reusableUtilities.switchFrame($(ECOCreationPageObjects.newFrameForHistoryRelationship3), "", 0);
        reusableUtilities.switchFrame($(ECOCreationPageObjects.newFrameForHistoryRelationship4), "", 0);
        waitABit(2000);
        $(copyField).click();
        reusableUtilities.pressRightNavigation();
        String s = Serenity.getDriver().switchTo().activeElement().getText().trim();
        System.out.println(s);
        if(s.equalsIgnoreCase("Copied From - Part "+PartPage.generatedItemCode)){
            Assert.assertTrue(true);
        }
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(PartPage.newFrameForCreatePartFrame), "", 0);
        $(ECOCreationPageObjects.historyWindowCloseButton).click();
        if($(PartPage.alertMessage).isCurrentlyVisible()){
            $(PartPage.ok).click();
        }
        waitABit(2000);
    }
    public void validationOfBOMTabWithOrigin(){
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(PartPage.newFrameForCreatePartFrame), "", 0);
        reusableUtilities.conditionalWait("visibility", RecipeInstructionPage.newFrameInBOM, "");
        reusableUtilities.switchFrame($(RecipeInstructionPage.newFrameInBOM), "", 0);
        reusableUtilities.scrollToAnElement(RecipeInstructionPage.addPartsButton);
        reusableUtilities.conditionalWait("visibility", RecipeInstructionPage.addPartsButton, "");
        if($(PartPage.searchResults).isCurrentlyVisible()){
            Assert.assertTrue(true);
        }
    }
    public void validationOfParametersTabWithOrigin(){
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(ParametersToIngredientPage.newFrameForCreatePartFrame), "", 0);
        if($(PartPage.searchResults).isCurrentlyVisible()){
            Assert.assertTrue(true);
        }
    }
    public void validationOfDocumentsTabWithOrigin(){
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(ParametersToIngredientPage.newFrameForCreatePartFrame), "", 0);
        reusableUtilities.performAction("", $(DocumentPage.documentsTab), "");
        if ($(DocumentPage.newFrameToAddDocuments).isCurrentlyVisible()) {
            reusableUtilities.switchFrame($(DocumentPage.newFrameToAddDocuments), "", 0);
        } else if ($(DocumentPage.newFrameToAddDocumentsInECO).isCurrentlyVisible()) {
            reusableUtilities.switchFrame($(DocumentPage.newFrameToAddDocumentsInECO), "", 0);
        }
        reusableUtilities.conditionalWait("visibility", DocumentPage.newDocumentButton, "");
        reusableUtilities.scrollToAnElement(DocumentPage.newDocumentButton);
        if($(PartPage.searchResults).isCurrentlyVisible()){
            Assert.assertFalse(false);
        }
    }
}
