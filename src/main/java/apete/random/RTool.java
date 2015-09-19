package apete.random;

/**
 * Created by bcmds on 19.09.2015.
 */
public interface RTool {
    static RTool Instance(){
        return new RTool() {
            final private RandomNames RN = new RandomNames();
            @Override
            public String getFullName(Gender gender) {
                return RN.getFullName(gender);
            }

            @Override
            public String getNameForPattern(String pattern,Gender gender) {
                    // @FF @LL @MM are full words
                    // @F @L @M

                String FF = RN.getNamePart(gender,NameParts.FIRSTNAME);
                String LL = RN.getNamePart(gender,NameParts.LASTNAME);
                String MM = RN.getNamePart(gender,NameParts.MIDDLENAME);

               return pattern.replace("@FF",FF)
                        .replace("@LL", LL)
                        .replace("@MM",MM)
                        .replace("@F", FF.substring(0,1).toUpperCase())
                        .replace("@L", LL.substring(0,1).toUpperCase())
                        .replace("@M",MM.substring(0,1).toUpperCase());


            }
        };
    }
    String getFullName(Gender gender);
    String getNameForPattern(String pattern,Gender gender);
}
