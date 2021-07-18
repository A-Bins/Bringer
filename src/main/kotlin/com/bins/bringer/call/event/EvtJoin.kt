package com.bins.bringer.call.event

import com.bins.bringer.Bringer
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent

class EvtJoin: Listener {
    @EventHandler
    fun event(e: PlayerJoinEvent) {
        if(Bringer.enable) {
            Bringer.url?.apply A@{
                Bringer.hash?.apply B@{
                    (e.player as CraftPlayer).getHandle().sendResourcePack(this@A, this@B)
                }
            }
        }
    }
}