package tests;

import apete.random.Gender;
import apete.random.RTool;
import apete.random.RandomNames;
import org.junit.Test;

import java.util.Random;

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
        System.out.println(fullName);
        System.out.println();
        System.out.println(rTool.getNameForPattern("FF LL",Gender.MALE));
        System.out.println(rTool.getNameForPattern("@F @M @F @MM @LL @FF",Gender.FEMALE));


    }
}
