package register
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

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

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When

import key.General

class VerifyRegisterSuccessFunder {
	public static TestObject daftarDisini = findTestObject("Register/aRegister")
	public static TestObject pilihPemberiDana = findTestObject("Register/imgPemberiDana")
	public static TestObject namaFunder = findTestObject("Register/inputRegisterNamaFunder")
	public static TestObject emailFunder = findTestObject("Register/inputRegisterEmailFunder")
	public static TestObject mobileNumber = findTestObject("Register/inputLenderPhone")
	public static TestObject password = findTestObject("Register/inputPassword")
	public static TestObject jenisAkunIndividual = findTestObject("Register/labelIndividual")
	public static TestObject silahkanPilih = findTestObject("Register/selectSilahkanPilih")
	public static TestObject pilihLinkedin = findTestObject("Register/selectPilihLinkedin")
	public static TestObject kodeReferral = findTestObject("Register/inputKodeRef")
	public static TestObject btnLanjutkan = findTestObject("Register/buttonLanjutkan")
	public static TestObject btnLanjutkanStepTwo = findTestObject("Register/buttonLanjutkanStepTwo")
	public static TestObject checkboxLangganan = findTestObject("Register/inputCheckboxLangganan")
	public static TestObject checkboxTC = findTestObject("Register/inputCheckboxTC")
	public static TestObject scrollSW = findTestObject("Register/divSW")
	public static TestObject scrollToContact = findTestObject("Register/contactAndMedsos")
	public static TestObject emailYopmail = findTestObject("Yopmail/inputMAil")
	public static TestObject btnGo = findTestObject("Yopmail/buttonGo")
	public static TestObject registerEmail = findTestObject("Yopmail/registerActivationEmail")
	public static TestObject emailInbox = findTestObject("Yopmail/iframeEmailInbox")
	public static TestObject bodyRegistrationEmail = findTestObject("Yopmail/iframeEmailBody")
	public static TestObject activationLink = findTestObject("Yopmail/registerActivationLink")
	public static TestObject masukAkun = findTestObject("Register/aMasukAkunSaya")
	public static TestObject usernameloginEmail = findTestObject("Register/inputEmailLogin")
	public static TestObject btnLoginAlami = findTestObject("Register/aLoginAlami")



	public static String regFunderName = "John Doe Alami"
	public static String regPassword = "Test.1234#@!"
	public static String regKodeReferral = "VR070"
	public static String inputUsername = ""


	public static String mail = General.getEmail('johndoealami', 'yopmail.com')

	public static String mobNumber = General.getMobileNumber()
	public static String mailinatorMail = General.getEmail('alamitest', 'yopmail.com')


	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */


	@Given("User on P2P DEV login page")
	def pageGoingToURL() {
		General.pageGoingToURL(GlobalVariable.P2P_DEV)
	}


	@And("User click daftar disini")
	def clickDaftarDisini() {
		General.clickElement(daftarDisini)
	}



	@And("User click pemberi dana")
	def clickPemberiDana() {
		General.clickElement(pilihPemberiDana)
	}

	@Then("User on register page")
	def verifyRegisterPage() {
		General.pageVerifyTheTextPresent("Registrasi Pemberi Dana")
	}


	@And("User input nama lengkap")
	def setName() {
		General.pageSetTheText(namaFunder, regFunderName)
		General.iWaitFor(3)
	}

	@And("User input email")
	def setEmail() {
		General.pageSetTheText(emailFunder, mail)
		General.iWaitFor(3)
		General.copyText(emailFunder)
		General.iWaitFor(3)
	}




	@And("User input nomor handphone")
	def setNomorHandphone() {
		General.pageSetTheText(mobileNumber, mobNumber)
	}


	@And("User input password")
	def setPassword() {
		General.pageSetTheText(password, regPassword)
	}


	@And("User pilih jenis akun individual")
	def setJenisAkun() {
		General.clickElement(jenisAkunIndividual)
	}

	@And("User input kode referral")
	def setKodeReferral() {
		General.pageSetTheText(kodeReferral, regKodeReferral)
	}

	@And("User pilih tahu dari linkedin")
	def setHowDoYouKnow() {
		General.clickElement(pilihLinkedin)
	}

	@And("User click lanjutkan")
	def clickContinue() {
		General.clickElement(btnLanjutkan)
		General.iWaitFor(10)
		General.pageVerifyTheTextPresent("Kebijakan Privasi & Ketentuan Pengguna")
	}

	@And("User click lanjutkan step two without accept TC")
	def clickLanjutkanStepTwoWithoutAcceptTC() {
		General.scrollToElement(btnLanjutkanStepTwo, 3)
		General.clickElement(btnLanjutkanStepTwo)
		General.iWaitFor(10)
		General.pageVerifyTheTextPresent("Kebijakan Privasi")
	}


	@And("User accept TC")
	def acceptTC() {
		General.clickElement(checkboxLangganan)
		General.clickElement(scrollSW)
		General.scrollToElement(scrollToContact, 3)


		General.clickElement(checkboxTC)
		General.clickElement(btnLanjutkanStepTwo)
		General.iWaitFor(5)
		General.pageVerifyTheTextPresent("Kamu sudah berhasil mendaftar sebagai Pemberi Dana. Silahkan klik link aktivasi yang dikirimkan ke email Kamu.")
	}


	@And("User access email to confirm the register")
	def pageGoingToYopmail() {
		General.pageGoingToURL(GlobalVariable.Yopmail)
		General.pasteText(emailYopmail)
		General.iWaitFor(3)
		General.clickElement(btnGo)
	}




	@And("User scroll down the register email page")
	def scrollDownTheRegisterEmailPage() {
		General.switchFrame(bodyRegistrationEmail, 10)
		General.scrollToElement(activationLink, 10)
		General.pageWait(10)
	}


	@And("User confirm the register link")
	def clickRegisterLink() {
		General.clickElement(activationLink)
		General.pageWait(10)
		General.switchWindow(1)
		General.pageWait(10)
		General.pageVerifyTheTextPresent("Alhamdulillah")
	}


	@And("User login with new credentials")
	def clickMasukAkun() {
		General.clickElement(masukAkun)
		General.pageWait(10)
		General.switchWindow(1)
		General.pageWait(10)
		General.pasteText(usernameloginEmail)
		General.pageSetTheText(password, regPassword)
		General.clickElement(btnLoginAlami)
		General.iWaitFor(10)
	}


	@Then("User on funder dashboard page")
	def verifyFunderDashboarPage() {
		General.pageVerifyTheTextPresent("John Doe Alami")
		General.pageVerifyTheTextPresent("Belum terverifikasi")
		General.iWaitFor(10)
		General.pageVerifyTheTextPresent("Lengkapi Profilmu Untuk Aktivasi Akun dan RDF (Rekening Dana Funder)")
	}
}