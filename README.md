# Status bar for react-native android

[![npm version](https://badge.fury.io/js/react-native-android-statusbar.svg)](https://badge.fury.io/js/react-native-android-statusbar)

A react native android module to control the android statusbar.

## Setup

There are five steps in the setup process

1. install module
2. update `android/settings.gradle`
- update `android/app/build.gradle`
- Register module in MainActivity.java
- Rebuild and restart package manager



* install module

```bash
 npm i --save react-native-android-statusbar
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
      .addPackage(new StatusBarPackage(this))      // <------- add package, the 'this' is super important
      .setUseDeveloperSupport(BuildConfig.DEBUG)
      .setInitialLifecycleState(LifecycleState.RESUMED)
      .build();

    mReactRootView.startReactApplication(mReactInstanceManager, "ExampleRN", null);

    setContentView(mReactRootView);
  }

  ......

}
```
* Run `react-native run-android` from your project root directory




## Usage

```js
var StatusBarAndroid = require('react-native-android-statusbar');

/* The following functions do not reflect on versions before 16 */
StatusBarAndroid.hideStatusBar()
StatusBarAndroid.showStatusBar()

/* The following functions do not reflect on versions before 21 */
StatusBarAndroid.setRGB(int red, int green, int blue);
StatusBarAndroid.setARGB(int alpha,int red, int green, int blue);
StatusBarAndroid.setHexColor('#AB1223'); /*Supported formats are: #RRGGBB #AARRGGBB or :
'red', 'blue', 'green', 'black', 'white', 'gray', 'cyan', 'magenta', 'yellow',
'lightgray', 'darkgray', 'grey', 'lightgrey', 'darkgrey', 'aqua',
'fuchsia', 'lime', 'maroon', 'navy', 'olive', 'purple', 'silver', 'teal'.*/


```
