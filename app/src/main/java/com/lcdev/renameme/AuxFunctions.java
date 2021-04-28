package com.lcdev.renameme;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Random;
import java.util.UUID;

public class AuxFunctions {

    public static void WriteSharedPref(Context zC, String zKey, String zVal)
    {
        SharedPreferences prefs = zC.getSharedPreferences(
                BuildConfig.APPLICATION_ID, Context.MODE_PRIVATE);
        prefs.edit().putString(zKey, zVal).commit();
    }

    public static String ReadSharedPreference(Context zC, String zKey)
    {
        String retVal="";
        SharedPreferences prefs = zC.getSharedPreferences(
                BuildConfig.APPLICATION_ID, Context.MODE_PRIVATE);

        retVal = prefs.getString(zKey, retVal);
        return retVal;
    }
    public static String CreatePFID()
    {
        UUID uuid = UUID.randomUUID();
        String randomUUIDString = uuid.toString();
        return randomUUIDString;
    }
    private static final String ALLOWED_CHARACTERS_ALPHANUMERIC ="0123456789qwertyuiopasdfghjklzxcvbnm";
    private static final String ALLOWED_CHARACTERS_NUMERIC ="0123456789";
    private static final String ALLOWED_CHARACTERS_ALPHA ="0123456789";
    private static final String ALLOWED_CHARACTERS_HEX ="0123456789ABCDEF";
    public static String CreateRandomString(String Type, final int sizeOfRandomString)
    {
        final Random random=new Random();
        final StringBuilder sb=new StringBuilder(sizeOfRandomString);
        for(int i=0;i<sizeOfRandomString;++i)
            if (Type.equals("AN"))
            {
                sb.append(ALLOWED_CHARACTERS_ALPHANUMERIC.charAt(random.nextInt(ALLOWED_CHARACTERS_ALPHANUMERIC.length())));
                String retMe= sb.toString().toUpperCase();
                return retMe;
            }
            else if (Type.equals("A"))
            {
                sb.append(ALLOWED_CHARACTERS_ALPHA.charAt(random.nextInt(ALLOWED_CHARACTERS_ALPHA.length())));
            }
            else if (Type.equals("N"))
            {
                sb.append(ALLOWED_CHARACTERS_NUMERIC.charAt(random.nextInt(ALLOWED_CHARACTERS_NUMERIC.length())));

            }
            else if (Type.equals("H"))
            {
                sb.append(ALLOWED_CHARACTERS_HEX.charAt(random.nextInt(ALLOWED_CHARACTERS_HEX.length())));
            }
        return sb.toString();
    }

}
