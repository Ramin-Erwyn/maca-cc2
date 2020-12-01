package cmdline.impl.common;

import com.beust.jcommander.IParameterValidator;
import com.beust.jcommander.IStringConverter;
import com.beust.jcommander.ParameterException;

import java.util.Arrays;

/**
 * Validates the Types unit the user indicates (as a string) in the command line,
 * and converts its into an actual {@link TypesUnit}.
 */
final class TypesUnitValidator implements IStringConverter<TypesUnit>, IParameterValidator {
    @Override
    public void validate(String name, String value) {
        try {
            TypesUnit.valueOf(value);
        } catch (IllegalArgumentException ex) {
            throw new ParameterException("Parameter " + name + " must be one of :  " + Arrays.toString(SizeUnit.values()));
        }
    }

    @Override
    public TypesUnit convert(String value) {
        return TypesUnit.valueOf(value);
    }
}
