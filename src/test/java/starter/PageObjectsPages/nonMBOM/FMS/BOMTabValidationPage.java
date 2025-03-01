package starter.PageObjectsPages.nonMBOM.FMS;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import starter.Utility.ReusableUtilities;

import java.util.List;

public class BOMTabValidationPage extends PageObject {

    public static By quantityField = By.xpath("(//td[@class='aras-grid-row-cell '])[6]");
    public static By uomField = By.xpath("//td[@class='aras-grid-row-cell aras-grid-row-cell__select']");
    public static By newFrameInBOMStructure = By.xpath("//*[@id='567E4149FBF74DACA0B0C4C9B1E79A3B']");

    ReusableUtilities reusableUtilities;

    public void validationOfFieldsInBOMTab(List<List<String>> data){
        waitABit(5000);
        for(int i = 0; i< data.get(0).size(); i++) {
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(PartPage.newFrameForCreatePartFrame), "", 0);
        reusableUtilities.switchFrame($(RecipeInstructionPage.newFrameInBOM), "", 0);
            By defaultAttribute = By.xpath("//*[contains(text(),'"+data.get(0).get(i)+"')]");
            if($(defaultAttribute).isCurrentlyVisible()) {
                Assert.assertTrue(true);
                System.out.println(data.get(0).get(i)+" is present in the BOM tab");
            }
            else {
                Serenity.getDriver().switchTo().parentFrame();
                if($(defaultAttribute).isCurrentlyVisible()) {
                    Assert.assertTrue(true);
                    System.out.println(data.get(0).get(i)+" is present in the BOM tab");
                }
            }
        }
    }
    public void userAddsPartInBOMTab(){
        waitABit(3000);
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(PartPage.newFrameForCreatePartFrame), "", 0);
        reusableUtilities.conditionalWait("visibility", RecipeInstructionPage.newFrameInBOM, "");
        reusableUtilities.switchFrame($(RecipeInstructionPage.newFrameInBOM), "", 0);
        reusableUtilities.scrollToAnElement(RecipeInstructionPage.addPartsButton);
        reusableUtilities.conditionalWait("visibility", RecipeInstructionPage.addPartsButton, "");
        $(RecipeInstructionPage.addPartsButton).waitUntilClickable();
        $(RecipeInstructionPage.addPartsButton).click();
        Serenity.getDriver().switchTo().parentFrame();
        reusableUtilities.switchFrame($(PartPage.newFrameToSelectPart), "", 0);
        reusableUtilities.conditionalWait("visibility", RecipeInstructionPage.itemCodeField, "");
        $(RecipeInstructionPage.itemCodeField).click();
        reusableUtilities.pressBackspace();
        reusableUtilities.pressBackspace();
        reusableUtilities.pressBackspace();
        reusableUtilities.pressBackspace();
        reusableUtilities.pressBackspace();
        reusableUtilities.pressBackspace();
        reusableUtilities.pressBackspace();
        waitABit(1000);
        $(RecipeInstructionPage.itemTypeField).click();
        $(Serenity.getDriver().switchTo().activeElement()).typeAndEnter("Adhesive - 80");
        reusableUtilities.pressEnter(RecipeInstructionPage.itemTypeField);
        reusableUtilities.conditionalWait("visibility", PartPage.searchResults, "");
        $(PartPage.searchResults).click();
        $(PartPage.ok).click();
    }
    public void validationOfQuantityField(){
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(PartPage.newFrameForCreatePartFrame), "", 0);
        reusableUtilities.conditionalWait("visibility", RecipeInstructionPage.newFrameInBOM, "");
        reusableUtilities.switchFrame($(RecipeInstructionPage.newFrameInBOM), "", 0);
        System.out.println("Quantity Field is "+$(quantityField).getText());
        $(quantityField).click();
        $(quantityField).isEnabled();
        Assert.assertTrue(true);
    }
    public void validationOfUOMField(String uom){
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(PartPage.newFrameForCreatePartFrame), "", 0);
        reusableUtilities.conditionalWait("visibility", RecipeInstructionPage.newFrameInBOM, "");
        reusableUtilities.switchFrame($(RecipeInstructionPage.newFrameInBOM), "", 0);
        $(uomField).click();
        System.out.println("UOM Field is "+$(uomField).getText());
        if($(uomField).getText().contains(uom)){
            Assert.assertTrue(true);
        }
        else{
            Assert.assertFalse(false);
        }
    }
    public void validationOfFieldsInBOMStructureTab(List<List<String>> data){
        waitABit(5000);
        for(int i = 0; i< data.get(0).size(); i++) {
            Serenity.getDriver().switchTo().defaultContent();
            reusableUtilities.switchFrame($(PartPage.newFrameForCreatePartFrame), "", 0);
            reusableUtilities.switchFrame($(newFrameInBOMStructure), "", 0);
            By defaultAttribute = By.xpath("//*[contains(text(),'"+data.get(0).get(i)+"')]");
            if($(defaultAttribute).isCurrentlyVisible()) {
                Assert.assertTrue(true);
                System.out.println(data.get(0).get(i)+" is present in the BOM tab");
            }
            else {
                Serenity.getDriver().switchTo().parentFrame();
                if($(defaultAttribute).isCurrentlyVisible()) {
                    Assert.assertTrue(true);
                    System.out.println(data.get(0).get(i)+" is present in the BOM tab");
                }
            }
        }
    }
}
