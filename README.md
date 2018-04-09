# Build jar
javac JavaApp.java
jar cfe JavaApp.jar JavaApp JavaApp.class

# Build image
docker build -t javaapp:1 -f Dockerfile.txt .

# Run image
docker run --dns=8.8.8.8 -i javaapp:1
