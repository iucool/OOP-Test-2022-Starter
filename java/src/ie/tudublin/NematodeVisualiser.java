package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class NematodeVisualiser extends PApplet
{

    ArrayList<Nematode> Nema = new ArrayList<Nematode>();

	public float border;

    void drawGrid()
    {
        stroke(255, 0, 255);
        textAlign(CENTER, CENTER);
        textSize(20);
        for(int i = -5; i <=5; i ++)
        {
            float x = map(i, -5, 5, border, width - border);
            line(x, border, x, height - border);
            line(border, x, width - border, x);
            fill(255);
            text(i, x, border * 0.5f);
            text(i, border * 0.5f, x);
        }
    
	}

	public void settings()
    {
        size(800, 800);
    }

	    Nematode first = null;
		Nematode second = null;

    public void keyPressed()
    {        
		for(Nematode s:Nema)
        {
            float x = map(s.limbs(), -5, 5, border, width - border);
            float y = map(s.eyes(), -5, 5, border, height - border);

            if (dist(mouseX, mouseY, x, y) < 20)
            {
                if (first == null)
                {
                    first = s;
                    break;
                }
                else if (second == null)
                {
                    second = s;
                    break;
                } 
                else
                {
                    first = s;
                    second = null;
                    break;
                }
            }
        }
	}

   
    public void setup() 
    {
        colorMode(HSB);
        background(0);
        smooth();    
        loadNematodes();
        printNematodes();        
    }

    void printNematodes(){
        for(Nematode n:Nema)
        {
            System.out.println(n);
        }
    }
    

    public void loadNematodes()
    {
        Table table = loadTable("nematodes.csv", "header");
        for(TableRow r:table.rows())
        {
            Nematode n = new Nematode(r);
            Nema.add(n);
        }
    }




    public void drawNematodes()
    {
        for(Nematode s:Nema)
        {
            s.render(this);
        }
    }

    public void draw() 
    {
        background(0);
        drawGrid();
        drawNematodes();

        if (first != null)
		{

		}
	}
}