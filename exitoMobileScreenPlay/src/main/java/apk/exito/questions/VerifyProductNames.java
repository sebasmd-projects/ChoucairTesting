package apk.exito.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static apk.exito.userinterfaces.BuyProductExitoPage.PRODUCT_NAME_CART_LABEL;

public class VerifyProductNames implements Question<Boolean> {
    private String name;

    public VerifyProductNames(String name) {
        this.name = name;
    }

    public static VerifyProductNames verify(String name) {
        return new VerifyProductNames(name);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return PRODUCT_NAME_CART_LABEL.of(name).isVisibleFor(actor);
    }
}