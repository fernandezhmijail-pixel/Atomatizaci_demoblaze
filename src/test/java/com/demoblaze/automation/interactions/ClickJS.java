package com.demoblaze.automation.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.JavascriptExecutor;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;

public class ClickJS implements Interaction {

    private final Target elemento;

    public ClickJS(Target elemento) {
        this.elemento = elemento;
    }

    public static ClickJS en(Target elemento) {
        return Tasks.instrumented(ClickJS.class, elemento);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        int intentos = 0;
        boolean exito = false;

        while (!exito && intentos < 5) {
            try {
                // Esperar hasta que esté visible y presente
                actor.attemptsTo(
                        WaitUntil.the(elemento, WebElementStateMatchers.isVisible())
                                .forNoMoreThan(10).seconds(),
                        WaitUntil.the(elemento, WebElementStateMatchers.isPresent())
                                .forNoMoreThan(10).seconds()
                );

                // Scroll hacia el elemento para asegurarse de que sea visible
                actor.attemptsTo(net.serenitybdd.screenplay.actions.Scroll.to(elemento));

                // Ejecutar click con JavaScript
                JavascriptExecutor js = (JavascriptExecutor) Serenity.getWebdriverManager().getWebdriver();
                js.executeScript("arguments[0].click();", elemento.resolveFor(actor));

                exito = true;
            } catch (Exception e) {
                intentos++;
                System.out.println("Intento JS " + intentos + " fallido, reintentando...");
                try { Thread.sleep(500); } catch (InterruptedException ignored) {}
            }
        }

        if (!exito) {
            throw new RuntimeException("No se pudo hacer click en el elemento con JS después de 5 intentos");
        }
    }
}
