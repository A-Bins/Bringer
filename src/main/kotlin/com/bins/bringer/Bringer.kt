package com.bins.bringer

import com.bins.bringer.call.event.EvtJoin
import com.bins.bringer.call.event.EvtResource
import org.bukkit.plugin.java.JavaPlugin

class Bringer : JavaPlugin() {
    private val configs = arrayOf(EvtJoin(), EvtResource())
    override fun onEnable() {
        saveDefaultConfig()
        instance = this
        getCommand("reload-bringer")?.apply {
            setExecutor(com.bins.bringer.call.commands.reloadConfig())
        }
        server.pluginManager.apply { configs.forEach { registerEvents(it, this@Bringer) } }
        // Plugin startup logic
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }

    companion object {
        lateinit var instance: Bringer
        val enable: Boolean
            get() = instance.config.getBoolean("enable")
        val url: String?
            get() = instance.config.getString("url")

    }
}