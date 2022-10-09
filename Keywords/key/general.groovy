package key
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.webui.keyword.internal.WebUIAbstractKeyword

import org.testng.Assert


import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import org.openqa.selenium.support.ui.Select

import java.util.concurrent.ThreadLocalRandom

import org.openqa.selenium.Keys as Keys


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;



import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait


import com.kms.katalon.core.webui.common.WebUiCommonHelper

import org.apache.commons.lang.RandomStringUtils



class General {


	/**
	 * Refresh browser
	 */
	@Keyword
	static def refreshBrowser() {
		KeywordUtil.logInfo("Refreshing")
		WebDriver webDriver = DriverFactory.getWebDriver()
		webDriver.navigate().refresh()
		KeywordUtil.markPassed("Refresh successfully")
	}

	/**
	 * Click element
	 * @param to Katalon test object
	 */
	@Keyword
	static def clickElement(TestObject to) {
		try {
			WebElement element = WebUiBuiltInKeywords.findWebElement(to);
			KeywordUtil.logInfo("Clicking element")
			element.click()
			KeywordUtil.markPassed("Element has been clicked")
		} catch (WebElementNotFoundException e) {
			KeywordUtil.markFailed("Element not found")
		} catch (Exception e) {
			KeywordUtil.markFailed("Fail to click on element")
		}
	}

	/**
	 * Get all rows of HTML table
	 * @param table Katalon test object represent for HTML table
	 * @param outerTagName outer tag name of TR tag, usually is TBODY
	 * @return All rows inside HTML table
	 */
	@Keyword
	def List<WebElement> getHtmlTableRows(TestObject table, String outerTagName) {
		WebElement mailList = WebUiBuiltInKeywords.findWebElement(table)
		List<WebElement> selectedRows = mailList.findElements(By.xpath("./" + outerTagName + "/tr"))
		return selectedRows
	}



	@Keyword
	static def pageGoingToURL(String url) {
		WebUI.openBrowser(url);
		WebUI.maximizeWindow();
		WebUI.waitForPageLoad(10);
	}



	@Keyword
	static def pageVerifyTheTextPresent(String text) {
		WebUI.verifyTextPresent(text, false);
	}


	@Keyword
	static def pageVerifyTheTextNotPresent(String text) {
		WebUI.verifyTextNotPresent(text, false)
	}


	@Keyword
	static def pageVerifyTheTextField(arg0, arg1) {
		Assert.assertEquals(arg0, arg1)
	}


	@Keyword
	static def pageVerifyElementText(findTestObject, text) {
		WebUI.verifyElementText(findTestObject, text)
	}


	@Keyword
	static def pageSetTheText(findTestObject, text) {
		WebUI.setText(findTestObject, text)
	}


	@Keyword
	static def pageSendKeys(findTestObject, text) {
		WebUI.sendKeys(findTestObject, text)
	}


	@Keyword
	static def pageCloseBrowser() {
		WebUI.closeBrowser()
	}


	@Keyword
	static def pageWait(timeout) {
		WebUI.waitForPageLoad(timeout)
	}


	@Keyword
	static def iWaitFor(seconds) {
		WebUI.delay(seconds)
	}




	@Keyword
	static def scrollToElement(TestObject to, int timeout) {
		WebUI.scrollToElement(to, timeout)
	}


	@Keyword
	static def switchFrame(findTestObject, timeOut) {
		WebUI.switchToFrame(findTestObject, timeOut)
	}


	@Keyword
	static def switchWindow(index) {
		WebUI.switchToWindowIndex(index)
	}


	@Keyword
	static def closeTheBrowser() {
		WebUI.closeBrowser()
	}



	@Keyword
	static def clearTheTextField(TestObject to){
		WebUI.sendKeys(to, Keys.chord(Keys.CONTROL, 'a'))
		WebUI.sendKeys(to, Keys.chord(Keys.BACK_SPACE))
	}


	@Keyword
	static def copyText(TestObject to){
		WebUI.sendKeys(to, Keys.chord(Keys.CONTROL, 'a'))
		WebUI.sendKeys(to, Keys.chord(Keys.CONTROL, 'c'))
	}



	@Keyword
	static def pasteText(TestObject to){
		WebUI.sendKeys(to, Keys.chord(Keys.CONTROL, 'v'))
	}


	@Keyword
	static def clickTAB(TestObject to){
		WebUI.sendKeys(to, Keys.chord(Keys.TAB))
	}


	@Keyword
	static def getEmail(String suffix,String prefix){
		int randomNo = (int)(Math.random() * 100000);
		return suffix + randomNo + "@" + prefix;
	}




	@Keyword
	static def getMobileNumber(){
		long randomNo = (long) Math.floor(Math.random() * 9000000000L);
		Integer length = String.valueOf(randomNo).length();
		if (length >= 8) {
			return '0812' + randomNo;
		}

		return '081' + randomNo;
	}


	



}