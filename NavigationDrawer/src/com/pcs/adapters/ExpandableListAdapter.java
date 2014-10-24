package com.pcs.adapters;

import java.util.HashMap;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.pcs.navigationdrawer.R;

/**
 * Adapter to handle the parent and child data
 * custom adapter which extends BaseExpandableListAdapter
 * Parents are described as group
 * Child are same as child
 * @author pcs-05
 *
 */
public class ExpandableListAdapter extends BaseExpandableListAdapter {

	private Context context;
	private List<String> parentList;
	private HashMap<String, List<String>> childList;

	//Constructor
	public ExpandableListAdapter(Context context, List<String> parentList,
			HashMap<String, List<String>> childList) {
		this.context = context;
		this.parentList = parentList;
		this.childList = childList;
	}

	@Override
	public Object getChild(int groupPosition, int childPosititon) {
		return this.childList.get(this.parentList.get(groupPosition)).get(
				childPosititon);
	}

	@Override
	public long getChildId(int groupPosition, int childPosition) {
		return childPosition;
	}

	// Returns the view of the child
	@Override
	public View getChildView(int groupPosition, final int childPosition,
			boolean isLastChild, View convertView, ViewGroup parent) {

		final String childText = (String) getChild(groupPosition, childPosition);

		if (convertView == null) {
			LayoutInflater infalInflater = (LayoutInflater) this.context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = infalInflater.inflate(R.layout.child, null);
		}

		TextView txtListChild = (TextView) convertView
				.findViewById(R.id.child_item);

		txtListChild.setText(childText);
		return convertView;
	}

	@Override
	public int getChildrenCount(int groupPosition) {
		return this.childList.get(this.parentList.get(groupPosition)).size();
	}

	@Override
	public Object getGroup(int groupPosition) {
		return this.parentList.get(groupPosition);
	}

	@Override
	public int getGroupCount() {
		return this.parentList.size();
	}

	@Override
	public long getGroupId(int groupPosition) {
		return groupPosition;
	}

	// Returns the view of the parent
	@Override
	public View getGroupView(int groupPosition, boolean isExpanded,
			View convertView, ViewGroup parent) {
		String headerTitle = (String) getGroup(groupPosition);
		if (convertView == null) {
			LayoutInflater infalInflater = (LayoutInflater) this.context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = infalInflater.inflate(R.layout.parent, null);
		}

		TextView lblListHeader = (TextView) convertView
				.findViewById(R.id.parent_item);

		lblListHeader.setText(headerTitle);

		return convertView;
	}

	@Override
	public boolean hasStableIds() {
		return false;
	}

	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		return true;
	}
}