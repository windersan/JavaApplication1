# Build jar
javac JavaApp.java  
jar cfe JavaApp.jar JavaApp JavaApp.class  
*Requires JDK (http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)*


# Build image
docker build -t javaapp -f Dockerfile.txt .

# Run image
docker run -i javaapp:latest

# Now the program should be running
Just enter a currency, for example, "bitcoin"

# If you have trouble at any step
Please contact devin.a.salemi@gmail.com
