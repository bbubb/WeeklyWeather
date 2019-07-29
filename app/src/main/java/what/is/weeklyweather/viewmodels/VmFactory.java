package what.is.weeklyweather.viewmodels;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import what.is.weeklyweather.database.WeatherDatabase;

public class VmFactory extends ViewModelProvider.NewInstanceFactory {

    WeatherDatabase mDb;
    int id;

public VmFactory(WeatherDatabase mDb, int id){
this.mDb = mDb;
this.id = id;
}

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new VmMainActivity();
    }
}
