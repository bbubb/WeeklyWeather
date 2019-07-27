package what.is.weeklyweather;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import java.text.DecimalFormat;
import java.util.List;

//import butterknife.BindView;
//import butterknife.ButterKnife;
//import what.is.weeklyweather.database.WeatherDatabase;
//import what.is.weeklyweather.pojos.pojos.LocationEntry;
//import what.is.weeklyweather.viewmodels.VmSplash;
//
//public class SplashScreen extends AppCompatActivity implements LocationListener {
//    private static int SPLASH_TIMER = 5000;
//    LocationManager locationManager;
//    @BindView(R.id.tv_lng_cords)
//    TextView tvLngCords;
//    @BindView(R.id.tv_lat_cords)
//    TextView tvLatCords;
//    DecimalFormat twoDForm;
//    AppExecutors roomExectuor;
//    WeatherDatabase mWeatherDb;
//    LocationEntry locationEntry;
//    Intent i;
//
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.splash);
//        ButterKnife.bind(this);
//        i = new Intent(SplashScreen.this, MainActivity.class);
//        getLocation();
//        roomExectuor.getDiskId().execute(new Runnable() {
//            @Override
//            public void run() {
//                mWeatherDb.locationDAO().insert(locationEntry);
//            }
//        });
//
//        VmSplash vmSplash = ViewModelProviders.of(this).get(VmSplash.class);
//        vmSplash.getAllLocationEntries().observe(this, new Observer<List<LocationEntry>>() {
//            @Override
//            public void onChanged(List<LocationEntry> locationEntries) {
//                Location mLocation = locationEntries.get(0).getLocation();
//
//            }
//        });
//        if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//            // TODO: Consider calling
//            //    Activity#requestPermissions
//            // here to request the missing permissions, and then overriding
//            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
//            //                                          int[] grantResults)
//            // to handle the case where the user grants the permission. See the documentation
//            // for Activity#requestPermissions for more details.
//
//            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION}, 101);
//        }
//
//
//        Location location = null;
//
//        getLocation();
//
//        new Handler().postDelayed(new Runnable() {
//
//            //Runs while Delay
//
//
//            @Override
//            public void run () {
//                //runs after delay
//
//                startActivity(i);
//
//                //close this activity
//                finish();
//            }
//        },SPLASH_TIMER);
//    }
//
//
//
//    void getLocation() {
//        try {
//            locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
//            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 5, this);
//        } catch (SecurityException e) {
//            e.printStackTrace();
//        }
//    }
//
//
//
//    @Override
//    public void onLocationChanged(Location location) {
//        twoDForm = new DecimalFormat("#0.0000");
//        tvLngCords.setText(String.valueOf(twoDForm.format(location.getLongitude())));
//        tvLatCords.setText(String.valueOf(twoDForm.format(location.getLatitude())));
//        mWeatherDb.locationDAO().insert(locationEntry);
//        i.putExtra("lng", String.valueOf(twoDForm.format(location.getLongitude())));
//        i.putExtra("lat", String.valueOf(twoDForm.format(location.getLatitude())));
//    }
//
//    @Override
//    public void onStatusChanged(String s, int i, Bundle bundle) {
//
//    }
//
//    @Override
//    public void onProviderEnabled(String s) {
//
//    }
//
//    @Override
//    public void onProviderDisabled(String s) {
//        Toast.makeText(this, "Please enable GPS and Internet", Toast.LENGTH_SHORT).show();
//    }
//}
