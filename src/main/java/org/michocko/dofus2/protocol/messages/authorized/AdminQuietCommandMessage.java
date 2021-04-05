package org.michocko.dofus2.protocol.messages.authorized;

import org.michocko.dofus2.protocol.messages.authorized.AdminCommandMessage;

import org.michocko.dofus2.common.io.IDataReader;
import org.michocko.dofus2.common.io.IDataWriter;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Data
@ToString(callSuper = true) 
@EqualsAndHashCode(callSuper = true)
public class AdminQuietCommandMessage extends AdminCommandMessage {
	public static final int MESSAGE_ID = 5662;
	
	
	public AdminQuietCommandMessage() {
	}
	
	public AdminQuietCommandMessage(String content) {
		super(content);
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
	}
	
	@Override
	public void serialize(IDataWriter writer) {
		super.serialize(writer);
	}
}