package otherFunctions;

import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.Set;

public class ProcessKeyInput
{
	private static final int MOTOR_STEP = 10;
	
	private int L_R = 11500;
	private int F_B = 21500;
	
	private Set<Integer> returnValues ;
	
	
	
	public Set<Integer> values(Set<Integer> keys)
	{
		
		returnValues = new HashSet<>();
		
		if (!keys.contains(KeyEvent.VK_SHIFT))
		{
			// TODO: 2/5/2021  yaw , throttle , roll , pitch
			if (keys.contains(KeyEvent.VK_W)) //FORWARD
			{
				if (F_B <22000)
					F_B += MOTOR_STEP;
			}
			if (keys.contains(KeyEvent.VK_S)) //BACKWARD
			{
				if (F_B >21000)
					F_B -= MOTOR_STEP;
			}
			if (keys.contains(KeyEvent.VK_A)) //LEFT
			{
				if (L_R >11000)
					L_R -= MOTOR_STEP;
			}
			if (keys.contains(KeyEvent.VK_D)) //RIGHT
			{
				if (L_R <12000)
					L_R += MOTOR_STEP;
			}
		}
		
		
		boolean stopLR = !keys.contains(KeyEvent.VK_A) && !keys.contains(KeyEvent.VK_D);
		
		boolean stopFB = !keys.contains(KeyEvent.VK_W) && !keys.contains(KeyEvent.VK_S);
		
		
		if (stopLR)
		{
			L_R = 11500;
		}
		if (stopFB)
		{
			F_B = 21500;
		}
		
		returnValues.add(L_R);
		returnValues.add(F_B);
		
		
		return returnValues;
	}
	
}
