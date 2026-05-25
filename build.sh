#!/bin/bash
# Build script för Göteborgaren
# Använd: ./build.sh

export JAVA_HOME=/home/larry/jdk17
export ANDROID_HOME=/home/larry/android-sdk
export PATH=$JAVA_HOME/bin:$ANDROID_HOME/cmdline-tools/latest/bin:$PATH

echo "=== Göteborgaren Build ==="
echo "JDK: $(java -version 2>&1 | head -1)"
echo "SDK: $ANDROID_HOME"
echo ""

cd "$(dirname "$0")"

# Setup local.properties
echo "sdk.dir=$ANDROID_HOME" > local.properties

# Download Gradle if needed
GRADLE_DIR=/tmp/gradle/gradle-8.7
if [ ! -f "$GRADLE_DIR/bin/gradle" ]; then
    echo "Downloading Gradle..."
    wget -q https://services.gradle.org/distributions/gradle-8.7-bin.zip -O /tmp/gradle.zip
    python3 -c "import zipfile; zipfile.ZipFile('/tmp/gradle.zip').extractall('/tmp/gradle')"
fi

echo "=== Building with Gradle ==="
JAVA_HOME=$JAVA_HOME ANDROID_HOME=$ANDROID_HOME $GRADLE_DIR/bin/gradle assembleDebug --no-daemon 2>&1

if [ $? -eq 0 ]; then
    echo ""
    echo "✅ Build successful!"
    ls -la app/build/outputs/apk/debug/app-debug.apk 2>/dev/null
else
    echo ""
    echo "❌ Build failed"
fi
