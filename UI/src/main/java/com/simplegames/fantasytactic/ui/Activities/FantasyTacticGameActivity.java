package com.simplegames.fantasytactic.ui.Activities;

import android.app.Activity;
import android.graphics.BitmapFactory;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.simplegames.fantasytactic.ui.Models.World;
import com.simplegames.fantasytactic.ui.OpenGl.DrawObjects.SimplePlane;
import com.simplegames.fantasytactic.ui.OpenGl.OpenGLRenderer;
import com.simplegames.fantasytactic.ui.R;


public class FantasyTacticGameActivity extends Activity {
    private World _world;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	this.requestWindowFeature(Window.FEATURE_NO_TITLE); 
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN);
 		GLSurfaceView view = new GLSurfaceView(this);
        OpenGLRenderer renderer = new OpenGLRenderer();
   		view.setRenderer(renderer);
   		setContentView(view);
        _world = new World(20,20);
        // Create a new plane.
        SimplePlane plane = new SimplePlane(1, 1);

        // Move and rotate the plane.
        plane.z = 1.7f;
        plane.rx = -65;

        // Load the texture.
        plane.loadBitmap(BitmapFactory.decodeResource(getResources(),
                R.drawable.map));

        // Add the plane to the renderer.
        renderer.addMesh(plane);
    }
}