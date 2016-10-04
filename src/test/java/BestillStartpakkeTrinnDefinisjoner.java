import cucumber.api.PendingException;
import cucumber.api.java.da.Når;
import cucumber.api.java.no.Gitt;
import cucumber.api.java.no.Så;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

/**
 *
 * @author echonyx
 */
public class BestillStartpakkeTrinnDefinisjoner {
    
    private HtmlUnitDriver driver = new HtmlUnitDriver();
    
    @Gitt("^at en bruker velger liten startpakke$")
    public void at_en_bruker_velger_liten_startpakke() throws Throwable {
        driver.get("http://localhost:8080/CucumberStart-master/index.html"); 
        Thread.sleep(2000); // Disse bruker vi kun for å kunne observere testen 
        WebElement element = driver.findElement(By.id("start-kit-small")); 
        element.click(); 
        Thread.sleep(1000); 
        element = driver.findElement(By.id("order-startkit")); 
        element.click();
    }
    
    @Når("^brukeren trykker på \"gjennomfør bestilling\"$")
    public void brukeren_trykker_på_gjennomfør_bestilling() throws Throwable {
        Thread.sleep(2000); 
        WebElement element = driver.findElement(By.id("place-order"));
        element.click();   
    }
    
    @Så("^skal brukeren få en ordrebekreftelse$")
    public void skal_brukeren_få_en_ordrebekreftelse() throws Throwable {
        Thread.sleep(2000); 
        assert(driver.findElement(By.id("order-confirmation")) != null);   
    }
    
    @Så("^ordrestatus skal opprettes$")
    public void ordrestatus_skal_opprettes() throws Throwable {
        WebElement element = driver.findElement(By.id("see-order-status")); 
        element.click(); 
        assert(driver.findElement(By.xpath("//p[contains(text(), \"Status: Bestilt.\")]")) != null); 
        Thread.sleep(2000); 
        driver.close();
    }
}
