# MP3_Player
Final Project for Java

For my final project, I have created a media player that plays audio files. It currently only can play mp3 files, but I plan on supporting other audio file formats in the future. The audio player that I am using is from a third party API called BasicPlayer, which I downloaded from JavaZoom's website here:
    http://www.javazoom.net/jlgui/api.html
    
I also used an API from Apache to parse metadata in an MP3 file which can be found here:
    https://tika.apache.org/download.html

For the program to run correctly, you need to add all of the jar files that they contain to your Project Structure's classpath.
  Project Structure > Platform Settings > SDKs > then add each one to the classpath
    
My audio player uses a custom file object, named audio file, which contains song information and a filepath to where the file is located on your computer. It then stores this information in a database table to "save" it so that it can be retrieved when the program is terminated and restarted. When a file is added to the "library" (or table that displays all of the songs that have been added), a new audio file is created. Then a method is called to add it to the database, which stores the song's title, artist, and album information, as well as the file path where it's located on your computer. This method also adds it to an arraylist which is used to create a new row to add to the "library." When the row is double clicked in the table, the song will play.

I did not include a MySQL dump file because my code automatically creates the database and table if they don't already exist.
Also, because a file's ability to play is dependant on where it is located in a computer's file system, test data will not work, so you just need to add some mp3 files to use it.

KNOWN BUGS:
-When a file is playing, if you double click a different row it doesn't stop playing and start playing that song, it just pauses. If you double click it resumes.
-If you change the path on your computer of where the audio file is located, it will throw an exception and not play.
-I didn't finish validation on the login screen so if you enter the wrong MySQL username and password, the database will not load. It will load after restarting the program and entering the correct credentials.

COOL FEATURES:
-It uses a customized JFileChooser to add or open files. 
    If the open option is selected, the dialog boxes title and button text changes to reflect opening a file. After a file has been opened, it will play if you press the play button. 
    If the add option is selected, the title and button changes for that and the file is added after you click import.
-The columns will autosort alphabetically if they are selected
-It implements a customed JMenuBar

