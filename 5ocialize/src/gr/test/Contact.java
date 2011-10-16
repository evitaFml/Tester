package gr.test;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Contact extends Activity {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.i("STARTED ACTIVITY", "Welcome");

		for (int i = 0; i < Welcome.checkedNames.size(); i++) {
			Log.i(String.valueOf(i), Welcome.checkedNames.get(i));
		}

		LinearLayout linearLay = new LinearLayout(this);
		linearLay.setOrientation(LinearLayout.VERTICAL);

		LinearLayout linearLay1 = new LinearLayout(this);
		linearLay1.setOrientation(LinearLayout.HORIZONTAL);

		LinearLayout linearLay2 = new LinearLayout(this);
		linearLay2.setOrientation(LinearLayout.HORIZONTAL);

		LinearLayout linearLay3 = new LinearLayout(this);
		linearLay3.setOrientation(LinearLayout.HORIZONTAL);

		LinearLayout linearLay4 = new LinearLayout(this);
		linearLay4.setOrientation(LinearLayout.HORIZONTAL);

		LinearLayout linearLay5 = new LinearLayout(this);
		linearLay5.setOrientation(LinearLayout.HORIZONTAL);

		TextView textview1 = new TextView(this);
		textview1.setText(Welcome.checkedNames.get(0));
		TextView textview2 = new TextView(this);
		textview2.setText(Welcome.checkedNames.get(1));
		TextView textview3 = new TextView(this);
		textview3.setText(Welcome.checkedNames.get(2));
		TextView textview4 = new TextView(this);
		textview4.setText(Welcome.checkedNames.get(3));
		TextView textview5 = new TextView(this);
		textview5.setText(Welcome.checkedNames.get(4));

		int pixelwidth = 140;
		EditText editText1 = new EditText(this);
		editText1.setWidth(pixelwidth);
		EditText editText2 = new EditText(this);
		editText2.setWidth(pixelwidth);
		EditText editText3 = new EditText(this);
		editText3.setWidth(pixelwidth);
		EditText editText4 = new EditText(this);
		editText4.setWidth(pixelwidth);
		EditText editText5 = new EditText(this);
		editText5.setWidth(pixelwidth);

		linearLay1.addView(textview1);
		linearLay1.addView(editText1);

		linearLay2.addView(textview2);
		linearLay2.addView(editText2);

		linearLay3.addView(textview3);
		linearLay3.addView(editText3);

		linearLay4.addView(textview4);
		linearLay4.addView(editText4);

		linearLay5.addView(textview5);
		linearLay5.addView(editText5);

		Button continueButton = new Button(this);
		continueButton.setText("Continue");
		continueButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				//KANE SAVE
			}
		});

		linearLay.addView(linearLay1);
		linearLay.addView(linearLay2);
		linearLay.addView(linearLay3);
		linearLay.addView(linearLay4);
		linearLay.addView(linearLay5);
		linearLay.addView(continueButton);

		setContentView(linearLay);
	}
}
