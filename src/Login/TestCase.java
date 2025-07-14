package Login;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCase {

	WebDriver driver = new EdgeDriver();

	@BeforeTest

	public void mySetup() {

		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();

	}

	@Test(priority = 1)
	public void login() {

		WebElement UserNameInputField = driver.findElement(By.id("user-name"));
		WebElement PasswordInputField = driver.findElement(By.id("password"));
		WebElement LoginButton = driver.findElement(By.id("login-button"));

		UserNameInputField.sendKeys("standard_user");

		PasswordInputField.sendKeys("secret_sauce");

		LoginButton.click();

	}

	@Test(priority = 2)
	public void addtocart() {

		WebElement FirstItem = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));

		WebElement SecondItem = driver.findElement(By.id("add-to-cart-sauce-labs-onesie"));

		FirstItem.click();
		SecondItem.click();

	}

	@Test(priority = 3)

	public void RemoveFromCart() {

		WebElement RemoveFirstItem = driver.findElement(By.id("remove-sauce-labs-backpack"));

		WebElement RemoveSecondItem = driver.findElement(By.id("remove-sauce-labs-onesie"));

		RemoveFirstItem.click();
		RemoveSecondItem.click();

	}

	@Test(priority = 4)

	public void AddAllItemsToTheCart() {

		List<WebElement> AllThePrices = driver.findElements(By.className("inventory_item_price"));
		List<WebElement> AllAddButtons = driver.findElements(By.className("btn_primary"));
		List<WebElement> ItemsName = driver.findElements(By.className("inventory_item_name"));

		for (int i = 0; i < AllAddButtons.size(); i++) {

			if (i % 2 == 0) {

				AllAddButtons.get(i).click();
				System.out.println(ItemsName.get(i).getText() + " has been added and the price is"
						+ AllThePrices.get(i).getText());

			} else {

				System.out.println(ItemsName.get(i).getText() + " has not been added and the price is"
						+ AllThePrices.get(i).getText());

			}

		}

	}

	@Test(priority = 5)
	public void cheickout() {

		driver.navigate().to("https://www.saucedemo.com/cart.html");

	
		driver.findElement(By.id("checkout")).click();
		driver.findElement(By.id("first-name")).sendKeys("Mais");
		driver.findElement(By.id("last-name")).sendKeys("Alrousan");
		driver.findElement(By.id("postal-code")).sendKeys("0000");
		driver.findElement(By.id("continue")).click();
		driver.findElement(By.name("finish")).click();

	}

	@Test(priority = 6, enabled = true)
	public void logout() throws InterruptedException {

		WebElement BurgerMenu = driver.findElement(By.id("react-burger-menu-btn"));

		BurgerMenu.click();

		Thread.sleep(1000);

		WebElement LogoutButton = driver.findElement(By.id("logout_sidebar_link"));

		LogoutButton.click();

	}

	
	@AfterTest

	public void afterthetestisdone() {

		driver.close();

	}
	
}
