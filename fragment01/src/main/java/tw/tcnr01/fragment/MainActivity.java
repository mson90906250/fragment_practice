package tw.tcnr01.fragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*ExampleFragment fragment = new ExampleFragment();
        //將data帶入fragment-------方法一
        //缺點會使程式碼變得非常雜亂,難以維護
        Bundle args = new Bundle();
        args.putString("argText","Hello World");
        args.putInt("argNumber",123);
        fragment.setArguments(args);*/

        //方法二 ,使用自定義的方法newInstance(String text,int number)來將data帶入並回傳一個ExampleFragment
        ExampleFragment fragment = ExampleFragment.newInstance("Hello World",456);

        //將R.id.container換成fragment
        getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment).commit();
    }
}
