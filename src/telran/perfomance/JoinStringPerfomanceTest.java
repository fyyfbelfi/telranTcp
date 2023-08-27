package telran.perfomance;

import telran.strings.JoinStrings;

public class JoinStringPerfomanceTest extends PerfomanceTest {
	
	private String [] strings;
	private JoinStrings joinStrings;
	private String delimiter = "$";
	
	public JoinStringPerfomanceTest(String name, int num, String [] str, JoinStrings join) {
		super(name, num);
		strings = str;
		joinStrings = join;
		
	}

	@Override
	protected void runTest() {
		joinStrings.join(strings, delimiter);

	}

}
