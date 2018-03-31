package cjcool.megamush.item;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemModelMesher;

public class Items {
	public static void registerItems() {
		
	}
	
	public static void registerBlockItems() {
		
	}
	
	public static void registerItemModels() {
		@SuppressWarnings("unused")
		ItemModelMesher modelMesher = Minecraft.getMinecraft().getRenderItem().getItemModelMesher();
		
	}
	
	public static void registerBlockItemModels() {
		@SuppressWarnings("unused")
		ItemModelMesher modelMesher = Minecraft.getMinecraft().getRenderItem().getItemModelMesher();
	}
}
