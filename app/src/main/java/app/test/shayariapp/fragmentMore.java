package app.test.shayariapp;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;


public class fragmentMore extends Fragment {
    LinearLayout linearLayout_share, linearLayout_policy, linearLayout_rate;

    public fragmentMore() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.fragment_more, container, false);
        linearLayout_policy = rootView.findViewById(R.id.linearlayout_privacy_policy);
        linearLayout_rate = rootView.findViewById(R.id.linearlayout_rate);
        linearLayout_share = rootView.findViewById(R.id.linearlayout_share);
        linearLayout_policy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(),privacyPolicy.class);
                startActivity(intent);
            }
        });
        linearLayout_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    shareIntent.setType("text/plain");
                    shareIntent.putExtra(Intent.EXTRA_SUBJECT, "My application name");
                    String shareMessage= "\nLet me recommend you this application\n\n";
                    shareMessage = shareMessage + "https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID +"\n\n";
                    shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
                    startActivity(Intent.createChooser(shareIntent, "choose one"));
                } catch(Exception e) {
                    //e.toString();
                }
            }
        });
        linearLayout_rate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  goToMyApp(false);
                gotoPlayStore();
            }
        });

        return rootView;
    }
    //only for play store
    public void gotoPlayStore() {
        try {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(("http://play.google.com/store/apps/details?id=") + getActivity().getPackageName())));
        } catch (ActivityNotFoundException e2) {
            Toast.makeText(getContext(), "You don't have any app that can open this link", Toast.LENGTH_SHORT).show();
        }
    }
    /*
    This is if you publish your app in both Google Play Store and Amazon Appstore.
    I also handle the case that users (especially in China)
     don't have both app store and browser.
     */
    public void goToMyApp(boolean googlePlay) {//true if Google Play, false if Amazone Store
        try {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse((googlePlay ? "market://details?id=" : "amzn://apps/android?p=") + getActivity().getPackageName())));
        } catch (ActivityNotFoundException e1) {
            try {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse((googlePlay ? "http://play.google.com/store/apps/details?id=" : "http://www.amazon.com/gp/mas/dl/android?p=") + getActivity().getPackageName())));
            } catch (ActivityNotFoundException e2) {
                Toast.makeText(getContext(), "You don't have any app that can open this link", Toast.LENGTH_SHORT).show();
            }
        }
    }
}