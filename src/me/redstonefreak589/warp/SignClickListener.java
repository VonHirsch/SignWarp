package me.redstonefreak589.warp;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class SignClickListener implements Listener{
	
	public Main plugin;
	
	public SignClickListener(Main instance){
		plugin = instance;
	}
	
	 @EventHandler
	    public void onPlayerInteract(PlayerInteractEvent event)
	    {
	        Player player = event.getPlayer();
	        String playerName = event.getPlayer().getName();
	        
	        if(event.getAction() == Action.RIGHT_CLICK_BLOCK)
	        {
	            if (event.getClickedBlock().getType() == Material.SIGN || event.getClickedBlock().getType() == Material.SIGN_POST || event.getClickedBlock().getType() == Material.WALL_SIGN){
	                Sign sign = (Sign) event.getClickedBlock().getState();
	                String signline1 = sign.getLine(0);
	                String signline2 = sign.getLine(1);
	                String signline3 = sign.getLine(2);
	                String signline4 = sign.getLine(3);
	                String sle = signline2;
	                int level = Integer.parseInt(signline3);
	                int length = Integer.parseInt(signline4);
	                
	                if(signline1.equalsIgnoreCase("[SignEffects]"))
	                {
	           
	                    if(sle.equals("CONFUSION") || sle.equals("BLINDNESS") || sle.equals("DAMAGE_RESISTANCE") || sle.equals("FAST_DIGGING") || sle.equals("FIRE_RESISTANCE") || sle.equals("HARM")
	                        || sle.equals("HEAL") || sle.equals("HUNGER") || sle.equals("INCREASE_DAMAGE") || sle.equals("INVISIBILITY") || sle.equals("JUMP") || sle.equals("NIGHT_VISION") ||
	                        sle.equals("POISON") || sle.equals("REGENERATION") || sle.equals("SLOW") || sle.equals("SLOW_DIGGING") || sle.equals("SPEED") || sle.equals("WATER_BREATHING") ||
	                        sle.equals("WEAKNESS") || sle.equals("WITHER"))
	                    {
	                        if(player.hasPermission(plugin.getConfig().getString("permissions.add")) || player.isOp())
	                        {
	                        		int chatLevel = level + 1;
	                        		player.addPotionEffect(new PotionEffect(PotionEffectType.getByName(signline2), length, level));
	                            	player.sendMessage(ChatColor.AQUA + "[SignEffects] " + ChatColor.LIGHT_PURPLE + "Gave player " + ChatColor.GOLD + playerName + ChatColor.LIGHT_PURPLE + " the " + signline2 + ChatColor.LIGHT_PURPLE + " effect for " + ChatColor.GOLD + length + ChatColor.LIGHT_PURPLE + " tick(s) at level " + ChatColor.GOLD + chatLevel + ChatColor.LIGHT_PURPLE + "!");
	                        }
	                        else
	                        {
	                            player.sendMessage(ChatColor.RED + "You don't have permission!");
	                        }
	                    }
	                    else
	                    {
	                        player.sendMessage(ChatColor.RED + "This potion effect doesn't exist!");
	                    }
	                }
	                else
	                {
	                    return;
	                }
	            }
	        }
	        else
	        {
	            return;
	        }
	    }
}
