package org.dummy.restapi.task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static org.dummy.restapi.utils.enums.Enums.URI_CREATE_EMPLOYEE;

public class CrearEmpleadoTask implements Task {
    private final String empleadoJSON;

    public CrearEmpleadoTask(String empleadoJSON) {
        this.empleadoJSON = empleadoJSON;
    }

    public static CrearEmpleadoTask crear(String empleadoJSON) {
        return Tasks.instrumented(CrearEmpleadoTask.class, empleadoJSON);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to(URI_CREATE_EMPLOYEE.toString())
                        .with(request -> request
                                .header("Content-Type", "application/json")
                                .body(empleadoJSON))
        );

    }
}
