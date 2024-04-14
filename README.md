# Kotlin Multiplatform Todo List

This is a Kotlin Multiplatform project targeting Web.
The project is a simple Todo List application where you can add, remove, and view tasks.

## Project Structure

- `/composeApp` is for code that will be shared across your Compose Multiplatform applications. It contains several subfolders:
  - `commonMain` is for code that’s common for all targets.
  - Other folders are for Kotlin code that will be compiled for only the platform indicated in the folder name.
  - `wasmJsBrowserMain` is for code that will be compiled to WebAssembly and JavaScript for the browser.

## Features

- Add tasks to the todo list.
- Remove tasks from the todo list.
- View the number of unfinished tasks.
- Hide or show completed tasks.

## Running the Project

You can open the web application by running the `:composeApp:wasmJsBrowserDevelopmentRun` Gradle task.

## Technologies Used

- Kotlin
- Compose Multiplatform
- Gradle
