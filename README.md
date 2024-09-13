# Word Learning App

## Project Description

The **Multilingual Word Learning App** allows users to explore and learn words in multiple languages. It provides an interactive and user-friendly interface for displaying words, showing their meanings, and playing their English pronunciations. The app also features a functionality for marking words as "learned," storing them in shared preferences, and allowing users to review their learned words. Furthermore, a quiz functionality is integrated, enabling users to test their knowledge using the words they have learned.

---

## Main Features

- **Word List Display**: Displays at least 50 words with their translations in different languages. Randomly ordered word list using `RecyclerView` or `ViewPager`. Flexible and creative UI design ensures a smooth learning experience.
  
- **BottomNavigationView with Two Tabs**:
  - **Tab 1**: Displays the randomly ordered list of words.
  - **Tab 2**: Displays the list of "Learned" words, saved using `SharedPreferences`.

- **Word Details**: Tapping on a word opens a **Detail Page** (or Popup), showing more information about the word. The detail view includes a "Learned" button to mark the word as learned, or "Unlearned" to remove it from the learned list.

- **Swipe to Refresh**: The first tab allows users to refresh the word list via swipe-to-refresh, randomizing the word order again.

- **Pronunciation Support**: Each word is accompanied by an English pronunciation, which is played when the sound icon is clicked using `MediaPlayer`.

- **Quiz Feature**: A quiz is dynamically generated from the "Learned" words. Users are presented with a word, and they must select the correct meaning or image from a list of options.

---

## Technology Stack

- **Kotlin**: The primary programming language used to build the app.
- **Android Jetpack Components**:
  - `RecyclerView`: For displaying the word list.
  - `ViewPager`: For managing multiple word views.
  - `BottomNavigationView`: For navigation between tabs.
  - `ViewBinding` or `DataBinding`: For seamless UI updates and data handling.
  - `SharedPreferences`: For storing and retrieving the learned words.
- **MediaPlayer**: Used to play the English pronunciations of each word.
- **Jetpack Navigation**: For handling fragment transitions and managing navigation between screens.
- **SwipeRefreshLayout**: For enabling swipe-to-refresh functionality.

---
