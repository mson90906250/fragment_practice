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
            text = getArguments().getString("argText");
            number = getArguments().getInt("argNumber");

            textView.setText(text+number);
        }

        return  v;
    }
}
