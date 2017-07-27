package org.chuckame.dofus2.protocol.messages.game.context.roleplay.emote;

import org.chuckame.dofus2.common.io.IDataReader;
import org.chuckame.dofus2.common.io.IDataWriter;
import org.chuckame.dofus2.protocol.messages.game.context.roleplay.emote.EmotePlayAbstractMessage;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true)
public class EmotePlayMessage extends EmotePlayAbstractMessage {
	public static final int MESSAGE_ID = 5683;
	
	private int actorId;
	private int accountId;
	
	public EmotePlayMessage() {
	}
	
	public EmotePlayMessage(short emoteId, double emoteStartTime, int actorId, int accountId) {
		super(emoteId, emoteStartTime);
		this.actorId = actorId;
		this.accountId = accountId;
	}
	
	@Override
	public int getProtocolId() {
		return MESSAGE_ID;
	}
	
	@Override
	public void deserialize(IDataReader reader) {
		super.deserialize(reader);
		this.actorId = reader.readInt();
		this.accountId = reader.readInt();
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeInt(this.actorId);
		writer.writeInt(this.accountId);
	}
}