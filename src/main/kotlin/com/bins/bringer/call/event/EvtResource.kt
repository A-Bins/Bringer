package com.bins.bringer.call.event

import net.kyori.adventure.text.Component.space
import net.kyori.adventure.text.Component.text
import net.kyori.adventure.text.format.NamedTextColor
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerResourcePackStatusEvent

class EvtResource: Listener {
    @EventHandler
    fun event(e: PlayerResourcePackStatusEvent) {
        if(e.status == PlayerResourcePackStatusEvent.Status.ACCEPTED && e.status == PlayerResourcePackStatusEvent.Status.SUCCESSFULLY_LOADED) return
        e.player.kick(
            text()
                .content("§c§l[ ! ] §7리소스팩 미적용 확인됨")
                .append(space())
                .append(text().content("§f멀티플레이 서버 목록 -> 서버 수정 -> 서버 리소스 팩: 사용 으로 설정 후 재접속 바랍니다."))
                .append(space())
                .append(text().content("§c만약, 리소스 팩이 따로 적용되지 않을 경우 디스코드: DDang#6786으로 연락주시길 바랍니다.")).build()
        )
    }
}