package com.demoblaze.automation.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.JavascriptExecutor;

public class ClickProductoRobusto implements Interaction {
    private final Target elemento;

    public ClickProductoRobusto(Target elemento) {
        this.elemento = elemento;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        // Espera a que el elemento sea visible y scroll
        actor.attemptsTo(
                WaitUntil.the(elemento, WebElementStateMatchers.isVisible()).forNoMoreThan(20).seconds(),
                Scroll.to(elemento)
        );

        // Click usando JS vía WebDriver del actor
        JavascriptExecutor js = (JavascriptExecutor) BrowseTheWeb.as(actor).getDriver();
        js.executeScript("arguments[0].click();", elemento.resolveFor(actor));

        // Pequeño delay opcional para estabilizar
        try { Thread.sleep(500); } catch (InterruptedException e) { }
    }

    public static ClickProductoRobusto en(Target elemento) {
        return Tasks.instrumented(ClickProductoRobusto.class, elemento);
    }
}