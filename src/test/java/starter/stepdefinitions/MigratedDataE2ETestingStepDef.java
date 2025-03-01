package starter.stepdefinitions;

import io.cucumber.java.en.*;
import net.serenitybdd.annotations.Steps;
import starter.SerenitySteps.MigratedDataE2ETestingSteps;

import java.io.IOException;

public class MigratedDataE2ETestingStepDef {

    @Steps
    MigratedDataE2ETestingSteps migratedDataE2ETestingSteps;

    @Then("User searches for migrated Parts and release it")
    public void userSearchesForMigratedDataAndReleaseIt() throws Exception {
        //migratedDataE2ETestingSteps.userSearchesForMigratePartsAndReleaseIt();
       Thread.sleep(6000);
    }

    @Then("User searches for migrated PV, GP, SP and release it")
    public void userSearchesForMigratedPVGPSPAndReleaseIt() throws Exception {
        migratedDataE2ETestingSteps.userSearchesForMigratedPVAndReleaseIt();
    }
    @And("Search all the parts based on the excel file and store it")
    public void searchAllThePartsBasedOnTheExcelFileAndStoreIt() throws Exception {
        migratedDataE2ETestingSteps.massPartsReleased();    }

    @Then("Add all parts one ECO and Release it")
    public void addAllPartsOneECOAndReleaseIt() throws Exception {
        migratedDataE2ETestingSteps.searchForAllPartsAndAddItOneECOAndReleaseIt();
    }

    @And("takescreenshots")
    public void takescreenshots() throws IOException {
        migratedDataE2ETestingSteps.takescreenshots("");
    }

    @Then("Search for the released migrated parts and change the lifecycle status of the parts to Obsolete")
    public void searchForTheReleasedMigratedPartsAndChangeTheLifecycleStatusOfThePartsToObsolete() throws Exception {
        migratedDataE2ETestingSteps.changeLifecycleForMigratedPartItemsFromReleasedToObsolete();
    }

    @Then("User searches for migrated Parts perform save as and release it")
    public void userSearchesForMigratedPartsPerformSaveAsAndReleaseIt() throws Exception {
        migratedDataE2ETestingSteps.userSearchesForMigratePartsAndPerformSaveAsAndReleaseIt();
    }

    @And("takescreenshots {string}")
    public void takescreenshots(String arg0) throws IOException {
        migratedDataE2ETestingSteps.takescreenshots(arg0);
    }

    @And("Search for all the parts based on the excel file add it one ECO and Release it")
    public void searchForAllThePartsBasedOnTheExcelFileAddItOneECOAndReleaseIt() throws Exception {
        migratedDataE2ETestingSteps.searchForAllThePartsBasedOnTheExcelFileAddItOneECOAndReleaseIt();
    }

    @Then("User searches for ECO and continue SingOff Process {string}")
    public void userSearchesForECOAndContinueSingOffProcess(String ecoNumber) throws Exception {
        migratedDataE2ETestingSteps.re_RunTheECOProcess(ecoNumber);
    }

    @And("add all the mSpec based on the excel file add it one MCO and Release it")
    public void addAllTheMSpecBasedOnTheExcelFileAddItOneMCOAndReleaseIt() {
    }

    @And("search with mSpec item code and fetch eBOM Revision and store it")
    public void searchWithMSpecItemCodeAndFetchEBOMRevisionAndStoreIt() throws Exception {
        migratedDataE2ETestingSteps.addAllTheMSpecBasedOnTheExcelFileAddItOneMCOAndReleaseIt();
    }
}
