package com.demoblaze.automation.tasks;

import com.demoblaze.automation.userinterfaces.ProductStorePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

public class VerCarrito implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(ProductStorePage.CART)
        );
    }

    public static VerCarrito productos() {
        return Tasks.instrumented(VerCarrito.class);
    }
}
