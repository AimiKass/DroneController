package otherFunctions;

import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.Set;

public class ProcessKeyInput
{
	private static final int MOTOR_STEP = 10;
	
	private int roll = 11500;
	private int pitch = 21500;
	private int yaw = 31500;
	private int throttle = 41500;
	
	
	public Set<Integer> values(Set<Integer> keys)
	{
		Set<Integer> returnValues = new HashSet<>();
		
		
		if (!keys.contains(KeyEvent.VK_SHIFT))
		{
			if (keys.contains(KeyEvent.VK_W)) //PITCH FORWARD
			{
				if (pitch < 22000)
					pitch += MOTOR_STEP;
			}
			if (keys.contains(KeyEvent.VK_S)) //PITCH BACKWARD
			{
				if (pitch > 21000)
					pitch -= MOTOR_STEP;
			}
			if (keys.contains(KeyEvent.VK_A)) //ROLL LEFT
			{
				if (roll > 11000)
					roll -= MOTOR_STEP;
			}
			if (keys.contains(KeyEvent.VK_D)) //ROLL RIGHT
			{
				if (roll < 12000)
					roll += MOTOR_STEP;
			}
			if (keys.contains(KeyEvent.VK_Q)) //YAW LEFT
			{
				if (yaw > 41000)
					yaw -= MOTOR_STEP;
			}
			if (keys.contains(KeyEvent.VK_E)) //YAW RIGHT
			{
				if (yaw < 42000)
					yaw += MOTOR_STEP;
			}
			if (keys.contains(KeyEvent.VK_UP)) //THROTTLE UP
			{
				if (throttle < 32000)
					throttle += MOTOR_STEP;
			}
			if (keys.contains(KeyEvent.VK_DOWN)) //THROTTLE DOWN
			{
				if (throttle > 31000)
					throttle -= MOTOR_STEP;
			}
		}
		
		boolean stopPitch = !keys.contains(KeyEvent.VK_W) && !keys.contains(KeyEvent.VK_S);
		boolean stopRoll = !keys.contains(KeyEvent.VK_A) && !keys.contains(KeyEvent.VK_D);
		boolean stopYaw = !keys.contains(KeyEvent.VK_Q) && !keys.contains(KeyEvent.VK_E);
		boolean stopThrottle = !keys.contains(KeyEvent.VK_UP) && !keys.contains(KeyEvent.VK_DOWN);
		
		
		if (stopRoll)
			roll = 11500;
		if (stopPitch)
			pitch = 21500;
		if (stopYaw)
			yaw = 31500;
		if (stopThrottle)
			throttle = 41500;
		
		
		returnValues.add(roll);
		returnValues.add(pitch);
		returnValues.add(yaw);
		returnValues.add(throttle);
		
		
		return returnValues;
	}
	
}
