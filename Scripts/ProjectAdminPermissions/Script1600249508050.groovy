import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.testobject.ConditionType as ConditionType

String xpath = ('//span[@class=\'aui-icon aui-icon-small aui-iconfont-sidebar-link glass-middle-position\']/ancestor::a[@href=\'' + 
root) + '\']'

TestObject tObject = new TestObject('sortCut')

tObject.addProperty('xpath', ConditionType.EQUALS, xpath)

TestObject tab = new TestObject('clickableTab')

tab.addProperty('xpath', ConditionType.EQUALS, clickableTab)

CustomKeywords.'topTestKeywords.Login.openBrowser'()

CustomKeywords.'topTestKeywords.Login.loginAsUser'(GlobalVariable.ProjectAdminNameAndPass, GlobalVariable.ProjectAdminNameAndPass)

WebUI.navigateToUrl(GlobalVariable.BaseURL + '/projects/TWT?selectedItem=com.codecanvas.glass:glass')

WebUI.waitForElementVisible(tab, timeout)

WebUI.click(tab)

WebUI.verifyElementPresent(tObject, timeout)

WebUI.click(tObject)

WebUI.switchToWindowIndex(1)

WebUI.waitForElementVisible(findTestObject('Object Repository/Project settings/Project Settings Title'), timeout)

CustomKeywords.'kms.turing.katalon.plugins.assertj.StringAssert.equals'(WebUI.getUrl(), expectedUrl, false, '', FailureHandling.STOP_ON_FAILURE)

