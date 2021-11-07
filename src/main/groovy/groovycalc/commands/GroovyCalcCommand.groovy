package groovycalc.commands

import groovy.transform.CompileStatic
import net.minecraft.command.CommandBase
import net.minecraft.command.CommandException
import net.minecraft.command.ICommandSender
import net.minecraft.util.ChatComponentText

import javax.script.ScriptEngine
import javax.script.ScriptEngineManager

@CompileStatic
class GroovyCalcCommand extends CommandBase {
    private static final ScriptEngine engine = (new ScriptEngineManager()).getEngineByName("JavaScript")

    @Override
    String getCommandName() {
        return "groovycalc"
    }

    @Override
    String getCommandUsage(ICommandSender sender) {
        return "idk use it properly lol"
    }

    @Override
    int getRequiredPermissionLevel() {
        return 0
    }

    @Override
    void processCommand(ICommandSender sender, String[] args) throws CommandException {
        if (args.length < 1) {
            sender.addChatMessage(new ChatComponentText("Please give me something to calculate!"))
        }
        try {
            sender.addChatMessage(new ChatComponentText("${args[0]} evaluates to ${engine.eval(args[0])}"))
        } catch (javax.script.ScriptException ae) {
            sender.addChatMessage(new ChatComponentText("Uh oh! Something Broke!"))
            ae.printStackTrace()
        }
    }
}