package com.example.kotlin_classes.abschluss_abgabe

/**
 * Represents a book with a title, author, genre, and current status.
 * @property title The title of the book.
 * @property author The author of the book.
 * @property genre The genre of the book, represented by [Genre].
 * @property status The current status of the book, represented as a [BookStatus].
 */
data class Book(
    val title: String,
    val author: String,
    val genre: Genre,
    var status: BookStatus
)

/**
 * A sealed class representing the status of a book.
 * Subclasses describe specific statuses such as availability, checkout, or reservation.
 */
sealed class BookStatus {

    /**
     * Represents a book that is currently available.
     */
    object Available : BookStatus() {
        override fun displayStatus() = "The book is available."
    }

    /**
     * Represents a book that has been checked out with a due date.
     * @property dueDate The date by which the book must be returned.
     */
    data class CheckedOut(val dueDate: String) : BookStatus() {
        override fun displayStatus() = "Checked out, due back by $dueDate."
    }

    /**
     * Represents a book that has been reserved by someone.
     * @property reservedBy The name of the person who reserved the book.
     */
    data class Reserved(val reservedBy: String) : BookStatus() {
        override fun displayStatus() = "Reserved by $reservedBy."
    }

    /**
     * Displays the status of the book in a readable format.
     * @return A string representing the current status of the book.
     */
    abstract fun displayStatus(): String
}
