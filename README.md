# Library-Management-System

<h2>Design and implement a Library Management System in Java that incorporates the 
    following aspects:</h2> <br> <hr>
    <h3>Classes.</h3><br><hr>
    <ol><h3><li><i><strong> library class:</strong></i></li></h3><br>
        <ul><li>Manages the overall system. </li>
        <li>Contains lists/arrays of books, members, and transactions. </li>
        <li>Methods to add/remove books, register members, handle transactions, and 
        display information.</li></ul>
    <h3><li><i><strong> book class:</strong></i></li></h3><br>
        <ul><li>Attributes: title, author, genre, availability, etc. </li>
        <li>Methods to update availability status, retrieve book details, etc. </li>
        <li>For inheritance: Consider potential subclasses like FictionBook and 
        NonFictionBook.</li></ul>
    <h3><li><i><strong> member class:</strong></i></li></h3><br>
        <ul> <li>Attributes: name, ID, borrowedBooks (a list of books currently borrowed).</li>
        <li>Methods to borrow/return books, display member details, etc.</li> </ul>
    <h3><li><i><strong> transaction class:</strong></i></li></h3><br>
        <ul><li>Attributes: book, member, transactionDate, transactionType (borrow/return).</li>
        <li>Methods to log transactions, retrieve transaction history, etc. </li></ul> <hr>
    </ol>
    <h3>Constructors:</h3><br> <hr>
        <ul><li>Implement default constructors and parameterized constructors for each class to 
        initialize their attributes upon object creation. </li>
        <li> Utilize constructors to set default values and ensure proper initialization of objects. </li>
        </ul><hr>
    <h3>Overloading:</h3><br> <hr>
    <p>Overload borrowing methods in the Library class to handle different scenarios: </p>
        <ul><li> Borrowing by member ID and book ID.</li>
        <li> Borrowing by book title, author, or genre.</li></ul>
    <h3>Overridinging:</h3><br> <hr>
        <ul><li>Override the toString() method in each class to provide customized representations 
            when objects are printed or converted to strings. </li>
        <li>For instance, in the Book class, the toString() method could display all book details. </li></ul> <hr>
    <h3>Inheritance: </h3><br> <hr>
        <ul><li>Create subclasses of Book such as FictionBook and NonFictionBook.</li>
        <li>These subclasses can inherit common attributes/methods from the Book class and 
        introduce specific characteristics or behaviors. </li></ul>
    <h3>Functionality to Implement: </h3><br> <hr>
        <ull><li> <b>Add Books:</b> Library method to add new books to the inventory.  </li>
        <li><b>Register Members:</b> Library method to register new members with unique IDs.  </li>
        <li><b>Borrow/Return Books:</b> Methods in the Library and Member classes to handle book 
            transactions.  </li>
        <li><b> Display Information:</b> Methods to show available books, borrowed books, member 
            details, etc. </li>
        <li> <b>Search Functionality:</b> Methods to search for books by title, author, or genre. </li>
        <li><b> Transaction Logs:</b> Maintain logs of book transactions (borrowing/returning) for record
            keeping. </li> </ull><hr>
        <p>This project combines multiple aspects of object-oriented programming in Java, 
            challenging you to design a cohesive system that effectively manages a library's 
            functionalities while utilizing concepts like inheritance, overloading, overriding, and 
            constructors. </p><hr>
        <p><b>Sample output for the Library Management System in text format can provide an idea of 
            how the functionalities might work together.</b></p><hr>
        
