package com.demoblaze.automation.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.targets.Target;

public class ClickAddToCart implements Interaction {

    private final Target elemento;

    public ClickAddToCart(Target elemento) {
        this.elemento = elemento;
    }

    public static ClickAddToCart en(Target elemento) {
        return Tasks.instrumented(ClickAddToCart.class, elemento);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        int intentos = 0;
        boolean exito = false;

        while (!exito && intentos < 5) { // max 5 intentos
            try {
                actor.attemptsTo(
                        Scroll.to(elemento),
                        WaitUntil.the(elemento, WebElementStateMatchers.isClickable()).forNoMoreThan(10).seconds(),
                        Click.on(elemento)
                );
                exito = true; // si hace click, salir del loop
            } catch (Exception e) {
                intentos++;
                System.out.println("Intento " + intentos + " fallido, reintentando...");
            }
        }

        if (!exito) {
            throw new RuntimeException("No se pudo hacer click en el Add to Cart después de 5 intentos");
        }
    }
}
