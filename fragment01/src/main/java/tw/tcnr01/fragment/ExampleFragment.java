package tw.tcnr01.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import tw.tcnr01.fragment.R;

public class ExampleFragment extends Fragment {
    //設定bundlez中的key值
    private static final  String ARG_TEXT = "argText";
    private static   final  String ARG_NUMBER = "argNumber";

    private  String text;
    private  int number;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.example_fragment,container,false);
        TextView textView = v.findViewById(R.id.text_view_fragment);

        //接收data
        //先判斷是否有data
        if (getArguments()!=null){
            text = getArguments().getString(ARG_TEXT);
            number = getArguments().getInt(ARG_NUMBER);

            textView.setText(text+number);
        }

        return  v;
    }

    //由於系統不鼓勵使用建構元來作初始化,所以要透過自定一個方法來回傳一個ExampleFragment的物件
    public static ExampleFragment newInstance(String text,int number){
        ExampleFragment fragment = new ExampleFragment();
        Bundle args = new Bundle();
        args.putString(ARG_TEXT,text);
        args.putInt(ARG_NUMBER,number);
        fragment.setArguments(args);
        return fragment;
    }
}
