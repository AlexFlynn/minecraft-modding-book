package org.devoxx4kids.forge.mods;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;

public class FlamingPigs implements ICommand 
{

	//class scope variables
	private List aliases = new ArrayList();
	private int numberOfPigs = 0;
	
	//this is the constructor for the class
	public FlamingPigs()
	{
		aliases.add("flamingpigs");
		aliases.add("fp");
	}
	
	public String getCommandName()
	{
	  return "sample";
	}
	  
	@Override
	public String getCommandUsage(ICommandSender sender) {
		// TODO Auto-generated method stub
		return "/flamingpigs <number of pigs>";
	}
	
	@Override
	public List<String> getCommandAliases() {
		// TODO Auto-generated method stub
		return aliases;
	}
	
	@Override
	public void processCommand(ICommandSender sender, String[] args) throws CommandException {
		// TODO Auto-generated method stub
		if (args.length != 1)
		{
			sendErrorMessage(sender, "Invalid number of arguments!");
			return;
		} // end if

		try
		{
			numberOfPigs = Integer.parseInt(args[0]);
		} 
		catch(NumberFormatException e)
		{
			sendErrorMessage(sender, "The argument \"" + args[0] + "\" is not a valid number!");
			return;
		} // end try/catch
		
		EntityPlayer player = (EntityPlayer) sender;
		
		for (int i = 0; i < numberOfPigs; i++)
		{
			EntityPig pig = new EntityPig(player.worldObj);
			pig.setLocationAndAngles(player.posX, player.posY, player.posZ, 0, 0);
			pig.setFire(10000);
			player.worldObj.spawnEntityInWorld(pig);
		} // End for
				
	}
	
	public boolean canCommandSenderUseCommand(ICommandSender icommandsender)
	{
	  return true;
	}
	
	public List addTabCompletionOptions(ICommandSender icommandsender, String[] astring)
	{
		return null;
	}
	
	public boolean isUsernameIndex(String[] astring, int i)
	{
	  return false;
	}

	@Override
	public int compareTo(ICommand arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public void sendErrorMessage(ICommandSender sender, String message)
	{
		sender.addChatMessage(new ChatComponentText(EnumChatFormatting.DARK_RED + message));
	} // end method
	

	@Override
	public List<String> addTabCompletionOptions(ICommandSender sender, String[] args, BlockPos pos) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
