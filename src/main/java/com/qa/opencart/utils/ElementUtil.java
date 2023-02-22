package com.qa.opencart.utils;


import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {

	private WebDriver driver;
	//private JSUtil jsutil;

	public ElementUtil(WebDriver driver) {

		this.driver = driver;
		//jsutil = new JSUtil(driver);

	}

	public WebElement getElement(By locator) {
		
		// WebElement ele = driver.findElement(locator);
		// if (Boolean.parseBooleanOf(DriverFactory.highlight)){
		
		//  call flash method from js util

		return driver.findElement(locator);
	}

	public void doSendKeys(By locator, String value) {

		getElement(locator).sendKeys(value);
	}

	public void doClick(By locator) {

		getElement(locator).click();
	}

	public String dogetText(By locator) {

		return getElement(locator).getText();
	}

	public boolean doISDisplayed(By locator) {

		return getElement(locator).isDisplayed();
	}

	public boolean doIsEnabled(By locator) {

		return getElement(locator).isEnabled();
	}

	public boolean doIsSelected(By locator) {

		return getElement(locator).isSelected();
	}

	public String doGetAttribute(By locator, String AttributeName) {

		return getElement(locator).getAttribute(AttributeName);
	}

	public boolean checkElementIsDisabled(By locator, String AttributeName) {

		String attributevalue = getElement(locator).getAttribute(AttributeName);

		if (attributevalue.equals("true")) {

			return true;
		} else {

			return false;
		}

	}

	public List<WebElement> getElements(By locator) {

		return driver.findElements(locator);
	}

	// total images on the page
	// for each impage , print src and alt value

	public void totallinks() {

		List<WebElement> linklist = driver.findElements(By.tagName("img"));

		for (WebElement e : linklist) {

			String scrvalue = e.getAttribute("src");
			String altvalue = e.getAttribute("alt");

			System.out.println(scrvalue);

			System.out.println(altvalue);
		}

	}

	public void totallinks1() {

		List<WebElement> linklist = driver.findElements(By.tagName("img"));

		for (int i = 0; i <= linklist.size() - 1; i++) {

			String text = linklist.get(i).getAttribute("src");

			String text1 = linklist.get(i).getAttribute("alt");
		}

	}

	public boolean doSelectByVisibleText(By locator, String text) {

		Select se = new Select(getElement(locator));

		se.selectByVisibleText(text);

		String text2 = se.getFirstSelectedOption().getText();

		if (text2.equals(text)) {

			return true;
		}
		return false;
	}

	public void getOptionsDropdown(By locator) {

		Select se = new Select(getElement(locator));

		List<WebElement> options = se.getOptions();

		for (WebElement e : options) {

			e.getText();
		}
	}

	public void selectValueFromDropdown(By locator, String value) {

		List<WebElement> options = getElements(locator);

		for (WebElement e : options) {

			String text = e.getText();

			if (text.equals(value)) {

				e.click();
				break;
			}
		}
	}

	public void iterateAndSelect(List<WebElement> optionslist, String value) {

		for (WebElement e : optionslist) {

			String text = e.getText();

			if (text.equalsIgnoreCase(value)) {

				e.click();
				break;
			}
		}

	}

	public WebElement waitForElementPresent(int timeout, By locator) {

		WebDriverWait wait = new WebDriverWait(driver, timeout);

		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	public Alert waitForJSAlert(int tinmeout) {

		WebDriverWait wait = new WebDriverWait(driver, tinmeout);

		return wait.until(ExpectedConditions.alertIsPresent());

	}

	public void AcceptAlert(int tinmeout) {

		Alert jsAlert = waitForJSAlert(tinmeout);

		jsAlert.accept();

	}

	public void waitFirURLTitle(int timeout, String urlfraction) {

		WebDriverWait wait = new WebDriverWait(driver, timeout);

		if (wait.until(ExpectedConditions.urlContains(urlfraction))) {

			driver.getCurrentUrl();
		}
	}

	public List<WebElement> waitForElements(By locator, int timeout) {

		WebDriverWait wait = new WebDriverWait(driver, timeout);

		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}

	public List<String> getElementsText(By locator, int timeout) {

		List<String> list = new ArrayList<String>();

		List<WebElement> waitForElements = waitForElements(locator, timeout);

		for (WebElement e : waitForElements) {

			String text = e.getText();

			list.add(text);

		}
		return list;
	}
	
	
	

}
