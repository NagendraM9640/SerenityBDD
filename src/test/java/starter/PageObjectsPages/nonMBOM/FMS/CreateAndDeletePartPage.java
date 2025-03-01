package starter.PageObjectsPages.nonMBOM.FMS;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import starter.Utility.ReusableUtilities;

import java.util.concurrent.TimeUnit;

public class CreateAndDeletePartPage extends PageObject {

    static By arasButtonIcon = By.className("aras-button__icon");
    static By design = By.xpath("//*[text()='Design']");
    static By parts = By.xpath("//*[text()='Parts']");
    static By createNewPart = By.xpath("//*[text()='Create New Part']");
    static By partDropDown = By.xpath("//*[@class='aras-nav-item_disabled']");
    static By newFrameToSelectPart = By.xpath("//*[@class='aras-dialog__iframe']");
    static By partNameAsCigarette = By.xpath("//*[text()='Cigarette']");
    static By itemNumber = By.xpath("//*[@class='item_number']");
    static By itemName = By.xpath("//*[@class='name']");
    static By description = By.xpath("//*[@class='description']");
    static By doneButton = By.xpath("//*[text()='Done']");
    static By editButton = By.xpath("//*[text()='Edit']");
    static By newFrameForCreatePartFrame = By.xpath("//*[@class='content-block__iframe']");
    static By newFrameForCreatePartFrameDataEntry = By.xpath("//*[@id='instance']");
    static By searchPart = By.className("aras-input");
    static By tripleDots = By.className(" aras-button__icon");

    ReusableUtilities reusableUtilities = new ReusableUtilities();

    String number = "ArupTest004";

    public void navigatingToNewPart () {
        //reusableUtilities.performAction("Button", $(arasButtonIcon), "Clicking on Aras Button");
        reusableUtilities.performAction("Button", $(design), "Clicking on Design");
        reusableUtilities.performAction("Button", $(parts), "Clicking on Parts");
        reusableUtilities.performAction("Button", $(createNewPart), "Clicking on Create New Part");
        reusableUtilities.switchFrame($(newFrameToSelectPart), "", 0);
        reusableUtilities.conditionalWait("visibility", partDropDown, "Waiting Part Drop Down to be visible");
        reusableUtilities.performAction("Button", $(partDropDown), "Clicking on Drop Down");
    }

    public void createPart () throws Exception{
        reusableUtilities.doubleClick(partNameAsCigarette);
        Serenity.getDriver().manage().timeouts().implicitlyWait(240, TimeUnit.SECONDS) ;
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(newFrameForCreatePartFrame), "", 0);
        reusableUtilities.switchFrame($(newFrameForCreatePartFrameDataEntry), "", 0);
        reusableUtilities.conditionalWait("Visibility", itemName, "Item Number to be visible");
        reusableUtilities.performAction("Text", $(itemNumber), number);
        reusableUtilities.performAction("Text", $(itemName), number);
        reusableUtilities.performAction("Text",$(description), number);
        Serenity.getDriver().switchTo().parentFrame();
        reusableUtilities.performAction("Button", $(doneButton), number);
    }
    public boolean validatingCreation () {
        reusableUtilities.conditionalWait("Visibility", editButton, "To validate creation");
        return true;
    }
    public void partDeletion () {
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.performAction("Text", $(searchPart), number);
        reusableUtilities.pressEnter(searchPart);
        reusableUtilities.conditionalWait("Visibility", newFrameForCreatePartFrame, "Frame to be visible");
        reusableUtilities.switchFrame($(newFrameForCreatePartFrame), "", 0);
        reusableUtilities.performAction("Button", $(tripleDots),"");
        reusableUtilities.performAction("Select", $(tripleDots), "Delete");
        //reusableUtilities.performAction("Select", $(tripleDots), "Delete");
    }
}
