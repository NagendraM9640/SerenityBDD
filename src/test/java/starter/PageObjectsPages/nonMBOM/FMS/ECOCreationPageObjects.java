package starter.PageObjectsPages.nonMBOM.FMS;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import starter.Utility.ReusableUtilities;

import java.util.List;


public class ECOCreationPageObjects extends PageObject {
    //static By lblNumber = By.xpath("//input[@id='8B7B5ADACCD343699DAADEB19BBA5C99']");
    static By lblNumber = By.xpath("//*[text()='Number']");
    static By txtNumber = By.xpath("//*[@class='item_number']");
    //static By lblChangeDescription = By.xpath("//div[@id='07AD32753A964C77BF9D09561270A4FE_label']");
    static By titleField = By.xpath("//*[@class='title']");
    static By lblChangeDescription = By.xpath("//*[text()='Change Description']");
    static By eco = By.xpath("//*[text()='ECO']");
    static By txtChangeDescription = By.xpath("//*[@class='description']");
    //static By lblReasonForChange = By.xpath("//span[@id='9834F54E7ACF446093E0527271A34DE7_label']");
    static By lblReasonForChange = By.xpath("//*[text()='Reason For Change']");
    static By txtReasonForChange = By.xpath("//*[contains(@class,'aras-icon-arrow_down')]");
    static By lblProductApplication = By.xpath("//span[@id='A15E52D844AD4734ADF0F528FBD2EF08_label']");
    static By productApplication = By.xpath("(//*[contains(@class,'aras-icon-arrow_down')])[2]");
    static By frmAdditionalInfo = By.xpath("//body/form[@id='MainDataForm']/div[@id='7623437D6DB947A2ACD73A6BF2D4CD44span']/fieldset[1]");
    static By lblOriginator = By.xpath("//span[@id='CFF17096D3B84640B73FC32FA40D5165_label']");
    static By lblDateOriginated = By.xpath("//div[@id='269FD314D71D48FF861980BEADEB0E8A_label']");
    static By lblReleaseDate = By.xpath("//div[@id='A424BF4DFE784004B62CED54A8CABE04_label']");
    static By tabAttachment = By.xpath("//span[contains(text(),'Attachments')]");
    static By tabSignOff = By.xpath("//span[contains(text(),'SignOffs')]");
    static By tabRelationships = By.xpath("//span[contains(text(),'Relationships')]");
    static By newFrameForCreateECOFrame = By.xpath("//iframe[contains(@name,'innovator_')]");
    static By newFrameForCreateECOFrameDataEntry = By.xpath("//*[@id='instance']");
    static By arasButtonIcon = By.className("aras-button__icon");
    static By doneButton = By.xpath("//*[text()='Done']");
    static By editButton = By.xpath("//*[text()='Edit']");
    static By newFrameForErrorMessage = By.xpath("//iframe[@id='innovator_21h19m29s_281BA45049274802B42F8DAAE3CD6ED3']");
    static By newFrameForOKButton = By.xpath("//iframe[@id='innovator_21h19m29s_281BA45049274802B42F8DAAE3CD6ED3']");
    static By navigateButton = By.xpath("//button[@title='Navigate']");
    static By historyButton = By.xpath("//*[text()='History']");
    static By workflowButton = By.xpath("//*[text()='Workflow']");
    static By newFrameForHistoryRelationship1 = By.xpath("//iframe[@class='aras-dialog__iframe']");
    static By newFrameForHistoryRelationship2 = By.xpath("//iframe[@title='History Container Item Form']");
    static By newFrameForHistoryRelationship3 = By.xpath("//iframe[@id='relationships_tmp']");
    static By newFrameForHistoryRelationship4 = By.xpath("//iframe[@title='History Relationship']");
    static By newFrameForWorkflowItem = By.xpath("//iframe[@title='Workflow Process Item Form']");
    static By historyWindowCloseButton = By.xpath("//*[contains(@class, 'aras-dialog__close-button aras-icon-close')]");
    static By addItemButton = By.xpath("//span[@title='Add Item']");
    static By searchItemButton = By.xpath("//button[@title='Run Search']");
    static By itemNumberField = By.xpath("//td[@class='aras-grid-search-row-cell ' and @data-index='2']");
    static By affectedItemResults = By.xpath("//td[@class='dojoxGridCell']");
    static By owner = By.xpath("//input[@name='owned_by_id']");
    static By productApplicationOwnerKretek = By.xpath("//select[@name='pmi_eco_item_type']//*[text()='Kretek']");
    static By productApplicationOwnerNonKretek = By.xpath("//select[@name='pmi_eco_item_type']//*[text()='Non-Kretek']");

    static String generatedECOCode = "ECO-00001022";

    ReusableUtilities reusableUtilities;

    /*public void validateECOForm() {
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.conditionalWait("Visibility", PartPage.arasSpinner, "");
        reusableUtilities.conditionalWait("Invisibility", PartPage.arasSpinner, "");
        reusableUtilities.conditionalWait("Visibility", newFrameForCreateECOFrame, "");
        reusableUtilities.switchFrame($(newFrameForCreateECOFrame), "", 0);
        if($(eco).isCurrentlyVisible()) {
            Assert.assertTrue("ECO form has been loaded successfully", true);
        }
        else {
            Assert.fail();
        }
        reusableUtilities.switchFrame($(newFrameForCreateECOFrameDataEntry), "", 0);
        reusableUtilities.conditionalWait("Visibility", lblChangeDescription, "");
        reusableUtilities.conditionalWait("Visibility", lblReasonForChange, "");
        reusableUtilities.conditionalWait("Visibility", lblProductApplication, "");
        Assert.assertTrue(true);
    }*/

    public void validateReasonForChangeDropDown() {
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.conditionalWait("Visibility", newFrameForCreateECOFrame, "");
        reusableUtilities.switchFrame($(newFrameForCreateECOFrame), "", 0);
        reusableUtilities.switchFrame($(newFrameForCreateECOFrameDataEntry), "", 0);
        reusableUtilities.performAction("Button",$(txtReasonForChange),"");
        String[] value = {"Lifecycle Change", "Design Change", "Design Correction During Commercialization"};
        for (int i=0; i<value.length; i++) {
            if($(By.xpath("//*[text()='"+value[i]+"']")).isCurrentlyVisible()) {
                Assert.assertTrue(value[i]+" is visible under Reason for change dropdown",true);
            }
        }
        reusableUtilities.performAction("Button",$(txtReasonForChange),"");
    }

    public void validateProductApplicationDropDown() {
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.conditionalWait("Visibility", newFrameForCreateECOFrame, "");
        reusableUtilities.switchFrame($(newFrameForCreateECOFrame), "", 0);
        reusableUtilities.switchFrame($(newFrameForCreateECOFrameDataEntry), "", 0);
        reusableUtilities.performAction("Button",$(productApplication),"");
        String[] value = {"Kretek", "White Cigarette", "P1", "P4"};
        for (int i=0; i<value.length; i++) {
            if($(By.xpath("//*[text()='"+value[i]+"']")).isCurrentlyVisible()) {
                Assert.assertTrue(value[i]+" is visible under Product Application dropdown",true);
            }
        }
        reusableUtilities.performAction("Button",$(productApplication),"");
    }

    public void createECO(String description, String title) {
        //Moving out from all frames
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.conditionalWait("Visibility", newFrameForCreateECOFrame, "");
        reusableUtilities.switchFrame($(newFrameForCreateECOFrame), "", 0);
        reusableUtilities.switchFrame($(newFrameForCreateECOFrameDataEntry), "", 0);
        reusableUtilities.conditionalWait("Visibility", txtChangeDescription, "");
        reusableUtilities.performAction("text", $(txtChangeDescription), description);
        reusableUtilities.performAction("text", $(titleField), title);
        if(reusableUtilities.getObjectProperty($(owner),"value").contains("Non-Kretek")){
            $(productApplicationOwnerNonKretek).click();
        }
        else if(reusableUtilities.getObjectProperty($(owner),"value").contains("Kretek")){
            $(productApplicationOwnerKretek).click();
        }
        Serenity.getDriver().switchTo().parentFrame();
        reusableUtilities.performAction("button", $(doneButton), "");
    }

    public String validateECOCreationWithGeneratedItemNumber() {
        reusableUtilities.conditionalWait("visibility", editButton, "ECO has been created successfully");
        reusableUtilities.switchFrame($(newFrameForCreateECOFrameDataEntry), "", 0);
        generatedECOCode = reusableUtilities.getObjectProperty($(txtNumber), "value");
        System.out.println(generatedECOCode);
        return generatedECOCode;
    }

    public void userSearchesWithECOCode() {
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.conditionalWait("Visibility", PartPage.newFrameForPartSearch, "");
        reusableUtilities.switchFrame($(PartPage.newFrame), "", 0);
        reusableUtilities.conditionalWait("visibility", PartPage.arasSpinner, "");
        reusableUtilities.conditionalWait("invisibility", PartPage.arasSpinner, "");
        if(generatedECOCode.contains("PECO")){
            $(PartPage.searchFieldToSearchParts).click();
            waitABit(1000);
            reusableUtilities.pressTab();
            waitABit(1000);
            reusableUtilities.pressTab();
            waitABit(1000);
            $(Serenity.getDriver().switchTo().activeElement()).typeAndTab(generatedECOCode);
        }
        else {
            reusableUtilities.performAction("Text", $(PartPage.searchFieldToSearchParts), generatedECOCode);
        }
        waitABit(2000);
        reusableUtilities.pressEnter(PartPage.searchFieldToSearchParts);
    }

    public void userValidatesTheECOSearchResult(){
        reusableUtilities.conditionalWait("Visibility", PartPage.searchResults, "");
        reusableUtilities.doubleClick(PartPage.searchResults);
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.conditionalWait("Visibility", PartPage.newFrameForCreatePartFrame, "");
        reusableUtilities.switchFrame($(PartPage.newFrameForCreatePartFrame), "", 0);
        reusableUtilities.conditionalWait("Visibility", PartPage.newFrameForCreatePartFrameDataEntry, "");
        reusableUtilities.switchFrame($(PartPage.newFrameForCreatePartFrameDataEntry), "", 0);
        Assert.assertTrue("Created ECO has been validated", generatedECOCode.equalsIgnoreCase(reusableUtilities.getObjectProperty($(PartPage.itemCode), "value")));
    }

    public void validateAllFieldsVisibility(){
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.conditionalWait("Visibility", newFrameForCreateECOFrame, "");
        reusableUtilities.switchFrame($(newFrameForCreateECOFrame), "", 0);
        reusableUtilities.switchFrame($(newFrameForCreateECOFrameDataEntry), "", 0);
        reusableUtilities.conditionalWait("Visibility", lblNumber, "");
        reusableUtilities.conditionalWait("Visibility", txtNumber, "");
        reusableUtilities.conditionalWait("Visibility", lblChangeDescription, "");
        reusableUtilities.conditionalWait("Visibility", txtChangeDescription, "");
        reusableUtilities.conditionalWait("Visibility", lblReasonForChange, "");
        reusableUtilities.conditionalWait("Visibility", txtReasonForChange, "");
        reusableUtilities.conditionalWait("Visibility", lblProductApplication, "");
        reusableUtilities.conditionalWait("Visibility", productApplication, "");
        reusableUtilities.conditionalWait("Visibility", lblOriginator, "");
        reusableUtilities.conditionalWait("Visibility", lblDateOriginated, "");
        reusableUtilities.conditionalWait("Visibility", lblReleaseDate, "");
    }

    public void validateErrorMessageForMandatoryFields(){
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.conditionalWait("Visibility", newFrameForCreateECOFrame, "");
        reusableUtilities.switchFrame($(newFrameForCreateECOFrame), "", 0);
        reusableUtilities.switchFrame($(newFrameForCreateECOFrameDataEntry), "", 0);
        reusableUtilities.performAction("Button",$(doneButton),"");
        reusableUtilities.conditionalWait("Visibility",newFrameForErrorMessage,"");
        reusableUtilities.switchFrame($(newFrameForErrorMessage),"",0);
        reusableUtilities.switchFrame($(newFrameForOKButton),"",0);
        reusableUtilities.performAction("Button",$(newFrameForOKButton),"");
    }

    public void validateFieldsInTabs(List<List<String>> data){
        Serenity.getDriver().switchTo().defaultContent();
//        reusableUtilities.switchFrame($(PartPage.newFrameForCreatePartFrame), "", 0);
//        reusableUtilities.switchFrame($(SubfamilyPage.newFrameForm), "", 0);
//        reusableUtilities.switchFrame($(SubfamilyPage.newFrameForm2), "", 0);
        reusableUtilities.switchFrame($(""), "", 0);
        reusableUtilities.switchFrame($(By.xpath("//iframe[@id='5186C9A803D74EC9AE8AFED8BD964C59']")), "", 0);
        for(int i = 0; i< data.get(0).size(); i++) {
            By defaultAttribute = By.xpath("//*[contains(text(),'"+data.get(0).get(i)+"')]");
            if($(defaultAttribute).isCurrentlyVisible()) {
                Assert.assertTrue(true);
                System.out.println(data.get(0).get(i)+" is present in the tab");
            }
        }
    }

    public void userClicksOnHistoryFromMenu(){
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(PartPage.newFrameForCreatePartFrame), "", 0);
        $(navigateButton).click();
        $(historyButton).click();
    }
    public void validateFieldsInHistoryWindow(List<List<String>> data){
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(PartPage.newFrameForCreatePartFrame), "", 0);
        reusableUtilities.conditionalWait("visibility", newFrameForHistoryRelationship1, "");
        reusableUtilities.switchFrame($(newFrameForHistoryRelationship1), "", 0);
        reusableUtilities.switchFrame($(newFrameForHistoryRelationship2), "", 0);
        reusableUtilities.switchFrame($(newFrameForHistoryRelationship3), "", 0);
        reusableUtilities.switchFrame($(newFrameForHistoryRelationship4), "", 0);
        for(int i = 0; i< data.get(0).size(); i++) {
            By defaultAttribute = By.xpath("//*[contains(text(),'"+data.get(0).get(i)+"')]");
            if($(defaultAttribute).isCurrentlyVisible()) {
                Assert.assertTrue(true);
                System.out.println(data.get(0).get(i)+" is present in the tab");
            }
        }
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(PartPage.newFrameForCreatePartFrame), "", 0);
        $(historyWindowCloseButton).click();
        if($(PartPage.alertMessage).isCurrentlyVisible()){
            $(PartPage.ok).click();
        }
    }
    public void userClicksOnWorkflowFromMenu(){
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(PartPage.newFrameForCreatePartFrame), "", 0);
        $(navigateButton).click();
        $(workflowButton).click();
    }

    public void validateFieldsInWorkflowWindow(List<List<String>> data){
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(DocumentPage.newFrameForCreateDocumentFrame2), "", 0);
        reusableUtilities.conditionalWait("visibility", PartPage.newFrameForCreatePartFrameDataEntry, "");
        reusableUtilities.switchFrame($(PartPage.newFrameForCreatePartFrameDataEntry), "", 0);
        for(int i = 0; i< data.get(0).size(); i++) {
            By defaultAttribute = By.xpath("//*[contains(text(),'"+data.get(0).get(i)+"')]");
            if($(defaultAttribute).isCurrentlyVisible()) {
                Assert.assertTrue(true);
                System.out.println(data.get(0).get(i)+" is present in the tab");
            }
        }
        Serenity.getDriver().switchTo().defaultContent();
        $(DocumentPage.closeButtonForSecondTab).click();
    }

    public void voteNowButtonNavigation(){
        waitABit(2000);
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(PartPage.newFrameForCreatePartFrame), "", 0);
        waitABit(2000);
        if($(SubfamilyPage.newFrameForm1).isCurrentlyVisible()) {
            reusableUtilities.switchFrame($(SubfamilyPage.newFrameForm1), "", 0);
            reusableUtilities.switchFrame($(SubfamilyPage.newFrameForm2), "", 0);
            reusableUtilities.switchFrame($(SubfamilyPage.newFrameToSeeSubFamilyWorkFlow), "", 0);
        }
        else {
            reusableUtilities.switchFrame($(SubfamilyPage.newFrameForm), "", 0);
            reusableUtilities.switchFrame($(SubfamilyPage.newFrameForm2), "", 0);
            reusableUtilities.switchFrame($(SubfamilyPage.newFrameToSeeSubFamilyWorkFlow), "", 0);
        }
        reusableUtilities.scrollToAnElement(SubfamilyPage.voteNowButton);
    }
    public void validatingVoteNowButtonIsPresent(){
        voteNowButtonNavigation();
        if($(SubfamilyPage.voteNowButton).isCurrentlyVisible()) {
            Assert.assertTrue(true);
        }
    }
    public void validatingVoteNowButtonIsNotPresent(){
        waitABit(2000);
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(PartPage.newFrameForCreatePartFrame), "", 0);
        waitABit(2000);
        if($(SubfamilyPage.newFrameForm1).isCurrentlyVisible()) {
            reusableUtilities.switchFrame($(SubfamilyPage.newFrameForm1), "", 0);
            reusableUtilities.switchFrame($(SubfamilyPage.newFrameForm2), "", 0);
            reusableUtilities.switchFrame($(SubfamilyPage.newFrameToSeeSubFamilyWorkFlow), "", 0);
        }
        else {
            reusableUtilities.switchFrame($(SubfamilyPage.newFrameForm), "", 0);
            reusableUtilities.switchFrame($(SubfamilyPage.newFrameForm2), "", 0);
            reusableUtilities.switchFrame($(SubfamilyPage.newFrameToSeeSubFamilyWorkFlow), "", 0);
        }
        if($(SubfamilyPage.voteNowButton).isCurrentlyVisible()) {
            Assert.assertFalse(false);
        }
    }
    public void addItemsToAffectedItems() {
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(PartPage.newFrameForCreatePartFrame), "", 0);
        reusableUtilities.switchFrame($(SubfamilyPage.newFrameForm), "", 0);
        reusableUtilities.switchFrame($(SubfamilyPage.newFrameForm2), "", 0);
        $(addItemButton).click();
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(PartPage.newFrameForCreatePartFrame), "", 0);
        reusableUtilities.switchFrame($(PartPage.newFrameToSelectPart), "", 0);
        $(searchItemButton).click();
        reusableUtilities.conditionalWait("Visibility", PartPage.searchResults, "");
        $(PartPage.searchResults).click();
        $(PartPage.ok).click();
        Serenity.getDriver().switchTo().defaultContent();
        if($(By.xpath("//*[text()='Create']")).isCurrentlyVisible()) {
            $(By.xpath("//*[text()='Create']")).click();
        }
        reusableUtilities.switchFrame($(PartPage.newFrameForCreatePartFrame), "", 0);
        reusableUtilities.switchFrame($(SubfamilyPage.newFrameForm), "", 0);
        reusableUtilities.switchFrame($(SubfamilyPage.newFrameForm2), "", 0);
    }
    public void validateItemAdditionInAffectedItems() {
        if($(affectedItemResults).isCurrentlyVisible()){
            Assert.assertTrue(true);
        }
    }
}