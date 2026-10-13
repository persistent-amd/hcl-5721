# Assessment 2: Library Management System
**HCL Tech Training | Java Full Stack Development**

- **Name:** Adarsh Prajapati
- **Roll Number:** 2300321540010
- **Batch / Branch:** CSE DS

---

## 1. Project Overview
This project is a console-based **Library Management System** implemented in core Java. It brings together fundamental object-oriented programming concepts, exception handling, data structures, and the Java Collections Framework.

### Key Highlights
- **Java Basics & OOP**: Clear inheritance hierarchy with abstract class `LibraryItem` implementing `Borrowable`, extended by concrete classes `Book`, `Magazine`, and `DVD`. Encapsulated private fields, overloaded constructors, and validated inputs.
- **Polymorphism**: Unified processing of items using `lateFee()` dynamic method dispatch and chained comparator sorting.
- **Custom Exception Handling**: Layered custom exceptions (`LibraryException`, `ItemNotAvailableException`, `InvalidMemberException`, `InvalidReturnException`) preserving the root cause.
- **Robust Collections & Identity**: `ArrayList` for item/member records, `HashSet` for ISBN uniqueness, `Map<Integer, Queue<Member>>` for FIFO waitlists with safe iterator removal, and `Comparator` chaining for dual-key sorting.
- **Reporting**: Report generation with `try-with-resources` ensuring safe I/O handling.

---

## 2. Project Layout
```text
Assignment/
├── .gitignore
├── README.md
└── src/
    └── com/
        └── hcl/
            └── library/
                ├── Book.java
                ├── BookNotAvailableException.java
                ├── Borrowable.java
                ├── CollectionUtils.java
                ├── DVD.java
                ├── InvalidMemberException.java
                ├── InvalidReturnException.java
                ├── ItemNotAvailableException.java
                ├── LateFeeCalculator.java
                ├── LibraryException.java
                ├── LibraryItem.java
                ├── LibraryRepository.java
                ├── LibraryService.java
                ├── Magazine.java
                ├── Member.java
                ├── ReportGenerator.java
                └── Waitlist.java
```

---

## 3. How to Compile and Run

### Prerequisites
- JDK 8 or higher (JDK 17/21 recommended)
- Git and Terminal / PowerShell

### Step-by-step Execution
Navigate to the root directory of the project in terminal:

```bash
# 1. Compile all Java source files into an output folder
javac -d out src/Assessment_2_Adarsh_Prajapati_2300321540010_CSEDS/Assignment/src/com/hcl/library/*.java

# 2. Run the Main application
java -cp out com.hcl.library.Main
```

---

## 4. Class Diagram & Architecture Summary

### Class Relationships
1. **`Borrowable` (Interface)**:
   - Methods: `borrow()`, `returnItem()`
2. **`LibraryItem` (Abstract Class implements `Borrowable`)**:
   - Fields: `id` (auto-incremented from 1001), `title`, `year`, `available`.
   - Abstract method: `abstract double lateFee(int daysLate)`
   - Identity: `equals()` and `hashCode()` based on unique `id`.
3. **Subclasses of `LibraryItem`**:
   - `Book`: Additional fields `author`, `isbn`. Late fee: 2.0 / day.
   - `Magazine`: Additional field `issueNumber`. Late fee: 1.0 / day.
   - `DVD`: Additional field `durationMinutes`. Late fee: 5.0 / day.
4. **`Member`**:
   - Represents a library patron with `id` and `name`.
5. **Exceptions (`LibraryException` extends `Exception`)**:
   - `ItemNotAvailableException` (and alias `BookNotAvailableException`)
   - `InvalidMemberException`
   - `InvalidReturnException`
6. **`Waitlist`**:
   - Uses `Map<Integer, Queue<Member>>` to queue members waiting for borrowed items.
   - Safe member removal using `Iterator.remove()`.
7. **`LibraryRepository`**:
   - In-memory data store using `ArrayList` and `HashSet` for uniqueness.
8. **`LibraryService`**:
   - Manages library workflows and enforces business rules.

---

## 5. Test Cases & Verification

### Test Case 1: Member Registration & Book Addition
- **Input**:
  - Register Member: ID `101`, Name `Shaurya`
  - Add Item: Type `Book`, Title `Java 101`, Year `2021`, Author `John`, ISBN `ISBN-001`
- **Expected Output**:
  - `Member registered successfully.`
  - `Book added successfully.` (Item assigned ID `1001`)

### Test Case 2: Borrow and Return Flow with Waitlist Notification
- **Input**:
  - Register Member 1: ID `101`, Name `Shaurya`
  - Register Member 2: ID `102`, Name `Adarsh`
  - Member `101` borrows Item `1001`.
  - Member `102` attempts to borrow Item `1001`.
  - Member `101` returns Item `1001`.
- **Expected Output**:
  - `Item ID 1001 borrowed successfully by Member 101.`
  - `[Library Error] Item 'Java 101' (ID: 1001) is currently unavailable. Member Adarsh added to waitlist.`
  - `Item ID 1001 returned successfully.`
  - `[Waitlist Notification] Member Adarsh (ID: 102) is next in queue for Item ID 1001!`

### Test Case 3: Edge Case — Returning an Unborrowed Item (`InvalidReturnException`)
- **Input**:
  - Return Item `1001` by Member `101` when the item is already in the library.
- **Expected Output**:
  - `[Library Error] Item ID 1001 was not borrowed.`

### Test Case 4: Edge Case — Duplicate ISBN Prevention (`HashSet`)
- **Input**:
  - Add Book: Title `Java Advanced`, Year `2022`, Author `James`, ISBN `ISBN-001`
- **Expected Output**:
  - `[Library Error] Duplicate ISBN detected: ISBN-001. Book cannot be added.`

### Test Case 5: Edge Case — Input Validation
- **Input**:
  - Add Book: Title ` `, Year `1850`
- **Expected Output**:
  - `[Validation Error] Title cannot be blank.` (or `[Validation Error] Year must be between 1900 and 2026.`)

---

## 6. Challenges Faced and Learnings
- **Safe Iteration on Collections**: Learned that calling `Collection.remove()` during an enhanced for-loop throws `ConcurrentModificationException`. Resolved by using `Iterator.remove()` in `Waitlist.removeWaitlistMember()`.
- **Exception Chaining**: Applied constructor chaining (`super(message, cause)`) to keep full stack traces when rethrowing custom exceptions.
- **Polymorphic Design**: Avoided `instanceof` checks when calculating late fees by utilizing dynamic method dispatch with `item.lateFee(daysLate)`.