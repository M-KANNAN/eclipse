package ChatBot;

public class ChatBotOutput {

}

//plan details
enum Layer1{
	OUTPUT("Hi Welcome to NETFLIX \nChoose Your Plan"),Exit("Bye Bye"),
	CHOICE_1("1.Basic Plan"),CHOICE_2("2.Premium Plan"),CHOICE_X("Exit 0") ;
	private final String output;
	Layer1(final String output) {
		this.output = output;		
	}
	
	public String toString() {
		return output;
	}	
}
//for Basic Plan
enum LayerA2{
	OUTPUT("Hey Buddy Choose the Language"),
	CHOICE_1("1.English"),CHOICE_2("2.Tamil"),CHOICE_X("Exit 0"),CHOICE_BACK("9.<-Back");

	private final String output;
	LayerA2(final String output) {
		this.output = output;		
	}
	
	public String toString() {
		return output;
	}	
}
//for vip Plan
enum LayerB2{
	OUTPUT("Hey Buddy Choose the Language"),
	CHOICE_1("1.English"),CHOICE_2("2.Tamil"),CHOICE_3("3.Malayalam"),CHOICE_X("Exit 0"),CHOICE_BACK("9.<-Back");

	private final String output;
	LayerB2(final String output) {
		this.output = output;		
	}
	
	public String toString() {
		return output;
	}
	
}
enum LayerA3{
	OUTPUT("Hey Buddy Choose the Category"),
	CHOICE_1("1.Movies"),CHOICE_2("2.Series"),CHOICE_X("Exit 0"),CHOICE_BACK("9.Back");

	private final String output;
	LayerA3(final String output) {
		this.output = output;		
	}
	
	public String toString() {
		return output;
	}
	
}
enum LayerB3{
	OUTPUT("Hey Buddy Choose the Category"),
	CHOICE_1("1.Movies"),CHOICE_2("2.Series"),CHOICE_3("3.TV Shows"),CHOICE_X("Exit 0"),CHOICE_BACK("9.Back");
	//OUTPUT("கீழே உள்ளதை தேர்வு செய்யவும்"),
  //CHOICE_1("1.திரைப்படம்"),CHOICE_2("2.இணையத் தொடர்கள்"),CHOICE_X(" வெளியேற 0 ஐ அழுத்தவும் "),CHOICE_BACK("9.திரும்பி செல்ல");
 
	private final String output;
	LayerB3(final String output) {
		this.output = output;		
	}
	
	public String toString() {
		return output;
	}
	
}