package YRS.Minecraft.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import net.minecraft.server.MinecraftServer;
import net.minecraft.world.WorldServer;
import net.minecraft.world.storage.WorldInfo;

public class InputOutput
{
	static Charset charset = Charset.forName("US-ASCII");
	static Path file = Paths.get("../src/minecraft/YRS/Minecraft/io/Birmingham_Weather.txt", new String[0]);

	// Reads Birmingham_Weather and changes the weather
	public static void getWeather() {
		try (BufferedReader reader = new BufferedReader( new FileReader( "../src/minecraft/YRS/Minecraft/io/Birmingham_Weather.txt")  ))
		{
			String line = null;
			while ((line = reader.readLine()) != null) {
					if(line.contains("description"))
					{
						
						String[] stringArray = line.split(", ");
						
						for(String s : stringArray)
						{
							if(s.contains("Visibility"))
							{
								WorldServer worldserver = MinecraftServer.getServer().worldServers[0];
					            WorldInfo worldinfo = worldserver.getWorldInfo();
								
								if(s.contains("Excelent") || s.contains("Very Good"))
								{
									worldinfo.setRaining(false);
									worldinfo.setThundering(false);
									
									System.out.println("Changing to clear");
								} else if(s.contains("Good") || s.contains("Moderate"))
								{
									worldinfo.setRaining(true);
									worldinfo.setThundering(false);
									System.out.println("Changing to rain");
								} else if(s.contains("Poor"))
								{
									worldinfo.setRaining(true);
									worldinfo.setThundering(true);
									System.out.println("Changing to Thunder");
								}
							}
						}
					}
			}
		}
		catch (IOException x)
		{
			System.err.format("IOException : %s%n", x);
		}

	}

	//Takes Data from BBC and puts it in Birmingham_Weather
	public static void streamFromBBC()
	{
		try {
			String urlString = "http://open.live.bbc.co.uk/weather/feeds/en/2655603/observations.rss";
			URL localURL = new URL(urlString);
			URLConnection conn = localURL.openConnection();
			InputStream is = conn.getInputStream();
			
			@SuppressWarnings("resource")
			java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
			String data = s.hasNext() ? s.next() : "";
			
			try (BufferedWriter writer = new BufferedWriter(new FileWriter("../src/minecraft/YRS/Minecraft/io/ Birmingham_Weather.txt")))
			{
				
				writer.write(data, 0, data.length());
				
			} catch (IOException e) {
				System.err.format("MalformedURLException %s%n", e);
			}
			
		} catch (IOException e) {
			System.err.format("MalformedURLException %s%n", e);
		}
	}
}