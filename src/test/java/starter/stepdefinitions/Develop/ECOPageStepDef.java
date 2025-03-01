package starter.stepdefinitions.Develop;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.Serenity;
import org.checkerframework.checker.units.qual.C;
import starter.PageObjectsPages.Develop.ItemCodeStore;
import starter.SerenitySteps.Develop.ECOPageSteps;
import starter.SerenitySteps.Develop.PartSteps;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

public class ECOPageStepDef {
    @Steps
    ECOPageSteps ecoPageSteps;
    @Steps
    PartSteps partSteps;

    @And("User should fill all the mandatory fields in ECO {string},{string},{string},{string}")
    public void userShouldFillAllTheMandatoryFieldsInECO(String arg0, String arg1, String arg2, String arg3) throws InterruptedException {
        ecoPageSteps.userShouldFillAllTheMandatoryFieldsInECO(arg0, arg1, arg2, arg3);
    }

    @When("Select the {string} and click on save")
    public void selectTheAndClickOnSave(String changeDrivers) {
        ecoPageSteps.selectTheAndClickOnSave(changeDrivers);
    }

    @And("Select the valid Purpose value from the Part{string} and click on save")
    public void selectTheValidPurposeValueFromThePartAndClickOnSave(String purpose) {
        ecoPageSteps.selectTheValidPurposeValueFromThePartAndClickOnSave(purpose);
    }

    @And("User should enter the E-Signature")
    public void userShouldEnterTheESignature() {
        ecoPageSteps.userShouldEnterTheEsignature();
    }

    @And("User should search and open the newly created ECO {string}")
    public void userShouldSearchAndOpenTheNewlyCreatedECO(String ecoNumber) {
        String uniqueCode = ItemCodeStore.getUniqueCode(ecoNumber);
        if (uniqueCode == null) {
            ecoPageSteps.searchECOItemsFromSearchSection(ecoNumber);
        } else {
            ecoPageSteps.searchECOItemsFromSearchSection(uniqueCode);
        }
        System.out.println(uniqueCode + "ECO Item Code");

    }

    @When("User opens the part request from the affected items {string}")
    public void userOpensThePartRequestFromTheAffectedItems(String partNum) throws InterruptedException {
        String uniqueCode = ItemCodeStore.getUniqueCode(partNum);
        if (uniqueCode == null) {
            ecoPageSteps.userOpensPartFromAffectedItems(partNum);
        } else {
            ecoPageSteps.userOpensPartFromAffectedItems(uniqueCode);
        }
    }


    @When("User fill all mandatory fields {string},{string},{string},{string} in ECO and click on save")
    public void userFillAllMandatoryFieldsInECOAndClickOnSave(String arg0, String arg1, String arg2, String arg3) {
        ecoPageSteps.userFillAllMandatoryFieldsInECOAndClickOnSave(arg0, arg1, arg2, arg3);
    }

    @Then("Validate Below mentioned error message should be displayed in ECO WorkFlow Activity")
    public void validateBelowMentionedErrorMessageShouldBeDisplayedInECOWorkFlowActivity(DataTable dataTable) throws InterruptedException {
        List<List<String>> data = dataTable.asLists();
        partSteps.validateErrorMessage(data);
        Thread.sleep(4000);
        ecoPageSteps.closeTheECOWorkFlowActivityCompletionPopup();
    }

    @And("User should be able to see Vote Now button and clicks on it")
    public void userShouldBeAbleToSeeVoteNowButtonAndClicksOnIt() throws InterruptedException {
        ecoPageSteps.voteNowButton();
    }

    @Then("Workflow Activity Completion window should be loaded")
    public void workflowActivityCompletionWindowShouldBeLoaded() throws InterruptedException {
        ecoPageSteps.validateWorkflowWindow();
    }

    @When("From the vote dropdown user selects (.*)$")
    public void fromTheVoteDropdownUserSelectsStartWork(String s) throws InterruptedException {
        ecoPageSteps.userSelectsSendToReviewVoteList(s);
    }

    @When("User should clicks Complete button")
    public void userShouldClicksCompleteButton() throws InterruptedException {
        ecoPageSteps.userClicksCompleteButton();
    }

    @Then("Object workflow status should be changed to (.*)$")
    public void objectWorkflowStatusShouldBeChangedToInWork(String s) throws InterruptedException {
        //ecoPageSteps.validateWorkFlowStatus(s);
    }

    @And("User should selects target lifecycle as (.*)$")
    public void userShouldSelectsTargetLifecycleAsReleased(String targetLifecycle) throws InterruptedException {
        Thread.sleep(10000);
          //ecoPageSteps.userSelectsTargetLifecycle(targetLifecycle);
//        ItemCodeStore.addUniqueCode("targetLifeCycle", targetLifecycle);
    }

    @Then("User fill all mandatory fields {string},{string},{string} and {string} in ECO and click on save")
    public void userFillAllMandatoryFieldsAndInECOAndClickOnSave(String arg0, String arg1, String arg2, String arg3) {
    }

    @When("User fill all mandatory fields {string},{string},{string},{string} in the ECO")
    public void userFillAllMandatoryFieldsInTheECO(String title, String desc, String purpose, String ChangeDrivers) {
        ecoPageSteps.userFillAllMandatoryFieldsInTheECO(title, desc, purpose, ChangeDrivers);
    }

    @And("User should select the Owner Approval checkbox")
    public void userShouldSelectTheOwnerApprovalCheckbox() throws InterruptedException {
        partSteps.editTheForm();
        Thread.sleep(4000);
        ecoPageSteps.userShouldSelectTheOwnerApprovalCheckbox();
    }

    @And("User should selects child target lifecycle as (.*)$")
    public void userShouldSelectsChildTargetLifecycleAsReleased(String targetLifecycle) throws InterruptedException {
        ecoPageSteps.updateTheChildPartsLifecycle(targetLifecycle);
    }

    @When("User should opens new draft part from affected items {string}")
    public void userShouldOpensNewDraftPartFromAffectedItems(String itemCode) {
        ecoPageSteps.userOpensPartFromAffectedItems(itemCode);
    }

    @And("User should complete the SignOff process of ECO")
    public void userShouldCompleteTheSignOffProcessOfECO() throws InterruptedException {
        //ecoPageSteps.userShouldCompleteTheSignOffProcessOfECO();
    }

    @And("User should select exclude validations on (.*)$")
    public void userShouldSelectExcludeValidationsOnParameterValidation(String excludeValidations) {
        ecoPageSteps.userShouldSelectExcludeValidationsOnParameterValidation(excludeValidations);
    }

    @And("The parameter {string} should be filled with values in the {string} column")
    public void theParameterShouldBeFilledWithValuesInTheColumn(String paramNum, String fieldName) {
        ecoPageSteps.theParameterShouldBeFilledWithValuesInTheColumn(paramNum, fieldName);
    }

    @And("User should search and open Product variant based on the {string},{string}, {string} and {string}")
    public void userShouldSearchAndOpenProductVariantBasedOnTheAnd(String pvNum, String lifeCycle, String migrationCategory, String productCategory) {
        ecoPageSteps.userShouldSearchAndOpenProductVariantBasedOnTheAnd(pvNum, lifeCycle,migrationCategory,productCategory);
    }

    @And("User should add PV, SP, GP in affected items")
    public void userShouldAddPVSPGPInAffectedItems() {
        ecoPageSteps.userShouldAddPVSPGPInAffectedItems();
    }

    @And("User sets new lifecycle of PV, SP, GP is Released")
    public void userSetsNewLifecycleOfPVSPGPIsReleased() {
        ecoPageSteps.userSetsNewLifecycleOfPVSPGPIsReleased();
    }

    @And("User should select the SFP Reason For Change as (.*)$")
    public void userShouldSelectTheSFPReasonForChange(String sfpReason) {
        ecoPageSteps.userShouldSelectTheSFPReasonForChange(sfpReason);
    }
}