package gr.test;

import net.xeomax.FBRocket.FBRocket;
import net.xeomax.FBRocket.Facebook;
import net.xeomax.FBRocket.LoginListener;
import net.xeomax.FBRocket.ServerErrorException;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class LogIn extends Activity implements LoginListener {

	private Button nextButton;
	private Button exitButton;

	private EditText emailText;
	private EditText passwordText;

	public static FBRocket mFBRocket;
	public static Facebook mFacebook;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.i("STARTED ACTIVITY", "LogIn");
		setContentView(R.layout.login);

		mFBRocket = new FBRocket(this, "5ocialize", "5aa5ab350ae11a92d8d51eaca3f12e02");

		// Determine whether there exists a previously-saved Facebook:
		try {
			if (mFBRocket.existsSavedFacebook()) {
				mFBRocket.loadFacebook();
			} else {
				mFBRocket.login(R.layout.login);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// nextButton = (Button) this.findViewById(R.id.LogInNextButton01);
		// nextButton.setOnClickListener(new OnClickListener() {
		//
		// @Override
		// public void onClick(View v) {
		//
		// Intent intent1 = new Intent(LogIn.this, Welcome.class);
		// startActivity(intent1);
		//
		// }
		// });
		//
		// exitButton = (Button) this.findViewById(R.id.LogInExitButton02);
		// exitButton.setOnClickListener(new OnClickListener() {
		//
		// @Override
		// public void onClick(View v) {
		// LogIn.this.finish();
		//
		// }
		// });
		//
		// emailText = (EditText) this.findViewById(R.id.EmailText01);
		//
		// passwordText = (EditText) this.findViewById(R.id.PasswordText02);

	}

	@Override
	public void onLoginFail() {
		mFBRocket.displayToast("Login failed!");
		mFBRocket.login(R.layout.login);

	}

	@Override
	public void onLoginSuccess(Facebook facebook) {
		mFBRocket.displayToast("Login success!");
		mFacebook = facebook;
		// mFacebook.save();

		// // Set the logged-in user's status:
		// try {
		//
		// String uid = facebook.getFriendUIDs().get(0); // Just get the uid of
		// // the first friend
		// // returned...
		// mFBRocket.displayDialog("Friend's name: "
		// + facebook.getFriend(uid).name); // ... and retrieve this
		// // friend's name.
		// Log.i("LALA", facebook.getFriend(uid).name);
		// } catch (ServerErrorException e) {
		// // Check if the exception was caused by not being logged-in:
		// if (e.notLoggedIn()) {
		// // ...if it was, then login again:
		// mFBRocket.login(R.layout.main);
		// } else {
		// System.out.println(e);
		// e.printStackTrace();
		// }
		// }

		Intent intent1 = new Intent(LogIn.this, Welcome.class);
		startActivity(intent1);

	}

}
