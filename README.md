An implementation of [Conway's Game of Life](https://en.wikipedia.org/wiki/Conway's_Game_of_Life) in Java.

To set the size of the grid, go to the config.properties file and change the width and height there.

The program will then randomly initiate live cells and start the game, which will run for 10 seconds and update the grid every 500 ms.

Please note that if you are looking for a beautiful rendering of the game you will be greatly underwhelmed:
the program outputs updates to the grid universe as arrays of boolean values to the console 
where true indicates a live cell and false indicates a dead cell.

