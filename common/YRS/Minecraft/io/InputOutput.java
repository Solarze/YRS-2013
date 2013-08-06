package YRS.Minecraft.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import net.minecraft.world.WorldServer;
import net.minecraft.world.storage.WorldInfo;

public class InputOutput
{
  static Charset charset = Charset.forName("US-ASCII");
  static Path file = Paths.get("../src/minecraft/YRS/Minecraft/io/Birmingham_Weather.txt", new String[0]);

  public static void getWeather() {
	try (BufferedReader reader = new BufferedReader( new FileReader( "../src/minecraft/YRS/Minecraft/io/Birmingham_Weather.txt")  ))
	{
		String line = null;
		while ((line = reader.readLine()) != null) {
	        if(line.contains("Visibility"))
	        {
	        	line = line.replace("<description>", " ");
	        	line = line.replace("</description", " ");
	        	line = line.trim();
	        }
	    }
	}
    catch (IOException x)
    {
    	System.err.format("IOException : %s%n", x);
    	}

  }

  public void streamFromBBC()
  {
    String urlString = "http://open.live.bbc.co.uk/weather/feeds/en/2655603/observations.rss";
    try {
      URL localURL = new URL(urlString);
    } catch (MalformedURLException e) {
      System.err.format("MalformedURLException %s%n", e);
    }
  }
}