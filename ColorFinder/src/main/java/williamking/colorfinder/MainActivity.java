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

    // Variables used to draw the color
    ColoredBox colorChanging;
    SurfaceView colorSurface;

    // Number pickers used to choose the color.
    NumberPicker numPickRed;
    NumberPicker numPickGreen;
    NumberPicker numPickBlue;


    // Overridden Methods
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize SurfaceView with standard color.
        colorChanging = new ColoredBox(getApplicationContext());
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
                Log.i("numPickRed","Value change listener, new value: " + newRedVal);
                colorChanging.updateBoxRed(newRedVal);
                redrawSurfaceDisplay(colorSurface, colorChanging);
            }
        }); // numPickRed.setOnValueChangedListener

        // numPickGreen
        numPickGreen = (NumberPicker) findViewById(R.id.numberPickerGreen);
        numPickGreen.setMaxValue(255);
        numPickGreen.setMinValue(0);
        Log.i("numPickGreen","numPickGreen number picker initialized.");

        numPickGreen.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker greenPicker, int oldGreenVal, int newGreenVal) {
                Log.i("numPickGreen","Value change listener, new value: " + newGreenVal);
                colorChanging.updateBoxGreen(newGreenVal);
                redrawSurfaceDisplay(colorSurface, colorChanging);
            }
        });  // numPickGreen.setOnValueChangedListener

        // numPickBlue
        numPickBlue = (NumberPicker) findViewById(R.id.numberPickerBlue);
        numPickBlue.setMaxValue(255);
        numPickBlue.setMinValue(0);
        Log.i("numPickBlue","numPickBlue number picker initialized.");

        numPickBlue.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker bluePicker, int oldBlueVal, int newBlueVal) {
                Log.i("numPickBlue","Value change listener, new value: " + newBlueVal);
                colorChanging.updateBoxBlue(newBlueVal);
                redrawSurfaceDisplay(colorSurface, colorChanging);

            }
        });  // numPickBlue.setOnValueChangedListener

    } // onCreate

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }  // onCreateOptionsMenu

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
    }  // onOptionsItemSelected


    // Created Methods
    /**
     * Method to initialize the redraw of the background of the surface view
     * Method created to remove repetitive calls.
     *
     * @param surfaceToRedraw the surface to redraw the background of.
     * @param colorsToUse the ColoredBox object that controls the color
     */
    void redrawSurfaceDisplay(SurfaceView surfaceToRedraw, ColoredBox colorsToUse) {
        Log.i("redrawSurfaceDisplay","Red: " + colorsToUse.boxRed
                                    + ", Green: " + colorsToUse.boxGreen
                                    + ", Blue: " + colorsToUse.boxBlue);
        surfaceToRedraw.setBackgroundColor( Color.rgb(colorsToUse.boxRed,
                                                      colorsToUse.boxGreen,
                                                      colorsToUse.boxBlue) );
        surfaceToRedraw.refreshDrawableState();
    }  // redrawSurfaceDisplay

}  // MainActivity


