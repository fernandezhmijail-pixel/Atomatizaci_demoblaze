package com.demoblaze.automation.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.JavascriptExecutor;
import net.serenitybdd.core.Serenity;

public class ClickAddToCartJS implements Interaction {

    private final Target elemento;

    public ClickAddToCartJS(Target elemento) {
        this.elemento = elemento;
    }

    public static ClickAddToCartJS en(Target elemento) {
        return Tasks.instrumented(ClickAddToCartJS.class, elemento);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        int intentos = 0;
        boolean exito = false;

        while (!exito && intentos < 5) {
            try {
                // Esperar hasta que esté presente
                actor.attemptsTo(
                        net.serenitybdd.screenplay.waits.WaitUntil.the(elemento, net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent())
                                .forNoMoreThan(10).seconds()
                );

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
            throw new RuntimeException("No se pudo hacer click en Add to Cart con JS después de 5 intentos");
        }
    }
}
