package what.is.weeklyweather.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

public class VmMainActivity extends AndroidViewModel {

    private static final String TAG = VmMainActivity.class.getSimpleName();

    public VmMainActivity(@NonNull Application application) {
        super(application);
    }
}
