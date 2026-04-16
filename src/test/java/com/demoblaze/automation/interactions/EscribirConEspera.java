package com.demoblaze.automation.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.targets.Target;

public class EscribirConEspera implements Interaction {
    private Target campo;
    private String valor;

    public EscribirConEspera(Target campo, String valor) {
        this.campo = campo;
        this.valor = valor;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                // Espera hasta que el campo sea visible
                WaitUntil.the(campo, WebElementStateMatchers.isVisible())
                        .forNoMoreThan(10).seconds(),
                // Limpia cualquier texto existente
                Clear.field(campo),
                // Escribe el nuevo valor
                Enter.theValue(valor).into(campo)
        );
    }

    public static EscribirConEspera en(Target campo, String valor) {
        return Tasks.instrumented(EscribirConEspera.class, campo, valor);
    }
}
