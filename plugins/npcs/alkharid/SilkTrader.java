package com.legacy.server.plugins.npcs.alkharid;

import static com.legacy.server.plugins.Functions.addItem;
import static com.legacy.server.plugins.Functions.npcTalk;
import static com.legacy.server.plugins.Functions.playerTalk;
import static com.legacy.server.plugins.Functions.showMenu;

import com.legacy.server.model.entity.npc.Npc;
import com.legacy.server.model.entity.player.Player;
import com.legacy.server.plugins.listeners.action.TalkToNpcListener;
import com.legacy.server.plugins.listeners.executive.TalkToNpcExecutiveListener;

public class SilkTrader implements TalkToNpcListener,
		TalkToNpcExecutiveListener {

	@Override
	public boolean blockTalkToNpc(Player p, Npc n) {
		return n.getID() == 2;
	}

	@Override
	public void onTalkToNpc(Player p, Npc n) {
		npcTalk(p, n, "Oi, move away human!");
		int option = showMenu(p, n, "I'm learning attack techniques!",
				"I want to be strong like you!", "Teach me how to defend myself?");
		if (option == 0) {
			npcTalk(p, n, "Ayy Mate!");
			p.incExp(0, 4, true);
		}
		if (option == 1) {
			npcTalk(p, n, "Like a boss!");
			p.incExp(2, 4, true);
		}
		if (option == 2) {
			p.incExp(1, 4, true);
			npcTalk(p, n, "Oi, defnoob!");
		}
			
		
	}
}
