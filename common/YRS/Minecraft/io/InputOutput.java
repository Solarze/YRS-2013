package YRS.Minecraft.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import net.minecraft.world.WorldServer;
import net.minecraft.world.storage.WorldInfo;

public class InputOutput
{
  static Charset charset = Charset.forName("US-ASCII");
  static Path file = Paths.get("../src/minecraft/YRS/Minecraft/io/Birmingham_Weather.txt", new String[0]);

  public static void getWeather() {
    try {
      Object localObject1 = null; Object localObject4 = null;
      Object localObject3;
      label278: 
      try { reader = new BufferedReader(new FileReader("../src/minecraft/YRS/Minecraft/io/Birmingham_Weather.txt")); }
      finally
      {
        BufferedReader reader;
        String line;
        WorldServer worldserver;
        WorldInfo worldinfo;
        String[] balloon;
        String[] arrayOfString1;
        int j;
        int i;
        String s;
        localObject3 = localThrowable; break label278; if (localObject3 != localThrowable) localObject3.addSuppressed(localThrowable); 
      }
    }
    catch (IOException x) { System.err.format("IOException : %s%n", new Object[] { x }); }

  }

  public void streamFromBBC()
  {
    String urlString = "http://open.live.bbc.co.uk/weather/feeds/en/2655603/observations.rss";
    try {
      URL localURL = new URL(urlString);
    } catch (MalformedURLException e) {
      System.err.format("MalformedURLException %s%n", new Object[] { e });
    }
  }
}