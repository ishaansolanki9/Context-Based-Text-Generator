Name: Text Context Generator
Description: 
  A Java program that models contextual relationships between words and generates
  random or gibberish-like text using custom data structures. Demonstrates linked
  lists, iterators, and object-oriented programming in text generation.

Features:
  - Generates gibberish or random text using contextual word models
  - Custom LinkedList and iterator implementation
  - Stores contextual relationships between words
  - Includes automated unit tests for all core classes
  - Demonstrates advanced Java data structure design

Files:
  - Context.java: Defines and manages contextual relationships between words
  - ContextData.java: Stores contextual information and structures
  - WordData.java: Represents individual words and their contextual frequency
  - LinkedList.java: Custom linked list implementation
  - GibberishWriter.java: Generates output text based on stored context
  - ContextTest.java: Tests for Context class
  - ContextDataTest.java: Tests for ContextData logic
  - WordDataTest.java: Tests for WordData functionality
  - LinkedListTest.java: Tests for linked list behavior
  - LLIteratorTest.java: Tests custom iterator traversal
  - GibberishWriterTest.java: Validates gibberish generation logic

Usage:
  Steps:
    - Clone the repository:
      - git clone https://github.com/yourusername/text-context-generator.git
      - cd text-context-generator
    - Compile all Java files:
      - javac *.java
    - Run the generator:
      - java GibberishWriter
  Example:
    Input:
      - Example corpus: "the cat sat on the mat"
    Output:
      - Generated gibberish: "cat mat sat on the cat"

Concepts Used:
  - Custom data structures (LinkedList, Iterator)
  - Object-oriented design principles
  - Text parsing and contextual modeling
  - File I/O and randomization algorithms
  - Java testing and modular programming

Testing:
  - Run included test suites:
    - java ContextTest
    - java ContextDataTest
    - java WordDataTest
    - java LinkedListTest
    - java LLIteratorTest
    - java GibberishWriterTest
  - Tests validate data integrity, iteration, and generation logic

License: MIT License © 2025 Ishaan Solanki
