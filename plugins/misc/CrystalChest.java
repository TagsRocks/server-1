package com.legacy.server.plugins.misc;

import static com.legacy.server.plugins.Functions.message;
import static com.legacy.server.plugins.Functions.showBubble;

import com.legacy.server.model.container.Item;
import com.legacy.server.model.entity.GameObject;
import com.legacy.server.model.entity.player.Player;
import com.legacy.server.plugins.listeners.action.InvUseOnObjectListener;
import com.legacy.server.plugins.listeners.executive.InvUseOnObjectExecutiveListener;
import com.legacy.server.util.rsc.DataConversions;

public class CrystalChest implements InvUseOnObjectListener,
		InvUseOnObjectExecutiveListener {

	@Override
	public boolean blockInvUseOnObject(GameObject obj, Item item, Player player) {
		// TODO Auto-generated method stub
		return item.getID() == 525 && obj.getID() == 248;
	}

	@Override
	public void onInvUseOnObject(GameObject obj, Item item, Player player) {
		showBubble(player, item);
		message(player, "You use the key to unlock the chest...");
		if (player.getInventory().remove(item) > -1) {
			player.getInventory().add(new Item(1749, 1));
			Item[] loot = null;
			int percent = DataConversions.random(0, 100);
			if (percent <= 100) {
				loot = new Item[] { new Item(1442, 1), new Item(10, 20000) };
			}
			if (percent < 85) {
				loot = new Item[] { new Item(1442, 1), new Item(10, 20000) };
			}
			if (percent < 60) {
				loot = new Item[] { new Item(1442, 1), new Item(1963, 1),
						new Item(10, 10000) };
			}
			if (percent < 35) {
				loot = new Item[] { new Item(33, 500) };
			}
			if (percent < 25) {
				loot = new Item[] { new Item(525, 1), new Item(10, 7500) };			
			}
			if (percent < 18) {
				loot = new Item[] { new Item(1643, 20) };
			}
			if (percent < 14) {
				loot = new Item[] { new Item(518, 60) };
			}
			if (percent < 13) {				
					loot = new Item[] { new Item(828, 1) };					
			}
			if (percent < 12) {				
					loot = new Item[] { new Item(831, 1) };					
			}
			if (percent < 11) {
				loot = new Item[] { new Item(832, 1) };				
			}
			if (percent < 10) {
				loot = new Item[] { new Item(971, 1) };				
			}
			if (percent < 4) {
				loot = new Item[] { new Item(2260, 1) };
			}
			if (percent < 3) {
				loot = new Item[] { new Item(2259, 1) };				
			}
			if (percent < 2) {
				loot = new Item[] { new Item(575, 1) };
							
			}
			for (Item i : loot) {
				if (i.getAmount() > 1 && !i.getDef().isStackable()) {
					for (int x = 0; x < i.getAmount(); x++) {
						player.getInventory().add(new Item(i.getID(), 1));
					}
				} else {
					player.getInventory().add(i);
				}
			}
		}
	}

}
