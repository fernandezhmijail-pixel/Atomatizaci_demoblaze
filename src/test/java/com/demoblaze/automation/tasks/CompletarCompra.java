package com.demoblaze.automation.tasks;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class CompletarCompra implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(By.xpath("//button[text()='Place Order']")),
                Enter.theValue("Anthony").into(By.id("name")),
                Enter.theValue("Peru").into(By.id("country")),
                Enter.theValue("Lima").into(By.id("city")),
                Enter.theValue("123456789").into(By.id("card")),
                Enter.theValue("12").into(By.id("month")),
                Enter.theValue("2026").into(By.id("year")),
                Click.on(By.xpath("//button[text()='Purchase']"))
        );
    }

    public static CompletarCompra formulario() {
        return Tasks.instrumented(CompletarCompra.class);
    }
}
