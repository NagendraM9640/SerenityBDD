package starter.PageObjectsPages.Develop;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import starter.Utility.ReusableMethods;
import starter.Utility.ReusableUtilities;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;


public class QCS extends PageObject {

    ReusableUtilities reusableUtilities;

    ReusableMethods reusableMethods;

    public static @FindBy(xpath = "//*[@class='aras-dialog__iframe']") WebElementFacade dialogueFrame;

    public static @FindBy(xpath = "//span[@class='aras-form aras-compat-toolbar__textbox']/input") WebElementFacade classificationSelection;

    public static @FindBy(xpath = "//iframe[@class='content-block__iframe']") WebElementFacade parentFrame;

    public static @FindBy(xpath = "//iframe[@id='instance']") WebElementFacade childFrame;

    public static @FindBy(xpath = "//iframe[@title='pmi_QCSIPC_ControlParameter Relationship']") WebElementFacade controlParameterRelationshipIframe;

    public static @FindBy(xpath = "//iframe[@title='pmi_QCSIPC_ControlParameter Relationship']") WebElementFacade selectionParameterRelationshipIframe;

    public static @FindBy(xpath = "//button[@title='Save']") WebElementFacade saveButton;

    public static @FindBy(xpath = "//textarea[@name='description']") WebElementFacade descriptionFiledInQCS;

    public static @FindBy(xpath = "//input[@name='pmi_qcs_productgroup']") WebElementFacade qcsProductGroupField;

    public static @FindBy(xpath = "//iframe[@title='pmi_QCSIPC_ControlParameter Relationship']") WebElementFacade IPCControlParameterRelationshipTabIframe;

    public static @FindBy(xpath = "//iframe[@title='pmi_QCSLAB_ControlParamer Relationship']") WebElementFacade LabControlParameterRelationshipTabIframe;

    public static @FindBy(xpath = "//iframe[@title='pmi_QCSMCS_ControlParameter Relationship']") WebElementFacade McsControlParameterRelationshipTabIframe;
    public static @FindBy(xpath = "//*[@id='gridTD']/div[2]/div[1]/div/table/tr/td[3]") List<WebElementFacade> GHPResults;
    public static @FindBy(xpath = "//button[@title='Add Global Harmonized Parameters']") WebElementFacade addGHPBtn;
    public static @FindBy(xpath = "//select[@title='ItemType']") WebElementFacade itemTypeSwitch;

    public static @FindBy(xpath = "//button[@title='Clear Search Criteria']") WebElementFacade clearSearchCriteria;

    public static @FindBy(xpath = "(//*[@class='aras-grid-row-cell '])[1]") WebElementFacade searchResultsInGrid;
    public static @FindBy(xpath = "//button[@class='aras-button aras-button_primary aras-buttons-bar__button']") WebElementFacade searchOkButton;
    public static @FindBy(xpath = "//td[@data-head-id='pmi_parameter_number_D']") WebElementFacade parameterNumberSearchField;

    public static @FindBy(xpath = "//button[@title='Run Search']") WebElementFacade runSearchButton;
    public static @FindBy(xpath = "//iframe[@title='pmi_SelectionParameters Relationship']") WebElementFacade qcsSelectionParameterRelationshipTabFrame;
    public static @FindBy(xpath = "//button[@title='New Selection Parameters']") WebElementFacade addNewSelectionParametersBtn;
    public static @FindBy(xpath = "//span[@class='aras-dialog-alert__text']") WebElementFacade alertText;
    public static @FindBy(xpath = "//span[text()='OK']") WebElementFacade alertOkBtn;
    public static @FindBy(xpath = "//iframe[@title='pmi_QCSAttachments Relationship']") WebElementFacade qcsAttachmentRelationshipTab;
    public static @FindBy(xpath = "//td[@data-head-id='pmi_item_code_D']") WebElementFacade qcsItemCodeField;
    public static @FindBy(xpath = "//*[@id='pmi_itemtypeMultiList']/div//span[@class='dropdown-search']/input") WebElementFacade dropDownSearchItemType;
    public static @FindBy(xpath = "//div[@id='pmi_templateplatformMultiList']//a[@class='dropdown-clear-all']") WebElementFacade technologyPlatformDropDownClear;
    public static @FindBy(xpath = "//div[@id='pmi_itemtypeMultiList']//a[@class='dropdown-clear-all']") WebElementFacade itemTypeDropDownClear;
    public static @FindBy(xpath = "//div[@id='pmi_itemtypeMultiList']/a/span") WebElementFacade itemTypeFieldBtn;
    public static @FindBy(xpath = "//div[@id='pmi_templateplatformMultiList']/a/span") WebElementFacade technologyPlatformFieldBtn;

    public static @FindBy(xpath = "//*[text()='Done']") WebElementFacade doneButton;
    public static @FindBy(xpath = "//div[@id='pmi_templateplatformMultiList']//span[@class='dropdown-selected']") List<WebElementFacade> getTheSelectedTechnologyList;
    public static @FindBy(xpath = "//div[@id='pmi_itemtypeMultiList']//span[@class='dropdown-selected']") List<WebElementFacade> getTheSelectedItemTypeList;

    public static @FindBy(xpath = "//span[@class='aras-list-item__label' and text()='Delete']") WebElementFacade deleteButton;

    public static @FindBy(xpath = "//span[@class='aras-list-item__label' and text()='Delete All Versions']") WebElementFacade deleteAllTheVersionsButton;

    public static @FindBy(xpath = "//button[@title='More']") WebElementFacade moreActionButton;

    public static @FindBy(xpath = "//button[@class='aras-button aras-button_secondary']/span") WebElementFacade confirmDeleteButton;

    public static @FindBy(xpath = "//textarea[@name='title']") WebElementFacade titleFieldInQCSEco;

    public static @FindBy(xpath = "//textarea[@name='description']") WebElementFacade changeDescFieldInQCSEco;

    public static @FindBy(xpath = "//input[@name='pmi_reason_for_change']") WebElementFacade reasonForChangeFieldInQCSEco;

    public static @FindBy(xpath = "//iframe[@title='pmi_QcsECO_AffectedItem Relationship']") WebElementFacade qcsAffectedItemIframe;

    public static @FindBy(xpath = "//input[@name='pmi_changeqcs_type']") WebElementFacade qcsChangeTypeField;

    public static @FindBy(css = "input[name='pmi_effectivedate']") WebElementFacade effectiveDateAndTimeField;
    Actions actions = new Actions(Serenity.getDriver());

    public void userShouldSelectTheTypeOfQCSYouWantToCreate(String qcsType) {
        By partNameAsIngredient = By.xpath("//*[text()='" + qcsType.trim() + "']");
        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(dialogueFrame);
        withTimeoutOf(Duration.ofSeconds(90)).waitFor(classificationSelection).waitUntilClickable().click();
        withTimeoutOf(Duration.ofSeconds(90)).waitFor(classificationSelection).sendKeys(qcsType);
        reusableUtilities.pressEnterWithoutElement();
        waitABit(2000);
        actions.moveToElement($(partNameAsIngredient)).doubleClick().build().perform();
    }

    public void validateAttributesPresentOrNot(List<String> attributes) {
        for (String attribute : attributes) {
            Serenity.getDriver().switchTo().defaultContent().switchTo().frame(parentFrame).switchTo().frame(childFrame);
            Assert.assertTrue(attribute + ":is not present in the form", $(By.xpath("//*[text()='" + attribute + "']")).isCurrentlyVisible());
        }
    }

    public void validateFieldsInQCSTab(List<List<String>> columnData) {
        for (int i = 0; i < columnData.get(0).size(); i++) {
            Serenity.getDriver().switchTo().defaultContent().switchTo().frame(parentFrame);
            if ($(controlParameterRelationshipIframe).isCurrentlyVisible() ||
                    $(selectionParameterRelationshipIframe).isCurrentlyVisible()) {
                validateColumnPresence(columnData, i);
            }

        }
    }

    public void validateColumnPresence(List<List<String>> columnData, int columnIndex) {
        By defaultAttribute = By.xpath("//*[contains(text(),'" + columnData.get(0).get(columnIndex) + "')]");
        if ($(defaultAttribute).isCurrentlyVisible()) {
            System.out.println(columnData.get(0).get(columnIndex) + " column is present in the form");
        } else {
            Serenity.getDriver().switchTo().parentFrame();
            if ($(defaultAttribute).isCurrentlyVisible()) {
                System.out.println(columnData.get(0).get(columnIndex) + " column is present in the form");
            } else {
                System.out.println(columnData.get(0).get(columnIndex) + " column is not present in the form");
            }
        }
    }

    public void saveTheData() {
        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(parentFrame);
        withTimeoutOf(Duration.ofSeconds(90)).waitFor(saveButton).waitUntilClickable().click();
    }

    public void userProvidesDescriptionAndSelectTheTechnologyPlatformAndItemTypeAndClickOnSaveAnd(String description, String technologyPlatform, String itemType, String productGroup) {

        String[] technologyPlatformValues = technologyPlatform.split(",");
        String[] itemTypeValues = itemType.split(",");

        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(parentFrame).switchTo().frame(childFrame);
        $(descriptionFiledInQCS).sendKeys(description);
        $(qcsProductGroupField).sendKeys(productGroup);
        reusableMethods.selectMultipleTechnologyPlatforms(technologyPlatformValues);
        reusableMethods.selectMultipleItemTypes(itemTypeValues);
        saveTheData();
    }

    private void switchToRelevantControlParameterTabIframes() {
        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(parentFrame);
        if ($(IPCControlParameterRelationshipTabIframe).isCurrentlyVisible()) {
            Serenity.getDriver().switchTo().frame(IPCControlParameterRelationshipTabIframe);
        } else if ($(LabControlParameterRelationshipTabIframe).isCurrentlyVisible()) {
            Serenity.getDriver().switchTo().frame(LabControlParameterRelationshipTabIframe);
        } else if ($(McsControlParameterRelationshipTabIframe).isCurrentlyVisible()) {
            Serenity.getDriver().switchTo().frame(McsControlParameterRelationshipTabIframe);
        }
    }


    public void userShouldAddRequiredParametersToQCSControlParameterTab() {
        switchToRelevantControlParameterTabIframes();
        reusableMethods.waitUntilElementVisible(addGHPBtn).click();
        Serenity.getDriver().switchTo().parentFrame().switchTo().frame(dialogueFrame);
        withTimeoutOf(Duration.ofSeconds(100)).waitFor(itemTypeSwitch).selectByVisibleText("Global Harmonized Parameter");
        reusableMethods.waitUntilElementVisible(clearSearchCriteria).click();
        reusableMethods.waitUntilElementVisible(parameterNumberSearchField).click();
        waitABit(2000);
        $(Serenity.getDriver().switchTo().activeElement()).type("N*");
        waitABit(2000);
        IntStream.rangeClosed(1, 11)
                .forEach(i -> {
                    Serenity.getDriver().switchTo().activeElement().sendKeys(Keys.TAB);
                    waitABit(1000);
                });
        waitABit(2000);
        $(Serenity.getDriver().switchTo().activeElement()).type("Released");
        waitABit(2000);
        reusableMethods.waitUntilElementVisible(runSearchButton).click();
        reusableMethods.waitUntilElementVisible(searchResultsInGrid).click();
        GHPResults.stream().skip(1).forEach(partNum -> actions.keyDown(Keys.CONTROL).click(partNum).keyUp(Keys.CONTROL).build().perform());
        reusableMethods.waitUntilElementVisible(searchOkButton).click();
        saveTheData();
    }

    public void userShouldAddCriteriaOnSelectionParametersTab() {
        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(parentFrame).switchTo().frame(qcsSelectionParameterRelationshipTabFrame);
        reusableMethods.waitUntilElementVisible(addNewSelectionParametersBtn).click();
        waitABit(3000);
        $(By.xpath("//li[@class='aras-list-item aras-list-item_shown']/label[text()[normalize-space()='Sub Family']]")).click();
        waitABit(2000);
        $(By.xpath("//li[@class='aras-list-item aras-list-item_shown']/label[text()[normalize-space()='Item Type']]")).click();
        Serenity.getDriver().switchTo().parentFrame();
        $(saveButton).click();
        String alterValue = $(alertText).getText().toString();
        String expectedValue = "Item Type,Sub Family is mandatory if the selected criteria is Item Type,Sub Family.Please select the value to proceed further.";
        System.out.println(alterValue + "AlterValue");
        Assert.assertTrue("Validation message is displaying", alterValue.equalsIgnoreCase(expectedValue));
        waitABit(2000);
        $(alertOkBtn).click();
        Serenity.getDriver().switchTo().frame(qcsSelectionParameterRelationshipTabFrame);
        $(By.xpath("//li[@class='aras-list-item aras-list-item_shown']/label[text()[normalize-space()='Adhesive - 80']]")).click();
        waitABit(2000);
        $(By.xpath("//li[@class='aras-list-item aras-list-item_shown']/label[text()[normalize-space()='Liquid - LIQ']]")).click();
    }

    public void validateAttachmentsCanBeAddedOrRemovedFromTheAttachmentTab() {
        reusableMethods.validateAddingAndRemovingAttachments(qcsAttachmentRelationshipTab);
    }

    public void searchItemsFromSearchSection(String qcsItemCode) {
        reusableMethods.searchItemByCode(qcsItemCodeField, qcsItemCode);
    }

    public void updateDescriptionAndSelectAttributes(String description, String technologyPlatform, String itemType, String productGroup) {
        String[] technologyPlatformValues = technologyPlatform.split(",");
        String[] itemTypeValues = itemType.split(",");
        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(parentFrame).switchTo().frame(childFrame);
        $(descriptionFiledInQCS).waitUntilClickable().clear();
        $(descriptionFiledInQCS).sendKeys(description);
        String productGroupName = $(qcsProductGroupField).getValue().trim();
        reusableMethods.clearMultiListAndUpdateWithNewList("technologyPlatforms", technologyPlatformValues, technologyPlatformDropDownClear, technologyPlatformFieldBtn);
        reusableMethods.clearMultiListAndUpdateWithNewList("itemTypes", itemTypeValues, itemTypeDropDownClear, itemTypeFieldBtn);
        for (int i = 0; i < productGroupName.length(); i++) $(qcsProductGroupField).sendKeys(Keys.BACK_SPACE);
        $(qcsProductGroupField).sendKeys(productGroup);
        Serenity.getDriver().switchTo().parentFrame();
        $(doneButton).click();
    }

    public void validateUpdatedAttributesOrProperties(String description, String technologyPlatform, String itemType) {
        String[] technologyPlatformValues = technologyPlatform.split(",");
        String[] itemTypeValues = itemType.split(",");
        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(parentFrame).switchTo().frame(childFrame);
        String descText = $(descriptionFiledInQCS).getValue().trim();
        Assert.assertTrue("Description is not updated", descText.equalsIgnoreCase(description));
        reusableMethods.validateSelectedValues(getTheSelectedTechnologyList, technologyPlatformValues, "technologyPlatformValues");
        reusableMethods.validateSelectedValues(getTheSelectedItemTypeList, itemTypeValues, "itemTypeValues");
    }

    public void DeleteAllTheVersionsOfItem() {
        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(parentFrame);
        reusableMethods.waitUntilElementVisible(moreActionButton).click();
        reusableMethods.waitUntilElementVisible(deleteButton).click();
        waitABit(3000);
        reusableMethods.waitUntilElementVisible(deleteAllTheVersionsButton).click();
        waitABit(2000);
        reusableMethods.waitUntilElementVisible(confirmDeleteButton).click();
    }

    public void userFillAllMandatoryFieldsInQCSECO(String title, String changeDesc, String reasonForChange, String qcsChangeType) {
        String effectiveDate = "2/03/2025 02:20:00 AM";
        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(parentFrame).switchTo().frame(childFrame);
        reusableMethods.waitUntilElementVisible(titleFieldInQCSEco).waitUntilClickable().sendKeys(title);
        $(changeDescFieldInQCSEco).sendKeys(changeDesc);
        $(reasonForChangeFieldInQCSEco).sendKeys(reasonForChange);
        $(qcsChangeTypeField).sendKeys(qcsChangeType);
        $(effectiveDateAndTimeField).sendKeys(effectiveDate);
        saveTheData();
    }


}
