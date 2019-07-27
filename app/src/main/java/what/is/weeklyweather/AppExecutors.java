package what.is.weeklyweather;

import android.os.Handler;
import android.os.Looper;

import androidx.annotation.MainThread;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class AppExecutors {

    private static final Object LOCK = new Object();
    private Executor diskId;
    private Executor networkId;
    private Executor mainThread;
    private static AppExecutors sInstance;

    public AppExecutors(Executor diskId, Executor networkId, Executor mainThread) {
        this.diskId = diskId;
        this.networkId = networkId;
        this.mainThread = mainThread;
    }

    public static AppExecutors getInstance(){
        if(sInstance==null){
            synchronized (LOCK){
                sInstance= new AppExecutors(Executors.newSingleThreadExecutor(),
                        Executors.newFixedThreadPool(4),
                        new MainThreadExecutor());
            }
        }
        return sInstance;
    }

    public Executor getDiskId() {
        return diskId;
    }

    public void setDiskId(Executor diskId) {
        this.diskId = diskId;
    }

    public Executor getNetworkId() {
        return networkId;
    }

    public void setNetworkId(Executor networkId) {
        this.networkId = networkId;
    }

    public Executor getMainThread() {
        return mainThread;
    }

    public void setMainThread(Executor mainThread) {
        this.mainThread = mainThread;
    }

    private static class MainThreadExecutor implements Executor{
        private Handler mainThreadHandler = new Handler(Looper.getMainLooper());

        @Override
        public void execute(Runnable runnable) {
            mainThreadHandler.post(runnable);
        }
    }
}
