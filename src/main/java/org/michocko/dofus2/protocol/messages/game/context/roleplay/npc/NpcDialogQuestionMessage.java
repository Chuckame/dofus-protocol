package org.michocko.dofus2.protocol.messages.game.context.roleplay.npc;

import java.util.Collection;
import java.util.LinkedList;

import org.michocko.dofus2.common.io.INetworkMessage;
import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString 
@EqualsAndHashCode
public class NpcDialogQuestionMessage implements INetworkMessage {
	public static final int MESSAGE_ID = 5617;
	
	private short messageId;
	private Collection<String> dialogParams;
	private Collection<Short> visibleReplies;
	
	public NpcDialogQuestionMessage() {
	}
	
	public NpcDialogQuestionMessage(short messageId, Collection<String> dialogParams, Collection<Short> visibleReplies) {
		this.messageId = messageId;
		this.dialogParams = dialogParams;
		this.visibleReplies = visibleReplies;
	}
	
	@Override
	public boolean containsNoField() {
		return false;
	}
	
	@Override
	public int getNetworkComponentId() {
		return MESSAGE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		this.messageId = reader.readShort();
		if (messageId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on messageId = %s, it doesn't respect the following condition : messageId < 0", messageId));
		int length = reader.readUShort();
		this.dialogParams = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			String entry = reader.readUTF();
			this.dialogParams.add(entry);
		}
		length = reader.readUShort();
		this.visibleReplies = new LinkedList<>();
		for (int i = 0; i < length; i++)
		{
			short entry = reader.readShort();
			this.visibleReplies.add(entry);
		}
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		writer.writeShort(this.messageId);
		writer.writeUShort(this.dialogParams.size());
		for (String entry : this.dialogParams)
		{
			writer.writeUTF(entry);
		}
		writer.writeUShort(this.visibleReplies.size());
		for (short entry : this.visibleReplies)
		{
			writer.writeShort(entry);
		}
	}
}