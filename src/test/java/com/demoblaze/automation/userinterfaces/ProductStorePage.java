package com.demoblaze.automation.userinterfaces;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;


public class ProductStorePage {

    public static Target CATEGORIA(String nombre) {
        return Target.the("categoria " + nombre)
                .locatedBy("//a[@id='itemc' and normalize-space()='" + nombre + "']")
                .of(nombre);
    }

    public static final Target PRODUCTO = Target.the("Producto 01")
            .located(By.xpath("(//img[@src='imgs/galaxy_s6.jpg'])[1]"));
    public static final Target PRODUCTO02 = Target.the("Producto 02")
            .located(By.xpath("//a/img[@src='imgs/Lumia_1520.jpg' and contains(@class,'card-img-top')]"));

    public static Target PRODUCTO1(String producto01) {
        return Target.the("Producto 1 " + producto01)
                .locatedBy("//a[text()='" + producto01 + "']")
                .of(producto01);
    }

    public static final Target HOME = Target.the("Agregar al carrito")
            .located(By.xpath("//li[contains(@class,'nav-item') and contains(@class,'active')]/a[contains(text(),'Home')]"));

    public static final Target ADD_TO_CART = Target.the("Agregar al carrito")
           .located(By.xpath("//a[text()='Add to cart']"));

    public static final Target CART = Target.the("Carrito")
            .located(By.id("cartur"));
}
