package williamking.colorfinder;

import android.content.Context;
import android.graphics.Canvas;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * ColoredBox
 *
 * Class designed to manage the colored box display that is colored based upon the
 * RGB values of the NumberPickers.
 *
 * Created by William King on 9/3/2016.
 */
public class ColoredBox extends SurfaceView implements SurfaceHolder.Callback {

    int boxRed;
    int boxGreen;
    int boxBlue;

    /**
     * Constructor used to initialize the colored surface
     * @param context standard input context
     */
    public ColoredBox(Context context) {
        super(context);

        boxRed = 0;
        boxGreen = 0;
        boxBlue = 0;
        drawBox();
    }

    /**
     * Takes a new red value and redraws the image
     *   in the colored box
     * @param newRed new red value to use to draw
     */
    public void updateBoxRed(int newRed) {
        boxRed = newRed;
    }

    /**
     * Takes a new green value and redraws the image
     *   in the colored box.
     * @param newGreen new green value with which to draw the image
     */
    public void updateBoxGreen(int newGreen) {
        boxGreen = newGreen;
    }

    /**
     * Takes a new blue value and redraws the image
     *   in the colored box.
     * @param newBlue new blue value with which to draw the image
     */
    public void updateBoxBlue(int newBlue) {
        boxBlue = newBlue;
    }

    private void drawBox() {

    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);


    }


    // Required Methods

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        // Must implement in order to extend SurfaceView
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int x, int y, int z) {
        // Must implement in order to extend SurfaceView
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        // Must implement in order to extend SurfaceView
    }

}
