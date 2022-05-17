import org.json.simple.JSONObject;

public class Jsonex {

	public static void main(String[] args) {
		

		JSONObject obj=new JSONObject();
		obj.put("UserName", "kanna");
		System.out.println(obj);
		System.out.println(obj.get("UserName"));

	}

}
