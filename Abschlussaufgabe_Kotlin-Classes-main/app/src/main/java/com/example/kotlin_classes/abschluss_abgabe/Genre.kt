package com.example.kotlin_classes.abschluss_abgabe

/**
 * Represents different genres of books, each with a description.
 * @property description A brief description of the genre.
 */
class Genre(val description: String) {
    companion object {
        val FICTION = Genre("Fictional stories and novels")
        val NON_FICTION = Genre("Non-fictional works")
        val SCIENCE = Genre("Scientific literature")
        val HISTORY = Genre("Historical accounts")
        val CHILDREN = Genre("Books for children")
    }

    /**
     * Prints the description of the genre to the console.
     */
    fun printDescription() {
        println(description)
    }
}
