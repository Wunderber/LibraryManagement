package com.example.kotlin_classes.abschluss_abgabe

fun main() {
    val library = Library()

    // Add books to the library
    val book1 = Book("1984", "George Orwell", Genre.FICTION, BookStatus.Available)
    val book2 = Book("A Brief History of Time", "Stephen Hawking", Genre.SCIENCE, BookStatus.Available)
    val book3 = Book("The Cat in the Hat", "Dr. Seuss", Genre.CHILDREN, BookStatus.Available)

    library.addBook(book1)
    book1.genre.printDescription()
    library.addBook(book2)
    library.addBook(book3)


    // Set library address
    val address = Library.LibraryAddress("123 Library St", "Heilbronn", "74072")
    address.printAddress()

    // Create a library member
    val member = library.LibraryMember("Robert", "M001")

    // Member checks out and reserves books
    member.checkoutBook(book1, "2024-12-31")
    member.reserveBook(book2)

    // Display book statuses
    library.displayBookStatuses()
}