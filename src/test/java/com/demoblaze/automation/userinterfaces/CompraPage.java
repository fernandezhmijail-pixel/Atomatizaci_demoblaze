package com.demoblaze.automation.userinterfaces;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CompraPage {
    public static final Target MENSAJE_COMPRA = Target.the("mensaje de compra exitosa")
            .located(By.xpath("//h2[text()='Thank you for your purchase!']"));
}
