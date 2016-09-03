package williamking.colorfinder;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.NumberPicker;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new ColorFinderFragment()).commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    /**
     *  Fragment containing all the components of the Color Finder Application
     */
    public static class ColorFinderFragment extends Fragment {

        // Variables
        NumberPicker numPickRed;
        NumberPicker numPickGreen;
        NumberPicker numPickBlue;


        public ColorFinderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(
                    R.layout.fragment_main, container, false);
            return rootView;
        }

        @Override
        public void onActivityCreated(Bundle b) {
            super.onActivityCreated(b);

            // numPickRed
            numPickRed = (NumberPicker) getActivity().findViewById(R.id.numberPickerRed);
            numPickRed.setMaxValue(255);
            numPickRed.setMinValue(0);

            numPickRed.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
                @Override
                public void onValueChange(NumberPicker picker, int oldVal, int newVal) {

                }
            });

            // numPickGreen
            numPickGreen = (NumberPicker) getActivity().findViewById(R.id.numberPickerGreen);
            numPickGreen.setMaxValue(255);
            numPickGreen.setMinValue(0);

            numPickGreen.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
                @Override
                public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                }
            });
            // numPickBlue
            numPickBlue = (NumberPicker) getActivity().findViewById(R.id.numberPickerBlue);
            numPickBlue.setMaxValue(255);
            numPickBlue.setMinValue(0);

            numPickBlue.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
                @Override
                public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                }
            });


        } //onActivity
    } //ColorFinderFragment
}


