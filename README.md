> > # LMS - Library Management System

### Setup

These instructions will get you a copy of the project up and running on your local machine for development and testing
purposes.

### Prerequisites

Before you begin, ensure you have the following software installed on your computer:

- Java JDK 17 or higher
- Maven 3.6.3 or higher

### Installation

Follow these steps to set up your development environment:

1. **Clone the Repository**

    ```bash
    git clone git@github.com:ayidaweiwei/LMS.git
    cd LMS
    ```

2. **Build the Project**

   Use Maven to compile the project and download its dependencies:

    ```bash
    mvn clean install
    ```

### Usage

To run the Library Management System, use the following command from the root directory of the project:

```bash
java -cp target/LMS-1.0-SNAPSHOT.jar
```

### Business	Functions

1. Users    (User)    and Administrators    (Admin)    can register and log in to the system.
2. Users can view the list of books, borrow multiple books, and return these books.
3. Administrators have the authority to view the list of books, add books, delete books. If a book is already in the
   system and the administrator tries to add it again, the system should merge the inventory rather than create a new
   one. Also, administrators cannot delete books that are currently being borrowed by users.

### Command-line	Input/Output	Examples

```
   $ register admin Alice password1  
   Admin Alice successfully registered.  
   $ register user Bob password2  
   User Bob successfully registered.  
   $ login Alice password1  
   Admin Alice successfully logged in.  
   $ add "Clean Code" "Robert C. Martin" 5  
   Book "Clean Code" by Robert C. Martin added successfully, inventory: 5.  
   $ list  
   Book List:  
   Clean Code - Robert C. Martin - Inventory: 5  
   $ login Bob password2  
   User Bob successfully logged in.  
   $ search "Clean Code" "Robert C. Martin"  
   Clean Code - Robert C. Martin - Inventory: 5  
   $ borrow "Clean Code" " Robert C. Martin"  
   Book "Clean Code" successfully borrowed.  
   $ login Alice password1  
   Admin Alice successfully logged in.  
   $ delete "Clean Code" " Robert C. Martin"  
   Cannot delete book "Clean Code" because it is currently borrowed.  
   $ login Bob password2  
   User Bob successfully logged in.  
   $ return "Clean Code" " Robert C. Martin"  
   Book "Clean Code" successfully returned.  
   $ login Alice password1  
   Admin Alice successfully logged in.  
   $ add "Clean Code" "Robert C. Martin" 3  
   Book "Clean Code" inventory successfully updated, new inventory: 8.  
 ```
