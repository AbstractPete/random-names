package apete.random;

import com.sun.corba.se.spi.orbutil.fsm.Input;
import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.*;
import java.util.stream.Stream;

/**
 * Created by bcmds on 19.09.2015.
 */
public class RandomNames {
    private final Random random;

    private enum TYPE{
       F_LASTNAME,
       F_FIRSTNAME,
       F_PATRONYMICS,
       M_LASTNAME,
       M_FIRSTNAME,
       M_PATRONYMICS;
        }
    private static final class LOCALE_RU{
        public final static Map<TYPE,String> RU = new EnumMap<>(TYPE.class);
        static String PATH = "resource/ru/";
        static {
            RU.put(TYPE.M_LASTNAME,PATH + "male_surnames.txt");
            RU.put(TYPE.M_FIRSTNAME,PATH + "male_names.txt");
            RU.put(TYPE.M_PATRONYMICS,PATH + "male_patronymics.txt");
            RU.put(TYPE.F_LASTNAME,PATH + "female_surnames.txt");
            RU.put(TYPE.F_FIRSTNAME,PATH + "female_names.txt");
            RU.put(TYPE.F_PATRONYMICS,PATH + "female_patronymics.txt");
        }
    }


    private  String[] fLastName;
    private  String[] fFirstName;
    private  String[] fMiddleName;
    private  String[] mLastName;
    private  String[] mFirstName;
    private  String[] mMiddleName;
    public RandomNames() {
        this.random = new Random(System.currentTimeMillis());
        try {
            loadResource();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private void loadResource() throws IOException {
        ClassLoader loader = this.getClass().getClassLoader();
        fLastName = fill(loader.getResourceAsStream(LOCALE_RU.RU.get(TYPE.F_LASTNAME)));
        fFirstName = fill(loader.getResourceAsStream(LOCALE_RU.RU.get(TYPE.F_FIRSTNAME)));
        fMiddleName = fill(loader.getResourceAsStream(LOCALE_RU.RU.get(TYPE.F_PATRONYMICS)));
        mLastName = fill(loader.getResourceAsStream(LOCALE_RU.RU.get(TYPE.M_LASTNAME)));
        mFirstName = fill(loader.getResourceAsStream(LOCALE_RU.RU.get(TYPE.M_LASTNAME)));
        mMiddleName = fill(loader.getResourceAsStream(LOCALE_RU.RU.get(TYPE.M_PATRONYMICS)));
    }

    private String[] fill(InputStream is){
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line;
            List<String> buffer = new ArrayList<>();
            while ((line= reader.readLine()) != null){
                buffer.add(line);
            }
            return buffer.toArray(new String[buffer.size()]);
        }catch (IOException e){
            System.out.println(e.getMessage());
            return new String[0];
        }

    }
    public String getFullName(Gender gender){
        switch (gender){
            case MALE:{
                return String.format("%s %s %s"
                        ,getRandom(mLastName)
                        ,getRandom(mFirstName)
                        ,getRandom(mMiddleName));
            }
            case FEMALE:{
                return String.format("%s %s %s"
                        ,getRandom(fLastName)
                        ,getRandom(fFirstName)
                        ,getRandom(fMiddleName));
            }
            default:{
                throw new IllegalArgumentException("Your 'gender' not supported yet!");
            }
        }
    }

    public String getNamePart(Gender gender,NameParts parts){
        switch (gender){
            case MALE:{
                switch (parts){
                    case FIRSTNAME:{
                        return getRandom(mFirstName);
                    }
                    case LASTNAME:{
                        return getRandom(mLastName);
                    }
                    case MIDDLENAME:{
                        return getRandom(mMiddleName);
                    }
                    default:throw new IllegalArgumentException("This part name not supported yet!");
                }
            }
            case FEMALE:{
                switch (parts){
                    case FIRSTNAME:{
                        return getRandom(fFirstName);
                    }
                    case LASTNAME:{
                        return getRandom(fLastName);
                    }
                    case MIDDLENAME:{
                        return getRandom(fMiddleName);
                    }
                    default:throw new IllegalArgumentException("This part name not supported yet!");
                }
            }
            default:{
                throw new IllegalArgumentException("Your 'gender' not supported yet!");
            }
        }
    }



    private String getRandom(String[] dictionary){
        if (dictionary != null){
            return dictionary[rangeOfRandom(0,dictionary.length)];
        }else return "";
    }
    private int rangeOfRandom(int min,int max){
        return this.random.nextInt((max - min) + 1) + min;
    }
}
