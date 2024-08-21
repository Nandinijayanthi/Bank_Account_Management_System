
# Bank Account Management System in Java

## Overview
The Bank Account Management System is a basic project in Java that demonstrates core Object-Oriented Programming (OOP) concepts. This system allows for the creation and management of different types of bank accounts and simulates basic banking operations such as deposits, withdrawals, and interest calculations.

## Concepts Used

### 1. Classes
- **Account:** A general class representing any bank account, containing attributes like balance and methods for operations such as deposit and withdrawal.
- **Customer:** Represents a bank customer, associated with an account, and capable of performing actions on that account.
- **SavingsAccount:** Inherits from `Account`, represents a savings account that can accumulate interest over time.
- **CheckingAccount:** Inherits from `Account`, represents a checking account with an overdraft limit.

### 2. Inheritance
- **SavingsAccount and CheckingAccount:** Both inherit from the `Account` class, sharing common properties like balance but differing in specific behaviors, such as interest application for savings accounts and overdraft handling for checking accounts.

### 3. Encapsulation
- **Balance Management:** The `balance` attribute in the `Account` class is private, ensuring it cannot be directly accessed or modified from outside the class. Instead, public methods like `deposit` and `withdraw` are used to safely modify the balance, maintaining control and integrity of the data.

### 4. Polymorphism
- **Method Overriding:** The `withdraw` method is overridden in the `CheckingAccount` class to allow for overdrafts, demonstrating how derived classes can modify or extend the behavior of methods from the base class.

## Summary
The Bank Account Management System in Java is an illustrative example of how fundamental OOP concepts can be applied to create a functional and extendable software system. By using classes, inheritance, encapsulation, and polymorphism, this system models real-world banking operations while maintaining a clean and organized code structure.
