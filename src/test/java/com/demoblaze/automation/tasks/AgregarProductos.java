package com.demoblaze.automation.tasks;

import com.demoblaze.automation.interactions.*;
import com.demoblaze.automation.userinterfaces.ProductStorePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;


public class AgregarProductos implements Task {

    private final String categoria;
    private final String producto01;

    public AgregarProductos(String categoria, String producto01) {
        this.categoria = categoria;
        this.producto01 = producto01;
    }

    public static AgregarProductos alCarrito(String producto01, String categoria) {
        return Tasks.instrumented(AgregarProductos.class, producto01, categoria);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        // Hacer click en la categoría con espera
        actor.attemptsTo(
                ClickConEspera.en(ProductStorePage.CATEGORIA(categoria))
                );

        actor.attemptsTo(
                ClickConEspera.en(ProductStorePage.PRODUCTO1(producto01)),
                ClickAddToCartJS.en(ProductStorePage.ADD_TO_CART),
                AceptarAlerta.delNavegador(), // esperar y aceptar alerta
                //NavegarAtras.pagina(),

                ClickJS.en(ProductStorePage.HOME)

      );
    }
}