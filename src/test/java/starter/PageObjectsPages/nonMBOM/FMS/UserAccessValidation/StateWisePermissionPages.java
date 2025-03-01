package starter.PageObjectsPages.nonMBOM.FMS.UserAccessValidation;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import starter.PageObjectsPages.nonMBOM.FMS.PartPage;
import starter.Utility.ReusableUtilities;

public class StateWisePermissionPages extends PageObject {

    public static By clearSearchArea = By.xpath("//button[@title='Clear Search Criteria']");
    public static By stateFieldOfList = By.xpath("(//td[@class='aras-grid-search-row-cell '])[5]");
    public static By stateFieldOfGHPECO = By.xpath("(//td[@class='aras-grid-search-row-cell '])[4]");
    public static By stateFieldOfSample = By.xpath("(//td[@class='aras-grid-search-row-cell '])[3]");
    public static By lifecycleField = By.xpath("//td[@class='aras-grid-search-row-cell ' and @data-head-id='pmi_lifecycle_D']");
    public static By itemTypeField = By.xpath("//td[@class='aras-grid-search-row-cell ' and @data-head-id='classification_D']");
    public static By itemNumberField = By.xpath("//td[@class='aras-grid-search-row-cell ' and @data-head-id='item_number_D']");
    public static By stateFieldOfVendor = By.xpath("//td[@class='aras-grid-search-row-cell ' and @data-head-id='state_D']");

    ReusableUtilities reusableUtilities;

    public void searchPreliminaryStated(String state){
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(PartPage.newFrame), "", 0);
        reusableUtilities.conditionalWait("visibility", PartPage.arasSpinner, "");
        reusableUtilities.conditionalWait("invisibility", PartPage.arasSpinner, "");
        $(stateFieldOfList).waitUntilVisible();
        waitABit(1000);
        $(stateFieldOfList).click();
        waitABit(1000);
        $(Serenity.getDriver().switchTo().activeElement()).typeAndEnter(state.trim());
        waitABit(3000);
    }

    public void searchGHPECO(String state){
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(PartPage.newFrame), "", 0);
        reusableUtilities.conditionalWait("visibility", PartPage.arasSpinner, "");
        reusableUtilities.conditionalWait("invisibility", PartPage.arasSpinner, "");
        $(clearSearchArea).waitUntilVisible();
        waitABit(1000);
        $(clearSearchArea).click();
        waitABit(1000);
        $(stateFieldOfGHPECO).waitUntilVisible();
        waitABit(1000);
        $(stateFieldOfGHPECO).click();
        waitABit(1000);
        $(Serenity.getDriver().switchTo().activeElement()).typeAndEnter(state.trim());
        waitABit(3000);
    }

    public void searchSample(String state){
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(PartPage.newFrame), "", 0);
        reusableUtilities.conditionalWait("visibility", PartPage.arasSpinner, "");
        reusableUtilities.conditionalWait("invisibility", PartPage.arasSpinner, "");
        $(clearSearchArea).waitUntilVisible();
        waitABit(1000);
        $(clearSearchArea).click();
        waitABit(1000);
        $(stateFieldOfSample).waitUntilVisible();
        waitABit(1000);
        $(stateFieldOfSample).click();
        waitABit(1000);
        $(Serenity.getDriver().switchTo().activeElement()).typeAndEnter(state.trim());
        waitABit(3000);
    }

    public void searchPart(String itemType){
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(PartPage.newFrame), "", 0);
        reusableUtilities.conditionalWait("visibility", PartPage.arasSpinner, "");
        reusableUtilities.conditionalWait("invisibility", PartPage.arasSpinner, "");
        $(clearSearchArea).waitUntilVisible();
        waitABit(1000);
        $(clearSearchArea).click();
        waitABit(1000);
        $(itemTypeField).click();
        waitABit(1000);
        $(Serenity.getDriver().switchTo().activeElement()).sendKeys(itemType.trim());
        waitABit(1000);
    }

    public void searchPartWithLifecycleState(String state){
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(PartPage.newFrame), "", 0);
        $(itemTypeField).waitUntilVisible();
        waitABit(1000);
        $(itemTypeField).click();
        waitABit(1000);
        reusableUtilities.pressTab();
        waitABit(1000);
        reusableUtilities.pressTab();
        waitABit(1000);
        $(Serenity.getDriver().switchTo().activeElement()).typeAndEnter(state.trim());
        waitABit(1000);
        reusableUtilities.pressEnterWithoutElement();
        waitABit(2000);
    }

    public void searchGHP(String state){
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(PartPage.newFrame), "", 0);
        reusableUtilities.conditionalWait("visibility", PartPage.arasSpinner, "");
        reusableUtilities.conditionalWait("invisibility", PartPage.arasSpinner, "");
        $(lifecycleField).waitUntilVisible();
        waitABit(1000);
        $(lifecycleField).click();
        waitABit(1000);
        $(Serenity.getDriver().switchTo().activeElement()).typeAndEnter(state.trim());
        waitABit(3000);
    }

    public void searchVendor(String state){
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(PartPage.newFrame), "", 0);
        reusableUtilities.conditionalWait("visibility", PartPage.arasSpinner, "");
        reusableUtilities.conditionalWait("invisibility", PartPage.arasSpinner, "");
        $(stateFieldOfVendor).waitUntilVisible();
        waitABit(1000);
        $(stateFieldOfVendor).click();
        waitABit(1000);
        $(Serenity.getDriver().switchTo().activeElement()).typeAndEnter(state.trim());
        waitABit(3000);
    }

    public void validateSearchResult(){
        reusableUtilities.conditionalWait("Visibility", PartPage.searchResults, "");
        Assert.assertTrue(true);
    }

    public void openingSearchResult(){
        if($(PartPage.secondSearchResults).isCurrentlyVisible()) {
            reusableUtilities.doubleClick(PartPage.secondSearchResults);
        }
        else {
            reusableUtilities.doubleClick(PartPage.searchResults);
        }
    }

    public void tryToDelete(){
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(PartPage.newFrameForCreatePartFrame), "", 0);
        reusableUtilities.performAction("Button", $(PartPage.tripleDots), "");
        waitABit(2000);
        reusableUtilities.performAction("Button", $(PartPage.delete), "");
        waitABit(2000);
        if($(PartPage.deleteAllVersions).isCurrentlyVisible()) {
            reusableUtilities.performAction("Button", $(PartPage.deleteAllVersions), "");
        }
        else if($(PartPage.delete2).isCurrentlyVisible()) {
            reusableUtilities.performAction("Button", $(PartPage.delete2), "");
        }
        waitABit(2000);
        reusableUtilities.performAction("Button", $(PartPage.deletePart), "");
    }

    public void validationOfSuccessfulEditing(){
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(PartPage.newFrameForCreatePartFrame), "", 0);
        if($(PartPage.editButton).isCurrentlyVisible()){
            Assert.fail();
        }
        else {
            Assert.assertTrue(true);
        }
        waitABit(1000);
        $(By.xpath("//*[text()='Discard']")).click();
    }

    public void validationOfSuccessfulDeletion(String s){
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.conditionalWait("Visibility", PartPage.arasSpinner, "");
        reusableUtilities.conditionalWait("Invisibility", PartPage.arasSpinner, "");
        reusableUtilities.conditionalWait("Visibility", PartPage.newFrameForCreatePartFrame, "");
        if($(PartPage.newFrameForCreatePartFrame).isCurrentlyVisible()) {
            Assert.fail();
        }
        else {
            Assert.assertTrue("Batch form has been deleted successfully", true);
        }
    }

    public void searchPartNo(String partNo){
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(PartPage.newFrame), "", 0);
        $(itemNumberField).waitUntilVisible();
        waitABit(1000);
        $(itemNumberField).click();
        waitABit(1000);
        $(Serenity.getDriver().switchTo().activeElement()).typeAndEnter(partNo.trim());
        waitABit(1000);
        reusableUtilities.pressEnterWithoutElement();
        waitABit(2000);
    }
}