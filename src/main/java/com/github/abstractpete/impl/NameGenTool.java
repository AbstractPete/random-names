package com.github.abstractpete.impl;

import com.github.abstractpete.Gender;
import com.github.abstractpete.NameParts;
import com.github.abstractpete.RTool;
import com.github.abstractpete.RandomNames;
import org.jetbrains.annotations.NotNull;

/**
 * Created by bcmds on 19.09.2015.
 */
public class NameGenTool implements RTool {
    final private RandomNames RN = new RandomNames();
    @Override
    public String getFullName(Gender gender) {
        return RN.getFullName(gender);
    }

    @Override
    public String getNameForPattern(@NotNull String pattern,@NotNull Gender gender) {
        // @FF @LL @MM are full words
        // @F @L @M
        String FF = RN.getNamePart(gender, NameParts.FIRSTNAME);
        String LL = RN.getNamePart(gender,NameParts.LASTNAME);
        String MM = RN.getNamePart(gender,NameParts.MIDDLENAME);

        return pattern.replace("@FF",FF)
                .replace("@LL", LL)
                .replace("@MM",MM)
                .replace("@F", FF.substring(0,1).toUpperCase())
                .replace("@L", LL.substring(0,1).toUpperCase())
                .replace("@M",MM.substring(0,1).toUpperCase());
    }
}
