package co.com.choucair.certification.proyectobase.stepdefinitions;

import co.com.choucair.certification.proyectobase.questions.Answer;
import co.com.choucair.certification.proyectobase.tasks.Login;
import co.com.choucair.certification.proyectobase.tasks.OpenUp;
import co.com.choucair.certification.proyectobase.tasks.Search;
import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

public class ChoucairAcademyStepDefinitions {
    @Before

    public void setStage(){
        OnStage.setTheStage(new OnlineCast());
    }
    @Given("^than brandon wants to learn automation at the academy Choucair$")
    public void thanBrandonWantsToLearnAutomationAtTheAcademyChoucair() {
        OnStage.theActorCalled("Brandon").wasAbleTo(OpenUp.thePage(), (Login.onThePage()));
        /*OnStage.theActorCalled("Brandon").wasAbleTo(Go.toGooglePage());
        OnStage.theActorCalled("Brandon").wasAbleTo(Launch.youtubeHomePage());
        OnStage.theActorCalled("Brandon").wasAbleTo(Search.yourFavoriteSong());
        OnStage.theActorCalled("Brandon").wasAbleTo(Login.withCredentials(username,password));*/
   }

    @When("^he search for the course (.*) on the choucair academy platform$")
    public void heSearchForTheCourseFoundationLevelOnTheChoucairAcademyPlatform(String course) {
        OnStage.theActorInTheSpotlight().attemptsTo(Search.the(course));
    }

    @Then("^he finds the course called resources (.*)$")
    public void heFindsTheCourseCalledResourcesFoundationLevel(String question) {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(Answer.toThe(question)));
    }
}
