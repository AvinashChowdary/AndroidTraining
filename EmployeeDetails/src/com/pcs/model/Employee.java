package com.pcs.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Employee implements Parcelable{

	private String id;
	private String name;
	private String designation;

	public Employee(){
		
	}
	
	//constructor for setting the source
	//source comes from creator
	public Employee(Parcel source){
		setId(source.readString());
		setName(source.readString());
		setDesignation(source.readString());
	}

	
	//setters and getters
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	@Override
	public int describeContents() {

		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {

		dest.writeString(getId());
		dest.writeString(getName());
		dest.writeString(getDesignation());


	}
//creator
	public static Creator<Employee> CREATOR = new Creator<Employee>(){

		@Override
		public Employee createFromParcel(Parcel source) {

			return new Employee(source);
		}

		@Override
		public Employee[] newArray(int size) {

			return new Employee[size];
		}

	};
	//tostring() to send data to the activity
	public String toString() {
		return getId()+"\n\n"+getName()+"\n\n"+getDesignation();
	};



}
