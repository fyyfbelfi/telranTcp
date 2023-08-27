package telran.strings.test;
import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import telran.strings.JoinStrings;
import telran.strings.JoinStringsBuilderImpl;
import telran.strings.JoinStringsImpl;

public class StringPerfomanceTest {
	private static final int N_STRINGS = 1000;
	private static final int N_RUNS = 10000;
	String[] strings = {"ann", "ann", "ann"};
	String expected = "ann$ann$ann";
	
	
@Test
void joinBuilderTest() {
	JoinStrings js = new JoinStringsBuilderImpl();
	String[] strings = getStrings();
	
	runTest(js, strings);

}

@Test
void joinStringTest() {
	JoinStrings js = new JoinStringsImpl();
	String[] strings = getStrings();
	
	runTest(js, strings);
}

private void runTest(JoinStrings js, String[] strings2) {
	 for (int i = 0; i < N_RUNS; i++) {
		js.join(strings2, "$");
	}
		
	}

private String[] getStrings() {
	
	String [] res = new String[N_STRINGS];
	 for (int i = 0; i < N_STRINGS; i++) {
		 res[i] = "Hello";
	 }
	return res;
}

}
