# Arkanoid Game

## Overview

This project is a modern implementation of the classic Arkanoid game, developed in Java as part of an Object-Oriented Programming course at Bar-Ilan University. The game offers an engaging gameplay experience where players control a paddle to prevent a ball from falling while attempting to break all the bricks on the screen.

## Features

### Core Gameplay Mechanics

- **Paddle Control:** Players can maneuver the paddle using the keyboard's left and right arrow keys to deflect the ball.

- **Ball Dynamics:** The ball features realistic physics, bouncing off bricks, walls, and the paddle at angles that depend on the point of impact.

- **Brick Interaction:** Bricks shatter upon impact.

### Game Levels

- **Direct Hit:** A simple level with a single target brick.

- **Wide Easy:** Features a wide paddle and a decorative sun-themed background.

- **The Boss Level:** A dramatic and visually rich level with building-like decorations and multiple obstacles.

### Visual and Functional Enhancements

- **Score Tracking:** The game dynamically updates the player’s score after each brick hit and level completion.

- **Game States:**

    - **Pause Screen:** Players can pause the game at any time by pressing the "P" key, with a clear message displayed.

    - **Win Screen:** A celebratory screen displays the player’s score upon successfully completing all levels.

    - **Game Over Screen:** Displays the final score when the ball touches the ground, and the game ends.

- **Custom Decorations:**

    - Each level incorporates thematic decorations, such as sun rays in Wide Easy or intricate building designs in The Boss Level, enhancing the visual appeal of the game.

## Compilation and Execution

### Prerequisites

### Apache Ant: The project uses Apache Ant for building and running the game.

Installing Apache Ant

1. Download Apache Ant from the [official website](https://ant.apache.org/bindownload.cgi).

     * Extract the downloaded archive to a directory (e.g., `C:\apache-ant-1.10.13`).

2. Configure environment variables:

    * Set `ANT_HOME` to the Ant directory (e.g., `C:\apache-ant-1.10.13`).

    * Add `%ANT_HOME%\bin` to your system `PATH` variable.

3. Verify the installation by running `ant -version` in the Command Prompt.

### Build and Run the Game

The project includes a `build.xml` file to simplify compilation and execution.

### Compile the Project:
```bash
ant compile
```
Run the Game by deafult levels order:
```bash
ant run
```
Specify Levels:
To play specific levels in a chosen order, pass level numbers as arguments:
```bash
ant -Dargs="1 2 3" run
```
The numbers correspond to levels: 1 (Direct Hit), 2 (Wide Easy), and 3 (The Boss Level).

## Controls

Left Arrow (<-): Move the paddle to the left.

Right Arrow (->): Move the paddle to the right.

P: Pause the game.

Space: Exit the game after a win or loss.

### Photos :
![1](https://github.com/user-attachments/assets/c1895001-af0b-4b08-ae85-3a79b2bfc10e)
![2](https://github.com/user-attachments/assets/f4d86bb0-a63c-4849-80c2-0ae0624ee13f)
![3](https://github.com/user-attachments/assets/9ae2398e-665b-41f3-9e39-2ca1afe079b5)
