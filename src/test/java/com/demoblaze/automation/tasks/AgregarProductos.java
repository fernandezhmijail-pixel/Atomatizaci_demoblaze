package com.demoblaze.automation.tasks;

import com.demoblaze.automation.interactions.*;
import com.demoblaze.automation.userinterfaces.producstorePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;


public class AgregarProductos implements Task {

    private final String categoria;
    //private final String producto01;
    //private final String producto02;

    public AgregarProductos(String categoria) {
        this.categoria = categoria;
       // this.producto01 = producto01;
        //this.producto02 = producto02;
    }

    public static AgregarProductos alCarrito(String categoria) {
        return Tasks.instrumented(AgregarProductos.class, categoria);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        // Hacer click en la categoría con espera
        actor.attemptsTo(
                ClickConEspera.en(producstorePage.CATEGORIA(categoria))
        );

        // --- PRIMER PRODUCTO ---
        actor.attemptsTo(
                ClickJS.en(producstorePage.PRODUCTO),
                //Scroll.to(producstorePage.PRODUCTO1(producto01)),
               // WaitUntil.the(producstorePage.PRODUCTO1(producto01), isVisible())
                     //   .forNoMoreThan(15).seconds(),
                //WaitUntil.the(PRODUCTO1(producto01), isClickable()).forNoMoreThan(10).seconds(),
                //Scroll.to(PRODUCTO1(producto01)),
                //ClickJS.en(producstorePage.PRODUCTO1(producto01)),
                //WaitUntil.the(producstorePage.ADD_TO_CART, isClickable()).forNoMoreThan(15).seconds(),
                //Scroll.to(producstorePage.ADD_TO_CART(producto01)),
                //ClickAddToCartRobusto.en(producstorePage.ADD_TO_CART(producto01)),
                ClickAddToCartJS.en(producstorePage.ADD_TO_CART),
                AceptarAlerta.delNavegador(), // esperar y aceptar alerta
                NavegarAtras.pagina()
        );

        actor.attemptsTo(
                ClickJS.en(producstorePage.HOME)
                );
        // Hacer click en la categoría con espera
        actor.attemptsTo(
                ClickConEspera.en(producstorePage.CATEGORIA(categoria))
        );

        // --- SEGUNDO PRODUCTO ---
       actor.attemptsTo(
               ClickConEspera.en(producstorePage.PRODUCTO02),
               // WaitUntil.the(producstorePage.PRODUCTO2(producto02), isClickable()).forNoMoreThan(10).seconds(),
               // ClickConEspera.en(producstorePage.PRODUCTO2(producto02)),
                //WaitUntil.the(producstorePage.ADD_TO_CART, isClickable()).forNoMoreThan(15).seconds(),
                //Scroll.to(ADD_TO_CART(producto02)),
                ClickConEspera.en(producstorePage.ADD_TO_CART),
                AceptarAlerta.delNavegador() // esperar y aceptar alerta
      );
    }
}