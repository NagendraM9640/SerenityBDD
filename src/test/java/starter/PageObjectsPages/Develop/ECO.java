package starter.PageObjectsPages.Develop;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;


import starter.PageObjectsPages.ARASLoginPageObjects;
import starter.PageObjectsPages.ARAS_HomePage;
import starter.PageObjectsPages.nonMBOM.FMS.ParametersToIngredientPage;
import starter.PageObjectsPages.nonMBOM.FMS.PartPage;
import starter.Utility.ReusableMethods;
import starter.Utility.ReusableUtilities;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.*;
import java.util.List;

import static starter.PageObjectsPages.Develop.EcoPage.newFrameToAddProductsInAffectedTab;

public class ECO extends PageObject {

    ReusableUtilities reusableUtilities = new ReusableUtilities();

    ReusableMethods reusableMethods;

    ARASLoginPageObjects arasLoginPageObjects = new ARASLoginPageObjects();

    ARAS_HomePage arasHomePage = new ARAS_HomePage();

    PartPageDev partPage = new PartPageDev();

    ECOPartParameterValidationsPage ecoPartParameterValidationsPage = new ECOPartParameterValidationsPage();

    public static @FindBy(xpath = "//textarea[@name='title']") WebElementFacade EcoTitleField;
    public static @FindBy(xpath = "//button[@aria-label='Open User Menu']") WebElementFacade currentUserDetails;

    public static @FindBy(xpath = "//iframe[@class='content-block__iframe']") WebElementFacade parentFrame;
    public static @FindBy(xpath = "//*[text()='OK']") WebElementFacade alertOkButton;
    public static @FindBy(xpath = "//iframe[@class='aras-dialog__iframe']") WebElementFacade dialogueIframe;

    public static @FindBy(xpath = "//button[@title='Edit']") WebElementFacade editButton;
    public static @FindBy(xpath = "//input[@name='item_number']") WebElementFacade ecoNumberField;
    public static @FindBy(xpath = "//table[@id='item_status']/tbody/tr/td") WebElementFacade ecoStatus;

    public static @FindBy(xpath = "//iframe[@id='instance']") WebElementFacade childFrame;
    public static @FindBy(xpath = "//td[@uniqueid='ms__id38']//table//tbody//tr") List<WebElementFacade> ecoSignOffTableRows;
    public static @FindBy(xpath = "//textarea[@class='description']") WebElementFacade changeDescFieldInEco;
    public static @FindBy(xpath = "//input[@name='pmi_eco_purpose']") WebElementFacade purposeFieldInEco;
    public static @FindBy(xpath = "//select[@name='pmi_change_drivers']") WebElementFacade changeDriversInEco;
    public static @FindBy(xpath = "//input[@name='esignature']") WebElementFacade eSignatureField;
    public static @FindBy(xpath = "//td[@data-head-id='item_number_D']") WebElementFacade ecoSearchNumberField;
    public static @FindBy(className = "aras-dialog__iframe") WebElementFacade newFrameForWorkFlow;

    public static @FindBy(xpath = "//iframe[contains(@name,'innovator_')]") WebElementFacade newFrameForCreatePartFrame;

    public static @FindBy(xpath = "(//iframe[contains(@name,'innovator_')])[2]") WebElementFacade newFrameForCreatePartFrame2;
    public static @FindBy(xpath = "(//iframe[contains(@name,'innovator_')])[3]") WebElementFacade newFrameForCreatePartFrame3;
    public static @FindBy(xpath = "//iframe[@src='ShowFormInFrame.html']") WebElementFacade newFrameForm;
    public static @FindBy(xpath = "//iframe[@id='formFrame']") WebElementFacade newFrameForm2;
    public static @FindBy(xpath = "//input[@aria-label='Product Group search cell']") WebElementFacade productGroupField;
    public static @FindBy(xpath = "//span[@id='SALTkA7_Aras_Tbi_collapse_all']") WebElementFacade collapseAllBtn;
    public static @FindBy(xpath = "//span[@title='Close']") WebElementFacade closePopUpInECO;
    public static @FindBy(xpath = "//span[@class='aras-tabs__label' and text()='Affected Items']") WebElementFacade affectedItemsTab;
    public static @FindBy(xpath = "//*[@class='aras-switcher']//iframe[@id='C5121F4CF8174DD7AED3AB967E9BDDC5']") WebElementFacade newFrameForm1;
    public static @FindBy(xpath = "//iframe[@id='result_iframe_frame']") WebElementFacade newFrameToSeeSubFamilyWorkFlow;
    public static @FindBy(id = "VoteList") WebElementFacade VoteList;
    public static @FindBy(xpath = "//*[@id='btnCreate' and @value='Continue']") WebElementFacade continueButton;
    public static @FindBy(name = "Complete") WebElementFacade completeButton;
    public static @FindBy(xpath = "//*[text()='Under Development']") WebElementFacade targetLifecycleField;
    public static @FindBy(xpath = "//*[text()='Under Verification']") WebElementFacade targetLifecycleField2;
    public static @FindBy(xpath = "//*[text()='Approved']") WebElementFacade targetLifecycleField3;
    public static @FindBy(xpath = "//span[contains(text(), 'VOTE NOW')]") WebElementFacade voteNowBtn;
    public static @FindBy(xpath = "//*[@id='gridTD']/div[2]/div[2]/div/table/tr/td[7]/label/input") List<WebElementFacade> ownerApprovalCheck;
    public static @FindBy(xpath = "//iframe[@title='pmi_ExpressECO_Assignments Relationship']") WebElementFacade ecoAssignmentsRelationshipFrame;
    public static @FindBy(xpath = "//*[@id='main-tab']/div/div/ul/li/span[1]") List<WebElementFacade> activeTabsList;
    public static @FindBy(xpath = "//span[@class='aras-dialog-alert__text']") WebElementFacade errorMessage;
    public static @FindBy(xpath = "//span[contains(text(), 'Creator/Owner of the Express ECO is not allowed')]") WebElementFacade creatorOwnerErrorMsg;
    public static @FindBy(xpath = "//span[contains(text(), 'Parameters Validation Results:')]") WebElementFacade parameterValidationErrorMsg;

    public static @FindBy(xpath = "//button[@title='Clear Search Criteria']") WebElementFacade clearSearchCriteria;
    public static @FindBy(xpath = "//div[@dojoattachpoint='contentNode']/div/div[contains(@class, 'dojoxGridRow')]/table/tbody/tr/td[6]") List<WebElementFacade> targetLifecyclesFields;

    public static @FindBy(xpath = "//button[@title='Run Search']") WebElementFacade runSearchButton;

    public static @FindBy(xpath = "//span[@class='aras-dialog-alert__text']") WebElementFacade alertMessage;
    public static @FindBy(xpath = "//tr[@class='dojoxGridNoChildren']//td[4]") WebElementFacade currentLifecycle;
    public static @FindBy(xpath = "//*[text()='Done']") WebElementFacade doneBtn;
    public static @FindBy(xpath = "//button[@title='More']") WebElementFacade moreButtonECO;
    public static @FindBy(xpath = "//li[@data-index='pmi_AddManualReviewersAction']/span[1]") WebElementFacade updateAssignmentBtn;
    public static @FindBy(xpath = "//input[@name='pmi_append']/following-sibling::label") WebElementFacade appendAssignmentCheckbox;
    public static @FindBy(xpath = "//textarea[@name='pmi_comments']") WebElementFacade updateAssignmentComments;
    public static @FindBy(xpath = "//input[@name='pmi_select']") WebElementFacade selectAssignmentsBtn;

    public static @FindBy(xpath = "//iframe[@id='formFrame']") WebElementFacade formFrame;
    public static @FindBy(xpath = "//td[@data-head-id='name_D']/input") WebElementFacade nameFieldInIdentities;
    public static @FindBy(xpath = "//input[@name='pmi_submit']") WebElementFacade submitBtn;
    public static @FindBy(xpath = "//span[@title='Close']") WebElementFacade closeBtn;
    public static @FindBy(xpath = "(//*[@class='aras-grid-row-cell '])[1]") WebElementFacade searchResultsInGrid;
    public static @FindBy(xpath = "//button[contains(@class, 'aras-button_primary') and contains(@class, 'aras-buttons-bar__button')]//span[text()='OK']") WebElementFacade searchOkBtn;
    public static @FindBy(xpath = "//*[@id='main-tab']/div/div/ul/li[1]/span[1]") WebElementFacade closeTheFirstOpenedTab;
    public static @FindBy(xpath = "//td[@data-head-id='classification_D']//input") WebElementFacade partSearchItemType;
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

    public static @FindBy(xpath = "//*[@class='item_number']") WebElementFacade itemCodeField;

    public static @FindBy(xpath = "//iframe[@class='aras-dialog__iframe']") WebElementFacade dialogueFrame;

    public static @FindBy(xpath = "//button[@title='Save']") WebElementFacade saveButton;

    public static @FindBy(xpath = "//input[@aria-label='Purpose search cell']") WebElementFacade purposeSearchField;

    String itemTypeInSheet = "";
    String itemTypeNumber = "";
    String subFamilyInSheet = "";
    String productGroupInSheet = "";
    String itemCode = "";
    String ecoItemCode = "";
    String integrationTabResult = "";
    String copyID = "";
    ARAS_HomePage home;
    Actions action = new Actions(Serenity.getDriver());
    JavascriptExecutor js = (JavascriptExecutor) Serenity.getDriver();

    public void userFillAllMandatoryFieldsInECOAndClickOnSave(String title, String desc, String purpose, String changeDrivers) {
        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(parentFrame).switchTo().frame(childFrame);
        $(EcoTitleField).sendKeys(title);
        $(changeDescFieldInEco).sendKeys(desc);
        $(purposeFieldInEco).sendKeys(purpose);
        $(changeDriversInEco).selectByVisibleText(changeDrivers);
    }

    public void userShouldEnterTheEsignature() {
        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(newFrameForCreatePartFrame);
        withTimeoutOf(Duration.ofSeconds(100)).waitFor(newFrameForWorkFlow);
        Serenity.getDriver().switchTo().frame(newFrameForWorkFlow);
        $(eSignatureField).sendKeys("innovator");
    }

    public void searchECOItemsFromSearchSection(String itemCode) {
        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(parentFrame);
        withTimeoutOf(Duration.ofSeconds(100)).waitFor(ecoSearchNumberField);
        waitABit(2000);
        withTimeoutOf(Duration.ofSeconds(100)).waitFor(clearSearchCriteria).click();
        waitABit(2000);
        withTimeoutOf(Duration.ofSeconds(100)).waitFor(ecoSearchNumberField).click();
        waitABit(2000);
        $(Serenity.getDriver().switchTo().activeElement()).type(itemCode);
        waitABit(2000);
        $(runSearchButton).click();
        withTimeoutOf(Duration.ofSeconds(100)).waitFor(By.xpath("//*[text()='" + itemCode + "']"));
        Actions a = new Actions(Serenity.getDriver());
        waitABit(3000);
        a.moveToElement($(By.xpath("//*[text()='" + itemCode + "']"))).doubleClick().build().perform();
        waitABit(2000);
        Serenity.getDriver().switchTo().defaultContent();
        withTimeoutOf(Duration.ofSeconds(100)).waitFor(activeTabsList.get(1));
        activeTabsList.get(0).click();
    }

    public void userOpensPartFromAffectedItems(String itemCode) {
        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(newFrameForCreatePartFrame);
        withTimeoutOf(Duration.ofSeconds(100)).waitFor(affectedItemsTab);
        $(affectedItemsTab).click();
        Serenity.getDriver().switchTo().frame(newFrameForm).switchTo().frame(newFrameForm2);
        withTimeoutOf(Duration.ofSeconds(100)).waitFor(collapseAllBtn).click();
        //withTimeoutOf(Duration.ofSeconds(100)).waitFor(By.xpath("//*[text()='" + itemCode + "']")).click();
        if ($(By.xpath("(//a[@class='gridLink' and text()='" + itemCode + "'])[2]")).isCurrentlyVisible()) {
            withTimeoutOf(Duration.ofSeconds(100)).waitFor(By.xpath("(//a[@class='gridLink' and text()='" + itemCode + "'])[2]")).click();
        } else {
            withTimeoutOf(Duration.ofSeconds(100)).waitFor(By.xpath("//*[text()='" + itemCode + "']")).click();
        }
        waitABit(2000);
        Serenity.getDriver().switchTo().defaultContent();
        withTimeoutOf(Duration.ofSeconds(100)).waitFor(closeTheFirstOpenedTab).click();
    }

    public void closeTheECOWorkFlowActivityCompletionPopup() {
        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(parentFrame);
        withTimeoutOf(Duration.ofSeconds(100)).waitFor(closePopUpInECO).click();
    }

    public void validateWorkflowWindow() {
        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(newFrameForCreatePartFrame);
        withTimeoutOf(Duration.ofSeconds(100)).waitFor(newFrameForWorkFlow);
        Serenity.getDriver().switchTo().frame(newFrameForWorkFlow);
    }

    public void userSelectsSendToReviewVoteList(String s) {
        validateWorkflowWindow();
        $(VoteList).selectByVisibleText(s.trim());
    }

    public void userClicksCompleteButton() {
        validateWorkflowWindow();
        $(completeButton).click();
        if ($(continueButton).isCurrentlyVisible()) {
            $(continueButton).click();
        }
    }

    public String validateECOWorkFlowStatus() {
        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(parentFrame).switchTo().frame(childFrame);
        String ecoStatusText = $(ecoStatus).getText();
        return ecoStatusText.trim();
    }

    public void userSelectsTargetLifecycle(String targetLifecycle) {
        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(newFrameForCreatePartFrame).switchTo().frame(newFrameForm).switchTo().frame(newFrameForm2);
        waitABit(2000);
        if ($(targetLifecycleField).isCurrentlyVisible()) {
            $(targetLifecycleField).click();
            waitABit(2000);
            $(targetLifecycleField).click();
            waitABit(2000);
        } else if ($(targetLifecycleField2).isCurrentlyVisible()) {
            $(targetLifecycleField2).click();
            waitABit(2000);
            $(targetLifecycleField2).click();
            waitABit(2000);
            $(Serenity.getDriver().switchTo().activeElement()).typeAndEnter("Released");
        } else if ($(targetLifecycleField3).isCurrentlyVisible()) {
            $(targetLifecycleField3).click();
            waitABit(2000);
            $(targetLifecycleField3).click();
            waitABit(2000);
        }

        if (targetLifecycle.equalsIgnoreCase("Released")) {
            reusableUtilities.pressDownNavigation();
            waitABit(1000);
            reusableUtilities.pressDownNavigation();
            waitABit(1000);
            reusableUtilities.pressDownNavigation();
            waitABit(1000);
            reusableUtilities.pressDownNavigation();
            waitABit(1000);
            reusableUtilities.pressEnterWithoutElement();
        } else if (targetLifecycle.equalsIgnoreCase("Obsolete")) {
            reusableUtilities.pressDownNavigation();
            waitABit(1000);
            reusableUtilities.pressDownNavigation();
            waitABit(1000);
            reusableUtilities.pressEnterWithoutElement();
        } else if (targetLifecycle.equalsIgnoreCase("Suppressed")) {
            reusableUtilities.pressDownNavigation();
            waitABit(1000);
            reusableUtilities.pressDownNavigation();
            waitABit(1000);
            reusableUtilities.pressDownNavigation();
            waitABit(1000);
            reusableUtilities.pressDownNavigation();
            waitABit(1000);
            reusableUtilities.pressDownNavigation();
            waitABit(1000);
            reusableUtilities.pressEnterWithoutElement();
        }

        waitABit(2000);
        $(currentLifecycle).click();

        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(newFrameForCreatePartFrame);
        $(doneBtn).click();
    }

    public void updateAssignmentInEco(String userName) {
        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(parentFrame);

        waitForElementToBeClickable(moreButtonECO).click();
        waitForElementToBeClickable(updateAssignmentBtn).click();

        Serenity.getDriver().switchTo().frame(dialogueIframe).switchTo().frame(formFrame);
        waitABit(2000);

        js.executeScript("arguments[0].click();", appendAssignmentCheckbox);
        waitABit(2000);

        withTimeoutOf(Duration.ofSeconds(100)).waitFor(updateAssignmentComments).sendKeys("Please approve");

        withTimeoutOf(Duration.ofSeconds(100)).waitFor(selectAssignmentsBtn).click();

        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(dialogueIframe);
        waitForElementToBeClickable(clearSearchCriteria).click();

        waitABit(2000);
        withTimeoutOf(Duration.ofSeconds(100)).waitFor(nameFieldInIdentities).click();

        waitABit(2000);
        $(Serenity.getDriver().switchTo().activeElement()).typeAndEnter(userName);

        waitABit(2000);
        withTimeoutOf(Duration.ofSeconds(100)).waitFor(searchResultsInGrid);

        waitABit(2000);
        waitForElementToBeClickable(searchOkBtn).click();

        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(parentFrame).switchTo().frame(dialogueIframe).switchTo().frame(formFrame);
        waitABit(3000);

        waitForElementToBeClickable(submitBtn).click();
        waitABit(3000);

        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(parentFrame);
        withTimeoutOf(Duration.ofSeconds(100)).waitFor(closeBtn).click();
    }

    private WebElement waitForElementToBeClickable(WebElement element) {
        return withTimeoutOf(Duration.ofSeconds(100)).waitFor(element).waitUntilClickable();
    }


    public void userShouldSelectTheOwnerApprovalCheckbox() {
        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(parentFrame);
        reusableMethods.clickOnEdit();
        Serenity.getDriver().switchTo().frame(ecoAssignmentsRelationshipFrame);
        for (WebElementFacade checkBox : ownerApprovalCheck) {
            if (!checkBox.isSelected()) {
                WebElement siblingSpan = checkBox.findElement(By.xpath("following-sibling::span"));
                siblingSpan.click();
            }
        }
        Serenity.getDriver().switchTo().parentFrame();
        $(doneBtn).click();
    }

    public void userShouldCompleteTheSignOffProcessOfECO() throws Exception {
        String ecoNumber = fetchECONumber();
        ItemCodeStore.storeTheData("ecoNum", ecoNumber);
        switchToECOWorkflowFrame();

        while (!isECOReleased()) {
            String activeUser = retrieveActiveUserAndInitiateVoteProcess();

            if (isECOReleased()) break;

            if (activeUser != null) {
                if (!isCurrentUser(activeUser)) {
                    switchToUserAndContinue(activeUser, ecoNumber);
                }
            } else {
                break;
            }
        }
    }

    public void switchToECOWorkflowFrame() {
        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(newFrameForCreatePartFrame);
        waitABit(10000);
        if ($(newFrameForm1).isCurrentlyVisible()) {
            Serenity.getDriver().switchTo().frame(newFrameForm1).switchTo().frame(newFrameForm2).switchTo().frame(newFrameToSeeSubFamilyWorkFlow);
        } else {
            Serenity.getDriver().switchTo().frame(newFrameForm).switchTo().frame(newFrameForm2).switchTo().frame(newFrameToSeeSubFamilyWorkFlow);
        }
    }

    public String fetchECONumber() {
        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(parentFrame).switchTo().frame(childFrame);
        return $(ecoNumberField).getAttribute("value").trim();
    }

    public boolean isCurrentUser(String activeUser) {
        Serenity.getDriver().switchTo().defaultContent();
        String title = $(currentUserDetails).getAttribute("title");
        return title.equalsIgnoreCase(activeUser);  // Case-insensitive comparison
    }

    public String retrieveActiveUserAndInitiateVoteProcess() throws Exception {

        switchToECOWorkflowFrame(); // Switch to the ECO Vote tab frame
        for (int i = 1; i < ecoSignOffTableRows.size(); i++) {  // Loop through each row to find the one with the 'Active' status and Skip the header row
            WebElement row = ecoSignOffTableRows.get(i);
            WebElement stateCell = row.findElement(By.xpath("./td[2]"));

            if (stateCell.getText().trim().equalsIgnoreCase("Active")) { // If the row contains an active user
                // Retrieve the active user's details and the activity status
                WebElement assignedUserCell = row.findElement(By.xpath("./td[3]"));
                WebElement activityCell = row.findElement(By.xpath("./td[1]"));
                String activeUser = assignedUserCell.getText().trim();
                String activity = activityCell.getText().trim();

                if (isVoteNowButtonVisible()) { // Check if the "VOTE NOW" button is visible
                    System.out.println("Vote Now is visible");
                    if ($(voteNowBtn).isClickable()) {
                        $(voteNowBtn).click();
                    } else {
                        throw new Exception("Vote now is visible but is it not clickable");
                    }
                    //isCreatorOwnerNotAllowedErrorMessageDisplayed(); // If the 'Creator Owner Not Allowed' error message is displayed, handle the error and retry
                    completeVoteProcess(activity); // Complete the vote process based on the activity type
                    isParameterValidationErrorMessageDisplayed(); // Handle any parameter validation error messages
                    checkAnyUnwantedErrorsIsDisplayed(); //Check If any unwanted errors will be displayed after click on complete button
                } else {
                    System.out.println("Vote Now is not visible");
                }
                return activeUser; // Return the active user after processing the vote
            }
        }

        return null; // If no active user is found, return null

    }

    public void checkAnyUnwantedErrorsIsDisplayed() throws Exception {
        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(parentFrame);
        if ($(errorMessage).isCurrentlyVisible()) {
            String errorMessageText = $(errorMessage).getText();
            System.err.println("An error displayed: " + errorMessageText);
            waitABit(5000);
            throw new Exception("An error displayed: " + errorMessageText);
        }
    }

    public boolean isVoteNowButtonVisible() {
        switchToECOWorkflowFrame();
        return $(voteNowBtn).isCurrentlyVisible();
    }

    private void isCreatorOwnerNotAllowedErrorMessageDisplayed() {
        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(parentFrame);
        if ($(creatorOwnerErrorMsg).isCurrentlyVisible()) {
            handleCreatorOwnerNotAllowedErrorAndRetryApproval();
            switchToECOWorkflowFrame();
            $(voteNowBtn).click();
        } else {
            System.out.println("Creator Owner Not Allowed Error Message not Displayed");
        }
    }

    private void isParameterValidationErrorMessageDisplayed() {
        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(parentFrame);
        if ($(parameterValidationErrorMsg).isCurrentlyVisible()) {
            handleParameterValidationError();
        }
    }

    private void handleCreatorOwnerNotAllowedErrorAndRetryApproval() {
        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(parentFrame);
        $(alertOkButton).click();  // Click 'OK' on the error message
        partPage.userClicksOnTab("Assignments"); // Navigate to the 'Assignments' tab and edit the assignment
        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(parentFrame);
        $(editButton).click();
        userShouldSelectTheOwnerApprovalCheckbox();  // Select the owner approval checkbox
        waitABit(2000);
        partPage.userClicksOnTab("SignOffs"); // Navigate to the 'SignOffs' tab
    }

    public void completeVoteProcess(String activity) {
        validateWorkflowWindow(); // Validate the workflow window before processing the vote

        switch (activity.trim()) { // Perform actions based on the activity type
            case "Submit":
                userSelectsSendToReviewVoteList("Start Work"); // If the activity is 'Submit', send it to 'Start Work'
                break;
            case "Draft":
                userSelectsSendToReviewVoteList("Submit for Approval");  // If the activity is 'Draft', submit it for approval
                break;
            case "Approval":
                userShouldEnterTheEsignature(); //Enter the e-signature
                userSelectsSendToReviewVoteList("Approve Change"); // If the activity is 'Approval', enter e-signature and send it to 'approve the change'
                break;
            default:
                throw new RuntimeException("Unknown activity type: " + activity);
        }
        userClicksCompleteButton(); // Click the 'Complete' button to finalize the vote process
    }

    public void switchToUserAndContinue(String nextVoteAssignedUser, String ecoNumber) throws IOException {
        String[] credentials = retrieveUserCredentials("src/test/resources/TestData/UserCredentials.xlsx", "Sheet1", nextVoteAssignedUser);
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
        return statusField.equalsIgnoreCase("Released");
    }

    private void handleParameterValidationError() {
        Serenity.getDriver().switchTo().defaultContent();

        // Switch to the correct frame based on which one is visible
        if ($(newFrameForCreatePartFrame).isCurrentlyVisible()) {
            Serenity.getDriver().switchTo().frame(newFrameForCreatePartFrame);
        } else if ($(newFrameForCreatePartFrame2).isCurrentlyVisible()) {
            Serenity.getDriver().switchTo().frame(newFrameForCreatePartFrame2);
        } else if ($(newFrameForCreatePartFrame3).isCurrentlyVisible()) {
            Serenity.getDriver().switchTo().frame(newFrameForCreatePartFrame3);
        }

        String parameterValidationErrorText = $(alertMessage).getText(); // Get the text from the alert message
        System.out.println(parameterValidationErrorText + " :AlertText");

        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(parentFrame); // Switch back to the default content and then to the parent frame

        $(alertOkButton).click(); // Click 'OK' to dismiss the alert

        closeTheECOWorkFlowActivityCompletionPopup(); // Close the popup related to the workflow activity completion

        Map<String, Set<String>> mandatoryValuesMap = ecoPartParameterValidationsPage.extractMandatoryValues(parameterValidationErrorText); // Extract mandatory values from the error message text

        userOpensPartFromAffectedItems(ItemCodeStore.getStoredData("affectedItem")); // Open the affected part item for the error validation

        reusableMethods.clickOnEdit();// Click the 'Edit' button to modify the part parameters

        waitABit(3000);  // Wait briefly for the page to load

        partPage.userClicksOnTab("Parameters"); // Navigate to the 'Parameters' tab to validate the parameters

        for (Map.Entry<String, Set<String>> entry : mandatoryValuesMap.entrySet()) { // Iterate through the mandatory parameters and it's values
            String parameterNumber = entry.getKey();
            String values = String.join(",", entry.getValue());
            System.out.println(parameterNumber + "--->" + values);

            ecoPartParameterValidationsPage.theParameterShouldBeFilledWithValueAndItsDataTypeShouldBe(parameterNumber, values); // update the parameter values in the part
        }

        waitABit(3000);
        Serenity.getDriver().navigate().refresh();
        waitABit(7000);
        //Serenity.getDriver().switchTo().alert().accept();
        home.verifyHomePage();
        arasHomePage.navigating("Change Management/ECOs/Search ECOs");
        searchECOItemsFromSearchSection(ItemCodeStore.getStoredData("ecoNum"));
        partPage.userClicksOnTab("SignOffs");
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

    public void userSearchesMigratedDataAndReleaseIt() throws Exception {

        //Reading excel

        //Create an object of FileInputStream class to read excel file
        FileInputStream fis = new FileInputStream("MigratedE2ESheet.xlsx");

        //Create object of XSSFWorkbook class
        XSSFWorkbook wb = new XSSFWorkbook(fis);

        //Read excel sheet by sheet number
        XSSFSheet sheet1 = wb.getSheetAt(0);

        for (int row = 1; row <= sheet1.getLastRowNum(); row++) {
            try {

                itemTypeInSheet = sheet1.getRow(row).getCell(0).getStringCellValue();
                subFamilyInSheet = sheet1.getRow(row).getCell(1).getStringCellValue();
                productGroupInSheet = sheet1.getRow(row).getCell(2).getStringCellValue();

                itemTypeNumber = itemTypeInSheet.substring(itemTypeInSheet.length() - 2);

                //Searching migrated parts
                Serenity.getDriver().switchTo().defaultContent().switchTo().frame(parentFrame);
                partSearchItemType.waitUntilEnabled().sendKeys(itemTypeInSheet);
                waitABit(1000);
                partSearchSubfamily.sendKeys(subFamilyInSheet);
                waitABit(1000);
                partSearchLifecycle.waitUntilEnabled().sendKeys("Released");
                waitABit(1000);
                purposeSearchField.waitUntilEnabled().sendKeys("Commercial");
                for (int j = 1; j <= 6; j++) {
                    waitABit(1000);
                    reusableUtilities.pressTab();
                }
                productGroupField.waitUntilEnabled().sendKeys(productGroupInSheet);
                waitABit(1000);
                partChangesField.waitUntilEnabled().sendKeys("0");
                waitABit(2000);
                for (int j = 0; j <= 6; j++) {
                    waitABit(1000);
                    reusableUtilities.pressTab();
                }
                partSearchMigratedField.waitUntilEnabled().sendKeys("1");
                for (int f = 0; f < 16; f++) {
                    waitABit(1000);
                    reusableUtilities.pressShiftTab();
                }
                waitABit(1000);
                paginationPageSize.waitUntilEnabled().click();
                reusableUtilities.pressControlA();
                $(Serenity.getDriver().switchTo().activeElement()).sendKeys("10");
                waitABit(1000);
                reusableUtilities.pressEnterWithoutElement();
                try {
                    reusableMethods.waitUntilElementVisible(searchResults);
                } catch (TimeoutException e) {
                    throw new Exception("Element searchResults was not visible within the expected time.", e);
                }
                paginationButton.waitUntilEnabled().click();
                paginationLastPageNumber.waitUntilVisible();
                String a = paginationLastPageNumber.getText();
                String b = a.substring(3);
                System.out.println("abcd " + b);
                paginationCurrentPageNumberField.waitUntilEnabled().click();
                reusableUtilities.pressControlA();
                paginationCurrentPageNumberField.sendKeys(b);
                reusableUtilities.pressEnterWithoutElement();

                //Open Migrated Parts
                $(searchResults).waitUntilClickable();
                waitABit(13000);
                System.out.println(itemTypeNumber);
                action.moveToElement(searchResults).doubleClick().build().perform();
                reusableMethods.closeFirstOpenedTab();

                //Fetching Item Code
                Serenity.getDriver().switchTo().defaultContent().switchTo().frame(parentFrame).switchTo().frame(childFrame);
                itemCode = $(itemCodeField).getAttribute("value").trim();
                System.out.println(itemCode + " is the item code");

                //Releasing through ECO
                waitABit(10000);
                partPage.userClicksOnAddItemSToChange();
                reusableMethods.closeFirstOpenedTab();
                userFillAllMandatoryFieldsInECOAndClickOnSave("Migrated Part Released test for: " + itemCode, "created by automation script", "Commercial", "Product maintenance");
                partPage.userClicksOnTab("Affected Items");
                userSelectsTargetLifecycle("Released");
                Serenity.getDriver().switchTo().defaultContent().switchTo().frame(parentFrame);
                reusableMethods.waitUntilElementVisible(refreshButton).click();
                Serenity.getDriver().switchTo().frame(childFrame);
                $(itemCodeField).waitUntilEnabled();
                waitABit(5000);
                ecoItemCode = $(itemCodeField).getAttribute("value").trim();
                System.out.println(ecoItemCode + " is the ECO item code");
                partPage.userClicksOnTab("Assignments");
                userShouldSelectTheOwnerApprovalCheckbox();
                partPage.userClicksOnTab("SignOffs");
                userShouldCompleteTheSignOffProcessOfECO();

                //Fetching Integration Tab results
                partPage.userClicksOnTab("Integration Results");
                Serenity.getDriver().switchTo().defaultContent();
                reusableUtilities.switchFrame($(ParametersToIngredientPage.newFrameForCreatePartFrame), "", 0);
                reusableUtilities.switchFrame($(newFrameOfIntegrationResultsTab), "", 0);
                $(runSearchButton).waitUntilClickable();
                waitABit(40000);
                $(runSearchButton).click();
                List<WebElement> list1 = Serenity.getDriver().findElements(By.xpath("//td[contains(text(),'Material')]"));
                List<WebElement> list2 = Serenity.getDriver().findElements(By.xpath("//td[contains(text(),'MM')]"));
                if (list1.size() != 0) {
                    integrationTabResult = reusableUtilities.getObjectProperty(
                            $(Serenity.getDriver().findElement(
                                    By.xpath("//td[contains(text(),'Material')]"))), "textContent");
                } else if (list2.size() != 0) {
                    integrationTabResult = reusableUtilities.getObjectProperty(
                            $(Serenity.getDriver().findElement(
                                    By.xpath("//td[contains(text(),'MM')]"))), "textContent");
                } else {
                    integrationTabResult = "Response is EMPTY";
                }

                //Open newly released part
                partPage.userClicksOnTab("Affected Items");
                Serenity.getDriver().switchTo().defaultContent().switchTo().frame(newFrameForCreatePartFrame);
                reusableUtilities.switchFrame($(Serenity.getDriver().findElement(By.xpath("//iframe[@src = 'ShowFormInFrame.html']"))), "", 0);
                reusableUtilities.switchFrame($(newFrameToAddProductsInAffectedTab), "", 0);
                System.out.println("(//*[text()='" + itemCode.trim() + "'])[2]");
                reusableUtilities.conditionalWait("visibility", By.xpath("(//*[text()='" + itemCode.trim() + "'])[2]"), "");
                $(By.xpath("(//*[text()='" + itemCode.trim() + "'])[2]")).click();
                Serenity.getDriver().switchTo().defaultContent();
                $(PartPage.closeButtonForSecondTab).waitUntilClickable();
                $(PartPage.closeButton).click();
                waitABit(1000);
                Serenity.getDriver().switchTo().defaultContent().switchTo().frame(newFrameForCreatePartFrame);
//                $(refreshButton).waitUntilClickable();
//                waitABit(1000);
//                $(refreshButton).click();
                reusableUtilities.conditionalWait("visibility", PartPage.newFrameForCreatePartFrameDataEntry, "");
                reusableUtilities.switchFrame($(PartPage.newFrameForCreatePartFrameDataEntry), "", 0);
                String s3 = reusableUtilities.getObjectProperty($(By.xpath("//input[@name='pmi_target_lc']")), "value");
                if (s3.equalsIgnoreCase("Released")) {
                    Assert.assertTrue(true);
                } else {
                    throw new Exception("Test Fail: Part lifeCycle is not in Released state, current state is :" + s3);
                }
                Serenity.getDriver().switchTo().parentFrame();
                $(shareButton).waitUntilClickable();
                waitABit(2000);
                $(shareButton).click();
                waitABit(1000);
                $(Serenity.getDriver().findElement(By.xpath("//span[text()='Copy ID']"))).click();
                Toolkit toolkit = Toolkit.getDefaultToolkit();
                Clipboard clipboard = toolkit.getSystemClipboard();
                copyID = (String) clipboard.getData(DataFlavor.stringFlavor);

                System.out.println("a " + itemCode);
                System.out.println("b " + ecoItemCode);
                System.out.println("c " + copyID);
                System.out.println("d " + integrationTabResult);

                //Write the output to Excel

                sheet1.getRow(row).getCell(3).setCellValue(itemCode);
                sheet1.getRow(row).getCell(4).setCellValue(ecoItemCode);
                sheet1.getRow(row).getCell(5).setCellValue(copyID);
                sheet1.getRow(row).getCell(6).setCellValue(integrationTabResult);

                FileOutputStream fos = new FileOutputStream("MigratedE2ESheet.xlsx");
                wb.write(fos);
                fos.close();

                System.out.println("11111" + row);
                System.out.println("22222" + sheet1.getLastRowNum());

                if (row == sheet1.getLastRowNum()) {
                    break;
                }
                //Refresh the page and open the search part again
                Serenity.getDriver().navigate().refresh();
                waitABit(5000);
                //Serenity.getDriver().switchTo().alert().accept();
                home.verifyHomePage();
                home.navigating("Design/Parts/Search Parts");

            } catch (Exception e) {
                System.out.println("In Catch");
                Serenity.getDriver().switchTo().defaultContent().switchTo().frame(parentFrame);
                if ($(PartPage.alertMessage).isCurrentlyVisible()) {
                    System.out.println("In Catch's IF");
                    String errorMessage = reusableUtilities.getObjectProperty($(PartPage.alertMessage), "text");
                    sheet1.getRow(row).getCell(3).setCellValue(itemCode);
                    sheet1.getRow(row).getCell(4).setCellValue(ecoItemCode);
                    sheet1.getRow(row).getCell(7).setCellValue(errorMessage);
                    FileOutputStream fos = new FileOutputStream("MigratedE2ESheet.xlsx");
                    wb.write(fos);
                }

                // Check if the next row is empty
                if (sheet1.getRow(row + 1) != null && sheet1.getRow(row + 1).getCell(0) != null) {
                    // Refresh the page and open the search part again
                    Serenity.getDriver().navigate().refresh();
                    waitABit(5000);
                    // Serenity.getDriver().switchTo().alert().accept();
                    home.verifyHomePage();
                    home.navigating("Design/Parts/Search Parts");
                } else {
                    System.out.println("Next row is empty brooo");
                }
                e.printStackTrace();
            }

        }
    }

}


