package main_package;

import android.app.Application;
import android.content.Context;

public class YummiApp extends Application {
    public void onCreate() {
        super.onCreate();
    }

    public static APIHandler getClient(Context context) {
        return (APIHandler) APIHandler.getInstance(APIHandler.class, context);
    }
}
