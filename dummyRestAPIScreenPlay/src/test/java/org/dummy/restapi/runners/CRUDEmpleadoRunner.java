package org.dummy.restapi.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/crud_empleados.feature",
        glue = "org.dummy.restapi",
        tags = "@Post",
        plugin = {"pretty"},
        snippets = CucumberOptions.SnippetType.CAMELCASE)
public class CRUDEmpleadoRunner {
}

