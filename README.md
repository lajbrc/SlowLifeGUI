#IS2545 - DELIVERABLE 4: Performance Testing (SlowLifeGUI)

Jinrong Liu   (jil181@pitt.edu)

##Performance Issues
Before profiling the application, I did an exploratory testing. I looked through the codes and found something weird. In Cell.java, the toString() method has an unnecessary loop, and in MainPanel.java, there is an unnecessary loop in runContinuous() method as well. So when profiling the application, I should try to test “Write” function and “Run Continuous” function first.

Steps to determine the methods to refactor:    
－ Run the game by typing “java GameOfLife 15” in terminal to create a 15×15 world.    
－ Create a certain pattern as the initial state of the life iteration.   
－ Click on “Wirte” button to see what happens in VisualVM. 
![screenshot1](https://github.com/lajbrc/SlowLifeGUI/blob/master/Screenshots/Before%20Refactor_Write.png?raw=true)

－ Then click on “Run Continuous” button to see what happens in VisualVM.
![screenshot2](https://github.com/lajbrc/SlowLifeGUI/blob/master/Screenshots/Before%20Refactor_Run%20Continuous.png?raw=true)


From the screenshots, another method from MainPanel.java got my attention. The method convertToInt() was very time consuming and should be improved.

Overall, there were three performance issues with this code and the methods I decided to refactor were:    
－ toString() method from Cell.java    
－ convertToInt() method from MainPanel.java    
－ runContinuous() method from MainPanel.java    


##Method Refactor
####Cell.toString()
![screenshot3](https://github.com/lajbrc/SlowLifeGUI/blob/master/Screenshots/toString_Refactor.png?raw=true)
In this method, the for loop is unnecessary, so I deleted that for loop.

####MainPanel.convertToInt()
![screenshot4](https://github.com/lajbrc/SlowLifeGUI/blob/master/Screenshots/convertToInt_Refactor.png?raw=true)    
In this method, integer c is useless and redundant. The last three lines of code simply convert the input integer x to String and then convert it back to integer again, this part of code was meaningless, so the method can be modified to as the picture shows.    
Since method getNumNeighbors() calls the method convertToInt(), when testing, we have to change “return convertToInt(numNeighbors);” to “return convertToIntModified(numNeighbors);” in method getNumNeighbors().

####MainPanel.runContinuous()
![screenshot5](https://github.com/lajbrc/SlowLifeGUI/blob/master/Screenshots/runContinuous_Refactor.png?raw=true)
In this method, the set of calculations of integer _r makes no sense. To make this method more efficient, I deleted all the _r related codes in this method.

##Screenshots of VisualVM
Screenshots before refactor are in the Performance Issues part.

Screenshots after refactor:    
![screenshot6](https://github.com/lajbrc/SlowLifeGUI/blob/master/Screenshots/After%20Refactor_Write.png?raw=true)
![screenshot7](https://github.com/lajbrc/SlowLifeGUI/blob/master/Screenshots/After%20Refactor_Run%20Continuous.png?raw=true)

It is obvious that the total time of the three methods which have been refactored has improved a lot.

##Pinning Tests
####Cell.toString() Test
Please [click here](https://github.com/lajbrc/SlowLifeGUI/blob/master/IS2545_Deliverable4/src/SlowLifeGUITest/toStringTest.java) to see the test for Cell.toString() method.
![screenshot8](https://github.com/lajbrc/SlowLifeGUI/blob/master/Screenshots/toString_TestRun.png?raw=true)

####MainPanel.convertToInt() Test
Please [click here](https://github.com/lajbrc/SlowLifeGUI/blob/master/IS2545_Deliverable4/src/SlowLifeGUITest/convertToIntTest.java) to see the test for MainPanel.convertToInt() method.
![screenshot9](https://github.com/lajbrc/SlowLifeGUI/blob/master/Screenshots/convertToInt_TestRun.png?raw=true)

####MainPanel.runContinuous() Test
Since MainPanel.runContinuous() method does not have a return value, I have to do the manual test for this method.

Please [click here](https://github.com/lajbrc/SlowLifeGUI/blob/master/IS2545_Deliverable4/src/SlowLifeGUITest/runContinuousTest/runContinuousTest) to see the manual test for MainPanel.runContinuous() method and the [screenshots](https://github.com/lajbrc/SlowLifeGUI/tree/master/IS2545_Deliverable4/src/SlowLifeGUITest/runContinuousTest) for this test.
