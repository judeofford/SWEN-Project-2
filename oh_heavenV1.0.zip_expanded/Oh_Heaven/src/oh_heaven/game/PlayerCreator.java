package oh_heaven.game;

public class PlayerCreator {
	public static BasePlayer createPlayer(String type) {
		if (type.equals("human")) {
			return new HumanPlayer();
		}
		else if (type.equals("legal")) {
			return new LegalPlayer();
		}
		else if (type.equals("smart")) {
			return new SmartPlayer();
		}
		else if (type.equals("random")) {
			return new RandomPlayer();
		}
		else {
			return null;
		}
	}
}