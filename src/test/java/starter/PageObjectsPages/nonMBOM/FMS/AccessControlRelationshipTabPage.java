package starter.PageObjectsPages.nonMBOM.FMS;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import starter.Utility.ReusableUtilities;

import java.util.List;

public class AccessControlRelationshipTabPage extends PageObject {

    public static By addRelationshipTabButton = By.xpath("//button[@title='Add Tabs Confidentiality Mapping']");
    public static By newFrameToAddInVisibleTabs = By.xpath("//iframe[@title='pmi_RestrictedRelTabs Relationship']");

    ReusableUtilities reusableUtilities;

    public void belowMentionedConfidentialTabShouldNOTBePresent(List<List<String>> data){
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(ParametersToIngredientPage.newFrameForCreatePartFrame), "", 0);
        if($(By.xpath("//*[text()='"+data.get(0).get(0).trim()+"']")).isCurrentlyVisible()){
            Assert.fail();
        }
    }
    public void userProvidesItemTypeAndAttributeInVisibleTab(String itemType, String tabName){
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(ParametersToIngredientPage.newFrameForCreatePartFrame), "", 0);
        reusableUtilities.switchFrame($(newFrameToAddInVisibleTabs), "", 0);
        reusableUtilities.conditionalWait("visibility", addRelationshipTabButton, "");
        reusableUtilities.performAction("", $(addRelationshipTabButton), "");
        waitABit(2000);
        Serenity.getDriver().switchTo().parentFrame();
        reusableUtilities.switchFrame($(ParametersToIngredientPage.newFrameToSelectParameters), "", 0);
        $(AccessControlAttributesPage.confidentialField).click();
        waitABit(1000);
        reusableUtilities.pressShiftTab();
        waitABit(1000);
        reusableUtilities.pressShiftTab();
        waitABit(1000);
        reusableUtilities.pressControlA();
        waitABit(1000);
        $(Serenity.getDriver().switchTo().activeElement()).sendKeys(itemType);
        waitABit(1000);
        reusableUtilities.pressTab();
        waitABit(1000);
        $(Serenity.getDriver().switchTo().activeElement()).sendKeys(tabName);
        waitABit(1000);
        reusableUtilities.pressTab();
        waitABit(1000);
        reusableUtilities.pressEnterWithoutElement();
        reusableUtilities.conditionalWait("visibility", ParametersToIngredientPage.searchResults, "");
        reusableUtilities.performAction("", $(ParametersToIngredientPage.searchResults), "");
        reusableUtilities.performAction("", $(ParametersToIngredientPage.okButton), "");
    }
}