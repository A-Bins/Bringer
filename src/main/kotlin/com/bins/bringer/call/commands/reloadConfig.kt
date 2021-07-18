package com.bins.bringer.call.commands

import com.bins.bringer.Bringer
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender

class reloadConfig: CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        Bringer.instance.reloadConfig()
        sender.sendMessage("§a성공적으로 리로드했서욘!")
        sender.sendMessage("§7url: ${Bringer.url}")
        sender.sendMessage("§7enable: ${Bringer.enable}")
        return false
    }
}