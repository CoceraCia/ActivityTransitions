# Transitions – Screens and Navigation App ⏱️📱

## Project Description

This project is an Android application developed in **Android Studio** that simulates the basic flow of a video game using **three main screens** and **custom transitions** between them.

Instead of a traditional game, the application is implemented as a **timer (chronometer)**, focusing on screen navigation, activity lifecycle management, and animated transitions.

---

## Activity Objective

The goal of this project is to practice:

- Activity navigation in Android
- Intent-based screen transitions
- Custom transition animations
- Basic UI structure using multiple screens

---

## Application Screens

### 1️⃣ Main Menu Screen

- Displays the name of the application.
- Contains buttons to:
  - Start the game (timer)
  - Access help (optional or placeholder)
  - Exit the application

### 2️⃣ Game Screen (Timer)

- Simulates gameplay using a **chronometer**.
- The timer runs while the game screen is active.
- Represents the main gameplay logic of the app.

### 3️⃣ Result Screen

- Displays the final result after the game ends.
- Shows a message (e.g., completion or result status).
- Allows the user to return to the main menu.

---

## Transitions and Animations

- Custom animations are applied when navigating between screens.
- XML animation resources are used to create smooth transitions.
- Transitions improve the user experience and simulate a real game flow.

---

## Project Structure

```
app/
├── manifests/
│ └── AndroidManifest.xml
├── kotlin+java/
│ ├── com.cocercacia.transitions.view
│ │ ├── GameActivity.kt
│ │ ├── MenuActivity.kt
│ │ └── ResultActivity.kt
├── res/
│ ├── drawable/
│ │ ├── ic_launcher_background.xml
│ │ ├── ic_launcher_foreground.xml
│ │ ├── slide_in_right.xml
│ │ └── slide_out_left.xml
│ ├── layout/
│ │ ├── activity_game.xml
│ │ ├── activity_menu.xml
│ │ └── activity_result.xml
│ ├── mipmap/
│ ├── values/
│ └── xml/
└── Gradle Scripts
```

---

## Main Activities

- **MenuActivity**  
  Handles the main menu interface and navigation to the game screen.

- **GameActivity**  
  Contains the chronometer logic and simulates the gameplay.

- **ResultActivity**  
  Displays the result screen and provides navigation back to the menu.

---

## Technologies Used

- **Language:** Kotlin  
- **IDE:** Android Studio  
- **Platform:** Android  
- **UI:** XML Layouts  
- **Animations:** XML-based transitions

---

## 📽️ Video Demo
[![Demo Short](https://img.youtube.com/vi/6koti_EHpXg/maxresdefault.jpg)](https://youtube.com/shorts/6koti_EHpXg?si=kBWzt2sbOxtvPAH_)

---

## Author

- **Cocera Cia**
- Academic project developed for Android navigation and transitions practice 🎓
