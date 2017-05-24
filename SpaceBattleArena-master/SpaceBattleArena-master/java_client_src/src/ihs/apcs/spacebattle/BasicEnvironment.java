package ihs.apcs.spacebattle;

/**
 * Basic Environment to introduce to Space Battle, see {@link Environment} for more info.
 * 
 * @author Michael A. Hawker
 *
 * @since 1.0
 * @version 1.0
 */
public class BasicEnvironment extends Environment<BasicGameInfo> {
	
	public BasicEnvironment(Environment<BasicGameInfo> env) {
		MESSAGES = env.getMessages();
		RADARLEVEL = env.getRadarLevel();
		RADARDATA = env.getRadar();
		SHIPDATA = env.getShipStatus();
		GAMEDATA = env.getGameInfo();
	}
	
}
