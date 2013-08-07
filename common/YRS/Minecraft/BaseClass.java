package YRS.Minecraft;

import YRS.Minecraft.block.BlockWeather;
import YRS.Minecraft.io.InputOutput;
import YRS.Minecraft.proxy.CommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

@Mod(modid="YRS_2013", name="Young Rewired State 2013 mod", version="0.0.1")
@NetworkMod(clientSideRequired=true, serverSideRequired=false)
public class BaseClass
{

	@Mod.Instance("BaseClass")
	public static BaseClass instance;

	@SidedProxy(clientSide="YRS.Minecraft.proxy.ClientProxy", serverSide="YRS.Minecraft.proxy.CommonProxy")
	public static CommonProxy proxy;
	public static final BlockWeather weather = new BlockWeather(499, Material.redstoneLight);

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		GameRegistry.registerBlock(weather, "weather");

		LanguageRegistry.addName(weather, "Weather Control");
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event)
	{
		proxy.registerRenderers();
		
		GameRegistry.addShapedRecipe(new ItemStack(weather), "xxx", "xyx", "xxx", 'x', new ItemStack(Item.ingotIron), 'y', new ItemStack(Item.pocketSundial));
		
		InputOutput.streamFromBBC();
	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
	}
}