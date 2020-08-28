package facebookPOM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HomePage {

	@FindBy(how = How.XPATH, using = "//h1[@data-click='bluebar_logo']")
	WebElement facebookLogo;
	//name = "q"
	@FindBy(how = How.NAME, using = "q" )
	WebElement searchField;

	@FindBy (how = How.XPATH, using = "//button[@data-testid='facebar_search_button']")
	WebElement searchButton;

	public WebDriver driver;
	public WebDriverWait wait;

	public HomePage(WebDriver testDriver) {
		driver = testDriver;
		wait = new WebDriverWait(driver, 15);
		PageFactory.initElements(driver, this);
	}

	public boolean at() {
		//existe el campo de busqueda?
		//existe el boton de busqueda?
		//retorna verdadero.
		//wait.until(ExpectedConditions)
		return searchField.isDisplayed() && searchButton.isDisplayed();
	}

	public void buscarAmigo(String nombreAmigo) {
		searchField.sendKeys(nombreAmigo);
		searchButton.click();
	}
	public void publicarEstado(String mensaje) {

		WebElement campoQuePasa = driver.findElement(By.cssSelector("div .oajrlxb2.b3i9ofy5.qu0x051f.esr5mh6w.e9989ue4.r7d6kgcz.rq0escxv.nhd2j8a9.j83agx80.p7hjln8o.kvgmc6g5.cxmmr5t8.oygrvhab.hcukyx3x.cxgpxx05.d1544ag0.sj5x9vvc.tw6a2znq.i1ao9s8h.esuyzwwr.f1sip0of.lzcic4wl.l9j0dhe7.abiwlrkh.p8dawk7l.bp9cbjyn.orhb3f3m.czkt41v7.fmqxjp7s.emzo65vh.btwxx1t3.buofh1pr.idiwt2bm.jifvfom9.ni8dbmo4.stjgntxs.kbf60n1y"));
		//Validar edicion en campo
		campoQuePasa.click();
		// WebElement campoAgregarText = driver.findElement(By.cssSelector("form[method='POST'] .q5bimw55"));
		WebElement campoAgregarText = driver.findElement(By.cssSelector("div .notranslate._5rpu div[data-contents=\"true\"] div[data-offset-key=\"86vse-0-0\"]"));
		// campo editable div[data-editor="ekfpm"]
		campoAgregarText.sendKeys("Publicacion de estado, que hay!");
		//botonPublicar css "form[method='POST'] .oajrlxb2"
		List<WebElement> elementitos = driver.findElements(By.cssSelector("form[method='POST'] .oajrlxb2"));
		int numeroElementitos = elementitos.size();
		WebElement publicar = elementitos.get(numeroElementitos - 1);
		publicar.click();

	}
	public void likePhoto() {


	}
	public void commentPost(String mensaje) {

	}
	public void compartirEstado(String mensaje) {

	}
	public void compartirEstadoSinMensaje() {

	}

}
