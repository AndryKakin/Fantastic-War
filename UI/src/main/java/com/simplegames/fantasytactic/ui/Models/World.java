package com.simplegames.fantasytactic.ui.Models;

import java.util.ArrayList;

/**
 * Created by andrey.kakin on 21.07.14.
 */
public class World {
    public int Width;
    public int Heidht;

    public ArrayList<City> Cities;

    public World(int heidht, int width)
    {
        Heidht = heidht;
        Width = width;
    }
}
