An implementation of [Conway's Game of Life](https://en.wikipedia.org/wiki/Conway's_Game_of_Life) in Java.

To set the max size of the grid, go to config.properties under src/main/resources and change the width and height there.
The actual grid size will be set randomly.

The program will
1. randomly initiate grid size, using your settings as an upper limit; 
2. initiate live cells and start the game;
3. run for 10 seconds;
4. update the grid every 500 ms; and 
5. print lists of boolean values to the console.

Please note that if you are looking for a beautiful rendering of the game you will be greatly underwhelmed:
the boolean outputs represent cells on the grid, where true indicates a live cell and false indicates a dead cell.

