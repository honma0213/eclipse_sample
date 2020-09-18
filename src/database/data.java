package database;

public class data {
	int id;
	String name;
	String mail;
	String time;
	String updatetime;
	String comment;
	String faile;

	//その他、必要な情報を定義する。


	public data(int id, String name, String mail, String time,String updatetime, String comment, String faile) {
		this.id = id;
		this.name = name;
		this.mail = mail;
		this.time = time;
		this.updatetime = updatetime;
		this.comment = comment;
		this.faile = faile;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getTime() {
		return time;
	}


	public void setTime(String time) {
		this.time = time;
	}

	public String getUpdateTime() {
		return updatetime;
	}


	public void setUpdateTime(String updatetime) {
		this.updatetime = updatetime;
	}

	public String getComment(){
		return comment;
	}

	public void setComment(String comment){
		this.comment = comment;
	}

	public String getFaile(){
		return faile;
	}

	public void setFaile(String faile){
		this.faile = faile;
	}

}
