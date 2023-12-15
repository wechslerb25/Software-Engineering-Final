[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-24ddc0f5d75046c5622901739e7c5dd533143b0c8e959d652212380cedb1ea36.svg)](https://classroom.github.com/a/1EiKHzOV)
###### Ben Wechsler, Reese Nelson, Janeet Bajracharya, Tyler Halliday, A.J Thomas

## Extensions

#### Assignments Side Bar - Ben
For this extension, I thought that it would be interesting to add a Matlab style assignments tab to the GUI. Utilizing JFrame and JTable, I created an extension of the GUI to the right side of the display window that consists of a table of assigned values.

#### Random Expression Generator - Tyler
For this extension, it allows the user to click a button in the GUI named random and it will generate a random expression with either a unary function like sin or cos, a binary operator like + or -, or a leaf node like x, y, a constant, or a color. 
<br>Note: If the Animation Player is on when the button is clicked, the expression will automatically evaluate.

#### Conditionals - Reese
Allows for conditional evaluation of pixels. Comes with comparison operators (<, >, <=, >=, ==, !=) and boolean logic (&, |). TRUE values are represented as an RGBColor [1,1,1] (white). FALSE values are represented as an RGBColor [-1,-1,-1] (black). If (typed if() in expression input) is a ternary function that takes a condition, expression to run if TRUE, and expression to run if FALSE. One application of this is to evaluate different expressions on different intervals of pixels coordinates.

#### Animation Loop - Reese
Adds a "Play/Pause" toggle button to the menu. The text input is repeatedly evaluated at a rate of about 20 fps (unless the expression is too complex). The extension automatically updates time-based variables "r" and "b" every frame.
<br>r: repeated loop from -1 --> 1
<br>b: boomerage from -1 --> 1 --> -1 (sinusoidal wave behavior)
<br>These variables are in the form of grayscale RGBColors (i.e. [1,1,1]). The variables are best used (in my opinion) within the condition parameter of if statements.

#### Game Of Life - Janeet
This extension is a collection of a bunch of other smaller extensions such as the avg function that takes the average of the Von Neuuman Neighborhood of the pixels during the last generation, also implements the pixel token that when evaluated, returns the pixel value of the current positon during (t-1) where the pixmap of the previous generation is stored in a singleton cache. It also comes with a rand(lower_bound,upper_bound) function that populates the image with random values in that range. Composing these with the standard rule set : First: rand(0,1) and Second: if((pixel):[1,1,1],if((avg)<0.25,[0,0,0],if((avg) >0.75, [0,0,0],[1,1,1])),if((avg)>0.5,[1,1,1],[0,0,0])) we have the game of life.


# Picasso

An application that allows the user to create expressions that
evaluate to colors and then eventually to images.

The given code base is a good start, but it is sparsely documented
(document each method/part after you understand what it's doing) and,
as your application grows, you may need to refactor.

See the specification for Picasso on the course web site.

## Running Picasso

To run Picasso, run `picasso.Main`

## Project Organization

`src` - the source code for the project

`conf` - the configuration files for the project

The `images` directory contains some sample images generated from Picasso.  Some of the expressions for these images can be found in the `expressions` directory.

## Code Base History

This code base originated as a project in a course at Duke University.  The professors realized that the code could be designed better and refactored.  This code base has some code leftover from the original version.