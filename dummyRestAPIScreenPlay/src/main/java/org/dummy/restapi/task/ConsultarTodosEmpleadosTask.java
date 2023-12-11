package org.dummy.restapi.task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static org.dummy.restapi.utils.enums.Enums.URI_CONSULT_EMPLOYEES;

public class ConsultarTodosEmpleadosTask implements Task {

    public static ConsultarTodosEmpleadosTask consultar(){
        return Tasks.instrumented(ConsultarTodosEmpleadosTask.class);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource(URI_CONSULT_EMPLOYEES.toString())
        );
    }
}
