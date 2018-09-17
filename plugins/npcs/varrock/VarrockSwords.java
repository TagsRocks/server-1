package com.legacy.server.plugins.npcs.varrock;

import static com.legacy.server.plugins.Functions.npcTalk;
import static com.legacy.server.plugins.Functions.showMenu;

import com.legacy.server.model.Shop;
import com.legacy.server.model.container.Item;
import com.legacy.server.model.entity.npc.Npc;
import com.legacy.server.model.entity.player.Player;
import com.legacy.server.net.rsc.ActionSender;
import com.legacy.server.plugins.ShopInterface;
import com.legacy.server.plugins.listeners.action.TalkToNpcListener;
import com.legacy.server.plugins.listeners.executive.TalkToNpcExecutiveListener;

public final class VarrockSwords implements ShopInterface,
		TalkToNpcExecutiveListener, TalkToNpcListener {

	private final Shop shop = new Shop(false, 30000, 100, 60, 2,
			new Item(6, 10), new Item(7, 10), new Item(8, 10),
            new Item(9, 10), new Item(2, 10), new Item(109, 10),
            new Item(114, 10), new Item(118, 10), new Item(121, 10),
            new Item(129, 10), new Item(230, 10), new Item(431, 10),
            new Item(196, 10), new Item(248, 10), new Item(433, 10),
            new Item(110, 10), new Item(115, 10), new Item(119, 10),
            new Item(122, 10), new Item(130, 10), new Item(111, 10),
            new Item(116, 10), new Item(120, 10), new Item(123, 10),
            new Item(131, 10),  new Item(1278, 5), new Item(744, 5));

	@Override
	public boolean blockTalkToNpc(final Player p, final Npc n) {
		if (n.getID() == 130 || n.getID() == 56) {
			if (p.getX() >= 222 && p.getX() <= 227 && p.getY() >= 439
					&& p.getY() <= 443) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Shop[] getShops() {
		return new Shop[] { shop };
	}

	@Override
	public boolean isMembers() {
		return false;
	}

	@Override
	public void onTalkToNpc(final Player p, final Npc n) {
		if (n.getID() == 130 || n.getID() == 56
				&& p.getLocation().inBounds(222, 439, 227, 443)) {
			npcTalk(p, n, "Welcome to Batman Shop!",
					"Can I interest you in some fine armour?");

			final String[] options = new String[] { "Sure mate!",
					"Oh, noo! Is it a Batman!" };
			int option = showMenu(p,n, options);
			switch (option) {
			case 0:
				p.setAccessingShop(shop);
				ActionSender.showShop(p, shop);
				break;
			case 1:
				npcTalk(p, n, "Come back if you need any");
				break;
			}
		}
	}

}
