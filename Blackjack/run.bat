@echo on
javac -source 1.8 -target 1.8 src/*.java -d build
cd build
java Main
pause