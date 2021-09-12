package com.healthChecker;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("healthChecker")
public interface healthCheckerConfig extends Config
{
	@ConfigItem(
			position = 1,
			keyName = "defaultHealth",
			name = "Default health",
			description = "If you're not in combat (targeting anything), set a default value to alert you when it is at it or under."
	)
	default int defaultHealth() { return 20; }

	@ConfigItem(
			position = 2,
			keyName = "healthMargin",
			name = "Health margin",
			description = "The margin added onto the max hit of the NPC you're fighting. E.G if the NPCs max hit is 10, and you have this set to 5, you will be warned at 15hp and under."
	)
	default int healthMargin() { return 5; }
}
