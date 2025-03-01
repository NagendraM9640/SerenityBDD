package starter.stepdefinitions.Develop;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.Serenity;
import starter.PageObjectsPages.Develop.ItemCodeStore;
import starter.SerenitySteps.ArasLoginPageSteps;
import starter.SerenitySteps.Develop.PartSteps;
import starter.SerenitySteps.HomePageStep;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

public class PartStepDef {

    @Steps
    PartSteps partSteps;


    @Steps
    public static ArasLoginPageSteps loginSteps = new ArasLoginPageSteps();

    @Steps
    HomePageStep home;

    @When("User clicks on Add Item\\(s) To Change from menu")
    public void userClicksOnAddItemSToChangeFromMenu() throws InterruptedException {
        partSteps.userClicksOnAddItemSToChange();
    }

    @And("User should fill all the fields in the part form and click on save {string},{string},{string} and {string}")
    public void userShouldFillAllTheFieldsInThePartFormAndClickOnSaveAnd(String subFamily, String purpose, String productGroup, String intendedTechnologyPlatform) {
        partSteps.userShouldFillAllTheFieldsInThePartFormAndClickOnSaveAnd(subFamily, purpose, productGroup, intendedTechnologyPlatform);
    }


    @And("User tries to edit with itemDescription, AdditionalDescription, {string},{string} and {string}")
    public void userTriesToEditWithItemDescriptionAdditionalDescriptionAnd(String newSubFamily, String newProductGroup, String newTechnologyPlateForms) {
        partSteps.userTriesToUpdate(newSubFamily, newProductGroup, newTechnologyPlateForms);
    }

    @Then("ItemDescription, AdditionalDescription and {string},{string},{string} should be updated and saved successfully")
    public void itemdescriptionAdditionalDescriptionAndShouldBeUpdatedAndSavedSuccessfully(String newSubFamily, String newProductGroup, String newTechnologyPlateForms) {
        partSteps.validatingUpdatedData(newSubFamily, newProductGroup, newTechnologyPlateForms);
    }

    @Then("User should search and open newly created Part from search page {string}")
    public void userShouldSearchAndOpenNewlyCreatedPartFromSearchPage(String itemCode) {
        String uniqueCode = ItemCodeStore.getUniqueCode(itemCode);
        if (uniqueCode == null) {
            partSteps.userSearchesWithItemCode(itemCode);
        } else {
            partSteps.userSearchesWithItemCode(uniqueCode);
            System.out.println(uniqueCode + "Part Item Code");
            Serenity.reportThat(itemCode + ":" + uniqueCode, () -> assertThat(itemCode + uniqueCode, true));
        }
    }

    @And("User should Delete all the versions of the part")
    public void userShouldDeleteAllTheVersionsOfThePart() {
        partSteps.userShouldDeleteAllTheVersionsOfThePart();
    }

    @And("User selects ItemType {string} under the Part tree")
    public void userSelectsItemTypeUnderThePartTree(String itemType) {
        partSteps.userSelectsItemTypeUnderThePartTree(itemType);
    }

    @Then("A new screen will open pre-filled with {string} and the field will be uneditable")
    public void aNewScreenWillOpenPreFilledWithAndTheFieldWillBeUneditable(String itemType) {
        partSteps.itemTypeFieldValidation(itemType);
    }

//    @And("Validate Below mentioned Attributes are available for the Part form")
//    public void validateBelowMentionedAttributesAreAvailableForThePartForm(io.cucumber.datatable.DataTable dataTable) {
//        qcsSteps.validateAttributes(dataTable.transpose().asList(String.class));
//    }
//
//    @And("Validate Below mentioned tabs should be present Part relationship segment")
//    public void validateBelowMentionedTabsShouldBePresentPartRelationshipSegment(DataTable dataTable) {
//        List<List<String>> data = dataTable.asLists();
//        referenceMethodSteps.validateTheRelationshipTabs(data);
//    }

    @And("Validate Below mentioned error message should be displayed")
    public void validateBelowMentionedErrorMessageShouldBeDisplayed(DataTable dataTable) {
        List<List<String>> data = dataTable.asLists();
        partSteps.validateErrorMessage(data);
    }

    @When("User should clicks on tab (.*)$")
    public void userShouldClicksOnTabBOM(String tabName) throws InterruptedException {
        partSteps.userClicksOnTab(tabName);
    }

    @Then("The form should be saved and got created with an unique Code {string}")
    public void theFormShouldBeSavedAndGotCreatedWithAnUniqueCode(String example) throws InterruptedException {
        String uniqueCode = partSteps.theFormShouldBeSavedAndGotCreatedWithAnUniqueCode(example);
        ItemCodeStore.addUniqueCode(example, uniqueCode);
    }

    @And("ItemType lifecycle should be (.*)$")
    public void itemtypeLifecycleShouldBe(String lifecycle) {
        partSteps.validationOfStatus(lifecycle);
    }

    @And("ItemType revision should be populated as (.*)$")
    public void itemtypeRevisionShouldBePopulatedAs(String rev) {
        partSteps.validateRevisionField(rev);
    }

    @And("User should edits the form")
    public void userShouldEditsTheForm() {
        partSteps.editTheForm();
    }

    @Then("User should add required bom elements to the BOM tab")
    public void userShouldAddRequiredBomElementsToTheBOMTab() {
        partSteps.userShouldAddBOMElementsToThePart();
    }

    @And("User should add the required bom elements {string}")
    public void userShouldAddTheRequiredBomElements(String bomNumber) {
        String uniqueCode = ItemCodeStore.getUniqueCode(bomNumber);
        System.out.println(uniqueCode + "BOM Item Code");
        Serenity.reportThat(bomNumber + ":" + uniqueCode, () -> assertThat(bomNumber + uniqueCode, true));
        partSteps.userShouldAddTheRequiredBomElements(uniqueCode);

    }

    @When("Chooses the action Create Consumable from Reference Consumable from the more action menu")
    public void choosesTheActionCreateConsumableFromReferenceConsumableFromTheMoreActionMenu() {
        partSteps.choosesTheActionCreateConsumableFromReferenceConsumableFromTheMoreActionMenu();
    }

    @And("A new {string} part form should open, and the User clicks Done")
    public void aNewPartFormShouldOpenAndTheUserClicksDone(String itemTypeName) {
        partSteps.aNewPartFormShouldOpenAndTheUserClicksDone(itemTypeName);
    }

    @Then("System should copy and display all the attributes and relationship tabs data from Reference Consumable - RCS in Consumable - COS")
    public void systemShouldCopyAndDisplayAllTheAttributesAndRelationshipTabsDataFromReferenceConsumableRCSInConsumableCOS() {
        partSteps.systemShouldCopyAndDisplayAllTheAttributesAndRelationshipTabsDataFromReferenceConsumableRCSInConsumableCOS();
    }

    @And("User should fill all the fields in the RCS part form and click on save {string},{string},{string} and {string}")
    public void userShouldFillAllTheFieldsInTheRCSPartFormAndClickOnSaveAnd(String subFamily, String purpose, String productGroup, String intendedTechnologyPlatform) {
        partSteps.userShouldFillAllTheFieldsInTheRCSPartFormAndClickOnSaveAnd(subFamily, purpose, productGroup, intendedTechnologyPlatform);
    }

    @And("The Item code for the Reference Consumable - RCS Part should be shown in the Reference Code field for the Consumable - COS Part {string}")
    public void theItemCodeForTheReferenceConsumableRCSPartShouldBeShownInTheReferenceCodeFieldForTheConsumableCOSPart(String RCSItemCode) {
        String uniqueCode = ItemCodeStore.getUniqueCode(RCSItemCode);
        System.out.println(uniqueCode + "RCS Item Code");
        Serenity.reportThat(RCSItemCode + ":" + uniqueCode, () -> assertThat(RCSItemCode + uniqueCode, true));
        partSteps.populateTheReferenceCodeAttributeOfTheConsumablesPartWithTheReferenceConsumableItemCode(uniqueCode);
    }

    @And("The parameter {string} should be filled with {string} value in the {string} column")
    public void theParameterShouldBeFilledWithValueInTheColumn(String parameterNumber, String value, String dataType) {
        partSteps.theParameterShouldBeFilledWithValueAndItsDataTypeShouldBe(parameterNumber, value, dataType);
    }

    @When("The Part reaches {string} lifecycle with the release of the ECO")
    public void thePartReachesLifecycleWithTheReleaseOfTheECO(String lifecycle) throws InterruptedException {
        partSteps.validationOfStatus(lifecycle);
    }

    @Then("The system must automatically create packed items with: {string},{string} and {string}")
    public void theSystemMustAutomaticallyCreatePackedItemsWithAnd(String itemCode, String itemType, String subFamily) {
//        String uniqueCode = ItemCodeStore.getUniqueCode(itemCode);
//        if(uniqueCode == null) {
//            partSteps.theSystemMustAutomaticallyCreatePackedItemsWithAnd(itemCode, itemType, subFamily);
//        } else {
//            partSteps.theSystemMustAutomaticallyCreatePackedItemsWithAnd(uniqueCode, itemType, subFamily);
//        }
    }

    public static String packedItems(String parentItemCode, String suffixes) {
        String[] suffixArray = suffixes.split(",");
        StringBuilder finalString = new StringBuilder();
        for (String suffix : suffixArray) {
            if (finalString.length() > 0) {
                finalString.append("|");
            }
            finalString.append(parentItemCode).append(suffix.trim());
        }
        System.out.println(finalString.toString());
        return finalString.toString();
    }


    @And("The lifecycles of the packed items must be aligned with the parent part lifecycle as (.*)$")
    public void theLifecyclesOfThePackedItemsMustBeAlignedWithTheParentPartLifecycleAsUnderVerification(String expectedLifecycle) {
        //partSteps.validationOfStatus(expectedLifecycle);
    }

    @And("The BOM must contain the parent item {string}")
    public void theBOMMustContainTheParentItem(String itemCode) {
//        String parentItemCode = ItemCodeStore.getUniqueCode(itemCode);
//        if(parentItemCode == null) {
//            partSteps.theBOMMustContainTheParentItem(itemCode);
//        } else {
//            partSteps.theBOMMustContainTheParentItem(parentItemCode);
//        }

    }

    @And("The packed items must be released automatically with a system-generated ECO")
    public void thePackedItemsMustBeReleasedAutomaticallyWithASystemGeneratedECO() {
//        partSteps.thePackedItemsMustBeReleasedAutomaticallyWithASystemGeneratedECO();
    }


    @And("The user searches for the parts and clicks on Save As {string}")
    public void theUserSearchesForThePartsAndClicksOnSaveAs(String itemCode) {
        partSteps.theUserSearchesForThePartsAndClicksOnSaveAs(itemCode);
        Serenity.reportThat("ParentItemCode: " + itemCode + ":" + itemCode, () -> assertThat(itemCode + itemCode, true));
    }

    @Then("After clicking on Save a new part is created based on the parent part with a unique code {string}")
    public void afterClickingOnSaveANewPartIsCreatedBasedOnTheParentPartWithAUniqueCode(String example) {
        partSteps.clickOnSave();
        String uniqueCode = partSteps.theFormShouldBeSavedAndGotCreatedWithAnUniqueCode(example);
        System.out.println(uniqueCode + " : Item Code");
        ItemCodeStore.addUniqueCode(example, uniqueCode);
        Serenity.reportThat(example + ":" + uniqueCode, () -> assertThat(example + ":" + uniqueCode, true));
        System.out.println(ItemCodeStore.getUniqueCode(example) + " : Stored Item Code");
    }

    @And("The {string} pop-up is displayed and the user clicks on the confirm button")
    public void thePopUpIsDisplayedAndTheUserClicksOnTheConfirmButton(String arg0) {
        partSteps.thePopUpIsDisplayedAndTheUserClicksOnTheConfirmButton(arg0);
    }

    @And("The user adds or updates the quantity and UOM values for the BOM elements as {string}, {string}")
    public void theUserAddsOrUpdatesTheQuantityAndUOMValuesForTheBOMElementsAsQuantityUOM(String quantity, String UOM) {
        partSteps.theUserAddsOrUpdatesTheQuantityAndUOMValuesForTheBOMElementsAsQuantityUOM(quantity, UOM);
    }

    @And("The user should remove the existing BOM elements and then add the same BOM elements again")
    public void theUserShouldRemoveTheExistingBOMElementsAndThenAddTheSameBOMElementsAgain() throws InterruptedException {
        partSteps.theUserShouldRemoveTheExistingBOMElementsAndThenAddTheSameBOMElementsAgain();
    }

    @And("The BOM elements should have a revision of {string} and should be in the {string} state")
    public void theBOMElementsShouldHaveARevisionOfAndShouldBeInTheState(String revision, String state) throws InterruptedException {
        partSteps.theBOMElementsShouldHaveARevisionOfAndShouldBeInTheState(revision, state);
    }

    @And("User should add RCM or RCS to the Reference code field {string}")
    public void userShouldAddRCMOrRCSToTheReferenceCodeField(String itemCodeVariable) {
        String uniqueCode = ItemCodeStore.getUniqueCode(itemCodeVariable);
        System.out.println(uniqueCode + "-->" + itemCodeVariable);
        partSteps.userShouldAddRCMOrRCSToTheReferenceCodeField(uniqueCode);
    }

    @And("The user searches for and opens the part {string} from the search results")
    public void theUserSearchesForAndOpensThePartFromTheSearchResults(String itemCode) {
        partSteps.userShouldSearchAndOpenThePartFromSearchPage(itemCode);
    }

    @And("Validate lifecycle state should be change to (.*)$")
    public void validateLifecycleStateShouldBeChangeTo(String lifecycle) {
        partSteps.validationOfStatus(lifecycle);
    }

    @And("decrease the zoom of application")
    public void decreaseTheZoomOfApplication() {
        partSteps.decreaseTheZoomOfApplication(0.5);
    }
}
