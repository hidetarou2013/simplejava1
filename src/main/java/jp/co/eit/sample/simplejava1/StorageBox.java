package jp.co.eit.sample.simplejava1;

import java.util.List;

public class StorageBox {
	private List<CustVehModel> list;
	private boolean priority;
	private String name;

	public StorageBox(String name, List<CustVehModel> list, boolean priority){
		this.name = name;
		this.list = list;
		this.priority = priority;
	}
	public StorageBox(){

	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<CustVehModel> getList() {
		return list;
	}
	public void setList(List<CustVehModel> list) {
		this.list = list;
	}
	public boolean isPriority() {
		return priority;
	}
	public void setPriority(boolean priority) {
		this.priority = priority;
	}

}
