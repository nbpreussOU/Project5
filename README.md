
# Project5


Thought process for completing the project:
First, I wanted to array out all the graphics components on a JFrame, to 
make sure that I had the correct output, and so that the GUI looked 
similar to the one in the project discription.  I used way too many 
JPanels for this, in part to get the 5 bonus points for using multiple 
JPanels, but also because I didn't want to use gridbag layout manager, 
and the other layout managers didn't support adding many components.  I 
would have liked to use fewer, but I couldn't get multiple box layouts 
to work on the same side of the window.  I divided the Jframe into a 
right and left JPanel to increase clarity for me for design the UI.

Next, I wrote all the code and methods to read in the file, do the 
statistics, and create the Treeset<String> and Hashmap<Integer, String> 
that were the basis for this project.  What each method can do is listed 
in the javadocs.

Finally, I decided to add in the action listeners to the graphics 
components, and this process took the longest.  I ended up making two or 
three new classes to decrease clutter, and spent a lot of time rewriting 
methods to fix bugs, especially with the JComboBox.  That was one of the 
more difficult methods to write, simply because refreshing it was 
different from how I thought it would be.

Finally, I added everything together, and made sure that the outputs 
were identical to the glimpses seen in the project assignment.

I then generated a UML and javadocs, and they should be uploaded to the 
git, and the UML will be included in here on github.
