package org.dummy.restapi.task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Delete;

import static org.dummy.restapi.utils.enums.Enums.URI_DELETE_EMPLOYEE;

public class EliminarEmpleadoTask implements Task {
    private final String idEmpleado;

    public EliminarEmpleadoTask(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public static EliminarEmpleadoTask eliminar(String idEmpleado) {
        return Tasks.instrumented(EliminarEmpleadoTask.class, idEmpleado);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Delete.from(URI_DELETE_EMPLOYEE + idEmpleado)
        );
    }
}
