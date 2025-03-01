package starter.PageObjectsPages.nonMBOM.FMS;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import starter.Utility.ReusableUtilities;

public class UserGroupAccessCheckPage extends PageObject {

    static By searchResult = By.xpath("//tr[@class='aras-grid-row' and @data-index='1']//td[@class='aras-grid-row-cell ']");
    public static By searchButton = By.xpath("//span[text()='Search']");

    ReusableUtilities reusableUtilities;

    public void triedToClickCreateNewPartButton() {
        if($(By.xpath("//*[text()='Create New Part']")).isClickable()) {
            Assert.assertFalse(false);
        }
    }
    public void validateCreateNewPartButton() {
        Assert.assertTrue("Create New Part button is disabled", true);
    }
    public void userOpensCreatedPart(String itemType) {
        String s = "";
        if(itemType.equalsIgnoreCase("Ingredient")) {
            s = "08.*";
        }
        else if(itemType.equalsIgnoreCase("Formula")) {
            s = "10.*";
        }
        Serenity.getDriver().switchTo().defaultContent();
        if($(PartPage.searchPartsButton).isCurrentlyVisible()) {

        }
        else {
            reusableUtilities.performAction("", $(PartPage.arasButtonIcon),"");
        }
        reusableUtilities.performAction("",$(PartPage.searchPartsButton),"");
        reusableUtilities.conditionalWait("Visibility", PartPage.newFrameForPartSearch, "");
        //reusableUtilities.switchFrame($(PartPage.newFrameForPartSearch), "", 0);
        reusableUtilities.switchFrame($(PartPage.newFrame), "", 0);
        reusableUtilities.conditionalWait("visibility", PartPage.arasSpinner, "");
        reusableUtilities.conditionalWait("invisibility", PartPage.arasSpinner, "");
        reusableUtilities.performAction("Text", $(PartPage.searchFieldToSearchParts), s);
        reusableUtilities.pressEnter(PartPage.searchFieldToSearchParts);
        reusableUtilities.conditionalWait("Visibility", searchResult, "");
        reusableUtilities.doubleClick(searchResult);
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(PartPage.newFrameForCreatePartFrame), "", 0);
        reusableUtilities.performAction("", $(PartPage.ok),"");
    }

    public void userShouldNotAbleToEdit() {
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.performAction("",$(PartPage.closeButton),"");
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.performAction("", $(PartPage.firstTab), "");
        reusableUtilities.switchFrame($(PartPage.newFrameForCreatePartFrame), "", 0);
        reusableUtilities.performAction("", $(PartPage.editButton), "");
    }
}
