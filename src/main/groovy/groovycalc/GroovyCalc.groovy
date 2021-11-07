package groovycalc

import groovy.transform.CompileStatic
import groovycalc.commands.GroovyCalcCommand
import net.minecraftforge.client.ClientCommandHandler
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.event.FMLInitializationEvent

@CompileStatic
@Mod(name = "GroovyCalc", version = "1.0.1", modid = "groovycalc")
class GroovyCalc {

    @Mod.EventHandler
    static void onInit(FMLInitializationEvent event) {
        ClientCommandHandler.instance.registerCommand(new GroovyCalcCommand());
    }
}