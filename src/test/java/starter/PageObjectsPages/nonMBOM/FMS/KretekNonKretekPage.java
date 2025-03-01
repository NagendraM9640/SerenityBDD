package starter.PageObjectsPages.nonMBOM.FMS;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import starter.Utility.ReusableUtilities;

public class KretekNonKretekPage extends PageObject {

    public static By kretek = By.xpath("(//select[@name='pmi_flav_appl']//option)[1]");
    public static By nonKretek = By.xpath("(//select[@name='pmi_flav_appl']//option)[2]");

    ReusableUtilities reusableUtilities;

    public void selectingKretekAndNonKretek(){
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.switchFrame($(PartPage.newFrameForCreatePartFrame), "", 0);
        reusableUtilities.switchFrame($(PartPage.newFrameForCreatePartFrameDataEntry), "", 0);
        $(kretek).click();
        waitABit(1000);
        reusableUtilities.pressShiftDown();
        waitABit(2000);
    }
}