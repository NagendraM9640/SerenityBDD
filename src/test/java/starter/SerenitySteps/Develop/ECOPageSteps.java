package starter.SerenitySteps.Develop;

import net.serenitybdd.annotations.Step;
import starter.PageObjectsPages.Develop.ECOPartParameterValidationsPage;
import starter.PageObjectsPages.Develop.EcoPage;
import starter.PageObjectsPages.Develop.ItemCodeStore;

public class ECOPageSteps {

    EcoPage ecoPage = new EcoPage();
    ECOPartParameterValidationsPage partParameterValidationsPage = new ECOPartParameterValidationsPage();

    @Step
    public void userShouldFillAllTheMandatoryFieldsInECO(String title, String changeDescText, String purpose, String changeDrivers) {
        ecoPage.userShouldFillAllTheMandatoryFieldsInECO(title, changeDescText, purpose, changeDrivers);
    }

    @Step
    public void selectTheAndClickOnSave(String changeDrivers) {
        ecoPage.selectTheAndClickOnSave(changeDrivers);
    }

    @Step
    public void selectTheValidPurposeValueFromThePartAndClickOnSave(String purpose) {
        ecoPage.selectTheValidPurposeValueFromThePartAndClickOnSave(purpose);
    }

    @Step
    public void userShouldSelectExcludeValidationsOnParameterValidation(String excludeValidations) {
        ecoPage.userShouldSelectExcludeValidationsOnParameterValidation(excludeValidations);
    }

    @Step
    public void userFillAllMandatoryFieldsInECOAndClickOnSave(String title, String desc, String purpose, String changeDrivers) {
        ecoPage.userFillAllMandatoryFieldsInECOAndClickOnSave(title, desc, purpose, changeDrivers);
    }

    @Step
    public void userShouldEnterTheEsignature() {
        ecoPage.userShouldEnterTheEsignature();
    }

    @Step
    public void searchECOItemsFromSearchSection(String itemCode) {
        ecoPage.searchECOItemsFromSearchSection(itemCode);
    }

    @Step("User opened the part from the affected items is: {0}")
    public void userOpensPartFromAffectedItems(String itemCode) {
        ecoPage.userOpensPartFromAffectedItems(itemCode);
    }

    @Step
    public void closeTheECOWorkFlowActivityCompletionPopup() {
        ecoPage.closeTheECOWorkFlowActivityCompletionPopup();
    }

    @Step
    public void voteNowButton() {
        ecoPage.voteNowButton();
    }

    @Step
    public void validateWorkflowWindow() {
        ecoPage.validateWorkflowWindow();
    }

    @Step
    public void userSelectsSendToReviewVoteList(String s) {
        ecoPage.userSelectsSendToReviewVoteList(s);
    }

    @Step
    public void userClicksCompleteButton() {
        ecoPage.userClicksCompleteButton();
    }

    @Step
    public void validateWorkFlowStatus(String s) {
        ecoPage.validateWorkFlowStatus(s);
    }

    @Step
    public void userSelectsTargetLifecycle(String targetLifecycle) {
        ecoPage.userSelectsTargetLifecycle(targetLifecycle);
    }

    @Step
    public void userFillAllMandatoryFieldsInTheECO(String title, String desc, String purpose, String ChangeDrivers) {
        ecoPage.userFillAllMandatoryFieldsInTheECO(title, desc, purpose, ChangeDrivers);
    }

    @Step
    public void userShouldSelectTheOwnerApprovalCheckbox() {
        ecoPage.userShouldSelectTheOwnerApprovalCheckbox();
    }

    @Step
    public void updateTheChildPartsLifecycle(String targetLifecycle) {
        ecoPage.updateTheChildPartsLifecycle(targetLifecycle);
    }

    @Step("Completing the ECO sign-off process")
    public void userShouldCompleteTheSignOffProcessOfECO() {
        ecoPage.userShouldCompleteTheSignOffProcessOfECO();
    }


    @Step
    public void theParameterShouldBeFilledWithValuesInTheColumn(String paramNum, String fieldName) {
        partParameterValidationsPage.theParameterShouldBeFilledWithValueAndItsDataTypeShouldBe(paramNum, fieldName);
    }

    @Step
    public void userShouldSearchAndOpenProductVariantBasedOnTheAnd(String pv, String lifeCycle, String migrationCategory, String productCategory) {
        ecoPage.userShouldSearchAndOpenProductVariantBasedOnTheAnd(pv, lifeCycle, migrationCategory, productCategory);
    }

    @Step
    public void userShouldAddPVSPGPInAffectedItems() {
        ecoPage.userShouldAddPVSPGPInAffectedItems();
    }

    @Step
    public void userSetsNewLifecycleOfPVSPGPIsReleased() {
        ecoPage.userShouldAddPVSPGPInAffectedItems();
    }
    @Step
    public void userShouldSelectTheSFPReasonForChange(String sfpReason) {
        ecoPage.userShouldSelectTheSFPReasonForChange(sfpReason);
    }
}