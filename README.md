# Open Fighting

## Introduction
“Open Fighting” is a simple, pixel art 2D game created using OpenGL’s java wrapper, JOGL. The game is on 2-player mode (to be played using the same keyboard – ‘90s style).  
There are currently 2 players designed for the game, 

| Kree | Bee |
|:---:|:----:|
|![Kree](https://i.imgur.com/ZlhHFvd.png) | ![Bee](https://i.imgur.com/0L5O2hd.png) |

The game will go on until either player gets his health to zero

## Configurations

No additional configurations are needed to be done except for, 
1. Make sure JDK version 1.8 or higher is installed (or download JDK8 from [here](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)) 
2. Make sure Maven is installed (otherwise, download Maven from [here](https://maven.apache.org/download.cgi)) 

### Building from source

Open Fighting is built using Maven framework to automate dependency management. So the steps to building the game from source are as following,  

1. Open a command prompt/terminal
2. Navigate to the “OpenFighting” source directory
3. Run the following commands :
```mvn clean package```
4. Let maven download all the dependencies and create an executable jar file 

### Executing from IDE 

1. Open the source code from your favourite IDE and (after downloading dependencies via Maven) execute the “Main” class 

### Executing jar file

1. Navigate to “target” directory and double click on the “open-fighting-1.0-jar-withdependencies.jar” file to start the game or run the following command to execute the jar file through terminal :  
```java -jar open-fighting-1.0-jar-with-dependencies.jar ```
2. Alternatively, download the executable jar file from [releases](https://github.com/Oshan96/OpenFighting/releases) and execute in the same manner or by just double clicking. 

## How to play

**_Keep shooting at your opponent using your power-up until his health reaches zero! Also, do not forget to dodge the opponent’s shots by moving around!_**

Game can be played using the same keyboard for both players, for the keys have been mapped separately (hard-coded) for the two players. 

The game’s current implementation allows the players to move around the map (upwards, downwards, forwards and backwards) and use their unique power-up. 
 
For the two players, the currently mapped keys are as following : 

| | Kree | Bee | 
|:---|:---:|:---:|
|Move Up | W | Up arrow|
|Move Down | S | Down arrow|
|Move Front | D | Left arrow|
|Move Back | A | Right arrow|
|Special Power | F | Enter |

## Gameplay

Following is a demonstration of a live gameplay of OpenFighting

![gameplay](https://i.imgur.com/d4Xsu8b.gif)

## Credits

### Resources

**All credits go to the original authors of the resource files I have used in creation of OpenFighting, who and which are mentioned below :**

|Resource|Type|Author|License|
|---|---|---|---|
|[Cyberpunk background](https://ansimuz.itch.io/cyberpunk-street-environment) | Texture (background) | [ansimuz](https://ansimuz.itch.io/)| Free|
|[Kree](https://assetbakery.itch.io/2d-fighter-3) |Spritesheet | [Asset Bakery](https://assetbakery.itch.io)| Free |
|[Bee](https://assetbakery.itch.io/2d-fighter-4) | Spritesheet| [Asset Bakery](https://assetbakery.itch.io)| Free |
| [Joystick Font](https://fontmeme.com/fonts/joystix-font/) | Font | [Typodermic Fonts](http://www.typodermicfonts.com/) | Free |





