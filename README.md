AR Placement App for Android

🎯 Overview:
Build a minimal AR app that lets users:

Select a drill from a dropdown list.

Tap on a detected horizontal plane in AR to place a 3D drill marker (a simple colored cube).

Features:
Drill Selection UI:

Dropdown with 3 drills: Drill 1, Drill 2, Drill 3

Drill detail page shows dummy data: title, description, usage tips

Button to start the AR experience for the selected drill

AR Interaction:

Uses ARCore and Sceneform SDK to detect horizontal planes

On tap, places a blue cube (representing the drill) at the tap location

Restricts to placing only one drill marker per session

Shows instructions to guide user (e.g., “Tap on ground to place drill marker”)

Setup & Requirements:
Minimum Android SDK: 24 (Android 7.0)

ARCore Dependency: com.google.ar:core:1.41.0 (or newer)

Sceneform Dependency: com.gorisse.thomas.sceneform:sceneform:1.23.0

Device: Must support ARCore with up-to-date Google Play Services for AR installed

Permissions: Camera permission declared in AndroidManifest

Meta-data: ARCore requirement declared in AndroidManifest

How to Run:
Clone or download the project source code.

Open in Android Studio and sync Gradle.

Connect a compatible ARCore-supported Android device.

Build and install the app on the device.

Launch the app, select a drill from the dropdown list.

Tap Start AR Drill to enter AR mode.

Point the camera at a flat surface and tap to place the drill marker.
