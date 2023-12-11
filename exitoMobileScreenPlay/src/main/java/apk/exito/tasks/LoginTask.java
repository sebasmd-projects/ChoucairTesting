package apk.exito.tasks;

import io.cucumber.datatable.DataTable;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import java.util.Map;

import static apk.exito.Util.List.IterateData;
import static apk.exito.userinterfaces.LoginExitoPage.*;

public class LoginTask implements Task {

    private final DataTable dataTable;

    public LoginTask(DataTable dataTable) {
        this.dataTable = dataTable;
    }

    public static Performable withTheData(DataTable dataTable) {
        return Tasks.instrumented(LoginTask.class, dataTable);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Map<String, String> credenciales = IterateData(dataTable);
        String email = "email";
        String password = "password";

        actor.attemptsTo(Click.on(LOGIN_BUTTON));
        actor.attemptsTo(Enter.theValue(credenciales.get(email)).into(EMAIL_INPUT));
        actor.attemptsTo(Enter.theValue(credenciales.get(password)).into(PASSWORD_INPUT));
        actor.attemptsTo(Click.on(ENTER_BUTTON));
    }
}
