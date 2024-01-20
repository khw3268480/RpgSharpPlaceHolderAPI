package org.swlab.rpgsharpplaceholderapi;

import com.binggre.rpgsharpmining.objects.PlayerMiner;
import com.hj.rpgsharp.rpg.apis.rpgsharp.RPGPlayerAPI;
import com.hj.rpgsharp.rpg.apis.rpgsharp.RPGSharpAPI;
import com.hj.rpgsharp.rpg.objects.RPGPlayer;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public final class RPGSharpPlaceHolderAPI extends PlaceholderExpansion {

    @Override
    public @NotNull String getIdentifier() {
        return "RPGSharp";
    }

    @Override
    public @NotNull String getAuthor() {
        return "dople_L";
    }

    @Override
    public @NotNull String getVersion() {
        return "1.0.0";
    }
    @Override
    public String getRequiredPlugin() {
        return "RpgSharp";
    }

    public String onPlaceholderRequest(final Player player, @NotNull final String identifier){
        if ( player == null){
            return "";
        }
            final String string = identifier.split("_")[0];

            final RPGPlayer rpgplayer = RPGSharpAPI.getRPGPlayerAPI().getRPGPlayer(player);
            if (rpgplayer == null){
                return "Loading..";
            }
            if (Objects.equals(string, "ExpPercentage")){
                return String.format("%.3f",rpgplayer.getExp()/rpgplayer.getMaxExp()*100);
            }
            if (Objects.equals(string, "Level")){
                return String.valueOf(rpgplayer.getLevel());
            }
            if (Objects.equals(string, "Job")){
                return rpgplayer.getJob(true);
            }
            if (Objects.equals(string, "Health")){
                return String.valueOf((int) player.getHealth());
            }
            if (Objects.equals(string, "MaxHealth")){
                return String.valueOf((int) player.getMaxHealth());
            }
            if (Objects.equals(string, "Title")){
                if ( (rpgplayer.getRPGTitle()) == null){
                    return "없음";
                }
                else{
                    return rpgplayer.getRPGTitle().getTitle(true);
                }
            }
            if (Objects.equals(string, "Guild")){
                if ( rpgplayer.getGuild() == null){
                    return "없음";
                }
                else{
                    return String.valueOf(rpgplayer.getGuild().getName());
                }
            }
        if (Objects.equals(string, "Mining")){
            if ( PlayerMiner.get(player).getCooldowns().get(Material.IRON_ORE) == null){
                return "§a채광 가능";
            }
            if ( PlayerMiner.get(player).getCooldowns().get(Material.IRON_ORE).getCooldown() == 1){
                return "§a채광 가능";
            }
            else{
                return (PlayerMiner.get(player).getCooldowns().get(Material.IRON_ORE).getCooldown() + "초");
            }
        }
        if (Objects.equals(string, "MiningExp")){
            return (String.format("%.3f", PlayerMiner.get(player).getExp()/PlayerMiner.get(player).getMaxExp()*100) +"%");
        }
        if (Objects.equals(string, "MiningLevel")){
            return String.valueOf(PlayerMiner.get(player).getLevel());
        }
            return "no data";

    }
}
