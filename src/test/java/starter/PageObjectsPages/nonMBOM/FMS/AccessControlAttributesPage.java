package starter.PageObjectsPages.nonMBOM.FMS;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import starter.Utility.ReusableUtilities;

import java.util.List;

public class AccessControlAttributesPage extends PageObject {

    public static By attributeItemType = By.xpath("//input[@name='pmi_itemtype']");
    public static By attributeProperty = By.xpath("//input[@name='pmi_property']");
    public static By confidentialCheckBox = By.xpath("//input[@name='pmi_flag']");
    public static By newFrameToAddInVisibleAttributes = By.xpath("//iframe[@title='pmi_RestrictedAttributesTab Relationship']");
    public static By addAttributesButton = By.xpath("//button[@title='Add Attributes Confidentiality Mapping']");
    public static By confidentialField = By.xpath("//input[@class='aras-form-input']");
    ////td[@class='aras-grid-search-row-cell ']//input[@class='aras-form-input']

    ReusableUtilities reusableUtilities;

    public void userSelectsAttributeItemType(String itemType){
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(starter.PageObjectsPages.nonMBOM.FMS.PartPage.newFrameForCreatePartFrame), "",0);
        reusableUtilities.switchFrame($(PartPage.newFrameForCreatePartFrameDataEntry), "",0);
        $(attributeItemType).sendKeys(itemType);
    }
    public void userSelectsAttributeProperty(String attributeName){
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(PartPage.newFrameForCreatePartFrame), "",0);
        reusableUtilities.switchFrame($(PartPage.newFrameForCreatePartFrameDataEntry), "",0);
        $(attributeProperty).sendKeys(attributeName);
        reusableUtilities.pressTab();
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(PartPage.newFrameForCreatePartFrame), "",0);
        if($(ParametersToIngredientPage.newFrameToSelectParameters).isCurrentlyVisible()) {
            reusableUtilities.switchFrame($(ParametersToIngredientPage.newFrameToSelectParameters), "", 0);
            if($(By.xpath("//*[@id='btnOK']")).isCurrentlyVisible()){
                $(By.xpath("//*[@id='btnOK']")).click();
            }
        }
    }
    public void userSelectsConfidentialCheckBox(){
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(PartPage.newFrameForCreatePartFrame), "",0);
        reusableUtilities.switchFrame($(PartPage.newFrameForCreatePartFrameDataEntry), "",0);
        $(confidentialCheckBox).click();
    }
    public void searchingWithAccessControlNumber(String accessControlID){
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.conditionalWait("Visibility", PartPage.newFrameForPartSearch, "");
        reusableUtilities.switchFrame($(PartPage.newFrame), "", 0);
        reusableUtilities.conditionalWait("visibility", PartPage.arasSpinner, "");
        reusableUtilities.conditionalWait("invisibility", PartPage.arasSpinner, "");
        reusableUtilities.performAction("Text", $(PartPage.searchFieldToSearchParts), accessControlID);
        reusableUtilities.pressEnter(PartPage.searchFieldToSearchParts);
        reusableUtilities.conditionalWait("Visibility", PartPage.searchResults, "");
        waitABit(3000);
        reusableUtilities.doubleClick(PartPage.searchResults);
    }
    public void attributesShouldNotBePresent(List<List<String>> data) {
        for(int i = 0; i< data.get(0).size(); i++) {
            Serenity.getDriver().switchTo().defaultContent();
            reusableUtilities.switchFrame($(PartPage.newFrameForCreatePartFrame), "", 0);
            reusableUtilities.switchFrame($(PartPage.newFrameForCreatePartFrameDataEntry), "", 0);
            By defaultAttribute = By.xpath("//*[contains(text(),'"+data.get(0).get(i)+"')]");
            if($(defaultAttribute).isCurrentlyVisible()) {
                Assert.fail();
            }
            else {
                Serenity.getDriver().switchTo().parentFrame();
                if($(defaultAttribute).isCurrentlyVisible()) {
                    Assert.fail();
                }
            }
        }
    }
    public void userProvidesItemTypeAndAttributeInVisibleTab(String itemType, String attributeName){
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(ParametersToIngredientPage.newFrameForCreatePartFrame), "", 0);
        reusableUtilities.switchFrame($(newFrameToAddInVisibleAttributes), "", 0);
        reusableUtilities.conditionalWait("visibility", addAttributesButton, "");
        reusableUtilities.performAction("", $(addAttributesButton), "");
        waitABit(1000);
        Serenity.getDriver().switchTo().parentFrame();
        reusableUtilities.switchFrame($(ParametersToIngredientPage.newFrameToSelectParameters), "", 0);
        $(confidentialField).click();
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
        $(Serenity.getDriver().switchTo().activeElement()).sendKeys(attributeName);
        waitABit(1000);
        reusableUtilities.pressTab();
        waitABit(1000);
        reusableUtilities.pressEnterWithoutElement();
        reusableUtilities.conditionalWait("visibility", ParametersToIngredientPage.searchResults, "");
        reusableUtilities.performAction("", $(ParametersToIngredientPage.searchResults), "");
        reusableUtilities.performAction("", $(ParametersToIngredientPage.okButton), "");
    }
}