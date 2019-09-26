package rec.first.spine_fairy;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class FrequencyFragment extends Fragment {


    /*public interface OnMyListener{
        void onReceivedData(String frequency);
    }

    public OnMyListener onMyListener;*/

    private FrameLayout frameLayout;
    public String frequency;//지워도 될듯
    public final String key="FREQUENCY_KEY";
    Context mcontext;

    public FrequencyFragment() {
        // Required empty public constructor
    }


    @SuppressLint("ClickableViewAccessibility")
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mcontext = container.getContext();
        View view = inflater.inflate(R.layout.fragment_frequency, container, false);



        RadioButton radioButton = view.findViewById(R.id.radioButton);
        RadioButton radioButton2 = view.findViewById(R.id.radioButton2);
        RadioButton radioButton3 = view.findViewById(R.id.radioButton3);

        if (radioButton.isChecked()) {
            frequency = "자주";
            PreferenceManager.setString(mcontext, key, frequency);
        } else if (radioButton2.isChecked()) {
            frequency = "보통";
            PreferenceManager.setString(mcontext, key, frequency);
        } else if (radioButton3.isChecked()) {
            frequency = "가끔";
            PreferenceManager.setString(mcontext, key, frequency);
        }




        Button button = view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (frequency == null)
                    Toast.makeText(getContext(), "체크해주세요", Toast.LENGTH_LONG);
                else {
                    //다음화면넘기기
                }
            }
        });

        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.Linear);
        linearLayout.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        frameLayout.setVisibility(View.VISIBLE);
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
    }




