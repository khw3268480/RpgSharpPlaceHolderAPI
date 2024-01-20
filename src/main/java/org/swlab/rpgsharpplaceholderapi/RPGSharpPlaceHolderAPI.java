package org.swlab.rpgsharpplaceholderapi;

import com.hj.rpgsharp.rpg.apis.rpgsharp.RPGSharpAPI;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public final class RPGSharpPlaceHolderAPI extends PlaceholderExpansion {


    @Override
    public boolean canRegister() {
        RPGSharpAPI rpgsharp = (RPGSharpAPI) Bukkit.getPluginManager().getPlugin(getRequiredPlugin());
        return rpgsharp != null;
    }
    @Override
    public @NotNull String getIdentifier() {
        return "rpgsharpextension";
    }

    @Override
    public @NotNull String getAuthor() {
        return "dople_L";
    }

    @Override
    public @NotNull String getVersion() {
        return "1.0.0";
    }

    public String onPlaceholderRequest(final Player player, @NotNull final String identifier){
        if ( player == null){
            return "";
        }
        if ( identifier.startsWith("RPGSharp_")){
            final String string = identifier.split("_")[1];
            
            if (Objects.equals(string, "Exp")){
                return String.valueOf(RPGSharpAPI.getRPGPlayerAPI().getRPGPlayer(player).getExp());
            }
        }
            else {
            return "no data";
        
        }
        return "not in select mem";
    }
}
