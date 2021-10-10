An implementation of [Conway's Game of Life](https://en.wikipedia.org/wiki/Conway's_Game_of_Life) in Java.

To set the max size of the grid, go to config.properties under src/main/resources and change the width and height there.
The actual grid size will be set randomly.

The program will
1. randomly initiate grid size, using your settings as an upper limit; 
2. initiate live cells,
3. start the game;
4. print boolean cell values to the console, every 500 ms; and 
5. run for 10 seconds.

Please note that if you are looking for a beautiful rendering of the game you will be greatly underwhelmed:
the boolean outputs represent cells on the grid, where true indicates a live cell and false indicates a dead cell.

