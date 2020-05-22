# Snace_Main_project
Project on Java programing Language "Snace" game with modification  the original is -> https://www.youtube.com/watch?v=VnogOoOQZIE
'MainWindow'  window where we create import javax. swing.*; GUI field for the game and all

Next on the GameField window we create all the logic of the game there in General 9 in public classes not counting the main one

1)  For the public GameField () method, we describe the background of the game field and which "snake" buttons will be obeyed

2)  In the public void initGame () method, the initial position of the snake and the subsequent appearance of the drawing on the 
game field are displayed using the Timer library

3)in this public void createApple() method, apples appear in the face of a file using the Random library

4)  In this class public void loadImages() the program accepts external files namely images that replace the traditional snake and 
Apple with . PLOT ->(a samurai who hunts a demon )

5)  In this method, protected void paintComponent(Graphics g), the program draws the technical part itself using super.paintComponent (g); 
we only have one race to draw the snake and the Apple, which we do if in short the movement of the snake
and check whether we are still in the game . Here I wrote try cath for errors

6) In this public void move() method, the movement is based on coordinates and everything

7) In this method, public void checkApple() checks whether the snake has met an Apple

8) In this public void checkCollisions() method, a collision check is performed .I WROTE IT MYSELF . HERE's WHAT I CHANGED 
if there is a collision by itself the restart begins and if the curb then just ends the game. that's the difference

9) In this method public void actionPerformed(ActionEvent e) we check the movement, randomization of apples, and collision 
of trees all of the above did not happen then the image is drawn every 250 milliseconds

10)In this public void keystressed(KeyEvent e) method, we set the direction of the snake using the keyboard and that's it
