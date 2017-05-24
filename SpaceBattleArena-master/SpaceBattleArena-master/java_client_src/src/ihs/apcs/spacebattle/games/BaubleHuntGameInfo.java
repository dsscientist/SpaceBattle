package ihs.apcs.spacebattle.games;

import ihs.apcs.spacebattle.BasicGameInfo;
import ihs.apcs.spacebattle.Point;

import java.util.*;

/**
 * Bauble Hunt is a more complex version of the Hungry Hungry Baubles game.  Baubles only count towards your score once they have been collected and returned to your Home Base.
 * <p>
 * You may store 5 Baubles on your ship at most.
 * <p>
 * Blue Bauble are worth 1 point.<p>
 * Golden Baubles are worth 3 points.<p>
 * Red Baubles are worth 5 points.
 * <p>
 * If your ship is destroyed, the Baubles it was carrying will be dropped.
 * 
 * @author Brett Wortzman
 *
 * @since 0.9
 * @version 1.2
 */
public class BaubleHuntGameInfo extends BasicGameInfo {
	private double[][] BAUBLES;
	private int COLLECTED;
	private int STORED;
	private int STOREDVALUE;
	private int WEIGHT;
	
	/**
	 * Gets a list of positions where there are high-value baubles.  Not all
	 *   bauble positions are returned, but each position in the list
	 *   has a bauble (unless it has been collected already).
	 * @return a list of bauble positions
	 */
	public List<Point> getBaublePositions() {
		List<Point> result = new ArrayList<Point>();
		for (double[] pos : BAUBLES) {
			result.add(new Point(pos));
		}
		return result;
	}
	
	/**
	 * Gets the number of baubles collected and returned to your base.
	 * @return the number of baubles return to base
	 */
	public int getNumCollected() { return COLLECTED; }
	
	/**
	 * Gets the number of baubles currently carried by your ship (maximum of 5).
	 * @return the number of baubles carried by your ship
	 */
	public int getNumBaublesCarried() { return STORED; }
	
	/**
	 * Gets the value of the baubles being carried by your ship (maximum of 25). 
	 * @return the value of the baubles carried by your ship
	 */
	public int getBaublesCarriedValue() { return STOREDVALUE; }
	
	/**
	 * Gets the total weight of the baubles being carried by your ship.
	 * @return weight of baubles carried
	 */
	public int getBaublesCarriedWeight() { return WEIGHT; }
	
	@Override
	public String toString() {
		return String.format("{Target: %s; Score: %f; Deaths: %d; High Score: %f}", getObjectiveLocation(), getScore(), getNumDeaths(), getHighScore());
	}
}
