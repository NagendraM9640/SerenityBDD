package starter.PageObjectsPages.nonMBOM.FMS;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import starter.Utility.ReusableUtilities;

public class SaveAsBusinessAdminTemplatesPage extends PageObject {

    ReusableUtilities reusableUtilities;

    public void searchingWithCode(String code){
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.conditionalWait("Visibility", PartPage.newFrame, "");
        reusableUtilities.switchFrame($(PartPage.newFrame), "", 0);
        reusableUtilities.conditionalWait("visibility", PartPage.arasSpinner, "");
        reusableUtilities.conditionalWait("invisibility", PartPage.arasSpinner, "");
        reusableUtilities.performAction("Text", $(PartPage.searchFieldToSearchParts), code);
        waitABit(2000);
        reusableUtilities.pressEnter(PartPage.searchFieldToSearchParts);
        reusableUtilities.conditionalWait("Visibility", PartPage.searchResults, "");
    }

    public void itemCodeValidation(String itemCode) {
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(PartPage.newFrameForCreatePartFrame), "", 0);
        reusableUtilities.switchFrame($(PartPage.newFrameForCreatePartFrameDataEntry), "", 0);
        if(reusableUtilities.getObjectProperty($(PartPage.pmiCode), "value").equalsIgnoreCase(itemCode)){
            Assert.fail();
        }
    }

    public void historyDescriptionShouldHaveMentionedThatCopiedFromTheOriginalOne(){
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(PartPage.newFrameForCreatePartFrame), "", 0);
        reusableUtilities.conditionalWait("visibility", ECOCreationPageObjects.newFrameForHistoryRelationship1, "");
        reusableUtilities.switchFrame($(ECOCreationPageObjects.newFrameForHistoryRelationship1), "", 0);
        reusableUtilities.switchFrame($(ECOCreationPageObjects.newFrameForHistoryRelationship2), "", 0);
        reusableUtilities.switchFrame($(ECOCreationPageObjects.newFrameForHistoryRelationship3), "", 0);
        reusableUtilities.switchFrame($(ECOCreationPageObjects.newFrameForHistoryRelationship4), "", 0);
        waitABit(2000);
        $(SaveAsPartsPage.copyField).click();
        reusableUtilities.pressRightNavigation();
        String s = Serenity.getDriver().switchTo().activeElement().getText().trim();
        System.out.println(s);
        if(s.contains("Copied From ")){
            Assert.assertTrue(true);
        }
        else {
            Assert.fail();
        }
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(PartPage.newFrameForCreatePartFrame), "", 0);
        $(ECOCreationPageObjects.historyWindowCloseButton).click();
        if($(PartPage.alertMessage).isCurrentlyVisible()){
            $(PartPage.ok).click();
        }
        waitABit(2000);
    }
}
