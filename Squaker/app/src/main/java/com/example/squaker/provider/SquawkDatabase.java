package com.example.squaker.provider;

import net.simonvt.schematic.annotation.Database;
import net.simonvt.schematic.annotation.Table;

@Database(version = SquawkDatabase.VERSION)
class SquawkDatabase {
    public static final int VERSION = 1;

    @Table(Contract.class)
    public static final String SQUAWK_MESSAGES = "squawk_messages";


}
