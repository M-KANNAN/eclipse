package ChatBot;

public class ChatBotDatas {

	private int layer;
	private int choice;
	
	public ChatBotDatas(int choice, int layer) {
		this.choice=choice;
		this.layer=layer;
	}
	public int getLayer() {
		return layer;
	}
	public void setLayer(int layer) {
		this.layer = layer;
	}
	public int getChoice() {
		return choice;
	}
	public void setChoice(int choice) {
		this.choice = choice;
	}
	
}
