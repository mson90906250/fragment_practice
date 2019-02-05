package tw.tcnr01.fragment_otherfragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
//讓Main implements 兩個Listener
public class Main extends AppCompatActivity implements FragmentA.FragmentAListener, FragmentB.FragmentBListener {
    FragmentA fragmentA;
    FragmentB fragmentB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentA = new FragmentA();
        fragmentB = new FragmentB();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_a,fragmentA)
                .replace(R.id.container_b,fragmentB)
                .commit();
    }

    //將fragmentA裡的editText的值傳入fragmentB
    @Override
    public void inputASent(CharSequence input) {
        fragmentB.updateEditText(input);
    }

    //將fragmentB裡的editText的值傳入fragmentA
    @Override
    public void inputBSent(CharSequence input) {
        fragmentA.updateEditText(input);
    }
}
