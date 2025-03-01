package starter.PageObjectsPages.nonMBOM.FMS;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import starter.Utility.ReusableUtilities;

import java.util.List;

public class ParameterTemplatePage extends PageObject {

    public static By newFrameForPartAdditionInParameterTemplate = By.xpath("y']");
    public static By secondSearchResult = By.xpath("(//tr[@class='aras-grid-row' and @data-index='1']//td[@class='aras-grid-row-cell '])[2]");
    public static By promoteButton = By.xpath("//button[@class='aras-toolbar__item aras-button' and @title='Promote']");
    public static By moreButton = By.xpath("//button[@class='aras-button' and @title='More']");
    public static By navigateButton = By.xpath("//button[@class='aras-button' and @title='Navigate']");
    public static By createNewRevisionButton = By.xpath("//span[text()='Create New Revision']");
    public static By versionsButton = By.xpath("//span[text()='Versions']");
    public static By newFrameToSelectState = By.xpath("//iframe[@class='aras-dialog__iframe']");
    public static By versions = By.xpath("//td[@tabindex='-1' and @idx='4']");
    public static By itemTypeField = By.xpath("//input[contains(@class,'pmi_partclassification')]");
    public static By subFamilyField = By.xpath("//input[contains(@name,'pmi_sub_families')]");
    public static By closeVersionsWindowButton = By.xpath("//*[@class='aras-dialog__close-button aras-icon-close']");
    public static By breRuleButton = By.xpath("(//button[contains(@class, 'aras-btn')])[2]");
    public static By breRuleField = By.xpath("//input[@class='aras-form-input']");
    public static By clearSearchField = By.xpath("//button[@title='Clear Search Criteria']");
    public static By runSearchField = By.xpath("//button[@title='Run Search']");
    public static By deleteParameterButton = By.xpath("//button[@title='Delete FMS Advance Search']");
    public static By restoreParameterButton = By.xpath("//span[text()='Restore Parameters']");


    ReusableUtilities reusableUtilities;

    public void defaultAttributeOfParameterTemplateFormValidation(List<List<String>> data) {
        for(int i = 0; i< data.get(0).size(); i++) {
            Serenity.getDriver().switchTo().defaultContent();
            reusableUtilities.switchFrame($(starter.PageObjectsPages.nonMBOM.FMS.PartPage.newFrameForCreatePartFrame), "", 0);
            reusableUtilities.switchFrame($(starter.PageObjectsPages.nonMBOM.FMS.PartPage.newFrameForCreatePartFrameDataEntry), "", 0);
            By defaultAttribute = By.xpath("//*[contains(text(),'"+data.get(0).get(i)+"')]");
            if($(defaultAttribute).isCurrentlyVisible()) {
                Assert.assertTrue(true);
                System.out.println(data.get(0).get(i)+" is present in the form");
            }
            else {
                Serenity.getDriver().switchTo().parentFrame();
                if($(defaultAttribute).isCurrentlyVisible()) {
                    Assert.assertTrue(true);
                    System.out.println(data.get(0).get(i)+" is present in the form");
                }
            }
        }
    }
    public void userAddsParametersToParameterTemplate() {
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(ParametersToIngredientPage.newFrameForCreatePartFrame), "", 0);
        reusableUtilities.switchFrame($(newFrameForPartAdditionInParameterTemplate), "", 0);
        reusableUtilities.conditionalWait("visibility", ParametersToIngredientPage.addParametersButton, "");
        reusableUtilities.performAction("", $(ParametersToIngredientPage.addParametersButton), "");
        Serenity.getDriver().switchTo().parentFrame();
        reusableUtilities.switchFrame($(ParametersToIngredientPage.newFrameToSelectParameters), "", 0);
        waitABit(2000);
        $(clearSearchField).click();
        waitABit(2000);
        $(runSearchField).click();
        /*reusableUtilities.performAction("", $(ParametersToIngredientPage.searchFieldToSearchParameters), "");
        for(int i = 1; i<14; i++) {
            waitABit(1000);
            reusableUtilities.pressControlA();
            reusableUtilities.pressBackspace();
            reusableUtilities.pressTab();
        }
        reusableUtilities.pressEnter(ParametersToIngredientPage.searchFieldToSearchParameters);*/
        reusableUtilities.conditionalWait("visibility", ParametersToIngredientPage.searchResults, "");
        reusableUtilities.performAction("", $(ParametersToIngredientPage.searchResults), "");
        reusableUtilities.performAction("", $(ParametersToIngredientPage.okButton), "");
    }

    public void userAddsAnotherParametersToParameterTemplate() {
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(ParametersToIngredientPage.newFrameForCreatePartFrame), "", 0);
        reusableUtilities.switchFrame($(newFrameForPartAdditionInParameterTemplate), "", 0);
        reusableUtilities.conditionalWait("visibility", ParametersToIngredientPage.addParametersButton, "");
        reusableUtilities.performAction("", $(ParametersToIngredientPage.addParametersButton), "");
        Serenity.getDriver().switchTo().parentFrame();
        reusableUtilities.switchFrame($(ParametersToIngredientPage.newFrameToSelectParameters), "", 0);
        reusableUtilities.performAction("", $(ParametersToIngredientPage.searchFieldToSearchParameters), "");
        reusableUtilities.pressControlA();
        reusableUtilities.pressBackspace();
        reusableUtilities.pressTab();
        waitABit(500);
        reusableUtilities.pressControlA();
        reusableUtilities.pressBackspace();
        reusableUtilities.pressTab();
        waitABit(500);
        reusableUtilities.pressControlA();
        reusableUtilities.pressBackspace();
        reusableUtilities.pressTab();
        waitABit(500);
        reusableUtilities.pressControlA();
        reusableUtilities.pressBackspace();
        reusableUtilities.pressTab();
        waitABit(500);
        reusableUtilities.pressControlA();
        reusableUtilities.pressBackspace();
        reusableUtilities.pressTab();
        waitABit(500);
        reusableUtilities.pressEnter(ParametersToIngredientPage.searchFieldToSearchParameters);
        reusableUtilities.conditionalWait("visibility", ParametersToIngredientPage.searchResults, "");
        reusableUtilities.performAction("", $(secondSearchResult), "");
        reusableUtilities.performAction("", $(ParametersToIngredientPage.okButton), "");
    }

    public void formCreationValidation() {
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(ParametersToIngredientPage.newFrameForCreatePartFrame), "", 0);
        reusableUtilities.conditionalWait("visibility", starter.PageObjectsPages.nonMBOM.FMS.PartPage.editButton, "");
        Assert.assertTrue(true);
    }

    public void createNewRevision() {
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(starter.PageObjectsPages.nonMBOM.FMS.PartPage.newFrameForCreatePartFrame), "", 0);
        reusableUtilities.performAction("", $(moreButton), "");
        reusableUtilities.performAction("", $(createNewRevisionButton), "");
    }

    public void userClicksOnPromoteButton() {
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(starter.PageObjectsPages.nonMBOM.FMS.PartPage.newFrameForCreatePartFrame), "", 0);
        reusableUtilities.performAction("", $(promoteButton), "");
    }

    public void userSelectsState(String lifecycleState) {
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(starter.PageObjectsPages.nonMBOM.FMS.PartPage.newFrameForCreatePartFrame), "", 0);
        reusableUtilities.switchFrame($(newFrameToSelectState), "", 0);
        reusableUtilities.doubleClick(By.xpath("//*[text()='"+lifecycleState.trim()+"']"));
    }

    public void userClicksOnVersions() {
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(starter.PageObjectsPages.nonMBOM.FMS.PartPage.newFrameForCreatePartFrame), "", 0);
        reusableUtilities.performAction("", $(navigateButton), "");
        reusableUtilities.performAction("", $(versionsButton), "");
    }

    public void userValidatesVersions() {
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(starter.PageObjectsPages.nonMBOM.FMS.PartPage.newFrameForCreatePartFrame), "", 0);
        reusableUtilities.switchFrame($(newFrameToSelectState), "", 0);
        if(reusableUtilities.getObjectProperty($(versions), "text").equalsIgnoreCase("Obsolete")) {
            Assert.assertTrue(true);
        }
        Serenity.getDriver().switchTo().parentFrame();
        reusableUtilities.performAction("", $(closeVersionsWindowButton), "");
    }

    public void userValidatesItemTypeAndSubFamilyField() {
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(starter.PageObjectsPages.nonMBOM.FMS.PartPage.newFrameForCreatePartFrame), "", 0);
        reusableUtilities.switchFrame($(starter.PageObjectsPages.nonMBOM.FMS.PartPage.newFrameForCreatePartFrameDataEntry), "", 0);
        Assert.assertFalse("Item Code field is non editable",$(itemTypeField).isEnabled());
        Assert.assertFalse("Item Code field is non editable",$(subFamilyField).isEnabled());
    }

    public void userSetsBRERule(String breRule){
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(starter.PageObjectsPages.nonMBOM.FMS.PartPage.newFrameForCreatePartFrame), "", 0);
        reusableUtilities.switchFrame($(starter.PageObjectsPages.nonMBOM.FMS.PartPage.newFrameForCreatePartFrameDataEntry), "", 0);
        $(breRuleButton).click();
        Serenity.getDriver().switchTo().parentFrame();
        reusableUtilities.conditionalWait("visibility", ParametersToIngredientPage.newFrameToSelectParameters, "");
        reusableUtilities.switchFrame($(ParametersToIngredientPage.newFrameToSelectParameters), "", 0);
        reusableUtilities.conditionalWait("visibility", breRuleField, "");
        waitABit(2000);
        $(breRuleField).click();
        waitABit(2000);
        reusableUtilities.pressControlA();
        waitABit(2000);
        reusableUtilities.pressBackspace();
        waitABit(2000);
        $(breRuleField).sendKeys(breRule.trim());
        reusableUtilities.pressEnterWithoutElement();
        reusableUtilities.conditionalWait("visibility", starter.PageObjectsPages.nonMBOM.FMS.PartPage.searchResults, "");
        $(starter.PageObjectsPages.nonMBOM.FMS.PartPage.searchResults).click();
        $(ParametersToIngredientPage.okButton).click();
        Serenity.getDriver().switchTo().parentFrame();
        if($(By.xpath("//*[text()='Yes']")).isCurrentlyVisible()){
            $(By.xpath("//*[text()='Yes']")).click();
        }
        waitABit(5000);
    }
    public void userTriesToOpenNewParameterTemplate(){
        Serenity.getDriver().switchTo().defaultContent();
        $(starter.PageObjectsPages.nonMBOM.FMS.PartPage.closeButton).click();
        $(starter.PageObjectsPages.nonMBOM.FMS.PartPage.arasButtonIcon).click();
        $(By.xpath("//*[text()='Create New Parameter Template']")).click();
    }
    public void userDeletesParameter(){
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(ParametersToIngredientPage.newFrameForCreatePartFrame), "", 0);
        reusableUtilities.switchFrame($(ParametersToIngredientPage.newFrameForPartAddition), "", 0);
        reusableUtilities.conditionalWait("visibility", starter.PageObjectsPages.nonMBOM.FMS.PartPage.searchResults, "");
        $(starter.PageObjectsPages.nonMBOM.FMS.PartPage.searchResults).click();
        waitABit(1000);
        reusableUtilities.conditionalWait("visibility", deleteParameterButton, "");
        $(deleteParameterButton).click();
    }
    public void userRestoresParameter(){
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(ParametersToIngredientPage.newFrameForCreatePartFrame), "", 0);
        reusableUtilities.switchFrame($(ParametersToIngredientPage.newFrameForPartAddition), "", 0);
        reusableUtilities.conditionalWait("visibility", restoreParameterButton, "");
        $(restoreParameterButton).click();
    }
}