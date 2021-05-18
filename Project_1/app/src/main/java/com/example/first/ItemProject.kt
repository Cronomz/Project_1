package com.example.first

data class ItemProject(
    val name: String,
    val tasks: MutableList<ItemTask>,
    val isDone: Boolean
)
