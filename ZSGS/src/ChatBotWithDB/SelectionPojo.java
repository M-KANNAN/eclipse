package ChatBotWithDB;

public class SelectionPojo {
	
	private int layerId;
	public SelectionPojo() {
		
	}
	public int getLayerId() {
		return layerId;
	}
	public void setLayerId(int layerId) {
		this.layerId = layerId;
	}
	public int getOptionId() {
		return optionId;
	}
	public void setOptionId(int optionId) {
		this.optionId = optionId;
	}
	public int getChoice_Id() {
		return choice_Id;
	}
	public void setChoice_Id(int choice_Id) {
		this.choice_Id = choice_Id;
	}
	private int optionId;
	private int choice_Id;
	
	
}
