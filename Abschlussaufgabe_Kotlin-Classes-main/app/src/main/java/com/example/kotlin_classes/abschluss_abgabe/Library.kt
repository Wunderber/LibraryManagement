package com.example.kotlin_classes.abschluss_abgabe

/**
 * Represents a library containing a collection of books and providing functionalities
 * for managing library members, books, and the library address.
 */
class Library {
    private val books = mutableListOf<Book>()

    /**
     * Represents the address of the library.
     * @property street The street of the library.
     * @property city The city where the library is located.
     * @property zipCode The postal code of the library.
     */
    class LibraryAddress(val street: String, val city: String, val zipCode: String) {
        /**
         * Prints the full address of the library to the console.
         */
        fun printAddress() {
            println("Address: $street, $city, $zipCode")
        }
    }

    /**
     * Represents a member of the library who can check out and reserve books.
     * @property name The name of the library member.
     * @property memberID The unique identifier for the library member.
     */
    inner class LibraryMember(val name: String, val memberID: String) {
        /**
         * Checks out a book for the member if it is available.
         * @param book The book to be checked out.
         * @param dueDate The date by which the book must be returned.
         */
        fun checkoutBook(book: Book, dueDate: String) {
            if (book.status is BookStatus.Available) {
                book.status = BookStatus.CheckedOut(dueDate)
                println("$name checked out '${book.title}'.")
            } else {
                println("'${book.title}' is not available for checkout.")
            }
        }

        /**
         * Reserves a book for the member if it is available.
         * @param book The book to be reserved.
         */
        fun reserveBook(book: Book) {
            if (book.status is BookStatus.Available) {
                book.status = BookStatus.Reserved(name)
                println("$name reserved '${book.title}'.")
            } else {
                println("'${book.title}' cannot be reserved.")
            }
        }
    }

    /**
     * Adds a new book to the library's collection.
     * @param book The book to be added.
     */
    fun addBook(book: Book) {
        books.add(book)
        println("Added '${book.title}' to the library.")
    }

    /**
     * Searches for books by title or author.
     * @param query The search term for title or author.
     * @return A list of books that match the query.
     */
    fun findBooksByTitleOrAuthor(query: String): List<Book> {
        return books.filter {
            it.title.contains(query, ignoreCase = true) || it.author.contains(
                query,
                ignoreCase = true
            )
        }
    }

    /**
     * Displays the current status of all books in the library.
     */
    fun displayBookStatuses() {
        books.forEach { book ->
            println("${book.title} by ${book.author}: ${book.status.displayStatus()}")
        }
    }
}
