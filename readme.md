> 关注公众号学习更多知识
>
>![](https://img-blog.csdnimg.cn/img_convert/6dd2df09156ca4cbfc44ad68c9baa2e4.png)
## 概述
`android12`新增了一个`SplashScreen`的启动页辅助类。不过他并不能向下兼容，只能在`android12`进行使用。因此官方在`jetpack`中开发了可以向下进行兼容的`jetpack版SplashScreen`（目前仍然是alpha所以还不不建议在项目中使用）。本文会简单讲讲`jetpack版SplashScreen`的使用。


## 简易使用
### 引入依赖

```groovy
implementation 'androidx.core:core-splashscreen:1.0.0-alpha02'

```

### 配置主题

```xml
<style name="AnananSplashScreen" parent="Theme.SplashScreen">
        # 启动画面的背景，默认使用 windowBackground
        <item name="windowSplashScreenBackground">#d73</item>
        # 指定 icon，支持静态 drawable 或动画 vector drawable
        <item name="windowSplashScreenAnimatedIcon">@mipmap/ic_launcher</item>
        # 动画 icon 时长，上限 1000 ms
        <item name="windowSplashScreenAnimationDuration">1000</item>
        # 启动画面退出后 Activity 的主题
        <item name="postSplashScreenTheme">@style/Theme.SplashScreenSample</item>
        # 设置图标北京颜色，本例中图标是不透明的，所以看不到效果
        <item name="windowSplashScreenIconBackgroundColor">#f00</item>
    </style>
```
### 在manifest中配置activity主题

```xml
 <activity
            android:name=".MainActivity"
            android:theme="@style/AnananSplashScreen"
            android:exported="true">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />
                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
```


### Activity中配置SplashScreen代码
只需要一行代码，安装jetpack版的`SplashScreen`即可使用
```kt
installSplashScreen()
```
### 延长展示时间
`setKeepVisibleCondition`方法可以延长显示时间
```kt
 private fun initSplashScreen() {
        var startMillis = SystemClock.uptimeMillis()
        val mSplashScreenView = installSplashScreen()
        mSplashScreenView.setKeepVisibleCondition {
            SystemClock.uptimeMillis() - startMillis < 1000 * 3
        }
    }
```
### 效果图

![SplashScreen.gif](https://p1-juejin.byteimg.com/tos-cn-i-k3u1fbpfcp/6b71d7966ff64e95bc5d65c6375fc159~tplv-k3u1fbpfcp-watermark.image?)


## 属性说明
### windowSplashScreenAnimatedIcon
中心图标
### windowSplashScreenBackground
整屏的背景颜色
### windowSplashScreenAnimationDuration
动画持续时间，最长1s
### windowSplashScreenIconBackgroundColor
中间图标背景颜色
