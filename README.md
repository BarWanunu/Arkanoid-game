Arkanoid Game

Overview

This project is a modern implementation of the classic Arkanoid game, developed in Java as part of an Object-Oriented Programming course at Bar Ilan University. The game offers an engaging gameplay experience where players control a paddle to prevent a ball from falling while attempting to break all the bricks on the screen. With several innovative features and polished design, this version of Arkanoid enhances the timeless gaming formula.

Features

Core Gameplay Mechanics

Paddle Control: Players can maneuver the paddle using the keyboard's left and right arrow keys, providing precise control to deflect the ball.

Ball Dynamics: The ball features realistic physics, bouncing off bricks, walls, and the paddle at angles that depend on impact position.

Brick Interaction: Bricks are designed to shatter upon impact, with certain levels featuring bricks that require multiple hits to break.

Game Levels

Diverse Themes: The game includes unique levels such as Direct Hit, Wide Easy, and The Boss Level. Each level has its distinctive design, decorations, and challenges.

Direct Hit: A simple yet challenging level with a single target surrounded by concentric decorations.

Wide Easy: Features a wide paddle and a decorative sun-themed background.

The Boss Level: A dramatic and visually rich level with building-like decorations and multiple obstacles.

Dynamic Progression: Levels can be played in a specified sequence or in the default order if no preferences are provided.

Visual and Functional Enhancements

Score Tracking: A scoring system keeps players motivated, displaying the current score on the game screens.

Game States:

Pause Screen: Players can pause the game at any time by pressing the "P" key, with a clear message displayed.

Win Screen: A celebratory screen showcases the player’s score upon successfully completing all levels.

Game Over Screen: Displays the final score when the ball touches the ground and the game ends.

Custom Decorations

Each level incorporates thematic decorations, such as sun rays in Wide Easy or intricate building designs in The Boss Level, enhancing the visual appeal of the game.

Compilation and Execution

Prerequisites

Apache Ant: The project uses Apache Ant for building and running the game.

Installing Apache Ant

Download Apache Ant from the official website.

Extract the downloaded archive to a directory (e.g., C:\apache-ant-1.10.13).

Configure environment variables:

Set ANT_HOME to the Ant directory (e.g., C:\apache-ant-1.10.13).

Add %ANT_HOME%\bin to your system PATH variable.

Verify the installation by running ant -version in the Command Prompt.

Build and Run the Game

The project includes a build.xml file to simplify compilation and execution.

Compile the Project:

ant compile

Run the Game:

ant run

Specify Levels:
To play specific levels in a chosen order, pass level numbers as arguments:

ant -Dargs="1 2 3" run

The numbers correspond to levels: 1 (Direct Hit), 2 (Wide Easy), and 3 (The Boss Level).

Controls

Left Arrow: Move the paddle to the left.

Right Arrow: Move the paddle to the right.

P: Pause the game.

Space: Exit the game after a win or loss.

Screenshots

The game includes visually appealing screens, such as the "You Win" and "Game Over" screens, which reinforce the immersive experience.

Summary

The Arkanoid game leverages object-oriented principles to deliver a refined version of the classic. With realistic ball physics, creative level designs, and intuitive controls, this project stands as a testament to thoughtful game development. Whether you’re nostalgic for retro games or discovering Arkanoid for the first time, this game offers something for everyone.
