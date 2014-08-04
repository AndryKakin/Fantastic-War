package com.simplegames.fantasytactic.ui.Activities;

import android.app.Activity;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.simplegames.fantasytactic.ui.Controllers.GameController;
import com.simplegames.fantasytactic.ui.Models.City;
import com.simplegames.fantasytactic.ui.Models.Enums.Nation;
import com.simplegames.fantasytactic.ui.Models.World;
import com.simplegames.fantasytactic.ui.OpenGl.DrawObjects.SimplePlane;
import com.simplegames.fantasytactic.ui.OpenGl.OpenGLRenderer;
import com.simplegames.fantasytactic.ui.R;

import java.util.UUID;


public class FantasyTacticGameActivity extends Activity {
    private GameController _game;
    private World _world;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {

    	super.onCreate(savedInstanceState);
        CreateWorld();
        _game = new GameController(_world);

        // Remove the title bar from the window.
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        // Make the windows into full screen mode.
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // Create a OpenGL view.
        GLSurfaceView view = new GLSurfaceView(this);

        // Creating and attaching the renderer.
        OpenGLRenderer renderer = new OpenGLRenderer();
        view.setRenderer(renderer);
        setContentView(view);

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

    private void CreateWorld() {
        _world = new World(20,20);
        City elfCity = new City();
        elfCity.Nation = Nation.Elf;
        elfCity.Name = "Aivel";
        elfCity.Position = new Point(2,4);
        _world.Cities.add(elfCity);
    }
}