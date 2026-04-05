package com.demoblaze.automation.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import net.serenitybdd.core.Serenity;
import java.time.Duration;

public class AceptarAlerta implements Interaction {

    public static AceptarAlerta delNavegador() {
        return new AceptarAlerta();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = Serenity.getWebdriverManager().getWebdriver();

        // Espera hasta que la alerta esté presente (máx 10 segundos)
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Alert alerta = wait.until(ExpectedConditions.alertIsPresent());

        // Aceptar la alerta
        alerta.accept();
    }
}