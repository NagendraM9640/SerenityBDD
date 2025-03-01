package starter.PageObjectsPages.nonMBOM.FMS.UserAccessValidation;

import net.serenitybdd.core.Serenity;
import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import starter.PageObjectsPages.nonMBOM.FMS.PartPage;
import starter.Utility.ReusableUtilities;

public class CanAddPermissionPage extends PageObject {

    ReusableUtilities reusableUtilities;

    public void validatingItemTypeEnablementInCreatePartAccess(String itemType){
        Serenity.getDriver().switchTo().defaultContent();
        By partNameAsIngredient = By.xpath("//*[text()='"+itemType.trim()+"']");
        reusableUtilities.switchFrame($(PartPage.newFrameToSelectPart), "", 0);
        if($(partNameAsIngredient).isEnabled()) {
            Assert.assertTrue(true);
        }
        else {
            Assert.fail();
        }
        Serenity.getDriver().switchTo().defaultContent();
        $(By.xpath("//span[@title='Close']")).click();
    }
    public void validatingItemTypeEnablementInCreateAccessControlAccess(String itemType){
        Serenity.getDriver().switchTo().defaultContent();
        By partNameAsIngredient = By.xpath("//*[text()='"+itemType.trim()+"']");
        reusableUtilities.switchFrame($(PartPage.newFrameToSelectPart), "", 0);
        if($(partNameAsIngredient).isEnabled()) {
            Assert.assertTrue(true);
        }
        else {
            Assert.fail();
        }
    }
    public void validatingItemTypeDisablementInCreatePartAccess(String itemType){
        Serenity.getDriver().switchTo().defaultContent();
        By partNameAsIngredient = By.xpath("//*[text()='"+itemType.trim()+"']");
        reusableUtilities.switchFrame($(PartPage.newFrameToSelectPart), "", 0);
        waitABit(1000);
        $(By.xpath("//span[@class='aras-form aras-compat-toolbar__textbox']/input")).click();
        waitABit(1000);
        $(By.xpath("//span[@class='aras-form aras-compat-toolbar__textbox']/input")).sendKeys(itemType);
        waitABit(1000);
        if($(By.xpath("//span[contains(@class, 'aras-nav-item_disabled') and text()='"+itemType.trim()+"']")).isCurrentlyVisible()) {
            Assert.assertTrue(true);
        }
        else{
            Assert.fail();
        }
        Serenity.getDriver().switchTo().defaultContent();
        $(By.xpath("//span[@title='Close']")).click();
    }
    public void validateBatchForm(String s) {
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.conditionalWait("Visibility", PartPage.arasSpinner, "");
        reusableUtilities.conditionalWait("Invisibility", PartPage.arasSpinner, "");
        reusableUtilities.conditionalWait("Visibility", PartPage.newFrameForCreatePartFrame, "");
        if($(PartPage.newFrameForCreatePartFrame2).isCurrentlyVisible()){
            reusableUtilities.switchFrame($(PartPage.newFrameForCreatePartFrame2), "", 0);
        }
        else {
            reusableUtilities.switchFrame($(PartPage.newFrameForCreatePartFrame), "", 0);
        }
        reusableUtilities.conditionalWait("visibility", By.xpath("//*[text()='"+s.trim()+"']"), "");
        if($(By.xpath("//*[text()='"+s.trim()+"']")).isCurrentlyVisible()) {
            $(By.xpath("//*[text()='"+s.trim()+"']")).click();
            Assert.assertTrue("The form has been loaded successfully", true);
        }
        else {
            Assert.fail();
        }
    }
}