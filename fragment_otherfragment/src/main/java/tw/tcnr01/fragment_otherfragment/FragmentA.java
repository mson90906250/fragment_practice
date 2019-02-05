package tw.tcnr01.fragment_otherfragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class FragmentA extends Fragment {
    private  FragmentAListener listener;
    private EditText editText;
    private Button buttonOk;

    //新增一個interface
    public  interface FragmentAListener{
        void inputASent(CharSequence input);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_a,container,false);

        editText = v.findViewById(R.id.edit_text);
        buttonOk = v.findViewById(R.id.button_ok);
        //設監聽
        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CharSequence input = editText.getText();
                listener.inputASent(input);
            }
        });

        return  v;
    }

    @Override
    //當fragment第一次attach一個activity時執行
    public void onAttach(Context context) {
        super.onAttach(context);
        //判斷context(即Activity)是否implement FragmentAListener
        if (context instanceof FragmentAListener){
            listener = (FragmentAListener) context;
        }else {
            throw new RuntimeException(context.toString()+"must implement FragmentAListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
}
