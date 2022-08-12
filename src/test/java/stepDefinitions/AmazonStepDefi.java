package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class AmazonStepDefi {
    AmazonPage amazonPage = new AmazonPage();
    Select select;
    JavascriptExecutor js;
    String expectedItemControl;

    @Given("kullanici {string} anasayfasina gider")
    public void kullanici_anasayfasina_gider(String url) {
        Driver.getDriver().get(ConfigReader.getProperty(url));
    }
    @Given("kullanici {string} anasayfasinin acildigini kontrol eder")
    public void kullanici_anasayfasinin_acildigini_kontrol_eder(String url) {
    String expectedUrl=ConfigReader.getProperty(url);
    String actualUrl=Driver.getDriver().getCurrentUrl();
    Assert.assertEquals(expectedUrl,actualUrl);
    }
    @Given("kullanici cerez tercihlerinden cerezleri kabul et secenegini secer")
    public void kullanici_cerez_tercihlerinden_cerezleri_kabul_et_secenegini_secer() {
    //yazim asamasinda cerezler ekrana gelmedigi icin yoruma alindi
    //amazonPage.cerezleriKabulEt.click();
    }
    @Then("kullanici siteye login olur")
    public void kullanici_siteye_login_olur() {
    amazonPage.signInButton.click();
    ReusableMethods.waitFor(1);
    amazonPage.emailTextBox.sendKeys(ConfigReader.getProperty("amazonUserEmail"));
    ReusableMethods.waitFor(1);
    amazonPage.continueButton.click();
    ReusableMethods.waitFor(1);
    amazonPage.passwordTextBox.sendKeys(ConfigReader.getProperty("amazonUserPassword"));
    ReusableMethods.waitFor(1);
    amazonPage.signInButton2.click();
    ReusableMethods.waitFor(1);

    }
    @Then("kullanici login oldugunu kontrol eder")
    public void kullanici_login_oldugunu_kontrol_eder() {
    String expectedLogin="Hello, Recep";
    String actualLogin=amazonPage.signInButton.getText();
    Assert.assertEquals(expectedLogin,actualLogin);
    }
    @Given("kullanici kategoriler bolumunden {string} secenegini secer")
    public void kullanici_kategoriler_bolumunden_secenegini_secer(String selected) {
    select = new Select(amazonPage.selectDropDown);
    select.selectByVisibleText(selected);
    }
    @Then("kullanici {string} seceneginin secili oldugunu kontrol eder")
    public void kullanici_seceneginin_secili_oldugunu_kontrol_eder(String selectOption) {
    select = new Select(amazonPage.selectDropDown);
    String actualOption = select.getFirstSelectedOption().getText();
    Assert.assertEquals(selectOption,actualOption);

    }
    @Then("kullanici arama kutusuna {string} yazar ve arama yapar")
    public void kullanici_arama_kutusuna_yazar_ve_arama_yapar(String searchWord) {
    amazonPage.searchBox.sendKeys(searchWord, Keys.ENTER);
    }
    @Then("kullanici arama sonuclarinin {string} icerdigini kontrol eder")
    public void kullanici_arama_sonuclarinin_icerdigini_kontrol_eder(String searchWord) {
    String actualSearcResult=amazonPage.searchResult.getText();
    Assert.assertTrue(actualSearcResult.contains(searchWord));

    }
    @Then("kullanici arama sonuc sayfasindan ikinci sayfaya gider")
    public void kullanici_arama_sonuc_sayfasindan_ikinci_sayfaya_gider() {
    js= (JavascriptExecutor) Driver.getDriver();
    ReusableMethods.waitFor(1);
    js.executeScript("arguments[0].click();", amazonPage.secondPage);
    expectedItemControl=amazonPage.secondItemControl.getText();

    }
    @Then("kullanici ikinci sayfanin acildigini kontrol eder")
    public void kullanici_ikinci_sayfanin_acildigini_kontrol_eder() {
    String expectedPageControl="Current page, page 2";
    String actualPageControl=amazonPage.secondPageControl.getAttribute("aria-label");
    Assert.assertEquals(expectedPageControl,actualPageControl);
    }
    @Then("kullanici acilan sayfada ikinci urunu favori listesie ekler")
    public void kullanici_acilan_sayfada_ikinci_urunu_favori_listesie_ekler() {
    js= (JavascriptExecutor) Driver.getDriver();
    ReusableMethods.waitFor(1);
    amazonPage.secondItem.click();
    ReusableMethods.waitFor(1);
    js.executeScript("arguments[0].click();", amazonPage.addToListButton);
    ReusableMethods.waitFor(1);
    amazonPage.closeButton.click();
    }
    @Then("kullanici ikinci urunun favori listesine eklendigini kontrol eder")
    public void kullanici_ikinci_urunun_favori_listesine_eklendigini_kontrol_eder() {
    ReusableMethods.hover(amazonPage.signInHover);
    ReusableMethods.waitFor(3);
    amazonPage.favoriteListButton.click();
    String actualItemTitle=amazonPage.favoriteListItem.getAttribute("alt");
    Assert.assertEquals(expectedItemControl,actualItemTitle);

    }
    @Given("kullanici favori listen sayfasina gider")
    public void kullanici_favori_listen_sayfasina_gider() {
    ReusableMethods.hover(amazonPage.signInHover);
    ReusableMethods.waitFor(3);
    amazonPage.favoriteListButton.click();
    ReusableMethods.waitFor(1);
    }
    @Given("kullanici favori listem sayfasinin acildigini kontrol eder")
    public void kullanici_favori_listem_sayfasinin_acildigini_kontrol_eder() {
    Assert.assertTrue(amazonPage.favoriteListPage.isDisplayed());
    ReusableMethods.waitFor(1);
    }
    @Then("kullanici eklenen urunu favori listesinden siler")
    public void kullanici_eklenen_urunu_favori_listesinden_siler() {
    amazonPage.deleteButton.click();
    ReusableMethods.waitFor(1);
    }
    @Then("kullanici silme isleminin gerceklestigini kontrol eder")
    public void kullanici_silme_isleminin_gerceklestigini_kontrol_eder() {
    Assert.assertTrue(amazonPage.deletedMessage.isDisplayed());
    }
    @Then("kullanici hesabim bolumunden cikis islemi yapar")
    public void kullanici_hesabim_bolumunden_cikis_islemi_yapar() {
    ReusableMethods.hover(amazonPage.signInHover);
    ReusableMethods.waitFor(3);
    amazonPage.signOutButton.click();
    ReusableMethods.waitFor(1);
    }
    @Then("kullanici cikis isleminin yapildigini kontrol eder")
    public void kullanici_cikis_isleminin_yapildigini_kontrol_eder() {
    Assert.assertTrue(amazonPage.signOutControl.isDisplayed());
    }

}
