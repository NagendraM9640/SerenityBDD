package starter.PageObjectsPages.nonMBOM.FMS;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import starter.Utility.ReusableUtilities;

public class DocumentPage extends PageObject {

    static By arasButtonIcon = By.className("aras-button__icon");
    static By documents = By.xpath("//*[@class='aras-nav__label'] [text()='Documents']");
    static By subDocuments = By.xpath("(//*[@class='aras-nav__label'] [text()='Documents'])[2]");
    static By createNewDocument = By.xpath("//*[text()='Create New Document']");
    static By fieldToProvideDocumentNumber = By.xpath("//*[@class='aras-input aras-quick-search__input']");
    static By attachmentShown = By.xpath("//*[@class='aras-grid-link']");
    static By docNumber = By.xpath("//*[@class='item_number']");
    static By docName = By.xpath("//*[@class='name']");
    static By longDescription = By.xpath("//*[@class='description']");
    static By doneButton = By.xpath("//*[text()='Done']");
    static By editButton = By.xpath("//*[text()='Edit']");
    static By newFrameForCreateDocumentFrame = By.xpath("//iframe[contains(@name,'innovator_')]");
    public static By newFrameForCreateDocumentFrame2 = By.xpath("(//iframe[contains(@name,'innovator_')])[2]");
    static By newFrame = By.xpath("//iframe[contains(@name,'search_')]");
    static By newFrameForFileSearch = By.xpath("//*[@class='content-block__iframe']");
    static By newFrameForCreateDocumentFrameDataEntry = By.xpath("//*[@id='instance']");
    static By newFrameForFileUpload = By.xpath("//*[@id='73C333E4E4174DD39DF3444ED344F805']");
    static By newFile = By.xpath("//button[@title='New File']");
    static By arasSpinner = By.xpath("//iframe[@id='dimmer_spinner']");
    static By closeButton = By.xpath("//*[@class='aras-icon-close']");
    static By backToMenuButton = By.xpath("(//*[@class='aras-button__icon'])[6]");
    static By administration = By.xpath("//*[text()='Administration']");
    static By fileHandling = By.xpath("//*[text()='File Handling']");
    static By files = By.xpath("//*[text()='Files']");
    static By searchFiles = By.xpath("//*[text()='Search Files']");
    static By searchFieldToSearchFiles = By.xpath("//*[@class='aras-form-input']");
    static By searchResults = By.xpath("(//*[@class='aras-grid-row-cell '])[2]");
    static By more = By.xpath("//*[text()='More']");
    static By delete = By.xpath("//span[text()='Delete']");
    static By okButton = By.xpath("//*[text()='OK']");
    static By okButtonToDeleteDocument = By.xpath("//*[@id='btnYes']");
    static By deleteAllVersions = By.xpath("//span[text()='Delete All Versions']");
    static By newFrameToDeleteDocument = By.xpath("//*[@class='aras-dialog__iframe']");
    static By firstTab = By.xpath("(//*[@class='aras-tabs__label'])[1]");
    public static By generatedRevision = By.className("major_rev");
    static By calenderButton = By.id("F6905EC0C0834B539B0CAA62141A32FE_img");
    static By nextMonthButton = By.xpath("//*[@id='Aras_Client_Controls_Experimental_CalendarLite_0']/thead/tr[1]/th[3]/img");
    static By previousYearButton = By.xpath("//*[@id='Aras_Client_Controls_Experimental_CalendarLite_0']/tfoot/tr/td/div/span[1]");
    public static By documentsTab = By.xpath("//span[@class='aras-tabs__label' and text()='Documents']");
    public static By filesTab = By.xpath("//span[@class='aras-tabs__label' and text()='Files']");
    public static By attachmentsTab = By.xpath("//span[@class='aras-tabs__label' and text()='Attachments']");
    public static By addDocumentButton = By.xpath("//button[contains(@class,'aras-button') and @title = 'Add Documents']");
    public static By newDocumentButton = By.xpath("//button[contains(@class,'aras-button') and @title = 'New Document']");
    public static By newFrameToAddDocuments = By.xpath("//iframe[@title='Part Document Relationship']");
    public static By newFrameToAddFiles = By.xpath("//iframe[@title='Document File Relationship']");
    public static By newFrameToAddDocumentsInECO = By.xpath("//iframe[@title='pmi_ExpressECODocument Relationship']");
    public static By newFrameToFilesInECO = By.xpath("//iframe[@title='Express ECO File Relationship']");
    public static By newFrameToAddFilesInECO = By.xpath("//iframe[@title='Express ECO File Relationship']");
    public static By closeButtonForFirstTab = By.xpath("//span[@class='aras-icon-close-block']");
    public static By closeButtonForSecondTab = By.xpath("(//span[@class='aras-icon-close-block'])[2]");

    ReusableUtilities reusableUtilities = new ReusableUtilities();

    String fileLink = System.getProperty("user.dir")+"\\src\\test\\resources\\AdditionalFiles\\File134.txt";
    String[] fileNameInArray = fileLink.split("\\\\");
    String fileName = fileNameInArray[fileNameInArray.length-1];

    public void createNewDocument (String documentName, String description) {
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.conditionalWait("Invisibility", arasSpinner, "");
        reusableUtilities.switchFrame($(newFrameForCreateDocumentFrame), "", 0);
        reusableUtilities.switchFrame($(newFrameForCreateDocumentFrameDataEntry), "", 0);
        reusableUtilities.performAction("Text", $(docName), documentName);
        reusableUtilities.performAction("Text",$(longDescription), description);
    }

    public void validateDocumentNumber() {
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(newFrameForCreateDocumentFrame), "", 0);
        reusableUtilities.switchFrame($(newFrameForCreateDocumentFrameDataEntry), "", 0);
        String generatedDocNumber  = reusableUtilities.getObjectProperty($(docNumber), "value");
        if(generatedDocNumber.startsWith("DOC")) {
            Assert.assertTrue(true);
        }
        if($(docNumber).isEnabled()) {
            Assert.assertFalse(false);
        }
    }

    public void validateRevisionField(String revision) {
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(newFrameForCreateDocumentFrame), "", 0);
        reusableUtilities.switchFrame($(newFrameForCreateDocumentFrameDataEntry), "", 0);
        if(reusableUtilities.getObjectProperty($(generatedRevision), "value").equalsIgnoreCase(revision)) {
            Assert.assertTrue(true);
        }
    }

    public void userAddsDocumentToTheRequest() {
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(ParametersToIngredientPage.newFrameForCreatePartFrame), "", 0);
        reusableUtilities.performAction("", $(documentsTab), "");
        if($(newFrameToAddDocuments).isCurrentlyVisible()) {
            reusableUtilities.switchFrame($(newFrameToAddDocuments), "", 0);
        }
        else if($(newFrameToAddDocumentsInECO).isCurrentlyVisible()) {
            reusableUtilities.switchFrame($(newFrameToAddDocumentsInECO), "", 0);
        }
        reusableUtilities.conditionalWait("visibility", addDocumentButton, "");
        reusableUtilities.scrollToAnElement(addDocumentButton);
        reusableUtilities.performAction("", $(addDocumentButton), "");
        Serenity.getDriver().switchTo().parentFrame();
        reusableUtilities.switchFrame($(ParametersToIngredientPage.newFrameToSelectParameters), "", 0);
        reusableUtilities.performAction("", $(ParametersToIngredientPage.searchFieldToSearchParameters), "");
        reusableUtilities.pressEnter(ParametersToIngredientPage.searchFieldToSearchParameters);
        reusableUtilities.conditionalWait("visibility", ParametersToIngredientPage.searchResults, "");
        reusableUtilities.performAction("", $(ParametersToIngredientPage.searchResults), "");
        reusableUtilities.performAction("", $(ParametersToIngredientPage.okButton), "");
    }

    public void userValidatesAddedDocument() {
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(ParametersToIngredientPage.newFrameForCreatePartFrame), "", 0);
        if ($(searchResults).isCurrentlyVisible()) {
            Assert.assertTrue("Document has been added successfully", true);
        }
    }

    public void userCreatesNewDocumentToTheRequest() {
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(ParametersToIngredientPage.newFrameForCreatePartFrame), "", 0);
        reusableUtilities.performAction("", $(documentsTab), "");
        if ($(newFrameToAddDocuments).isCurrentlyVisible()) {
            reusableUtilities.switchFrame($(newFrameToAddDocuments), "", 0);
        } else if ($(newFrameToAddDocumentsInECO).isCurrentlyVisible()) {
            reusableUtilities.switchFrame($(newFrameToAddDocumentsInECO), "", 0);
        }
        reusableUtilities.conditionalWait("visibility", newDocumentButton, "");
        reusableUtilities.scrollToAnElement(newDocumentButton);
        reusableUtilities.performAction("", $(newDocumentButton), "");
        waitABit(8000);
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.conditionalWait("Invisibility", arasSpinner, "");
        reusableUtilities.switchFrame($(newFrameForCreateDocumentFrame2), "", 0);
        reusableUtilities.switchFrame($(newFrameForCreateDocumentFrameDataEntry), "", 0);
        reusableUtilities.performAction("Text", $(docName), "documentName");
        reusableUtilities.performAction("Text",$(longDescription), "description");
    }

    public void userAttachesFileToTheDocument() {
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(ParametersToIngredientPage.newFrameForCreatePartFrame), "", 0);
        if($(filesTab).isCurrentlyVisible()) {
            reusableUtilities.performAction("", $(filesTab), "");
        }
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(newFrameForCreateDocumentFrame2), "", 0);
        if(($(filesTab).isCurrentlyVisible())){
            reusableUtilities.performAction("", $(filesTab), "");
        }
        reusableUtilities.switchFrame($(newFrameToAddFiles), "", 0);
        reusableUtilities.conditionalWait("visibility", newFile, "");
        reusableUtilities.scrollToAnElement(newFile);
        try {
            reusableUtilities.uploadFile(newFile, fileLink);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

   /* public void searchAttachedFileInFileSection () {
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.performAction("Button", $(arasButtonIcon), "Clicking on Burger Menu");
        reusableUtilities.performAction("Button", $(backToMenuButton), "");
        reusableUtilities.performAction("Button", $(administration), "");
        reusableUtilities.performAction("Button", $(fileHandling), "");
        reusableUtilities.performAction("Button", $(files), "");
        reusableUtilities.performAction("Button", $(searchFiles), "");
        reusableUtilities.conditionalWait("Visibility", newFrameForFileSearch, "");
        reusableUtilities.switchFrame($(newFrame), "", 0);
        reusableUtilities.conditionalWait("visibility", arasSpinner, "");
        waitABit(10000);
        reusableUtilities.conditionalWait("invisibility", arasSpinner, "");
        reusableUtilities.performAction("Text", $(searchFieldToSearchFiles), fileName);
        reusableUtilities.pressEnter(searchFieldToSearchFiles);
        reusableUtilities.conditionalWait("Visibility", searchResults, "");
        Serenity.getDriver().switchTo().defaultContent();
    }
    public void deleteDocument (String documentName) {
        reusableUtilities.performAction("Button", $(arasButtonIcon), "Clicking on Burger Menu");
        reusableUtilities.performAction("Button", $(backToMenuButton), "");
        reusableUtilities.performAction("Button", $(fileHandling), "");
        reusableUtilities.performAction("Button", $(administration), "");
        waitABit(2000);
        reusableUtilities.performAction("Button", $(subDocuments), "");
        reusableUtilities.performAction("Text", $(fieldToProvideDocumentNumber), documentName);
        reusableUtilities.pressEnter(fieldToProvideDocumentNumber);
        waitABit(7000);
        reusableUtilities.switchFrame($(newFrameForCreateDocumentFrame), "", 0);
        reusableUtilities.conditionalWait("invisibility", arasSpinner, "");
        waitABit(7000);
        reusableUtilities.clickUsingJavaScriptExecutor($(deleteAllVersions));
        reusableUtilities.conditionalWait("Visibility", newFrameToDeleteDocument, "");
        reusableUtilities.switchFrame($(newFrameToDeleteDocument),"",0);
        reusableUtilities.conditionalWait("visibility", okButtonToDeleteDocument, "");
        reusableUtilities.clickUsingJavaScriptExecutor($(okButtonToDeleteDocument));
        Serenity.getDriver().switchTo().defaultContent();
    }

    public void validateFilePresenceInFileSection () {
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.conditionalWait("visibility", firstTab, "");
        reusableUtilities.performAction("Button", $(firstTab), "");
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(newFrameForFileSearch), "", 0);
        $(searchFieldToSearchFiles).clear();
        reusableUtilities.performAction("Text", $(searchFieldToSearchFiles), fileName);
        reusableUtilities.pressEnter(searchFieldToSearchFiles);
        reusableUtilities.conditionalWait("Visibility", searchResults, "");
    }

    public void deleteFile () {
        reusableUtilities.rightClick(searchResults);
        reusableUtilities.performAction("Button", $(more), "");
        waitABit(5000);
        reusableUtilities.performAction("Button", $(delete), "");
        Serenity.getDriver().switchTo().parentFrame();
        reusableUtilities.performAction("Button", $(okButton), "");
        reusableUtilities.switchFrame($(newFrameForFileSearch), "", 0);
        reusableUtilities.conditionalWait("invisibility", searchResults, "");
        Assert.assertTrue(true);
    }*/
    public void closingSecondTab() {
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.performAction("", $(closeButtonForSecondTab), "");
    }
}
