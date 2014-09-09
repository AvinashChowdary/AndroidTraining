package com.pcs.model;

import android.os.Parcel;
import android.os.Parcelable;


public class Employee implements Parcelable{

	private String Name;
	private String Empid;
	private String Dept;
	private String Salary;

	
	public Employee()
	{
	}
	
	
	public Employee(Parcel source)
	{
		setName(source.readString());
		setEmpid(source.readString());
		setDept(source.readString());
		setSalary(source.readString());
	}
	
	
	
	
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getEmpid() {
		return Empid;
	}
	public void setEmpid(String empid) {
		Empid = empid;
	}
	public String getDept() {
		return Dept;
	}
	public void setDept(String dept) {
		Dept = dept;
	}
	public String getSalary() {
		return Salary;
	}
	public void setSalary(String salary) {
		Salary = salary;
	}


	@Override
	public int describeContents() {

		return 0;
	}
	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(getName());
		dest.writeString(getEmpid());
		dest.writeString(getDept());
		dest.writeString(getSalary());
	}
	
	public static final Creator<Employee> CREATOR = new Creator<Employee>() {

		@Override
		public Employee createFromParcel(Parcel source) {
			
			return new Employee(source);
		}

		@Override
		public Employee[] newArray(int size) {
			
			return new Employee[size];
		}
		
	};
	
	public String toString() {
		return getName()+"\n\n"+getEmpid()+"\n\n"+getDept()+"\n\n"+getSalary()+"\n\nLooking Forward To Meet You At The Get_To_Gether";
	};
}
