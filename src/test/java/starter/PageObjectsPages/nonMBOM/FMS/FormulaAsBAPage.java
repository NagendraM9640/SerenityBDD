package starter.PageObjectsPages.nonMBOM.FMS;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import starter.Utility.ReusableUtilities;

public class FormulaAsBAPage extends PageObject {

    ReusableUtilities reusableUtilities;

    public void userFillsItemCode(String itemCode){
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(PartPage.newFrameForCreatePartFrame), "", 0);
        reusableUtilities.switchFrame($(PartPage.newFrameForCreatePartFrameDataEntry), "", 0);
        $(PartPage.itemCode).sendKeys(itemCode);
    }
}