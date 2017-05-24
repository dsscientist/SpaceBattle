package ihs.apcs.spacebattle;

import ihs.apcs.spacebattle.commands.ShipCommand;

/**
 * Basic Spaceship class to abstract Generic for initial introduction.  See {@link Spaceship} for more info.
 * 
 * @author Michael A. Hawker
 *
 * @since 1.0
 * @version 1.0.1
 */
public abstract class BasicSpaceship implements Spaceship<BasicGameInfo> {
	
	/* (non-Javadoc)
	 * @see ihs.apcs.spacebattle.Spaceship#registerShip(int, int, int)
	 */
	@Override
	abstract public RegistrationData registerShip(int numImages, int worldWidth, int worldHeight);

	abstract public ShipCommand getNextCommand(BasicEnvironment env);
	
	/* (non-Javadoc)
	 * @see ihs.apcs.spacebattle.Spaceship#getNextCommand(ihs.apcs.spacebattle.Environment)
	 */
	@Override
	public ShipCommand getNextCommand(Environment<BasicGameInfo> env) {		
		return getNextCommand(new BasicEnvironment(env));
	}

	/* (non-Javadoc)
	 * @see ihs.apcs.spacebattle.Spaceship#shipDestroyed()
	 */
	@Override
	public void shipDestroyed(String lastDestroyedBy) { }	
}
