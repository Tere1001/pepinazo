package pageIMDB;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static junit.framework.Assert.assertNotNull;

public class IMDBStepsDefinitions {

    protected WebDriver driver;

    @Before
    public void setUpTest() {
        ChromeOptions opt = new ChromeOptions();
        opt.addArguments("--disable-notifications");
        driver = new ChromeDriver(opt);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }

    @After
    public void tearDownTest() {
        driver.quit();
    }

    @Given("I have open the browser")
    public void I_have_open_the_browser() {
        assertNotNull(driver);
    }

    @When("I am in IMDB page")
    public void I_open_IMDB_page() {
        driver.get("https://www.imdb.com/");
    }

    @When ("I search by title")
    public void search_title(){
        //encontrar el campo de busqueda
        WebElement campoBusqueda = driver.findElement(By.name("q"));
        campoBusqueda.click();
        WebElement titles = driver.findElement(By.xpath("//a[@role='menuitem' and text() = 'Items']"));
        // ingresar el nombre de la pelicula
        campoBusqueda.sendKeys("it");
        //encontrar el boton de busqueda
        WebElement botonBusqueda = driver.findElement(By.cssSelector("svg.ipc-icon.ipc-icon--magnify"));
        botonBusqueda.click();

    }

    @Then("It displays movies by the title")
    public void display_movieByTitle() {
        List<WebElement> listaPeliculas = driver.findElements(By.cssSelector("td.result_text"));
        for(WebElement element: listaPeliculas) {
            String textoElemento = element.getText();
            if(textoElemento.contains("it")) {
                System.out.println("Ya encontre la pelicula" + textoElemento);
                break;
            }
        }

    }

    @When ("I search by episode")
    public void search_episode() {

    }


    @Then ("It displays movies by episode")
    public void display_movieByEpisode() {


    }

    @When ("I search by celebrity")
    public void search_By_celebrity() {

    }


    @Then ("It displays movies by the celebrity")
    public void display_movieByCelebrity() {

    }

    @When ("I search by genre")
    public void search_BY_Genre() {

    }

    @Then ("It displays movies by genre")
    public void display_movieByGenre() {

    }

    @When ("I search by company")
    public void searchBYcompany() {

    }

    @Then ("It displays movies by the company")
    public void display_movieByCompany() {

    }

    @When ("I search by key word")
    public void searchBYkeyWord() {

    }


    @Then ("It displays movies by the key word")
    public void display_movieByKeyWord() {

    }







}
