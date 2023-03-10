package com.kangfenmao.reactnativeminimizer;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import android.app.Activity;
import android.content.Intent;

@ReactModule(name = ReactNativeMinimizerModule.NAME)
public class ReactNativeMinimizerModule extends ReactContextBaseJavaModule {
  public static final String NAME = "ReactNativeMinimizer";
  private ReactApplicationContext reactContext;

  public ReactNativeMinimizerModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @Override
  @NonNull
  public String getName() {
    return NAME;
  }

  @ReactMethod
  public void exit() {
    Activity activity = this.reactContext.getCurrentActivity();
    activity.finishAffinity();
    System.exit(0);
  }

  @ReactMethod
  public void goBack() {
    Activity activity = this.reactContext.getCurrentActivity();
    activity.moveTaskToBack(true);
  }

  @ReactMethod
  public void minimize() {
    Intent startMain = new Intent(Intent.ACTION_MAIN);
    startMain.addCategory(Intent.CATEGORY_HOME);
    startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    this.reactContext.startActivity(startMain);
  }
}
