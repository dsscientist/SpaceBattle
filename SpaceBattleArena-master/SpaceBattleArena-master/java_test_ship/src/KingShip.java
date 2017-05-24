import java.awt.Color;

import ihs.apcs.spacebattle.*;
import ihs.apcs.spacebattle.commands.*;
import ihs.apcs.spacebattle.games.KingOfTheBubbleGameInfo;

/**
 * Example 'Dummy' Ship for "King of The Bubble" game.
 * 
 * @author Michael A. Hawker
 *
 */
public class KingShip implements Spaceship<KingOfTheBubbleGameInfo> {

	public static void main(String[] args) {
		ihs.apcs.spacebattle.TextClient.main(new String[] {"127.0.0.1", "KingShip"});		
	}

	@Override
	public RegistrationData registerShip(int numImages, int worldWidth,
			int worldHeight) {
		return new RegistrationData("King Ship", new Color(0, 0, 255), 1);		
	}

	@Override
	public ShipCommand getNextCommand(Environment<KingOfTheBubbleGameInfo> env) {
		System.out.println("Score: " + env.getGameInfo().getScore() + " there are " + env.getGameInfo().getBubblePositions().size() + " bubbles in the world.");
		if (env.getShipStatus().getEnergy() > WarpCommand.getInitialEnergyCost() * 2)
		{
			return new WarpCommand();
		}
		
		return new IdleCommand(1);
	}

	@Override
	public void shipDestroyed(String lastDestroyedBy) {
		// TODO Auto-generated method stub
		
	}
	
}
