package starter.SerenitySteps.Develop;

import net.serenitybdd.annotations.Step;
import starter.PageObjectsPages.Develop.PartPageDev;

import java.util.List;

public class PartSteps {

    PartPageDev partPage;


    @Step
    public void userTriesToUpdate(String newSubFamily, String newProductGroup, String newTechnologyPlateForms) {
        partPage.userTriesToUpdate(newSubFamily, newProductGroup, newTechnologyPlateForms);
    }

    @Step
    public void validatingUpdatedData(String newSubFamily, String newProductGroup, String newTechnologyPlateForms) {
        partPage.validatingUpdatedData(newSubFamily, newProductGroup, newTechnologyPlateForms);
    }

    @Step
    public void userClicksOnAddItemSToChange() throws InterruptedException {
        partPage.userClicksOnAddItemSToChange();
        Thread.sleep(4000);
        partPage.closeTheFirstOpenedTab();
    }


    @Step
    public void userSearchesWithItemCode(String itemCode) {
        partPage.userSearchesWithItemCode(itemCode);
    }


    @Step
    public void userShouldFillAllTheFieldsInThePartFormAndClickOnSaveAnd(String subFamily, String purpose, String productGroup, String intendedTechnologyPlatform) {
        partPage.userShouldFillAllTheFieldsInThePartFormAndClickOnSaveAnd(subFamily, purpose, productGroup, intendedTechnologyPlatform);
    }

    @Step
    public void userShouldAddBOMElementsToThePart() {
        partPage.userShouldAddBOMElementsToThePart();
    }

    @Step
    public void userShouldDeleteAllTheVersionsOfThePart() {
        partPage.userDeleteAllTheVersionsOfPart();
    }

    @Step
    public void userSelectsItemTypeUnderThePartTree(String itemType) {
        partPage.selectingTheItemType(itemType);
    }

    @Step
    public void itemTypeFieldValidation(String itemType) {
        partPage.itemTypeFieldValidation(itemType);
    }

    @Step
    public void validateErrorMessage(List<List<String>> data) {
        partPage.validateErrorMessage(data);
    }

    @Step
    public void userClicksOnTab(String tabName) {
        partPage.userClicksOnTab(tabName);
    }

    @Step
    public String theFormShouldBeSavedAndGotCreatedWithAnUniqueCode(String example) {
        return partPage.fetchingItemCode();
    }

    @Step
    public void validationOfStatus(String lifecycleStatus) {
        partPage.validationOfStatus(lifecycleStatus);
    }

    @Step
    public void decreaseTheZoomOfApplication(double zoomLevel) {
        partPage.setZoomLevel(zoomLevel);
    }

    @Step
    public void validateRevisionField(String revision) {
        partPage.validateRevisionField(revision);
    }

    @Step
    public void editTheForm() {
        partPage.editTheForm();
    }

    @Step
    public void userShouldAddTheRequiredBomElements(String bomCode) {
        partPage.userShouldAddTheRequiredBomElements(bomCode);
    }

    @Step
    public void choosesTheActionCreateConsumableFromReferenceConsumableFromTheMoreActionMenu() {
        partPage.choosesTheActionCreateConsumableFromReferenceConsumableFromTheMoreActionMenu();
    }

    @Step
    public void aNewPartFormShouldOpenAndTheUserClicksDone(String itemTypeName) {
        partPage.aNewPartFormShouldOpenAndTheUserClicksDone(itemTypeName);
    }

    @Step
    public void populateTheReferenceCodeAttributeOfTheConsumablesPartWithTheReferenceConsumableItemCode(String RCSItemCode) {
        partPage.populateTheReferenceCodeAttributeOfTheConsumablesPartWithTheReferenceConsumableItemCode(RCSItemCode);
    }

    @Step
    public void userShouldFillAllTheFieldsInTheRCSPartFormAndClickOnSaveAnd(String subFamily, String purpose, String productGroup, String intendedTechnologyPlatform) {
        partPage.userShouldFillAllTheFieldsInTheRCSPartFormAndClickOnSaveAnd(subFamily, purpose, productGroup, intendedTechnologyPlatform);
    }

    @Step
    public void systemShouldCopyAndDisplayAllTheAttributesAndRelationshipTabsDataFromReferenceConsumableRCSInConsumableCOS() {
        partPage.systemShouldCopyAndDisplayAllTheAttributesAndRelationshipTabsDataFromReferenceConsumableRCSInConsumableCOS();
    }

    @Step
    public void theParameterShouldBeFilledWithValueAndItsDataTypeShouldBe(String parameterNumber, String parameterValue, String dataType) {
        partPage.theParameterShouldBeFilledWithValueAndItsDataTypeShouldBe(parameterNumber, parameterValue, dataType);
    }

    @Step
    public void theBOMMustContainTheParentItem(String BOMNumber) {
        partPage.theBOMMustContainTheParentItem(BOMNumber);
    }

    @Step
    public void thePackedItemsMustBeReleasedAutomaticallyWithASystemGeneratedECO() {
        partPage.thePackedItemsMustBeReleasedAutomaticallyWithASystemGeneratedECO();
    }

    @Step
    public void userSearchesWithItemCodeForPackedItems(String itemCode) {
        partPage.userSearchesWithItemCodeForPackedItems(itemCode);
    }

    @Step
    public void theSystemMustAutomaticallyCreatePackedItemsWithAnd(String itemCode, String itemType, String subFamily) {
        partPage.theSystemMustAutomaticallyCreatePackedItemsWithAnd(itemCode,itemType,subFamily);
    }

        @Step
    public void theUserSearchesForThePartsAndClicksOnSaveAs(String itemCode) {
        partPage.theUserSearchesForThePartsAndClicksOnSaveAs(itemCode);
    }

    @Step
    public void thePopUpIsDisplayedAndTheUserClicksOnTheConfirmButton(String expectedTitle) {
        partPage.thePopUpIsDisplayedAndTheUserClicksOnTheConfirmButton(expectedTitle);
    }

    @Step
    public void clickOnSave() {
        partPage.clickOnSave();
    }

    @Step
    public void theUserAddsOrUpdatesTheQuantityAndUOMValuesForTheBOMElementsAsQuantityUOM(String quantity, String UOM) {
        partPage.theUserAddsOrUpdatesTheQuantityAndUOMValuesForTheBOMElementsAsQuantityUOM(quantity,UOM);
    }

    @Step
    public void theUserShouldRemoveTheExistingBOMElementsAndThenAddTheSameBOMElementsAgain() {
        partPage.theUserShouldRemoveTheExistingBOMElementsAndThenAddTheSameBOMElementsAgain();
    }

    @Step
    public void theBOMElementsShouldHaveARevisionOfAndShouldBeInTheState(String revision, String state) {
        partPage.theBOMElementsShouldHaveARevisionOfAndShouldBeInTheState(revision,state);
    }
    @Step("User is added {0} item code to the Reference code field")
    public void userShouldAddRCMOrRCSToTheReferenceCodeField(String itemCode) {
        partPage.userShouldAddRCMOrRCSToTheReferenceCodeField(itemCode);
    }

    @Step("The user searches for and opens the part {0} from the search results")
    public void userShouldSearchAndOpenThePartFromSearchPage(String arg0) {
        partPage.userShouldSearchAndOpenThePartFromSearchPage(arg0);
    }

    }