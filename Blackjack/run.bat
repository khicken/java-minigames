javac -source 1.8 -target 1.8 src/*.java -d build
cd build
jar cmf manifest.mf App.jar *.class
java -jar App.jar
pause