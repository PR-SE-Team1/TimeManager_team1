Timemanager TEAM 1

Info about project structure:
    java: contains the functionality behind the timemanager app and tests
    res: contains icons, layouts, menus, the navigation and values (strings, ids)
    manifests: contains the AndroidManifest.xml 
    Manager.java is used for functionality for Projects, Tasks and Bookings
    MainActivity.java is used to create the navigation bar

Doku (optional):
    -Documentation and examples for Parcelable:
        https://stackoverflow.com/questions/34503724/adding-data-to-a-parcelable-object-passed-to-another-activity
        https://developer.android.com/reference/android/os/Parcelable
        https://www.vogella.com/tutorials/AndroidParcelable/article.html
    
    
Important: 
    -Always add a new activity to AndroidManifest.xml. Otherwise the app will crash.
    -Add new ids or strings to id.xml and strings.xml in the correct structure.
    -Avoid using fragments. 
    -create a new Recycler (including recycler item) when needed.
    
    
Sonar Scanner:
    

Gradle: 
    In this project gradle is used instead of maven.