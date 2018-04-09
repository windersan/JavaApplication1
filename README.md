# Build jar
javac JavaApp.java  
jar cfe JavaApp.jar JavaApp JavaApp.class  
*Requires JDK (http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)*


# Build image
docker build -t javaapp:1 -f Dockerfile.txt .

# Run image
docker run --dns=8.8.8.8 -i javaapp:1
