# Maximum-Processes-running
This file reads millions of lines of log file and gives date and time at which maximum processes are running.

This project consist of following files:
JunitTest.java ------------------ Junit testcases.
MaxProcesses.class--------------- Compiled java class file.
MaxProcesses.java---------------- Main program to find max # of running processes.
Output.class--------------------- Compiled java class file.
Output.java---------------------- Class to wrap output.

How to execute the program?
1) Go to terminal 
2) Compile the java program using: $ javac MaxProcesses.java
3) Execute the program using: $ java MaxProcesses <<Path to log file>>
    ex: $ java MaxProcesses /Users/admin/Desktop/Process.log
4) Output will be: [2018-03-07 11:16:29]4

About the program:
1) Data type used for currmax and count is long to handle large values as files can have millions of records which int cannot hold 
and to avoid Integer overflow error.
2) Bufferedreader is used to fetch log data from disk to memory in chunks and default chunk size is 8192 characters which is enough for
small file but for large file size can be increased in multiples of 2. ex: 2*1024, 8*1024 etc. I took size as 8kb. 
3) Arraylist is used as there can be multiple date and time with maximum # of running process. Also output of the program is wrapped into 
Output.java class which has list of string and count of max running process.This was done so that caller program can parse the output easily.
4) Time complexity ----- O(n) --n is # of lines in log file.
5) Space complexity----- O(1)

Approach to solve this problem:
Read data line by line from buffer and checked for "Process_End" when not found incremented the count and kept track of current maximum
value of # of running process. Added datetime to arraylist and wrapped the output in Output.java class.

Performed following testcases using Junit

1. Process log file not found/does not exists  -- expected o/p -- throw file not found exception
2. log file is empty. -- expected o/p -- return Output object with empty list and count as 0
3. Normal log file -- expected o/p -- return Output object
4. log file with blank link between records. -- expected o/p -- return Output object
5. log file with multiple time stamp showing maximum number of running process -- expected o/p -- return Output object
6. Varied bufferedreader size and checked time required for execution using System.nano() and found that for small data default size is good 
   and for large file changing buffer size increased performance.
