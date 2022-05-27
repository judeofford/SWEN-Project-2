package oh_heaven.game;

// Oh_Heaven.java

import oh_heaven.utility.PropertiesLoader;
import java.util.*;

public class Oh_Heaven{

  public Oh_Heaven(Properties properties){
	  Game game = new Game();
	  game.startGame(properties);
  }

  public static void main(String[] args)
  {
	// System.out.println("Working Directory = " + System.getProperty("user.dir"));
	final Properties properties;
	if (args == null || args.length == 0) {
	  properties = PropertiesLoader.loadPropertiesFile(null);
	} else {
	  properties = PropertiesLoader.loadPropertiesFile(args[0]);
	}
    new Oh_Heaven(properties);
  }
}

