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

    NumberPicker numPickRed;
    NumberPicker numPickGreen;
    NumberPicker numPickBlue;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new ColorFinderFragment()).commit();
        }
        */

        //TODO colorMetrics = new DisplayMetrics();
        // TODO colorBitmap.createBitmap(colorMetrics, 0, 0, null );
        // TODO colorChanging = new ColoredBox(getApplicationContext());
        // TODOcolorCanvas = new Canvas(colorBitmap);
        // TODO colorSurface = (SurfaceView) findViewById(R.id.colorSurfaceView);
        // TODO Remove Next Lines, insert redrawSurfaceDisplay(colorSurface, colorChanging);
        // TODO colorSurface.setBackgroundColor(0);
        // TODO colorSurface.refreshDrawableState();


        colorChanging = new ColoredBox(getApplicationContext());
        // TODOcolorCanvas = new Canvas(colorBitmap);
        colorSurface = (SurfaceView) findViewById(R.id.colorSurfaceView);

        if(colorSurface == null) Log.i("colorSurface","colorSurface is null");
        else {
            Log.i("colorSurface","colorSurface is not null");

            colorSurface.setBackgroundColor(Color.rgb(0,0,0));
            colorSurface.refreshDrawableState();
        }




        // numPickRed
        numPickRed = (NumberPicker) findViewById(R.id.numberPickerRed);
        numPickRed.setMaxValue(255);
        numPickRed.setMinValue(0);
        Log.i("numPickRed","numPickRed number picker initialized.");

        numPickRed.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker redPicker, int oldRedVal, int newRedVal) {
                //TODO same as above
                colorSurface.setBackgroundColor(Color.rgb(255,0,0));
                colorSurface.refreshDrawableState();
            }
        });

        // numPickGreen
        numPickGreen = (NumberPicker) findViewById(R.id.numberPickerGreen);
        numPickGreen.setMaxValue(255);
        numPickGreen.setMinValue(0);
        Log.i("numPickGreen","numPickGreen number picker initialized.");

        numPickGreen.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker greenPicker, int oldGreenVal, int newGreenVal) {

                colorSurface.setBackgroundColor(Color.rgb(0,255,0));
                colorSurface.refreshDrawableState();
            }
        });
        // numPickBlue
        numPickBlue = (NumberPicker) findViewById(R.id.numberPickerBlue);
        numPickBlue.setMaxValue(255);
        numPickBlue.setMinValue(0);
        Log.i("numPickBlue","numPickBlue number picker initialized.");

        numPickBlue.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker bluePicker, int oldBlueVal, int newBlueVal) {

                colorSurface.setBackgroundColor(Color.rgb(0,0,255));
                colorSurface.refreshDrawableState();
            }
        });



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
}


