package pageobject;



public class PageObject {

	/*________page login__________*/
	public String email ="//input[@id='username']";
	public String countinue ="//input[@id='continue']";
	
	public String username = "//input[@id='desktop']";
	public String password ="password";
	public String signbutton ="//button[@id='btn_signin']";
	public String remember="//label[@name='checkbox1_lbl']";
	
	
	/*_________authentication page_______*/
	public String otp_header="Authorize this device";
	public String otp ="//a[@id='smsOTP']";
	//public String otppass="	//input[@id='otppswd']";
	public String submitbutton="//button[@id='btn_submit']";
	
	/*_________Compose page_______*/
	public String conmposebutton ="//button[@class='compose-button']";
	public String compose_to="//div[@id='dijit__TemplatedMixin_15']";
	public String subject="//input[@id='uniqName_142_0_subjectInput']";
	public String frame_body="//iframe[@title='Rich Text Editor']";
	public String body="//body[@class='socpimEditorBody cke_editable cke_editable_themed cke_contents_ltr']";
	public String sendMail="//button[@class='socpimBtn socpimSend socpimBtnEnabled']";
	
	
	
	
	
	
	
	public String lastname = "//input[@name='password']";
	public String submitbut= "//input[@value='Submit']";
	
	
	public String radio= "//input[@value='female']";
	public String checkbox= "//input[@value='qtp']";
	
	public String dropdown="Tools";
	
	public String linkingtext="Click on link to open new window!";
}
