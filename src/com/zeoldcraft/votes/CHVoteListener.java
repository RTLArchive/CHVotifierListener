package com.zeoldcraft.votes;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

import com.laytonsmith.annotations.shutdown;
import com.laytonsmith.annotations.startup;
import com.laytonsmith.commandhelper.CommandHelperPlugin;
import com.laytonsmith.core.events.Driver;
import com.laytonsmith.core.events.EventUtils;
import com.vexsoftware.votifier.model.VotifierEvent;

public class CHVoteListener implements Listener {

	static final CHVoteListener vl = new CHVoteListener();
	
	@startup
	public static void register() {
		CommandHelperPlugin.self.registerEvent(vl);
	}
	
	@shutdown
	public static void unregister() {
		VotifierEvent.getHandlerList().unregister(vl);
	}
	
	@EventHandler(priority=EventPriority.LOWEST)
	public void onVoteReceived(VotifierEvent event) {
		EventUtils.TriggerListener(Driver.EXTENSION, "vote_received", new CHVoteEvent(event));
	}
}
