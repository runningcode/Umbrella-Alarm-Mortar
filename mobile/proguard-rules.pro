# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in /Applications/Android Studio.app/sdk/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

-keepattributes SourceFile, LineNumberTable
-keepattributes Signature
-renamesourcefileattribute SourceFile

#butterknife rules
-dontwarn butterknife.internal.**
-keep class **$$ViewInjector { *; }
-keepnames class * { @butterknife.InjectView *;}

# dagger rules
-dontwarn dagger.internal.**
-keepattributes *Annotation*

-keepclassmembers,allowobfuscation class * {
    @javax.inject.* *;
    @dagger.* *;
    <init>();
}

-keep class javax.inject.** { *; }
-keep class **$$ModuleAdapter
-keep class **$$InjectAdapter
-keep class **$$StaticInjection
-keep class dagger.** { *; }

-keepnames !abstract class coffee.*

-keepnames class dagger.Lazy

# okhttp rules
-dontwarn okio.**
-dontwarn com.squareup.okhttp.internal.**

# retrofit rules
-dontwarn retrofit.appengine.**
-keep class retrofit.http.* { *; }
-keep class com.osacky.umbrella.data.api.model.** { *; }
-keep class com.osacky.umbrella.data.api.WeatherService { *; }

# joda time rules
-dontwarn org.joda.time.**

# rxJava rules
-dontwarn rx.android.operators.**
-dontwarn rx.internal.util.**

# Screen Rules
-keep public class * extends android.view.View {
    public <init>(android.content.Context);
    public <init>(android.content.Context, android.util.AttributeSet);
    public <init>(android.content.Context, android.util.AttributeSet, int);
    public void set*(...);
}




