package com.legacy.server.plugins.npcs.hemenster;

import static com.legacy.server.plugins.Functions.*;

import com.legacy.server.model.container.Item;
import com.legacy.server.model.entity.npc.Npc;
import com.legacy.server.model.entity.player.Player;
import com.legacy.server.plugins.listeners.action.TalkToNpcListener;
import com.legacy.server.plugins.listeners.executive.TalkToNpcExecutiveListener;

public class MasterFisher implements TalkToNpcListener, TalkToNpcExecutiveListener {

	@Override
	public boolean blockTalkToNpc(Player p, Npc n) {
		return n.getID() == 368;
	}

	@Override
	public void onTalkToNpc(Player p, Npc n) {		
			if(p.isIronMan(1) || p.isIronMan(2) || p.isIronMan(3)) {
				p.message("You are an Iron Man. You stand alone.");
				return;
			}
			if (!p.canUsePool()) {
				p.message("You have just died, you must wait for "+ p.secondsUntillPool()+ " seconds before you refill for food");
				return;
			}
			npcTalk(p, n, "Hei, ukko! Maistusko miekkakala?");
			int menu = showMenu(p, n, "No laitas pari tulemaan!", "Alkaa olla kupu ravittu...");
			if(menu == 0) {
				while(!p.getInventory().full()) {
					p.getInventory().add(new Item(370, 1));
				}
				p.message("Nonih... reppu taynna miekkakalaa!");
			} else if(menu == 1) {
				npcTalk(p, n, "joku toinen kerta sitte...", 
						"you can visit our facilities at fishing guild located in Kandarin perhaps");
			
		}
	}
}
