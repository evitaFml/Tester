package gr.test;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.TextView;

public class TestList1ItemAdapter extends BaseAdapter {
	private Context mContext;

	private LayoutInflater inflater;

	private List<TestList1Item> mItems = new ArrayList<TestList1Item>();

	public TestList1ItemAdapter(Context ctx) {
		mContext = ctx;
		inflater = LayoutInflater.from(mContext);
	}

	public View getView(int position, View convertView, ViewGroup parent) {

		View btv = null;
		try {
			btv = inflater.inflate(R.layout.testlistitem, null);

			TextView nameText = (TextView) btv.findViewById(R.id.Name);
			nameText.setText(mItems.get(position).getName());

			CheckBox checkbox1 = (CheckBox) btv.findViewById(R.id.CheckBox01);
			checkbox1.setChecked(mItems.get(position).isChecked());
			final int finalPos = position;
			checkbox1.setOnCheckedChangeListener(new OnCheckedChangeListener() {

				@Override
				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
					if (isChecked) {
						Welcome.checkedNames.add(mItems.get(finalPos).getName());
					} else {
						Welcome.checkedNames.remove(mItems.get(finalPos).getName());
					}
				}
			});

		} catch (Exception e) {
			e.printStackTrace();
		}
		return btv;
	}

	public void addItem(TestList1Item it) {
		mItems.add(it);
	}

	public void setListItems(List<TestList1Item> lit) {
		mItems = lit;
	}

	@Override
	public int getCount() {
		return mItems.size();
	}

	@Override
	public Object getItem(int arg0) {
		return mItems.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		return arg0;
	}

}
