# Adventure Hunt

Adventure Hunt is a 2D platformer game developed entirely in Java. This game provides an engaging experience focused on adventure and exploration within a richly designed virtual world. Players embark on a quest to find keys and unlock caskets hidden throughout the game, all while facing various attackers and receiving assistance from a knowledgeable guide character.

## Table of Contents

- [Features](#features)
- [System Specifications](#system-specifications)
  - [Hardware Requirements](#hardware-requirements)
  - [Software Requirements](#software-requirements)
- [Installation](#installation)
- [Usage](#usage)
- [Project Structure](#project-structure)
- [System Architecture](#system-architecture)

- [Future Enhancements](#future-enhancements)


## Features

- Engaging gameplay centered around adventure and exploration.
- A variety of maps with unique challenges.
- High score tracking for competitive play.
- Interactive characters, including a guide for assistance.

## System Specifications

### Hardware Requirements

**Minimum Requirements:**
- Processor: Dual-core CPU, 2.0 GHz
- RAM: 4 GB
- Graphics: Integrated graphics with OpenGL support
- Storage: 500 MB of available disk space
- Operating System: Windows 7/8/10, macOS 10.10 or later, Linux

**Recommended Requirements:**
- Processor: Quad-core CPU, 3.0 GHz
- RAM: 8 GB
- Graphics: Dedicated GPU with 1 GB VRAM, OpenGL 3.0 support
- Storage: 1 GB of available disk space
- Operating System: Windows 10, macOS 11, Linux (latest distribution)

### Software Requirements

**Development Environment:**
- IDE: IntelliJ IDEA, Eclipse, or NetBeans
- Programming Language: Java SE 8 or higher
- Build Tools: Apache Maven or Gradle
- Version Control: Git

**Runtime Environment:**
- Java Runtime Environment (JRE) 8 or higher

**Graphics and Sound Libraries:**
- Java 2D API (for rendering graphics)
- Java Sound API (for sound effects and background music)

## Installation

1. Clone the repository using the following command:
   ```bash
   git clone https://github.com/Uditnarayanakb/2dgame.git

## Usage

Open your IDE and run the main program of the Java application.

## Project Structure

- **src**: Handles the running of the game.
- **res**: Contains the elements (images, audio) used in the game.

## System Architecture

- **Game Window**: Created using `JFrame`, this serves as the main display area for the game, containing all graphical elements and user interface components.
- **Game Panel**: Built with `JPanel`, this panel handles the game loop, rendering, and core game logic, such as updating the game state and managing graphical output.
- **Map Integration System**: External text files are used to define the layouts of maps, specifying tile types and object positions, making it simple to customize and expand game environments.
- **Graphics Rendering**: Utilizes the `Graphics2D` API to draw characters, items, and backgrounds, ensuring smooth and appealing visual output.
- **User Input Handling**: Captures keyboard inputs for controlling character movements and actions, ensuring interactive and responsive gameplay.
- **Game Logic**: Manages character movement, collision detection, item collection, and level progression. This logic is designed in a modular way to allow easy updates.
- **UI Components**: Uses `JPanel` to display game-related information such as scores and key counts, updating them in real-time during gameplay.
- **Sound Integration**: Java's Sound API is used to incorporate background music and sound effects, enhancing the overall immersive experience.

## Future Enhancements

While the project has successfully met its initial goals, several areas offer opportunities for future enhancements:

- **Advanced Map Features**: Future versions could include more complex map elements, such as moving platforms, destructible environments, and interactive puzzles, to enhance gameplay depth.
- **Player Health and Status Indicators**: Implementing a comprehensive health bar and status indicators will add another layer of challenge and strategy to the game.
- **Expanded Combat System**: Developing a full-fledged combat system with various weapons, shields, and attack strategies will significantly enhance gameplay.
- **Trading and Economy System**: Introducing a trade system where players can exchange items or resources with in-game characters would add an interesting economic layer, increasing replayability.

## Code Overview

**Dependencies:**
```java
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import java.awt.Graphics2D;