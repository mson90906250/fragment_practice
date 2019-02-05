package tw.tcnr01.fragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ExampleFragment fragment = new ExampleFragment();

        //將R.id.container換成fragment
        getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment).commit();
    }
}
