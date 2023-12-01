# Project Name

OpinionThread

## Description

This project is a Simple CRUD App with Upvote and Downvote features. It allows users to create, view, edit, and delete posts, with upvote and downvote functionality. The application uses Room Library for local database management and follows the MVVM pattern.

## Features

1. **All Posts Screen:**
   - Displays all created posts.
   - Allows users to upvote or downvote posts, updating the counter.

2. **View Post:**
   - Shows post details.
   - Provides options to edit and delete the post.

3. **Edit Page:**
   - Redirects to a form with prefilled post details.
   - Saves changes to Room Database on success.
   - Redirects to the All Posts page.

4. **Create Post:**
   - Form with proper validation.
   - Saves the post in Room Database on submit.
   - Shows error and success messages accordingly.
   - Redirects to the All Posts page on success.

5. **Delete Confirmation:**
   - Confirmation popup before deleting a post.
   - On confirmation, deletes the post from Room Database.
   - Redirects to the All Posts page on success.

6. **Upvote/Downvote:**
   - Increases post like or dislike count on click.

## Technologies Used

- Language: Java
- Local Database: Room Library
- Pattern: MVVM

## How to Run

1. Clone the repository.
2. Open the project in Android Studio.
3. Build and run the application on an emulator or physical device.

## Contributors

- Mohamad Vahid Soudagar

## License

This project is licensed under the [MIT License](LICENSE).
