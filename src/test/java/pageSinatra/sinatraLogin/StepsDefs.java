package pageSinatra.sinatraLogin;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

// navegarPagina("https://evening-bastion-49392.herokuapp.com/");
   //       verificarPaginaHome();
     //     clickLogin("footer a[href=\"/login\"]");
       //   verificarPaginaLogin("username","password","[value=\"Log In\"");
         // ingresarCredenciales("frank","sinatra","[value=\"Log In\"");
      //    verificarPaginaSongs();
        //  verificarMensajeBienvenida("You are now logged in as frank");
public class StepsDefs {
    WebDriver driver;

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


    @Given("I am on Sinatra page")
    public void iAmInSinatraPage() {
        driver.get("https://evening-bastion-49392.herokuapp.com/");

    }

    @When("I can see Sinatra Home Page")
    public void iCanSeeSinatraHomePage() {
        WebElement login = driver.findElement(By.cssSelector("img[alt=\"Frank Sinatra\"]"));
        //preguntar si esta visible
        if(login.isDisplayed()){
            System.out.println("Esta visible el login");
        }else{
            System.out.println("El login no esta visible");
            driver.quit(); // cierra todo
        }

    }

    @Then("i can see in the footer the logging button")
    public void iCanSeeInTheFooterTheLoggingButton() {
        WebElement login = driver.findElement(By.cssSelector("footer a[href=\"/login\"]"));
        login.click();
    }


    @When("I imput user and password")
    public void iImputUserAndPassword() {
        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));

        //verificar que existen los campos de username, password,
        if(username.isDisplayed() && password.isDisplayed() ){
            System.out.println("Se encuentran visibles el login");
        }else{
            System.out.println("No se encuentra visible el login");
            System.exit(-1);
        }
        //preguntar si estan visibles
        if(username.isEnabled() && password.isEnabled() ){
            System.out.println("Se encuentran habilitados los campos");
            username.sendKeys("frank");
            password.sendKeys("sinatra");

        }else {
            System.out.println("Algo marco error");
            System.exit(-1);
        }


    }

    @And("click on log in button")
    public void clickOnLogInButton() {
        WebElement botonLogin = driver.findElement(By.cssSelector("[value=\"Log In\""));
        botonLogin.click();
    }

    @Given("I am on Sinatra songs page")
    public void iAmOnSinatraSongsPage() {
        WebElement loggedInMessage = driver.findElement(By.id("flash"));
        if (loggedInMessage.getText().equals("You are now logged in as frank"))
            System.out.println("Test Passed");
        else
            System.out.println("Test Failed");
    }

    @When("I create a songs")
    public void iCreateASongs() {


    }

    @Then("I can see the new songs on the list")
    public void iCanSeeTheNewSongsOnTheList() {
    }
}
