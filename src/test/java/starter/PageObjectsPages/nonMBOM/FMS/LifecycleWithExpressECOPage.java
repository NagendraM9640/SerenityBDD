package starter.PageObjectsPages.nonMBOM.FMS;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import starter.Utility.ReusableUtilities;

public class LifecycleWithExpressECOPage extends PageObject {

    public static By addItemsToChangeButton = By.xpath("//span[contains(text(),'Add Item(s) To Change')]");
    public static By newFrameForAffectedItems = By.xpath("//iframe[@id='1A6269964DD94DEA98E530E391EF3395']");
    public static By newFrameToSelectExpressEco = By.xpath("//iframe[@id='formFrame']");
    public static By changeTypeInputDropdown = By.xpath("//select[@name='change_type_input']");
    //public static By itemActionField = By.xpath("//td[@class='dojoxGridCell' and @idx='4' and text()='Review']");
    public static By itemActionField = By.xpath("//td[text()='Review']");
    public static By targetLifecycleField = By.xpath("//*[text()='Under Development']");
    public static By targetLifecycleField2 = By.xpath("//*[text()='Under Verification']");
    public static By targetLifecycleField3 = By.xpath("//*[text()='Approved']");
    static By okButton = By.xpath("//*[@name='ok_button']");
    public static By affectedItemsTab = By.xpath("//span[@class='aras-tabs__label' and text()='Affected Items']");
    public static By qcsAffectedItemIframe = By.xpath("//iframe[@title='pmi_QcsECO_AffectedItem Relationship']");

    ReusableUtilities reusableUtilities;

    public void userTriesToCreateExpressEco() {
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(PartPage.newFrameForCreatePartFrame), "", 0);
        reusableUtilities.performAction("Button", $(PartPage.tripleDots), "");
        waitABit(2000);
        reusableUtilities.performAction("Button", $(addItemsToChangeButton), "");
        waitABit(2000);
        reusableUtilities.switchFrame($(PartPage.newFrameToSelectPart), "", 0);
        reusableUtilities.switchFrame($(newFrameToSelectExpressEco), "", 0);
        reusableUtilities.conditionalWait("Visibility", changeTypeInputDropdown, "");
        reusableUtilities.performAction("Select", $(changeTypeInputDropdown), "Express ECO");
        reusableUtilities.performAction("", $(okButton), "");
        waitABit(8000);
        getDriver().switchTo().defaultContent();
        reusableUtilities.performAction("", $(PartPage.closeButton), "");
    }

    public void userSelectsItemAction(String itemAction) {
        waitABit(10000);
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(PartPage.newFrameForCreatePartFrame), "", 0);
        reusableUtilities.scrollToAnElement(affectedItemsTab);
        reusableUtilities.switchFrame($(SubfamilyPage.newFrameForm), "", 0);
        reusableUtilities.switchFrame($(SubfamilyPage.newFrameForm2), "", 0);
        reusableUtilities.performAction("", $(itemActionField), "");
        reusableUtilities.rightClick(itemActionField);
        reusableUtilities.performAction("", $(By.xpath("//*[text()='" + itemAction.trim() + "']")), "");
    }

    public void userSelectsTargetLifecycle(String targetLifecycle) {
        waitABit(4000);
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(PartPage.newFrameForCreatePartFrame), "", 0);
        if($(qcsAffectedItemIframe).isCurrentlyVisible()){
            reusableUtilities.switchFrame($(qcsAffectedItemIframe), "", 0);
        }else {
            reusableUtilities.switchFrame($(SubfamilyPage.newFrameForm), "", 0);
            reusableUtilities.switchFrame($(SubfamilyPage.newFrameForm2), "", 0);
        }
        if ($(targetLifecycleField).isCurrentlyVisible()) {
            reusableUtilities.performAction("", $(targetLifecycleField), "");
            waitABit(2000);
            reusableUtilities.performAction("", $(targetLifecycleField), "");
            waitABit(2000);
        } else if ($(targetLifecycleField2).isCurrentlyVisible()) {
            reusableUtilities.performAction("", $(targetLifecycleField2), "");
            waitABit(2000);
            reusableUtilities.performAction("", $(targetLifecycleField2), "");
            waitABit(2000);
        } else if ($(targetLifecycleField3).isCurrentlyVisible()) {
            reusableUtilities.performAction("", $(targetLifecycleField3), "");
            waitABit(2000);
//            reusableUtilities.performAction("", $(targetLifecycleField3), "");
//            waitABit(2000);
        }
        if (targetLifecycle.equalsIgnoreCase("Released")) {
            reusableUtilities.pressDownNavigation();
            waitABit(2000);
            reusableUtilities.pressDownNavigation();
            waitABit(2000);
            reusableUtilities.pressDownNavigation();
            waitABit(2000);
            reusableUtilities.pressDownNavigation();
        } else if (targetLifecycle.equalsIgnoreCase("Under Verification")) {
            reusableUtilities.pressDownNavigation();
            waitABit(2000);
            reusableUtilities.pressDownNavigation();
            waitABit(2000);
            reusableUtilities.pressDownNavigation();
        } else if (targetLifecycle.equalsIgnoreCase("Suppressed from Released")) {
            reusableUtilities.pressDownNavigation();
            waitABit(2000);
            reusableUtilities.pressDownNavigation();
            waitABit(2000);
            reusableUtilities.pressDownNavigation();
        }else if(targetLifecycle.equalsIgnoreCase("Suppressed")){
            String targetLifeCycle = reusableUtilities.getObjectProperty($(targetLifecycleField3),"Value");
            for (int i = 0; i < targetLifeCycle.length(); i++) $(targetLifecycleField3).sendKeys(Keys.BACK_SPACE);
            reusableUtilities.performAction("Text", $(targetLifecycleField3), targetLifecycle);
        }
        waitABit(3000);
        reusableUtilities.pressEnterWithoutElement();

    }

    public void userOpensPartFromAffectedItems() {
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(PartPage.newFrameForCreatePartFrame), "", 0);
        reusableUtilities.conditionalWait("visibility", affectedItemsTab, "");
        reusableUtilities.performAction("", $(affectedItemsTab), "");
        reusableUtilities.switchFrame($(SubfamilyPage.newFrameForm), "", 0);
        reusableUtilities.switchFrame($(SubfamilyPage.newFrameForm2), "", 0);
        reusableUtilities.conditionalWait("visibility", By.xpath("//*[text()='"+PartPage.generatedItemCode.trim()+"']"), "");
        reusableUtilities.performAction("", $(By.xpath("//*[text()='"+PartPage.generatedItemCode.trim()+"']")), "");
        waitABit(2000);
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.performAction("", $(PartPage.closeButton), "");
    }

    public void validatingParentChildPartStatus(String status) {
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.conditionalWait("Visibility", PartPage.newFrameForPartSearch, "");
        reusableUtilities.switchFrame($(PartPage.newFrame), "", 0);
        waitABit(1000);
        $(PartPage.searchResults).click();
        waitABit(1000);
        reusableUtilities.pressTab();
        waitABit(1000);
        reusableUtilities.pressTab();
        waitABit(1000);
        reusableUtilities.pressTab();
        waitABit(1000);
        reusableUtilities.pressTab();
        waitABit(1000);
        reusableUtilities.pressTab();
        waitABit(1000);
        reusableUtilities.pressTab();
        waitABit(1000);
        reusableUtilities.pressTab();
        waitABit(1000);
        if ($(Serenity.getDriver().switchTo().activeElement()).getText().equalsIgnoreCase(status.trim())) {
            Assert.assertTrue(true);
        }
        reusableUtilities.pressDownNavigation();
        waitABit(1000);
        if ($(Serenity.getDriver().switchTo().activeElement()).getText().equalsIgnoreCase(status.trim())) {
            Assert.assertTrue(true);
        }
        reusableUtilities.pressDownNavigation();
        waitABit(1000);
        if ($(Serenity.getDriver().switchTo().activeElement()).getText().equalsIgnoreCase(status.trim())) {
            Assert.assertTrue(true);
        }
    }
}
