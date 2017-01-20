# more_coding_challenges

Part 1 (see Search.java and SearchTests.java):

Write search algorithm that finds location j in the array such that all elements in range A[0] … A[j-1] are strictly less than x and all elements in range A[j] … A[n-1] are greater than or equal to x (x doesn’t have to exist in A). Returns -1 if no suitable location is found. MUST run in O(log n) time.

Given an array A of N integers (where elements of A are not necessarily unique and sorted in ascending order). Given target integer x.

I also included a test suite.

---

Part 2 (see RandomLine.java):

Given a ridiculously large plain text file where each line contains a plain text string, and the file has at most 1 billion lines where each line is max 1000 characters long, write a program that prints an arbitrary line from the file.

The program will be run many times, and may minimize the runtime for subsequent executions. Additional disk storage is allowed. It should take two command line arguments: path of the file and index of line you want to print. Program should write the line to standard output.
