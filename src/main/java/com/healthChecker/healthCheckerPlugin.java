package com.healthChecker;

import com.google.inject.Provides;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.events.GameStateChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.game.NPCManager;
import net.runelite.api.events.HitsplatApplied;
import net.runelite.api.NPC;
import net.runelite.api.Player;

@Slf4j
@PluginDescriptor(
	name = "Health Checker"
)
public class healthCheckerPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private healthCheckerConfig config;

	@Inject
	private NPCManager npcManager;

	@Inject
	private Player player;

	private NPC currentNpc;

	public healthCheckerPlugin() {
	}

	@Override
	protected void startUp() throws Exception
	{
		log.info("healthChecker started!");
	}

	@Override
	protected void shutDown() throws Exception
	{
		log.info("healthChecker stopped!");
	}

	@Subscribe
	public void onHitsplatApplied(HitsplatApplied event)
	{
		if(event.getActor() == null) return;
		if(event.getActor().getName() != this.client.getLocalPlayer().getName()) {
			this.currentNpc = (NPC)(event.getActor().getInfo(this.currentNpc.getId()));
		}

		if(event.getActor().getName() == this.client.getLocalPlayer().getName()) {
			final Player localPlayer = client.getLocalPlayer();



			log.info(localPlayer.getHealth());

			if(localPlayer.getHealthRatio()) {

			}

			//check npcs max hit
			final npcMaxHit = this.currentNpc.g

			//check players current health and add the margin

			//display the warning/red if it is under
		}


	}

	@Provides
	public healthCheckerConfig getConfig(ConfigManager configManager)
	{
		return configManager.getConfig(healthCheckerConfig.class);
	}
}
