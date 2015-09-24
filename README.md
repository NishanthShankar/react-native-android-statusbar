# React Native Android Status bar



A react native android module to control the android statusbar.

## Setup

* install module

This module is currently inactive
```bash
# npm i --save react-native-android-statusbar
```

* `android/settings.gradle`

```gradle
...
include ':react-native-android-statusbar'
project(':react-native-android-statusbar').projectDir = new File(settingsDir, '../node_modules/react-native-android-statusbar')
```

* `android/app/build.gradle`

```gradle
...
dependencies {
    ...
    compile project(':react-native-android-statusbar')
}
```

* register module (in MainActivity.java)

```java
import me.neo.react.StatusBarPackage;  // <--- import

public class MainActivity extends Activity implements DefaultHardwareBackBtnHandler {

  ......
  private static Activity mActivity = null;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    mReactRootView = new ReactRootView(this);

    mActivity = this;
    mReactInstanceManager = ReactInstanceManager.builder()
      .setApplication(getApplication())
      .setBundleAssetName("index.android.bundle")
      .setJSMainModuleName("index.android")
      .addPackage(new MainReactPackage())
      .addPackage(new StatusBarPackage())      // <------- add package
      .setUseDeveloperSupport(BuildConfig.DEBUG)
      .setInitialLifecycleState(LifecycleState.RESUMED)
      .build();

    mReactRootView.startReactApplication(mReactInstanceManager, "ExampleRN", null);

    setContentView(mReactRootView);
  }

  //Add this static function
  public static Activity getActivity(){
      Activity activity = new Activity();
      activity = mCurrentActivity;
      return activity;
  }

  ......

}
```

## Usage

```js
var StatusBarAndroid = require('react-native-android-statusbar');


StatusBarAndroid.hideStatusBar() // Does not reflect on versions before 16
StatusBarAndroid.showStatusBar() // Does not reflect on versions before 16
StatusBarAndroid.setRGB(int red, int green, int blue);// Does not reflect on versions before 21
StatusBarAndroid.setARGB(int alpha,int red, int green, int blue);// Does not reflect on versions before 21
StatusBarAndroid.setHexColor('#AB1223'); // Does not reflect on versions before 21
/*Supported formats are: #RRGGBB #AARRGGBB
or one of the following names: 'red', 'blue', 'green', 'black', 'white', 'gray', 'cyan', 'magenta', 'yellow', 'lightgray', 'darkgray', 'grey', 'lightgrey', 'darkgrey', 'aqua', 'fuchsia', 'lime', 'maroon', 'navy', 'olive', 'purple', 'silver', 'teal'.*/


```
