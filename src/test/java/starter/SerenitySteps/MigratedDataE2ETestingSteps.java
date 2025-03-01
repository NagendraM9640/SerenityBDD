package starter.SerenitySteps;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.Serenity;
import starter.PageObjectsPages.*;
import starter.PageObjectsPages.Develop.EcoPage;
import starter.PageObjectsPages.Develop.ItemCodeStore;
import starter.PageObjectsPages.Develop.PartPageDev;
import starter.Utility.ExcelUtilities;
import starter.Utility.ReusableMethods;

import java.io.IOException;
import java.util.*;
import java.util.stream.IntStream;

public class MigratedDataE2ETestingSteps {

    MigratedDataPVPage migratedDataPVPage = new MigratedDataPVPage();
    MigratedDataPartPages migratedDataPartPage = new MigratedDataPartPages();
    MigratedDataPartPage migratedDataPartPages = new MigratedDataPartPage();
    MigratedDataMSpecPage migratedDataMSpecPage = new MigratedDataMSpecPage();
    PartPageDev partPage = new PartPageDev();
    ReusableMethods reusableMethods = new ReusableMethods();
    EcoPage ecoPage = new EcoPage();
    ARAS_HomePage arasHomePage = new ARAS_HomePage();
    private final ExcelUtilities excelUtilities = new ExcelUtilities();
    List<String> productItemCodes = new ArrayList<>();
    String excelPath = "MigratedE2ESheet4.xlsx";
    String errorForPartsSheetName = "ErrorScreenshotsForParts";
    String errorForProductsSheetName = "ErrorScreenshotsForProducts";
    List<String> itemCodes = new ArrayList<>();

    @Step
    public String prepareItemCodeSearchCriteria() {
        StringBuilder formattedString = new StringBuilder();
        for (String code : itemCodes) {
            if (formattedString.length() > 0) {
                formattedString.append("|");
            }
            formattedString.append(code);
        }
        return formattedString.toString();
    }

    public void addAllTheMSpecBasedOnTheExcelFileAddItOneMCOAndReleaseIt() throws Exception {
        String plantName = "";
        List<mSpecMCOData> excelData = excelUtilities.readExcelDataFormSpecs(excelPath);
        Map<String, mSpecMCOData> mSpectDataMap = new HashMap<>();

        for (mSpecMCOData data : excelData) {
            plantName = data.getPlantCode();
            itemCodes.add(data.getmSpecItemCode());
            mSpectDataMap.put(data.getmSpecItemCode(), data);
        }

        System.out.println("ItemCodes from excel: " + itemCodes);
        String itemCodeSearchCriteria = prepareItemCodeSearchCriteria();
        System.out.println("ItemCode Search Criteria is: " + itemCodeSearchCriteria);

        migratedDataMSpecPage.createTheMCOWithRequiredDetails(plantName, "created by automation script", "Product maintenance", itemCodeSearchCriteria);

        String mcoNumber = migratedDataMSpecPage.addMspecsToTheMCO(itemCodeSearchCriteria);

        List<String> revisions = migratedDataMSpecPage.userFillEBomRevisionAndNewLifecycleFields(itemCodes);

        IntStream.range(0, itemCodes.size()).forEach(i -> {
            mSpecMCOData mSpecObj = mSpectDataMap.get(itemCodes.get(i));
            mSpecObj.seteBomRevision(revisions.get(i));
            try {
                excelUtilities.updateExcelDataFormSpecs(excelPath, mSpecObj);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        //migratedDataMSpecPage.searchMCOItemsFromSearchSection("MCO000000003193");

        partPage.userClicksOnTab("Signoffs");
        migratedDataMSpecPage.userShouldCompleteTheSignOffProcessOfMCO();

        itemCodes.forEach(itemCode -> {
            try {
                mSpecMCOData mSpecDataToUpdate = mSpectDataMap.get(itemCode);
                mSpecDataToUpdate.setMcoNumber(mcoNumber);
                //mSpecDataToUpdate.setMcoNumber("MCO000000003193");
                migratedDataMSpecPage.userOpensMspecFromAffectedItems(itemCode);
                //System.out.println("opened");
                migratedDataMSpecPage.validateTheLifeCycle("Released");
                //migratedDataMSpecPage.takeTheScreenshotsForMspecData(itemCode);
                String jsonID = migratedDataMSpecPage.getTheMspecID();
                System.out.println(jsonID);
                mSpecDataToUpdate.setJsonID(jsonID);
                System.out.println(mSpecDataToUpdate.getSerialNum() + "serialNum");
                excelUtilities.updateExcelDataFormSpecs(excelPath, mSpecDataToUpdate);
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException(e.getMessage());
            }
        });
    }

    @Step
    public void takescreenshots(String part) throws IOException {
        migratedDataPartPages.takeTheScreenshotsForPartsData(part);
    }

    @Step
    public void searchForAllPartsAndAddItOneECOAndReleaseIt() throws Exception {
        String itemCodeSearchCriteria = prepareItemCodeSearchCriteria();
        System.out.println("ItemCode Search Criteria is: " + itemCodeSearchCriteria);
        reusableMethods.searchItemByCodeForMassSearch(PartPageDev.searchItemCodeField, itemCodeSearchCriteria);
        migratedDataPartPage.rightClickAndClickOnAddToChange();
        reusableMethods.closeFirstOpenedTab();
        migratedDataPartPage.userFillAllMandatoryFieldsInECOAndClickOnSave("Migrated Part Released test for: " + itemCodeSearchCriteria, "created by automation script", "Commercial", "Product maintenance", "");
        migratedDataPartPage.updateTargetLifeCycleForMassParts("", "Released");
        System.out.println("ECO Number is: " + migratedDataPartPage.getECONumber());
        partPage.userClicksOnTab("Assignments");
        migratedDataPartPage.userShouldSelectTheOwnerApprovalCheckbox();
        partPage.userClicksOnTab("SignOffs");
        migratedDataPartPage.userShouldCompleteTheSignOffProcessOfECO(itemCodes);
    }

    public void searchForAllThePartsBasedOnTheExcelFileAddItOneECOAndReleaseIt() throws Exception {
        List<PartData> excelData = excelUtilities.readExcelDataForPartSaveAs(excelPath);
        Map<String, PartData> partDataMap = new HashMap<>();
        for (PartData data : excelData) {
            itemCodes.add(data.getItemCode());
            partDataMap.put(data.getItemCode(), data);
        }
        System.out.println("ItemCodes from excel: " + itemCodes);
        String itemCodeSearchCriteria = prepareItemCodeSearchCriteria();
        System.out.println("ItemCode Search Criteria is: " + itemCodeSearchCriteria);

        //reusableMethods.searchItemByCodeForMassSearch(PartPageDev.searchItemCodeField, itemCodeSearchCriteria);
        // migratedDataPartPage.rightClickAndClickOnAddToChange();
        //reusableMethods.closeFirstOpenedTab();

        reusableMethods.waitUntilArasSpinnerToDisappear();

        migratedDataPartPage.userFillAllMandatoryFieldsInECOAndClickOnSave("Migrated Part Released test - Integration Testing", "created by automation script", "Commercial", "New Product", "");

        migratedDataPartPage.addAllThePartsInECOAffectedItemTab(itemCodeSearchCriteria);

        migratedDataPartPage.maximizeAndRestoreThePage("Maximize");

        migratedDataPartPage.searchMultipleItemNumbersAndUpdateTheTargetLifeCycle(itemCodes, "Released");

        migratedDataPartPage.clicksOnDone();

        migratedDataPartPage.maximizeAndRestoreThePage("Restore");

        String ecoNumber = migratedDataPartPage.getECONumber();
        System.out.println("ECO Number is: " + ecoNumber);

        partPage.userClicksOnTab("Assignments");
        migratedDataPartPage.userShouldSelectTheOwnerApprovalCheckbox();

        partPage.userClicksOnTab("SignOffs");
        migratedDataPartPage.userShouldCompleteTheSignOffProcessOfECO(itemCodes);

        partPage.userClicksOnTab("Integration Results");
        HashMap<String, String> responses = migratedDataPartPages.massPartsFetchIntegrationResults(itemCodes);

        for (String key : responses.keySet()) {
            System.out.println("Key: " + key + " Value: " + responses.get(key));
            PartData partDataToUpdate = partDataMap.get(key);
            partDataToUpdate.setIntegrationResponse(responses.get(key));
            excelUtilities.updateExcelDataPartSaveAs(excelPath, partDataToUpdate);
        }

        partPage.userClicksOnTab("Affected Items");
        itemCodes.forEach(itemCode -> {
            try {
                PartData partDataToUpdate = partDataMap.get(itemCode);
                partDataToUpdate.setEcoItemCode(ecoNumber);
                boolean isPresent = migratedDataPartPage.userOpensPartFromAffectedItems(itemCode);
                if (isPresent) {
                    migratedDataPartPage.validateTheLifeCycle("Released");
                    //migratedDataPartPage.takeTheScreenshotsForPartsData(itemCode);
                    String jsonID = migratedDataPartPage.getThePartID();
                    System.out.println(jsonID);
                    partDataToUpdate.setJsonID(jsonID);
                    System.out.println(partDataToUpdate.getSerialNum() + "serialNum");
                } else {
                    partDataToUpdate.setJsonID("Part Not Available.....");
                }
                excelUtilities.updateExcelDataPartSaveAs(excelPath, partDataToUpdate);
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException(e.getMessage());
            }
        });
    }

    @Step
    public void re_RunTheECOProcess(String ecoNumber) throws Exception {
        List<PartData> excelData = excelUtilities.readExcelDataForPartSaveAs(excelPath);
        Map<String, PartData> partDataMap = new HashMap<>();
        for (PartData data : excelData) {
            itemCodes.add(data.getItemCode());
            partDataMap.put(data.getItemCode(), data);
        }
        try {
            ecoPage.searchECOItemsFromSearchSection(ecoNumber);

            migratedDataPartPage.maximizeAndRestoreThePage("Maximize");

//            migratedDataPartPage.searchMultipleItemNumbersAndUpdateTheTargetLifeCycle(itemCodes,"Released");
//
//            partPage.userClicksOnTab("SignOffs");
//            migratedDataPartPage.userShouldCompleteTheSignOffProcessOfECO(itemCodes);
//
//            partPage.userClicksOnTab("Integration Results");
//            HashMap<String, String> responses = migratedDataPartPages.massPartsFetchIntegrationResults(itemCodes);
//
//
//            for (String key : responses.keySet()) {
//                System.out.println("Key: " + key + " Value: " + responses.get(key));
//                PartData partDataToUpdate = partDataMap.get(key);
//                partDataToUpdate.setIntegrationResponse(responses.get(key));
//                excelUtilities.updateExcelDataPartSaveAs(excelPath, partDataToUpdate);
//            }

            itemCodes.forEach(itemCode -> {
                try {
                    PartData partDataToUpdate = partDataMap.get(itemCode);
                    partDataToUpdate.setEcoItemCode(ecoNumber);
                    boolean isPresent = migratedDataPartPage.userOpensPartFromAffectedItems(itemCode);
                    if (isPresent) {
                        migratedDataPartPage.validateTheLifeCycle("Released");
                        //migratedDataPartPage.takeTheScreenshotsForPartsData(itemCode);
                        String jsonID = migratedDataPartPage.getThePartID();
                        System.out.println(jsonID);
                        partDataToUpdate.setJsonID(jsonID);
                        System.out.println(partDataToUpdate.getSerialNum() + "serialNum");
                    } else {
                        partDataToUpdate.setJsonID("Part Not Available.....");
                    }
                    excelUtilities.updateExcelDataPartSaveAs(excelPath, partDataToUpdate);
                } catch (Exception e) {
                    e.printStackTrace();
                    throw new RuntimeException(e.getMessage());
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Step
    public void massPartsReleased() throws Exception {
        List<PartData> excelData = excelUtilities.readExcelDataForParts(excelPath);

        for (PartData data : excelData) {
            try {
                // Search and open migrated part
                migratedDataPartPage.searchAndOpenMigratedPart(data.getItemType(), data.getSubfamily(), data.getProductGroup());

                // Retrieve Part Item code
                String itemCode = migratedDataPartPage.getItemCode();
                data.setItemCode(itemCode);

                itemCodes.add(itemCode);

                // Update Excel with product data
                excelUtilities.updateExcelData(excelPath, data);

                // Refresh and navigate back to the search page
                migratedDataPartPage.refreshThePageAndNavigatePartSearchPage();

            } catch (Exception e) {
                // Handle exception and log details
                data.setErrorMsg(e.getMessage());
                Serenity.takeScreenshot();
                // Capture and insert screenshot into Excel
                ExcelUtilities.captureScreenshot(data.getItemType() + "_" + data.getSubfamily() + "_error");
                // excelUtilities.insertScreenshot(excelPath, errorForPartsSheetName, data.getRowNumber(), screenshotPath);

                if (migratedDataPartPage.isErrorMessageDisplayed()) {
                    String errorMessage = migratedDataPartPage.getErrorMessageText();
                    data.setErrorMsg(errorMessage);
                    excelUtilities.updateExcelData(excelPath, data);
                }

                // Update Excel with error details
                excelUtilities.updateExcelData(excelPath, data);

                // Refresh and navigate back to the search page
                migratedDataPartPage.refreshThePageAndNavigatePartSearchPage();

                // Log stack trace for debugging
                e.printStackTrace();
            }
        }
    }

    @Step
    public void userSearchesForMigratePartsAndReleaseIt() throws Exception {
        List<PartData> excelData = excelUtilities.readExcelDataForPartSaveAs(excelPath);

        for (PartData data : excelData) {
            try {
                //ItemCodeStore.storeTheData("PTEMPCode", data.getpTempCode());
                // Search and open migrated part
                //migratedDataPartPage.searchAndOpenMigratedPart(data.getItemType(), data.getSubfamily(), data.getProductGroup());
                migratedDataPartPage.searchAndOpenMigratedParts(data.getItemCode());

                // Retrieve Part Item code
                //data.setItemCode(migratedDataPartPage.getItemCode());
                data.setSubfamily(ItemCodeStore.getStoredData("subFamilyText"));
                data.setProductGroup(ItemCodeStore.getStoredData("productGroupText"));

                ItemCodeStore.storeTheData("PartCode", migratedDataPartPage.getItemCode());

                //ExcelUtilities.captureScreenshotForPartsData(data.getItemType() + "_" + data.getItemCode(),"MigratedPart");

                // Add item to change and close the first tab
                partPage.userClicksOnAddItemSToChange();
                reusableMethods.closeFirstOpenedTab();

                // Fill mandatory fields in ECO and save
                migratedDataPartPage.userFillAllMandatoryFieldsInECOAndClickOnSave("Migrated Part Released test for: " + data.getItemCode(), "created by automation script", "Commercial", "Product maintenance", data.getProductGroup());

                // Set target lifecycle and retrieve ECO number
                partPage.userClicksOnTab("Affected Items");
                migratedDataPartPage.userSelectsTargetLifecycle(data.getItemType(), "Released");
                data.setEcoItemCode(migratedDataPartPage.getECONumber());
                ItemCodeStore.storeTheData("ecoNum", data.getEcoItemCode());

                //Capture the screenshot after the ECO creation
                //ExcelUtilities.captureScreenshotForPartsData(data.getItemType() + "_" + data.getItemCode(),"ECO");

                // Complete assignments and sign-offs
                partPage.userClicksOnTab("Assignments");
                migratedDataPartPage.userShouldSelectTheOwnerApprovalCheckbox();


                partPage.userClicksOnTab("SignOffs");
                migratedDataPartPage.userShouldCompleteTheSignOffProcessOfECO(itemCodes);

                data.setpTempCode(ItemCodeStore.getStoredData("PTEMPCode"));

                // Fetch and set integration results
                partPage.userClicksOnTab("Integration Results");
                data.setIntegrationResponse(migratedDataPartPage.fetchIntegrationResults());

                //Capture the screenshot for the Integration Results tab
                ExcelUtilities.captureScreenshotForPartsData(data.getItemType() + "_" + data.getItemCode(), "Integration_Results");

                // Validate lifecycle and retrieve JSON ID
                ecoPage.userOpensPartFromAffectedItems(data.getItemCode());
                migratedDataPartPage.validateTheLifeCycle("Released");
                data.setJsonID(migratedDataPartPage.getThePartID());

                //Capture the screenshot for Parts BOM,Parameters,Vendors tab data
                migratedDataPartPage.takeTheScreenshotsForPartsData(data.getItemType() + "_" + data.getItemCode());

                // Refresh and navigate back to the search page
                migratedDataPartPage.refreshThePageAndNavigatePartSearchPage();

                // Update Excel with product data
                excelUtilities.updateExcelDataPartSaveAs(excelPath, data);

            } catch (Exception e) {
                // Handle exception and log details
                data.setErrorMsg(e.getMessage());

                // Capture and insert screenshot into Folder
                ExcelUtilities.captureErrorScreenshotForPartsData(data.getItemType() + "_" + data.getItemCode(), data.getItemType() + "_" + data.getItemCode() + "_error");

                //ExcelUtilities.captureScreenshot(data.getItemType() + "_" + data.getSubfamily() + "_error");
                // excelUtilities.insertScreenshot(excelPath, errorForPartsSheetName, data.getRowNumber(), screenshotPath);

                if (migratedDataPartPage.isErrorMessageDisplayed()) {
                    String errorMessage = migratedDataPartPage.getErrorMessageText();
                    data.setErrorMsg(errorMessage);
                    data.setpTempCode(ItemCodeStore.getStoredData("PTEMPCode"));
                    excelUtilities.updateExcelDataPartSaveAs(excelPath, data);
                }

                data.setpTempCode(ItemCodeStore.getStoredData("PTEMPCode"));

                // Update Excel with error details
                excelUtilities.updateExcelDataPartSaveAs(excelPath, data);

                // Refresh and navigate back to the search page
                migratedDataPartPage.refreshThePageAndNavigatePartSearchPage();

                // Log stack trace for debugging
                e.printStackTrace();
            }
        }
    }

    @Step
    public void userSearchesForMigratePartsAndPerformSaveAsAndReleaseIt() throws Exception {
        List<PartData> excelData = excelUtilities.readExcelDataForPartSaveAs(excelPath);

        for (PartData data : excelData) {
            try {
                //ItemCodeStore.storeTheData("PTEMPCode", data.getpTempCode());
                // Search and open migrated part
                //migratedDataPartPage.searchAndOpenMigratedPart(data.getItemType(), data.getSubfamily(), data.getProductGroup());
                migratedDataPartPage.searchAndOpenMigratedParts(data.getItemCode());

                // Perform Save As functionality
                migratedDataPartPage.performSaveAs();

                // Retrieve Part Item code
                data.setItemCode(migratedDataPartPage.getItemCode());
                data.setSubfamily(ItemCodeStore.getStoredData("subFamilyText"));
                data.setProductGroup(ItemCodeStore.getStoredData("productGroupText"));

                ItemCodeStore.storeTheData("PartCode", migratedDataPartPage.getItemCode());

                //ExcelUtilities.captureScreenshotForPartsData(data.getItemType() + "_" + data.getItemCode(),"MigratedPart");

                // Add item to change and close the first tab
                partPage.userClicksOnAddItemSToChange();
                reusableMethods.closeFirstOpenedTab();

                // Fill mandatory fields in ECO and save
                migratedDataPartPage.userFillAllMandatoryFieldsInECOAndClickOnSave("Migrated Part Released test for: " + data.getItemCode(), "created by automation script", "Commercial", "Product maintenance", data.getProductGroup());

                // Set target lifecycle and retrieve ECO number
                partPage.userClicksOnTab("Affected Items");
                migratedDataPartPage.userSelectsTargetLifecycle(data.getItemType(), "Released");
                data.setEcoItemCode(migratedDataPartPage.getECONumber());
                ItemCodeStore.storeTheData("ecoNum", data.getEcoItemCode());

                //Capture the screenshot after the ECO creation
                //ExcelUtilities.captureScreenshotForPartsData(data.getItemType() + "_" + data.getItemCode(),"ECO");

                // Complete assignments and sign-offs
                partPage.userClicksOnTab("Assignments");
                migratedDataPartPage.userShouldSelectTheOwnerApprovalCheckbox();


                partPage.userClicksOnTab("SignOffs");
                migratedDataPartPage.userShouldCompleteTheSignOffProcessOfECO(itemCodes);

                data.setpTempCode(ItemCodeStore.getStoredData("PTEMPCode"));

                // Fetch and set integration results
                partPage.userClicksOnTab("Integration Results");
                data.setIntegrationResponse(migratedDataPartPage.fetchIntegrationResults());

                //Capture the screenshot for the Integration Results tab
                ExcelUtilities.captureScreenshotForPartsData(data.getItemType() + "_" + data.getItemCode(), "Integration_Results");

                // Validate lifecycle and retrieve JSON ID
                ecoPage.userOpensPartFromAffectedItems(data.getItemCode());
                migratedDataPartPage.validateTheLifeCycle("Released");
                data.setJsonID(migratedDataPartPage.getThePartID());

                //Capture the screenshot for Parts BOM,Parameters,Vendors tab data
                migratedDataPartPage.takeTheScreenshotsForPartsData(data.getItemType() + "_" + data.getItemCode());

                // Refresh and navigate back to the search page
                migratedDataPartPage.refreshThePageAndNavigatePartSearchPage();

                // Update Excel with product data
                excelUtilities.updateExcelDataPartSaveAs(excelPath, data);

            } catch (Exception e) {
                // Handle exception and log details
                data.setErrorMsg(e.getMessage());

                // Capture and insert screenshot into Folder
                ExcelUtilities.captureErrorScreenshotForPartsData(data.getItemType() + "_" + data.getItemCode(), data.getItemType() + "_" + data.getItemCode() + "_error");

                //ExcelUtilities.captureScreenshot(data.getItemType() + "_" + data.getSubfamily() + "_error");
                // excelUtilities.insertScreenshot(excelPath, errorForPartsSheetName, data.getRowNumber(), screenshotPath);

                if (migratedDataPartPage.isErrorMessageDisplayed()) {
                    String errorMessage = migratedDataPartPage.getErrorMessageText();
                    data.setErrorMsg(errorMessage);
                    data.setpTempCode(ItemCodeStore.getStoredData("PTEMPCode"));
                    excelUtilities.updateExcelDataPartSaveAs(excelPath, data);
                }

                data.setpTempCode(ItemCodeStore.getStoredData("PTEMPCode"));

                // Update Excel with error details
                excelUtilities.updateExcelDataPartSaveAs(excelPath, data);

                // Refresh and navigate back to the search page
                migratedDataPartPage.refreshThePageAndNavigatePartSearchPage();

                // Log stack trace for debugging
                e.printStackTrace();
            }
        }
    }

    @Step
    public void changeLifecycleForMigratedPartItemsFromReleasedToObsolete() throws Exception {
        List<PartData> excelData = excelUtilities.readExcelDataForParts(excelPath);

        for (PartData data : excelData) {
            try {
                ItemCodeStore.storeTheData("PTEMPCode", data.getpTempCode());

                // Search and open migrated part
                migratedDataPartPage.searchAndOpenMigratedPart(data.getItemType(), data.getSubfamily(), data.getProductGroup());

                // Retrieve Part Item code
                data.setItemCode(migratedDataPartPage.getItemCode());
                ItemCodeStore.storeTheData("PartCode", migratedDataPartPage.getItemCode());

                ExcelUtilities.captureScreenshotForPartsData(data.getItemType() + "_" + data.getItemCode(), "MigratedPart");

                // Add item to change and close the first tab
                partPage.userClicksOnAddItemSToChange();
                reusableMethods.closeFirstOpenedTab();

                // Fill mandatory fields in ECO and save
                migratedDataPartPage.userFillAllMandatoryFieldsInECOAndClickOnSave("Migrated Part Released test for: " + data.getItemCode(), "created by automation script", "Commercial", "Product maintenance", data.getProductGroup());

                // Set target lifecycle and retrieve ECO number
                partPage.userClicksOnTab("Affected Items");
                migratedDataPartPage.userSelectsTargetLifecycle(data.getItemType(), "Obsolete");
                data.setEcoItemCode(migratedDataPartPage.getECONumber());
                ItemCodeStore.storeTheData("ecoNum", data.getEcoItemCode());

                //Capture the screenshot after the ECO creation
                ExcelUtilities.captureScreenshotForPartsData(data.getItemType() + "_" + data.getItemCode(), "ECO");

                // Complete assignments and sign-offs
                partPage.userClicksOnTab("Assignments");
                migratedDataPartPage.userShouldSelectTheOwnerApprovalCheckbox();


                partPage.userClicksOnTab("SignOffs");
                migratedDataPartPage.userShouldCompleteTheSignOffProcessOfECO(itemCodes);

                // Fetch and set integration results
                partPage.userClicksOnTab("Integration Results");
                data.setIntegrationResponse(migratedDataPartPage.fetchIntegrationResults());

                //Capture the screenshot for the Integration Results tab
                ExcelUtilities.captureScreenshotForPartsData(data.getItemType() + "_" + data.getItemCode(), "Integration_Results");

                // Validate lifecycle and retrieve JSON ID
                ecoPage.userOpensPartFromAffectedItems(data.getItemCode());
                migratedDataPartPage.validateTheLifeCycle("Obsolete");
                data.setJsonID(migratedDataPartPage.getThePartID());

                //Capture the screenshot for Parts BOM,Parameters,Vendors tab data
                migratedDataPartPage.takeTheScreenshotsForPartsData(data.getItemType() + "_" + data.getItemCode());

                // Refresh and navigate back to the search page
                migratedDataPartPage.refreshThePageAndNavigatePartSearchPage();

                // Update Excel with product data
                excelUtilities.updateExcelData(excelPath, data);

            } catch (Exception e) {
                // Handle exception and log details
                data.setErrorMsg(e.getMessage());

                // Capture and insert screenshot into Folder
                ExcelUtilities.captureErrorScreenshotForPartsData(data.getItemType() + "_" + data.getItemCode(), data.getItemType() + "_" + data.getItemCode() + "_error");

                //ExcelUtilities.captureScreenshot(data.getItemType() + "_" + data.getSubfamily() + "_error");
                // excelUtilities.insertScreenshot(excelPath, errorForPartsSheetName, data.getRowNumber(), screenshotPath);

                if (migratedDataPartPage.isErrorMessageDisplayed()) {
                    String errorMessage = migratedDataPartPage.getErrorMessageText();
                    data.setErrorMsg(errorMessage);
                    excelUtilities.updateExcelData(excelPath, data);
                }

                // Update Excel with error details
                excelUtilities.updateExcelData(excelPath, data);

                // Refresh and navigate back to the search page
                migratedDataPartPage.refreshThePageAndNavigatePartSearchPage();

                // Log stack trace for debugging
                e.printStackTrace();
            }
        }
    }


    @Step
    public void userSearchesForMigratedPVAndReleaseIts() throws Exception {
        //arasHomePage.navigating("Product Portfolio and Project Management/Product ECOs/Search Product ECOs");
        //migratedDataPVPage.searchForPECOItems("PECO-00001233");
        ecoPage.searchECOItemsFromSearchSection("ECO-00003096");
        partPage.userClicksOnTab("SignOffs");
        migratedDataPartPage.userShouldCompleteTheSignOffProcessOfECO(itemCodes);
    }


    @Step
    public void userSearchesForMigratedPVAndReleaseIt() throws Exception {
        List<PVSPGPData> excelData = excelUtilities.readExcelDataForProducts(excelPath);

        for (PVSPGPData data : excelData) {
            try {
                // Retrieve and store item codes
                productItemCodes = migratedDataPVPage.retrieveAndStoreItemCodes(data.getProductType(), data.getProductCategory());

                System.out.println(productItemCodes);

                // Map retrieved item codes to product data
                data.setProductVariantIdentifier(productItemCodes.get(0));
                data.setSellableProductIdentifier(productItemCodes.get(1));
                data.setGlobalProductIdentifier(productItemCodes.get(2));

                // Refresh the page
                migratedDataPVPage.refreshThePage();

                // Navigate and fill the product ECO details
                arasHomePage.navigating("Product Portfolio and Project Management/Product ECOs/Create New Product ECO");
                migratedDataPVPage.userFillsDataInProductECO("Migrated PV GP SP Released test for: " + productItemCodes.get(0) + " " + productItemCodes.get(1) + " " + productItemCodes.get(2), "created by automation script", "Lifecycle Change", "Product maintenance");

                // Add the item codes to affected items
                migratedDataPVPage.addPVSPGPInAffectedItems(productItemCodes);

                // Fetch PECO number and store in the Obj
                data.setPecoNumber(migratedDataPVPage.fetchPECONumber());

                // Set lifecycle status to released
                migratedDataPVPage.setsNewLifecycleOfPVSPGPIsReleased();

//                arasHomePage.navigating("Product Portfolio and Project Management/Product ECOs/Search Product ECOs");
                //migratedDataPVPage.searchForPECOItems(data.getPecoNumber());

                // Complete the sign-off process
                partPage.userClicksOnTab("Signoffs");
                migratedDataPVPage.completeTheSignOffProcessForPECO();

                // Fetch and set integration results
                partPage.userClicksOnTab("Integration Results");
                List<String> integrationResponses = migratedDataPVPage.fetchIntegrationResults();
                data.setPvIntegrationResponse(integrationResponses.get(0));
                data.setSpIntegrationResponse(integrationResponses.get(1));
                data.setGpIntegrationResponse(integrationResponses.get(2));

                // Validate and copy JSON IDs
                partPage.userClicksOnTab("Affected Items");
                List<String> jsonIds = migratedDataPVPage.userOpensAndValidatesAddedProductsAndCopyJSONID("Released");
                data.setPvJsonId(jsonIds.get(0));
                data.setSpJsonId(jsonIds.get(1));
                data.setGpJsonId(jsonIds.get(2));

                // Update Excel with product data
                excelUtilities.updateExcelDataForProducts(excelPath, data.getSerialNumber(), data);

                // Refresh and navigate to search page
                migratedDataPVPage.refreshThePageAndNavigateSearchProductVariantsPage();

                //Clear the product codes from the list
                productItemCodes.clear();

            } catch (Exception e) {


                //Clear the product codes from the list
                productItemCodes.clear();

                // Handle exception and log details
                data.setErrorMessage(e.getMessage());
                ExcelUtilities.captureScreenshot(data.getSerialNumber() + "_error");

                // Insert screenshot and error details into Excel
                //int row = excelUtilities.getRowNumberBySerialNum(data.getSerialNumber());
                //excelUtilities.insertScreenshot(excelPath, errorForProductsSheetName, row, screenshotPath);

                if (migratedDataPartPage.isErrorMessageDisplayed()) {
                    String errorMessage = migratedDataPartPage.getErrorMessageText();
                    data.setErrorMessage(errorMessage);
                }

                // Update Excel with error details
                excelUtilities.updateExcelDataForProducts(excelPath, data.getSerialNumber(), data);

                // Refresh and navigate back to productVariants page search page
                migratedDataPVPage.refreshThePageAndNavigateSearchProductVariantsPage();

                // Log the stack trace
                e.printStackTrace();
            }
        }
    }
}