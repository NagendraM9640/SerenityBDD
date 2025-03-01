package starter.PageObjectsPages;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import starter.PageObjectsPages.nonMBOM.FMS.PartPage;
import starter.PageObjectsPages.Develop.ItemCodeStore;
import starter.PageObjectsPages.Develop.PartPageDev;
import starter.Utility.ReusableMethods;
import starter.Utility.ReusableUtilities;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.time.Duration;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MigratedDataPVPage extends PageObject {
    ReusableUtilities reusableUtilities = new ReusableUtilities();
    ReusableMethods reusableMethods = new ReusableMethods();
    ARASLoginPageObjects arasLoginPageObjects = new ARASLoginPageObjects();
    ARAS_HomePage arasHomePage = new ARAS_HomePage();
    PartPageDev partPage = new PartPageDev();
    Actions action = new Actions(Serenity.getDriver());

    public static @FindBy(xpath = "//*[@id='instance']") WebElementFacade newFrameForCreatePartFrameDataEntry;
    public static @FindBy(xpath = "//input[@aria-label='Lifecycle Status search cell']") WebElementFacade lifeCycleStatusSearchForPV;

    public static @FindBy(xpath = "(//*[@class='aras-grid-row-cell '])[1]") WebElementFacade searchResultsInGrid;
    public static @FindBy(xpath = "//*[@id='gridTD']/div[2]/div[2]/div/table/tr[1]/td[2]") WebElementFacade openFirstEleFromTable;
    public static @FindBy(xpath = "//*[@id='gridTD']/div[2]/div[2]/div/table/tr/td[2]") List<WebElementFacade> searchTableRows;
    public static @FindBy(xpath = "//button[@title='Next Page']") WebElementFacade nextPageButton;
    public static @FindBy(xpath = "//*[@id='main-tab']/div/div/ul/li[2]/span[1]") WebElementFacade TheSecondOpenedTab;
    public static @FindBy(xpath = "//*[@id='main-tab']/div/div/ul/li[3]/span[1]") WebElementFacade TheThirdOpenedTab;
    public static @FindBy(xpath = "//iframe[@title='pmi_PECOIntegrationRecords Relationship']") WebElementFacade newFrameForIntegrationTabInPECO;
    public static @FindBy(xpath = "//button[@title='Show Total Pages and Results']") WebElementFacade totalPagesAndResultsButton;
    public static @FindBy(xpath = "//input[@aria-label='Product Variant Identifier search cell']") WebElementFacade pvIdentifierSearchCell;
    public static @FindBy(xpath = "//input[@aria-label='Product Type search cell']") WebElementFacade productTypeFieldForPV;
    public static @FindBy(xpath = "//input[@aria-label='Migration Category search cell']") WebElementFacade migrationCategorySearchForPV;

    public static @FindBy(xpath = "//*[@id='main-tab']/div/div/ul/li[1]/span[1]") WebElementFacade closeTheFirstOpenedTab;
    public static @FindBy(xpath = "//input[@name='pmi_item_code']") WebElementFacade productVariantItemCode;
    public static @FindBy(xpath = "//span[@class='aras-toolbar__item aras-link_a aras-toolbar__lin' and text()='Open Current']") WebElementFacade openCurrentRev;
    public static @FindBy(xpath = "//span[@class='sys_item_link pmi_sellable_product']") WebElementFacade sellableProductItemCode;
    public static @FindBy(xpath = "//span[@class='sys_item_link pmi_global_product']") WebElementFacade globalProductItemCode;
    public static @FindBy(xpath = "//button[@title='Add Product ECO Poly Item']") WebElementFacade addProductsButtonInAffectedTab;
    public static @FindBy(xpath = "//td[@data-head-id='pmi_item_code_D']/input[@class='aras-form-input']") WebElementFacade productCodeField;
    public static @FindBy(xpath = "//iframe[@title='pmi_ProductECO_AffectedItem Relationship']") WebElementFacade newFrameToAddProductsInAffectedTab;
    public static @FindBy(xpath = "//button[@class='aras-button aras-button_primary aras-buttons-bar__button']") WebElementFacade searchOkButton;
    public static @FindBy(xpath = "//input[@aria-label='Number search cell']") WebElementFacade pecoNumberField;
    public static @FindBy(xpath = "//*[@id='main-tab']/div/div/ul/li/span[1]") List<WebElementFacade> activeTabsList;
    public static @FindBy(xpath = "//button[@title='Refresh']") WebElementFacade refreshButton;
    public static @FindBy(xpath = "//button[@title='Share']") WebElementFacade shareButton;

    public static @FindBy(xpath = "//*[text()='Done']") WebElementFacade doneButton;
    public static @FindBy(xpath = "//iframe[@id='A89403A2231B4D709210D41E9192BA4E']") WebElementFacade productVariantChangesFrame;
    public static @FindBy(xpath = "//iframe[@id='8C5DE16A30A447F4B9CBE5551D5BF18D']") WebElementFacade globalVariantChangesFrame;
    public static @FindBy(xpath = "//iframe[@id='4956E15FB8A34AF1A37C21DEA1B90B7D']") WebElementFacade sellableProductChangesFrame;
    public static @FindBy(xpath = "//iframe[@title='pmi_SellableProductParameter Relationship']") WebElementFacade sellableProductParameterRelationshipFrame;
    public static @FindBy(xpath = "//iframe[@title='pmi_GlobalProductParameter Relationship']") WebElementFacade globalProductParameterRelationshipFrame;
    public static @FindBy(xpath = "//iframe[@title='pmi_ProductVariantParameter Relationship']") WebElementFacade productVariantParameterRelationshipFrame;
    public static @FindBy(xpath = "//select[@title='Search Modes']") WebElementFacade searchModesInSearchDialogue;

    public static @FindBy(xpath = "//button[@title='Clear Search Criteria']") WebElementFacade clearSearchCriteria;
    public static @FindBy(xpath = "//td[@data-head-id='pmi_parameter_number_R']") WebElementFacade parameterNumberFieldInSearchMode;
    public static @FindBy(xpath = "//button[@title='Add Global Harmonized Parameters']") WebElementFacade GHPAddButton;

    public static @FindBy(xpath = "//iframe[@class='aras-dialog__iframe']") WebElementFacade dialogueFrame;

    public static @FindBy(xpath = "//button[@title='Run Search']") WebElementFacade runSearchButton;
    public static @FindBy(xpath = "//*[@id='gridTD']/div[2]/div[2]/div/table/tr[position() > 2]/td[6]") List<WebElementFacade> responseElements;
    public static @FindBy(xpath = "//td[contains(text(),'Material Master distribution successful')]") List<WebElementFacade> materialResponse;
    public static @FindBy(xpath = "(//table//td[@class='aras-grid-row-cell aras-grid-row-cell__select'])[1]") WebElementFacade parameterDataType;
    public static @FindBy(xpath = "//td[@data-head-id='pmi_parameter_number_D']") WebElementFacade parameterNumberFieldInDialogueFrame;
    public static @FindBy(xpath = "//span[@title='Change Type']") WebElementFacade changeTypeField;
    public static @FindBy(xpath = "//td[@data-head-id='pmi_text_value_D']") WebElementFacade textFieldInSimpleSearch;
    public static @FindBy(xpath = "//td[@data-head-id='pmi_target_value_D']") WebElementFacade targetFieldInSimpleSearch;
    public static @FindBy(xpath = "//td[@data-head-id='pmi_data_type_R']") WebElementFacade dataTypeFieldInSimpleSearch;
    public static @FindBy(xpath = "//td[@data-head-id='pmi_max_value_D']") WebElementFacade maxFieldInSimpleSearch;
    public static @FindBy(xpath = "//td[@data-head-id='pmi_min_value_D']") WebElementFacade minFieldInSimpleSearch;
    public static @FindBy(xpath = "(//iframe[@class='content-block__iframe'])[3]") WebElementFacade thirdParentFrame;
    public static @FindBy(xpath = "//button[@title='More']") WebElementFacade moreButton;
    public static @FindBy(xpath = "(//iframe[@class='content-block__iframe'])[2]") WebElementFacade secondFrame;
    public static @FindBy(xpath = "//span[@class='aras-list-item__label' and text()='Barcode Assignment']") WebElementFacade barcodeAssignmentButton;

    public static @FindBy(xpath = "//button[@class='aras-button aras-button_primary aras-buttons-bar__button']") WebElementFacade arasSearchOkButton;
    List<String> pvGpSpCodes = new ArrayList<String>();
    String pvItemCode = "";
    String spItemCode = "";
    String gpItemCode = "";

    public void userFillsDataInProductECO(String ecoTitle, String ecoDescription, String ecoReasonForChange, String ecoChangeDrivers) throws Exception {
//        try {
//            Serenity.getDriver().switchTo().defaultContent().switchTo().frame(MigratedDataPartPage.newFrameForCreatePartFrame).switchTo().frame(newFrameForCreatePartFrameDataEntry);
//
//            waitABit(1000);
//
//            $(MarketObjectPage.ecoTitleField).sendKeys(ecoTitle);
//            waitABit(1000);
//            $(MarketObjectPage.ecoDescriptionField).sendKeys(ecoDescription);
//            waitABit(1000);
//            $(MarketObjectPage.ecoReasonForChangeField).sendKeys(ecoReasonForChange);
//            waitABit(1000);
//            $(ProductECOPage.changeDriversField).selectByVisibleText(ecoChangeDrivers);
//
//            getDriver().switchTo().parentFrame();
//            $(ProductECOPage.saveButton).click();
//
//        } catch (Exception e) {
//            throw new Exception("Error while filling ECO data: " + e.getMessage(), e);
//        }
    }

    public void searchForProductVariants(String productType, String productCategory) throws Exception {
        try {
            Serenity.getDriver().switchTo().defaultContent().switchTo().frame(MigratedDataPartPage.parentFrame);

            withTimeoutOf(Duration.ofSeconds(100)).waitFor(MigratedDataPartPage.clearSearchCriteria).click();
            withTimeoutOf(Duration.ofSeconds(100)).waitFor(lifeCycleStatusSearchForPV).waitUntilClickable().sendKeys("Preliminary");

            // Press Tab twice to navigate through the fields
            for (int i = 1; i <= 2; i++) {
                reusableUtilities.pressTab();
                waitABit(1000);
            }

            // Type and tab in the product category field
            $(Serenity.getDriver().switchTo().activeElement()).typeAndTab(productCategory);

            waitABit(2000);

            withTimeoutOf(Duration.ofSeconds(100)).waitFor(productTypeFieldForPV).waitUntilClickable().sendKeys(productType);

            // Press Tab several times to navigate further
            for (int i = 1; i <= 7; i++) {
                reusableUtilities.pressTab();
                waitABit(1000);
            }

            // Enter "2_PLM" in the active field
            // $(Serenity.getDriver().switchTo().activeElement()).sendKeys("2_PLM");
            waitABit(1000);

            // Press Shift+Tab several times to navigate back to previous fields
            for (int i = 1; i <= 17; i++) {
                reusableUtilities.pressShiftTab();
                waitABit(1000);
            }

            $(runSearchButton).click();

            // Wait until the first element from the table is visible
            reusableMethods.waitUntilElementVisible(openFirstEleFromTable);

        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Error while searching for product variants: " + e.getMessage(), e);
        }
    }

    public List<String> retrieveAndStoreItemCodes(String productType, String productCategory) throws Exception {
        // Perform the initial search for product variants
        searchForProductVariants(productType, productCategory);
        boolean continueSearch = true;

        // Set to store processed product variants to avoid duplicates
        Set<String> processedProductVariants = new HashSet<>();

        // Index to track the current row in the search results
        int currentIndex = 1;

        // $(nextPageButton).click();

        waitABit(5000);

        // Loop to process the product variants until the search is completed
        while (continueSearch) {
            try {
                // If we've reached the last row, click next page and reset the current index
                if (currentIndex == searchTableRows.size()) {
                    $(nextPageButton).click();
                    currentIndex = 1;
                    waitABit(5000);
                }

                switchToDefaultContentAndParentFrame();

                // Get the current row element and extract the product variant number
                WebElementFacade currentRowElement = getElementByIndex(currentIndex);

                String productVariantNumber = currentRowElement.getText();
                String SPItemCode = getTheElementText(currentIndex, 4);
                String GPItemCode = getTheElementText(currentIndex, 5);

                if (!SPItemCode.trim().equalsIgnoreCase("Restricted") && !GPItemCode.trim().equalsIgnoreCase("Restricted")) {
                    // If the product variant is already verified, skip to the next row
                    if (processedProductVariants.contains(productVariantNumber)) {
                        currentIndex++;
                        continue;
                    } else {
                        // Double-click on the product variant to open
                        action.moveToElement(currentRowElement).doubleClick().build().perform();
                        waitABit(3000);

                        if (ValidateBarcodeAssignment()) {
                            // Skip to the next iteration if barcode assignment error is valid
                            currentIndex++;
                            Serenity.getDriver().switchTo().defaultContent();
                            closeAdditionalSecondTabIfVisible();
                            continue;
                        } else {
                            // Check if any changes are detected for the product variant
                            boolean isChangeDetectedForPV = isAnyOngoingChange("ProductVariant Changes", 2, productVariantChangesFrame);

                            if (isChangeDetectedForPV) {
                                // If changes are detected, mark the variant as checked and close the tab
                                processedProductVariants.add(productVariantNumber);
                                Serenity.getDriver().switchTo().defaultContent();
                                closeAdditionalSecondTabIfVisible();
                            } else {
                                // Handle global and sellable product changes and stop the search if no changes are detected for SP and GP
                                boolean canWeUse = handleGlobalAndSellableProductChanges(productVariantNumber);
                                if (!canWeUse) {
                                    copyTheProductItemCodes();
                                    continueSearch = false;
                                }
                            }
                        }
                    }
                }

                currentIndex++; // Increment currentIndex to process the next row

            } catch (Exception e) {
                System.err.println("An error occurred: " + e.getMessage());
                throw new Exception("Error during product variant retrieval: " + e.getMessage(), e);
            }
        }

        return pvGpSpCodes;
    }

    public boolean ValidateBarcodeAssignment() {
        try {
            // Switch to the second frame
            Serenity.getDriver().switchTo().defaultContent().switchTo().frame(secondFrame);

            // Click on the more button and then the barcode assignment button
            moreButton.waitUntilClickable().click();
            barcodeAssignmentButton.waitUntilClickable().click();

            // Wait for the actions to complete
            waitABit(3000);

            // Switch back to the default content
            Serenity.getDriver().switchTo().defaultContent();

            // Check if the third tab is visible and click it if it is
            if (TheThirdOpenedTab.isCurrentlyVisible()) {
                TheThirdOpenedTab.click();
            }

            // Switch back to the second frame
            Serenity.getDriver().switchTo().frame(secondFrame);

            // Check if an error message is displayed
            if (isErrorMessageDisplayed()) {
                return $(PartPage.alertMessage).getText().contains("(E)");
            }
        } catch (Exception e) {
            // Log the exception for debugging purposes
            System.err.println("An error occurred during barcode assignment validation: " + e.getMessage());
        }

        return false;
    }


    public boolean isErrorMessageDisplayed() {
        try {
            Serenity.getDriver().switchTo().defaultContent().switchTo().frame(secondFrame);
            return $(PartPage.alertMessage).isCurrentlyVisible();
        } catch (Exception e) {
            System.err.println("Error checking error message visibility: " + e.getMessage());
            return false;
        }
    }

    public String getTheElementText(int currentIndex, int column) {
        return $(By.xpath("//*[@id='gridTD']/div[2]/div[2]/div/table/tr[" + currentIndex + "]/td[" + column + "]")).getText();
    }

    private void closeAdditionalSecondTabIfVisible() {
        if ($(TheSecondOpenedTab).isCurrentlyVisible()) {
            $(TheSecondOpenedTab).click();
        }
    }

    private boolean handleGlobalAndSellableProductChanges(String productVariantNumber) throws Exception {
        try {
            waitABit(3000);
            Serenity.getDriver().switchTo().defaultContent().switchTo().frame(ReusableMethods.parentFrameForSecondTab).switchTo().frame(MigratedDataPartPage.childFrame);

            // Click on the global product item code
            $(globalProductItemCode).click();

            // Switch frames again for the refresh operation
            Serenity.getDriver().switchTo().defaultContent().switchTo().frame(thirdParentFrame);

            // Click on the refresh button
            $(refreshButton).click();

            waitABit(2000);

            // Handle refresh edit failed alert if visible
            if ($(PartPage.alertMessage).isCurrentlyVisible()) {
                $(MigratedDataPartPage.alertOkButton).click();
            }

            // Check if any global product changes are detected
            boolean globalProductChangeDetected = isAnyOngoingChange("Global Product Changes", 3, globalVariantChangesFrame);

            // If no global product changes, proceed to sellable product
            if (!globalProductChangeDetected) {
                System.out.println("Change Not Detected For GP");
                Serenity.getDriver().switchTo().defaultContent();
                $(TheThirdOpenedTab).click();
                System.out.println("Closed GP....Opening SP....");
                // Switch to frames again for sellable product interaction
                Serenity.getDriver().switchTo().defaultContent().switchTo().frame(ReusableMethods.parentFrameForSecondTab).switchTo().frame(MigratedDataPartPage.childFrame);

                // Click on the sellable product item code
                $(sellableProductItemCode).click();

                // Switch frames again for the refresh operation
                Serenity.getDriver().switchTo().defaultContent().switchTo().frame(thirdParentFrame);

                // Click on the refresh button
                $(refreshButton).click();

                waitABit(2000);

                // Handle refresh edit failed alert if visible
                if ($(PartPage.alertMessage).isCurrentlyVisible()) {
                    $(MigratedDataPartPage.alertOkButton).click();
                }

                // Check if any sellable product changes are detected
                boolean sellableProductChangeDetected = isAnyOngoingChange("Sellable Product Changes", 3, sellableProductChangesFrame);

                // If no sellable product changes, proceed with copying the product item codes
                if (!sellableProductChangeDetected) {
                    System.out.println("Change Not Detected For SP");
                    Serenity.getDriver().switchTo().defaultContent();
                    $(TheThirdOpenedTab).click();
                    System.out.println("Not Added any change we can use for PECO....");
                    return false;
                } else {
                    System.out.println("Change Detected For SP");
                    // If there are changes, handle the tab closure
                    handleTabClosure();
                    return true;
                }
            } else {
                System.out.println("Change Detected For GP");
                // If global product changes are detected, handle the tab closure
                handleTabClosure();
                System.out.println("Closing GP..........");
                return true;

            }
        } catch (Exception e) {
            System.err.println("An error occurred while handling global and sellable product changes: " + e.getMessage());
            throw new Exception("Error in handling global and sellable product changes for product variant " + productVariantNumber, e);
        }
    }

    private void handleTabClosure() {
        Serenity.getDriver().switchTo().defaultContent();
        if ($(TheThirdOpenedTab).isCurrentlyVisible()) {
            $(TheThirdOpenedTab).click();
            $(TheSecondOpenedTab).click();
        }
    }

    private void switchToDefaultContentAndParentFrame() {
        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(MigratedDataPartPage.parentFrame);
    }

    private WebElementFacade getElementByIndex(int index) {
        return $(By.xpath("//*[@id='gridTD']/div[2]/div[2]/div/table/tr[" + index + "]/td[2]"));
    }


    public void copyTheProductItemCodes() throws Exception {
        try {
            Serenity.getDriver().switchTo().defaultContent().switchTo().frame(ReusableMethods.parentFrameForSecondTab).switchTo().frame(MigratedDataPartPage.childFrame);

            waitABit(3000);

            // Get the product variant, sellable product, and global product item codes
            pvItemCode = withTimeoutOf(Duration.ofSeconds(100)).waitFor(productVariantItemCode).getAttribute("value");

            spItemCode = $(sellableProductItemCode).getText().trim();
            gpItemCode = $(globalProductItemCode).getText().trim();

            // Add the item codes to the list
            pvGpSpCodes.add(pvItemCode);
            pvGpSpCodes.add(spItemCode);
            pvGpSpCodes.add(gpItemCode);

            System.out.println("PV Code: " + pvItemCode);
            System.out.println("SP Code: " + spItemCode);
            System.out.println("GP Code: " + gpItemCode);
        } catch (Exception e) {
            throw new Exception("Error while copying product item codes: " + e.getMessage(), e);
        }

    }

    public boolean isAnyOngoingChange(String tabName, int indexOfFrame, WebElementFacade changesTabFrame) {
        try {
            partPage.userClicksOnTab(tabName);

            // Switch to the correct iframe using index
            WebElementFacade element = $(By.xpath("(//iframe[@class='content-block__iframe'])[" + indexOfFrame + "]"));
            Serenity.getDriver().switchTo().defaultContent().switchTo().frame(element).switchTo().frame(changesTabFrame);

            // Wait for the field to be available
            withTimeoutOf(Duration.ofSeconds(180)).waitFor(changeTypeField);
            waitABit(3000);

            // Check if "New" change type is visible, indicating an ongoing change
            return $(By.xpath("//td[text()='New']")).isCurrentlyVisible();
        } catch (Exception e) {
            System.err.println("Error checking ongoing change for " + tabName + ": " + e.getMessage());
            return false;
        }
    }


    public String getItemCodeForPV() {
        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(MigratedDataPartPage.parentFrame).switchTo().frame(MigratedDataPartPage.childFrame);
        waitABit(3000);
        return withTimeoutOf(Duration.ofSeconds(100)).waitFor(productVariantItemCode).getAttribute("value");
    }

    public String setSearchCriteria(List<String> itemCodes) {
        if (itemCodes == null || itemCodes.isEmpty()) {
            return "";  // Return empty string if the list is null or empty
        }

        String searchCriteria = itemCodes.stream().collect(Collectors.joining("|"));

        System.out.println(searchCriteria);

        return searchCriteria;
    }

    public void addPVSPGPInAffectedItems(List<String> itemCodes) {
        String pvGpSpCodes = setSearchCriteria(itemCodes);

        try {
            Serenity.getDriver().switchTo().defaultContent().switchTo().frame(MigratedDataPartPage.parentFrame).switchTo().frame(newFrameToAddProductsInAffectedTab);

            withTimeoutOf(Duration.ofSeconds(100)).waitFor(addProductsButtonInAffectedTab).waitUntilClickable().click();

            Serenity.getDriver().switchTo().parentFrame().switchTo().frame(MigratedDataPartPage.dialogueFrame);
            waitABit(3000);

            // Clear existing criteria and input the generated search codes
            withTimeoutOf(Duration.ofSeconds(100)).waitFor(MigratedDataPartPage.clearSearchCriteria).waitUntilClickable().click();
            waitABit(3000);

            withTimeoutOf(Duration.ofSeconds(100)).waitFor(productCodeField).waitUntilClickable().sendKeys(pvGpSpCodes);
            // Run the search and wait for the results
            withTimeoutOf(Duration.ofSeconds(100)).waitFor(MigratedDataPartPage.runSearchButton).waitUntilClickable().click();
            withTimeoutOf(Duration.ofSeconds(100)).waitFor(searchResultsInGrid).click();

            // Select all items and confirm the selection
            reusableUtilities.pressControlA();
            waitABit(2000);

            withTimeoutOf(Duration.ofSeconds(100)).waitFor(searchOkButton).waitUntilClickable().click();

            System.out.println("PV/SP/GP Codes added successfully!");
        } catch (Exception e) {
            System.err.println("Error while adding PV SP GP in affected items: " + e.getMessage());
            throw e;
        }
    }

    public void searchForPECOItems(String itemCode) {
        try {
            Serenity.getDriver().switchTo().defaultContent().switchTo().frame(MigratedDataPartPage.parentFrame);

            withTimeoutOf(Duration.ofSeconds(100)).waitFor(pecoNumberField);
            waitABit(2000);

            // Clear search criteria
            withTimeoutOf(Duration.ofSeconds(100)).waitFor(MigratedDataPartPage.clearSearchCriteria).click();
            waitABit(2000);

            // Click and enter the item code into the search field
            withTimeoutOf(Duration.ofSeconds(100)).waitFor(pecoNumberField).click();
            waitABit(2000);

            $(Serenity.getDriver().switchTo().activeElement()).sendKeys(itemCode);
            waitABit(2000);

            $(MigratedDataPartPage.runSearchButton).click();

            // Wait for the element to appear and double-click it
            withTimeoutOf(Duration.ofSeconds(100)).waitFor(By.xpath("//*[text()='" + itemCode + "']"));
            waitABit(3000);

            // Move to the element and double-click it
            action.moveToElement($(By.xpath("//*[text()='" + itemCode + "']"))).doubleClick().build().perform();
            waitABit(2000);

            Serenity.getDriver().switchTo().defaultContent();
            withTimeoutOf(Duration.ofSeconds(100)).waitFor(activeTabsList.get(1));
            activeTabsList.get(0).click();

            System.out.println("PECO Item " + itemCode + " found and selected.");
        } catch (Exception e) {
            System.err.println("Error while searching for PECO item: " + e.getMessage());
            throw e;
        }
    }

    public void setsNewLifecycleOfPVSPGPIsReleased() throws Exception {
        try {
            Serenity.getDriver().switchTo().defaultContent().switchTo().frame(MigratedDataPartPage.parentFrame).switchTo().frame(newFrameToAddProductsInAffectedTab);

            for (String code : pvGpSpCodes) {
                $(By.xpath("//*[text()='" + code.trim() + "']")).click();
                waitABit(1000);
                navigateUsingTabsAndDownKeys(4);  // 4 tab presses and 4 down key presses
            }

            //Save the data
            Serenity.getDriver().switchTo().defaultContent().switchTo().frame(MigratedDataPartPage.parentFrame);
            $(doneButton).click();
            System.out.println("Lifecycle of PV/SP/GP codes has been updated successfully.");
            waitABit(5000);
        } catch (Exception e) {
            System.err.println("Error while setting the lifecycle of PV/SP/GP: " + e.getMessage());
            throw new Exception("Error while setting lifecycle: " + e.getMessage());
        }
    }

    private void navigateUsingTabsAndDownKeys(int numberOfTabs) {
        for (int i = 0; i < 3; i++) {
            reusableUtilities.pressTab();
            waitABit(1000);
        }
        for (int i = 0; i < numberOfTabs; i++) {
            reusableUtilities.pressDownNavigation();
            waitABit(1000);
        }

        reusableUtilities.pressTab();
        waitABit(1000);
    }

    public String fetchPECONumber() {
        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(MigratedDataPartPage.parentFrame).switchTo().frame(MigratedDataPartPage.childFrame);
        return $(MigratedDataPartPage.ecoNumberField).getAttribute("value").trim();
    }

    public void refreshThePage() {
        Serenity.getDriver().navigate().refresh();
        waitABit(5000);
    }

    public void refreshThePageAndNavigateSearchProductVariantsPage() {
        Serenity.getDriver().navigate().refresh();
        waitABit(5000);
        arasHomePage.navigating("Product Portfolio and Project Management/Product Variants/Search Product Variants");
    }

    public void completeTheSignOffProcessForPECO() throws Exception {
        String pecoNumber = fetchPECONumber();
        ItemCodeStore.storeTheData("pecoNum", pecoNumber);
        switchToECOWorkflowFrame();

        while (!isPECOReleased()) {
            long startTime = System.currentTimeMillis();
            // Retrieve the active user and initiate the vote process
            String activeUserAndNextApprover = retrieveActiveUserAndInitiateVoteProcess();

            // Break if the active user is the Super User or If PECO is released, exit the loop
            if (activeUserAndNextApprover == null || activeUserAndNextApprover.trim().equalsIgnoreCase("Super User") || isPECOReleased()) {
                break;
            }
            // If an active user is found and it's not the current user, switch to that user and continue
            if (!isCurrentUser(activeUserAndNextApprover)) {
                switchToUserAndContinue(activeUserAndNextApprover, pecoNumber);
            }
            long endTime = System.currentTimeMillis();
            System.out.println("Time taken for current cycle: " + (endTime - startTime) + " ms");
        }
    }


    public void switchToUserAndContinue(String nextVoteAssignedUser, String ecoNumber) throws Exception {
        String[] credentials = MigratedDataPartPage.retrieveUserCredentials("src/test/resources/TestData/UserCredentials.xlsx", "Sheet1", nextVoteAssignedUser);
        if (credentials != null) {
            performLogOutLoginAndNavigateToECO(credentials[0], ecoNumber);
        } else {
            throw new Exception("User credentials not found in Excel file...Please update the credential for this user: " + nextVoteAssignedUser);
        }
    }

    public void performLogOutLoginAndNavigateToECO(String credentials, String ecoNumber) {
        arasLoginPageObjects.logOutAndLogin();
        arasLoginPageObjects.Login(credentials);

        arasHomePage.verifyHomePage();
        arasHomePage.navigating("Product Portfolio and Project Management/Product ECOs/Search Product ECOs");

        searchForPECOItems(ecoNumber);
        partPage.userClicksOnTab("Signoffs");
    }

    public boolean isCurrentUser(String activeUser) {
        Serenity.getDriver().switchTo().defaultContent();
        String title = $(MigratedDataPartPage.currentUserDetails).getAttribute("title");
        return title.equalsIgnoreCase(activeUser);
    }

    public boolean isPECOReleased() {
        String statusField = validateECOWorkFlowStatus();
        return statusField.equalsIgnoreCase("Released");
    }

    public String validateECOWorkFlowStatus() {
        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(MigratedDataPartPage.parentFrame).switchTo().frame(MigratedDataPartPage.childFrame);
        String ecoStatusText = $(MigratedDataPartPage.ecoStatus).getText();
        return ecoStatusText.trim();
    }

    public void switchToECOWorkflowFrame() {
        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(MigratedDataPartPage.newFrameForCreatePartFrame);
        waitABit(10000);
        if ($(MigratedDataPartPage.newFrameForm1).isCurrentlyVisible()) {
            Serenity.getDriver().switchTo().frame(MigratedDataPartPage.newFrameForm1).switchTo().frame(MigratedDataPartPage.newFrameForm2).switchTo().frame(MigratedDataPartPage.newFrameToSeeSubFamilyWorkFlow);
        } else {
            Serenity.getDriver().switchTo().frame(MigratedDataPartPage.newFrameForm).switchTo().frame(MigratedDataPartPage.newFrameForm2).switchTo().frame(MigratedDataPartPage.newFrameToSeeSubFamilyWorkFlow);
        }
    }

    public String retrieveActiveUserAndInitiateVoteProcess() throws Exception {
        switchToECOWorkflowFrame();
        // Check if the "VOTE NOW" button is visible
        if (isVoteNowButtonVisible()) {
            long startTime = System.currentTimeMillis();
            System.out.println("Vote Now is visible");

            // Find the "Vote Now" button and the corresponding row
            WebElementFacade tdElement = $(MigratedDataPartPage.voteNowBtn);
            WebElement trElement = tdElement.findElement(By.xpath("./ancestor::tr[1]"));

            // Extract the active user and activity details
            WebElement assignedUserCell = trElement.findElement(By.xpath(".//td[3]"));
            WebElement activityCell = trElement.findElement(By.xpath(".//td[1]"));
            String activeUser = assignedUserCell.getText().trim();
            String activity = activityCell.getText().trim();
            System.out.println("Vote is AssignedTo: " + activeUser);
            System.out.println("Activity is: " + activity);

            long endTime = System.currentTimeMillis();
            System.out.println("Time taken to retrieve vote info: " + (endTime - startTime) + " ms");

            // Click the Vote Now button
            $(MigratedDataPartPage.voteNowBtn).click();

            long voteClickTime = System.currentTimeMillis();
            System.out.println("Time taken for vote click: " + (voteClickTime - startTime) + " ms");

            // Complete the vote process based on activity
            completeVoteProcess(activity);

            // Perform parameter validation and check for unwanted errors
            isParameterValidationErrorMessageDisplayed();
            checkAnyUnwantedErrorsIsDisplayed(); // Check for any unwanted errors after clicking the complete button
            return activeUser;
        } else {
            System.out.println("Vote Now is not visible");

            // Check if the Active is visible
            if ($(MigratedDataPartPage.ActiveText).isCurrentlyVisible()) {
                WebElement tdElement = Serenity.getDriver().findElement(By.xpath("(//td[contains(text(),'Active')])[2]"));
                WebElement trElement = tdElement.findElement(By.xpath("./ancestor::tr[1]"));

                // Extract the active user from the found row
                WebElement assignedUserCell = trElement.findElement(By.xpath(".//td[3]"));
                String activeUser = assignedUserCell.getText().trim();
                System.out.println("Vote is AssignedTo: " + activeUser);
                return activeUser;
            }
        }

        // If no active user is found, return null
        return null;
    }


    public boolean isVoteNowButtonVisible() {
        switchToECOWorkflowFrame();
        return $(MigratedDataPartPage.voteNowBtn).isCurrentlyVisible();
    }

    public void completeVoteProcess(String activity) {
        validateWorkflowWindow();
        String trimmedActivity = activity.trim();
        System.out.println("Processing vote for activity: " + trimmedActivity);

        if (trimmedActivity.equals("Submit")) {
            userSelectsSendToReviewVoteList("Start Work"); // If the activity is 'Submit', send it to 'Start Work'
        } else if (trimmedActivity.equals("Draft")) {
            userSelectsSendToReviewVoteList("Submit for Review");  // If the activity is 'Draft', Submit for Review
        } else if (trimmedActivity.contains("1st Approval") || trimmedActivity.contains("Management Approval") || trimmedActivity.contains("GP Approval")) {
            userSelectsSendToReviewVoteList("Approve Change"); // If the activity is '1st Approval' or 'Management Approval'
        } else {
            throw new RuntimeException("Unknown activity type: " + trimmedActivity);
        }

        // Click the 'Complete' button to finalize the vote process
        userClicksCompleteButton();
        System.out.println("Vote process completed for activity: " + trimmedActivity);
    }

    private void isParameterValidationErrorMessageDisplayed() throws Exception {
        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(MigratedDataPartPage.parentFrame);
        if (MigratedDataPartPage.parameterValidationErrorMsg.isCurrentlyVisible()) {
            handleParameterUpdates();
       }
        //else if (MigratedDataPartPage.parameterValidationErrorMsg2.isCurrentlyVisible()) {
//            handleParameterUpdates();
//        } else {
//            System.out.println("Some error message is displaying.........");
//        }
    }

    public void userShouldEnterTheEsignature() {
        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(MigratedDataPartPage.newFrameForCreatePartFrame);
        withTimeoutOf(Duration.ofSeconds(100)).waitFor(MigratedDataPartPage.newFrameForWorkFlow);
        Serenity.getDriver().switchTo().frame(MigratedDataPartPage.newFrameForWorkFlow);
        $(MigratedDataPartPage.eSignatureField).sendKeys("innovator");
    }

    public void userClicksCompleteButton() {
        validateWorkflowWindow();
        $(MigratedDataPartPage.completeButton).click();
        if ($(MigratedDataPartPage.continueButton).isCurrentlyVisible()) {
            $(MigratedDataPartPage.continueButton).click();
        }
    }


    public void validateWorkflowWindow() {
        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(MigratedDataPartPage.newFrameForCreatePartFrame);
        withTimeoutOf(Duration.ofSeconds(100)).waitFor(MigratedDataPartPage.newFrameForWorkFlow);
        Serenity.getDriver().switchTo().frame(MigratedDataPartPage.newFrameForWorkFlow);
    }

    public void checkAnyUnwantedErrorsIsDisplayed() throws Exception {
        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(MigratedDataPartPage.parentFrame);
        if ($(MigratedDataPartPage.errorMessage).isCurrentlyVisible()) {
            String errorMessageText = $(MigratedDataPartPage.errorMessage).getText();
            waitABit(5000);
            throw new Exception("An error displayed: " + errorMessageText);
        }
    }

    public void userSelectsSendToReviewVoteList(String s) {
        validateWorkflowWindow();
        $(MigratedDataPartPage.VoteList).selectByVisibleText(s.trim());
    }

    public List<String> userOpensAndValidatesAddedProductsAndCopyJSONID(String status) throws Exception {
        List<String> jsonIds = new ArrayList<>();
        String copyID = "";

        try {
            for (String pvGpSpCode : pvGpSpCodes) {
                Serenity.getDriver().switchTo().defaultContent().switchTo().frame(MigratedDataPartPage.newFrameForCreatePartFrame).switchTo().frame(newFrameToAddProductsInAffectedTab);

                $(By.xpath("(//*[text()='" + pvGpSpCode + "'])[2]")).click();
                waitABit(1000);

                Serenity.getDriver().switchTo().defaultContent().switchTo().frame(MigratedDataPartPage.newFrameForCreatePartFrame2).switchTo().frame(newFrameForCreatePartFrameDataEntry);

                // Validate the lifecycle status
                String currentState = reusableUtilities.getObjectProperty($(By.xpath("//input[@name='state']")), "value");
                if (!currentState.equalsIgnoreCase(status)) {
                    throw new Exception("Current Lifecycle is different from expected Lifecycle. Expected: " + status + ", Found: " + currentState);
                }

                Serenity.getDriver().switchTo().parentFrame();
                $(shareButton).waitUntilClickable();
                $(shareButton).click();

                // Retrieve and copy the 'Copy ID'
                $(Serenity.getDriver().findElement(By.xpath("//span[text()='Copy ID']"))).click();

                // Handle clipboard interaction to get the copied ID
                Toolkit toolkit = Toolkit.getDefaultToolkit();
                Clipboard clipboard = toolkit.getSystemClipboard();
                copyID = (String) clipboard.getData(DataFlavor.stringFlavor);

                // Close the 2nd tab and wait for the process to complete
                Serenity.getDriver().switchTo().defaultContent();
                $(PartPage.closeButtonForSecondTab).click();
                waitABit(2000);

                // Print and add the Copy ID to the list
                System.out.println(pvGpSpCode + "---->" + copyID);
                jsonIds.add(copyID);
            }

        } catch (Exception e) {
            System.err.println("Error occurred while processing products: " + e.getMessage());
            e.printStackTrace();
            throw new Exception("Error in userOpensAndValidatesAddedProductsAndCopyJSONID: " + e.getMessage(), e);
        }

        return jsonIds;
    }

    public List<String> fetchIntegrationResults() throws Exception {
        List<String> responses = new ArrayList<>();
        WebDriver driver = Serenity.getDriver();

        try {
            driver.switchTo().defaultContent().switchTo().frame(MigratedDataPartPage.newFrameForCreatePartFrame).switchTo().frame(newFrameForIntegrationTabInPECO);

            $(runSearchButton).waitUntilClickable();
            waitABit(60000);
            $(runSearchButton).click();
            waitABit(5000);
            $(runSearchButton).click();
            waitABit(2000);
            // Check if the materialResponse size is 3 and add Material Master distribution successful success message for each code
            if (materialResponse.size() == 3) {
                for (String code : pvGpSpCodes) {
                    responses.add("Material Master distribution successful, 021(ZDGXU_MM) for code: " + code);
                }
            } else {
                // Collecting text from response elements in case of failure or different scenario
                responses = responseElements.stream().map(WebElementFacade::getText).map(response -> {
                    if (response.trim().isEmpty()) {
                        return "Response is empty";
                    }
                    return response;
                }).collect(Collectors.toList());
            }

        } catch (Exception e) {
            System.err.println("Error occurred while fetching integration results: " + e.getMessage());
            e.printStackTrace();
            throw new Exception("Error in fetch Integration Results: " + e.getMessage(), e);
        }

        return responses;
    }

    public void closeTheECOWorkFlowActivityCompletionPopup() {
        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(MigratedDataPartPage.parentFrame);
        withTimeoutOf(Duration.ofSeconds(100)).waitFor(MigratedDataPartPage.closePopUpInECO).click();
    }

    public void handleParameterUpdates() throws Exception {
        try {
            Serenity.getDriver().switchTo().defaultContent();

            switchToFrameBasedOnVisibility();

            String parameterValidationErrorText = $(MigratedDataPartPage.alertMessage).getText(); // Get the text from the alert message
            System.out.println(parameterValidationErrorText + " :AlertText");

            // Switch back to the default content and then to the parent frame
            Serenity.getDriver().switchTo().defaultContent().switchTo().frame(MigratedDataPartPage.parentFrame);

            waitABit(3000);
            $(MigratedDataPartPage.alertOkButton).click(); // Click 'OK' to dismiss the alert
            closeTheECOWorkFlowActivityCompletionPopup(); // Close the popup related to the workflow activity completion

            Map<String, Set<String>> mandatoryValuesMap = extractMandatoryValues(parameterValidationErrorText);

            for (Map.Entry<String, Set<String>> entry : mandatoryValuesMap.entrySet()) {
                String itemCode = entry.getKey();
                Set<String> parameterNumbers = entry.getValue();

                // Process Affected Items
                partPage.userClicksOnTab("Affected Items");

                Serenity.getDriver().switchTo().defaultContent().switchTo().frame(MigratedDataPartPage.newFrameForCreatePartFrame).switchTo().frame(newFrameToAddProductsInAffectedTab);

                $(By.xpath("(//*[text()='" + itemCode + "'])[2]")).click();
                waitABit(1000);
                reusableMethods.clickOnEdit();
                waitABit(3000);

                processItemCodeTabs(itemCode);

                // Handle parameter numbers
                for (String paramNum : parameterNumbers) {
                    System.out.println(itemCode + " Processing value: " + paramNum);
                    theParameterShouldBeFilledWithValueAndItsDataTypeShouldBe(paramNum, "target");
                }

                waitABit(3000);
                Serenity.getDriver().switchTo().defaultContent();
                withTimeoutOf(Duration.ofSeconds(90)).waitFor(TheSecondOpenedTab).click();
            }

            waitABit(3000);
            partPage.userClicksOnTab("Signoffs");

        } catch (Exception e) {
            System.err.println("Error occurred while handling parameter updates: " + e.getMessage());
            e.printStackTrace();
            throw new Exception("Error in handleParameterUpdates: " + e.getMessage(), e);
        }
    }

    private void switchToFrameBasedOnVisibility() {
        if ($(MigratedDataPartPage.newFrameForCreatePartFrame).isCurrentlyVisible()) {
            Serenity.getDriver().switchTo().frame(MigratedDataPartPage.newFrameForCreatePartFrame);
        } else if ($(MigratedDataPartPage.newFrameForCreatePartFrame2).isCurrentlyVisible()) {
            Serenity.getDriver().switchTo().frame(MigratedDataPartPage.newFrameForCreatePartFrame2);
        } else if ($(MigratedDataPartPage.newFrameForCreatePartFrame3).isCurrentlyVisible()) {
            Serenity.getDriver().switchTo().frame(MigratedDataPartPage.newFrameForCreatePartFrame3);
        } else {
            throw new RuntimeException("None of the frames are visible.");
        }
    }

    private void processItemCodeTabs(String itemCode) {
        if (itemCode.contains("SP")) {
            partPage.userClicksOnTab("Sellable Product Parameter");
        } else if (itemCode.contains("GP")) {
            partPage.userClicksOnTab("Global Product Parameter");
        } else {
            partPage.userClicksOnTab("Product Variant Parameter");
        }
    }

    //********************************************************Parameter updates**********************************************************************************//
    public Map<String, Set<String>> extractMandatoryValues(String input) {
        Map<String, Set<String>> mandatoryValuesMap = new HashMap<>();

        String[] lines = input.split("\\r?\\n");

        String currentItem = null;

        for (String line : lines) {
            if (line.startsWith("All GHP Parameters of")) {
                currentItem = line.split(" ")[4];
            } else if (line.contains("Target Value and Text Value is empty for")) {
                String[] parts = line.split(" ");
                String parameter = parts[parts.length - 1];
                Set<String> mandatoryValues = mandatoryValuesMap.getOrDefault(currentItem, new LinkedHashSet<>());
                mandatoryValues.add(parameter);
                mandatoryValuesMap.put(currentItem, mandatoryValues);
            }
        }

        return mandatoryValuesMap;
    }

    private void switchToParameterIframe() {
        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(ReusableMethods.parentFrameForSecondTab);
        if ($(productVariantParameterRelationshipFrame).isCurrentlyVisible()) {
            Serenity.getDriver().switchTo().frame(productVariantParameterRelationshipFrame);
        } else if ($(sellableProductParameterRelationshipFrame).isCurrentlyVisible()) {
            Serenity.getDriver().switchTo().frame(sellableProductParameterRelationshipFrame);
        } else if ($(globalProductParameterRelationshipFrame).isCurrentlyVisible()) {
            Serenity.getDriver().switchTo().frame(globalProductParameterRelationshipFrame);
        }
    }

    private boolean isParameterAvailable(String parameterNumber) {
        return $(By.xpath("//td[text()='" + parameterNumber + "']")).isCurrentlyVisible();
    }


    public void theParameterShouldBeFilledWithValueAndItsDataTypeShouldBe(String parameterNumber, String parameterValues) throws Exception {
        try {
            // Edit action for the second tab
            reusableMethods.clickOnEditForSecondTab();
            switchToParameterIframe();

            withTimeoutOf(Duration.ofSeconds(60)).waitFor(searchModesInSearchDialogue).selectByVisibleText("Simple");

            withTimeoutOf(Duration.ofSeconds(60)).waitFor(clearSearchCriteria).click();
            waitABit(2000);

            withTimeoutOf(Duration.ofSeconds(100)).waitFor(parameterNumberFieldInSearchMode).click();
            waitABit(1000);

            $(Serenity.getDriver().switchTo().activeElement()).typeAndEnter(parameterNumber);
            waitABit(10000);

            // Check if the parameter is available
            if (isParameterAvailable(parameterNumber)) {
                handleParameterValues(parameterValues);
            } else {
                throw new Exception("Parameter " + parameterNumber + " is not available in the search results.");
            }

            Serenity.getDriver().switchTo().defaultContent().switchTo().frame(ReusableMethods.parentFrameForSecondTab);
            $(doneButton).click();
        } catch (Exception e) {
            System.err.println("Error in processing parameter: " + parameterNumber + ". Error message: " + e.getMessage());
            throw new Exception("Error in theParameterShouldBeFilledWithValueAndItsDataTypeShouldBe: " + e.getMessage(), e);
        }
    }

    private String getTheColumnDataIndex(String columnName) {
        String dataIndex = "";
        switch (columnName) {
            case "List":
            case "Free Text":
            case "Multi List":
                dataIndex = textFieldInSimpleSearch.getAttribute("data-index");
                break;
            case "Number":
                dataIndex = targetFieldInSimpleSearch.getAttribute("data-index");
                break;
            default:
                System.out.println("ColumnName is not found......");
        }
        return dataIndex;
    }

    private void handleParameterValues(String parameterValues) {
        String dataType = "";
        int textFieldPosition = 1;
        int targetFieldPosition = 2;

        if (parameterDataType.isCurrentlyVisible()) {
            dataType = parameterDataType.getAttribute("textContent").trim();
            if (dataType.equalsIgnoreCase("Number")) {
                targetFieldPosition = Integer.parseInt(getTheColumnDataIndex(dataType));
            } else {
                textFieldPosition = Integer.parseInt(getTheColumnDataIndex(dataType));
            }
        } else {
            System.out.println("data type is not visible");
        }

        switch (dataType) {
            case "Free Text":
                handleFreeText(textFieldPosition);
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
                throw new IllegalArgumentException("Invalid data type: " + dataType);
        }
    }


    private void handleFreeText(int noOfMoves) {
        $(parameterDataType).click();
        waitAndExecuteTabs(noOfMoves);
        waitABit(2000);
        $(Serenity.getDriver().switchTo().activeElement()).type("MN");
    }

    private void handleList(int noOfMoves) {
        $(parameterDataType).click();
        waitAndExecuteTabs(noOfMoves);
        waitABit(1000);
        reusableUtilities.pressDownNavigation();
        waitABit(1000);
        reusableUtilities.pressDownNavigation();
        waitABit(1000);
        reusableUtilities.pressDownNavigation();
        waitABit(1000);
        reusableUtilities.pressTab();
    }

    private void handleMultiList(int noOfMoves) {
        $(parameterDataType).click();
        waitAndExecuteTabs(noOfMoves);
        waitABit(2000);
        $(By.xpath("//span[text()='0 item(s) selected']/following-sibling::button")).click();
        waitABit(2000);
        List<WebElement> elements = Serenity.getDriver().findElements(By.xpath("//span[text()='0 item(s) selected']/following-sibling::div/ul/li/label/span"));
        List<WebElement> firstThreeElements = elements.stream().limit(3).collect(Collectors.toList());
        firstThreeElements.forEach(WebElement::click);
        reusableUtilities.pressTab();
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
            $(parameterDataType).click();
            waitABit(1000);

            waitAndExecuteTabsForMinMaxTargetColumns(noOfMoves);
            reusableUtilities.pressTab();
            waitABit(3000);

            String min = reusableUtilities.getTheInnerTextOfActiveElement();
            waitABit(1000);

            reusableUtilities.pressTab();
            waitABit(1000);
            String max = reusableUtilities.getTheInnerTextOfActiveElement();

            ItemCodeStore.storeTheData("min", min);
            ItemCodeStore.storeTheData("max", max);

            return min != null && max != null && !min.isEmpty() && !max.isEmpty();

        } catch (Exception e) {
            System.err.println("Error while checking Min/Max values: " + e.getMessage());
            return false;
        }
    }


    public void enterTheMinMaxTargetValues(String parameterValue, int noOfMoves) {
        $(parameterDataType).click();
        waitABit(1000);
        waitAndExecuteTabsForMinMaxTargetColumns(noOfMoves);
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
        $(parameterDataType).click();
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

    private void waitAndExecuteTabs(int times) {
        IntStream.range(0, times - 1).forEach(i -> {
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
