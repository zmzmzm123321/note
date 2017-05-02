package cn.tedu.note.entity;

import java.io.Serializable;
import java.util.Date;

public class Notebook implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;
	private String userId;
	private Integer typeId;
	private String name;
	private String desc;
	private Date createtime;

	public Notebook() {
	}

	public Notebook(String id, String userId, Integer typeId, String name, String desc, Date createtime) {
		this.id = id;
		this.userId = userId;
		this.typeId = typeId;
		this.name = name;
		this.desc = desc;
		this.createtime = createtime;
	}

	@Override
	public String toString() {
		return "Notebook [id=" + id + ", user_id=" + userId + ", type_id=" + typeId + ", name=" + name + ", desc="
				+ desc + ", createtime=" + createtime + "]";
	}

	
	public Notebook(String id, String userId, String name) {
		super();
		this.id = id;
		this.userId = userId;
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Notebook other = (Notebook) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

}
