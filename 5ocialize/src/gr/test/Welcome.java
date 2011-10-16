package gr.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import net.xeomax.FBRocket.FBRocket;
import net.xeomax.FBRocket.Facebook;
import net.xeomax.FBRocket.Friend;
import net.xeomax.FBRocket.ServerErrorException;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Welcome extends ListActivity {

	private TextView mainTextview;
	private Facebook mFacebook;
	private List<Friend> facebookFriends;
	private FBRocket mFBRocket;
	private TestList1ItemAdapter tlia;
	public static ArrayList<String> checkedNames = new ArrayList<String>();
	private ArrayList<TestList1Item> itemsList = new ArrayList<TestList1Item>();
	private Button continueButton;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.i("STARTED ACTIVITY", "Welcome");
		setContentView(R.layout.welcome);
		mainTextview = (TextView) this.findViewById(R.id.WelcomeTextView01);
		facebookFriends = new ArrayList<Friend>();
		mFBRocket = LogIn.mFBRocket;
		mFacebook = LogIn.mFacebook;

		continueButton = (Button) this.findViewById(R.id.WelcomeBContinue);
		continueButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent1 = new Intent(Welcome.this, Contact.class);
				startActivity(intent1);

			}
		});

		tlia = new TestList1ItemAdapter(this);

		try {
			Log.i("Valid session", String.valueOf(mFacebook.sessionIsValid()));
		} catch (ServerErrorException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String ownName = "";
		try {

			Log.i("STARTED ACTIVITY", "Fetch start");
			ownName = mFacebook.getFriend(mFacebook.getUid()).name;

			// Log.i("STARTED OWN NAME", ownName);
			// List<String> friendUIDs = mFacebook.getFriendUIDs();
			// // for (int i = 0; i < friendUIDs.size(); i++) {
			// for (int i = 0; i < 15; i++) {
			// facebookFriends.add(mFacebook.getFriend(friendUIDs.get(i)));
			// Log.i("FRIEND NAME",
			// mFacebook.getFriend(friendUIDs.get(i)).name);
			// }
			// Log.i("STARTED ACTIVITY", "Fetch stop");
		} catch (ServerErrorException e) {
			e.printStackTrace();
		}

		mainTextview
				.setText("Welcome "
						+ ownName
						+ "\nThis account will be in use for nowon. From the following list choose 5 friends with who you 5ocialize the most!\n"
						+ "Remember, your account and the friends selected will be registered for quite a long! Be sure of what you feeling for them, and they for you!!");

		for (int i = 0; i < FacebookLib.returnFriends().size(); i++) {
			itemsList.add(new TestList1Item(FacebookLib.returnFriends().get(i)));
		}
		updateGUI();

	}

	private void updateGUI() {
		this.runOnUiThread(new Runnable() {
			@Override
			public void run() {
				tlia.setListItems(itemsList);
				Welcome.this.setListAdapter(tlia);
			}
		});
	}
}
