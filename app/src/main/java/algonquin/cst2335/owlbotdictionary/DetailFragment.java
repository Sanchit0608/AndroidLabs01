package algonquin.cst2335.owlbotdictionary;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.nio.charset.MalformedInputException;

public class DetailFragment extends Fragment {

    private Bundle dataFromActivity;
    private String word, define, pronunciation;
    private AppCompatActivity parentActivity;
    private TextView tvWord, tvDefine, tvPronunciation;

    public DetailFragment(){
        //Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        dataFromActivity = getArguments();
        word = dataFromActivity.getString(MainActivity.WORD);
        define = dataFromActivity.getString(MainActivity.DEFINE);
        pronunciation = dataFromActivity.getString(MainActivity.PRONUNCIATION);

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detail, container, false);

        tvWord = (TextView)view.findViewById(R.id.tvWord);
        tvWord.setText(word);

        tvDefine = (TextView)view.findViewById(R.id.tvDefinition);
        tvDefine.setText(define);

        tvPronunciation = (TextView)view.findViewById(R.id.tvPronunciation);
        tvPronunciation.setText(pronunciation);

        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        parentActivity = (AppCompatActivity)context;
    }
}