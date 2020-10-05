build: clean
	./gradlew build
clean:
	./gradlew clean

run-screenshot-test:
	./gradlew verifyDebugAndroidTestScreenshotTest

record-screenshots: clean install-tools-screenshot-test
	./gradlew recordDebugAndroidTestScreenshotTest