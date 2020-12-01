package cmdline.impl.common;

import cmdline.api.UnitParam;
import com.beust.jcommander.Parameter;

/**
 * Defines a single option for unit in which to display sizes.
 */
public final class UnitParamImpl implements UnitParam {
    @Parameter(names = {"-u", "--unit"}, description = "unit in which to display the size",
            converter = SizeUnitValidator.class,  validateWith = SizeUnitValidator.class)
    private SizeUnit sizeUnit = SizeUnit.BYTES;
    private TypesUnit typesUnit = TypesUnit.BYTES;

    @Override
    public SizeUnit getSizeUnit() {
        return sizeUnit;
    }

    @Override
    public TypesUnit getTypesUnit() { return typesUnit;
    }
}
