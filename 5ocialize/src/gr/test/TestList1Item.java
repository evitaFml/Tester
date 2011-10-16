package gr.test;

import android.graphics.drawable.Drawable;

public class TestList1Item {

	private String Name = "";
	private boolean Checked = false;

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public boolean isChecked() {
		return Checked;
	}

	public void setChecked(boolean checked) {
		Checked = checked;
	}

	public TestList1Item(String _name) {
		Name = _name;
		Checked = false;
	}

}