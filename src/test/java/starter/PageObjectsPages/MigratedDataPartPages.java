package starter.PageObjectsPages;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import starter.PageObjectsPages.Develop.EcoPage;
import starter.PageObjectsPages.Develop.ItemCodeStore;
import starter.PageObjectsPages.Develop.PartPageDev;
import starter.Utility.ExcelUtilities;
import starter.Utility.ReusableMethods;
import starter.Utility.ReusableUtilities;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MigratedDataPartPages extends PageObject {
    ReusableUtilities reusableUtilities = new ReusableUtilities();
    ReusableMethods reusableMethods = new ReusableMethods();
    ARASLoginPageObjects arasLoginPageObjects = new ARASLoginPageObjects();
    ARAS_HomePage arasHomePage = new ARAS_HomePage();
    PartPageDev partPage = new PartPageDev();
    EcoPage ecoPage = new EcoPage();
    ARAS_HomePage home = new ARAS_HomePage();
    Actions action = new Actions(Serenity.getDriver());
    JavascriptExecutor js = (JavascriptExecutor) Serenity.getDriver();
    public static @FindBy(xpath = "//textarea[@name='title']") WebElementFacade EcoTitleField;
    public static @FindBy(xpath = "//button[@aria-label='Open User Menu']") WebElementFacade currentUserDetails;

    public static @FindBy(xpath = "//iframe[@class='content-block__iframe']") WebElementFacade parentFrame;
    public static @FindBy(css = "span.aras-dialog-alert__text") WebElementFacade getAlertMessage;
    public static @FindBy(xpath = "(//iframe[@class='content-block__iframe'])[2]") WebElementFacade secondParentFrame;
    public static @FindBy(xpath = "//*[@id='gridTD']/div[2]/div[2]/div/table/tr[1]/td[1]") WebElementFacade firstEleInSearchResult;
    public static @FindBy(xpath = "//*[@id='gridTD']/div[2]/div[2]/div/table/tr[1]/td[5]") WebElementFacade subFamilyTextSearch;
    public static @FindBy(xpath = "//*[text()='OK']") WebElementFacade alertOkButton;
    public static @FindBy(xpath = "//iframe[@class='aras-dialog__iframe']") WebElementFacade dialogueIframe;
    public static @FindBy(xpath = "//iframe[@title=' Item Form']") WebElementFacade frmItemForm;
    public static By btnRestorePreferences = By.cssSelector("input[id='reset_button']");
    public static By listAvailableProperties = By.cssSelector("select[id='availableProperties']");
    public static By listAvailableRelationships = By.cssSelector("select[id='availableRelationships']");
    public static By buttonGraterThanTwice = By.cssSelector("#saveAsManager > table > tbody > tr:nth-child(1) > td:nth-child(3) > table > tbody > tr:nth-child(1) > td > input");
    public static @FindBy(xpath = "//span[@class='aras-icon-close']") WebElementFacade closeTab;
    public static @FindBy(xpath = "//input[@id='ok_button']") WebElementFacade btnConfirm;

    public static @FindBy(xpath = "//button[@title='Edit']") WebElementFacade editButton;
    public static @FindBy(xpath = "//input[@name='item_number']") WebElementFacade ecoNumberField;
    public static @FindBy(xpath = "//table[@id='item_status']/tbody/tr/td") WebElementFacade ecoStatus;
    public static @FindBy(xpath = "//span[@title='Add Item']") WebElementFacade affectedItemButton;

    public static @FindBy(xpath = "//iframe[@id='instance']") WebElementFacade childFrame;
    public static @FindBy(xpath = "//td[@uniqueid='ms__id38']//table//tbody//tr") List<WebElementFacade> ecoSignOffTableRows;
    public static @FindBy(xpath = "//textarea[@class='description']") WebElementFacade changeDescFieldInEco;
    public static @FindBy(xpath = "//input[@name='pmi_eco_purpose']") WebElementFacade purposeFieldInEco;
    public static @FindBy(xpath = "//select[@name='pmi_change_drivers']") WebElementFacade changeDriversInEco;
    public static @FindBy(xpath = "//input[@name='pmi_sfp_reason_for_change']") WebElementFacade sfpReasonChangeField;
    public static @FindBy(xpath = "//input[@name='esignature']") WebElementFacade eSignatureField;
    public static @FindBy(xpath = "//td[@data-head-id='item_number_D']") WebElementFacade ecoSearchNumberField;
    public static @FindBy(className = "aras-dialog__iframe") WebElementFacade newFrameForWorkFlow;

    public static @FindBy(xpath = "//iframe[contains(@name,'innovator_')]") WebElementFacade newFrameForCreatePartFrame;
    public static @FindBy(xpath = "//span[text()='Done']") WebElementFacade btnDone;

    public static @FindBy(xpath = "//button[@title='More']") WebElementFacade moreButton;
    public static @FindBy(xpath = "//span[text()='Save As']") WebElementFacade buttonSaveAs;

    public static @FindBy(xpath = "(//iframe[contains(@name,'innovator_')])[2]") WebElementFacade newFrameForCreatePartFrame2;
    public static @FindBy(xpath = "(//iframe[contains(@name,'innovator_')])[3]") WebElementFacade newFrameForCreatePartFrame3;
    public static @FindBy(xpath = "//iframe[@src='ShowFormInFrame.html']") WebElementFacade newFrameForm;
    public static @FindBy(xpath = "//iframe[@id='formFrame']") WebElementFacade newFrameForm2;
    public static @FindBy(xpath = "//input[@name='pmi_sub_families']") WebElementFacade subFamilyField;
    public static @FindBy(xpath = "//input[@name='pmi_productgroup']") WebElementFacade getProductGroup;
    public static @FindBy(xpath = "//input[@aria-label='Product Group search cell']") WebElementFacade productGroupField;
    public static @FindBy(xpath = "//span[@id='SALTkA7_Aras_Tbi_collapse_all']") WebElementFacade collapseAllBtn;
    public static @FindBy(xpath = "//span[@title='Close']") WebElementFacade closePopUpInECO;
    public static @FindBy(xpath = "//span[@class='aras-list-item__label' and text()='Check for Completeness']") WebElementFacade checkForCompletenessButton;
    public static @FindBy(xpath = "//textarea[@name='description_textarea']") WebElementFacade checkForCompletenessDescriptionText;
    public static @FindBy(xpath = "//span[@class='aras-tabs__label' and text()='Affected Items']") WebElementFacade affectedItemsTab;
    public static @FindBy(xpath = "//*[@class='aras-switcher']//iframe[@id='C5121F4CF8174DD7AED3AB967E9BDDC5']") WebElementFacade newFrameForm1;
    public static @FindBy(xpath = "//iframe[@id='result_iframe_frame']") WebElementFacade newFrameToSeeSubFamilyWorkFlow;
    public static @FindBy(id = "VoteList") WebElementFacade VoteList;
    public static @FindBy(xpath = "//*[@id='btnCreate' and @value='Continue']") WebElementFacade continueButton;
    public static @FindBy(name = "Complete") WebElementFacade completeButton;
    public static @FindBy(xpath = "//*[text()='Under Development']") WebElementFacade targetLifecycleField;
    public static @FindBy(xpath = "//span[@title='Add Item']") WebElementFacade addAffectedItemButton;
    public static @FindBy(xpath = "//select[@title='ItemType']") WebElementFacade itemTypeSelect;
    public static @FindBy(xpath = "//*[text()='Under Development']") List<WebElementFacade> targetLifecycleFields;
    public static @FindBy(xpath = "//*[text()='Under Verification']") WebElementFacade targetLifecycleField2;
    public static @FindBy(xpath = "//*[text()='Under Verification']") List<WebElementFacade> targetLifecycleFields2;
    public static @FindBy(xpath = "//span[contains(text(), 'VOTE NOW')]") WebElementFacade voteNowBtn;
    public static @FindBy(xpath = "//span[contains(text(), 'VOTE NOW')]/ancestor::tr[1]/td[1]") WebElementFacade activityType;
    public static @FindBy(xpath = "(//td[contains(text(), 'Active')])[position() > 1]") WebElementFacade activeButton;
    public static @FindBy(xpath = "(//td[contains(text(), 'Active')]/ancestor::tr[1]/td[3])[position() > 1]") WebElementFacade assignedTo;
    public static @FindBy(xpath = "//*[@id='gridTD']/div[2]/div[2]/div/table/tr/td[7]/label/input") List<WebElementFacade> ownerApprovalCheck;
    public static @FindBy(xpath = "//iframe[@title='pmi_ExpressECO_Assignments Relationship']") WebElementFacade ecoAssignmentsRelationshipFrame;
    public static @FindBy(xpath = "//*[@id='main-tab']/div/div/ul/li/span[1]") List<WebElementFacade> activeTabsList;

    public static @FindBy(xpath = "//span[@class='aras-dialog-alert__text']") WebElementFacade errorMessage;
    public static @FindBy(xpath = "//span[contains(text(), 'Creator/Owner of the Express ECO is not allowed')]") WebElementFacade creatorOwnerErrorMsg;
    public static @FindBy(xpath = "//span[contains(text(), 'All GHP Parameters')]") WebElementFacade parameterValidationErrorMsg;
    public static @FindBy(xpath = "//span[contains(text(), 'Affected Item')]") WebElementFacade parameterValidationErrorMsg3;
    public static @FindBy(xpath = "//span[contains(text(), 'Parameters Validation Results')]") WebElementFacade parameterValidationErrorMsg2;

    public static @FindBy(xpath = "//button[@title='Clear Search Criteria']") WebElementFacade clearSearchCriteria;
    public static @FindBy(xpath = "//div[@dojoattachpoint='contentNode']/div/div[contains(@class, 'dojoxGridRow')]/table/tbody/tr/td[6]") List<WebElementFacade> targetLifecyclesFields;
    public static @FindBy(xpath = "//button[@title='Run Search']") WebElementFacade runSearchButton;
    public static @FindBy(xpath = "//span[@class='aras-dialog-alert__text']") WebElementFacade alertMessage;
    public static @FindBy(xpath = "//tr[@class='dojoxGridNoChildren']//td[4]") WebElementFacade currentLifecycle;
    public static @FindBy(xpath = "(//*[text()='Released'])[2]") WebElementFacade targetLifeCycleText;
    public static @FindBy(xpath = "//*[text()='Done']") WebElementFacade doneBtn;
    public static @FindBy(xpath = "//button[@title='More']") WebElementFacade moreButtonECO;
    public static @FindBy(xpath = "//select[@id='pmi_newTextId']") WebElementFacade listMultiListFieldInMassChange;
    public static @FindBy(xpath = "//input[@id='pmi_newTextId']") WebElementFacade freeTextFieldInMassChange;
    public static @FindBy(xpath = "//input[@id='pmi_newMinValueId']") WebElementFacade minValueFieldInMassChange;
    public static @FindBy(xpath = "//input[@id='pmi_newMaxValueId']") WebElementFacade maxValueFieldInMassChange;
    public static @FindBy(xpath = "//input[@id='pmi_newTargetValueId']") WebElementFacade targetValueFieldInMassChange;
    public static @FindBy(xpath = "//li[@data-index='pmi_AddManualReviewersAction']/span[1]") WebElementFacade updateAssignmentBtn;
    public static @FindBy(xpath = "//input[@name='pmi_append']/following-sibling::label") WebElementFacade appendAssignmentCheckbox;
    public static @FindBy(xpath = "//textarea[@name='pmi_comments']") WebElementFacade updateAssignmentComments;
    public static @FindBy(xpath = "//input[@name='pmi_select']") WebElementFacade selectAssignmentsBtn;

    public static @FindBy(xpath = "//iframe[@id='formFrame']") WebElementFacade formFrame;
    public static @FindBy(xpath = "//input[@name='close_button']") WebElementFacade closeButtonForCompleteness;
    public static @FindBy(xpath = "//td[@data-head-id='name_D']/input") WebElementFacade nameFieldInIdentities;
    public static @FindBy(xpath = "//input[@name='pmi_submit']") WebElementFacade submitBtn;
    public static @FindBy(xpath = "//span[@title='Close']") WebElementFacade closeBtn;

    public static @FindBy(xpath = "(//*[@class='aras-grid-row-cell '])[1]") WebElementFacade searchResultsInGrid;
    public static @FindBy(xpath = "//input[@name='pmi_parameter_data_type']") WebElementFacade parameterDataTypeInMassChange;
    public static @FindBy(xpath = "//button[contains(@class, 'aras-button_primary') and contains(@class, 'aras-buttons-bar__button')]//span[text()='OK']") WebElementFacade searchOkBtn;

    public static @FindBy(xpath = "//*[@id='main-tab']/div/div/ul/li[1]/span[1]") WebElementFacade closeTheFirstOpenedTab;
    public static @FindBy(xpath = "//td[@data-head-id='classification_D']//input") WebElementFacade partSearchItemType;
    public static @FindBy(xpath = "//td[@data-head-id='item_number_D']//input") WebElementFacade itemNumberInPartSearch;
    public static @FindBy(xpath = "//td[@data-head-id='pmi_subfilter_D']//input") WebElementFacade partSearchSubfamily;
    public static @FindBy(xpath = "//td[@data-head-id='pmi_target_lc_D']//input") WebElementFacade partSearchLifecycle;
    public static @FindBy(xpath = "//td[@data-head-id='pmi_is_migrated_D']//input") WebElementFacade partSearchMigratedField;
    public static @FindBy(xpath = "//input[@aria-label='Changes search cell']") WebElementFacade partChangesField;
    public static @FindBy(xpath = "//button[@data-id='pagination_more_button']") WebElementFacade paginationButton;
    public static @FindBy(xpath = "//span[@data-id='pagination_page_size']") WebElementFacade paginationPageSize;
    public static @FindBy(xpath = "//span[@data-id='pagination_status_node']//span[3]") WebElementFacade paginationLastPageNumber;
    public static @FindBy(xpath = "//aras-input[@title='Current Page']") WebElementFacade paginationCurrentPageNumberField;

    public static @FindBy(xpath = "//button[@title='Refresh']") WebElementFacade refreshButton;
    public static @FindBy(xpath = "//button[@title='Share']") WebElementFacade shareButton;
    public static @FindBy(xpath = "//iframe[@title='pmi_ECOIntegrationRecords Relationship']") WebElementFacade newFrameOfIntegrationResultsTab;

    public static @FindBy(xpath = "(//*[@class='aras-grid-row-cell '])[1]") WebElementFacade searchResults;
    public static @FindBy(xpath = "//*[@id='main-tab']/div/div/ul/li[2]/span[1]") WebElementFacade TheSecondOpenedTab;

    public static @FindBy(xpath = "//*[@class='item_number']") WebElementFacade itemCodeField;
    public static @FindBy(xpath = "//td[@data-head-id='item_number_D']") WebElementFacade itemCodeFieldInSearchParts;

    public static @FindBy(xpath = "//iframe[@class='aras-dialog__iframe']") WebElementFacade dialogueFrame;

    public static @FindBy(xpath = "//button[@title='Save']") WebElementFacade saveButton;
    public static @FindBy(xpath = "//input[@aria-label='Purpose search cell']") WebElementFacade purposeSearchField;
    public static @FindBy(xpath = "//li[@data-index='pmi_ECO_MassChange']/span[1]") WebElementFacade massChangeField;
    public static @FindBy(xpath = "//input[@name='pmi_eco_changeType']//following-sibling::button") WebElementFacade massChangeChangeType;
    public static @FindBy(xpath = "//li[@data-value='Parameter']") WebElementFacade parameterChangeType;
    public static @FindBy(xpath = "//li[@data-value='Update']") WebElementFacade updateActionSelection;
    public static @FindBy(xpath = "//input[@name='pmi_eco_massChange_action']//following-sibling::button") WebElementFacade massChangeActionField;
    public static @FindBy(xpath = "//input[@name='pmi_continue_btn']") WebElementFacade massChangeNextButton;
    public static @FindBy(xpath = "//textarea[@id='selected-options']") WebElementFacade massChangeAffectedItemCodes;
    public static @FindBy(xpath = "//input[@id='search-input']") WebElementFacade massChangeSearchInputField;
    public static @FindBy(xpath = "(//input[@class='option'])[1]") WebElementFacade massChangeSearchOptions;
    public static @FindBy(xpath = "//img[@name='GHP Parameter']") WebElementFacade selectParameterButton;
    public static @FindBy(xpath = "//td[@data-head-id='pmi_parameter_number_D']") WebElementFacade parameterNumberSearchField;
    public static @FindBy(xpath = "//input[@name='pmi_TargetLifecycle']") WebElementFacade massChangeTargetLifecycleField;
    public static @FindBy(xpath = "//input[@name='pmi_UpdateBtn']") WebElementFacade massChangeUpdateButton;
    public static @FindBy(xpath = "(//td[@class='aras-grid-row-cell '])[6]") WebElementFacade responseElement;
    public static @FindBy(xpath = "//td[contains(text(),'Material Master distribution successful, 021(ZDGXU_MM)')]") WebElementFacade responseText;
    public static @FindBy(xpath = "//iframe[@title='pmi_Parameters Relationship']") WebElementFacade ParametersIframe;
    public static @FindBy(xpath = "//iframe[@title='Part BOM Relationship']") WebElementFacade BOMTabIframe;
    public static @FindBy(xpath = "//select[@title='Search Modes']") WebElementFacade searchModesInSearchDialogue;
    public static @FindBy(xpath = "//td[@data-head-id='pmi_parameter_number_R']") WebElementFacade parameterNumberFieldInSearchMode;
    public static @FindBy(xpath = "//td[@data-head-id='pmi_text_value_D']") WebElementFacade textFieldInSearchMode;
    public static @FindBy(xpath = "//button[@title='Add Parts']") WebElementFacade addPartsButton;
    public static @FindBy(xpath = "//td[@data-head-id='pmi_target_value_D']") WebElementFacade targetFieldInSearchMode;
    public static @FindBy(xpath = "//button[@title='Next Page']") WebElementFacade nextPage;

    public static @FindBy(xpath = "//*[text()='Done']") WebElementFacade doneButton;
    public static @FindBy(xpath = "//button[@title='Add Global Harmonized Parameters']") WebElementFacade GHPAddButton;
    public static @FindBy(xpath = "//td[@data-head-id='pmi_parameter_number_D']") WebElementFacade parameterNumberFieldInDialogueFrame;

    public static @FindBy(xpath = "//button[@class='aras-button aras-button_primary aras-buttons-bar__button']") WebElementFacade arasSearchOkButton;

    public static @FindBy(xpath = "//textarea[@id='txtContent']") WebElementFacade popupTextContent;

    public static @FindBy(xpath = "//input[@id='btnClose']") WebElementFacade closePopup;

    public static @FindBy(xpath = "(//aras-scroller[@id='formTab']//aras-accordion)[2]") WebElementFacade maximizeHostElement;

    public static @FindBy(xpath = "//div[@class='aras-acc-a-button-icon aras-icon-minimize']") WebElementFacade maximizeTargetElement;

    public static @FindBy(xpath = "//*[@id='gridTD']/div[2]/div[2]/div/table/tr/td[1]") WebElementFacade firstTdElementInRow;
    public static @FindBy(css = "div.aras-grid-body-boundary") List<WebElementFacade> arasGridDiv;

    public static @FindBy(css = "div.dojoxGridRow") List<WebElement> tableRows;
    public static @FindBy(css = "tr.aras-grid-row") List<WebElement> integrationTableRows;
    public static @FindBy(css = "div.dojoxGridScrollbox") WebElement scrollContainer;
    public static @FindBy(css = "div.aras-grid-scroller[data-scroller-mark='scroller_0']") WebElement integrationScrollContainer;
    public static @FindBy(css = "td[idx='0'] a.gridLink") List<WebElement> itemNumbers;
    public static @FindBy(css = "td.aras-grid-row-cell ") List<WebElement> partNumbers;

    public void updateTheTargetLifeCycleThroughMassChange(String itemCode, String targetLifecycle) {
        // Switch to the parent frame
        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(parentFrame);

        // Click on "More" button and "Mass Change" field
        $(moreButtonECO).waitUntilClickable().click();
        $(massChangeField).waitUntilClickable().click();

        // Switch to the form frame
        Serenity.getDriver().switchTo().frame(formFrame);

        // Select change type as "Lifecycle"
        $(massChangeChangeType).waitUntilClickable().sendKeys("Lifecycle");
        $(massChangeNextButton).waitUntilClickable().click();

        // Search for the affected item code
        $(massChangeAffectedItemCodes).waitUntilClickable().click();
        $(massChangeSearchInputField).waitUntilClickable().sendKeys(itemCode);
        $(massChangeSearchOptions).waitUntilClickable().click();

        // Enter target lifecycle and update
        $(massChangeTargetLifecycleField).waitUntilClickable().sendKeys(targetLifecycle);
        $(massChangeUpdateButton).waitUntilClickable().click();

    }

    public void updateParameterValuesThroughMassChange(String itemCode, String paramNum, String paramValue) throws Exception {
        Serenity.getDriver().switchTo().defaultContent();
        withTimeoutOf(Duration.ofSeconds(180)).waitFor(parentFrame);
        Serenity.getDriver().switchTo().frame(parentFrame);

        withTimeoutOf(Duration.ofSeconds(180)).waitFor(moreButtonECO).waitUntilClickable().click();
        withTimeoutOf(Duration.ofSeconds(120)).waitFor(massChangeField).waitUntilClickable().click();

        withTimeoutOf(Duration.ofSeconds(180)).waitFor(dialogueFrame);
        Serenity.getDriver().switchTo().frame(dialogueFrame);
        withTimeoutOf(Duration.ofSeconds(180)).waitFor(formFrame);
        Serenity.getDriver().switchTo().frame(formFrame);

        withTimeoutOf(Duration.ofSeconds(120)).waitFor(massChangeChangeType).click();
        withTimeoutOf(Duration.ofSeconds(120)).waitFor(parameterChangeType).click();
        withTimeoutOf(Duration.ofSeconds(120)).waitFor(massChangeActionField).click();
        withTimeoutOf(Duration.ofSeconds(120)).waitFor(updateActionSelection).click();
        withTimeoutOf(Duration.ofSeconds(120)).waitFor(massChangeNextButton).waitUntilClickable().click();

        waitABit(5000);
        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(parentFrame).switchTo().frame(dialogueFrame).switchTo().frame(formFrame);
        js.executeScript("arguments[0].removeAttribute('disabled');", massChangeAffectedItemCodes);
        waitABit(5000);
        withTimeoutOf(Duration.ofSeconds(120)).waitFor(massChangeAffectedItemCodes).click();
        $(By.xpath("//input[@class='option' and @value='" + itemCode + "']")).click();

        massChangeUpdateButton.waitUntilClickable().click();
        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(parentFrame);
        $(alertOkButton).click();

        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(parentFrame).switchTo().frame(dialogueFrame).switchTo().frame(formFrame);
        withTimeoutOf(Duration.ofSeconds(120)).waitFor(selectParameterButton).click();
        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(dialogueFrame);
        parameterNumberSearchField.click();
        waitABit(2000);
        $(Serenity.getDriver().switchTo().activeElement()).type(paramNum);
        waitABit(2000);
        runSearchButton.click();
        withTimeoutOf(Duration.ofSeconds(180)).waitFor(searchResultsInGrid);
        arasSearchOkButton.click();

        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(parentFrame).switchTo().frame(dialogueFrame).switchTo().frame(formFrame);
        String dataType = withTimeoutOf(Duration.ofSeconds(180)).waitFor(parameterDataTypeInMassChange).getAttribute("value");
        System.out.println("Parameter DataType is: " + dataType);

        handleParameterInMassChange(dataType, paramValue);

        massChangeUpdateButton.waitUntilClickable().click();
    }

    public void handleParameterInMassChange(String dataType, String value) throws Exception {
        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(parentFrame).switchTo().frame(dialogueFrame).switchTo().frame(formFrame);
        switch (dataType) {
            case "Free Text":
                handleFreeTextForMassChange();
                break;
            case "List":
                handleListForMassChange();
                break;
            case "Multi List":
                handleMultiListForMassChange();
                break;
            case "Number":
                handleNumberForMassChange(value);
                break;
            default:
                throw new IllegalArgumentException("Invalid data type: " + dataType);
        }
    }

    public void handleFreeTextForMassChange() {
        withTimeoutOf(Duration.ofSeconds(90)).waitFor(freeTextFieldInMassChange).sendKeys("MN");
    }

    public void handleListForMassChange() {
        withTimeoutOf(Duration.ofSeconds(90)).waitFor(listMultiListFieldInMassChange).click();
        waitABit(2000);
        reusableUtilities.pressDownNavigation();
        waitABit(1000);
        reusableUtilities.pressDownNavigation();
        waitABit(1000);
        reusableUtilities.pressEnterWithoutElement();
        waitABit(3000);
    }

    public void handleMultiListForMassChange() {
        withTimeoutOf(Duration.ofSeconds(90)).waitFor(listMultiListFieldInMassChange).click();
        waitABit(2000);

        // Retrieve all option elements
        List<WebElement> options = listMultiListFieldInMassChange.findElements(By.tagName("option"));

        // Extract the text of each option and store in a list
        List<String> optionTexts = options.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());

        // Print the option texts
        System.out.println(optionTexts);

        // Get the first three elements
        List<WebElement> firstThreeElements = options.stream()
                .limit(3)
                .collect(Collectors.toList());

        // Click on the first three elements
        firstThreeElements.forEach(WebElement::click);
    }

    public void handleNumberForMassChange(String value) throws Exception {
        System.out.println("Handle Number: " + value);
        if (value.trim().equalsIgnoreCase("Target"))
            withTimeoutOf(Duration.ofSeconds(90)).waitFor(targetValueFieldInMassChange).sendKeys("100");
        else if (value.trim().equalsIgnoreCase("Min")) {
            withTimeoutOf(Duration.ofSeconds(90)).waitFor(minValueFieldInMassChange).sendKeys("2");
        } else if (value.trim().equalsIgnoreCase("Max")) {
            withTimeoutOf(Duration.ofSeconds(90)).waitFor(maxValueFieldInMassChange).sendKeys("5");
        } else {
            throw new Exception("some different values" + value);
        }
    }

    public void checkForCompletenessInECO() throws Exception {
        Serenity.getDriver().switchTo().defaultContent();
        withTimeoutOf(Duration.ofSeconds(180)).waitFor(parentFrame);
        Serenity.getDriver().switchTo().frame(parentFrame);

        withTimeoutOf(Duration.ofSeconds(180)).waitFor(moreButtonECO).waitUntilClickable().click();
        withTimeoutOf(Duration.ofSeconds(120)).waitFor(checkForCompletenessButton).waitUntilClickable().click();

        withTimeoutOf(Duration.ofSeconds(180)).waitFor(dialogueFrame);
        Serenity.getDriver().switchTo().frame(dialogueFrame);
        withTimeoutOf(Duration.ofSeconds(180)).waitFor(formFrame);
        Serenity.getDriver().switchTo().frame(formFrame);

        String descriptionText = withTimeoutOf(Duration.ofSeconds(180)).waitFor(checkForCompletenessDescriptionText).getAttribute("value");
        System.out.println("Completeness In ECO Text is: " + descriptionText);

        waitABit(3000);
        withTimeoutOf(Duration.ofSeconds(180)).waitFor(closeButtonForCompleteness).click();

        Map<String, Map<String, Set<String>>> affectedItemsMap = null;
        if (!descriptionText.equalsIgnoreCase("Completeness Check succeeded. Express ECO is ready to move forward.")) {
            affectedItemsMap = extractMandatoryValuesForMassChange(descriptionText);
        }

        if (affectedItemsMap != null) {
            for (Map.Entry<String, Map<String, Set<String>>> affectedItemEntry : affectedItemsMap.entrySet()) {
                String affectedItem = affectedItemEntry.getKey();
                Map<String, Set<String>> parametersMap = affectedItemEntry.getValue();

                System.out.println("Affected Item: " + affectedItem);
                for (Map.Entry<String, Set<String>> parameterEntry : parametersMap.entrySet()) {
                    String parameter = parameterEntry.getKey();
                    Set<String> mandatoryValues = parameterEntry.getValue();

                    System.out.println("  Parameter: " + parameter);
                    System.out.print("    Mandatory Values: ");
                    for (String value : mandatoryValues) {
                        updateParameterValuesThroughMassChange(affectedItem, parameter, value);
                    }
                    System.out.println();
                }
            }
        }
    }


    public void userFillAllMandatoryFieldsInECOAndClickOnSave(String title, String desc, String purpose, String changeDrivers, String productGroup) {
        Serenity.getDriver().switchTo().defaultContent();
        withTimeoutOf(Duration.ofSeconds(240)).waitFor(parentFrame);
        Serenity.getDriver().switchTo().frame(parentFrame);
        withTimeoutOf(Duration.ofSeconds(240)).waitFor(childFrame);
        Serenity.getDriver().switchTo().frame(childFrame);
        withTimeoutOf(Duration.ofSeconds(180)).waitFor(EcoTitleField).sendKeys(title);
        withTimeoutOf(Duration.ofSeconds(180)).waitFor(changeDescFieldInEco).sendKeys(desc);
        withTimeoutOf(Duration.ofSeconds(180)).waitFor(purposeFieldInEco).sendKeys(purpose);
        withTimeoutOf(Duration.ofSeconds(180)).waitFor(changeDriversInEco).selectByVisibleText(changeDrivers);
        withTimeoutOf(Duration.ofSeconds(180)).waitFor(sfpReasonChangeField).sendKeys("Design Correction during Commercialization");
    }

    public void searchECOItemsFromSearchSection(String itemCode) {
        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(parentFrame);

        withTimeoutOf(Duration.ofSeconds(100)).waitFor(ecoSearchNumberField);
        waitABit(2000);

        withTimeoutOf(Duration.ofSeconds(100)).waitFor(clearSearchCriteria).click();
        waitABit(2000);

        $(ecoSearchNumberField).click();
        waitABit(2000);

        Serenity.getDriver().switchTo().activeElement().sendKeys(itemCode);
        waitABit(2000);

        $(runSearchButton).waitUntilClickable().click();

        withTimeoutOf(Duration.ofSeconds(100)).waitFor(By.xpath("//*[text()='" + itemCode + "']"));

        waitABit(3000);

        WebElement resultElement = $(By.xpath("//*[text()='" + itemCode + "']"));
        action.moveToElement(resultElement).doubleClick().perform();

        waitABit(2000);
        Serenity.getDriver().switchTo().defaultContent();

        withTimeoutOf(Duration.ofSeconds(100)).waitFor(activeTabsList.get(1));
        activeTabsList.get(0).click();
    }

    public boolean userOpensPartFromAffectedItems(String itemCode) throws Exception {

        boolean isPresent = openThePartFromAffectedItemsTab(itemCode);

        if (isPresent) {
            Serenity.getDriver().switchTo().defaultContent();
            withTimeoutOf(Duration.ofSeconds(100)).waitFor(TheSecondOpenedTab);

            Serenity.getDriver().switchTo().defaultContent().switchTo().frame(secondParentFrame).switchTo().frame(childFrame);
            withTimeoutOf(Duration.ofSeconds(120)).waitFor(itemCodeField);
        }

        return isPresent;

    }

    public void searchMultipleItemNumbersAndUpdateTheTargetLifeCycle(List<String> itemNumbersToFind) throws Exception {

        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(newFrameForCreatePartFrame).switchTo().frame(newFrameForm).switchTo().frame(newFrameForm2);

        boolean wasScrolled = false; // Flag to track if previous check required scrolling down

        for (String itemNumber : itemNumbersToFind) {
            boolean isNumberPresent = isItemNumberVisible(itemNumber);

            if (!isNumberPresent) {
                System.out.println(itemNumber + " not found, scrolling to load more data...");
                loadAllTableData();
                isNumberPresent = isItemNumberVisible(itemNumber);
                wasScrolled = true; // We scrolled, so we may need to reset position for next check
            }
            if (isNumberPresent) {
                System.out.println("Item Number Found: " + itemNumber);
                for (WebElement row : tableRows) {
                    WebElement numberCell = row.findElement(By.cssSelector("td[idx='0'] a.gridLink"));
                    if (numberCell.getText().trim().equalsIgnoreCase(itemNumber)) {
                        WebElement statusCell = row.findElement(By.cssSelector("td[idx='4'] a.gridLink"));
                        System.out.println(statusCell.getText() + "status");
                        $(statusCell).waitUntilClickable().click();
                        break;
                    }
                }
                waitABit(3000);
            } else {
                System.out.println("Item Number NOT Present: " + itemNumber);
            }

            // If we scrolled down for the previous item, scroll back up before checking the next one
            if (wasScrolled) {
                System.out.println("Scrolling back to the top before checking the next item...");
                scrollToTop();
                wasScrolled = false; // Reset flag
            }
        }

    }

    public boolean openThePartFromAffectedItemsTab(String itemNumber) {

        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(newFrameForCreatePartFrame).switchTo().frame(newFrameForm).switchTo().frame(newFrameForm2);

        boolean wasScrolled = false;

        boolean isFind = false;

        boolean isNumberPresent = isItemNumberVisible(itemNumber);

        if (!isNumberPresent) {
            System.out.println(itemNumber + " not found, scrolling to load more data...");
            loadAllTableData();
            isNumberPresent = isItemNumberVisible(itemNumber);
            wasScrolled = true; // We scrolled, so we may need to reset position for next check
        }
        if (isNumberPresent) {
            System.out.println("Item Number Found: " + itemNumber);
            for (WebElement row : tableRows) {
                WebElement oldDraft = row.findElement(By.cssSelector("td[idx='0'] a.gridLink"));
                if (oldDraft.getText().trim().equalsIgnoreCase(itemNumber)) {
                    WebElement statusCell = row.findElement(By.cssSelector("td[idx='4'] a.gridLink"));
                    System.out.println(statusCell.getText() + "status");
                    $(statusCell).waitUntilClickable().click();
                    break;
                }
            }
            waitABit(3000);
            isFind = true;
        } else {
            System.out.println("Item Number NOT Present: " + itemNumber);
            isFind = false;
        }

        // If we scrolled down for the previous item, scroll back up before checking the next one
        if (wasScrolled) {
            System.out.println("Scrolling back to the top before checking the next item...");
            scrollToTop();
            wasScrolled = false;
        }
        return isFind;
    }

    public void closeTheECOWorkFlowActivityCompletionPopup() {
        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(parentFrame);

        withTimeoutOf(Duration.ofSeconds(100)).waitFor(closePopUpInECO).click();

        Serenity.recordReportData().withTitle("ECO Workflow Popup Closed").andContents("Successfully closed the ECO workflow activity completion popup.");
    }

    public void validateWorkflowWindow() {
        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(newFrameForCreatePartFrame);

        withTimeoutOf(Duration.ofSeconds(100)).waitFor(newFrameForWorkFlow);

        Serenity.getDriver().switchTo().frame(newFrameForWorkFlow);

        Serenity.recordReportData().withTitle("Workflow Window Validated").andContents("Switched to the workflow window successfully.");
    }

    public void userSelectsSendToReviewVoteList(String option) {
        validateWorkflowWindow();

        $(VoteList).selectByVisibleText(option.trim());

        Serenity.recordReportData().withTitle("Vote List Updated").andContents("Selected the option: " + option + " from the Vote List.");
    }

    public void userClicksCompleteButton() {
        validateWorkflowWindow();

        $(completeButton).waitUntilClickable().click();

        if ($(continueButton).isCurrentlyVisible()) {
            $(continueButton).click();
        }

        Serenity.recordReportData().withTitle("Complete Button Clicked").andContents("Clicked the complete button successfully.");
    }

    public String validateECOWorkFlowStatus() {
        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(parentFrame).switchTo().frame(childFrame);
        return $(ecoStatus).waitUntilVisible().getText().trim();
    }

    public void checkAnyErrorPopupOrAlertMessage() {
        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(parentFrame);
        if (getAlertMessage.isCurrentlyVisible()) {
            alertOkButton.waitUntilClickable().click();
        }
    }

    public void addAllThePartsInECOAffectedItemTab(String partCodes) {
        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(newFrameForCreatePartFrame).switchTo().frame(newFrameForm).switchTo().frame(newFrameForm2);
        //js.executeScript("arguments[0].scrollIntoView();", $(addAffectedItemButton));
        addAffectedItemButton.click();
        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(parentFrame);
        withTimeoutOf(Duration.ofSeconds(120)).waitFor(dialogueFrame);
        Serenity.getDriver().switchTo().frame(dialogueFrame);
        withTimeoutOf(Duration.ofSeconds(120)).waitFor(itemTypeSelect).selectByVisibleText("Part");
        waitABit(3000);
        checkAnyErrorPopupOrAlertMessage();
        Serenity.getDriver().switchTo().frame(dialogueFrame);
        clearSearchCriteria.click();
        checkAnyErrorPopupOrAlertMessage();
        Serenity.getDriver().switchTo().frame(dialogueFrame);
        waitABit(2000);
        itemCodeFieldInSearchParts.click();
        waitABit(2000);
        $(Serenity.getDriver().switchTo().activeElement()).type(partCodes);
        waitABit(2000);
        for (int i = 1; i <= 11; i++) {
            reusableUtilities.pressTab();
            waitABit(1000);
        }
        waitABit(2000);
        $(Serenity.getDriver().switchTo().activeElement()).typeAndEnter("0");
        waitABit(3000);
        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(parentFrame);
        if (getAlertMessage.isCurrentlyVisible()) {
            alertOkButton.waitUntilClickable().click();
        }
        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(parentFrame).switchTo().frame(dialogueFrame);
        withTimeoutOf(Duration.ofSeconds(120)).waitFor(searchResultsInGrid).click();
        waitABit(2000);
        reusableUtilities.pressControlA();
        withTimeoutOf(Duration.ofSeconds(120)).waitFor(arasSearchOkButton).click();
    }

    public void userSelectsTargetLifecycle(String itemType, String targetLifecycle) throws Exception {
        try {
            Serenity.getDriver().switchTo().defaultContent().switchTo().frame(newFrameForCreatePartFrame).switchTo().frame(newFrameForm).switchTo().frame(newFrameForm2);

            if (targetLifecycleField.isCurrentlyVisible()) {
                targetLifecycleField.click();
                waitABit(2000);
                targetLifecycleField.click();
                waitABit(2000);
            } else if (targetLifecycleField2.isCurrentlyVisible()) {
                targetLifecycleField2.click();
                waitABit(2000);
                targetLifecycleField2.click();
                waitABit(2000);
            }

            switch (targetLifecycle) {
                case "Released":
                    pressNavigationDown(4);
                    waitABit(1000);
                    reusableUtilities.pressEnterWithoutElement();
                    break;
                case "Obsolete":
                    pressNavigationDown(2);
                    waitABit(1000);
                    reusableUtilities.pressEnterWithoutElement();
                    break;
                case "Suppressed":
                    pressNavigationDown(5);
                    waitABit(1000);
                    reusableUtilities.pressEnterWithoutElement();
                    break;
                default:
                    System.out.println("LifeCycle is not defined");
            }

            waitABit(2000);
            $(currentLifecycle).click();

            Serenity.getDriver().switchTo().defaultContent().switchTo().frame(newFrameForCreatePartFrame);
            $(doneBtn).click();

            waitABit(3000);
            Serenity.getDriver().switchTo().frame(newFrameForm).switchTo().frame(newFrameForm2);

            if (!$(targetLifeCycleText).isCurrentlyVisible()) {
                System.out.println("Target lifecycle is different.......");
            }
        } catch (Exception e) {
            throw new Exception("Error while Selects Target Lifecycle: " + e.getMessage(), e);
        }
    }


    public void updateTargetLifeCycleForMassParts(String itemType, String targetLifecycle) throws Exception {
        try {
            Serenity.getDriver().switchTo().defaultContent().switchTo().frame(newFrameForCreatePartFrame).switchTo().frame(newFrameForm).switchTo().frame(newFrameForm2);
            withTimeoutOf(Duration.ofSeconds(100)).waitFor(collapseAllBtn).click();
            if ($(targetLifecycleField).isCurrentlyVisible()) {
                updateLifecycle(targetLifecycleFields, targetLifecycleField, itemType, targetLifecycle);
            } else if ($(targetLifecycleField2).isCurrentlyVisible()) {
                updateLifecycle(targetLifecycleFields2, targetLifecycleField2, itemType, targetLifecycle);
            }
            finalizeLifecycleUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    private void updateLifecycle(List<WebElementFacade> lifecycleFields, WebElement lifecycleField, String itemType, String targetLifecycle) {
        lifecycleFields.forEach(targetLifecycleEle -> {

            $(lifecycleField).click();
            waitABit(2000);
            $(lifecycleField).click();
            waitABit(2000);

            switch (targetLifecycle) {
                case "Released":
                    selectLifecycleOption("Released");
                    break;
                case "Obsolete":
                    selectLifecycleOption("Obsolete");
                    break;
                case "Suppressed":
                    selectLifecycleOption("Suppressed");
                    break;
                default:
                    System.out.println("LifeCycle is not defined");
            }
        });


    }

    private void selectLifecycleOption(String targetLifeCycle) {
        action.keyDown(Keys.SHIFT).sendKeys(Keys.HOME).keyUp(Keys.SHIFT).perform();
        reusableUtilities.pressBackspace();
        $(Serenity.getDriver().switchTo().activeElement()).type(targetLifeCycle);
        waitABit(2000);
        reusableUtilities.pressDownNavigation();
        waitABit(2000);
        reusableUtilities.pressEnterWithoutElement();
        waitABit(2000);
    }

    private void finalizeLifecycleUpdate() {
        waitABit(2000);
        $(currentLifecycle).click();
        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(newFrameForCreatePartFrame);
        $(doneBtn).click();
        waitABit(3000);
    }

    public void clicksOnDone() {
        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(newFrameForCreatePartFrame);
        $(doneBtn).click();
        waitABit(3000);
        reusableMethods.waitUntilArasSpinnerToDisappear();
    }

    private void pressNavigationDown(int noOfTimes) {
        for (int i = 1; i <= noOfTimes; i++) {
            reusableUtilities.pressDownNavigation();
            waitABit(1000);
        }
    }

    public void updateAssignmentInEco(String userName) {
        // Switch to parent frame and click on More and Update Assignment buttons
        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(parentFrame);
        waitForElementToBeClickable(moreButtonECO).click();
        waitForElementToBeClickable(updateAssignmentBtn).click();

        // Switch to the appropriate dialog iframe and form frame
        Serenity.getDriver().switchTo().frame(dialogueIframe).switchTo().frame(formFrame);
        waitABit(2000);

        // Check the append assignment checkbox using JavaScript executor
        js.executeScript("arguments[0].click();", appendAssignmentCheckbox);
        waitABit(2000);

        // Add comments and select assignments
        withTimeoutOf(Duration.ofSeconds(100)).waitFor(updateAssignmentComments).sendKeys("Please approve");
        withTimeoutOf(Duration.ofSeconds(100)).waitFor(selectAssignmentsBtn).click();

        // Switch to the dialog iframe and clear search criteria
        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(dialogueIframe);
        waitABit(4000);
        waitForElementToBeClickable(clearSearchCriteria).click();
        waitABit(4000);

        // Search for the user by name
        withTimeoutOf(Duration.ofSeconds(100)).waitFor(nameFieldInIdentities).click();
        waitABit(2000);
        $(Serenity.getDriver().switchTo().activeElement()).typeAndEnter(userName);
        waitABit(2000);

        // Wait for search results and confirm selection
        withTimeoutOf(Duration.ofSeconds(100)).waitFor(searchResultsInGrid);
        waitABit(2000);
        waitForElementToBeClickable(searchOkBtn).click();

        // Return to form frame and submit the assignment update
        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(parentFrame).switchTo().frame(dialogueIframe).switchTo().frame(formFrame);
        waitABit(3000);
        waitForElementToBeClickable(submitBtn).click();
        waitABit(3000);

        // Close the dialog and return to the parent frame
        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(parentFrame);
        waitABit(3000);
        withTimeoutOf(Duration.ofSeconds(100)).waitFor(closeBtn).click();
    }

    private WebElement waitForElementToBeClickable(WebElement element) {
        return withTimeoutOf(Duration.ofSeconds(100)).waitFor(element).waitUntilClickable();
    }


    public void userShouldSelectTheOwnerApprovalCheckbox() throws Exception {
        try {
            // Switch to the parent frame
            Serenity.getDriver().switchTo().defaultContent();
            withTimeoutOf(Duration.ofSeconds(180)).waitFor(parentFrame);
            Serenity.getDriver().switchTo().frame(parentFrame);

            withTimeoutOf(Duration.ofSeconds(180)).waitFor(ecoAssignmentsRelationshipFrame);
            // Switch to the ECO Assignments Relationship frame
            Serenity.getDriver().switchTo().frame(ecoAssignmentsRelationshipFrame);

            // Select all owner approval checkboxes if not already selected
            for (WebElementFacade checkBox : ownerApprovalCheck) {
                Serenity.getDriver().switchTo().parentFrame();

                // Click on the edit button
                reusableMethods.clickOnEdit();
                waitABit(5000);

                Serenity.getDriver().switchTo().frame(ecoAssignmentsRelationshipFrame);

                if (!checkBox.isSelected()) {
                    WebElement siblingSpan = checkBox.findElement(By.xpath("following-sibling::span"));
                    siblingSpan.click();
                }

                // Switch back to the parent frame and click the done button
                Serenity.getDriver().switchTo().parentFrame();
                $(doneBtn).click();
            }

        } catch (Exception e) {
            throw new Exception("Error occurred while selecting the owner approval checkbox: " + e.getMessage(), e);
        }
    }


    WebDriver driver = getDriver();

    public void loadAllTableData() {
        int previousRowCount = 0;
        int currentRowCount = tableRows.size();

        JavascriptExecutor js = (JavascriptExecutor) driver;

        while (currentRowCount > previousRowCount) {
            previousRowCount = currentRowCount;
            js.executeScript("arguments[0].scrollTop = arguments[0].scrollHeight;", scrollContainer);
            waitABit(2000);
            currentRowCount = tableRows.size();
        }
    }

    public void scrollToTop() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollTop = 0;", scrollContainer);
        waitABit(2000);
    }

    public void searchMultipleItemNumbersAndUpdateTheTargetLifeCycle(List<String> itemNumbersToFind, String targetLifecycle) throws Exception {

        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(newFrameForCreatePartFrame).switchTo().frame(newFrameForm).switchTo().frame(newFrameForm2);

        boolean wasScrolled = false; // Flag to track if previous check required scrolling down

        for (String itemNumber : itemNumbersToFind) {
            boolean isNumberPresent = isItemNumberVisible(itemNumber);

            if (!isNumberPresent) {
                System.out.println(itemNumber + " not found, scrolling to load more data...");
                loadAllTableData();
                isNumberPresent = isItemNumberVisible(itemNumber);
                wasScrolled = true; // We scrolled, so we may need to reset position for next check
            }
            if (isNumberPresent) {
                System.out.println("Item Number Found: " + itemNumber);
                for (WebElement row : tableRows) {
                    WebElement numberCell = row.findElement(By.cssSelector("td[idx='0'] a.gridLink"));
                    if (numberCell.getText().trim().equalsIgnoreCase(itemNumber)) {
                        WebElement statusCell = row.findElement(By.cssSelector("td[idx='5']"));
                        System.out.println(statusCell.getText() + "status");
                        if (!statusCell.getText().equalsIgnoreCase("Released")) {
                            statusCell.click();
                            waitABit(2000);
                            statusCell.click();
                            waitABit(2000);
                            selectLifecycleOption(targetLifecycle);
                            WebElement currentLifeCycle = row.findElement(By.cssSelector("td[idx='3']"));
                            waitABit(2000);
                            currentLifeCycle.click();
                            break;
                        }
                    }
                }
                waitABit(3000);
            } else {
                System.out.println("Item Number NOT Present: " + itemNumber);
            }

            // If we scrolled down for the previous item, scroll back up before checking the next one
            if (wasScrolled) {
                System.out.println("Scrolling back to the top before checking the next item...");
                scrollToTop();
                wasScrolled = false; // Reset flag
            }
        }

    }

    private boolean isItemNumberVisible(String itemNumber) {
        for (WebElement item : itemNumbers) {
            if (item.getText().trim().equalsIgnoreCase(itemNumber)) {
                return true;
            }
        }
        return false;
    }


    public void maximizeAndRestoreThePage(String action) {
        reusableMethods.waitUntilArasSpinnerToDisappear();
        Serenity.getDriver().switchTo().defaultContent();
        withTimeoutOf(Duration.ofSeconds(180)).waitFor(parentFrame);
        Serenity.getDriver().switchTo().frame(parentFrame);
        waitABit(3000);
        WebDriver driver = Serenity.getDriver();
        // Locate the shadow host element
        withTimeoutOf(Duration.ofSeconds(180)).waitFor(maximizeHostElement);
        WebElement shadowHost = driver.findElement(By.xpath("(//aras-scroller[@id='formTab']//aras-accordion)[2]"));
        // Get shadow root using JavaScript
        SearchContext shadowRoot = (SearchContext) js.executeScript("return arguments[0].shadowRoot", shadowHost);
        // Find the maximize button inside shadow DOM
        WebElement maximizeButton = shadowRoot.findElement(By.cssSelector("button[aria-label='" + action + "']"));
        // Click the maximize button
        withTimeoutOf(Duration.ofSeconds(180)).waitFor(maximizeButton).waitUntilClickable().click();
    }

    public void userShouldCompleteTheSignOffProcessOfECO(List<String> itemCodes) throws Exception {
        String ecoNumber = fetchECONumber();
        ItemCodeStore.storeTheData("ecoNum", ecoNumber);
        switchToECOWorkflowFrame();
        while (!isECOReleased()) {
            if (isECOInWorkState()) {
                checkForCompletenessInECO();
            }
            String activeUser = completeCurrentVoteAndGetTheNameOfNextApprover();
            System.out.println("next approver is: " + activeUser);
            if (isECOReleased()) break;
            if (activeUser != null) {
                if (!isCurrentUser(activeUser)) {
                    switchToUserAndContinue(activeUser, ecoNumber);
                } else {
                    System.out.println("next approver and current login user same");
                }
            } else {
                break;
            }
        }
    }

    public void switchToECOWorkflowFrame() {
        Serenity.getDriver().switchTo().defaultContent();
        withTimeoutOf(Duration.ofSeconds(60)).waitFor(newFrameForCreatePartFrame);
        Serenity.getDriver().switchTo().frame(newFrameForCreatePartFrame);
        if ($(newFrameForm1).isCurrentlyVisible()) {
            Serenity.getDriver().switchTo().frame(newFrameForm1).switchTo().frame(newFrameForm2).switchTo().frame(newFrameToSeeSubFamilyWorkFlow);
        } else {
            Serenity.getDriver().switchTo().frame(newFrameForm).switchTo().frame(newFrameForm2).switchTo().frame(newFrameToSeeSubFamilyWorkFlow);
        }
    }

    public void validateR10903ParameterAvailableOrNot(List<String> itemCodes) {
        itemCodes.forEach(itemCode -> {
            try {
                userOpensPartFromAffectedItems(itemCode);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            waitABit(3000);
            partPage.userClicksOnTab("Parameters");
            validateR10903TextValue("R10903", ItemCodeStore.getStoredData("PTEMPCode"));
            waitABit(2000);
            partPage.userClicksOnTab("SignOffs");
        });
    }

    public void opensPartFromAffectedItems(String itemCode) {
        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(newFrameForCreatePartFrame);
        withTimeoutOf(Duration.ofSeconds(100)).waitFor(affectedItemsTab);
        $(affectedItemsTab).click();
        Serenity.getDriver().switchTo().frame(newFrameForm).switchTo().frame(newFrameForm2);
        withTimeoutOf(Duration.ofSeconds(100)).waitFor(collapseAllBtn).click();
        if ($(By.xpath("(//a[@class='gridLink' and text()='" + itemCode + "'])[2]")).isCurrentlyVisible()) {
            withTimeoutOf(Duration.ofSeconds(100)).waitFor(By.xpath("(//a[@class='gridLink' and text()='" + itemCode + "'])[2]")).click();
        } else {
            withTimeoutOf(Duration.ofSeconds(100)).waitFor(By.xpath("//*[text()='" + itemCode + "']")).click();
        }
    }

    public String fetchECONumber() {
        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(parentFrame).switchTo().frame(childFrame);
        return $(ecoNumberField).getAttribute("value").trim();
    }

    public boolean isCurrentUser(String activeUser) {
        Serenity.getDriver().switchTo().defaultContent();
        String title = $(currentUserDetails).getAttribute("title");
        System.out.println("Current Login User is: " + title);
        return title.equalsIgnoreCase(activeUser);
    }

    public String retrieveActiveUserAndInitiateVoteProcess() throws Exception {
        switchToECOWorkflowFrame();
        if (isVoteNowButtonVisible()) {
            System.out.println("Vote Now is visible");
            String activeApproverName = assignedTo.getText().trim();
            withTimeoutOf(Duration.ofSeconds(60)).waitFor(voteNowBtn).click();
            String activity = activityType.getText().trim();
            System.out.println("Activity: " + activity);
            completeVoteProcess(activity);
            isParameterValidationErrorMessageDisplayed();
            checkAnyUnwantedErrorsIsDisplayed();
            return activeApproverName;
        } else {
            if (activeButton.isCurrentlyVisible()) {
                System.out.println("Vote Now is not visible but Active is visible");
                String nextApprovesName = assignedTo.getText().trim();
                System.out.println("Next Vote is assigned to: " + nextApprovesName);
                return nextApprovesName;
            } else {
                System.out.println("Vote Now and Active both are not visible");
                return null; // No active user found
            }
        }

    }

    public String completeCurrentVoteAndGetTheNameOfNextApprover() {
        try {
            switchToECOWorkflowFrame();
            if (isVoteNowButtonVisible()) {
                System.out.println("Vote Now is visible");
                String activeApproverName = assignedTo.getText().trim();
                voteNowBtn.click();
                String activity = activityType.getText().trim();
                System.out.println("Activity: " + activity);
                completeVoteProcess(activity);
                //isParameterValidationErrorMessageDisplayed();
                checkAnyUnwantedErrorsIsDisplayed();
                return activeApproverName;
            } else if (activeButton.isCurrentlyVisible()) {
                System.out.println("Vote Now is not visible but Active is visible");
                String nextApproverName = assignedTo.getText().trim();
                System.out.println("Next Vote is assigned to: " + nextApproverName);
                return nextApproverName;
            } else {
                System.out.println("Vote Now and Active both are not visible");
                return null; // No active user found
            }
        } catch (Exception e) {
            e.printStackTrace(); // Consider using a logging framework
            return null;
        }
    }

    public void checkAnyUnwantedErrorsIsDisplayed() throws Exception {
        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(parentFrame);
        if ($(errorMessage).isCurrentlyVisible()) {
            String errorMessageText = $(errorMessage).getText();
            waitABit(5000);
            throw new Exception("An error occurred: " + errorMessageText);
        }
    }

    public boolean isVoteNowButtonVisible() {
        switchToECOWorkflowFrame();
        try {
            if (voteNowBtn.isCurrentlyVisible()) {
                return $(voteNowBtn).isCurrentlyVisible();
            } else {
                System.out.println("Vote Now button is not visible immediately so waiting......");
                withTimeoutOf(Duration.ofSeconds(60)).waitFor(voteNowBtn);
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    private void isCreatorOwnerNotAllowedErrorMessageDisplayed() throws Exception {
        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(parentFrame);
        if ($(creatorOwnerErrorMsg).isCurrentlyVisible()) {
            handleCreatorOwnerNotAllowedErrorAndRetryApproval();
            switchToECOWorkflowFrame();
            $(voteNowBtn).click();
        } else {
            System.out.println("Creator Owner Not Allowed Error Message not Displayed");
        }
    }

    private void isParameterValidationErrorMessageDisplayed() throws Exception {
        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(parentFrame);
        if (parameterValidationErrorMsg.isCurrentlyVisible()) {
            System.out.println("Parameter Validation for DIMS.......");
            handleParameterValidationError();
        } else if (parameterValidationErrorMsg2.isCurrentlyVisible()) {
            System.out.println("Parameter Validation for PackagingItems.......");
            handleParameterValidationError();
            // handleParameterValidationErrorForPackagingItems();
        }
    }

    private void handleCreatorOwnerNotAllowedErrorAndRetryApproval() throws Exception {
        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(parentFrame);
        alertOkButton.click(); // Click 'OK' on the error message
        partPage.userClicksOnTab("Assignments"); // Navigate to the 'Assignments' tab
        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(parentFrame);
        editButton.click();
        userShouldSelectTheOwnerApprovalCheckbox(); // Select the owner approval checkbox
        waitABit(2000);
        partPage.userClicksOnTab("SignOffs"); // Navigate to the 'SignOffs' tab
    }

    public void completeVoteProcess(String activity) {
        validateWorkflowWindow(); // Validate the workflow window
        if (activity.trim().equalsIgnoreCase("Submit")) {
            userSelectsSendToReviewVoteList("Start Work");
        } else if (activity.trim().equalsIgnoreCase("Draft")) {
            userSelectsSendToReviewVoteList("Submit for Approval");
        } else if (activity.trim().equalsIgnoreCase("Approval") || activity.trim().contains("1st Approval") || activity.trim().contains("Management Approval")) {
            userShouldEnterTheEsignature();
            userSelectsSendToReviewVoteList("Approve Change");
        } else {
            throw new RuntimeException("Unknown activity type: " + activity);
        }
        userClicksCompleteButton(); // Finalize the process
    }


    public void userShouldEnterTheEsignature() {
        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(newFrameForCreatePartFrame);
        withTimeoutOf(Duration.ofSeconds(100)).waitFor(newFrameForWorkFlow);
        Serenity.getDriver().switchTo().frame(newFrameForWorkFlow);
        $(eSignatureField).sendKeys("innovator");
    }

    public void switchToUserAndContinue(String nextVoteAssignedUser, String ecoNumber) throws IOException {
        String[] credentials = retrieveUserCredentials("src/test/resources/TestData/UserCredentials.xlsx", "Sheet1", nextVoteAssignedUser);
        System.out.println(Arrays.toString(credentials) + "Credentials");
        if (credentials != null) {
            performLogOutLoginAndNavigateToECO(credentials[0], ecoNumber);
        } else {
            updateAssignmentInEco(getCurrentLoginUserName());
        }
    }

    public void performLogOutLoginAndNavigateToECO(String credentials, String ecoNumber) {
        arasLoginPageObjects.logOutAndLogin();
        arasLoginPageObjects.Login(credentials);
        arasHomePage.verifyHomePage();
        arasHomePage.navigating("Change Management/ECOs/Search ECOs");
        searchECOItemsFromSearchSection(ecoNumber);
        partPage.userClicksOnTab("SignOffs");
    }

    public String getCurrentLoginUserName() {
        Serenity.getDriver().switchTo().defaultContent();
        return $(currentUserDetails).getAttribute("title");
    }

    public boolean isECOReleased() {
        String statusField = validateECOWorkFlowStatus();
        System.out.println("ECO current state is: " + statusField);
        return statusField.equalsIgnoreCase("Released");
    }

    public boolean isECOInReviewState() {
        String statusField = validateECOWorkFlowStatus();
        return statusField.equalsIgnoreCase("In Review");
    }

    public boolean isECOInWorkState() {
        String statusField = validateECOWorkFlowStatus();
        return statusField.equalsIgnoreCase("In Work");
    }

    // Handle parameter validation error and resolve the issue
    private void handleParameterValidationError() throws Exception {
        try {
            switchToCorrectFrame(); // Switch to the correct frame based on visibility
            waitABit(5000);

            String parameterValidationErrorText = alertMessage.getText(); // Get the alert text

            System.out.println("Parameter Validation : " + parameterValidationErrorText);

            // Switch back to the default content and the parent frame
            Serenity.getDriver().switchTo().defaultContent().switchTo().frame(parentFrame);

            alertOkButton.click(); // Dismiss the alert For Parameter Validation
            closeTheECOWorkFlowActivityCompletionPopup(); // Close workflow activity completion popup

            // Extract mandatory Parameter numbers from the Validation error message
            Map<String, Set<String>> mandatoryValuesMap = extractMandatoryValuesForDims(parameterValidationErrorText);

            System.out.println("Parameter Validation on the Part Num : " + ItemCodeStore.getStoredData("affectedItem"));

            // Open the affected part item for error validation
            userOpensPartFromAffectedItems(ItemCodeStore.getStoredData("affectedItem"));

            // Wait for the page to load and navigate to the Parameters tab
            waitABit(10000);
            partPage.userClicksOnTab("Parameters");

            // Iterate through the mandatory parameters and update the values using streams
            mandatoryValuesMap.forEach((parameterNumber, valuesSet) -> {
                String values = String.join(",", valuesSet); // Join the values as comma-separated
                theParameterShouldBeFilledWithValueAndItsDataTypeShouldBe(parameterNumber, values);
            });

            // Wait for the updates and refresh the page
            waitABit(3000);
            Serenity.getDriver().navigate().refresh();
            waitABit(7000);

            // Verify home page and navigate to the ECO search
            home.verifyHomePage();
            arasHomePage.navigating("Change Management/ECOs/Search ECOs");
            searchECOItemsFromSearchSection(ItemCodeStore.getStoredData("ecoNum"));
            partPage.userClicksOnTab("SignOffs");

        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage(), e); // Re-throw with the error message and stack trace
        }
    }

    private void handleParameterValidationErrorForPackagingItems() throws Exception {
        try {
            switchToCorrectFrame(); // Switch to the correct frame based on visibility
            String parameterValidationErrorText = $(alertMessage).getText(); // Get the alert text

            // Switch back to the default content and the parent frame
            Serenity.getDriver().switchTo().defaultContent().switchTo().frame(parentFrame);

            $(alertOkButton).click(); // Dismiss the alert
            closeTheECOWorkFlowActivityCompletionPopup(); // Close any related workflow activity completion popup

            // Extract mandatory values from the error message
            List<String> mandatoryValuesMap = extractParameterNumbersForPackagingItems(parameterValidationErrorText);

            // Open the affected part item for error validation
            userOpensPartFromAffectedItems(ItemCodeStore.getStoredData("affectedItem"));

            // Wait for the page to load and navigate to the Parameters tab
            waitABit(10000);
            partPage.userClicksOnTab("Parameters");

            // Iterate through the mandatory parameters and update the values using streams
            mandatoryValuesMap.forEach((parameterNumber) -> {
                theParameterShouldBeFilledWithValueAndItsDataTypeShouldBe(parameterNumber, "");
            });

            // Wait for the updates and refresh the page
            waitABit(3000);
            Serenity.getDriver().navigate().refresh();
            waitABit(7000);

            // Verify home page and navigate to the ECO search
            home.verifyHomePage();
            arasHomePage.navigating("Change Management/ECOs/Search ECOs");
            searchECOItemsFromSearchSection(ItemCodeStore.getStoredData("ecoNum"));
            partPage.userClicksOnTab("SignOffs");

        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage(), e); // Re-throw with the error message and stack trace
        }
    }

    private void switchToCorrectFrame() {
        Serenity.getDriver().switchTo().defaultContent();

        // Check visibility of frames and switch accordingly
        if ($(newFrameForCreatePartFrame).isCurrentlyVisible()) {
            Serenity.getDriver().switchTo().frame(newFrameForCreatePartFrame);
        } else if ($(newFrameForCreatePartFrame2).isCurrentlyVisible()) {
            Serenity.getDriver().switchTo().frame(newFrameForCreatePartFrame2);
        } else if ($(newFrameForCreatePartFrame3).isCurrentlyVisible()) {
            Serenity.getDriver().switchTo().frame(newFrameForCreatePartFrame3);
        }
    }

    public static String[] retrieveUserCredentials(String filePath, String sheetName, String targetName) throws IOException {
        FileInputStream fis = new FileInputStream(filePath); // Open the Excel file and access the specified sheet
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet(sheetName);

        Iterator<Row> rowIterator = sheet.iterator(); // Iterate through each row in the sheet
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            Cell nameCell = row.getCell(0);

            if (nameCell.getStringCellValue().equalsIgnoreCase(targetName)) { // If the target name matches the first column, retrieve the credentials
                String username = row.getCell(1).getStringCellValue();
                String password = row.getCell(2).getStringCellValue();
                workbook.close();  // Close the workbook and return the credentials
                return new String[]{username, password};
            }
        }

        workbook.close();  // Close the workbook if the target name is not found
        return null;  // Return null if no matching entry is found
    }

    public void rightClickAndClickOnAddToChange() {
        Serenity.getDriver().switchTo().defaultContent();
        withTimeoutOf(Duration.ofSeconds(180)).waitFor(parentFrame);
        Serenity.getDriver().switchTo().frame(parentFrame);
        waitABit(2000);
        reusableUtilities.pressControlA();
        waitABit(2000);
        action.contextClick(firstEleInSearchResult).perform();
        userClicksOnAddItemSToChange();
    }

    public void userClicksOnAddItemSToChange() {
        Serenity.getDriver().switchTo().defaultContent();
        withTimeoutOf(Duration.ofSeconds(120)).waitFor(parentFrame);
        Serenity.getDriver().switchTo().frame(parentFrame);
        withTimeoutOf(Duration.ofSeconds(120)).waitFor(PartPageDev.moreButtonFromSearchPage).click();
        withTimeoutOf(Duration.ofSeconds(120)).waitFor(PartPageDev.addToChangeButton).click();
        Serenity.getDriver().switchTo().defaultContent();
        withTimeoutOf(Duration.ofSeconds(180)).waitFor(dialogueFrame);
        Serenity.getDriver().switchTo().frame(dialogueFrame).switchTo().frame(formFrame);
        withTimeoutOf(Duration.ofSeconds(180)).waitFor(PartPageDev.addToChangeOkButton).click();
    }

    public void searchAndOpenMigratedPart(String itemType, String subFamily, String productGroup) throws Exception {
        try {
            Serenity.getDriver().switchTo().defaultContent();
            withTimeoutOf(Duration.ofSeconds(180)).waitFor(parentFrame);
            Serenity.getDriver().switchTo().frame(parentFrame);

            // Filling out the search form
            fillSearchFields(itemType, subFamily, productGroup);

            // Wait until the search results are ready
            waitForSearchResults(subFamily);

            // Set pagination (if needed)
            // setPagination();

            // Handle the search result and open the part
            openPartFromSearchResults();

            reusableMethods.recordReportData("Searching For Migrated Part", "Migrated Part found for combination of " + itemType + " - " + subFamily + " - " + productGroup);

        } catch (Exception e) {
            reusableMethods.recordReportData("Error Searching For Migrated Part", "Failed to find migrated part for combination of " + itemType + " - " + subFamily + " - " + productGroup + ". Error: " + e.getMessage());
            throw new Exception("Error Searching For Migrated Part. Details: " + e.getMessage(), e);
        }
    }

    public void searchAndOpenMigratedParts(String itemCode) throws Exception {
        try {
            Serenity.getDriver().switchTo().defaultContent();
            withTimeoutOf(Duration.ofSeconds(180)).waitFor(parentFrame);
            Serenity.getDriver().switchTo().frame(parentFrame);

            withTimeoutOf(Duration.ofSeconds(120)).waitFor(clearSearchCriteria);
            $(clearSearchCriteria).click();
            waitABit(2000);

            withTimeoutOf(Duration.ofSeconds(180)).waitFor(itemNumberInPartSearch).click();
            waitABit(2000);
            $(Serenity.getDriver().switchTo().activeElement()).type(itemCode);

            withTimeoutOf(Duration.ofSeconds(180)).waitFor(runSearchButton).click();

            withTimeoutOf(Duration.ofSeconds(180)).waitFor(By.xpath("//*[text()='" + itemCode + "']"));

            action.moveToElement($(By.xpath("//*[text()='" + itemCode + "']"))).doubleClick().build().perform();

            Serenity.getDriver().switchTo().defaultContent();
            withTimeoutOf(Duration.ofSeconds(180)).waitFor(TheSecondOpenedTab);
            waitABit(2000);
            withTimeoutOf(Duration.ofSeconds(180)).waitFor(closeTheFirstOpenedTab).click();

            Serenity.getDriver().switchTo().defaultContent();
            withTimeoutOf(Duration.ofSeconds(180)).waitFor(parentFrame);
            Serenity.getDriver().switchTo().frame(parentFrame);
            withTimeoutOf(Duration.ofSeconds(180)).waitFor(childFrame);
            Serenity.getDriver().switchTo().frame(childFrame);

            String subFamilyText = withTimeoutOf(Duration.ofSeconds(120)).waitFor(subFamilyField).getAttribute("value");

            String productGroupText = withTimeoutOf(Duration.ofSeconds(120)).waitFor(getProductGroup).getAttribute("value");

            System.out.println(subFamilyText + "----" + productGroupText);

            ItemCodeStore.storeTheData("subFamilyText", subFamilyText);

            ItemCodeStore.storeTheData("productGroupText", productGroupText);

        } catch (Exception e) {
            throw new Exception("Error Searching For Migrated Part. Details: " + e.getMessage(), e);
        }
    }

    public void performSaveAs() {
        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(newFrameForCreatePartFrame);

        // Click on "More" button and "Save As"
        $(moreButton).waitUntilClickable().click();
        $(buttonSaveAs).waitUntilClickable().click();

        // Restore Preferences or Configuration
        Serenity.getDriver().switchTo().defaultContent();
        Serenity.getDriver().switchTo().frame(dialogueIframe).switchTo().frame(frmItemForm);
        waitABit(2000);

        withTimeoutOf(3000, TimeUnit.SECONDS).waitFor(btnRestorePreferences).click();
        waitABit(2000);
        getDriver().switchTo().alert().accept();
        waitABit(2500);

        // Move list values from left side list to right side
        withTimeoutOf(2000, TimeUnit.SECONDS).waitFor(listAvailableProperties).click();
        Serenity.getDriver().switchTo().activeElement().sendKeys(Keys.chord(Keys.CONTROL, "a"));
        waitABit(2000);

        withTimeoutOf(2000, TimeUnit.SECONDS).waitFor(listAvailableRelationships).click();
        Serenity.getDriver().switchTo().activeElement().sendKeys(Keys.chord(Keys.CONTROL, "a"));
        waitABit(2000);

        withTimeoutOf(2000, TimeUnit.SECONDS).waitFor(buttonGraterThanTwice).click();
        waitABit(2000);

        // Select required values from right side list
        String strSelectedProperties[] = {"Sub Family", "Item Description", "Purpose", "Product Group"};
        for (int i = 0; i <= strSelectedProperties.length - 1; i++) {
            if ($(By.xpath("//select[@id='selectedProperties']/option[text()='" + strSelectedProperties[i] + "']")).isCurrentlyVisible()) {
                $(By.xpath("//select[@id='selectedProperties']/option[text()='" + strSelectedProperties[i] + "']")).click();
                waitABit(500);
                Assert.assertTrue("The " + strSelectedProperties[i] + " is appearing in the Selected Properties box.", true);
            } else {
                Assert.fail();
            }
        }

        String strSelectedRelationships[] = {"BOM", "Parameters", "Vendors"};
        for (int j = 0; j <= strSelectedRelationships.length - 1; j++) {
            if ($(By.xpath("//select[@id='selectedRelationships']/option[text()='" + strSelectedRelationships[j] + "']")).isCurrentlyVisible()) {
                $(By.xpath("//select[@id='selectedRelationships']/option[text()='" + strSelectedRelationships[j] + "']")).click();
                waitABit(500);
                Assert.assertTrue("The " + strSelectedRelationships[j] + " is appearing in the Selected Relationships box.", true);
            } else {
                Assert.fail();
            }
        }

        // Click on Confirm button from Save As form
        withTimeoutOf(2000, TimeUnit.SECONDS).waitFor(btnConfirm).click();
        waitABit(2000);

        // Close the previous tab
        Serenity.getDriver().switchTo().defaultContent();
        withTimeoutOf(2000, TimeUnit.SECONDS).waitFor(closeTab).click();
        waitABit(2000);

        // Click on Done button
        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(newFrameForCreatePartFrame);
        withTimeoutOf(2000, TimeUnit.SECONDS).waitFor(btnDone).click();
        waitABit(5000);

    }

    private void fillSearchFields(String itemType, String subFamily, String productGroup) {
        partSearchItemType.waitUntilEnabled().sendKeys(itemType);
        waitABit(1000);

        partSearchSubfamily.sendKeys(subFamily);
        waitABit(1000);

        partSearchLifecycle.waitUntilEnabled().sendKeys("Released");
        waitABit(1000);

        purposeSearchField.waitUntilEnabled().sendKeys("Commercial");
        pressTabs(6);

        productGroupField.waitUntilEnabled().sendKeys(productGroup);
        waitABit(1000);

        partChangesField.waitUntilEnabled().sendKeys("0");
        waitABit(2000);

        pressTabs(6);

        partSearchMigratedField.waitUntilEnabled().sendKeys("1");
        pressShiftTabs(16);
    }

    private void pressTabs(int times) {
        IntStream.range(0, times).forEach(j -> {
            waitABit(1000);
            reusableUtilities.pressTab();
        });
    }

    private void pressShiftTabs(int times) {
        IntStream.range(0, times).forEach(j -> {
            waitABit(1000);
            reusableUtilities.pressShiftTab();
        });
    }

    private void waitForSearchResults(String subFamily) throws Exception {
        try {
            waitABit(1000);
            paginationPageSize.waitUntilEnabled().click();
            reusableUtilities.pressControlA();
            $(Serenity.getDriver().switchTo().activeElement()).sendKeys("5");
            waitABit(2000);
            reusableUtilities.pressEnterWithoutElement();
            withTimeoutOf(Duration.ofSeconds(180)).waitFor(firstEleInSearchResult);
            String subFamilyText = subFamilyTextSearch.getAttribute("textContent");
            System.out.println(subFamilyText + "Subfamily Text in search page...");
            System.out.println(subFamily + "Subfamily in excel file...");
            if (!subFamilyText.trim().equalsIgnoreCase(subFamily.trim())) {
                throw new Exception("Search Subfamily mismatch");
            }
        } catch (Exception e) {
            throw new Exception("Error Searching For Migrated Part. Details: " + e.getMessage(), e);
        }
    }

    private void setPagination() {
        paginationButton.waitUntilEnabled().click();
        paginationLastPageNumber.waitUntilVisible();
        String lastPage = paginationLastPageNumber.getText().substring(3);
        paginationCurrentPageNumberField.waitUntilEnabled().click();
        reusableUtilities.pressControlA();
        paginationCurrentPageNumberField.sendKeys(lastPage);
        reusableUtilities.pressEnterWithoutElement();
        reusableMethods.waitUntilElementVisible(searchResults);
    }

    private void openPartFromSearchResults() {
        $(firstEleInSearchResult).waitUntilClickable();
        waitABit(10000);
        // Move to the search results and double-click to open the part
        action.moveToElement(firstEleInSearchResult).doubleClick().build().perform();
        // If the part isn't opened, double-click again
        if (!$(TheSecondOpenedTab).isCurrentlyVisible()) {
            action.moveToElement(firstEleInSearchResult).doubleClick().build().perform();
        }
        reusableMethods.closeFirstOpenedTab();
    }

    public String getItemCode() throws Exception {
        try {
            waitABit(5000);
            Serenity.getDriver().switchTo().defaultContent();
            withTimeoutOf(Duration.ofSeconds(180)).waitFor(parentFrame);
            Serenity.getDriver().switchTo().frame(parentFrame).switchTo().frame(childFrame);
            withTimeoutOf(Duration.ofSeconds(180)).waitFor(itemCodeField);
            return itemCodeField.getAttribute("value").trim();
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    public String getECONumber() throws Exception {
        try {
            waitABit(5000);
            Serenity.getDriver().switchTo().defaultContent();
            withTimeoutOf(Duration.ofSeconds(180)).waitFor(parentFrame);
            Serenity.getDriver().switchTo().frame(parentFrame);
            withTimeoutOf(Duration.ofSeconds(180)).waitFor(refreshButton).click();
            Serenity.getDriver().switchTo().frame(childFrame);
            js.executeScript("arguments[0].scrollIntoView();", itemCodeField);
            withTimeoutOf(Duration.ofSeconds(180)).waitFor(itemCodeField);
            return itemCodeField.getAttribute("value").trim();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }

    }

    public String fetchIntegrationResults() {
        String integrationTabResponse = "Error fetching integration results";
        WebDriver driver = Serenity.getDriver();

        try {
            driver.switchTo().defaultContent().switchTo().frame(newFrameForCreatePartFrame).switchTo().frame(newFrameOfIntegrationResultsTab);

            // Wait until the search button is clickable and initiate search
            $(runSearchButton).waitUntilClickable().click();

            // Check if the response text is visible
            if ($(responseText).isCurrentlyVisible()) {
                return "Material Master distribution successful, 021(ZDGXU_MM)";
            } else {
                waitABit(70000);
                $(runSearchButton).waitUntilClickable().click();
                waitABit(3000);
                integrationTabResponse = $(responseElement).waitUntilVisible().getText();
                if (integrationTabResponse.isEmpty()) {
                    return "Response is Empty";
                } else {
                    return integrationTabResponse;
                }
            }

        } catch (NoSuchFrameException e) {
            integrationTabResponse = "Frame not found: " + e.getMessage();
            System.err.println(integrationTabResponse);
        } catch (TimeoutException e) {
            integrationTabResponse = "Timeout waiting for element: " + e.getMessage();
            System.err.println(integrationTabResponse);
        } catch (Exception e) {
            integrationTabResponse = "Error fetching integration results: " + e.getMessage();
            System.err.println(integrationTabResponse);
        }

        return integrationTabResponse;
    }

    public void validateTheLifeCycle(String lifecycle) throws Exception {
        try {
            Serenity.getDriver().switchTo().defaultContent();
            withTimeoutOf(Duration.ofSeconds(180)).waitFor(secondParentFrame);
            Serenity.getDriver().switchTo().frame(secondParentFrame).switchTo().frame(childFrame);
            waitABit(3000);
            String partLifecycle = $(By.xpath("//input[@name='pmi_target_lc']")).getAttribute("value");
            if (lifecycle.equalsIgnoreCase(partLifecycle)) {
                Assert.assertTrue(true); // Lifecycle is as expected
            } else {
                throw new Exception("Test Fail: Part lifeCycle is not in " + lifecycle + " state, current state is: " + partLifecycle);
            }
        } catch (Exception e) {
            throw new Exception("Error while validating lifecycle: " + e.getMessage(), e);
        }
    }

    public String getThePartID() throws Exception {
        try {
            Serenity.getDriver().switchTo().defaultContent();
            withTimeoutOf(Duration.ofSeconds(180)).waitFor(secondParentFrame);
            Serenity.getDriver().switchTo().frame(secondParentFrame);
            withTimeoutOf(Duration.ofSeconds(180)).waitFor(shareButton);
            waitABit(2000);
            $(shareButton).click();
            waitABit(1000);
            $(Serenity.getDriver().findElement(By.xpath("//span[text()='Copy ID']"))).click();

            // Retrieve part ID from clipboard
            Toolkit toolkit = Toolkit.getDefaultToolkit();
            Clipboard clipboard = toolkit.getSystemClipboard();
            Serenity.getDriver().switchTo().defaultContent();
            withTimeoutOf(Duration.ofSeconds(100)).waitFor(TheSecondOpenedTab).click();
            return (String) clipboard.getData(DataFlavor.stringFlavor);

        } catch (Exception e) {
            throw new Exception("Error while fetching Part ID: " + e.getMessage(), e);
        }
    }

    public boolean isErrorMessageDisplayed() {
        try {
            Serenity.getDriver().switchTo().defaultContent().switchTo().frame(parentFrame);
            return $(alertMessage).isCurrentlyVisible();
        } catch (Exception e) {
            System.err.println("Error checking error message visibility: " + e.getMessage());
            return false;
        }
    }

    public String getErrorMessageText() {
        try {
            Serenity.getDriver().switchTo().defaultContent().switchTo().frame(parentFrame);
            if ($(alertMessage).isCurrentlyVisible()) {
                return $(alertMessage).getText();
            }
            return "";
        } catch (Exception e) {
            System.err.println("Error fetching error message text: " + e.getMessage());
            return "";
        }
    }

    public void takeTheScreenshotsForPartsData(String folderName) throws IOException {
        Serenity.getDriver().switchTo().defaultContent();
        withTimeoutOf(Duration.ofSeconds(120)).waitFor(secondParentFrame);
        Serenity.getDriver().switchTo().frame(secondParentFrame);
        withTimeoutOf(Duration.ofSeconds(120)).waitFor(BOMTabIframe);
        Serenity.getDriver().switchTo().frame(BOMTabIframe);
        js.executeScript("arguments[0].scrollIntoView();", $(addPartsButton));
        addSearchCriteriaForBOMTab(folderName, "BOM tab");
        partPage.userClicksOnTab("Parameters");
        waitABit(2000);
        addSearchCriteria(textFieldInSearchMode, "*", folderName, "Parameters_tab_text");
        addSearchCriteria(targetFieldInSearchMode, "*", folderName, "Parameters_tab_target");
        //addSearchCriteria(listValueFieldInSearchMode, "N", folderName, "Parameters_tab_listValues");
        partPage.userClicksOnTab("Vendors");
        partPage.setZoomLevel(0.5);
        waitABit(5000);
        ExcelUtilities.captureScreenshotForPartsData(folderName, "Vendors tab");
    }

    public void addSearchCriteria(WebElementFacade targetElement, String targetValue, String folderName, String screenshotName) throws IOException {
        partPage.setZoomLevel(1.0);
        Serenity.getDriver().switchTo().defaultContent();
        withTimeoutOf(Duration.ofSeconds(120)).waitFor(secondParentFrame);
        Serenity.getDriver().switchTo().frame(secondParentFrame).switchTo().frame(ParametersIframe);
        js.executeScript("arguments[0].scrollIntoView();", searchModesInSearchDialogue);
        withTimeoutOf(Duration.ofSeconds(120)).waitFor(searchModesInSearchDialogue).selectByVisibleText("Simple");
        waitABit(2000);
        withTimeoutOf(Duration.ofSeconds(120)).waitFor(clearSearchCriteria).click();
        waitABit(2000);
        withTimeoutOf(Duration.ofSeconds(100)).waitFor(targetElement).click();
        waitABit(2000);
        $(Serenity.getDriver().switchTo().activeElement()).type(targetValue);
        runSearchButton.click();
        waitABit(2000);

        final String SHADOW_HOST_SELECTOR = "aras-input[title='Results per Page']";
        final String INPUT_SELECTOR = "input[title='Results per Page']";

        WebElement shadowHost = Serenity.getDriver().findElement(By.cssSelector(SHADOW_HOST_SELECTOR));
        SearchContext shadowRoot = (SearchContext) js.executeScript("return arguments[0].shadowRoot", shadowHost);
        WebElement inputElement = shadowRoot.findElement(By.cssSelector(INPUT_SELECTOR));

        System.out.println(inputElement.getText() + " :setSearchResults");

        inputElement.click();
        reusableUtilities.pressControlA();
        reusableUtilities.pressBackspace();
        waitABit(2000);
        inputElement.sendKeys(String.valueOf(5));
        runSearchButton.click();

        waitABit(5000);
        int pageNum = 1;
        System.out.println(nextPage.isDisabled() + " :nextPageButton");
        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(secondParentFrame).switchTo().frame(ParametersIframe);
        withTimeoutOf(Duration.ofSeconds(120)).waitFor(searchModesInSearchDialogue).selectByVisibleText("Hidden");
        ExcelUtilities.captureScreenshotForPartsData(folderName, screenshotName + "Page_" + pageNum);
        waitABit(2000);
        while (!nextPage.isDisabled()) {
            pageNum++;
            nextPage.click();
            waitABit(5000);
            ExcelUtilities.captureScreenshotForPartsData(folderName, screenshotName + "Page_" + pageNum);
        }
    }

    public void addSearchCriteriaForBOMTab(String folderName, String screenshotName) throws IOException {
        Serenity.getDriver().switchTo().defaultContent();
        withTimeoutOf(Duration.ofSeconds(120)).waitFor(secondParentFrame);
        waitABit(3000);
        Serenity.getDriver().switchTo().frame(secondParentFrame).switchTo().frame(BOMTabIframe);
        js.executeScript("arguments[0].scrollIntoView();", searchModesInSearchDialogue);
        runSearchButton.click();
        waitABit(1500);

        final String SHADOW_HOST_SELECTOR = "aras-input[title='Results per Page']";
        final String INPUT_SELECTOR = "input[title='Results per Page']";

        WebElement shadowHost = Serenity.getDriver().findElement(By.cssSelector(SHADOW_HOST_SELECTOR));
        SearchContext shadowRoot = (SearchContext) js.executeScript("return arguments[0].shadowRoot", shadowHost);
        WebElement inputElement = shadowRoot.findElement(By.cssSelector(INPUT_SELECTOR));

        System.out.println(inputElement.getText() + " :setSearchResults");

        inputElement.click();
        reusableUtilities.pressControlA();
        reusableUtilities.pressBackspace();
        waitABit(2000);
        inputElement.sendKeys(String.valueOf(5));
        runSearchButton.click();

        waitABit(5000);
        int pageNum = 1;
        System.out.println(nextPage.isDisabled() + " :nextPageButton");
        ExcelUtilities.captureScreenshotForPartsData(folderName, screenshotName + "Page_" + pageNum);
        waitABit(2000);
        while (!nextPage.isDisabled()) {
            pageNum++;
            nextPage.click();
            waitABit(3000);
            ExcelUtilities.captureScreenshotForPartsData(folderName, screenshotName + "Page_" + pageNum);
        }
    }

    public void refreshThePageAndNavigatePartSearchPage() {
        try {
            Serenity.getDriver().switchTo().defaultContent().switchTo().frame(parentFrame);
            Serenity.getDriver().navigate().refresh();
            waitABit(5000);
            home.verifyHomePage();
            home.navigating("Design/Parts/Search Parts");
        } catch (Exception e) {
            System.err.println("Error during page refresh and navigation: " + e.getMessage());
        }
    }

    public void refreshThePageAndNavigatePartECOPage() {
        try {
            Serenity.getDriver().switchTo().defaultContent().switchTo().frame(parentFrame);
            Serenity.getDriver().navigate().refresh();
            waitABit(5000);
            home.verifyHomePage();
            home.navigating("Change Management/ECOs/Search ECOs");
        } catch (Exception e) {
            System.err.println("Error during page refresh and navigation: " + e.getMessage());
        }
    }

    public static List<String> extractParameterNumbersForPackagingItems(String input) {
        List<String> parameterNumbers = new ArrayList<>();

        // Split the input string into lines
        String[] lines = input.split("\\.\\s*");

        // Pattern to match Parameter Numbers
        Pattern pattern = Pattern.compile("R\\d+");

        for (String line : lines) {
            if (line.contains("Value")) {
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()) {
                    parameterNumbers.add(matcher.group());
                }
            }
        }

        return parameterNumbers;
    }

    public Map<String, Set<String>> extractMandatoryValuesForDims(String inputs) {

        String input = "Affected Item V0SCA: Part Parameters Validation Results: Please fix below errors to proceed:\n" +
                "V0SCA: Text Value is mandatory for the Parameter: R10005 - Production Center\n" +
                "V0SCA: Text Value is mandatory for the Parameter: R10074 - Cutfiller type\n" +
                "\n" +
                "Affected Item 80.C133: Part Parameters Validation Results: Please fix below errors to proceed:\n" +
                "80.C133: Target Value is mandatory for the Parameter: N10121 - pH\n" +
                "80.C133: Target Value is mandatory for the Parameter: N10218 - Viscosity by Brookfield at 20°C\n" +
                "80.C133: Text Value is mandatory for the Parameter: R10055 - Adhesive Class\n";
        Map<String, Set<String>> mandatoryValuesMap = new HashMap<>();

        String[] lines = input.split("\\r?\\n");

        String currentAffectedItem = null;

        for (String line : lines) {
            if (line.startsWith("Affected Item")) {
                currentAffectedItem = line.split(":")[0].replace("Affected Item", "").trim();
                ItemCodeStore.storeTheData("affectedItem", currentAffectedItem);
            } else if (line.contains("Parameter:")) {

                int paramIndex = line.indexOf("Parameter: ") + "Parameter: ".length();
                int dashIndex = line.indexOf(" - ", paramIndex);
                String parameter = line.substring(paramIndex, dashIndex);

                Set<String> mandatoryValues = mandatoryValuesMap.getOrDefault(parameter, new LinkedHashSet<>());

                if (line.contains("Text")) mandatoryValues.add("Text");
                if (line.contains("Target")) mandatoryValues.add("Target");
                if (line.contains("Min")) mandatoryValues.add("Min");
                if (line.contains("Max")) mandatoryValues.add("Max");
                if (line.contains("Free Text")) mandatoryValues.add("Free Text");

                mandatoryValuesMap.put(parameter, mandatoryValues);
            }
        }
        System.out.println(mandatoryValuesMap);
        return mandatoryValuesMap;
    }

    public Map<String, Map<String, Set<String>>> extractMandatoryValuesForMassChange(String input) {

        Map<String, Map<String, Set<String>>> affectedItemsMap = new HashMap<>();

        String[] lines = input.split("\\r?\\n");

        String currentAffectedItem = null;

        for (String line : lines) {
            if (line.startsWith("Affected Item")) {
                currentAffectedItem = line.split(":")[0].replace("Affected Item", "").trim();
            } else if (line.contains("Parameter:")) {
                int paramIndex = line.indexOf("Parameter: ") + "Parameter: ".length();
                int dashIndex = line.indexOf(" - ", paramIndex);
                String parameter = line.substring(paramIndex, dashIndex);

                Set<String> mandatoryValues = new LinkedHashSet<>();
                if (line.contains("Text")) mandatoryValues.add("Text");
                if (line.contains("Target")) mandatoryValues.add("Target");
                if (line.contains("Min")) mandatoryValues.add("Min");
                if (line.contains("Max")) mandatoryValues.add("Max");
                if (line.contains("Free Text")) mandatoryValues.add("Free Text");

                Map<String, Set<String>> parametersMap = affectedItemsMap.getOrDefault(currentAffectedItem, new HashMap<>());
                parametersMap.putIfAbsent(parameter, new LinkedHashSet<>());
                parametersMap.get(parameter).addAll(mandatoryValues);
                affectedItemsMap.put(currentAffectedItem, parametersMap);
            }
        }

        // Iterating over the map
//        for (Map.Entry<String, Map<String, Set<String>>> affectedItemEntry : affectedItemsMap.entrySet()) {
//            String affectedItem = affectedItemEntry.getKey();
//            Map<String, Set<String>> parametersMap = affectedItemEntry.getValue();
//
//            System.out.println("Affected Item: " + affectedItem);
//            for (Map.Entry<String, Set<String>> parameterEntry : parametersMap.entrySet()) {
//                String parameter = parameterEntry.getKey();
//                Set<String> mandatoryValues = parameterEntry.getValue();
//
//                System.out.println("  Parameter: " + parameter);
//                System.out.print("    Mandatory Values: ");
//                for (String value : mandatoryValues) {
//                    System.out.println(value + " ");
//                }
//                System.out.println();
//            }
//        }

        return affectedItemsMap;
    }


    private boolean isParameterAvailable(String parameterNumber) {
        return $(By.xpath("//td[text()='" + parameterNumber + "']")).isCurrentlyVisible();
    }

    private void switchToParameterIframe() {
        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(parentFrame).switchTo().frame(ParametersIframe);
    }

    private void performFinalActions() {
        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(parentFrame);
        $(doneButton).click();
        waitABit(2000);
        $(editButton).click();
    }

    public void validateR10903TextValue(String parameterNumber, String parameterValues) {
        //reusableMethods.clickOnEdit();
        Serenity.getDriver().switchTo().defaultContent();
        withTimeoutOf(Duration.ofSeconds(120)).waitFor(secondParentFrame);
        Serenity.getDriver().switchTo().frame(secondParentFrame).switchTo().frame(ParametersIframe);

        withTimeoutOf(Duration.ofSeconds(120)).waitFor(searchModesInSearchDialogue).selectByVisibleText("Simple");
        withTimeoutOf(Duration.ofSeconds(120)).waitFor(clearSearchCriteria).click();
        waitABit(2000);

        withTimeoutOf(Duration.ofSeconds(100)).waitFor(parameterNumberFieldInSearchMode).click();
        waitABit(1000);

        $(Serenity.getDriver().switchTo().activeElement()).typeAndEnter(parameterNumber);
        waitABit(10000);

        // Check if the parameter is available
        if (isParameterAvailable(parameterNumber)) {
            if (parameterNumber.equalsIgnoreCase("R10903")) {
                int textFieldPosition = Integer.parseInt(getTheColumnDataIndex("Free Text"));
                System.out.println("Text Value Index : " + textFieldPosition);
                String textValue = $(By.xpath("//*[@id='gridTD']/div[2]/div[2]/div/table/tr/td[" + textFieldPosition + "]")).getAttribute("textContent");
                System.out.println("Text Value : " + textValue);
                ItemCodeStore.storeTheData("PTEMPCode", textValue);
                if (textValue.trim().isEmpty()) {
                    System.out.println("Text Value is empty for R10903 Parameter");
                    Assert.fail("Text Value is empty for R10903 Parameter");
                    //handleParameterValues(parameterNumber, parameterValues);
                } else {
                    System.out.println("PTEMP Code is available for R10903 Parameter: " + textValue);
                }
            }

        } else {
            System.out.println("R10903 Parameter is not available....");
            Assert.fail("R10903 Parameter is not available....");
        }
    }


    public void theParameterShouldBeFilledWithValueAndItsDataTypeShouldBe(String parameterNumber, String parameterValues) {
        reusableMethods.clickOnEdit();
        Serenity.getDriver().switchTo().defaultContent();
        withTimeoutOf(Duration.ofSeconds(120)).waitFor(parentFrame);
        Serenity.getDriver().switchTo().frame(parentFrame).switchTo().frame(ParametersIframe);
        //withTimeoutOf(Duration.ofSeconds(120)).waitFor(parentFrame);

        withTimeoutOf(Duration.ofSeconds(120)).waitFor(searchModesInSearchDialogue).selectByVisibleText("Simple");
        withTimeoutOf(Duration.ofSeconds(120)).waitFor(clearSearchCriteria).click();
        waitABit(2000);

        withTimeoutOf(Duration.ofSeconds(100)).waitFor(parameterNumberFieldInSearchMode).click();
        waitABit(1000);

        $(Serenity.getDriver().switchTo().activeElement()).typeAndEnter(parameterNumber);
        waitABit(10000);

        // Check if the parameter is available
        if (isParameterAvailable(parameterNumber)) {
            if (parameterNumber.equalsIgnoreCase("R10903")) {
                int textFieldPosition = Integer.parseInt(getTheColumnDataIndex("Free Text"));
                System.out.println("Text Value Index : " + textFieldPosition);
                String textValue = $(By.xpath("//*[@id='gridTD']/div[2]/div[2]/div/table/tr/td[" + textFieldPosition + "]")).getAttribute("textContent");
                System.out.println("Text Value : " + textValue);
                ItemCodeStore.storeTheData("PTEMPCode", textValue);
                if (textValue.trim().isEmpty()) {
                    System.out.println("Text Value is empty for R10903 Parameter");
                    Assert.fail("Text Value is empty for R10903 Parameter");
                    //handleParameterValues(parameterNumber, parameterValues);
                } else {
                    System.out.println("PTEMP Code is available for R10903 Parameter: " + textValue);
                }
            } else {
                // Handle existing parameter values
                handleParameterValues(parameterNumber, parameterValues);
            }

        } else {
            // Add parameter and enter values if not available
            System.out.println("Parameter is not available. Adding it now...");
            addGHPAndEnterParameterValues(parameterNumber);

            switchToParameterIframe();
            handleParameterValues(parameterNumber, parameterValues);
        }

        waitABit(3000);
        // Click on Done and Edit
        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(parentFrame);
        $(doneButton).click();
        waitABit(3000);
    }


    private void addGHPAndEnterParameterValues(String GHPNumber) {
        $(GHPAddButton).click();

        Serenity.getDriver().switchTo().parentFrame().switchTo().frame(dialogueFrame);
        waitABit(3000);

        withTimeoutOf(Duration.ofSeconds(100)).waitFor(clearSearchCriteria).click();
        waitABit(2000);

        withTimeoutOf(Duration.ofSeconds(100)).waitFor(parameterNumberFieldInDialogueFrame).click();
        waitABit(2000);

        $(Serenity.getDriver().switchTo().activeElement()).type(GHPNumber);
        waitABit(2000);

        $(runSearchButton).click();
        waitABit(1000);

        withTimeoutOf(Duration.ofSeconds(100)).waitFor(By.xpath("//*[@id='gridTD']/div[2]/div[1]/div/table/tr/td[2]"));
        $(arasSearchOkButton).click();
    }

    private String getTheColumnDataIndex(String columnName) {
        String dataIndex = "";
        switch (columnName) {
            case "List":
            case "Free Text":
            case "Multi List":
                dataIndex = MigratedDataPVPage.textFieldInSimpleSearch.getAttribute("data-index");
                break;
            case "Number":
                dataIndex = MigratedDataPVPage.targetFieldInSimpleSearch.getAttribute("data-index");
                break;
            default:
                System.out.println("ColumnName is not found.....-->" + columnName);
        }
        return dataIndex;
    }

    private void handleParameterValues(String parameterNumber, String parameterValues) {

        if (!MigratedDataPVPage.dataTypeFieldInSimpleSearch.isCurrentlyVisible()) {
            scrollGrid();
        }

        int dataTypeIndex = Integer.parseInt(MigratedDataPVPage.dataTypeFieldInSimpleSearch.getAttribute("data-index"));

        int finalDataTypeIndex = dataTypeIndex + 1;

        System.out.println("DataType Field Index is: " + dataTypeIndex);

        System.out.println("Final DataType Field Index is: " + finalDataTypeIndex);

        //String finalDataType = $(By.xpath("//*[@id='gridTD']/div[2]/div[2]/div/table/tr/td[" + dataTypeIndex + "]")).getAttribute("textContent");
        String finalDataType = $(By.xpath("//*[@id='gridTD']/div[2]/div[2]/div/table/tr[1]/td[" + finalDataTypeIndex + "]")).getAttribute("textContent");

        System.out.println("DataType text is: " + finalDataType);

        int textFieldPosition = 1;

        int targetFieldPosition = 2;

        if (finalDataType.equalsIgnoreCase("Number")) {
            targetFieldPosition = Integer.parseInt(getTheColumnDataIndex(finalDataType));
            System.out.println("Target Value Index is : " + targetFieldPosition);
        } else {
            textFieldPosition = Integer.parseInt(getTheColumnDataIndex(finalDataType));
            System.out.println("Text Value Index is : " + textFieldPosition);
        }

        switch (finalDataType) {
            case "Free Text":
                handleFreeText(textFieldPosition, parameterValues);
                break;
            case "List":
                handleList(textFieldPosition);
                break;
            case "Multi List":
                handleMultiList(textFieldPosition);
                break;
            case "Number":
                handleNumber(targetFieldPosition, parameterValues);
                break;
            default:
                throw new IllegalArgumentException("Invalid data type: " + finalDataType);
        }
    }

    private void handleFreeText(int noOfMoves, String text) {
        $(firstTdElementInRow).click();
        waitAndExecuteTabs(noOfMoves);
        waitABit(2000);
        if (text.isEmpty()) {
            $(Serenity.getDriver().switchTo().activeElement()).type("MN");
        } else {
            $(Serenity.getDriver().switchTo().activeElement()).type(text);
        }
    }

    private void handleList(int noOfMoves) {
        $(firstTdElementInRow).click();
        waitAndExecuteTabs(noOfMoves);
        waitABit(1000);
        reusableUtilities.pressDownNavigation();
        waitABit(1000);
        reusableUtilities.pressDownNavigation();
        waitABit(1000);
        reusableUtilities.pressDownNavigation();
        waitABit(1000);
        reusableUtilities.pressShiftTab();
    }

    private void handleMultiList(int noOfMoves) {
        $(firstTdElementInRow).click();
        waitAndExecuteTabs(noOfMoves);
        waitABit(2000);
        $(By.xpath("//span[text()='0 item(s) selected']/following-sibling::button")).click();
        waitABit(2000);
        List<WebElement> elements = Serenity.getDriver().findElements(By.xpath("//span[text()='0 item(s) selected']/following-sibling::div/ul/li/label/span"));
        List<WebElement> firstThreeElements = elements.stream().limit(3).collect(Collectors.toList());
        firstThreeElements.forEach(WebElement::click);
        reusableUtilities.pressShiftTab();
    }

    private void handleNumber(int noOfMoves, String parameterValues) {
        if (parameterValues.contains(",")) {
            checkTheColumnNameHandleMultipleMinMaxTargetValues(noOfMoves, parameterValues);
        } else {
            checkTheColumnNameAndHandleTheParamValues(noOfMoves, parameterValues);
        }
    }

    private void checkTheColumnNameAndHandleTheParamValues(int tabIndex, String parameterValue) {
        String targetValue = "100"; // Default target value

        switch (parameterValue.toLowerCase()) {
            case "target":
                // Check if min and max values are present
                if (isMinMaxValuesPresent(tabIndex)) {
                    double min = Double.parseDouble(ItemCodeStore.getStoredData("min"));
                    double max = Double.parseDouble(ItemCodeStore.getStoredData("max"));
                    targetValue = String.valueOf(RandomValueBetweenMinAndMax(min, max));
                }

                enterTheMinMaxTargetValues(targetValue, tabIndex);
                break;

            case "min":
                enterTheMinMaxTargetValues("5", tabIndex + 1);
                break;

            case "max":
                enterTheMinMaxTargetValues("10", tabIndex + 2);
                break;

            default:
                throw new IllegalArgumentException("Invalid data type: " + parameterValue);
        }
    }


    public boolean isMinMaxValuesPresent(int noOfMoves) {
        try {
            int dataIndexForMin = Integer.parseInt(MigratedDataPVPage.minFieldInSimpleSearch.getAttribute("data-index"));

            int dataIndexForMax = Integer.parseInt(MigratedDataPVPage.maxFieldInSimpleSearch.getAttribute("data-index"));

            System.out.println("Min Field Index is: " + dataIndexForMin);
            System.out.println("Max Field Index is: " + dataIndexForMax);

            waitABit(2000);

            String min = $(By.xpath("//*[@id='gridTD']/div[2]/div[2]/div/table/tr/td[" + dataIndexForMin + "]")).getAttribute("textContent");
            String max = $(By.xpath("//*[@id='gridTD']/div[2]/div[2]/div/table/tr/td[" + dataIndexForMax + "]")).getAttribute("textContent");

            System.out.println("Min text is: " + min);
            System.out.println("Max text is: " + max);

            ItemCodeStore.storeTheData("min", min);
            ItemCodeStore.storeTheData("max", max);

            return min != null && max != null && !min.isEmpty() && !max.isEmpty();

        } catch (Exception e) {
            System.err.println("Error while checking Min/Max values: " + e.getMessage());
            return false;
        }
    }


    public void enterTheMinMaxTargetValues(String parameterValue, int noOfMoves) {
        $(firstTdElementInRow).click();
        waitABit(1000);
        waitAndExecuteTabs(noOfMoves);
        waitABit(1000);
        reusableUtilities.pressControlA();
        waitABit(1000);
        reusableUtilities.pressBackspace();
        waitABit(1000);
        $(Serenity.getDriver().switchTo().activeElement()).typeAndTab(parameterValue.trim());
        //scrollGrid();
    }

    public void checkTheColumnNameHandleMultipleMinMaxTargetValues(int noOfMoves, String parameterValues) {
        String paramValues = parameterValues.trim();
        $(firstTdElementInRow).click();
        waitABit(1000);
        waitAndExecuteTabsForMinMaxTargetColumns(noOfMoves);
        if (paramValues.equalsIgnoreCase("Target,Min,Max")) {
            reusableUtilities.pressControlA();
            waitABit(1000);
            reusableUtilities.pressBackspace();
            waitABit(1000);
            $(Serenity.getDriver().switchTo().activeElement()).typeAndTab("15");
            waitABit(1000);
            $(Serenity.getDriver().switchTo().activeElement()).typeAndTab("10");
            waitABit(1000);
            $(Serenity.getDriver().switchTo().activeElement()).typeAndTab("20");
            waitABit(1000);
        } else if (paramValues.equalsIgnoreCase("Min,Max")) {
            waitABit(1000);
            reusableUtilities.pressTab();
            waitABit(1000);
            reusableUtilities.pressControlA();
            waitABit(1000);
            reusableUtilities.pressBackspace();
            waitABit(1000);
            $(Serenity.getDriver().switchTo().activeElement()).typeAndTab("10");
            waitABit(1000);
            $(Serenity.getDriver().switchTo().activeElement()).typeAndTab("20");
        } else if (paramValues.equalsIgnoreCase("Max,Target")) {
            waitABit(1000);
            reusableUtilities.pressTab();
            waitABit(1000);
            reusableUtilities.pressTab();
            waitABit(1000);
            reusableUtilities.pressControlA();
            waitABit(1000);
            reusableUtilities.pressBackspace();
            waitABit(1000);
            $(Serenity.getDriver().switchTo().activeElement()).type("20");
            waitABit(1000);
            reusableUtilities.pressShiftTab();
            waitABit(1000);
            reusableUtilities.pressShiftTab();
            waitABit(1000);
            $(Serenity.getDriver().switchTo().activeElement()).typeAndTab("10");
        }
    }

    private void handlePopup(String parameterNum) {
        Serenity.getDriver().switchTo().parentFrame().switchTo().frame(dialogueFrame);
        waitABit(1000);
        String popupText = $(popupTextContent).getAttribute("value").trim();
        System.out.println(popupText + " PopText");
        if (parameterNum.equalsIgnoreCase("R10454")) {
            ItemCodeStore.storeTheData("PackedItems", popupText);
        }
        $(closePopup).click();
        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(parentFrame);
        if ($(ParametersIframe).isCurrentlyVisible()) {
            Serenity.getDriver().switchTo().frame(ParametersIframe);
        }
    }

    private void scrollGrid() {
        try {
            evaluateAsyncJavascript("arguments[0].scrollLeft = 0", arasGridDiv.get(arasGridDiv.size() - 1));
        } catch (ScriptTimeoutException e) {
            // Handle exception
        }
    }

    private void waitAndExecuteTabs(int times) {
        IntStream.range(1, times - 1).forEach(i -> {
            reusableUtilities.pressRightNavigation();
            waitABit(1000);
        });
        reusableUtilities.pressTab();
    }

    private void waitAndExecuteTabsForMinMaxTargetColumns(int times) {
        IntStream.range(0, times).forEach(i -> {
            //reusableUtilities.pressRightNavigation();
            reusableUtilities.pressTab();
            waitABit(1000);
        });
    }

    private Double RandomValueBetweenMinAndMax(Double min, Double max) {
        return min + (max - min) * Math.random();
    }


}

