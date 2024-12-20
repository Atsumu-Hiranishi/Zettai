package com.example

import com.example.digits
import com.example.lowercase
import com.example.randomString
import kotlin.random.Random.Default.nextInt

fun emptyStore(): ToDoListStore = mutableMapOf()

fun usersGenerator(): Sequence<User> = generateSequence {
    randomUser()
}

fun randomUser() = User.fromTrusted(randomString(lowercase, 3, 6).capitalize())

fun itemsGenerator(): Sequence<ToDoItem> = generateSequence {
    randomItem()
}

fun randomItem() = ToDoItem(randomString(lowercase + digits, 5, 20), null, ToDoStatus.Todo)


fun toDoListsGenerator(): Sequence<ToDoList> = generateSequence {
    randomToDoList()
}

fun randomToDoList(): ToDoList = ToDoList(
    randomListName(),
    itemsGenerator().take(nextInt(5) + 1).toList()
)


fun randomListName(): ListName = ListName.fromTrusted(randomString(lowercase, 3, 6))