package topTestKeywords

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import com.kms.katalon.core.webui.driver.DriverFactory

import internal.GlobalVariable

public class Login {

	@Keyword
	def loginAsUser(String username, String password){

		WebUI.setText(findTestObject('Object Repository/Page_System Dashboard - Jira/Username Field'), username)

		WebUI.setText(findTestObject('Object Repository/Page_System Dashboard - Jira/Password Field'), password)

		WebUI.click(findTestObject('Object Repository/Page_System Dashboard - Jira/Login Button'))

		WebUI.waitForElementVisible(findTestObject('Object Repository/Page_System Dashboard - Jira/User Avatar'), 10)
	}

	@Keyword
	def openBrowser(){
		WebUI.openBrowser('')
		WebUI.maximizeWindow()
		WebUI.navigateToUrl(GlobalVariable.BaseURL)
	}

	@Keyword
	def goToTheWorkflow(int timeout){
		WebUI.navigateToUrl(GlobalVariable.BaseURL + '/projects/TWT?selectedItem=com.codecanvas.glass:glass')
		WebUI.waitForElementVisible(findTestObject('Object Repository/Page_ToP Week6 Test - Jira/Issue Dropdown'), timeout)
		WebUI.click(findTestObject('Object Repository/Page_ToP Week6 Test - Jira/Issue Dropdown'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/Page_ToP Week6 Test - Jira/Issue Type'), timeout)
		WebUI.click(findTestObject('Object Repository/Page_ToP Week6 Test - Jira/Issue Type'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/Project Workflow/WorkflowTransitionsTitle'), timeout)
	}

	@Keyword
	String getWebElementsAsListSize(String xpath) {
		WebDriver webDriver = DriverFactory.getWebDriver()
		List<WebElement> elements = webDriver.findElements(By.xpath(xpath))
		return elements.size().toString()
	}
}

