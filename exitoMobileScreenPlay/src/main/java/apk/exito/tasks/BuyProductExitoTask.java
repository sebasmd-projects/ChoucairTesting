package apk.exito.tasks;

import apk.exito.model.ProductModel;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.*;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static apk.exito.userinterfaces.BuyProductExitoPage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class BuyProductExitoTask implements Task {

    private String productCategory;

    public BuyProductExitoTask(ProductModel productModel) {
        this.productCategory = productModel.getProductCategory();
    }

    public static Performable withTheData(ProductModel productModel) {
        return Tasks.instrumented(BuyProductExitoTask.class, productModel);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Check.whether(theLocationPopupIsVisible()).
                andIfSo(Click.on(CLOSE_LOCATION_POP_UP)));

        actor.attemptsTo(Check.whether(theVideoIsVisible()).
                andIfSo(Click.on(CLOSE_VIDEO_ICON)));

        actor.attemptsTo(Click.on(PRODUCT_SEARCH_INPUT));

        actor.attemptsTo(WaitUntil.the(RECEIVE_ORDER_POP_UP, isVisible()).forNoMoreThan(5).seconds());
        actor.attemptsTo((Click.on(SEND_TO_HOME)));
        actor.attemptsTo(WaitUntil.the(CONTINUE_BUTTON, isClickable()).forNoMoreThan(5).seconds(), Click.on(CONTINUE_BUTTON));


        actor.attemptsTo(Enter.theValue(productCategory).into(PRODUCT_SEARCH_TWO_INPUT));

        actor.attemptsTo(Click.on(PRODUCT_NAME_LABEL.of(this.productCategory)));

        actor.attemptsTo(WaitUntil.the(FIRST_BUTTON_AGREGAR_IN_LIST, isClickable()).forNoMoreThan(10).seconds(), Click.on(FIRST_BUTTON_AGREGAR_IN_LIST));

        String productName = Text.of(FIRST_NAME_IN_LIST).answeredBy(actor).substring(Math.max(0, Text.of(FIRST_NAME_IN_LIST).answeredBy(actor).length() - 20));
        String productPrice = Text.of(FIRST_PRICE_IN_LIST).answeredBy(actor).replaceAll("[^0-9]", "");

        Serenity.setSessionVariable("productName").to(productName);
        Serenity.setSessionVariable("productPrice").to(productPrice);

        actor.attemptsTo(Click.on(SHOPPING_CART_ICON));

        actor.attemptsTo(WaitUntil.the(CART_PRODUCT_UNITS.of(productName), isVisible()).forNoMoreThan(15).seconds());
    }

    private Question<Boolean> theVideoIsVisible() {
        return actor -> CLOSE_VIDEO_ICON.resolveFor(actor).isCurrentlyVisible();
    }

    private Question<Boolean> theLocationPopupIsVisible() {
        return actor -> CLOSE_LOCATION_POP_UP.resolveFor(actor).isCurrentlyVisible();
    }
}
