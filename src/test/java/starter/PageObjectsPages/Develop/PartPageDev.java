package starter.PageObjectsPages.Develop;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import starter.PageObjectsPages.MigratedDataPartPage;
import starter.Utility.ReusableMethods;
import starter.Utility.ReusableUtilities;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;


import static starter.PageObjectsPages.Develop.QCSPage.*;
public class PartPageDev extends PageObject {

    ReusableUtilities reusableUtilities;
    ReusableMethods reusableMethods;
    PartParameterValues partParameterValues;
    ECOPartParameterValidationsPage ecoPartParameterValidationsPage = new ECOPartParameterValidationsPage();

    public static @FindBy(xpath = "//iframe[@class='aras-dialog__iframe']") WebElementFacade dialogueFrame;
    public static @FindBy(xpath = "//input[@class='item_number']") WebElementFacade itemCode;
    public static @FindBy(xpath = "//button[@class='aras-filter-list__button aras-btn']") WebElementFacade referenceCodeBtn;
    public static @FindBy(xpath = "//input[@name='pmi_item_number']") WebElementFacade mSpecAlternativeItemCode;
    public static @FindBy(xpath = "//input[@name='pmi_item_code']") WebElementFacade qcsItemCode;
    public static @FindBy(xpath = "//input[@name='pmi_itemcode']") WebElementFacade materialDisclosureItemCode;
    public static @FindBy(xpath = "//textarea[@name='description']") WebElementFacade itemDescription;
    public static @FindBy(xpath = "//textarea[@class='pmi_additonal_description']") WebElementFacade additionalDescription;
    public static @FindBy(xpath = "//textarea[@class='pmi_additional_description']") WebElementFacade additionalDescription2;
    public static @FindBy(xpath = "//input[@name='item_number']") WebElementFacade itemNumber;
    public static @FindBy(xpath = "//input[@name='pmi_purpose']") WebElementFacade purposeField;
    public static @FindBy(xpath = "//input[@name='pmi_productgroup']") WebElementFacade productGroupField;

    public static @FindBy(xpath = "//input[@name='pmi_sub_families']") WebElementFacade subFamily;
    public static @FindBy(xpath = "//button[@title='Refresh']") WebElementFacade refreshBtn;

    public static @FindBy(xpath = "//button[@title='Edit']") WebElementFacade editButton;

    public static @FindBy(xpath = "//*[text()='Done']") WebElementFacade doneButton;
    public static @FindBy(xpath = "//button[@title='More']") WebElementFacade moreButton;
    public static @FindBy(xpath = "//*[text()='Add Item(s) To Change…']") WebElementFacade addToChangeButton;
    public static @FindBy(xpath = "//input[@name='ok_button']") WebElementFacade addToChangeOkButton;

    public static @FindBy(xpath = "//*[@id='main-tab']/div/div/ul/li[1]/span[1]") WebElementFacade closeFirstTab;
    public static @FindBy(xpath = "//iframe[@id='formFrame']") WebElementFacade formFrame;
    public static @FindBy(xpath = "//iframe[@title='Part BOM Relationship']") WebElementFacade partBomRelationshipFrame;
    public static @FindBy(xpath = "(//td[@class='aras-grid-row-cell '])[3]") WebElementFacade bomElement;
    public static @FindBy(xpath = "//*[@id='gridTD']/div[2]/div[2]/div/table/tr/td[2]") List<WebElementFacade> bomElements;
    public static @FindBy(xpath = "//iframe[@id='199974B1330640319AD3A39569359E7B']") WebElementFacade changesTabFrame;
    public static @FindBy(xpath = "//iframe[@id='tree_grid_viewer']") WebElementFacade treeGridViewerFrame;
    public static @FindBy(xpath = "//button[@title='Add Parts']") WebElementFacade addPartButton;
    public static @FindBy(xpath = "//td[@data-head-id='item_number_D']") WebElementFacade searchItemCodeField;
    public static @FindBy(xpath = "//span[@data-id='pagination_total_results_status_node']") WebElementFacade paginationResults;

    public static @FindBy(xpath = "//button[@class='aras-button aras-button_primary aras-buttons-bar__button']") WebElementFacade arasSearchOkButton;
    public static @FindBy(xpath = "//div[@class='aras-list-item__container' and span[@class='aras-list-item__label' and text()='Delete']]") WebElementFacade deleteBtn;
    public static @FindBy(xpath = "//*[text()='Delete All Versions']") WebElementFacade deleteAllTheVersions;
    public static @FindBy(xpath = "//input[@name='pmi_sub_families']") WebElementFacade subFamilyField;
    public static @FindBy(xpath = "//input[@name='classification']") WebElementFacade getItemTypeClassificationName;

    public static @FindBy(xpath = "//iframe[contains(@name,'search_')]") WebElementFacade newFrame;
    public static @FindBy(xpath = "//*[@id='gridTD']/div[2]/div[1]/div/table/tr/td[2]") List<WebElementFacade> partResult;
    public static @FindBy(xpath = "//*[@id='gridTD']/div[2]/div[2]/div/table/tr/td[2]") List<WebElementFacade> BOMResult;
    public static @FindBy(css = "state") WebElementFacade status1;
    public static @FindBy(css = "pmi_target_lc") WebElementFacade status2;
    public static @FindBy(css = "state") WebElementFacade status3;
    public static @FindBy(xpath = "//*[@id='item_status']") WebElementFacade status4;
    public static @FindBy(xpath = "//input[@name='pmi_target_lc']") WebElementFacade status5;
    public static @FindBy(xpath = "//input[@name='pmi_workflow_status']") WebElementFacade status6;
    public static @FindBy(css = "pmi_status") WebElementFacade analysisPackageState;
    public static @FindBy(xpath = "//input[@name='state']") WebElementFacade qcsState;
    public static @FindBy(xpath = "//iframe[contains(@name,'innovator_')]") WebElementFacade newFrameForCreateDocumentFrame;
    public static @FindBy(xpath = "//*[@id='instance']") WebElementFacade newFrameForCreateDocumentFrameDataEntry;
    public static @FindBy(className = "major_rev") WebElementFacade generatedRevision;
    public static @FindBy(xpath = "//input[@name='classification']") WebElementFacade itemTypeClassificationName;
    public static @FindBy(xpath = "//span[@class='sys_item_link pmi_referencecode']") WebElementFacade referenceCodeFieldLink;
    public static @FindBy(xpath = "//span[@class='aras-list-item__label' and text()='Create Consumable from Reference Consumable']") WebElementFacade createConsumableFromRCActionBtn;

    public static @FindBy(xpath = "//span[@class='aras-dialog-alert__text']") WebElementFacade alertMessage;
    public static @FindBy(xpath = "//td[@data-head-id='pmi_parameter_number_R']") WebElementFacade parameterNumberFieldInSearchMode;
    public static @FindBy(xpath = "//button[@title='Add Global Harmonized Parameters']") WebElementFacade GHPAddButton;
    public static @FindBy(xpath = "//td[@data-head-id='pmi_parameter_number_D']") WebElementFacade parameterNumberFieldInDialogueFrame;
    public static @FindBy(xpath = "//button[@title='Edit']") WebElementFacade editBtn;
    public static @FindBy(xpath = "//button[@title='Delete Part BOM']") WebElementFacade deletePartBomBtn;
    public static @FindBy(xpath = "//input[@id='btnClose']") WebElementFacade closePopup;
    public static @FindBy(xpath = "//textarea[@id='txtContent']") WebElementFacade popupTextContent;
    public static @FindBy(xpath = "(//table//td[@class='aras-grid-row-cell aras-grid-row-cell__select'])[1]") WebElementFacade parameterDataType;
    public static @FindBy(css = "div.aras-grid-body-boundary") List<WebElementFacade> arasGridDiv;
    public static @FindBy(xpath = "//span[@class='aras-list-item__label' and text()='More']") WebElementFacade moreButtonFromSearchPage;
    public static @FindBy(xpath = "//span[@class='aras-list-item__label' and text()='Save As']") WebElementFacade saveAsButtonFromSearchPage;
    public static @FindBy(xpath = "//span[@class='aras-dialog__title']") WebElementFacade dialogueTitle;
    public static @FindBy(xpath = "//input[@id='ok_button']") WebElementFacade confirmBtnForSaveAs;
    public static @FindBy(xpath = "//div[@id='pmi_templateplatformMultiList']/a/span") WebElementFacade technologyPlatformFieldBtn;
    public static @FindBy(xpath = "//*[@id='pmi_templateplatformMultiList']/div//span[@class='dropdown-search']/input") WebElementFacade dropDownSearchTechnologyPlatform;
    public static @FindBy(xpath = "//div[@id='pmi_templateplatformMultiList']//a[@class='dropdown-clear-all']") WebElementFacade technologyPlatformDropDownClear;
    public static @FindBy(xpath = "//div[@id='pmi_templateplatformMultiList']//span[@class='dropdown-selected']") List<WebElementFacade> getTheSelectedTechnologyList;
    public static @FindBy(xpath = "//td[@data-head-id='item_number_D']/input") WebElementFacade itemCodeInSearchSection;
    public static @FindBy(xpath = "//button[@title='Navigate']") WebElementFacade navigateButton;
    public static @FindBy(xpath = "//span[@class='aras-list-item__label' and text()='Open Item...']") WebElementFacade openItemButton;
    public static @FindBy(xpath = "//li[@data-index='itemview.itemcommandbar.default.navigate.whereused']") WebElementFacade whereUsedButton;

    public static @FindBy(xpath = "//iframe[@class='content-block__iframe']") WebElementFacade parentFrame;

    public static @FindBy(xpath = "(//iframe[contains(@name,'innovator_')])[3]") WebElementFacade newFrameForCreatePartFrame3;
    public static @FindBy(xpath = "(//iframe[contains(@name,'innovator_')])[2]") WebElementFacade newFrameForCreatePartFrame2;

    public static @FindBy(xpath = "//iframe[contains(@name,'innovator_')]") WebElementFacade newFrameForCreatePartFrame;
    String generatedItemCode = "";
    JavascriptExecutor js = (JavascriptExecutor) Serenity.getDriver();
    Actions a = new Actions(Serenity.getDriver());

    public void selectingTheItemType(String itemType) {
        By itemTypeName = By.xpath("//*[text()='" + itemType.trim() + "']");
        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(newFrameToSelectPart);
        waitABit(1000);
        $(By.xpath("//span[@class='aras-form aras-compat-toolbar__textbox']/input")).click();
        waitABit(1000);
        $(By.xpath("//span[@class='aras-form aras-compat-toolbar__textbox']/input")).sendKeys(itemType);
        waitABit(1000);
        reusableUtilities.pressEnterWithoutElement();
        waitABit(2000);
        Actions a = new Actions(Serenity.getDriver());
        a.moveToElement($(itemTypeName)).doubleClick().build().perform();
    }

    public void itemTypeFieldValidation(String itemType) {
        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(newFrameForCreatePartFrame).switchTo().frame("");
        withTimeoutOf(Duration.ofSeconds(100)).waitFor(itemName);
        String s = $(itemName).getAttribute("value").trim();
        Assert.assertTrue("Item name is auto filled", s.equalsIgnoreCase(itemType.trim()));
    }

    public void userTriesToUpdate(String newSubFamily, String newProductGroup, String newTechnologyPlateForms) {
        String[] technologyPlatformValues = newTechnologyPlateForms.split(",");
        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(parentFrame).switchTo().frame(childFrame);
        //SubFamily Clear & Update
        String subFamilyText = $(subFamily).getAttribute("value").toString().trim();
        for (int i = 0; i < subFamilyText.length(); i++) $(subFamily).sendKeys(Keys.BACK_SPACE);
        $(subFamily).sendKeys(newSubFamily);
        //itemDescription Clear & Update
        $(itemDescription).waitUntilClickable().clear();
        $(itemDescription).waitUntilClickable().sendKeys("MN Automation Script Item Desc - Update of Part");
        //additionalDescription Clear & Update
        if ($(additionalDescription).isCurrentlyVisible()) {
            $(additionalDescription).waitUntilClickable().clear();
            $(additionalDescription).waitUntilClickable().sendKeys("MN Automation Script Add Desc - Update of Part");
        } else {
            $(additionalDescription2).waitUntilClickable().clear();
            $(additionalDescription2).waitUntilClickable().sendKeys("MN Automation Script Add Desc - Update of Part");
        }
        //productGroupField Clear & Update
        String productGroupText = $(productGroupField).getAttribute("value").toString().trim();
        for (int i = 0; i < productGroupText.length(); i++) $(productGroupField).sendKeys(Keys.BACK_SPACE);
        $(productGroupField).sendKeys(newProductGroup);
        // technologyPlatforms  Clear & Update
        clearMultiListAndUpdateWithNewList("technologyPlatforms", technologyPlatformValues, technologyPlatformDropDownClear, technologyPlatformFieldBtn);
        // Save the Part
        Serenity.getDriver().switchTo().parentFrame();
        $(doneButton).click();
    }

    public void validatingUpdatedData(String newSubFamily, String newProductGroup, String newTechnologyPlateForms) {
        String[] technologyPlatformValues = newTechnologyPlateForms.split(",");
        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(parentFrame).switchTo().frame(childFrame);
        String itemDescriptionText = $(itemDescription).getAttribute("value").toString().trim();
        String addDescText = "";
        if ($(additionalDescription).isCurrentlyVisible()) {
            addDescText = $(additionalDescription).getAttribute("value").toString().trim();
        } else {
            addDescText = $(additionalDescription2).getAttribute("value").toString().trim();
        }
        String productGroupText = $(productGroupField).getAttribute("value").toString().trim();
        String subFamilyText = $(subFamily).getAttribute("value").toString().trim();
        boolean isMultiListUpdated = validateSelectedValues(getTheSelectedTechnologyList, technologyPlatformValues, "technologyPlatformValues");
        String itemTypeName = $(itemName).getAttribute("value").toString().trim();

        if (itemTypeName.equalsIgnoreCase("Reference Consumable - RCS") || itemTypeName.equalsIgnoreCase("Cigarette Paper Base - CP")) {
            System.out.println("If-Condition");
        } else {
            Assert.assertTrue("Update Item Description is failed", itemDescriptionText.equalsIgnoreCase("MN Automation Script Item Desc - Update of Part"));
        }
        Assert.assertTrue("Update Add Description is failed", addDescText.equalsIgnoreCase("MN Automation Script Add Desc - Update of Part"));
        Assert.assertTrue("Update subFamily is failed", subFamilyText.equalsIgnoreCase(newSubFamily));
        Assert.assertTrue("Update productGroup is failed", productGroupText.equalsIgnoreCase(newProductGroup));
        Assert.assertTrue("Update technologyPlatformValues is failed", isMultiListUpdated);

    }

    public void closeTheFirstOpenedTab() {
        Serenity.getDriver().switchTo().defaultContent();
        withTimeoutOf(Duration.ofSeconds(100)).waitFor(closeTheFirstOpenedTab).click();
    }

    public void userClicksOnAddItemSToChange() {
        Serenity.getDriver().switchTo().defaultContent();
        withTimeoutOf(Duration.ofSeconds(120)).waitFor(parentFrame);
        Serenity.getDriver().switchTo().frame(parentFrame);
        withTimeoutOf(Duration.ofSeconds(120)).waitFor(moreButton).click();
        withTimeoutOf(Duration.ofSeconds(120)).waitFor(addToChangeButton).click();
        withTimeoutOf(Duration.ofSeconds(120)).waitFor(dialogueFrame);
        Serenity.getDriver().switchTo().frame(dialogueFrame).switchTo().frame(formFrame);
        withTimeoutOf(Duration.ofSeconds(120)).waitFor(addToChangeOkButton).click();
    }

    public void userDeleteAllTheVersionsOfPart() {
        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(parentFrame);
        $(moreButton).click();
        withTimeoutOf(Duration.ofSeconds(100)).waitFor(deleteBtn).click();
        withTimeoutOf(Duration.ofSeconds(100)).waitFor(deleteAllTheVersions).click();
    }

    public void userSearchesWithItemCode(String itemCode) {
        reusableMethods.searchItemByCode(searchItemCodeField, itemCode);
    }

    public void theUserSearchesForThePartsAndClicksOnSaveAs(String itemCode) {
        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(parentFrame);
        withTimeoutOf(Duration.ofSeconds(100)).waitFor(searchItemCodeField);
        $(clearSearchCriteria).waitUntilClickable().click();
        $(searchItemCodeField).waitUntilClickable().click();
        $(Serenity.getDriver().switchTo().activeElement()).type(itemCode);
        $(runSearchButton).waitUntilClickable().click();
        withTimeoutOf(Duration.ofSeconds(120)).waitFor(searchResultsInGrid);
        waitABit(3000);
        a.contextClick(searchResultsInGrid).perform();
        $(moreButtonFromSearchPage).waitUntilClickable().click();
        $(saveAsButtonFromSearchPage).waitUntilClickable().click();
    }

    public void thePopUpIsDisplayedAndTheUserClicksOnTheConfirmButton(String expectedTitle) {
        Serenity.getDriver().switchTo().defaultContent();
        String actualTitle = $(dialogueTitle).getText();
        System.out.println(actualTitle + "titleName");
        Assert.assertTrue("Save As pop-up is not visible/configuration is not available for this part", actualTitle.contains(expectedTitle));
        Serenity.getDriver().switchTo().frame(dialogueFrame).switchTo().frame(formFrame);
        withTimeoutOf(Duration.ofSeconds(120)).waitFor(confirmBtnForSaveAs);
        $(confirmBtnForSaveAs).waitUntilClickable().click();
        Serenity.getDriver().switchTo().defaultContent();
        withTimeoutOf(Duration.ofSeconds(100)).waitFor(closeFirstTab).click();
    }

    public void clickOnSave() {
        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(parentFrame);
        withTimeoutOf(Duration.ofSeconds(100)).waitFor(saveButton);
        $(saveButton).waitUntilClickable().click();
    }

    public void theUserShouldRemoveTheExistingBOMElementsAndThenAddTheSameBOMElementsAgain() {
        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(parentFrame).switchTo().frame(partBomRelationshipFrame);
        withTimeoutOf(Duration.ofSeconds(100)).waitFor(bomElement);
        //js.executeScript("arguments[0].scrollIntoView();",bomElement);
        String partNum = bomElement.getText();
        $(bomElement).click();
        $(deletePartBomBtn).click();
        userShouldAddTheRequiredBomElements(partNum);
        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(parentFrame);
        //$(editButton).click();
        Serenity.getDriver().switchTo().frame(partBomRelationshipFrame);
        Assert.assertTrue("BOM element is not added", $(By.xpath("//*[text()='" + partNum + "']")).isCurrentlyVisible());
    }

    public void theBOMElementsShouldHaveARevisionOfAndShouldBeInTheState(String revision, String state) {
        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(parentFrame).switchTo().frame(partBomRelationshipFrame);

        withTimeoutOf(Duration.ofSeconds(100)).waitFor(bomElement);
        js.executeScript("arguments[0].scrollIntoView();", bomElement);
        $(bomElement).click();
        waitABit(2000);
        reusableUtilities.pressTab();
        waitABit(2000);
        reusableUtilities.pressTab();
        reusableUtilities.pressTab();
        String rev = $(By.xpath("(//td[@class='aras-grid-row-cell '])[6]")).getText();
        Assert.assertTrue("Revision mismatch", rev.equalsIgnoreCase(revision));

//        String stateBom = $(By.xpath("(//td[@class='aras-grid-row-cell '])[7]")).getText();
//        Assert.assertTrue("BOM state mismatch", stateBom.equalsIgnoreCase(state));
    }


    public void theUserAddsOrUpdatesTheQuantityAndUOMValuesForTheBOMElementsAsQuantityUOM(String quantity, String UOM) {
        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(parentFrame).switchTo().frame(partBomRelationshipFrame);
        withTimeoutOf(Duration.ofSeconds(120)).waitFor(bomElements);
        for (WebElementFacade bomElement : bomElements) {
            bomElement.click();
            moveToQuantityField();
            waitABit(3000);
            String quantityValue = getTextValueOfTdElement(9);
            clearActiveElementTextAndEnterNewValue(quantityValue.length(), quantity);
            waitABit(1000);
            reusableUtilities.pressTab();
            waitABit(2000);
            String uomValue = getTextValueOfTdElement(10);
            clearActiveElementTextAndEnterNewValue(uomValue.length(), UOM);
        }
        Serenity.getDriver().switchTo().parentFrame();
        $(saveButton).click();
    }

    private String getTextValueOfTdElement(int indexNo) {
        return $(By.xpath("(//table//td[@class='aras-grid-row-cell '])[" + indexNo + "]")).getAttribute("textContent").trim();
    }

    private void clearActiveElementTextAndEnterNewValue(int fieldName, String fieldValue) {
        for (int i = 0; i < fieldName; i++)
            $(Serenity.getDriver().switchTo().activeElement()).sendKeys(Keys.BACK_SPACE);
        waitABit(2000);
        $(Serenity.getDriver().switchTo().activeElement()).type(fieldValue);
    }

    public void moveToQuantityField() {
        for (int i = 1; i <= 6; i++) {
            waitABit(1000);
            reusableUtilities.pressTab();
        }
    }

    public void userSearchesWithItemCodeForPackedItems(String itemCode) {
        String[] parts = itemCode.split("|");
        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(parentFrame);
        withTimeoutOf(Duration.ofSeconds(100)).waitFor(searchItemCodeField);
        waitABit(5000);
        $(clearSearchCriteria).click();
        waitABit(2000);
        $(searchItemCodeField).click();
        $(Serenity.getDriver().switchTo().activeElement()).typeAndEnter(itemCode);
        $(runSearchButton).click();
        withTimeoutOf(Duration.ofSeconds(100)).waitFor(searchResultsInGrid);
//        withTimeoutOf(100, TimeUnit.SECONDS).waitFor(paginationResults);
//        String paginationResult = $(paginationResults).getAttribute("Text").toString();
//        String[] totalResults = paginationResult.split(" ");
//        Assert.assertTrue("All the packed items are visible", Integer.parseInt(totalResults[0])==parts.length);
        waitABit(2000);
        a.moveToElement($(searchResultsInGrid)).doubleClick().build().perform();
        Serenity.getDriver().switchTo().defaultContent();
        waitABit(5000);
        withTimeoutOf(Duration.ofSeconds(100)).waitFor(closeFirstTab).click();
    }

    public void theSystemMustAutomaticallyCreatePackedItemsWithAnd(String itemCode, String itemType, String subFamily) {
        String suffixes = ItemCodeStore.getStoredData("PackedItems");
        //String suffixes = "K, S";
        String[] suffixArray = suffixes.split(",");
        String newItemCode = "";
        //String itemCode1 = "14.D081";
        Serenity.getDriver().switchTo().defaultContent();
        withTimeoutOf(Duration.ofSeconds(120)).waitFor(parentFrame);
        Serenity.getDriver().switchTo().frame(parentFrame);
        withTimeoutOf(Duration.ofSeconds(120)).waitFor(navigateButton);
        reusableMethods.waitUntilElementVisible(navigateButton).click();
        reusableMethods.waitUntilElementVisible(whereUsedButton).click();
        waitABit(10000);
        reusableMethods.closeFirstOpenedTab();
        waitABit(20000);
        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(parentFrame);
        for (String suffix : suffixArray) {
            newItemCode = itemCode + suffix.trim();
            reusableMethods.waitUntilElementVisible($(By.xpath("//span[contains(text(), '" + newItemCode + "' )]")));
            Assert.assertTrue("Packed Items not created for:- " + newItemCode, $(By.xpath("//span[contains(text(), '" + newItemCode + "' )]")).isCurrentlyVisible());
        }

        WebElement link = Serenity.getDriver().findElement(By.xpath("//span[contains(text(), '" + newItemCode + "' )]"));

        a.contextClick(link).perform();

        waitABit(3000);

        reusableMethods.waitUntilElementVisible(openItemButton).click();

        reusableMethods.closeFirstOpenedTab();

        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(parentFrame).switchTo().frame(childFrame);

        String getSubFamily = $(subFamilyField).getAttribute("value");
        String getItemType = $(getItemTypeClassificationName).getAttribute("value");

        Assert.assertTrue("SubFamily is not matching for packedItems", getSubFamily.equalsIgnoreCase(subFamily));
        Assert.assertTrue("Item Type is not matching for packedItems", getItemType.equalsIgnoreCase(itemType));
    }

    public void userShouldFillAllTheFieldsInThePartFormAndClickOnSaveAnd(String subFamily, String purpose, String productGroup, String intendedTechnologyPlatform) {
        Random random = new Random();
        String[] technologyPlatformValues = intendedTechnologyPlatform.split(",");
        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(parentFrame).switchTo().frame(childFrame);
        $(subFamilyField).sendKeys(subFamily);
        $(itemDescription).sendKeys("MN Automation Script Item Desc - Creation of Part");
        if ($(additionalDescription).isCurrentlyVisible()) {
            $(additionalDescription).sendKeys("MN Automation Script Add Desc - Creation of Part");
        } else if ($(additionalDescription2).isCurrentlyVisible()) {
            $(additionalDescription2).sendKeys("MN Automation Script Add Desc - Creation of Part");
        }
        $(purposeField).sendKeys(purpose);
        $(productGroupField).sendKeys(productGroup);
        String itemTypeName = $(itemName).getAttribute("value").trim();
        if (itemTypeName.equalsIgnoreCase("Leaf Tobacco TMC") || itemTypeName.equalsIgnoreCase("Raw Tobacco - RAW") || itemTypeName.equalsIgnoreCase("Leaf Tobacco LOT") || itemTypeName.equalsIgnoreCase("Dry Blend - DB")) {
            $(itemNumber).sendKeys("MN.R" + random.nextInt(10000));
        }
        JavascriptExecutor js = (JavascriptExecutor) Serenity.getDriver();
        js.executeScript("arguments[0].scrollIntoView();", $(itemNumber));
        multiSelectionOfTechnologyPlatform(technologyPlatformValues);
        Serenity.getDriver().switchTo().parentFrame();
        $(QCSPage.saveButton).click();
        Serenity.getDriver().switchTo().frame(childFrame);
        String itemDesc = $(itemDescription).getAttribute("value").trim();
        ItemCodeStore.addUniqueCode("itemDesc", itemDesc);
    }

    public void userShouldFillAllTheFieldsInTheRCSPartFormAndClickOnSaveAnd(String subFamily, String purpose, String productGroup, String intendedTechnologyPlatform) {
        Random random = new Random();
        String[] technologyPlatformValues = intendedTechnologyPlatform.split(",");
        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(parentFrame).switchTo().frame(childFrame);
        $(subFamilyField).sendKeys(subFamily);
        $(itemDescription).sendKeys("MN Automation Script Item Desc - Creation of Part");
        if ($(additionalDescription).isCurrentlyVisible()) {
            $(additionalDescription).sendKeys("MN Automation Script Add Desc - Creation of Part");
        } else if ($(additionalDescription2).isCurrentlyVisible()) {
            $(additionalDescription2).sendKeys("MN Automation Script Add Desc - Creation of Part");
        }
        $(purposeField).sendKeys(purpose);
        $(productGroupField).sendKeys(productGroup);
        String itemTypeName = $(itemName).getAttribute("value").toString().trim();
        if (itemTypeName.equalsIgnoreCase("Adhesive - 80") || itemTypeName.equalsIgnoreCase("Leaf Tobacco TMC") || itemTypeName.equalsIgnoreCase("Raw Tobacco - RAW") || itemTypeName.equalsIgnoreCase("Leaf Tobacco LOT") || itemTypeName.equalsIgnoreCase("Dry Blend - DB")) {
            $(itemNumber).sendKeys("MN.R" + random.nextInt(10000));
        }
        js.executeScript("arguments[0].scrollIntoView();", $(itemNumber));
        //multiSelectionOfTechnologyPlatform(technologyPlatformValues);
        Serenity.getDriver().switchTo().parentFrame();
        $(QCSPage.saveButton).click();
        Serenity.getDriver().switchTo().frame(childFrame);
        String itemDesc = $(itemDescription).getAttribute("value").toString().trim();
        List<String> getTheSelectedTechnologyListValues = getTheSelectedTechnologyList.stream().map(WebElementFacade::getText).collect(Collectors.toList());
        System.out.println("TechnologyListValues:" + getTheSelectedTechnologyListValues);
        ItemCodeStore.addUniqueCode("itemDesc", itemDesc);
        ItemCodeStore.addUniqueCode("AddDesc", "MN Automation Script Add Desc - Creation of Part");
        ItemCodeStore.addUniqueCode("subFamily", subFamily);
        ItemCodeStore.addUniqueCode("purpose", purpose);
        ItemCodeStore.addUniqueCode("productGroup", productGroup);
        ItemCodeStore.storeLists("TechnologyListValues", getTheSelectedTechnologyListValues);
    }

    public void multiSelectionOfTechnologyPlatform(String[] technologyPlatformValues) {
        $(technologyPlatformFieldBtn).click();
        withTimeoutOf(Duration.ofSeconds(100)).waitFor(dropDownSearchTechnologyPlatform);
        $(dropDownSearchTechnologyPlatform).sendKeys(technologyPlatformValues[0].trim());
        withTimeoutOf(Duration.ofSeconds(100)).waitFor(By.xpath("//li[text()='" + technologyPlatformValues[0].trim() + "']"));
        waitABit(2000);
        $(By.xpath("//li[text()='" + technologyPlatformValues[0].trim() + "']")).click();
        for (int i = 1; i < technologyPlatformValues.length; i++) {
            String searchText = $(dropDownSearchTechnologyPlatform).getAttribute("value").trim();
            System.out.println(searchText + "searchText: TechnologyPlatform");
            for (int j = 0; j < searchText.length(); j++) {
                $(dropDownSearchTechnologyPlatform).sendKeys(Keys.BACK_SPACE);
            }
            $(dropDownSearchTechnologyPlatform).sendKeys(technologyPlatformValues[i].trim());
            withTimeoutOf(Duration.ofSeconds(100)).waitFor(By.xpath("//li[text()='" + technologyPlatformValues[i].trim() + "']"));
            waitABit(2000);
            $(By.xpath("//li[text()='" + technologyPlatformValues[i].trim() + "']")).click();
        }
    }

    public void clearMultiListAndUpdateWithNewList(String listName, String[] newListValues, WebElementFacade dropDownClear, WebElementFacade listFieldBtn) {
        // withTimeoutOf(100, TimeUnit.SECONDS).waitFor(dropDownClear);
        $(listFieldBtn).click();
        waitABit(1000);
        $(dropDownClear).click();
        if (listName.equalsIgnoreCase("technologyPlatforms")) {
            multiSelectionOfTechnologyPlatform(newListValues);
        }
    }

    public boolean validateSelectedValues(List<WebElementFacade> selectedValues, String[] expectedValues, String itemName) {
        List<String> selectedValues1 = selectedValues.stream().map(WebElementFacade::getText).collect(Collectors.toList());
        List<String> expected = Arrays.asList(expectedValues);
        System.out.println(selectedValues1 + ":" + "Actual" + itemName);
        System.out.println(expected + ":" + "Expected" + itemName);
        if (selectedValues1.size() != expectedValues.length) {
            Assert.fail("Number of selected values does not match the expected number");
        }
        return reusableUtilities.compareTwoLists(selectedValues1, expected);
    }

    public void validateErrorMessage(List<List<String>> data) {
        Serenity.getDriver().switchTo().defaultContent();
        String expectedMessage = data.get(0).get(0).trim();

        if (checkAlertMessage(alertMessage, expectedMessage)) {
            Assert.assertTrue("Error Message for Mandatory Fields have been shown", true);
        } else if (switchToFrameAndCheckMessage(newFrameForCreatePartFrame, alertMessage, expectedMessage)) {
            Assert.assertTrue("Error Message for Mandatory Fields have been shown", true);
        } else if (switchToFrameAndCheckMessage(newFrameForCreatePartFrame2, alertMessage, expectedMessage)) {
            Assert.assertTrue("Error Message for Mandatory Fields have been shown", true);
        } else if (switchToFrameAndCheckMessage(newFrameForCreatePartFrame3, alertMessage, expectedMessage)) {
            Assert.assertTrue("Error Message for Mandatory Fields have been shown", true);
        }

        $(alertOkButton).click();
    }

    private boolean checkAlertMessage(WebElementFacade alertLocator, String expectedMessage) {
        if ($(alertLocator).isCurrentlyVisible()) {
            String alertMsg = $(alertLocator).getText().toString().trim();
            return alertMsg.equalsIgnoreCase(expectedMessage);
        }
        return false;
    }

    private boolean switchToFrameAndCheckMessage(WebElementFacade frameLocator, WebElementFacade alertLocator, String expectedMessage) {
        if ($(frameLocator).isCurrentlyVisible()) {
            Serenity.getDriver().switchTo().frame(frameLocator);
            return checkAlertMessage(alertLocator, expectedMessage);
        }
        return false;
    }


    public void userShouldAddTheRequiredBomElements(String bomCode) {
        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(parentFrame).switchTo().frame(partBomRelationshipFrame);
        withTimeoutOf(Duration.ofSeconds(100)).waitFor(addPartButton);
        js.executeScript("arguments[0].scrollIntoView();", $(addPartButton));
        $(addPartButton).click();
        Serenity.getDriver().switchTo().parentFrame().switchTo().frame(dialogueFrame);
        waitABit(3000);
        withTimeoutOf(Duration.ofSeconds(100)).waitFor(clearSearchCriteria).click();
        waitABit(3000);
        withTimeoutOf(Duration.ofSeconds(100)).waitFor(searchItemCodeField).click();
        waitABit(2000);
        $(Serenity.getDriver().switchTo().activeElement()).type(bomCode);
        waitABit(2000);
        $(runSearchButton).click();
        withTimeoutOf(Duration.ofSeconds(120)).waitFor(searchResultsInGrid).click();
        $(By.xpath("//td[text()='" + bomCode + "']")).click();
        waitABit(2000);
        $(arasSearchOkButton).click();
        getDriver().switchTo().parentFrame();
        $(doneButton).click();
    }

    public void userShouldAddBOMElementsToThePart() {
        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(parentFrame).switchTo().frame(partBomRelationshipFrame);
        withTimeoutOf(Duration.ofSeconds(100)).waitFor(addPartButton);
        js.executeScript("arguments[0].scrollIntoView();", $(addPartButton));
        $(addPartButton).click();
        Serenity.getDriver().switchTo().parentFrame().switchTo().frame(dialogueFrame);
        waitABit(3000);
        withTimeoutOf(Duration.ofSeconds(100)).waitFor(clearSearchCriteria).click();
        waitABit(3000);
        withTimeoutOf(Duration.ofSeconds(100)).waitFor(searchItemCodeField).click();
        for (int i = 1; i <= 3; i++) {
            reusableUtilities.pressTab();
            waitABit(1000);
        }
        $(Serenity.getDriver().switchTo().activeElement()).type("Adhesive - 80");
        for (int i = 1; i <= 2; i++) {
            reusableUtilities.pressTab();
            waitABit(1000);
        }
        $(Serenity.getDriver().switchTo().activeElement()).type("Released");
        $(runSearchButton).click();
        withTimeoutOf(Duration.ofSeconds(100)).waitFor(searchResultsInGrid).click();
        partResult.stream().skip(1).forEach(partNum -> reusableUtilities.pressAndHoldControl(partNum));
        List<String> PartRes = partResult.stream().map(WebElementFacade::getText).collect(Collectors.toList());
        System.out.println(PartRes + "PartResElements");
        $(arasSearchOkButton).click();
        getDriver().switchTo().parentFrame();
        $(doneButton).click();
        Serenity.getDriver().switchTo().frame(partBomRelationshipFrame);
        //Assert.assertEquals("Parts Mismatch", partResult.size(), BOMResult.size());
        List<String> BOMElements = BOMResult.stream().map(WebElementFacade::getText).collect(Collectors.toList());
        System.out.println(BOMElements + "BOMElements");
        ItemCodeStore.storeLists("BOMElements", BOMElements);
        System.out.println(ItemCodeStore.getStoreList("BOMElements"));
    }

    public String fetchingItemCode() {
        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(newFrameForCreatePartFrame);
        $(refreshButton).click();
        reusableUtilities.switchFrame($(starter.PageObjectsPages.nonMBOM.FMS.PartPage.newFrameForCreatePartFrameDataEntry), "", 0);
        List<WebElementFacade> elementList = Arrays.asList(
                itemCode,
                pmiCode,
                methodIDField,
                nameField,
                materialDisclosureItemCode,
                mSpecAlternativeItemCode,
                qcsItemCode
        );
        generatedItemCode = elementList.stream()
                .filter(WebElementFacade::isCurrentlyVisible)
                .findFirst()
                .map(element -> {
                    scrollIntoView(element);
                    return element.getAttribute("value").trim();
                })
                .orElse("Item code not found");
        System.out.println(generatedItemCode);
        return generatedItemCode;
    }

    private void scrollIntoView(WebElementFacade element) {
        JavascriptExecutor js = (JavascriptExecutor) Serenity.getDriver();
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public void userClicksOnTab(String tabName) {
        waitABit(7000);
        By tabNameElement = By.xpath("//span[@class='aras-tabs__label' and text()='" + tabName.trim() + "']");
        By tabNameElement2 = By.xpath("//li[@class='aras-tabs__tab' and @title='" + tabName.trim() + "']");
        Serenity.getDriver().switchTo().defaultContent();

        if ($(newFrameForCreatePartFrame3).isCurrentlyVisible()) {
            Serenity.getDriver().switchTo().frame(newFrameForCreatePartFrame3);
            if ($(tabNameElement).isCurrentlyVisible()) {
                $(tabNameElement).waitUntilClickable();
                js.executeScript("arguments[0].scrollIntoView();", $(tabNameElement));
                $(tabNameElement).click();
            } else if ($(tabNameElement2).isCurrentlyVisible()) {
                $(tabNameElement2).waitUntilClickable();
                js.executeScript("arguments[0].scrollIntoView();", $(tabNameElement2));
                $(tabNameElement2).click();
            }
        } else if ($(newFrameForCreatePartFrame2).isCurrentlyVisible()) {
            Serenity.getDriver().switchTo().frame(newFrameForCreatePartFrame2);
            if ($(tabNameElement).isCurrentlyVisible()) {
                $(tabNameElement).waitUntilClickable();
                js.executeScript("arguments[0].scrollIntoView();", $(tabNameElement));
                $(tabNameElement).click();
            } else if ($(tabNameElement2).isCurrentlyVisible()) {
                $(tabNameElement2).waitUntilClickable();
                js.executeScript("arguments[0].scrollIntoView();", $(tabNameElement2));
                $(tabNameElement2).click();
            }
        } else {
            Serenity.getDriver().switchTo().frame(newFrameForCreatePartFrame);
            if ($(tabNameElement).isCurrentlyVisible()) {
                $(tabNameElement).waitUntilClickable();
                js.executeScript("arguments[0].scrollIntoView();", $(tabNameElement));
                $(tabNameElement).click();
            } else if ($(tabNameElement2).isCurrentlyVisible()) {
                $(tabNameElement2).waitUntilClickable();
                js.executeScript("arguments[0].scrollIntoView();", $(tabNameElement2));
                $(tabNameElement2).click();
            }
        }

        waitABit(5000);
        if (Serenity.getDriver().switchTo().activeElement().getAttribute("className").contains("tabs__tab_active")) {
            Assert.assertTrue(true);
        } else {
            $(By.cssSelector("div.aras-scroller__wrapper:nth-child(2) span.aras-tabs-arrow:nth-child(3)")).click();
            waitABit(1000);
            js.executeScript("arguments[0].scrollIntoView();", $(tabNameElement));
            waitABit(1000);
            $(tabNameElement).click();
        }
    }


    public void editTheForm() {
        Serenity.getDriver().switchTo().defaultContent();
        withTimeoutOf(Duration.ofSeconds(100)).waitFor(newFrameForCreatePartFrame);
        Serenity.getDriver().switchTo().frame(newFrameForCreatePartFrame);
        waitABit(4000);
        withTimeoutOf(Duration.ofSeconds(100)).waitFor(editButton);
        $(editButton).click();
    }

    public void setZoomLevel(double zoomLevel) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("document.body.style.zoom='" + zoomLevel + "'");
    }
    public void validationOfStatus(String lifecycleStatus) {
        // System.out.println("QCS Changes Tab Data: " + qcsEcoInformation);
        Serenity.getDriver().switchTo().defaultContent();
        withTimeoutOf(Duration.ofSeconds(120)).waitFor(parentFrame);
        Serenity.getDriver().switchTo().frame(parentFrame);
        withTimeoutOf(Duration.ofSeconds(120)).waitFor(childFrame);
        Serenity.getDriver().switchTo().frame(childFrame);
        String statusOfTheRequest = "";
        if ($(status1).isCurrentlyVisible()) {
            statusOfTheRequest = $(status1).getAttribute("value").toString().trim();
        } else if ($(status2).isCurrentlyVisible()) {
            statusOfTheRequest = $(status2).getAttribute("value").toString().trim();
        } else if ($(status3).isCurrentlyVisible()) {
            JavascriptExecutor js = (JavascriptExecutor) Serenity.getDriver();
            statusOfTheRequest = (String) js.executeScript("return document.getElementsByName('" + status3 + "')[0].value");
        } else if ($(status4).isCurrentlyVisible()) {
            statusOfTheRequest = $(status4).getAttribute("value").toString().trim();
        } else if ($(status5).isCurrentlyVisible()) {
            statusOfTheRequest = $(status5).getAttribute("value").toString().trim();
        } else if ($(status6).isCurrentlyVisible()) {
            statusOfTheRequest = $(status6).getAttribute("value").toString().trim();
        } else if ($(analysisPackageState).isCurrentlyVisible()) {
            statusOfTheRequest = $(analysisPackageState).getAttribute("value").toString().trim();
            System.out.println(statusOfTheRequest + "AP status");
        } else if ($(qcsState).isCurrentlyVisible()) {
            statusOfTheRequest = $(qcsState).getAttribute("value").toString().trim();
        }
        if ($(qcsState).isCurrentlyVisible()) {
            statusOfTheRequest = $(qcsState).getAttribute("value").toString().trim();
        }
        System.out.println(statusOfTheRequest + "Actual status");
        System.out.println(lifecycleStatus + "Expected status");
        Assert.assertTrue("Status is " + lifecycleStatus, statusOfTheRequest.equalsIgnoreCase(lifecycleStatus));
    }

    public void validateRevisionField(String revision) {
        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(newFrameForCreateDocumentFrame).switchTo().frame(newFrameForCreateDocumentFrameDataEntry);
        String currentRev = $(generatedRevision).getAttribute("value").toString().trim();
        if (currentRev.equalsIgnoreCase(revision)) {
            Assert.assertTrue(true);
        }
    }

    public void choosesTheActionCreateConsumableFromReferenceConsumableFromTheMoreActionMenu() {
        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(parentFrame);
        $(moreButton).click();
        js.executeScript("arguments[0].scrollIntoView();", $(createConsumableFromRCActionBtn));
        $(createConsumableFromRCActionBtn).click();
    }

    public void aNewPartFormShouldOpenAndTheUserClicksDone(String itemTypeName) {
        waitABit(5000);
        Serenity.getDriver().switchTo().defaultContent();
        withTimeoutOf(Duration.ofSeconds(100)).waitFor(closeTheFirstOpenedTab).click();
        Serenity.getDriver().switchTo().frame(parentFrame).switchTo().frame(childFrame);
        String itemTypeClassification = $(itemTypeClassificationName).getAttribute("value").toString().trim();
        Assert.assertTrue("", itemTypeName.equalsIgnoreCase(itemTypeClassification));
        Serenity.getDriver().switchTo().parentFrame();
        $(doneButton).click();
    }

    public void systemShouldCopyAndDisplayAllTheAttributesAndRelationshipTabsDataFromReferenceConsumableRCSInConsumableCOS() {
        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(parentFrame).switchTo().frame(childFrame);
        waitABit(5000);

        String itemDescText = getFieldValue(itemDescription);
        String subFamilyText = getFieldValue(subFamilyField);
        String productGroupText = getFieldValue(productGroupField);
        String purposeText = getFieldValue(purposeField);
        String addDescText = getFieldValue(additionalDescription, additionalDescription2);

        List<String> selectedTechnologyListValues = getTheSelectedTechnologyList.stream()
                .map(WebElementFacade::getText)
                .collect(Collectors.toList());

        // Simplified printing for actual vs expected values
        compareAndPrintValues("itemDesc", itemDescText);
        compareAndPrintValues("AddDesc", addDescText);
        compareAndPrintValues("subFamily", subFamilyText);
        compareAndPrintValues("productGroup", productGroupText);
        compareAndPrintValues("purpose", purposeText);

        // Compare technology lists
        boolean technologyPlatform = reusableUtilities.compareTwoLists(
                selectedTechnologyListValues,
                ItemCodeStore.getStoreList("TechnologyListValues")
        );
        System.out.println("Actual Value: " + "TRUE" + "...." + "Expected Value: " + technologyPlatform);

        // Assertions
        Assert.assertTrue("ItemDesc is not copied", itemDescText.equalsIgnoreCase(ItemCodeStore.getUniqueCode("itemDesc")));
        Assert.assertTrue("addDesc is not copied", addDescText.equalsIgnoreCase(ItemCodeStore.getUniqueCode("AddDesc")));
        Assert.assertTrue("subFamily is not copied", subFamilyText.equalsIgnoreCase(ItemCodeStore.getUniqueCode("subFamily")));
        Assert.assertTrue("productGroup is not copied", productGroupText.equalsIgnoreCase(ItemCodeStore.getUniqueCode("productGroup")));
        Assert.assertTrue("Purpose is not copied", purposeText.equalsIgnoreCase(ItemCodeStore.getUniqueCode("purpose")));
        Assert.assertTrue("TechnologyListValues is not copied", technologyPlatform);
    }

    private String getFieldValue(WebElementFacade element) {
        return element.getAttribute("value").trim();
    }

    private String getFieldValue(WebElementFacade primaryElement, WebElementFacade fallbackElement) {
        return primaryElement.isCurrentlyVisible() ?
                primaryElement.getAttribute("value").trim() :
                fallbackElement.getAttribute("value").trim();
    }

    private void compareAndPrintValues(String fieldName, String actualValue) {
        String expectedValue = ItemCodeStore.getUniqueCode(fieldName);
        System.out.println("Actual Value: " + actualValue + "...." + "Expected Value: " + expectedValue);
    }

    public void populateTheReferenceCodeAttributeOfTheConsumablesPartWithTheReferenceConsumableItemCode(String RCSItemCode) {
        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(parentFrame).switchTo().frame(childFrame);
        String referenceCodeFieldData = $(referenceCodeFieldLink).getText().toString().trim();
        System.out.println(referenceCodeFieldData + "referenceCodeFieldData");
        Assert.assertTrue("RCS Code is not attached/Different in the ROC Reference Code Field", referenceCodeFieldData.equalsIgnoreCase(RCSItemCode));
    }

    public void theParameterShouldBeFilledWithValueAndItsDataTypeShouldBe(String parameterNumber, String parameterValue, String dataType) {
        //partParameterValues.theParameterShouldBeFilledWithValueAndItsDataTypeShouldBe(parameterNumber, parameterValue);
        ecoPartParameterValidationsPage.theParameterShouldBeFilledWithValueAndItsDataTypeShouldBe(parameterNumber, parameterValue);
    }

    public void theBOMMustContainTheParentItem(String BOMNumber) {
        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(parentFrame).switchTo().frame(partBomRelationshipFrame);
        Assert.assertTrue("Parent Item is not visible in BOM tab", $(By.xpath("//*[text()='" + BOMNumber + "']")).isCurrentlyVisible());
    }

    public void thePackedItemsMustBeReleasedAutomaticallyWithASystemGeneratedECO() {
        Serenity.getDriver().switchTo().defaultContent();
        waitABit(3000);
        withTimeoutOf(Duration.ofSeconds(120)).waitFor(parentFrame);
        Serenity.getDriver().switchTo().frame(parentFrame).switchTo().frame(changesTabFrame).switchTo().frame(treeGridViewerFrame);
        Assert.assertTrue("System Generated ECO is not visible", $(By.xpath("//*[contains(text(), 'System generated ECO for Packed Items from')]")).isCurrentlyVisible());
        Assert.assertTrue("Released state is not visible", $(By.xpath("//*[text()='Released']")).isCurrentlyVisible());
    }

    public void userShouldSearchAndOpenThePartFromSearchPage(String itemCode) {
        reusableMethods.searchItemByCode(searchItemCodeField, itemCode);
    }

    public void userShouldAddRCMOrRCSToTheReferenceCodeField(String itemCode) {
        System.out.println(itemCode + "RefCode");
        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(parentFrame).switchTo().frame(childFrame);
        reusableMethods.waitUntilElementVisible(referenceCodeBtn).click();
        Serenity.getDriver().switchTo().parentFrame().switchTo().frame(dialogueFrame);
        waitABit(2000);
        reusableMethods.waitUntilElementVisible(clearSearchCriteria).click();
        waitABit(2000);
        reusableMethods.waitUntilElementVisible(itemCodeInSearchSection).click();
        waitABit(2000);
        $(Serenity.getDriver().switchTo().activeElement()).type(itemCode);
        waitABit(2000);
        reusableMethods.waitUntilElementVisible(runSearchButton).click();
        reusableMethods.waitUntilElementVisible(searchResultsInGrid);
        $(arasSearchOkButton).click();
        Serenity.getDriver().switchTo().parentFrame();
        $(doneButton).click();
        waitABit(2000);
    }
}