
package what.is.weeklyweather.pojos.pojos.responses.responsepojos.forecast;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Daily {

    @SerializedName("data")
    private List<Datum> mData;
    @SerializedName("icon")
    private String mIcon;
    @SerializedName("summary")
    private String mSummary;

    public List<Datum> getData() {
        return mData;
    }

    public void setData(List<Datum> data) {
        mData = data;
    }

    public String getIcon() {
        return mIcon;
    }

    public void setIcon(String icon) {
        mIcon = icon;
    }

    public String getSummary() {
        return mSummary;
    }

    public void setSummary(String summary) {
        mSummary = summary;
    }

}
