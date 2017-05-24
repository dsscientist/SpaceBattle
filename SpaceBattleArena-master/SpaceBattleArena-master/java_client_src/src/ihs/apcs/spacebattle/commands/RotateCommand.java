package ihs.apcs.spacebattle.commands;

/**
 * A command to cause a ship to rotate.  Positive rotations are 
 *   counter-clockwise; negative rotations are clockwise
 * @author Brett Wortzman
 *
 * @since 0.1
 * @version 0.1
 */
public class RotateCommand extends ShipCommand {
	@SuppressWarnings("unused")
	private int DEG;
	
	/**
	 * Creates a command to rotate a ship.  
	 * @param degrees the number of degrees to rotate
	 */
	public RotateCommand(int degrees) {
		DEG = degrees;
	}

	/* (non-Javadoc)
	 * @see ihs.apcs.spacebattle.commands.ShipCommand#getName()
	 */
	@Override
	public String getName() {
		return CommandNames.Rotate.toString();
	}
	
	/**
	 * Gets the energy cost per second of this command.
	 * @return the amount of energy consumed per second while this command is executing (2)
	 */
	public static int getOngoingEnergyCost() { return 2; }
}
