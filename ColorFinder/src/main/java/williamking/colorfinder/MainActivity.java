package williamking.colorfinder;

import android.app.Activity;
import android.app.Fragment;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.NumberPicker;
import android.widget.TextView;

public class MainActivity extends Activity {

    // Variables
    static ColoredBox colorChanging;
    // TODO static Canvas colorCanvas;
    // TODO static Bitmap colorBitmap;
    // TODO static DisplayMetrics colorMetrics;
    SurfaceView colorSurface;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new ColorFinderFragment()).commit();
        }

        //TODO colorMetrics = new DisplayMetrics();
        // TODO colorBitmap.createBitmap(colorMetrics, 0, 0, null );
        // TODO colorChanging = new ColoredBox(getApplicationContext());
        // TODOcolorCanvas = new Canvas(colorBitmap);
        // TODO colorSurface = (SurfaceView) findViewById(R.id.colorSurfaceView);
        // TODO Remove Next Lines, insert redrawSurfaceDisplay(colorSurface, colorChanging);
        // TODO colorSurface.setBackgroundColor(0);
        // TODO colorSurface.refreshDrawableState();

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
     * Method to initialize the redraw of the background of the surface view
     * Method created to remove repetitive calls.
     *
     * @param surfaceToRedraw the surface to redraw the background of.
     * @param colorsToUse the ColoredBox object that controls the color
     */
    void redrawSurfaceDisplay(SurfaceView surfaceToRedraw, ColoredBox colorsToUse) {
        surfaceToRedraw.setBackgroundColor( Color.rgb(colorsToUse.boxRed,
                                                      colorsToUse.boxGreen,
                                                      colorsToUse.boxBlue) );
        surfaceToRedraw.refreshDrawableState();
    }

    /**
     *  Fragment containing all the components of the Color Finder Application
     */
    public static class ColorFinderFragment extends Fragment {

        // Variables
        NumberPicker numPickRed;
        NumberPicker numPickGreen;
        NumberPicker numPickBlue;

        // Variables
        ColoredBox colorChanging;
        SurfaceView colorSurface;


        public ColorFinderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            return inflater.inflate(R.layout.fragment_main, container, false);
        }

        @Override
        public void onActivityCreated(Bundle b) {
            super.onActivityCreated(b);


            colorChanging = new ColoredBox(getActivity().getApplicationContext());
            // TODOcolorCanvas = new Canvas(colorBitmap);
            colorSurface = (SurfaceView) getActivity().findViewById(R.id.colorSurfaceView);

            if(colorSurface == null) Log.i("colorSurface","colorSurface is null");
            else {
                Log.i("colorSurface","colorSurface is not null");

                colorSurface.setBackgroundColor(0);
                colorSurface.refreshDrawableState();
            }




            // numPickRed
            numPickRed = (NumberPicker) getActivity().findViewById(R.id.numberPickerRed);
            numPickRed.setMaxValue(255);
            numPickRed.setMinValue(0);
            Log.i("numPickRed","numPickRed number picker initialized.");

            numPickRed.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
                @Override
                public void onValueChange(NumberPicker redPicker, int oldRedVal, int newRedVal) {
                    //TODO same as above
                    colorSurface.setBackgroundColor(50);
                    colorSurface.refreshDrawableState();
                }
            });

            // numPickGreen
            numPickGreen = (NumberPicker) getActivity().findViewById(R.id.numberPickerGreen);
            numPickGreen.setMaxValue(255);
            numPickGreen.setMinValue(0);
            Log.i("numPickGreen","numPickGreen number picker initialized.");

            numPickGreen.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
                @Override
                public void onValueChange(NumberPicker greenPicker, int oldGreenVal, int newGreenVal) {

                    colorSurface.setBackgroundColor(100);
                    colorSurface.refreshDrawableState();
                }
            });
            // numPickBlue
            numPickBlue = (NumberPicker) getActivity().findViewById(R.id.numberPickerBlue);
            numPickBlue.setMaxValue(255);
            numPickBlue.setMinValue(0);
            Log.i("numPickBlue","numPickBlue number picker initialized.");

            numPickBlue.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
                @Override
                public void onValueChange(NumberPicker bluePicker, int oldBlueVal, int newBlueVal) {

                    colorSurface.setBackgroundColor(150);
                    colorSurface.refreshDrawableState();
                }
            });


        } //onActivity
    } //ColorFinderFragment
}


