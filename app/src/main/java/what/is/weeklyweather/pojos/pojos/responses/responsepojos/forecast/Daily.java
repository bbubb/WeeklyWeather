package what.is.weeklyweather.pojos.pojos.responses.responsepojos.forecast;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Daily{

	@SerializedName("summary")
	private String summary;

	@SerializedName("data")
	private List<what.is.weeklyweather.pojos.pojos.responses.responsepojos.forecast.DataItem> data;

	@SerializedName("icon")
	private String icon;

	public void setSummary(String summary){
		this.summary = summary;
	}

	public String getSummary(){
		return summary;
	}

	public void setData(List<DataItem> data){
		this.data = data;
	}

	public List<what.is.weeklyweather.pojos.pojos.responses.responsepojos.forecast.DataItem> getData(){
		return data;
	}

	public void setIcon(String icon){
		this.icon = icon;
	}

	public String getIcon(){
		return icon;
	}

	@Override
 	public String toString(){
		return 
			"Daily{" + 
			"summary = '" + summary + '\'' + 
			",data = '" + data + '\'' + 
			",icon = '" + icon + '\'' + 
			"}";
		}
}