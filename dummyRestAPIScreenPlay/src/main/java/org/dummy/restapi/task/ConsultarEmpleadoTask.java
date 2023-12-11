package org.dummy.restapi.task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static org.dummy.restapi.utils.enums.Enums.URI_CONSULT_EMPLOYEE;

public class ConsultarEmpleadoTask implements Task {
    private final String idEmpleado;

    public ConsultarEmpleadoTask(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public static ConsultarEmpleadoTask consultar(String idEmpleado) {
        return Tasks.instrumented(ConsultarEmpleadoTask.class, idEmpleado);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource(URI_CONSULT_EMPLOYEE + "/" + idEmpleado)
        );
    }
}
