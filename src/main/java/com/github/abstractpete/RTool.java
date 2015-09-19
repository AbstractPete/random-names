package com.github.abstractpete;

import com.github.abstractpete.impl.NameGenTool;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Created by bcmds on 19.09.2015.
 */
public interface RTool {
    @Nullable public static RTool Instance(){
        return new NameGenTool();
    }
    String getFullName(Gender gender);
    String getNameForPattern(String pattern, Gender gender);
}
