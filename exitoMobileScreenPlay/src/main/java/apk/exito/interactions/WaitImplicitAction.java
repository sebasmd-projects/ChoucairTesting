package apk.exito.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Tasks;

public class WaitImplicitAction implements Interaction {
    private int timeSeconds;

    public WaitImplicitAction(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }

    public static Performable inSeconds(int timeSeconds) {
        return Tasks.instrumented(WaitImplicitAction.class, timeSeconds);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            Thread.sleep(timeSeconds * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
