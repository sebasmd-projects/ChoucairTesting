package apk.exito.stepdefinitions;


import apk.exito.model.ProductModel;
import apk.exito.questions.VerifyProductNames;
import apk.exito.tasks.BuyProductExitoTask;
import apk.exito.tasks.LoginTask;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.Text;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static apk.exito.userinterfaces.BuyProductExitoPage.*;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class CartProductsStepDefinitions {

    @Managed(driver = "Appium")
    public WebDriver webDriver;

    @Before
    public void before() {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActor("usuario");
    }

    @Given("that I enter the apk movil Exito")
    public void enterTheAPKMovilExito(DataTable dataUser) {
        theActorInTheSpotlight().can(BrowseTheWeb.with(webDriver));
        theActorInTheSpotlight().attemptsTo(LoginTask.withTheData(dataUser));
    }

    @When("I add product to cart")
    public void addProductToCart(List<List<String>> productData) {
        theActorInTheSpotlight().attemptsTo(BuyProductExitoTask.withTheData(new ProductModel(productData.get(0))));
    }

    @Then("I verify the item in my shopping cart")
    public void iVerifyTheItemInMyShoppingCart() {
        String productName = Serenity.sessionVariableCalled("productName");
        String productPrice = Serenity.sessionVariableCalled("productPrice");

        Ensure.that(Text.of(CART_PRODUCT_NAME.of(productName)).answeredBy(theActorInTheSpotlight())).contains(productName);
        Ensure.that(Text.of(CART_PRODUCT_PRICE.of(productName)).answeredBy(theActorInTheSpotlight())).isEqualTo(productPrice);
        Ensure.that(Text.of(CART_PRODUCT_UNITS.of(productName)).answeredBy(theActorInTheSpotlight())).isEqualTo("1");
    }
}
