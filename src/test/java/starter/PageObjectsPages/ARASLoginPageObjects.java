package starter.PageObjectsPages;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import starter.PageObjectsPages.nonMBOM.FMS.ParameterTemplatePage;
import starter.Utility.ReusableUtilities;

public class ARASLoginPageObjects extends PageObject {

    public static ReusableUtilities comm = new ReusableUtilities();
    public static By dataBase = By.cssSelector("#Database");
    public static By userID = By.cssSelector("#Username");
    public static By passwordElement = By.cssSelector("#Password");
    public static By loginButton = By.cssSelector("#Login");
    public static By userMenu = By.cssSelector("button[aria-label='Open User Menu']");
    public static By logoutButton = By.xpath("//span[text()='Logout']");
    public static By logoutWithoutSaveButton = By.xpath("//span[@title='Logout without Saving']");
    public static By loginAgain = By.xpath("//span[text()='Login Again']");


    public void Login(String userRole) {
        String databaseField = "";
        String userName = "";
        String password = "";
        if (userRole.equalsIgnoreCase("Admin") || userRole.equalsIgnoreCase("Administrator")) {
            databaseField = "ArasInnovatorMigrationLw";
            userName = "admin";
            password = "innovator";
        } else if (userRole.equalsIgnoreCase("Business Admin") || userRole.equalsIgnoreCase("Sruthi Mukherjee")) {
            databaseField = "Aras db";
            userName = "SM1";
            password = "innovator";
        }else if (userRole.equalsIgnoreCase("summalaraju")) {
            databaseField = "Aras db";
            userName = "summalaraju";
            password = "innovator";
        } else if (userRole.equalsIgnoreCase("MN1") || userRole.equalsIgnoreCase("CLIPP Business ADMIN Development")) {
            databaseField = "Aras db";
            userName = "MN1";
            password = "innovator";
        } else if (userRole.equalsIgnoreCase("Business Admin 2") || userRole.equalsIgnoreCase("BA 2")) {
            databaseField = "ArasInnovatorMigrationLw";
            userName = "BA2";
            password = "innovator";
        } else if (userRole.equalsIgnoreCase("Business Admin 3") || userRole.equalsIgnoreCase("BA 3")) {
            databaseField = "ArasInnovatorMigrationLw";
            userName = "sm1";
            password = "innovator";
        } else if (userRole.equalsIgnoreCase("FMS Business Admin") || userRole.equalsIgnoreCase("ba1")) {
            databaseField = "ArasInnovatorMigrationLw";
            userName = "BA1";
            password = "innovator";
        } else if (userRole.equalsIgnoreCase("Flavor Developer") || userRole.equalsIgnoreCase("Flavour Developer") || userRole.equalsIgnoreCase("FD") || userRole.equalsIgnoreCase("FMS Flavor Developer")) {
            databaseField = "ArasInnovatorMigrationLw";
            userName = "FDK1";
            password = "innovator";
        } else if (userRole.equalsIgnoreCase("Consumable Developer") || userRole.equalsIgnoreCase("CD")) {
            databaseField = "ArasInnovatorMigrationLw";
            userName = "CD1";
            password = "innovator";
        } else if (userRole.equalsIgnoreCase("Flavor Production Centre") || userRole.equalsIgnoreCase("Flavour Production Centre") || userRole.equalsIgnoreCase("FPC") || userRole.equalsIgnoreCase("FMS Flavor Production Centre")) {
            databaseField = "ArasInnovatorMigrationLw";
            userName = "FPCU1";
            password = "innovator";
        } else if (userRole.equalsIgnoreCase("Flavor Production Centre NL") || userRole.equalsIgnoreCase("Flavour Production Centre NL") || userRole.equalsIgnoreCase("FPCB") || userRole.equalsIgnoreCase("FMS Flavor Production Centre NL")) {
            databaseField = "ArasInnovatorMigrationLw";
            userName = "FPCB1";
            password = "innovator";
        } else if (userRole.equalsIgnoreCase("Flavor Business Admin") || userRole.equalsIgnoreCase("FBA")) {
            databaseField = "ArasInnovatorMigrationLw";
            userName = "FBA1";
            password = "innovator";
        } else if (userRole.equalsIgnoreCase("IBM support")) {
            databaseField = "ArasInnovatorMigrationLw";
            userName = "ibmsupport";
            password = "innovator";
        } else if (userRole.equalsIgnoreCase("Flavor Developer Kretek")) {
            databaseField = "ArasInnovatorMigrationLw";
            userName = "fdk1";
            password = "innovator";
        } else if (userRole.equalsIgnoreCase("Flavor Developer Kretek 2")) {
            databaseField = "ArasInnovatorMigrationLw";
            userName = "fdk2";
            password = "innovator";
        } else if (userRole.equalsIgnoreCase("Flavor Developer Non Kretek") || userRole.equalsIgnoreCase("FMS Flavor Developer Non Kretek") || userRole.equalsIgnoreCase("Flavor Developer Non-Kretek") || userRole.equalsIgnoreCase("FMS Flavor Developer Non-Kretek")) {
            databaseField = "ArasInnovatorMigrationLw";
            userName = "fdnk1";
            password = "innovator";
        } else if (userRole.equalsIgnoreCase("Flavor Developer Non Kretek 2")) {
            databaseField = "ArasInnovatorMigrationLw";
            userName = "fdnk2";
            password = "innovator";
        } else if (userRole.equalsIgnoreCase("PMI Flavor Management Approval - Kretek")) {
            databaseField = "ArasInnovatorMigrationLw";
            userName = "fmak1";
            password = "innovator";
        } else if (userRole.equalsIgnoreCase("PMI Flavor Management Approval - Non Kretek")) {
            databaseField = "ArasInnovatorMigrationLw";
            userName = "fmank1";
            password = "innovator";
        } else if (userRole.equalsIgnoreCase("PMI Flavor Compliance & Product Safety Team") || userRole.equalsIgnoreCase("FMS Flavor Compliance & Product Safety Team")) {
            databaseField = "ArasInnovatorMigrationLw";
            userName = "fc1";
            password = "innovator";
        } else if (userRole.equalsIgnoreCase("Flavor Production Center - US")) {
            databaseField = "ArasInnovatorMigrationLw";
            userName = "FPCU1";
            password = "innovator";
        } else if (userRole.equalsIgnoreCase("PMI Flavor Prototyping Lab - Neu") || userRole.equalsIgnoreCase("Flavor Prototyping Lab - Neu") || userRole.equalsIgnoreCase("FMS Flavor Prototyping Lab - Neu")) {
            databaseField = "ArasInnovatorMigrationLw";
            userName = "FPLN1";
            password = "innovator";
        } else if (userRole.equalsIgnoreCase("PMI Flavor Testing Lab") || userRole.equalsIgnoreCase("Flavor Testing Lab") || userRole.equalsIgnoreCase("FMS Testing Lab")) {
            databaseField = "ArasInnovatorMigrationLw";
            userName = "FTL1";
            password = "innovator";
        } else if (userRole.equalsIgnoreCase("FMS MVP")) {
            databaseField = "ArasInnovatorMigrationLw";
            userName = "FM1";
            password = "innovator";
        } else if (userRole.equalsIgnoreCase("Product Developer") || userRole.equalsIgnoreCase("pd2")) {
            databaseField = "ArasInnovatorMigrationLw";
            userName = "PD2";
            password = "innovator";
        } else if (userRole.equalsIgnoreCase("Product Developer 3")) {
            databaseField = "ArasInnovatorMigrationLw";
            userName = "PD3";
            password = "innovator";
        } else if (userRole.equalsIgnoreCase("CLIPP Factory Task Request Originator")) {
            databaseField = "ArasInnovatorMigrationLw";
            userName = "CCFTRO1";
            password = "innovator";
        } else if (userRole.equalsIgnoreCase("CLIPP Factory Task Request Executor")) {
            databaseField = "ArasInnovatorMigrationLw";
            userName = "CCFTRE1";
            password = "innovator";
        } else if (userRole.equalsIgnoreCase("Capgemini user")) {
            databaseField = "ArasInnovatorMigrationLw";
            userName = "cgexecutor1";
            password = "innovator";
        } else if (userRole.equalsIgnoreCase("Method Portfolio Lead")) {
            databaseField = "ArasInnovatorMigrationLw";
            userName = "MP1";
            password = "innovator";
        } else if (userRole.equalsIgnoreCase("CLIPP Business Admin Development") || userRole.equalsIgnoreCase("bd1") || userRole.equalsIgnoreCase("PMI Business Admin Development")) {
            databaseField = "ArasInnovatorMigrationLw";
            userName = "bd1";
            password = "innovator";
        } else if (userRole.equalsIgnoreCase("Packaging Lead")) {
            databaseField = "ArasInnovatorMigrationLw";
            userName = "CCPL1";
            password = "innovator";
        } else if (userRole.equalsIgnoreCase("Packaging Leader")) {
            databaseField = "ArasInnovatorMigrationLw";
            userName = "CCPL1";
            password = "innovator";
        } else if (userRole.equalsIgnoreCase("Packaging Lead 2")) {
            databaseField = "ArasInnovatorMigrationLw";
            userName = "CCPL2";
            password = "innovator";
        } else if (userRole.equalsIgnoreCase("Managing Lead")) {
            databaseField = "ArasInnovatorMigrationLw";
            userName = "CCPM1";
            password = "innovator";
        } else if (userRole.equalsIgnoreCase("CLIPP TEMP Product Transfer PLM to CLIPP for Release 1")) {
            databaseField = "ArasInnovatorMigrationLw";
            userName = "CCTPMR1";
            password = "innovator";
        } else if (userRole.equalsIgnoreCase("iu_productbrief")) {
            databaseField = "ArasInnovatorMigrationLw";
            userName = "iu_productbrief";
            password = "innovator";
        } else if (userRole.equalsIgnoreCase("SM1")) {
            databaseField = "ArasInnovatorMigrationLw";
            userName = "SM1";
            password = "innovator";
        } else if (userRole.equalsIgnoreCase("AB1")) {
            databaseField = "ArasInnovatorMigrationLw";
            userName = "AB1";
            password = "innovator";
        } else if (userRole.equalsIgnoreCase("PD1")) {
            databaseField = "ArasInnovatorMigrationLw";
            userName = "SM1";
            password = "innovator";
        } else if (userRole.equalsIgnoreCase("CSODE19U")) {
            databaseField = "ArasInnovatorMigrationLw";
            userName = "CSODE19U";
            password = "innovator";
        } else if (userRole.equalsIgnoreCase("CSODE19A")) {
            databaseField = "ArasInnovatorMigrationLw";
            userName = "CSODE19A";
            password = "innovator";
        } else if (userRole.equalsIgnoreCase("PMI QCS Contributor")) {
            databaseField = "ArasInnovatorMigrationLw";
            userName = "QCSCCC1";
            password = "innovator";
        } else if (userRole.equalsIgnoreCase("PMI QCS Contributor SFP")) {
            databaseField = "ArasInnovatorMigrationLw";
            userName = "QCSSFPC1";
            password = "innovator";
        } else if (userRole.equalsIgnoreCase("PMI QCS Approver CC")) {
            databaseField = "ArasInnovatorMigrationLw";
            userName = "QCSCCA1";
            password = "innovator";
        } else if (userRole.equalsIgnoreCase("PMI QCS Approver SFP")) {
            databaseField = "ArasInnovatorMigrationLw";
            userName = "QCSSFPA1";
            password = "innovator";
        } else if (userRole.equalsIgnoreCase("PMI QCS Reviewer CC")) {
            databaseField = "ArasInnovatorMigrationLw";
            userName = "QCSCCR1";
            password = "innovator";
        } else if (userRole.equalsIgnoreCase("PMI QCS Reviewer SFP")) {
            databaseField = "ArasInnovatorMigrationLw";
            userName = "QCSSFPR1";
            password = "innovator";
        } else if (userRole.equalsIgnoreCase("NM1")) {
            databaseField = "ArasUATDB4";
            userName = "NM1";
            password = "innovator1";
        } else {
            userName = userRole;
            password = "innovator";
        }
        //$(dataBase).selectByVisibleText(databaseField);
        //comm.performAction("Select",$(dataBase),"");
        comm.conditionalWait("visibility", userID, "Waiting for user name field to be appeared");
        comm.performAction("Text", $(userID), userName);
        comm.performAction("Text", $(passwordElement), password);
        comm.pressEnter(passwordElement);
        waitABit(3000);
        if ($(passwordElement).isCurrentlyVisible()) {
            comm.performAction("Text", $(passwordElement), password);
            comm.pressEnter(passwordElement);
        }
        //comm.performAction("Button",$(loginButton),"");
        comm.conditionalWait("visibility", userMenu, "");
    }

    public void logOutAndLogin() {
        Serenity.getDriver().switchTo().defaultContent();
        if ($(userMenu).isCurrentlyVisible()) {
            comm.performAction("Button", $(userMenu), "");
            comm.conditionalWait("visibility", logoutButton, "");
            comm.performAction("Button", $(logoutButton), "");
            if ($(ParameterTemplatePage.newFrameToSelectState).isPresent()) {
                comm.switchFrame($(ParameterTemplatePage.newFrameToSelectState), "", 0);
                comm.conditionalWait("visibility", logoutWithoutSaveButton, "");
                comm.performAction("Button", $(logoutWithoutSaveButton), "");
                Serenity.getDriver().switchTo().defaultContent();
            }
            comm.performAction("Button", $(loginAgain), "");
            comm.conditionalWait("visibility", userID, "Waiting for user name field to be appeared");
        }
    }

}
