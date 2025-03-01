package starter.SerenitySteps;


import net.serenitybdd.annotations.Step;
import starter.PageObjectsPages.ARAS_HomePage;


public class HomePageStep{

    ARAS_HomePage home;
@Step
    public boolean verifyOnHomePage()
{
   return home.verifyHomePage();
}

@Step
    public void clickOnNavigationButton()
{
    home.click_On_Navigation();
}
    @Step
public void clickOnDesign()
{

    home.click_On_designOption();
}
    @Step
    public void NavigateToContent(String NavPath) {
        home.navigating(NavPath);
    }
    @Step
public void clickOnParts()
{
    home.click_On_partsSubMenu();
}
    @Step
public void createNewPart()
{
    home.click_On_createNewPart();
}
@Step
public void search_Part()
{
    home.clickonSearchParts();
}

}
