package net.rayfall.eyesniper2.skrayfall.holograms;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class HoloPickupEvent extends Event {

  private static final HandlerList handlers = new HandlerList();
  private Player player;
  private String hologramId;
  private int line;

  @Override
  public HandlerList getHandlers() {
    return handlers;
  }

  public static HandlerList getHandlerList() {
    return handlers;
  }

  /**
   * Called when a player picks up a hologram. 
   * 
   * @param player The player that picked up the hologram.
   * @param hologramId The ID of the hologram.
   * @param lineNumber The line number of the hologram that was picked up.
   */
  public HoloPickupEvent(Player player, String hologramId, int lineNumber) {
    this.player = player;
    this.hologramId = hologramId;
    this.line = lineNumber;
  }

  public Player getPlayer() {
    return this.player;
  }

  public String getHoloId() {
    return this.hologramId;
  }

  public int getLineNumber() {
    return this.line;
  }

}
