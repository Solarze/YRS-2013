package YRS.Minecraft.block;

import java.awt.event.KeyEvent;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import YRS.Minecraft.io.InputOutput;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BlockWeather extends Block
{	
	public BlockWeather(int id, Material material)
	{
		super(id, material);

		setCreativeTab(CreativeTabs.tabTools);
		setUnlocalizedName("WeatherBlock");
		setHardness(0.01F);
		
		func_111022_d("yrs:weather_2");
	}

	// When the block is right clicked
	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
	{
		InputOutput.getWeather();
		
		System.out.println("Activating Weather...");

		return false;
	}
}