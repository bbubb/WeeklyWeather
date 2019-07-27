package what.is.weeklyweather.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import what.is.weeklyweather.pojos.pojos.LocationEntry;
import what.is.weeklyweather.repositories.LocationRepository;

public class VmSplash extends AndroidViewModel {
    public static final String TAG = VmSplash.class.getSimpleName();
    private LiveData<List<LocationEntry>> mAllLocationEntries;
    private LocationRepository mLocationRepository;

    public VmSplash(@NonNull Application application){
        super(application);
        mLocationRepository = new LocationRepository(application);
        mAllLocationEntries = mLocationRepository.getAllLocationEntries();
    }

    public LiveData<List<LocationEntry>> getAllLocationEntries(){return mAllLocationEntries;}
    public void insert(LocationEntry locationEntry){mLocationRepository.insert(locationEntry);}
    public void update(LocationEntry locationEntry){mLocationRepository.update(locationEntry);}

}
