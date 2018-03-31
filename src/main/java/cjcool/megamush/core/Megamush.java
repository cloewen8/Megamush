package cjcool.megamush.core;

import org.apache.logging.log4j.Logger;

import cjcool.megamush.block.Blocks;
import cjcool.megamush.config.ConfigEventsHandler;
import cjcool.megamush.config.ConfigValues;
import cjcool.megamush.item.Items;
import cjcool.megamush.proxies.CommonProxy;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;


@Mod(modid = ConfigValues.ID, name = ConfigValues.NAME, version = ConfigValues.VERSION)
public class Megamush {
	@Instance(value = ConfigValues.ID)
	public static Megamush INSTANCE;

	@SidedProxy(clientSide = "cjcool.megamush.proxies.ClientProxy", serverSide = "cjcool.megamush.proxies.CommonProxy")
	public static CommonProxy proxy;
	
	public static Logger LOGGER;
	public static Configuration CONFIGURATIONS;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		LOGGER = event.getModLog();

		CONFIGURATIONS = new Configuration(event.getSuggestedConfigurationFile());
		ConfigValues.init(CONFIGURATIONS);

		Items.registerItems();
		Blocks.registerBlocks();
		Items.registerBlockItems();
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(new ConfigEventsHandler());
		
		if (event.getSide() == Side.CLIENT) {
			Items.registerItemModels();
			Items.registerBlockItemModels();
		}
	}
}
