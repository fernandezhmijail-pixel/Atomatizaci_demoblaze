package com.demoblaze.automation.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.targets.Target;

public class ClickConEspera implements Interaction {
    private final Target elemento;

    public ClickConEspera(Target elemento) {
        this.elemento = elemento;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Scroll.to(elemento), // Asegura que esté visible
                WaitUntil.the(elemento, WebElementStateMatchers.isClickable())
                        .forNoMoreThan(15).seconds(),
                Click.on(elemento)
        );
    }

    public static ClickConEspera en(Target elemento) {
        return Tasks.instrumented(ClickConEspera.class, elemento);
    }
}