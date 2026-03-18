package sit707_week2;

public class Main {
	public static void main(String[] args) {

		System.out.println("Starting Officeworks...");
		SeleniumOperations.officeworks_registration_page("https://www.officeworks.com.au/app/identity/create-account");

		System.out.println("Starting OnePageCRM...");
		SeleniumOperations.onepagecrm_registration_page("https://secure.onepagecrm.com/register");
	}
}