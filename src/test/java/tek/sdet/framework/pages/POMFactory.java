package tek.sdet.framework.pages;

import tek.sdet.framework.base.BaseSetup;

public class POMFactory extends BaseSetup {

	private RetailAccountPage account;
	private RetailHomePage home;
	private RetailOrderPage order;
	private RetailSignInPage signIn;

	public POMFactory() {

		this.account = new RetailAccountPage();
		this.home = new RetailHomePage();
		this.order = new RetailOrderPage();
		this.signIn = new RetailSignInPage();
	}
	
	public RetailAccountPage account() {
		return this.account;
	}
	
	public RetailHomePage home() {
		return this.home;
	}
	
	public RetailOrderPage order() {
		return this.order;
	}

	public RetailSignInPage signIn() {
		return this.signIn;
	}

}
