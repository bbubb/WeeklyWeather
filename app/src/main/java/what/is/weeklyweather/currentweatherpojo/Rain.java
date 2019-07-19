package what.is.weeklyweather.currentweatherpojo;

import com.google.gson.annotations.SerializedName;


public class Rain{

	@SerializedName("1h")
	private double jsonMember1h;

	public void setJsonMember1h(double jsonMember1h){
		this.jsonMember1h = jsonMember1h;
	}

	public double getJsonMember1h(){
		return jsonMember1h;
	}

	@Override
 	public String toString(){
		return 
			"Rain{" + 
			"1h = '" + jsonMember1h + '\'' + 
			"}";
		}
}