# SnowX Data Analysis Problem

It's April 1, 2143. Your job is to save the world.
Well, it’s a little world. Specifically, the asteroid X8483 that you and Benedetto Snowy are stuck on. You've been stranded there ever since the evil Rejectos hit your spaceship with a HPtorpedo fired from one of their spaceships. Now you and Bendetto are trying to save your little world from a concerted Rejectos attack. 

The main problem you have is detecting the Rejectos spaceships and HPtorpedos, because they're protected with cloaking devices. Benedetto has invented an imaging anti¬neutrino system (which he has modestly named the “SnowX”) that provides the only information you have about their location, but it's not very good information. First, the SnowX only detects whether there are anti¬neutrinos at any particular point on an image, not what their intensity is. In other words, the data it provides is the equivalent of a black¬ and¬ white image. 

Second, the data is very noisy – even if there are no targets in a particular area, some pixels will be “on”, and if there is a target, some of its pixels will be “off”.

## Getting Started

### Prerequisites

* [Java 1.8](http://www.oracle.com/technetwork/java/javase/downloads/index.html) - Programming language

### Running

Running development environment

```
./mvnw exec:java -Dexec.mainClass="com.servicenow.snowx.SnowXMain" -Dexec.args="-x {RequiredSnowXDataFilePath} -s {OptionalHPShipDataFilePath} -t {OptionalHPTorpedoDataFilePath}"
```

Running prod environment

```
./mvnw package
java -jar ./target/snowx-1.0.0.jar -x {RequiredSnowXDataFilePath} -s {OptionalHPShipDataFilePath} -t {OptionalHPTorpedoDataFilePath}
```

### Running the tests

```
./mvnw test
```

## Built With

* [Maven](https://maven.apache.org) - Dependency management
* [JUnit](https://junit.org) - Test framework

## Author

* [Baris Aydinoglu](https://github.com/barisaydinoglu)

## License

This project is licensed under the MIT License
