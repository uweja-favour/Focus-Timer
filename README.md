# Timer Application

A simple, user-friendly timer application built using **Jetpack Compose**. This app features an intuitive user interface that displays a timer with start, stop, and reset functionalities. The app is designed with Material Design principles to provide a clean and seamless experience.

## Features

- **Start/Stop Timer**: Users can easily start or stop the timer with a single click.
- **Reset Timer**: A reset button appears once the timer starts, allowing users to reset the timer back to zero.
- **Responsive UI**: Built with Jetpack Compose, the app adapts well to different screen sizes and orientations.
- **Material Design**: Rounded surfaces and subtle shadows for a modern, polished look.
- **Animated Visibility**: Buttons such as "Reset" appear with a smooth animation when relevant.

## Technologies Used

- **Kotlin**: All functionalities are implemented in Kotlin, utilizing its powerful syntax and features.
- **Jetpack Compose**: The UI is fully built with Jetpack Compose, providing a declarative and modern UI framework.
- **ViewModel**: The business logic is separated from the UI using Android's `ViewModel`, ensuring a clean architecture.
- **State Management**: Proper state handling is done using Jetpack's state management features to maintain UI consistency during configuration changes.

## Screenshots

_(Screenshots or gifs here to showcase the UI and functionality.)_
##

<img src="https://github.com/uweja-favour/Focus-Timer/blob/main/FocusTimer.png" alt="Home Screen" width="300"/> <img src="https://github.com/uweja-favour/Focus-Timer/blob/main/FocusTimer.png" alt="Home Screen" width="300"/>



## Code Structure

### Main Components

- **Timer Functionality**:  
  The timer format is controlled by the `convertDigitToTimerFormat` function, which converts seconds into the `HH:MM:SS` format. Here's an example:

```
fun convertDigitToTimerFormat(digit: Int): String {
    val hours = digit / 3600
    val minutes = (digit % 3600) / 60
    val seconds = digit % 60
    return String.format("%02d:%02d:%02d", hours, minutes, seconds)
}
```

- **Surface Design**:
The app's timer is displayed inside a Surface composable with rounded corners and subtle shadow effects to create a clean UI:

```
Surface(
    modifier = Modifier
        .padding(bottom = 10.dp)
        .size(150.dp),
    shape = RoundedCornerShape(50.dp),
    color = MaterialTheme.colorScheme.onPrimary,
    shadowElevation = 4.dp
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = convertDigitToTimerFormat(timerCount))
    }
}
```

- **Button Controls**:
The Start/Stop and Reset buttons are arranged in a Row, with visibility animations for the reset button:

```
Row(
    modifier = Modifier.fillMaxWidth(),
    horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterHorizontally)
) {
    Button(onClick = { homeViewModel.toggleTimerToStartOrStop(!startTimer) }) {
        Text(text = if (startTimer) "Stop" else "Start")
    }

   AnimatedVisibility(visible = startTimer) {
        Button(onClick = { homeViewModel.resetTimer() }) {
            Text(text = "Reset")
        }
    }
}
```


## How to Run the Project
### Prerequisites

1. Android Studio Flamingo (or higher)
2. Kotlin 1.9.0+
3. Gradle 8.0+
4. Minimum SDK version: 21
5. Compile SDK version: 33

   
## Installation
Clone the Repository:


git clone https://github.com/uweja-favour/timer-app.git
cd timer-app

### Open the Project: Open the project in Android Studio.

### Build and Run:
Connect an Android device or start an emulator.
Press Run (or Shift + F10) to build and run the app.


## Contributing
#### Contributions are welcome! Feel free to submit issues or pull requests for new features, bug fixes, or improvements.

### Steps to Contribute:

1. Fork the repository.
2. Create a new branch for your feature or bug fix:
git checkout -b feature-name
3. Commit your changes and push your branch:
git commit -m "Add new feature"
git push origin feature-name
4. Open a pull request, and describe the changes you’ve made.
   
### License
This project is licensed under the MIT License. See the LICENSE file for more details.

