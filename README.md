#IS2545 - DELIVERABLE 4: Performance Testing (SlowLifeGUI)

Jinrong Liu   (jil181@pitt.edu)

##Performance Issues
Before profiling the application, I did an exploratory testing. I looked through the codes and found something weird. In Cell.java, the toString() method has an unnecessary loop, and in MainPanel.java, there is an unnecessary loop in runContinuous() method as well. So when profiling the application, I should try to test “Write” function and “Run Continuous” function first.

Steps to determine the methods to refactor:    
－ Run the game by typing “java GameOfLife 15” in terminal to create a 15×15 world.    
－ Create a certain pattern as the initial state of the life iteration.    
