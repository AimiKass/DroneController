package otherFunctions;

import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.Set;

public class ProcessKeyInput
{
	private static final int MOTOR_STEP = 10;
	
	private static final int PITCH_FORWARD_KEY = KeyEvent.VK_W;
	private static final int PITCH_BACKWARD_KEY = KeyEvent.VK_S;
	private static final int ROLL_LEFT_KEY = KeyEvent.VK_A;
	private static final int ROLL_RIGHT_KEY = KeyEvent.VK_D;
	private static final int YAW_LEFT_KEY = KeyEvent.VK_Q;
	private static final int YAW_RIGHT_KEY = KeyEvent.VK_E;
	private static final int THROTTLE_UP_KEY = KeyEvent.VK_P;
	private static final int THROTTLE_DOWN_KEY = KeyEvent.VK_L;
	private static final int ARM_KEY = KeyEvent.VK_SPACE;
	private static final int DISARM_KEY = KeyEvent.VK_CONTROL;

	
	private int roll = 11500;
	private int pitch = 21500;
	private int yaw = 41500;
	private int throttle = 31000;
	private int arm = 51000;
	
	
	public Set<Integer> values(Set<Integer> keys)
	{
		Set<Integer> returnValues = new HashSet<>();
		
		
		if (!keys.contains(KeyEvent.VK_SHIFT)) //If shift is pressed values stay constant
		{
			if (keys.contains(PITCH_FORWARD_KEY)) //PITCH FORWARD
			{
				if (pitch < 22000)
					pitch += MOTOR_STEP;
			}
			if (keys.contains(PITCH_BACKWARD_KEY)) //PITCH BACKWARD
			{
				if (pitch > 21000)
					pitch -= MOTOR_STEP;
			}
			if (keys.contains(ROLL_LEFT_KEY)) //ROLL LEFT
			{
				if (roll > 11000)
					roll -= MOTOR_STEP;
			}
			if (keys.contains(ROLL_RIGHT_KEY)) //ROLL RIGHT
			{
				if (roll < 12000)
					roll += MOTOR_STEP;
			}
			if (keys.contains(YAW_LEFT_KEY)) //YAW LEFT
			{
				if (yaw > 41000)
					yaw -= MOTOR_STEP;
			}
			if (keys.contains(YAW_RIGHT_KEY)) //YAW RIGHT
			{
				if (yaw < 42000)
					yaw += MOTOR_STEP;
			}
			if (keys.contains(THROTTLE_UP_KEY)) //THROTTLE UP
			{
				if (throttle < 32000)
					throttle += MOTOR_STEP;
			}
			if (keys.contains(THROTTLE_DOWN_KEY)) //THROTTLE DOWN
			{
				if (throttle > 31000)
					throttle -= MOTOR_STEP;
			}
			if (keys.contains(ARM_KEY)) //Space disarms the drone and sets the minimum throttle
			{
				arm = 51000;
				throttle = 31000;
			}
			if (keys.contains(DISARM_KEY)) // Control arms the drone
			{
				arm = 52000;
			}
		}
		
		boolean stopPitch = !keys.contains(PITCH_FORWARD_KEY) && !keys.contains(PITCH_BACKWARD_KEY);
		boolean stopRoll = !keys.contains(ROLL_RIGHT_KEY) && !keys.contains(ROLL_LEFT_KEY);
		boolean stopYaw = !keys.contains(YAW_RIGHT_KEY) && !keys.contains(YAW_LEFT_KEY);
		
		
		if (stopRoll)
			roll = 11500;
		if (stopPitch)
			pitch = 21500;
		if (stopYaw)
			yaw = 41500;
		
		
		returnValues.add(roll);
		returnValues.add(pitch);
		returnValues.add(yaw);
		returnValues.add(throttle);
		returnValues.add(arm);
		
		
		return returnValues;
	}
	
}
