package applicationTest.utilsTest;

import Application.utils.CSVReader;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class CSVReaderTest {

    @Test
    public void csvParserTest() {
        CSVReader reader = new CSVReader();
        String currentDir = System.getProperty("user.dir");
        String filePath = currentDir + "/bookings.csv";
        ArrayList<List<String>> result;
        ArrayList<List<String>> expected = new ArrayList<>();

        List<String> temp = Arrays.asList("A","B","C","D","E");
        List<String> temp1 = Arrays.asList("1","2","3","4","5");
        List<String> temp2 = Arrays.asList("6","7","8","9","10");
        List<String> temp3 = Arrays.asList("11","12","13","14","15");

        expected.add(temp);
        expected.add(temp1);
        expected.add(temp2);
        expected.add(temp3);

        result = reader.CSVParser(filePath);
        System.out.println(expected);
        System.out.println(result);
        assertEquals(expected,result);
    }
}
