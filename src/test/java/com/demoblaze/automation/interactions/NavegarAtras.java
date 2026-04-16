package com.demoblaze.automation.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;


public class NavegarAtras implements Interaction {
    @Override
    public <T extends Actor> void performAs(T actor) {
        BrowseTheWeb.as(actor).getDriver().navigate().back();
    }

    public static NavegarAtras pagina() {
        return Tasks.instrumented(NavegarAtras.class);
    }
}
