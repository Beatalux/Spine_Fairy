package rec.first.spine_fairy;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;


/**
 * A simple {@link Fragment} subclass.
 */
public class FrequencyFragment extends Fragment implements RadioGroup.OnCheckedChangeListener {


    /*public interface OnMyListener{
        void onReceivedData(String frequency);
    }

    public OnMyListener onMyListener;*/

    private FrameLayout frameLayout;
    public String frequency;//지워도 될듯
    public final String key="FREQUENCY_KEY";
    Context mcontext;
    private AdView mAdView;
    private InterstitialAd mInterstitialAd;

    public FrequencyFragment() {
        // Required empty public constructor
    }






    @SuppressLint("ClickableViewAccessibility")
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mcontext = container.getContext();
        View view = inflater.inflate(R.layout.fragment_frequency, container, false);

        frameLayout = view.findViewById(R.id.container);


frequency=PreferenceManager.getString(mcontext,key);
        RadioButton radioButton = view.findViewById(R.id.radioButton);
        RadioButton radioButton2 = view.findViewById(R.id.radioButton2);
        RadioButton radioButton3 = view.findViewById(R.id.radioButton3);
        RadioGroup radioGroup=view.findViewById(R.id.radiogroup);
        radioGroup.setOnCheckedChangeListener(this);



        MobileAds.initialize(getActivity(), getString(R.string.admob_app_id));
        mAdView  =view.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        mAdView.setAdListener(new AdListener() {
            public void onAdLoaded() {
                Log.d("@@@", "onAdLoaded-banner");
            }
            public void onAdFailedToLoad(int errorCode) {

                Log.d("@@@", "onAdFailedToLoad " + errorCode);

            }

            @Override
            public void onAdClosed() {
                super.onAdClosed();
            }

            @Override
            public void onAdLeftApplication() {
                super.onAdLeftApplication();
            }

            @Override
            public void onAdOpened() {
                super.onAdOpened();
            }

            @Override
            public void onAdClicked() {
                super.onAdClicked();
            }
        });

        mInterstitialAd = new InterstitialAd(getActivity());
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712" );
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        mInterstitialAd.setAdListener(new AdListener() {
            public void onAdLoaded() {
                Log.d("@@@", "onAdLoaded-front");

            }
            public void onAdFailedToLoad(int errorCode) {

                Log.d("@@@", "onAdFailedToLoad " + errorCode);

            }

            @Override
            public void onAdClosed()
            { mInterstitialAd.loadAd(new AdRequest.Builder().build());}

            public void onAdLeftApplication() {
                super.onAdLeftApplication();
            }

            public void onAdOpened() {
                super.onAdOpened();
            }
            @Override
            public void onAdClicked() {
                super.onAdClicked();
            }
        });


        if(frequency.equals("자주"))
            radioButton.setChecked(true);
        else if (frequency.equals("보통"))
            radioButton2.setChecked(true);
        else if (frequency.equals("가끔"))
            radioButton3.setChecked(true);




        ImageButton button = view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (frequency==null)
                    Toast.makeText(getContext(), "체크해주세요", Toast.LENGTH_LONG).show();
                else {
                    Log.i("확인","왔딴다");
                    Intent goback=new Intent(getActivity(),MainActivity.class);
                    startActivity(goback);

                    //다음화면넘기기
             }
            }
        });

        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.Linear);
        linearLayout.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {

                    case MotionEvent.ACTION_DOWN: {
                        if (mInterstitialAd.isLoaded()) {
                            mInterstitialAd.show();
                        } else {
                            Log.d("TAG", "The interstitial wasn't loaded yet.");
                        }

                        frameLayout.setVisibility(View.VISIBLE);
                    }
                }
                    return true;
                }

        });
        return view;
    }






    /*public void onAttach(Context context){
        super.onAttach(context);
        try {
            onMyListener = (OnMyListener) getActivity();
        } catch(ClassCastException e) {
            Log.e("tag", "onAttach: ClassCastException" + e.getMessage());

        }*/

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId)
        {
            case R.id.radioButton:
                frequency = "자주";
                PreferenceManager.setString(mcontext, key, frequency);

                break;
            case R.id.radioButton2:

                frequency = "보통";
                PreferenceManager.setString(mcontext, key, frequency);
                break;
            case R.id.radioButton3:

                frequency = "가끔";
                PreferenceManager.setString(mcontext, key, frequency);
                break;

        }
    }
    }




