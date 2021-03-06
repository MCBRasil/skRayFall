package net.rayfall.eyesniper2.skrayfall.effectlibsupport;

import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.util.Kleenean;

import de.slikey.effectlib.effect.BigBangEffect;
import de.slikey.effectlib.util.DynamicLocation;

import net.rayfall.eyesniper2.skrayfall.Core;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.event.Event;
import org.eclipse.jdt.annotation.Nullable;

public class EffBigBangEffect extends Effect {

  // (spawn|create|apply) (a|the|an) big bang (effect|formation) (at|on|for) %entity/location% with
  // id %string%

  private Expression<?> target;
  private Expression<String> id;

  @SuppressWarnings("unchecked")
  @Override
  public boolean init(Expression<?>[] exp, int arg1, Kleenean arg2, ParseResult arg3) {
    target = exp[0];
    id = (Expression<String>) exp[1];
    return true;
  }

  @Override
  public String toString(@Nullable Event arg0, boolean arg1) {
    return null;
  }

  // TODO add more options
  @Override
  protected void execute(Event evt) {
    Object tar = target.getSingle(evt);
    BigBangEffect effect = new BigBangEffect(Core.effectManager);
    if (tar instanceof Entity) {
      effect.setDynamicOrigin(new DynamicLocation((Entity) tar));
      effect.infinite();
      effect.start();
      Boolean check = Core.effLibManager.setEffect(effect, id.getSingle(evt).replace("\"", ""));
      if (!check) {
        effect.cancel();
      }
    } else if (tar instanceof Location) {
      effect.setDynamicOrigin(new DynamicLocation((Location) tar));
      effect.infinite();
      effect.start();
      Boolean check = Core.effLibManager.setEffect(effect, id.getSingle(evt).replace("\"", ""));
      if (!check) {
        effect.cancel();
      }
    } else {
      assert false;
    }
  }


}
