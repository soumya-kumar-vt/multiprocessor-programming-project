# Implementation and Performance Analysis of Concurrent AVL Trees


There are two different types of AVL trees i.e. coarse-grain and fine-gran as well as RBTree implementations included in this project.

1.Coarse-grain AVL tree:

steps to run:
1. Go to the folder AVL Tree.
2. Test_AVl is the test file for running coarse-grain avl tree.
3. Exected output:
   By changing the number of operations (variable PER_THREADS) for every operations like insertion,
 deletion, we can see the changes in the throughput.

 
2. Fine-grain AVL tree

steps to run:
1. Go to folder RelaxedAVLTree folder. 
2. inside src file, open test_bench.
3. Run TestBench which is a test file for fine-grained avl tree.
4. Expected output:
      By changing the values of maxThreads(Thread numbers), numOps(Iterations), we can see the change in throughput.


3. RBTree

steps to run:
1. Go to folder src. 
2. Inside src run the test file TestTrees.java.
3. Expected output:
    By changing the variable num_threads(Number of threads) we can see the change in time required as well as the throughput. 

