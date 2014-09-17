package com.pcs.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Contacts implements Parcelable{

	private String name;
	private String phone;
	private String email;


	/**
	 * Empty Constructor
	 */

	public Contacts(){

	}

	/**
	 * This Constructor is used when parcel is sent as argument
	 * @param source
	 */
	
	public Contacts(Parcel source){

		setName(source.readString());
		setPhone(source.readString());
		setEmail(source.readString());

	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public int describeContents() {

		return 0;
	}
	@Override
	public void writeToParcel(Parcel dest, int flags) {
		
		dest.writeString(getName());
		dest.writeString(getPhone());
		dest.writeString(getEmail());


	}
	
	public static final Creator<Contacts> CREATOR = new Creator<Contacts>(){

		@Override
		public Contacts createFromParcel(Parcel source) {
			
			return new Contacts(source);
		}

		@Override
		public Contacts[] newArray(int size) {
			
			return new Contacts[size];
		}
		
	};

}
