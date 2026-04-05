package com.demoblaze.automation.userinterfaces;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;


public class producstorePage {

    public static Target CATEGORIA(String nombre) {
        return Target.the("categoria " + nombre)
                .locatedBy("//a[text()='{0}']").of(nombre);
    }

    public static final Target PRODUCTO = Target.the("Producto 01")
            .located(By.xpath("(//img[@src='imgs/galaxy_s6.jpg'])[1]"));
    public static final Target PRODUCTO02 = Target.the("Producto 02")
            .located(By.xpath("//a/img[@src='imgs/Lumia_1520.jpg' and contains(@class,'card-img-top')]"));

    public static Target PRODUCTO1(String producto01) {
        return Target.the("Producto 1 " + producto01)
                .locatedBy("//a[text()=\"{0}\"]")
                .of(producto01);
    }

    public static Target PRODUCTO2(String producto02) {
        return Target.the("Producto 2 " + producto02)
                .locatedBy("//a[text()='{0}']").of(producto02);
    }

   // public static Target ADD_TO_CART(String nombreProducto) {
     //   return Target.the("Agregar al carrito de " + nombreProducto)
       //         .locatedBy("//h2[text()='{0}']/ancestor::div[contains(@class,'product-content')]//a[contains(text(),'Add to cart')]");
    // }

    public static final Target HOME = Target.the("Agregar al carrito")
            .located(By.xpath("//li[contains(@class,'nav-item') and contains(@class,'active')]/a[contains(text(),'Home')]"));

    public static final Target ADD_TO_CART = Target.the("Agregar al carrito")
           .located(By.xpath("//a[text()='Add to cart']"));
    //a[contains(@class,'btn-success') and contains(@class,'btn-lg')]

    public static final Target CART = Target.the("Carrito")
            .located(By.id("cartur"));
}
