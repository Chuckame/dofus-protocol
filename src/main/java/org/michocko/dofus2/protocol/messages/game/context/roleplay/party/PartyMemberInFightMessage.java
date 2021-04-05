package org.michocko.dofus2.protocol.messages.game.context.roleplay.party;

import org.michocko.dofus2.protocol.types.game.context.MapCoordinatesExtended;
import org.michocko.dofus2.protocol.messages.game.context.roleplay.party.AbstractPartyMessage;

import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true)
public class PartyMemberInFightMessage extends AbstractPartyMessage {
	public static final int MESSAGE_ID = 6342;
	
	private byte reason;
	private int memberId;
	private int memberAccountId;
	private String memberName;
	private int fightId;
	private MapCoordinatesExtended fightMap;
	private int secondsBeforeFightStart;
	
	public PartyMemberInFightMessage() {
	}
	
	public PartyMemberInFightMessage(int partyId, byte reason, int memberId, int memberAccountId, String memberName, int fightId, MapCoordinatesExtended fightMap, int secondsBeforeFightStart) {
		super(partyId);
		this.reason = reason;
		this.memberId = memberId;
		this.memberAccountId = memberAccountId;
		this.memberName = memberName;
		this.fightId = fightId;
		this.fightMap = fightMap;
		this.secondsBeforeFightStart = secondsBeforeFightStart;
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
		super.deserialize(reader);
		this.reason = reader.readSByte();
		if (reason < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on reason = %s, it doesn't respect the following condition : reason < 0", reason));
		this.memberId = reader.readInt();
		this.memberAccountId = reader.readInt();
		if (memberAccountId < 0)
			throw new IllegalArgumentException(String.format("Forbidden value on memberAccountId = %s, it doesn't respect the following condition : memberAccountId < 0", memberAccountId));
		this.memberName = reader.readUTF();
		this.fightId = reader.readInt();
		this.fightMap = new MapCoordinatesExtended();
		this.fightMap.deserialize(reader);
		this.secondsBeforeFightStart = reader.readInt();
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
		writer.writeSByte(this.reason);
		writer.writeInt(this.memberId);
		writer.writeInt(this.memberAccountId);
		writer.writeUTF(this.memberName);
		writer.writeInt(this.fightId);
		this.fightMap.serialize(writer);
		writer.writeInt(this.secondsBeforeFightStart);
	}
}