package gr.test;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Socialize extends Activity {

	private Button nextButton;
	private Button exitButton;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.i("STARTED ACTIVITY", "Socialize");
		setContentView(R.layout.main);

		nextButton = (Button) this.findViewById(R.id.NextButton01);
		nextButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (isConnected()) {
					Intent intent1 = new Intent(Socialize.this, LogIn.class);
					startActivity(intent1);
				} else {
					showNoInternetDialog();
				}
			}
		});

		exitButton = (Button) this.findViewById(R.id.ExitButton02);
		exitButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Socialize.this.finish();

			}
		});

	}

	private Dialog noInternetDialog;
	private TextView noInternetDialogTextView;
	private Button noInternetDialogButton;

	private void showNoInternetDialog() {
		this.runOnUiThread(new Runnable() {
			public void run() {

				noInternetDialog = new Dialog(Socialize.this);
				noInternetDialog.setTitle(getString(R.string.app_name));

				LinearLayout lay1 = new LinearLayout(getApplicationContext());
				lay1.setOrientation(LinearLayout.VERTICAL);

				noInternetDialogTextView = new TextView(getApplicationContext());
				noInternetDialogTextView.setText("You are not connected!");

				noInternetDialogButton = new Button(getApplicationContext());
				noInternetDialogButton.setText("Close");
				noInternetDialogButton
						.setOnClickListener(new OnClickListener() {
							public void onClick(View v) {
								noInternetDialog.cancel();
							}
						});

				lay1.addView(noInternetDialogTextView);
				lay1.addView(noInternetDialogButton);

				noInternetDialog.addContentView(lay1, new LayoutParams(
						LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
				noInternetDialog.show();
			};
		});
	}

	private boolean isConnected() {
		ConnectivityManager connec = (ConnectivityManager) this
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo netInfo = null;
		try {
			netInfo = connec.getActiveNetworkInfo();
		} catch (NullPointerException e) {
			return false;
		}
		if (netInfo != null) {
			if (netInfo.getState() == NetworkInfo.State.CONNECTED) {
				return true;
			} else {
				return false;
			}
		}
		connec = null;
		netInfo = null;
		return false;
	}
}