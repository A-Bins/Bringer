package com.bins.bringer.call.event

import com.bins.bringer.Bringer
import org.bukkit.craftbukkit.v1_17_R1.entity.CraftPlayer
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent

class EvtJoin: Listener {
    @EventHandler
    fun event(e: PlayerJoinEvent) {
        if(Bringer.enable) {
            Bringer.url?.apply A@{
                (e.player as CraftPlayer).setResourcePack(this@A)
            }
        }
    }
}