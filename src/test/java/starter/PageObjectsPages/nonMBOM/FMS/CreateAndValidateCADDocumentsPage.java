package starter.PageObjectsPages.nonMBOM.FMS;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import starter.Utility.ReusableUtilities;

import java.util.concurrent.TimeUnit;

public class CreateAndValidateCADDocumentsPage extends PageObject {

    static By arasButtonIcon = By.className("aras-button__icon");
    static By documents = By.xpath("//*[@class='aras-nav__label'] [text()='Documents']");
    static By cadDocument = By.xpath("//*[text()='CAD Documents']");
    static By createNewCADDocument = By.xpath("//*[text()='Create New CAD Document']");
    static By docNumbers = By.xpath("//*[@class='item_number']");
    static By docNames = By.xpath("//*[@class='name']");
    static By descriptions = By.xpath("//*[@class='description']");
    static By doneButton = By.xpath("//*[text()='Done']");
    static By editButton = By.xpath("//*[text()='Edit']");
    static By arasSpinner = By.xpath("//iframe[@id='dimmer_spinner']");
    static By type = By.xpath("//*[@id=\"2B8E631A7C9B4F8F818724C6C9CAD5A7wrapper\"]/aras-classification-property/div/button");
    static By designatedUser = By.xpath("//*[@id='0099D26B5A7F403F914CA91CF4A18C28_img']");
    static By newFrameToSelectTypeAndDesignatedUser = By.xpath("//*[@class='aras-dialog__iframe']");
    static By userNameToSearch = By.xpath("//*[@class='aras-form-input']");
    static By userNameToSelect = By.xpath("(//*[@class='aras-grid-row-cell '])[2]");
    static By okButton = By.xpath("//*[text()='OK']");
    static By newFrameForCreateCADDocumentFrame = By.xpath("//*[@class='content-block__iframe']");
    static By newFrameForCreateCADDocumentFrameDataEntry = By.xpath("//*[@id='instance']");
    String typeName = "";
    By typeNames = By.xpath("//*[text()='"+typeName.trim()+"']");

    ReusableUtilities reusableUtilities;

    public void navigatingToCADDocument () {
        reusableUtilities.performAction("Button", $(documents), "Clicking on Document");
    }

    public void clickOnCreateCADDocument () {
        reusableUtilities.performAction("Button", $(cadDocument), "Clicking on CAD Document");
        reusableUtilities.performAction("Button", $(createNewCADDocument), "Clicking on Create New CAD document");
    }

    public void createNewCADDocumentWithNumberNameDesc (String docNumber, String docName, String description) {
        Serenity.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        reusableUtilities.switchFrame($(newFrameForCreateCADDocumentFrame), "", 0);
        reusableUtilities.switchFrame($(newFrameForCreateCADDocumentFrameDataEntry), "", 0);
        reusableUtilities.conditionalWait("Visibility", docNumbers, "Item Number to be visible");
        reusableUtilities.performAction("Text", $(docNumbers), docNumber);
        reusableUtilities.performAction("Text", $(docNames), docName);
        reusableUtilities.performAction("Text",$(descriptions), description);
    }
    public void providingType (String typeName) {
        this.typeName = typeName.trim();
        System.out.println(this.typeName);
        reusableUtilities.conditionalWait("Visibility", type, "");
        try {
            Thread.sleep(15000);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        reusableUtilities.performAction("button", $(type), "");
        Serenity.getDriver().switchTo().parentFrame();
        reusableUtilities.conditionalWait("Visibility", newFrameToSelectTypeAndDesignatedUser, "");
        reusableUtilities.switchFrame($(newFrameToSelectTypeAndDesignatedUser), "", 0);
        reusableUtilities.selectingClassification(typeNames);
    }
    public void providingUserName (String userName) {
        try {
            Thread.sleep(10000);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        reusableUtilities.switchFrame($(newFrameForCreateCADDocumentFrameDataEntry), "", 0);
        reusableUtilities.conditionalWait("Visibility", designatedUser, "");
        reusableUtilities.performAction("button", $(designatedUser), "");
        Serenity.getDriver().switchTo().parentFrame();
        reusableUtilities.conditionalWait("Visibility", newFrameToSelectTypeAndDesignatedUser, "");
        reusableUtilities.switchFrame($(newFrameToSelectTypeAndDesignatedUser), "", 0);
        reusableUtilities.selectingItem(userNameToSearch, userNameToSelect, okButton, userName);
    }
    public void creatingCADDocument () {
        reusableUtilities.performAction("button", $(doneButton), "");
        reusableUtilities.conditionalWait("invisibility", arasSpinner, "");
    }

    public void validatingCADDocumentCreation () {
        reusableUtilities.conditionalWait("Visibility", editButton, "To validate creation");
        Serenity.getDriver().switchTo().parentFrame();
    }




}
