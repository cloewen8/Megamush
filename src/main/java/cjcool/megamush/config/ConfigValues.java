package cjcool.megamush.config;

import net.minecraftforge.common.config.Configuration;

public class ConfigValues {
	public static final String VERSION = "1.12.2";
	public static final String ID = "megamush";
	public static final String NAME = "MegaMush";

	public static Configuration CONFIGURATIONS;

	public static void init(Configuration config) {
		ConfigValues.CONFIGURATIONS = config;
		
		config.load();
		load();
	}

	public static void load() {
		if (CONFIGURATIONS.hasChanged())
			CONFIGURATIONS.save();
	}
}
