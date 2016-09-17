package williamking.colorfinder;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;

public class MainIntent extends Activity {

        // Variables

        // Variables used to draw the color
        ColoredBox colorChanging_intent;
        SurfaceView colorSurface_intent;

        // Number pickers used to choose the color.
        NumberPicker numPickRed_intent;
        NumberPicker numPickGreen_intent;
        NumberPicker numPickBlue_intent;

        // Intent Information
        Intent colorToSend;
        Button buttonToSend;
        int[] colorComponents;

        // Overridden Methods
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            // Initialize SurfaceView with standard color.
            colorChanging_intent = new ColoredBox(getApplicationContext());
            colorSurface_intent = (SurfaceView) findViewById(R.id.colorSurfaceView_intent);

            if(colorSurface_intent == null) Log.i("colorSurface","colorSurface is null");
            else {
                Log.i("colorSurface","colorSurface is not null");

                colorSurface_intent.setBackgroundColor(Color.rgb(0,0,0));
                colorSurface_intent.refreshDrawableState();
            }

            // numPickRed
            numPickRed_intent = (NumberPicker) findViewById(R.id.numberPickerRed_intent);
            numPickRed_intent.setMaxValue(255);
            numPickRed_intent.setMinValue(0);
            Log.i("numPickRed","numPickRed number picker initialized.");

            numPickRed_intent.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
                @Override
                public void onValueChange(NumberPicker redPicker, int oldRedVal, int newRedVal) {
                    Log.i("numPickRed","Value change listener, new value: " + newRedVal);
                    colorChanging_intent.updateBoxRed(newRedVal);
                    redrawSurfaceDisplay(colorSurface_intent, colorChanging_intent);
                }
            }); // numPickRed.setOnValueChangedListener

            // numPickGreen
            numPickGreen_intent = (NumberPicker) findViewById(R.id.numberPickerGreen_intent);
            numPickGreen_intent.setMaxValue(255);
            numPickGreen_intent.setMinValue(0);
            Log.i("numPickGreen","numPickGreen number picker initialized.");

            numPickGreen_intent.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
                @Override
                public void onValueChange(NumberPicker greenPicker, int oldGreenVal, int newGreenVal) {
                    Log.i("numPickGreen","Value change listener, new value: " + newGreenVal);
                    colorChanging_intent.updateBoxGreen(newGreenVal);
                    redrawSurfaceDisplay(colorSurface_intent, colorChanging_intent);
                }
            });  // numPickGreen.setOnValueChangedListener

            // numPickBlue
            numPickBlue_intent = (NumberPicker) findViewById(R.id.numberPickerBlue_intent);
            numPickBlue_intent.setMaxValue(255);
            numPickBlue_intent.setMinValue(0);
            Log.i("numPickBlue","numPickBlue number picker initialized.");

            numPickBlue_intent.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
                @Override
                public void onValueChange(NumberPicker bluePicker, int oldBlueVal, int newBlueVal) {
                    Log.i("numPickBlue","Value change listener, new value: " + newBlueVal);
                    colorChanging_intent.updateBoxBlue(newBlueVal);
                    redrawSurfaceDisplay(colorSurface_intent, colorChanging_intent);

                }
            });  // numPickBlue.setOnValueChangedListener


            // Sending Return of Intent Call
            colorComponents = new int[] {colorChanging_intent.boxRed,
                    colorChanging_intent.boxGreen,
                    colorChanging_intent.boxBlue};

            Intent intentToSend = new Intent(Intent.ACTION_SEND);
            intentToSend.putExtra("Color to Print",colorComponents);

            buttonToSend = (Button) findViewById(R.id.buttonToSendIntent);
            buttonToSend.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });


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




} // MainIntent
