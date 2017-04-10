package pl.polsl;

import static net.sourceforge.jwebunit.junit.JWebUnit.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Tomasz Jastrząb
 * @version 1.0
 */
public class ViewTest {

    @Before
    public void setup() {
        setBaseUrl("http://localhost:8080/Lab5-Report-web/faces/");
    }

    @Test
    public void test() throws InterruptedException {
        beginAt("index.xhtml");
        clickLink("airplanesId");
        Thread.sleep(7000);
        assertTitleEquals("Airplanes");
        clickButtonWithText("ADD");
        Thread.sleep(5000);
        assertTitleEquals("Create");
        setTextField("airplane_name", "Aerolinea");
        setTextField("passenger", "6998");
        clickButtonWithText("CREATE");
        Thread.sleep(5000);
        assertTitleEquals("Airplanes");
        clickButtonWithText("ADD");
        Thread.sleep(5000);
        clickButtonWithText("BACK");
        Thread.sleep(5000);
        assertTitleEquals("Airplanes");
        clickButtonWithText("HOME");
        Thread.sleep(5000);
        clickLink("customersId");
        Thread.sleep(5000);
        assertTitleEquals("Customer");
        clickButtonWithText("ADD");
        Thread.sleep(5000);
        setTextField("name", "Zahid");
        setTextField("lastname", "Kizmaz");
        selectOption("singleSelect_input", "Ryanair 50");

        clickButtonWithText("CREATE");
        Thread.sleep(5000);
        clickButtonWithText("ADD");
        Thread.sleep(5000);
        clickButtonWithText("BACK");
        Thread.sleep(5000);
        clickButtonWithText("HOME");
    }
}
