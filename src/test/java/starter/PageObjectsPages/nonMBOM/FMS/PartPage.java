package starter.PageObjectsPages.nonMBOM.FMS;

import io.cucumber.java.ja.且つ;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import starter.Utility.ReusableUtilities;

import java.util.List;
public class PartPage extends PageObject {

    public static By arasButtonIcon = By.className("aras-button__icon");
    public static By newFrameToSelectPart = By.xpath("//*[@class='aras-dialog__iframe']");
    public static By itemCode = By.xpath("//*[@class='item_number']");
    public static By projectCode = By.xpath("//*[@class='pmi_project_number']");
    public static By pmiCode = By.xpath("//*[@class='pmi_code']");
    public static By projectTemplateCode = By.xpath("//input[@name='pmi_number']");
    public static By itemName = By.xpath("//input[contains(@name,'classification')]");
    public static By description = By.xpath("//*[@class='description']");
    public static By doneButton = By.xpath("//*[text()='Done']");
    public static By saveButton = By.xpath("//*[text()='Save']");
    public static By editButton = By.xpath("//*[text()='Edit']");
    public static By searchButton = By.xpath("//*[text()='Search']");
    public static By newFrameForCreatePartFrame = By.xpath("//iframe[contains(@name,'innovator_')]");
    public static By newFrameForCreatePartFrame2 = By.xpath("(//iframe[contains(@name,'innovator_')])[2]");
    public static By newFrameForCreatePartFrame3 = By.xpath("(//iframe[contains(@name,'innovator_')])[3]");
    public static By newFrameForCreatePartFrameDataEntry = By.xpath("//*[@id='instance']");
    public static By searchPartsButton = By.xpath("//*[text()='Search Parts']");
    public static By createNewPartButton = By.xpath("//*[text()='Create New Part']");
    public static By searchFieldToSearchParts = By.xpath("//*[@class='aras-form-input']");
    public static By tripleDots = By.xpath("//button[@title='More']");

    public static By arasSpinner = By.xpath("//iframe[@id='dimmer_spinner']");
    public static By subFamilyDropDownButton = By.xpath("//*[contains(@class,'aras-icon-arrow_down')]");

    public static By newFrame = By.xpath("//iframe[contains(@name,'search_')]");

    public static By newFrameForPartSearch = By.xpath("//*[@class='content-block__iframe']");

    public static By searchResults = By.xpath("(//*[@class='aras-grid-row-cell '])[1]");
    public static By secondSearchResults = By.xpath("(//*[@class='aras-grid-row-cell '])[2]");
    public static By firstTab = By.xpath("(//*[@class='aras-tabs__label'])[1]");
    public static By secondTab = By.xpath("(//*[@class='aras-tabs__label'])[2]");
    public static By ThirdTab = By.xpath("(//*[@class='aras-tabs__label'])[3]");
    public static By closeButton = By.xpath("//*[@class='aras-icon-close']");
    public static By closeButtonForSecondTab = By.xpath("(//*[@class='aras-icon-close'])[2]");
    public static By delete = By.xpath("//span[text()='Delete']");
    public static By delete2 = By.xpath("(//span[text()='Delete'])[2]");
    public static By ok = By.xpath("//*[text()='OK']");
    public static By confirmButton = By.xpath("//span[@class='aras-button__text' and text()='Confirm']");
    public static By deleteAllVersions = By.xpath("//span[text()='Delete All Versions']");
    public static By newFrameForFileSearch = By.xpath("//*[@class='content-block__iframe']");
    public static By deletePart = By.xpath("//span[@class='aras-button__text' and text()='Delete']");
    public static By partTab = By.xpath("(//div[@class='aras-scroller__wrapper']//span[@class='aras-tabs__label'])[1]");
    public static By status1 = By.className("state");
    public static By status2 = By.className("pmi_target_lc");
    public static By status3 = By.name("state");
    public static By status4 = By.xpath("//*[@id='item_status']");
    public static By status5 = By.xpath("//input[@name='pmi_target_lc']");
    public static By status6 = By.xpath("//input[@name='pmi_workflow_status']");
    public static By analysisPackageState = By.className("pmi_status");
    public static By commonNameElement = By.className("pmi_common_name");
    public static By trialNameElement = By.className("pmi_trial_name");

    public static By alertMessage = By.xpath("//span[@class='aras-dialog-alert__text']");
    public static By newFrameToAddSubFamilyInList = By.xpath("//iframe[@title='Value Relationship']");
    public static By subFamilyListAddButton = By.xpath("//button[@class='aras-toolbar__item aras-button' and @title='New Value']");
    public static By resultsPerPageElement = By.xpath("//input[@title='Results per Page']");

    ReusableUtilities reusableUtilities;

    public static String generatedItemCode = "";

    public void selectingIngredient(String itemType) {
        By partNameAsIngredient = By.xpath("//*[text()='" + itemType.trim() + "']");
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(newFrameToSelectPart), "", 0);
        waitABit(1000);
        $(By.xpath("//span[@class='aras-form aras-compat-toolbar__textbox']/input")).click();
        waitABit(1000);
        $(By.xpath("//span[@class='aras-form aras-compat-toolbar__textbox']/input")).sendKeys(itemType);
        waitABit(1000);
        reusableUtilities.pressEnterWithoutElement();
        waitABit(2000);
        reusableUtilities.doubleClick(partNameAsIngredient);
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.conditionalWait("invisibility", arasSpinner, "");
    }

    public void selectingItemTypeForPartInsidePartBOM(String itemType) {
        By partNameAsIngredient = By.xpath("//*[text()='" + itemType.trim() + "']");
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(newFrameForCreatePartFrame), "", 0);
        reusableUtilities.switchFrame($(newFrameToSelectPart), "", 0);
        reusableUtilities.doubleClick(partNameAsIngredient);
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.conditionalWait("invisibility", arasSpinner, "");
    }

    public void itemTypeFieldValidation(String itemType) {
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(newFrameForCreatePartFrame), "", 0);
        reusableUtilities.switchFrame($(newFrameForCreatePartFrameDataEntry), "", 0);
        reusableUtilities.conditionalWait("Visibility", itemName, "Item Number to be visible");
        String s = reusableUtilities.getObjectProperty($(itemName), "value");
        Assert.assertTrue("Item name is auto filled", s.equalsIgnoreCase(itemType.trim()));
    }

    public void itemCodeFieldValidation() {
        Assert.assertFalse("Item Code field is non editable", $(itemCode).isEnabled());
    }

    public void subFamilySelection(String subFamily) {
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.conditionalWait("visibility", arasSpinner, "");
        reusableUtilities.conditionalWait("invisibility", arasSpinner, "");
        reusableUtilities.conditionalWait("Visibility", newFrameForCreatePartFrame, "");
        reusableUtilities.switchFrame($(newFrameForCreatePartFrame), "", 0);
        reusableUtilities.conditionalWait("Visibility", newFrameForCreatePartFrameDataEntry, "");
        reusableUtilities.switchFrame($(newFrameForCreatePartFrameDataEntry), "", 0);
        reusableUtilities.conditionalWait("Visibility", subFamilyDropDownButton, "");
        waitABit(4000);
        reusableUtilities.performAction("", $(subFamilyDropDownButton), "");
        reusableUtilities.performAction("", $(By.xpath("//*[text()='" + subFamily.trim() + "']")), "");
        Serenity.getDriver().switchTo().parentFrame();
        if ($(confirmButton).isCurrentlyVisible()) {
            reusableUtilities.performAction("", $(confirmButton), "");
        }
        Assert.assertTrue(true);
    }

    public void subFamilySelectionForSecondTab(String subFamily) {
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.conditionalWait("visibility", arasSpinner, "");
        reusableUtilities.conditionalWait("invisibility", arasSpinner, "");
        reusableUtilities.conditionalWait("Visibility", newFrameForCreatePartFrame2, "");
        reusableUtilities.switchFrame($(newFrameForCreatePartFrame2), "", 0);
        reusableUtilities.conditionalWait("Visibility", newFrameForCreatePartFrameDataEntry, "");
        reusableUtilities.switchFrame($(newFrameForCreatePartFrameDataEntry), "", 0);
        reusableUtilities.conditionalWait("Visibility", subFamilyDropDownButton, "");
        waitABit(4000);
        reusableUtilities.performAction("", $(subFamilyDropDownButton), "");
        reusableUtilities.performAction("", $(By.xpath("//*[text()='" + subFamily.trim() + "']")), "");
        Serenity.getDriver().switchTo().parentFrame();
        if ($(confirmButton).isCurrentlyVisible()) {
            reusableUtilities.performAction("", $(confirmButton), "");
        }
        Assert.assertTrue(true);
    }

    public void mandatoryFieldCheck() {
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(newFrameForCreatePartFrame), "", 0);
        reusableUtilities.performAction("", $(saveButton), "");
    }

    public void validateErrorMessage(List<List<String>> data) {
        Serenity.getDriver().switchTo().defaultContent();
        if ($(alertMessage).isCurrentlyVisible()) {
            if (reusableUtilities.getObjectProperty($(alertMessage), "text").equalsIgnoreCase(data.get(0).get(0).trim())) {
                Assert.assertTrue("Error Message for Mandatory Fields have been shown", true);
            } else if (reusableUtilities.getObjectProperty($(alertMessage), "text").contains(data.get(0).get(0).trim())) {
                Assert.assertTrue("Error Message for Mandatory Fields have been shown", true);
            }
        } else if ($(newFrameForCreatePartFrame3).isCurrentlyVisible()) {
            reusableUtilities.switchFrame($(newFrameForCreatePartFrame3), "", 0);
            if (reusableUtilities.getObjectProperty($(alertMessage), "text").equalsIgnoreCase(data.get(0).get(0).trim())) {
                Assert.assertTrue("Error Message for Mandatory Fields have been shown", true);
            } else if (reusableUtilities.getObjectProperty($(alertMessage), "text").contains(data.get(0).get(0).trim())) {
                Assert.assertTrue("Error Message for Mandatory Fields have been shown", true);
            }
        } else if ($(newFrameForCreatePartFrame2).isCurrentlyVisible()) {
            reusableUtilities.switchFrame($(newFrameForCreatePartFrame2), "", 0);
            if (reusableUtilities.getObjectProperty($(alertMessage), "text").equalsIgnoreCase(data.get(0).get(0).trim())) {
                Assert.assertTrue("Error Message for Mandatory Fields have been shown", true);
            } else if (reusableUtilities.getObjectProperty($(alertMessage), "text").contains(data.get(0).get(0).trim())) {
                Assert.assertTrue("Error Message for Mandatory Fields have been shown", true);
            }
        } else if ($(newFrameForCreatePartFrame).isCurrentlyVisible()) {
            reusableUtilities.switchFrame($(newFrameForCreatePartFrame), "", 0);
            if (reusableUtilities.getObjectProperty($(alertMessage), "text").equalsIgnoreCase(data.get(0).get(0).trim())) {
                Assert.assertTrue("Error Message for Mandatory Fields have been shown", true);
            } else if (reusableUtilities.getObjectProperty($(alertMessage), "text").contains(data.get(0).get(0).trim())) {
                Assert.assertTrue("Error Message for Mandatory Fields have been shown", true);
            }
        }
        reusableUtilities.performAction("", $(ok), "");
    }

    public void createPart(String newDescription, String name) {
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(newFrameForCreatePartFrame), "", 0);
        reusableUtilities.performAction("", $(partTab), "");
        reusableUtilities.switchFrame($(newFrameForCreatePartFrameDataEntry), "", 0);
        reusableUtilities.performAction("Text", $(description), newDescription);
        if ($(commonNameElement).isCurrentlyVisible()) {
            reusableUtilities.performAction("Text", $(commonNameElement), name);
        } else if ($(trialNameElement).isCurrentlyVisible()) {
            reusableUtilities.performAction("Text", $(trialNameElement), name);
        }
    }

    public void createPartForSecondTab(String newDescription, String name) {
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(newFrameForCreatePartFrame2), "", 0);
        reusableUtilities.switchFrame($(newFrameForCreatePartFrameDataEntry), "", 0);
        reusableUtilities.performAction("Text", $(description), newDescription);
        if ($(commonNameElement).isCurrentlyVisible()) {
            reusableUtilities.performAction("Text", $(commonNameElement), name);
        } else if ($(trialNameElement).isCurrentlyVisible()) {
            reusableUtilities.performAction("Text", $(trialNameElement), name);
        }
        Serenity.getDriver().switchTo().defaultContent();
    }

    public void saveTheForm() {
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(newFrameForCreatePartFrame), "", 0);
        if ($(saveButton).isCurrentlyVisible()) {
            reusableUtilities.performAction("Button", $(saveButton), "");
        } else {
            Serenity.getDriver().switchTo().defaultContent();
            reusableUtilities.switchFrame($(newFrameForCreatePartFrame2), "", 0);
            if ($(saveButton).isCurrentlyVisible()) {
                $(saveButton).click();
            } else {
                Serenity.getDriver().switchTo().defaultContent();
                reusableUtilities.switchFrame($(newFrameForCreatePartFrame3), "", 0);
                $(saveButton).click();
            }
        }
        waitABit(2000);
    }

    public void saveThePart() {
        waitABit(5000);
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(newFrameForCreatePartFrame), "", 0);
        if ($(saveButton).isCurrentlyVisible()) {
            reusableUtilities.performAction("Button", $(saveButton), "");
        } else {
            Serenity.getDriver().switchTo().defaultContent();
            reusableUtilities.switchFrame($(newFrameForCreatePartFrame2), "", 0);
            reusableUtilities.performAction("Button", $(saveButton), "");
        }
        waitABit(2000);
    }

    public void saveTheFormForSecondTab() {
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(newFrameForCreatePartFrame2), "", 0);
        reusableUtilities.performAction("Button", $(doneButton), "");
        waitABit(2000);
    }

    public void editTheForm() {
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.conditionalWait("visibility", newFrameForCreatePartFrame, "");
        reusableUtilities.switchFrame($(newFrameForCreatePartFrame), "", 0);
        waitABit(4000);
        reusableUtilities.conditionalWait("visibility", editButton, "");
        reusableUtilities.performAction("Button", $(editButton), "");
    }

    public String fetchingItemCode() {
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(newFrameForCreatePartFrame), "", 0);
        reusableUtilities.switchFrame($(newFrameForCreatePartFrameDataEntry), "", 0);
        if ($(itemCode).isCurrentlyVisible()) {
            reusableUtilities.scrollToAnElement(itemCode);
            generatedItemCode = reusableUtilities.getObjectProperty($(itemCode), "value");
        } else if ($(pmiCode).isCurrentlyVisible()) {
            reusableUtilities.scrollToAnElement(pmiCode);
            generatedItemCode = reusableUtilities.getObjectProperty($(pmiCode), "value");
        } else if ($(projectCode).isCurrentlyVisible()) {
            reusableUtilities.scrollToAnElement(projectCode);
            generatedItemCode = reusableUtilities.getObjectProperty($(projectCode), "value");
        } else if ($(projectTemplateCode).isCurrentlyVisible()) {
            reusableUtilities.scrollToAnElement(projectTemplateCode);
            generatedItemCode = reusableUtilities.getObjectProperty($(projectTemplateCode), "value");
        }
        System.out.println(generatedItemCode);
        return generatedItemCode;
    }

    public String fetchingItemCodeForSecondTab() {
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(newFrameForCreatePartFrame2), "", 0);
        reusableUtilities.switchFrame($(newFrameForCreatePartFrameDataEntry), "", 0);
        if ($(itemCode).isCurrentlyVisible()) {
            generatedItemCode = reusableUtilities.getObjectProperty($(itemCode), "value");
        } else if ($(pmiCode).isCurrentlyVisible()) {
            generatedItemCode = reusableUtilities.getObjectProperty($(pmiCode), "value");
        }
        System.out.println(generatedItemCode);
        return generatedItemCode;
    }

    public void validationOfItemCodePrefix(String itemCodePrefix) {
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(newFrameForCreatePartFrame), "", 0);
        reusableUtilities.switchFrame($(newFrameForCreatePartFrameDataEntry), "", 0);
        if (generatedItemCode.startsWith(itemCodePrefix.trim())) {
            Assert.assertTrue(true);
        }
    }

    public void itemCodeShouldNotStartWith(String itemCodePrefix) {
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(newFrameForCreatePartFrame), "", 0);
        reusableUtilities.switchFrame($(newFrameForCreatePartFrameDataEntry), "", 0);
        if (reusableUtilities.getObjectProperty($(itemCode), "value").startsWith(itemCodePrefix)) {
            Assert.fail();
        }
    }

    public void validationOfStatus(String lifecycleStatus) {
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(newFrameForCreatePartFrame), "", 0);
        reusableUtilities.switchFrame($(newFrameForCreatePartFrameDataEntry), "", 0);
        String statusOfTheRequest = "";
        if ($(status1).isCurrentlyVisible()) {
            statusOfTheRequest = reusableUtilities.getObjectProperty($(status1), "value").trim();
        } else if ($(status2).isCurrentlyVisible()) {
            statusOfTheRequest = reusableUtilities.getObjectProperty($(status2), "value").trim();
        } else if ($(status3).isCurrentlyVisible()) {
            statusOfTheRequest = reusableUtilities.getValueThroughJS(status3);
        } else if ($(status4).isCurrentlyVisible()) {
            statusOfTheRequest = reusableUtilities.getObjectProperty($(status4), "text").trim();
        } else if ($(status5).isCurrentlyVisible()) {
            statusOfTheRequest = reusableUtilities.getObjectProperty($(status5), "value").trim();
        } else if ($(status6).isCurrentlyVisible()) {
            statusOfTheRequest = reusableUtilities.getObjectProperty($(status6), "value").trim();
        } else if ($(analysisPackageState).isCurrentlyVisible()) {
            statusOfTheRequest = reusableUtilities.getObjectProperty($(analysisPackageState), "Value").trim();
            System.out.println(statusOfTheRequest + "AP status");
        }
        Assert.assertTrue("Status is " + lifecycleStatus, statusOfTheRequest.equalsIgnoreCase(lifecycleStatus));
    }

    public void userCreatesAnotherPart() {
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.performAction("", $(arasButtonIcon), "");
        reusableUtilities.performAction("", $(createNewPartButton), "");
    }

    public void userValidatesGeneratedItemCode() {
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(newFrameForCreatePartFrame), "", 0);
        reusableUtilities.switchFrame($(newFrameForCreatePartFrameDataEntry), "", 0);
        String generatedItemCodeForSecondPart = reusableUtilities.getObjectProperty($(itemCode), "value");
        double d1 = Double.parseDouble(generatedItemCode);
        double d2 = Double.parseDouble(generatedItemCodeForSecondPart);
        if (d1 + 0.0001 == d2) {
            Assert.assertTrue("Item code has been generated incremental way", true);
        }
        Serenity.getDriver().switchTo().parentFrame();
        reusableUtilities.performAction("Button", $(tripleDots), "");
        waitABit(2000);
        reusableUtilities.performAction("Button", $(delete), "");
        waitABit(2000);
        reusableUtilities.performAction("Button", $(deleteAllVersions), "");
        reusableUtilities.performAction("Button", $(deletePart), "");
    }

    public void userSearchesWithItemCode() {
        waitABit(5000);
        Serenity.getDriver().switchTo().defaultContent();
        if ($(searchPartsButton).isCurrentlyVisible()) {
            reusableUtilities.performAction("", $(searchPartsButton), "");
        } else {
            reusableUtilities.performAction("", $(arasButtonIcon), "");
            reusableUtilities.performAction("", $(searchPartsButton), "");
        }
        reusableUtilities.conditionalWait("Visibility", newFrameForPartSearch, "");
        reusableUtilities.switchFrame($(newFrame), "", 0);
        reusableUtilities.conditionalWait("visibility", arasSpinner, "");
        reusableUtilities.conditionalWait("invisibility", arasSpinner, "");
        reusableUtilities.performAction("Text", $(searchFieldToSearchParts), generatedItemCode + "*");
        waitABit(3000);
        reusableUtilities.pressEnter(searchFieldToSearchParts);
    }

    public void userValidatesTheSearchResult() {
        reusableUtilities.conditionalWait("Visibility", searchResults, "");
        reusableUtilities.doubleClick(searchResults);
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.conditionalWait("Visibility", newFrameForCreatePartFrame, "");
        reusableUtilities.switchFrame($(newFrameForCreatePartFrame), "", 0);
        reusableUtilities.conditionalWait("Visibility", newFrameForCreatePartFrameDataEntry, "");
        reusableUtilities.switchFrame($(newFrameForCreatePartFrameDataEntry), "", 0);
        Assert.assertTrue("Created Part has been validated", generatedItemCode.equalsIgnoreCase(reusableUtilities.getObjectProperty($(itemCode), "value")));
        Serenity.getDriver().switchTo().defaultContent();
        $(closeButton).click();
    }

    public void userSearchesWithSubFamily(String subFamily) {
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.performAction("", $(secondTab), "");
        reusableUtilities.conditionalWait("Visibility", newFrameForPartSearch, "");
        reusableUtilities.switchFrame($(newFrame), "", 0);
        reusableUtilities.conditionalWait("visibility", arasSpinner, "");
        reusableUtilities.conditionalWait("invisibility", arasSpinner, "");
        reusableUtilities.performAction("", $(subFamilyDropDownButton), "");
        reusableUtilities.performAction("", $(By.xpath("//*[text()='" + subFamily.trim() + "']")), "");
    }

    public void userTriesToEdit(String editedDescription) {
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.performAction("", $(firstTab), "");
        reusableUtilities.switchFrame($(newFrameForCreatePartFrame), "", 0);
        reusableUtilities.performAction("", $(editButton), "");
        reusableUtilities.switchFrame($(newFrameForCreatePartFrameDataEntry), "", 0);
        $(description).clear();
        reusableUtilities.performAction("Text", $(description), editedDescription);
        Serenity.getDriver().switchTo().parentFrame();
        reusableUtilities.performAction("Button", $(doneButton), "");
    }

    public void validateChangedDescription(String editedDescription) {
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(newFrameForCreatePartFrame), "", 0);
        reusableUtilities.switchFrame($(newFrameForCreatePartFrameDataEntry), "", 0);
        String s = reusableUtilities.getObjectProperty($(description), "value");
        Assert.assertTrue("Edit is working fine", s.equalsIgnoreCase(editedDescription));
    }

    public void userTriesToDeleteThePart() {
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.performAction("", $(firstTab), "");
        reusableUtilities.switchFrame($(newFrameForCreatePartFrame), "", 0);
        reusableUtilities.performAction("Button", $(tripleDots), "");
        waitABit(2000);
        reusableUtilities.performAction("Button", $(delete), "");
        waitABit(2000);
        if ($(deleteAllVersions).isCurrentlyVisible()) {
            reusableUtilities.performAction("Button", $(deleteAllVersions), "");
        } else if ($(delete2).isCurrentlyVisible()) {
            reusableUtilities.performAction("Button", $(delete2), "");
        }
        waitABit(2000);
        reusableUtilities.performAction("Button", $(deletePart), "");
    }

    public void validateDeletedPart() {
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.performAction("", $(firstTab), "");
        reusableUtilities.switchFrame($(newFrameForFileSearch), "", 0);
        reusableUtilities.performAction("", $(searchButton), "");
        reusableUtilities.conditionalWait("invisibility", searchResults, "");
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.performAction("", $(closeButton), "");
        reusableUtilities.performAction("", $(closeButton), "");
        Assert.assertTrue(true);
    }

    public void closeBrowser() {
        Serenity.getDriver().quit();
    }

    public void userProvidesProjectCode(String code) {
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(newFrameForCreatePartFrame), "", 0);
        reusableUtilities.switchFrame($(newFrameForCreatePartFrameDataEntry), "", 0);
        reusableUtilities.conditionalWait("visibility", projectCode, "");
        $(projectCode).sendKeys(code);
    }
}
