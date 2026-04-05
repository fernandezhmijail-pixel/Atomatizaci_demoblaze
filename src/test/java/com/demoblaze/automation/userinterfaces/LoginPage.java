package com.demoblaze.automation.userinterfaces;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class LoginPage {
    public static final Target BTN_LOGIN_MODAL = Target.the("botón para abrir modal login")
            .located(By.xpath("//a[@id='login2']"));

    public static final Target INPUT_USERNAME = Target.the("campo usuario")
            .located(By.xpath("//input[@id='loginusername']"));

    public static final Target INPUT_PASSWORD = Target.the("campo contraseña")
            .located(By.xpath("//input[@id='loginpassword']"));

    public static final Target BTN_SUBMIT_LOGIN = Target.the("botón iniciar sesión")
            .located(By.xpath("//button[text()='Log in']"));
}
