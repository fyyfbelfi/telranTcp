package telran.strings.test;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import telran.strings.*;

public class StringTests {
	String[] strings = {"ann", "ann", "ann"};
	String expected = "ann$ann$ann";
	
	
@Test
void joinBuilderTest() {
	JoinStrings js = new JoinStringsBuilderImpl();
	String[] strings = getStrings();
	String expected = getExpected();
	runTest(js, strings, expected);
}
@Test
void joinStringTest() {
	JoinStrings js = new JoinStringsImpl();
	String[] strings = getStrings();
	String expected = getExpected();
	runTest(js, strings, expected);
}


private void runTest(JoinStrings js, String[] strings2, String expected2) {
 assertEquals(expected2, js.join(strings2, "$"));
	
}


private String getExpected() {
	
	return expected;
}


private String[] getStrings() {
	
	return strings;
}

}
