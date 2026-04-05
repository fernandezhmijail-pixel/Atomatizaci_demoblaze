package com.demoblaze.automation.stepdefinitions;

import com.demoblaze.automation.interactions.EscribirConEspera;
import com.demoblaze.automation.questions.CompraExitosa;
import com.demoblaze.automation.tasks.AgregarProductos;
import com.demoblaze.automation.tasks.CompletarCompra;
import com.demoblaze.automation.tasks.Login;
import com.demoblaze.automation.tasks.VerCarrito;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class CompraStepDefinitions {
    @Given("que el usuario ingresa a Demoblaze")
    public void abrirPagina() {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("Usuario")
                .wasAbleTo(Open.url("https://www.demoblaze.com/"));
        // Maximizar navegador de forma tipo segura
        Performable maximizar = Task.where("{0} maximiza el navegador",
                actor -> BrowseTheWeb.as(actor).getDriver().manage().window().maximize()
        );
        // Usar tu Task de login con interacción personalizada
        OnStage.theActorInTheSpotlight().attemptsTo(
                maximizar,
                Login.conCredenciales("fernandez.h.mijail@gmail.com", "Anthonella91")
        );
    }

    @When("agrega dos productos al carrito {string}")
    public void agregarProductos(String categoria) {
        OnStage.theActorInTheSpotlight()
                .attemptsTo(AgregarProductos.alCarrito(categoria));
    }

    @When("visualiza el carrito")
    public void verCarrito() {
        OnStage.theActorInTheSpotlight()
                .attemptsTo(VerCarrito.productos());
    }

    @When("completa el formulario de compra")
    public void completarCompra() {
        OnStage.theActorInTheSpotlight()
                .attemptsTo(CompletarCompra.formulario());
    }

    @Then("finaliza la compra exitosamente")
    public void validarCompra() {
        OnStage.theActorInTheSpotlight()
                .should(seeThat(CompraExitosa.validacion()));
    }
}
