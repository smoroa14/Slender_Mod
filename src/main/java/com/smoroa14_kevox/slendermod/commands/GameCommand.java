package com.smoroa14_kevox.slendermod.commands;

import com.smoroa14_kevox.slendermod.SlenderMod;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentBase;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class GameCommand implements ICommand{

    private final List aliases;

    public GameCommand() {
        aliases = new ArrayList();
        aliases.add("game");
    }

    @Override
    public String getName() {
        return "game";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "game <start|stop>";
    }

    @Override
    public List<String> getAliases() {
        return this.aliases;
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        World world = sender.getEntityWorld();

        if (world.isRemote)
        {
            System.out.println("Not processing on Client side");
        }
        else
        {
            System.out.println("Processing on Server side");
            if(args.length == 0)
            {
                sender.sendMessage(new TextComponentBase() {
                    @Override
                    public String getUnformattedComponentText() {
                        return "Keine Argumente angegeben";
                    }

                    @Override
                    public ITextComponent createCopy() {
                        return null;
                    }
                });
                return;
            }

            sender.sendMessage(new TextComponentBase(){
                @Override
                public String getUnformattedComponentText() {
                    return "Slender: " + args[0];
                }

                @Override
                public ITextComponent createCopy() {
                    return null;
                }
            });

            String operation = args[0]
            /*if (EntityList.stringToClassMapping.containsKey(fullEntityName))
            {
                conjuredEntity = EntityList.createEntityByName(fullEntityName, world);
                conjuredEntity.setPosition(sender.getPlayerCoordinates().posX,
                        sender.getPlayerCoordinates().posY,
                        sender.getPlayerCoordinates().posZ);
                world.spawnEntityInWorld(conjuredEntity);
            }
            else
            {
                sender.addChatMessage(new ChatComponentText("Entity not found"));
            }*/
        }
    }

    @Override
    public boolean checkPermission(MinecraftServer server, ICommandSender sender) {
        return false;
    }

    @Override
    public List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args, @Nullable BlockPos targetPos) {
        return null;
    }

    @Override
    public boolean isUsernameIndex(String[] args, int index) {
        return false;
    }

    @Override
    public int compareTo(ICommand o) {
        return 0;
    }
}
