package org.dummy.restapi.task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Put;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static org.dummy.restapi.utils.enums.Enums.URI_UPDATE_EMPLOYEE;

public class ActualizarEmpleadoTask implements Task {

    private final String empleadoJSON;
    private final String idEmpleado;

    public ActualizarEmpleadoTask(String empleadoJSON, String idEmpleado) {
        this.empleadoJSON = empleadoJSON;
        this.idEmpleado = idEmpleado;
    }

    public static ActualizarEmpleadoTask actualizar(String empleadoJSON, String idEmpleado) {
        return instrumented(ActualizarEmpleadoTask.class, empleadoJSON, idEmpleado);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Put.to(URI_UPDATE_EMPLOYEE + idEmpleado)
                        .with(request -> request
                                .header("Content-Type", "application/json","","")
                                .body(empleadoJSON))
        );
    }
}
