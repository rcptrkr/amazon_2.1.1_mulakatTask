package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AmazonPage {
    public AmazonPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy (id="sp-cc-accept")
    public WebElement cerezleriKabulEt;
    @FindBy (id="nav-link-accountList-nav-line-1")
    public WebElement signInButton;

    @FindBy (xpath = "//input[@id='ap_email']")
    public WebElement emailTextBox;

    @FindBy (xpath = "//input[@id='continue']")
    public WebElement continueButton;

    @FindBy (xpath = "//input[@id='ap_password']")
    public WebElement passwordTextBox;

    @FindBy (id="signInSubmit")
    public WebElement signInButton2;

    @FindBy (xpath = "//select[@id='searchDropdownBox']")
    public WebElement selectDropDown;

    @FindBy (id="twotabsearchtextbox")
    public WebElement searchBox;

    @FindBy (xpath = "//div[@class='a-section a-spacing-small a-spacing-top-small']")
    public WebElement searchResult;

    @FindBy (xpath = "//a[text()='2']")
    public WebElement secondPage;

    @FindBy (xpath = "//span[@class='s-pagination-item s-pagination-selected']")
    public WebElement secondPageControl;

    @FindBy (xpath = "(//span[@class='a-size-base-plus a-color-base a-text-normal'])[2]")
    public WebElement secondItem;

    @FindBy (xpath = "//input[@id='add-to-wishlist-button-submit']")
    public WebElement addToListButton;

    @FindBy (xpath = "//button[@data-action='a-popover-close']")
    public WebElement closeButton;

    @FindBy (xpath = "(//span[text()='favorite list'])[1]")
    public WebElement favoriteListButton;

    @FindBy (xpath = "(//span[@class='a-color-base'])[1]")
    public WebElement favoriteListPage;

    @FindBy (xpath = "//img[@height='135']")
    public WebElement favoriteListItem;

    @FindBy (name="submit.deleteItem")
    public WebElement deleteButton;

    @FindBy (xpath = "//*[text()='Deleted']")
    public WebElement deletedMessage;

    @FindBy (xpath = "//span[text()='Sign Out']")
    public WebElement signOutButton;

    @FindBy (xpath = "//a[@data-nav-ref='nav_youraccount_btn']")
    public WebElement signInHover;

    @FindBy (xpath = "//h1[@class='a-spacing-small']")
    public WebElement signOutControl;

    @FindBy (xpath = "(//span[@class='a-size-base-plus a-color-base a-text-normal'])[2]")
    public WebElement secondItemControl;




















}