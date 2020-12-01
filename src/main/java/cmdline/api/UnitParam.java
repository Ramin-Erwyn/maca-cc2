package cmdline.api;

import cmdline.impl.common.SizeUnit;
import cmdline.impl.common.TypesUnit;

/**
 * Definition for unit parameter specification.
 */
public interface UnitParam {
    SizeUnit getSizeUnit();
    TypesUnit getTypesUnit();
}
