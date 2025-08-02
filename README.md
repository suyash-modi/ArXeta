# AR Placement App for Android

## 🎯 Overview

Build a minimal AR app that lets users:
1. Select a drill from a dropdown list.
2. Tap on a detected horizontal plane in AR to place a 3D drill marker (a simple colored cube).

## Features

- **Drill Selection UI:**  
  - Dropdown with 3 drills: Drill 1, Drill 2, Drill 3  
  - Drill detail page shows dummy data: title, description, usage tips  
  - Button to start the AR experience for the selected drill

- **AR Interaction:**  
  - Uses **ARCore** and **Sceneform** SDK to detect horizontal planes  
  - On tap, places a blue cube (representing the drill) at the tap location  
  - Restricts to placing only one drill marker per session  
  - Shows instructions to guide user (e.g., *“Tap on ground to place drill marker”*)

## Setup & Requirements

- **Minimum Android SDK:** 24 (Android 7.0)  
- **ARCore Dependency:** `com.google.ar:core:1.41.0` (or newer)  
- **Sceneform Dependency:** `com.gorisse.thomas.sceneform:sceneform:1.23.0`  
- **Device:** Must support ARCore with up-to-date Google Play Services for AR installed  
- **Permissions:** Camera permission declared in AndroidManifest  
- **Meta-data:** ARCore requirement declared in AndroidManifest

## How to Run

1. Clone or download the project source code.
2. Open in Android Studio and sync Gradle.
3. Connect a compatible ARCore-supported Android device.
4. Build and install the app on the device.
5. Launch the app, select a drill from the dropdown list.
6. Tap **Start AR Drill** to enter AR mode.
7. Point the camera at a flat surface and tap to place the drill marker.

## Project Structure

- `MainActivity`: Drill selection UI with dropdown and navigation  
- `DrillDetailActivity`: Displays drill info and launches ARActivity  
- `ARActivity`: Hosts AR fragment and handles placing a blue cube on tap  
- Layout files with ViewBinding for safe UI references  
- Gradle files properly configured with compatible ARCore & Sceneform versions  

## Troubleshooting

- Ensure your device has the latest **Google Play Services for AR** from Play Store.
- If the app crashes with method not found errors (`acquireEnvironmentalHdrCubeMap`), verify ARCore and Sceneform versions are compatible, and fully uninstall/reinstall the app.
- The AR view requires camera permission and supported hardware.
- Emulators rarely support ARCore fully — use a real ARCore-certified device.

## Notes

- The 3D drill marker is a simple programmatically generated colored cube (no complex 3D model required).
- Only one drill marker can be placed at a time for simplicity.
- UI and AR interactions are minimal but demonstrate the core concept.

Thank you for exploring this AR Placement App! Feel free to customize and extend it further.
