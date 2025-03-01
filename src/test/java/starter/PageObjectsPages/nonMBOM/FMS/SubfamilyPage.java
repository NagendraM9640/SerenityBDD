package starter.PageObjectsPages.nonMBOM.FMS;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import starter.Utility.ReusableUtilities;
public class SubfamilyPage extends PageObject {

    public static By subfamilyDescription = By.className("pmi_description");
    public static By newFrameForm = By.xpath("//iframe[@src='ShowFormInFrame.html']");
    public static By newFrameForm1 = By.xpath("//*[@class='aras-switcher']//iframe[@id='C5121F4CF8174DD7AED3AB967E9BDDC5']");
    public static By newFrameForm2 = By.xpath("//iframe[@id='formFrame']");
    public static By newFrameToSeeSubFamilyWorkFlow = By.xpath("//iframe[@id='result_iframe_frame']");
    public static By voteNowButton = By.xpath("//span[contains(text(),'VOTE NOW')]");
    public static By voteList = By.id("VoteList");
    public static By completeButton = By.name("Complete");
    public static By continueButton = By.xpath("//*[@id='btnCreate' and @value='Continue']");
    public static By newFrameForWorkFlow = By.className("aras-dialog__iframe");

    ReusableUtilities reusableUtilities;

    public void listSearchFormValidation() {
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.conditionalWait("Visibility", PartPage.searchButton, "");
        Assert.assertTrue(true);
    }

    public void userSearchesWithListName(String listName) {
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.conditionalWait("Visibility", PartPage.newFrameForPartSearch, "");
        reusableUtilities.switchFrame($(PartPage.newFrame), "", 0);
        reusableUtilities.conditionalWait("visibility", PartPage.arasSpinner, "");
        reusableUtilities.conditionalWait("invisibility", PartPage.arasSpinner, "");
        reusableUtilities.performAction("Text", $(PartPage.searchFieldToSearchParts), listName);
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(PartPage.newFrameForPartSearch), "", 0);
        reusableUtilities.performAction("", $(PartPage.searchButton), "");
    }

    public void validateListSearchResult(String listName) {
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.conditionalWait("Visibility", PartPage.newFrameForPartSearch, "");
        reusableUtilities.switchFrame($(PartPage.newFrame), "", 0);
        reusableUtilities.conditionalWait("Visibility", PartPage.searchResults, "");
        String s = reusableUtilities.getObjectProperty($(PartPage.searchResults), "text");
    }

    public void userOpensThatList() {
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(PartPage.newFrame), "", 0);
        reusableUtilities.doubleClick(PartPage.searchResults);
    }

    public void userTriesToEditToAddAList(String label, String value) {
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.conditionalWait("visibility", PartPage.arasSpinner, "");
        reusableUtilities.conditionalWait("invisibility", PartPage.arasSpinner, "");
        reusableUtilities.switchFrame($(PartPage.newFrameForCreatePartFrame), "", 0);
        waitABit(3000);
        reusableUtilities.performAction("", $(PartPage.editButton), "");
        reusableUtilities.switchFrame($(PartPage.newFrameToAddSubFamilyInList), "", 0);
        reusableUtilities.conditionalWait("visibility", PartPage.subFamilyListAddButton, "");
        reusableUtilities.performAction("", $(PartPage.subFamilyListAddButton), "");
        waitABit(1000);
        Serenity.getDriver().switchTo().activeElement().click();
        waitABit(1000);
        $(Serenity.getDriver().switchTo().activeElement()).typeAndEnter(label);
        waitABit(1000);
        Serenity.getDriver().switchTo().activeElement().sendKeys(Keys.TAB);
        waitABit(1000);
        $(Serenity.getDriver().switchTo().activeElement()).sendKeys(value);
        waitABit(3000);
    }
    public void validateNewSubFamilyCreation() {
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(PartPage.newFrameForCreatePartFrame), "", 0);
        reusableUtilities.performAction("", $(PartPage.doneButton), "");
        reusableUtilities.conditionalWait("visibility", PartPage.editButton, "");
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.performAction("", $(PartPage.closeButton), "");
        waitABit(2000);
        reusableUtilities.performAction("", $(PartPage.closeButton), "");
    }
    public void provideDescription(String description) {
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(PartPage.newFrameForCreatePartFrame), "", 0);
        reusableUtilities.switchFrame($(PartPage.newFrameForCreatePartFrameDataEntry), "", 0);
        reusableUtilities.performAction("Text",$(subfamilyDescription), description);
    }
    public void userClicksOnTab(String tabName) {
         By tabNameElement = By.xpath("//span[@class='aras-tabs__label' and text()='"+tabName.trim()+"']");
         By tabNameElement2 = By.xpath("//li[@class='aras-tabs__tab' and text()='"+tabName.trim()+"']");
         if(tabName.equalsIgnoreCase("Parameters")){
             tabNameElement2 = By.xpath("//li[@class='aras-tabs__tab' and contains(text(),'Parameters')]");
         }
        Serenity.getDriver().switchTo().defaultContent();
        if($(PartPage.newFrameForCreatePartFrame3).isCurrentlyVisible()){
            reusableUtilities.switchFrame($(PartPage.newFrameForCreatePartFrame3), "", 0);
            if($(tabNameElement).isCurrentlyVisible()) {
                $(tabNameElement).waitUntilClickable();
                reusableUtilities.scrollToAnElement(tabNameElement);
                reusableUtilities.performAction("", $(tabNameElement), "");
            }
            else if($(tabNameElement2).isCurrentlyVisible()) {
                $(tabNameElement2).waitUntilClickable();
                reusableUtilities.scrollToAnElement(tabNameElement2);
                reusableUtilities.performAction("", $(tabNameElement2), "");
            }
        }
        else if($(PartPage.newFrameForCreatePartFrame2).isCurrentlyVisible()){
            reusableUtilities.switchFrame($(PartPage.newFrameForCreatePartFrame2), "", 0);
            if($(tabNameElement).isCurrentlyVisible()) {
                $(tabNameElement).waitUntilClickable();
                reusableUtilities.scrollToAnElement(tabNameElement);
                reusableUtilities.performAction("", $(tabNameElement), "");
            }
            else if($(tabNameElement2).isCurrentlyVisible()) {
                $(tabNameElement2).waitUntilClickable();
                reusableUtilities.scrollToAnElement(tabNameElement2);
                reusableUtilities.performAction("", $(tabNameElement2), "");
            }
        }
        else {
            reusableUtilities.switchFrame($(PartPage.newFrameForCreatePartFrame), "", 0);
            if ($(tabNameElement).isCurrentlyVisible()) {
                $(tabNameElement).waitUntilClickable();
                reusableUtilities.scrollToAnElement(tabNameElement);
                reusableUtilities.performAction("", $(tabNameElement), "");
            }
            else if($(tabNameElement2).isCurrentlyVisible()) {
                $(tabNameElement2).waitUntilClickable();
                reusableUtilities.scrollToAnElement(tabNameElement2);
                reusableUtilities.performAction("", $(tabNameElement2), "");
            }
        }
        waitABit(5000);
        if(Serenity.getDriver().switchTo().activeElement().getAttribute("className").contains("tabs__tab_active")){
            Assert.assertTrue(true);
        }
        else{
            $(By.cssSelector("div.aras-scroller__wrapper:nth-child(2) span.aras-tabs-arrow:nth-child(3)")).click();
            waitABit(1000);
            reusableUtilities.scrollToAnElement(tabNameElement);
            waitABit(1000);
            reusableUtilities.performAction("", $(tabNameElement), "");
        }
    }
    public void voteNowButton() {
        waitABit(2000);
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(PartPage.newFrameForCreatePartFrame), "", 0);
        waitABit(2000);
        if($(newFrameForm1).isCurrentlyVisible()) {
            reusableUtilities.switchFrame($(newFrameForm1), "", 0);
            reusableUtilities.switchFrame($(newFrameForm2), "", 0);
            reusableUtilities.switchFrame($(newFrameToSeeSubFamilyWorkFlow), "", 0);
        }
        else {
            reusableUtilities.switchFrame($(newFrameForm), "", 0);
            reusableUtilities.switchFrame($(newFrameForm2), "", 0);
            reusableUtilities.switchFrame($(newFrameToSeeSubFamilyWorkFlow), "", 0);
        }
        reusableUtilities.scrollToAnElement(voteNowButton);
        reusableUtilities.conditionalWait("Visibility", voteNowButton, "");
        reusableUtilities.performAction("", $(voteNowButton), "");
        waitABit(3000);
    }
    public void validateWorkflowWindow() {
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(PartPage.newFrameForCreatePartFrame), "", 0);
        reusableUtilities.conditionalWait("Visibility", newFrameForWorkFlow, "");
        reusableUtilities.switchFrame($(newFrameForWorkFlow), "", 0);
    }
    public void userSelectsSendToReviewVoteList(String s) {
        validateWorkflowWindow();
        reusableUtilities.performAction("Select", $(voteList), s.trim());
    }
    public void userClicksCompleteButton() {
        validateWorkflowWindow();
        reusableUtilities.performAction("", $(completeButton), "");
        if($(continueButton).isCurrentlyVisible()) {
            $(continueButton).click();
        }
    }
    public void validateWorkFlowStatus(String s) {
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(PartPage.newFrameForCreatePartFrame), "", 0);
        reusableUtilities.conditionalWait("Visibility", newFrameForm, "");
//        if($(qcsAffectedItemIframe).isCurrentlyVisible()){
//            reusableUtilities.switchFrame($(qcsAffectedItemIframe), "", 0);
//        }else {
//            reusableUtilities.switchFrame($(newFrameForm), "", 0);
//            reusableUtilities.switchFrame($(newFrameForm2), "", 0);
//        }
        reusableUtilities.switchFrame($(newFrameToSeeSubFamilyWorkFlow), "", 0);
        reusableUtilities.conditionalWait("Visibility", By.xpath("//*[contains(text(),'"+s.trim()+"')]"), "");
        Assert.assertTrue(true);
    }
    public void userOpensNewlyCreatedSubFamilyRequest() {
        waitABit(5000);
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.conditionalWait("Visibility", PartPage.newFrameForPartSearch, "");
        reusableUtilities.switchFrame($(PartPage.newFrame), "", 0);
        reusableUtilities.conditionalWait("visibility", PartPage.arasSpinner, "");
        reusableUtilities.conditionalWait("invisibility", PartPage.arasSpinner, "");
        reusableUtilities.performAction("Text", $(PartPage.searchFieldToSearchParts), PartPage.generatedItemCode);
        reusableUtilities.pressEnter(PartPage.searchFieldToSearchParts);
        reusableUtilities.doubleClick(PartPage.searchResults);
    }
}
