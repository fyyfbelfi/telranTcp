package telran.perfomance;

public abstract class PerfomanceTest {
 private String testName;
 private int nRuns;
 
 public PerfomanceTest(String name, int num) {
	 testName = name;
	 nRuns = num;
 }
 
 public void run() {
	 long startTime = System.currentTimeMillis();
	 for (int i = 0; i < nRuns; i++) {
		runTest();
	}
	long finishTime = System.currentTimeMillis();
	 
	 System.out.print("test name = " + testName + 
			 " nums of run= " + nRuns + 
			 " time = " + (finishTime - startTime) + " ms \n");
 
 }
 
 protected abstract  void runTest();
 
}
