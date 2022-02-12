package it.unikey.utilities;

public abstract class IntUtil {

    public static boolean isInt(String nToCheck) {
        try {
            Integer.parseInt(nToCheck);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public int toInt(String nToParse) {
        return Integer.parseInt(nToParse);
    }

}
