package nuy.corp.springbootdemo.jpa.entity;

import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
public class SongPerformer extends BaseEntity {

	public enum Type {
		SOLO, DUET, BAND, ETC
	}

	private String name;
	private Type type;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

}
