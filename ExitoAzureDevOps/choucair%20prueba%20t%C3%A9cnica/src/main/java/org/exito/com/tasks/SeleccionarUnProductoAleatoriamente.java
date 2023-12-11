package org.exito.com.tasks;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.exito.com.userInterface.ListaDeProductosPage;
import org.exito.com.util.UnidadTiempo;
import org.exito.com.util.Utilitarios;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SeleccionarUnProductoAleatoriamente implements Task {

    Logger logger = LoggerFactory.getLogger(SeleccionarCategoria.class);
    static List<Integer> items = new ArrayList<>(Arrays.asList(1, 2, 3, 4));


    public static SeleccionarUnProductoAleatoriamente seleccionar() {
        return Tasks.instrumented(SeleccionarUnProductoAleatoriamente.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        new UnidadTiempo(TimeUnit.SECONDS).esperar(3);
        actor.attemptsTo(WaitUntil.the(ListaDeProductosPage.CONTENEDOR_DE_PRODUCTOS, isVisible()));
        int aleatorio = Utilitarios.generarNumeroAleatorio(items);
        items.remove(aleatorio-1);
        WebElementFacade elemento = ListaDeProductosPage.PRODUCTOS.of(String.valueOf(aleatorio)).resolveFor(actor);
        actor.attemptsTo(Scroll.to(elemento), Click.on(elemento));
    }
}
