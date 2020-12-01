package utils;

import cmdline.impl.common.TypesUnit;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

/**
 * Provides translation of Types into the requested unit, and formatting for display.
 */
public final class TypesFormatter {
    public static final double TO_KB = 1024.0d;
    public static final double TO_MB = Math.pow(TO_KB, 2.0d);
    public static final double TO_GB = Math.pow(TO_KB, 3.0d);

    private TypesFormatter(){}

    public static double translateTypesInUnit(long typesInByte, TypesUnit typesUnit) {
        switch (typesUnit) {
            case KB:
                return typesInByte / TypesFormatter.TO_KB;
            case MB:
                return typesInByte / TypesFormatter.TO_MB;
            case GB:
                return typesInByte / TypesFormatter.TO_GB;
            default:
                return typesInByte;
        }
    }

    public static String formatTypes(double types) {
        DecimalFormat dc = new DecimalFormat("###,###.###", new DecimalFormatSymbols(Locale.ENGLISH));
        return dc.format(types);
    }
}
