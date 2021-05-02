# Makefile
install: # выполняем:  ./gradlew clean install
		gradle wrapper
		./gradlew clean install
run-dist: #
		./build/install/app/bin/app
check-updates: #
		./gradlew dependencyUpdates
run: #
		./gradlew run
lint: #
		./gradlew checkstyleMain