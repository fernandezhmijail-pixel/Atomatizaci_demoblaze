package com.demoblaze.automation.tasks;

import com.demoblaze.automation.interactions.EscribirConEspera;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static com.demoblaze.automation.userinterfaces.LoginPage.*;

public class Login implements Task {
    private final String usuario;
    private final String contrasena;

    public Login(String usuario, String contrasena) {
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    public static Login conCredenciales(String usuario, String contrasena) {
        return Tasks.instrumented(Login.class, usuario, contrasena);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BTN_LOGIN_MODAL),       // Abrir modal de login si aplica
                //Enter.theValue(usuario).into(INPUT_USERNAME),
                //Enter.theValue(contrasena).into(INPUT_PASSWORD),
                EscribirConEspera.en(INPUT_USERNAME, usuario),   // Usa tu interacción personalizada para el campo de usuario
                EscribirConEspera.en(INPUT_PASSWORD, contrasena), // Usa tu interacción personalizada para la contraseña
                Click.on(BTN_SUBMIT_LOGIN)       // Botón para enviar login
        );
    }
}
