Individual Project    
Name: Sai Kapadekar        
ID: 015937727   
  
  #### Class Diagram
  
![indiv_project](https://user-images.githubusercontent.com/91869107/144800685-bf752efb-c3b8-4c94-be58-9e476935a63d.png)


Steps to run project in Git Bash

1.  git clone https://github.com/gopinathsjsu/individual-project-sai-kapadekar.git
2.  cd individual-project-sai-kapadekar
3.  cd src
4.  javac *.java (optional)
5.  java Main

Output of testcases:
1. Test case 1

![testcase_1](https://user-images.githubusercontent.com/91869107/144802330-7c271b40-7f92-41e8-8e75-672d936259dc.PNG)

2. Test case 2

![testcase_2](https://user-images.githubusercontent.com/91869107/144802416-3a8c54b0-e5d0-4a0c-87db-3abb9dd5c351.PNG)

3. Test case 3

![testcase_3](https://user-images.githubusercontent.com/91869107/144802446-92c39414-8177-48da-b926-a78bf496027b.PNG)

Design patterns used:

1. Singleton

Since the database is static and must not be modified during the execution of the project, Singleton is an ideal design pattern to implement, where the constructor is private and only one instance of class can be instantiated.

Class associated with it is:     DatasetSingle


2. Iterator

To iterate over the entries of order in CSV file, Iterator design pattern is used. Input files are accessed using this class. This helps us in accessing complex data stored in the file individually.

Classes associated with it are:
AggregateIP   
ConcAggregateIP   
Iterator   
ConcIterator   


3. Chain of responsibility

Chain of responsibility design pattern is used when there is a series of processing to be done on objects. Here we need to check if order items are within the limit given and if that much quantity is present in stock. Only after these two validations are done we can calculate final price of cart. To implement this best Chain of Responsibility design pattern is used.

Classes associated with it are:
OrderHandler   
ValidateStock   
ValidateMaxQty   
PriceCalculate   
