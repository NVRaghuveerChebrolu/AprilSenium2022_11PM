package com.utility;

public class ObjectRepository2 {
public static final String GMO_OnlineSubmitButton= constants.Name + "&"+"bSubmit";
public static final String GMO_OnlineCatalog= constants.xpath + "&"+"//h1[text()='OnLine Catalog']";
public static final String QTY_BACKPACKS= constants.Name+"&"+"QTY_BACKPACKS";
public static final String UnitPriceFromWebTable= constants.xpath + "&"+"//table[@border='1']/tbody/tr[2]/td[4]";
public static final String TotalPriceFromWebTable=constants.xpath + "&"+ "//table[@border='1']/tbody/tr[2]/td[5]";
public static final String AlertButton=constants.ID+"&"+"alertButton";
public static final String Timer_Alertbutton=constants.ID+"&"+"timerAlertButton";
public static final String confirmAlertButton=constants.ID+"&"+"confirmButton";
public static final String confirmAlertResult=constants.xpath+"&"+"//span[@id='confirmResult']";
public static final String PromptAlertButton=constants.ID+"&"+"promtButton";
public static final String PromptAlertResult=constants.ID+"&"+"promptResult";

public static final String SingleIframe=constants.ID+"&"+"singleframe";
public static final String TextBoxOfSingle_Frame=constants.xpath+"&"+"//input[@type='text']";
public static final String IframeWithInIframe=constants.xpath+"&"+"//a[@href='#Multiple']";
public static final String MultipleFrame=constants.xpath+"&"+"//iframe[@src='MultipleFrames.html']";
public static final String SingleFrame=constants.xpath+"&"+"//iframe[@src='SingleFrame.html']";


public static final String FrameAnimals=constants.ID+"&"+"animals";

public static final String NewBrowserWindow=constants.Name+"&"+"newbrowserwindow123";
public static final String MenuOfNew_BrowserWindow=constants.xpath+"&"+"//span[contains(text(),'Menu')]";
public static final String About_Me_NewBrowserWindow=constants.xpath+"&"+"/span[text()='About Me']";
public static final String MouseOperationRightClick=constants.xpath+"&"+"//span[text()='right click me']";
public static final String SelectDeleteOptionInRightClick=constants.xpath+"&"+"//span[text()='Delete']";

public static final String Frame=constants.xpath+"&"+"//iframe";
public static final String BoxInsideFrame=constants.xpath+"&"+"//span[contains(text(),'Double click the block')]/preceding-sibling::div";

public static final String Draggable=constants.ID+"&"+"draggable";
public static final String Droppable=constants.ID+"&"+"droppable";

public static final String WebTableRows=constants.xpath+"&"+"//table[@id='example']/tbody/tr";

public static final String FileUploadBrowseButton=constants.xpath+"&"+"//input[@id='input-4']/preceding-sibling::span";

public static final String FileDownload100Kb=constants.xpath+"&"+"//table/tbody/tr[1]/td[5]/a";


public static final String DataDrivenFirstName=constants.xpath+"&"+"//input[@ng-model='FirstName']";
public static final String DataDrivenLastName=constants.xpath+"&"+"//input[@ng-model='LastName']";
public static final String DataDrivenAddress=constants.xpath+"&"+"//textarea[@ng-model='Adress']";
public static final String DataDrivenEmailAddress=constants.xpath+"&"+"//input[@ng-model='EmailAdress']";
public static final String DataDrivenPhoneNumber=constants.xpath+"&"+"//input[@ng-model='Phone']";
public static final String DataDrivenMale=constants.xpath+"&"+"//input[@value='Male']";
public static final String DataDrivenFeMale=constants.xpath+"&"+"//input[@value='FeMale']";
public static final String DataDrivenCricket=constants.ID+"&"+"checkbox1";
public static final String DataDrivenMovies=constants.ID+"&"+"checkbox2";
public static final String DataDrivenHockey=constants.ID+"&"+"checkbox3";
public static final String DataDrivenLanguages=constants.ID+"&"+"msdd";
public static final String DataDrivenAllLanguages=constants.xpath+"&"+"//div[@id='msdd']/following-sibling::div/ul/li";
public static final String DataDrivenSkillsField=constants.xpath+"&"+"//label[text()='Skills']";
public static final String DataDrivenSkills=constants.xpath+"&"+"//select[@id='Skills']";
public static final String DataDrivenAllSkills=constants.xpath+"&"+"//select[@id='Skills']/option";
public static final String DataDrivenSelectCountry=constants.xpath+"&"+"//span[@role='combobox']";
public static final String DataDrivenTextBoxOfSelectCountry=constants.xpath+"&"+"//input[@type='search']";


public static final String DataDrivenDOB_Years=constants.xpath+"&"+"//select[@id='yearbox']";
public static final String DataDrivenDOB_AllYears=constants.xpath+"&"+"//select[@id='yearbox']/option";

public static final String DataDrivenDOB_Months=constants.xpath+"&"+"//select[@placeholder='Month']";
public static final String DataDrivenDOB_AllMonths=constants.xpath+"&"+"//select[@placeholder='Month']/option";

public static final String DataDrivenDOB_Day=constants.ID+"&"+"daybox";
public static final String DataDrivenDOB_AllDays=constants.xpath+"&"+"//select[@id='daybox']/option";
public static final String DataDrivenDOB_Pwd=constants.ID+"&"+"firstpassword";
public static final String DataDrivenDOB_ConformPwd=constants.ID+"&"+"secondpassword";


























}
