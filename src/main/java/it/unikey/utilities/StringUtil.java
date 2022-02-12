package it.unikey.utilities;

import java.util.Arrays;
import java.util.stream.Collectors;

public class StringUtil {

    public static String inizialeMaiuscola(String parola) {
        String[] parolaArray = parola.toLowerCase().split("");
        parolaArray[0] = parolaArray[0].toUpperCase();
        return Arrays.asList(parolaArray).stream().collect(Collectors.joining());
    }

}
