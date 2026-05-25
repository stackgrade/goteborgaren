# Default ProGuard rules
-keepattributes Signature
-keepattributes *Annotation*

# Gson
-keepattributes Signature
-keep class com.goteborgaren.app.data.model.** { *; }

# Hilt
-dontwarn dagger.hilt.**
-keep class dagger.hilt.** { *; }

# Retrofit
-dontwarn retrofit2.**
-keep class retrofit2.** { *; }
