package com.demoblaze.automation.questions;

import com.demoblaze.automation.userinterfaces.CompraPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;


public class CompraExitosa implements Question<Boolean> {
    @Override
    public Boolean answeredBy(Actor actor) {
        return Text.of(CompraPage.MENSAJE_COMPRA)
                .answeredBy(actor)   // método correcto
                .contains("Thank you");
    }

    public static CompraExitosa validacion() {
        return new CompraExitosa();
    }
}
