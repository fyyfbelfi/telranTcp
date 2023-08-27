package telran.perfomance;

import telran.strings.JoinStringsBuilderImpl;
import telran.strings.JoinStringsImpl;

public class JoinStringPerfomanceAppl {
	private static final int N_STRINGS = 1000;
	private static final int N_RUNS = 10000;
	
	public static void main(String [] args) {
		String [] str = getStrings();
		new JoinStringPerfomanceTest("StringsImplTest", N_RUNS, str, new JoinStringsImpl()).run();
		new JoinStringPerfomanceTest("BuilderImplTest", N_RUNS, str, new JoinStringsBuilderImpl()).run();
			
		
	}

	
	private static String[] getStrings() {
		
		String [] res = new String[N_STRINGS];
		 for (int i = 0; i < N_STRINGS; i++) {
			 res[i] = "Ann";
		 }
		return res;
	}
}
