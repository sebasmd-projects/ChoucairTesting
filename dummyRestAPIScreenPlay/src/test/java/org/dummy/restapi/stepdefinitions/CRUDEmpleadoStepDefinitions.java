package org.dummy.restapi.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.restassured.path.json.JsonPath;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import org.dummy.restapi.modelos.EmpleadoModel;
import org.dummy.restapi.task.*;
import org.dummy.restapi.utils.ConvertidorAJSON;

import java.util.List;

import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.dummy.restapi.utils.enums.Enums.BASE_URL;

public class CRUDEmpleadoStepDefinitions {
    private EmpleadoModel empleado;

    @Before
    public void initialAutomationConfig() {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActor("DavidMorales");
    }

    @Dado("que se accede a la plataforma de endpoints")
    public void accesoALaPlataformaDeEndpoints() {
        theActorInTheSpotlight().whoCan(CallAnApi.at(BASE_URL.toString()));
    }

    @Cuando("el usuario crea un empleado")
    public void usuarioCreaUnEmpleado(List<List<String>> datosEmpleado) {
        empleado = new EmpleadoModel(datosEmpleado.get(0));
        theActorInTheSpotlight().attemptsTo(
                CrearEmpleadoTask.crear(ConvertidorAJSON.convertir(empleado))
        );
    }

    @Entonces("verifica la creacion de un nuevo registro en la base de datos")
    public void verificaLaCreacionDeUnNuevoRegistroEnLaBaseDeDatos(List<List<String>> datosEmpleado) {
        JsonPath responseJson = JsonPath.given(lastResponse().getBody().asString());
        assertThat(lastResponse().getStatusCode()).isEqualTo(200);
        assertThat(responseJson.getString("message")).isEqualTo(datosEmpleado.get(0).get(0));
    }

    @Cuando("todos los empleados registrados son consultados")
    public void empleadosRegistradosSonConsultados() {
        theActorInTheSpotlight().attemptsTo(
                ConsultarTodosEmpleadosTask.consultar());
    }

    @Cuando("un empleado registrado es consultado")
    public void empleadoRegistradoEsConsultado(List<List<String>> datosEmpleado) {
        theActorInTheSpotlight().attemptsTo(
                ConsultarEmpleadoTask.consultar(datosEmpleado.get(0).get(0))
        );
    }

    @Cuando("la informacion del empleado es modificada")
    public void informacionEmpleadoEsModificada(List<List<String>> datosEmpleado) {
        empleado = new EmpleadoModel(datosEmpleado.get(0));
        theActorInTheSpotlight().attemptsTo(
                ActualizarEmpleadoTask.actualizar(ConvertidorAJSON.convertir(empleado), datosEmpleado.get(0).get(0))
        );
    }

    @Cuando("un empleado registrado es eliminado")
    public void empleadoRegistradoEsEliminado(List<List<String>> datosEmpleado) {
        theActorInTheSpotlight().attemptsTo(
                EliminarEmpleadoTask.eliminar(datosEmpleado.get(0).get(0))
        );
    }

    @Entonces("verifica la respuesta del servicio consultado")
    public void verificaRespuestaDelServicioConsultado(List<List<String>> datosEmpleado) {
        JsonPath responseJson = JsonPath.given(lastResponse().getBody().asString());
        assertThat(lastResponse().getStatusCode()).isEqualTo(200);
        assertThat(responseJson.getString("message")).isEqualTo(datosEmpleado.get(0).get(0));
    }
}
