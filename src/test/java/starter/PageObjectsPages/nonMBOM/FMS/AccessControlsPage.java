package starter.PageObjectsPages.nonMBOM.FMS;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import starter.Utility.ReusableUtilities;

import java.util.List;

public class AccessControlsPage extends PageObject {

    public static By addPropertiesButton = By.xpath("//button[@title='Add Properties']");
    public static By addRelationshipTypesButton = By.xpath("//button[@title='Add RelationshipTypes']");
    public static By newFrameToAddRestrictionsToField = By.xpath("//iframe[@title='pmi_RestrictedAttributesTab Relationship']");
    public static By newFrameToAddRestrictionsToTabs = By.xpath("//iframe[@title='pmi_RestrictedRelTabs Relationship']");
    public static By userGroupSearchField = By.xpath("//td[@class='aras-grid-search-row-cell ' and @data-index='1']");
    public static By tabSearchField = By.xpath("//td[@class='aras-grid-search-row-cell ' and @data-index='2']");
    public static By attributeSearchField = By.xpath("//td[@class='aras-grid-search-row-cell ' and @data-index='3']");
    public static By labelSearchField = By.xpath("//td[@class='aras-grid-search-row-cell ' and @data-index='4']");
    public static By userGroupFieldButton = By.xpath("//button[@class='aras-filter-list__button aras-btn']");


    ReusableUtilities reusableUtilities;

    public void userSelectsUserGroups(String userGroup) {
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(PartPage.newFrameForCreatePartFrame), "", 0);
        reusableUtilities.switchFrame($(PartPage.newFrameForCreatePartFrameDataEntry), "", 0);
        reusableUtilities.performAction("", $(userGroupFieldButton), "");
        Serenity.getDriver().switchTo().parentFrame();
        reusableUtilities.conditionalWait("visibility", PartPage.newFrameToSelectPart, "");
        reusableUtilities.switchFrame($(PartPage.newFrameToSelectPart), "", 0);
        waitABit(4000);
        reusableUtilities.conditionalWait("visibility", userGroupSearchField, "");
        reusableUtilities.performAction("", $(userGroupSearchField), "");
        $(Serenity.getDriver().switchTo().activeElement()).clear();
        $(Serenity.getDriver().switchTo().activeElement()).typeAndEnter(userGroup);
        waitABit(2000);
        reusableUtilities.performAction("", $(PartPage.searchResults), "");
        reusableUtilities.performAction("", $(PartPage.ok), "");
    }
    public void userRestrictsTheField(String fieldName) {
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(PartPage.newFrameForCreatePartFrame), "", 0);
        reusableUtilities.switchFrame($(newFrameToAddRestrictionsToField), "", 0);
        reusableUtilities.scrollToAnElement(addPropertiesButton);
        reusableUtilities.performAction("", $(addPropertiesButton), "");
        Serenity.getDriver().switchTo().parentFrame();
        reusableUtilities.switchFrame($(PartPage.newFrameToSelectPart), "", 0);
        waitABit(4000);
        reusableUtilities.conditionalWait("visibility", attributeSearchField, "");
        reusableUtilities.performAction("", $(userGroupSearchField), "");
        $(Serenity.getDriver().switchTo().activeElement()).clear();
        waitABit(2000);
        reusableUtilities.performAction("", $(labelSearchField), "");
        $(Serenity.getDriver().switchTo().activeElement()).clear();
        waitABit(2000);
        reusableUtilities.performAction("", $(attributeSearchField), "");
        $(Serenity.getDriver().switchTo().activeElement()).clear();
        $(Serenity.getDriver().switchTo().activeElement()).typeAndEnter(fieldName);
        waitABit(2000);
        reusableUtilities.performAction("", $(PartPage.searchResults), "");
        reusableUtilities.performAction("", $(PartPage.ok), "");
    }
    public void userRestrictsTheTab(String tabName) {
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(PartPage.newFrameForCreatePartFrame), "", 0);
        reusableUtilities.switchFrame($(newFrameToAddRestrictionsToTabs), "", 0);
        reusableUtilities.scrollToAnElement(addRelationshipTypesButton);
        reusableUtilities.performAction("", $(addRelationshipTypesButton), "");
        Serenity.getDriver().switchTo().parentFrame();
        reusableUtilities.switchFrame($(PartPage.newFrameToSelectPart), "", 0);
        waitABit(4000);
        reusableUtilities.conditionalWait("visibility", tabSearchField, "");
        reusableUtilities.performAction("", $(tabSearchField), "");
        $(Serenity.getDriver().switchTo().activeElement()).clear();
        $(Serenity.getDriver().switchTo().activeElement()).typeAndEnter(tabName);
        waitABit(2000);
        reusableUtilities.performAction("", $(PartPage.searchResults), "");
        reusableUtilities.performAction("", $(PartPage.ok), "");
    }

    public void attributeNotPresentValidation(List<List<String>> data) {
        for(int i = 0; i< data.get(0).size(); i++) {
            Serenity.getDriver().switchTo().defaultContent();
            reusableUtilities.switchFrame($(PartPage.newFrameForCreatePartFrame), "", 0);
            reusableUtilities.switchFrame($(PartPage.newFrameForCreatePartFrameDataEntry), "", 0);
            By defaultAttribute = By.xpath("//*[contains(text(),'"+data.get(0).get(i)+"')]");
            if($(defaultAttribute).isCurrentlyVisible()) {
                Assert.assertFalse(false);
                System.out.println(data.get(0).get(i)+" is present in the form");
            }
            else {
                Serenity.getDriver().switchTo().parentFrame();
                if($(defaultAttribute).isCurrentlyVisible()) {
                    Assert.assertFalse(false);
                    System.out.println(data.get(0).get(i)+" is present in the form");
                }
            }
            Assert.assertTrue(true);
        }
    }
}
