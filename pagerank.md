Google's PageRank ( 100 points)
Implement the Google PageRank algorithm as explained below. The input for this problem would be a graph
represented through an adjacency list representation. The command-line interface that would be used is as
follows. The first two of the three parameters hold integer values; the last parameter is a filename.

% ./pagerank iterations initialvalue filename
% java pagerank iterations initialvalue filename

The PageRank of vertex A depends on the PageRanks of vertices T1,.....,Tm of vertices incident to A. The value
of d is 0.85. C(Ti)) is the out-degree of vertex Ti. When we compute ranks iteratively we use the previous
iteration values to update the current iteration values!

PR(A) = (1 - d)/n + d (PR(T1)/C(T1) + ... + PR(Tm)/C(Tm))

Thus PR(A) is the value to be obtained in the current iteration, but all PR (Ti) values are from the previous
iteration. This is called a synchronized update. Also note that for this assignment the user may control the
number of iterations. Another approach is that the iterations terminate when a given error rate is achieved.
This means that for every vertex the corresponding PageRank values between two successive iterations is LESS
than a given error bound say 10 raise to -4.Thus instead of specifying iterations one may specify an error bound (or
rate) and the algorithm checks how many iterations are needed to achieve this error rate, if possible. The rst
parameter iterations runs the algorithms for that number of iterations if iterations is a non-zero positive
integer (natural integer). A zero (0) has a special meaning; you need to run as many iterations k as needed. You
stop at iteration k if each one of pageranks between iteration k - 1 and k is smaller than a fixed error 10 raise to -4.

The second parameter initialvalue shows the initial values for the ranks. If it is 0 all ranks are initialized
to 0, if it is 1 they are initialized to 1. If it is -1 they are initialized to 1/N, where N is the number of web-pages
(vertices of the graph). If it is -2 they are initialized to 1/root of N, where N is the number of web-pages (vertices of
the graph). (In order to determine N you need to construct the graph described in file filename first.)

The third parameter filename describes the input (directed) graph and it has the following form. The first
line contains two numbers: the number of vertices (in the example below, this is equal to four and is denoted by
the first four) and the number of edges that follow on separate lines (the second four in the example). In each
line an edge (i, j) is represented by i j. Thus our graph has (directed) edges (0, 2); (0, 3); (1, 0); (2, 1).

Pageranks are printed to six decimal digits.
If the graph has N greater than 10, then the values for iterations, initialvalue revert to 0 and -1
respectively. In such a case the pageranks at the stopping iteration are ONLY shown, one per line.

The graph below will be referred to as samplegraph.txt

4 4

0 2

0 3

1 0

2 1


The following invocations relate to samplegraph.txt, with a fixed number of iterations and the xed error
rate that determines how many iterations will run. Your code should compute for this graph the same rank
values (intermediate and final). A sample of the output for the case of N > 10 is shown (output truncated to
first 4 lines of it).

% ./pagerank 15 -1 samplegraph.txt
Base : 0 :P[ 0]=0.250000 P[ 1]=0.250000 P[ 2]=0.250000 P[ 3]=0.250000

Iter : 1 :P[ 0]=0.250000 P[ 1]=0.250000 P[ 2]=0.143750 P[ 3]=0.143750

Iter : 2 :P[ 0]=0.250000 P[ 1]=0.159687 P[ 2]=0.143750 P[ 3]=0.143750

Iter : 3 :P[ 0]=0.173234 P[ 1]=0.159687 P[ 2]=0.143750 P[ 3]=0.143750

Iter : 4 :P[ 0]=0.173234 P[ 1]=0.159687 P[ 2]=0.111125 P[ 3]=0.111125

Iter : 5 :P[ 0]=0.173234 P[ 1]=0.131956 P[ 2]=0.111125 P[ 3]=0.111125

Iter : 6 :P[ 0]=0.149663 P[ 1]=0.131956 P[ 2]=0.111125 P[ 3]=0.111125

Iter : 7 :P[ 0]=0.149663 P[ 1]=0.131956 P[ 2]=0.101107 P[ 3]=0.101107

Iter : 8 :P[ 0]=0.149663 P[ 1]=0.123441 P[ 2]=0.101107 P[ 3]=0.101107

Iter : 9 :P[ 0]=0.142425 P[ 1]=0.123441 P[ 2]=0.101107 P[ 3]=0.101107

Iter : 10 :P[ 0]=0.142425 P[ 1]=0.123441 P[ 2]=0.098030 P[ 3]=0.098030

Iter : 11 :P[ 0]=0.142425 P[ 1]=0.120826 P[ 2]=0.098030 P[ 3]=0.098030

Iter : 12 :P[ 0]=0.140202 P[ 1]=0.120826 P[ 2]=0.098030 P[ 3]=0.098030

Iter : 13 :P[ 0]=0.140202 P[ 1]=0.120826 P[ 2]=0.097086 P[ 3]=0.097086

Iter : 14 :P[ 0]=0.140202 P[ 1]=0.120023 P[ 2]=0.097086 P[ 3]=0.097086

Iter : 15 :P[ 0]=0.139520 P[ 1]=0.120023 P[ 2]=0.097086 P[ 3]=0.097086



% ./pagerank 0 -1 samplegraph.txt

Base : 0 :P[ 0]=0.250000 P[ 1]=0.250000 P[ 2]=0.250000 P[ 3]=0.250000

Iter : 1 :P[ 0]=0.250000 P[ 1]=0.250000 P[ 2]=0.143750 P[ 3]=0.143750

Iter : 2 :P[ 0]=0.250000 P[ 1]=0.159687 P[ 2]=0.143750 P[ 3]=0.143750

Iter : 3 :P[ 0]=0.173234 P[ 1]=0.159687 P[ 2]=0.143750 P[ 3]=0.143750

Iter : 4 :P[ 0]=0.173234 P[ 1]=0.159687 P[ 2]=0.111125 P[ 3]=0.111125

Iter : 5 :P[ 0]=0.173234 P[ 1]=0.131956 P[ 2]=0.111125 P[ 3]=0.111125

Iter : 6 :P[ 0]=0.149663 P[ 1]=0.131956 P[ 2]=0.111125 P[ 3]=0.111125

Iter : 7 :P[ 0]=0.149663 P[ 1]=0.131956 P[ 2]=0.101107 P[ 3]=0.101107

Iter : 8 :P[ 0]=0.149663 P[ 1]=0.123441 P[ 2]=0.101107 P[ 3]=0.101107

Iter : 9 :P[ 0]=0.142425 P[ 1]=0.123441 P[ 2]=0.101107 P[ 3]=0.101107

Iter : 10 :P[ 0]=0.142425 P[ 1]=0.123441 P[ 2]=0.098030 P[ 3]=0.098030

Iter : 11 :P[ 0]=0.142425 P[ 1]=0.120826 P[ 2]=0.098030 P[ 3]=0.098030

Iter : 12 :P[ 0]=0.140202 P[ 1]=0.120826 P[ 2]=0.098030 P[ 3]=0.098030

Iter : 13 :P[ 0]=0.140202 P[ 1]=0.120826 P[ 2]=0.097086 P[ 3]=0.097086

Iter : 14 :P[ 0]=0.140202 P[ 1]=0.120023 P[ 2]=0.097086 P[ 3]=0.097086

Iter : 15 :P[ 0]=0.139520 P[ 1]=0.120023 P[ 2]=0.097086 P[ 3]=0.097086

Iter : 16 :P[ 0]=0.139520 P[ 1]=0.120023 P[ 2]=0.096796 P[ 3]=0.096796

Iter : 17 :P[ 0]=0.139520 P[ 1]=0.119776 P[ 2]=0.096796 P[ 3]=0.096796

Iter : 18 :P[ 0]=0.139310 P[ 1]=0.119776 P[ 2]=0.096796 P[ 3]=0.096796

Iter : 19 :P[ 0]=0.139310 P[ 1]=0.119776 P[ 2]=0.096707 P[ 3]=0.096707


% ./pagerank 0 -1 verylargegraph.txt

Iter : 3

P[ 0] = 0.021429

P[ 1] = 0.030536

P[ 2] = 0.027500

.

.

.

.

.

other vertices omitted

.

.

.



