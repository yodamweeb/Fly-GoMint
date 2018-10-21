package fly;

import io.gomint.ChatColor;
import io.gomint.command.Command;
import io.gomint.command.CommandOutput;
import io.gomint.command.CommandSender;
import io.gomint.entity.EntityPlayer;

import java.util.Map;

public class FlyCommand extends Command {

    public FlyCommand(MainClass plugin) {
        super("fly");
        description("Toggle flight");
    }

    @Override
    public CommandOutput execute(CommandSender sender, String alias, Map<String, Object> args) {
        if (sender instanceof EntityPlayer) {
            if (sender.hasPermission("fly.allow")) {
                if (((EntityPlayer) sender).getAllowFlight()) {
                    ((EntityPlayer) sender).setFlying(false);
                    ((EntityPlayer) sender).setAllowFlight(false);
                    return new CommandOutput().success(ChatColor.AQUA + "Fly is now disabled!");
                } else {
                    ((EntityPlayer) sender).setAllowFlight(true);
                    return new CommandOutput().success(ChatColor.AQUA + "Fly is now enabled!");
                }
            } else {
                return new CommandOutput().fail("Invalid Permission");
            }
        }
        return new CommandOutput().fail("A console can't. Or can it?");
    }
}
