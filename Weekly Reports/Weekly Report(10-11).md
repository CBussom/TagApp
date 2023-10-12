# Weekly Status Reports - October 11, 2023

# *Team Report*

## Last Week's Goals:
1. Continue working on SQLite database - Greg Salisbury
2. Create columns for players - Cameron Bussom
3. Continue working on finding other devices using bluetooth - Love-Divine Onwulata and Cameron Bussom
4. Figure out how to have the tag button enabled/disabled depending on the player's range - Mahima Abraham
5. Start implementing different settings/features to the app(or test it out on my project) to make it more user friendly and to improve its layout - Mahima Abraham

## Progress and Issues:
+ Have a basic phone app set up in Adroid Studio for Teletag
+ We have added a history tab
+ We have added a game tab
+ Progressed through Connecting to Bluetooth Tutorial
+ Started integration with SQLite database
+ Bluetooth is up and running and does not crash anymore
+ Bluetooth permissions have been handled
+ The BluetoothAdapter.startDiscovery() is not currently working which is the function needed for finding other devices. 
  

## This Week's Goals
1. Continue working on SQLite database - Greg Salisbury
2. Create columns for players - Cameron Bussom
3. Get the BluetoothAdapter.startDiscovery() working so it can be used to scan for other devices  - Love-Divine Onwulata and Cameron Bussom
5. Continue implementing different settings/features to the app(or test it out on my project) to make it more user friendly and to improve its layout - Mahima Abraham

# *Individual Team Contributions*

+ ## Cameron Bussom
    + **Goals of last week:**
      + Create a simple interface to allow user to connect via bluetooth
    + **Progress and Issues:**
      + Have a working bluetooth version from a found project
      + GUI is sloppy could use some updating
    + **Next Week's Goals:**
      + Add a Lobby and list to show bluetooth connections
      + learn more about creating the GUI
      + Possibly modify the GUI on the working bluetooth code we found
      + look into more bluetooth documentation
      + learn more about a possible way to remove players from a game
      + Finish merging bluetooth and found project

+ ## Greg Salisbury 
    + **Goals of last week:**
      + Still need to complete tutorial
      + Once tutorial is completed, will start implementation and table construction
    + **Progress and Issues:**
      + Looked into Bluetooth in an attempt to help Cameron and Love, but stopped when sufficient progress was made on Bluetooth
      + Watched SQlite Kotlin Android Studio tutorial
      + Will attempt writing SQLite code in Android Studio and make a table
    + **Next Week's Goals:**
      + Learn enough about SQLite in Android Studio to write code for SQLite tables
      + Make Teletag Leaderboard table

+ ## Love-Divine Onwulata
    + **Goals of last week:**
      + Scan for Devices
    + **Progress and Issues:**
      + Used Tutorial Repository to Scan for Bluetooth Devices
      + Started implementing Tutorial Repository in project
    + **Next Week's Goals:**
      + Finish implementing Tutorial Repo
      + Start Connecting to Bluetooth Devices in Scanned List
      + Look into if GPS if easier to use?

+ ## Mahima Abraham
    + **Goals of last week:**
       + Connect the history tab to the database once the database is set up. 
      + Finish connecting the tag button to the Bluetooth connection, meaning if the player is in range the button is enabled or else disabled and apply it to the actual app.
      + Find more features to apply to the phone app to make it user friendly. 
    + **Progress and Issues:**
      + Still working on how to get the tag button go hand in hand with the bluetooth connection once the bluetooth is up and running.
      + Have started looking into how to implement to the leaderboard and display the data for the players to use.
      + Currently have no issues.   
    + **Next Week's Goals:**
      + Connect the history tab to the database.
      + Finish connecting the tag button to the Bluetooth connection, meaning if the player is in range the button is enabled or else disabled and apply it to the actual app.
      + Start working on the leaderboard and its layout and the type of data it will display(players' rank, wins, losses, etc.)
      + Continue finding more features to implement like giving players option to share their leaderboard with others, push notifications, etc. 

