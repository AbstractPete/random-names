package tests;

import com.github.abstractpete.Gender;
import com.github.abstractpete.RTool;
import com.github.abstractpete.RandomNames;
import org.junit.Test;

/**
 * Created by bcmds on 19.09.2015.
 */
public class LoadResourcesTest {
    @Test
    public void testLoadResourceOfRuLocale() throws Exception {
        RandomNames rn = new RandomNames();
        assert rn != null;
    }
    @Test
    public void testGetRandomMaleName() throws Exception {
        RandomNames names = new RandomNames();
        String fullName = names.getFullName(Gender.FEMALE);
        System.out.println(fullName);
    }
    @Test
    public void testNamesForPattern() throws Exception {
        RTool rTool = RTool.Instance();
        String fullName = rTool.getFullName(Gender.MALE);
       /* System.out.println(fullName);
        System.out.println();
        System.out.println(rTool.getNameForPattern("FF LL",Gender.MALE));
        System.out.println(rTool.getNameForPattern("@F @M @F @MM @LL @FF",Gender.FEMALE));*/
    }

    @Test(expected = NullPointerException.class)
    public void testName() throws Exception {
        RTool tool = RTool.Instance();
        String nameForPattern = tool.getNameForPattern(null, null);
        System.out.println(nameForPattern);
    }

    @Test
    public void testRunTest() throws Exception {
        RTool tool = RTool.Instance();
        int i = 0;
        while (i++ < 10){
            System.out.println(tool.getNameForPattern("@LL @F. @M.", Gender.FEMALE));
        }

    }
}
