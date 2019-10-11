public class Flower
{
    private int x;
    private int y;

    public Flower(int theX, int theY) {
        this.x = theX;
        this.y = theY;


    }
    public void draw() {

        Ellipse circle1 = new Ellipse(x+100, y+50, 20, 20);
        circle1.draw();
        circle1.setColor(Color.PINK);
        circle1.fill();
        Ellipse circle2 = new Ellipse(x+100, y+70, 20,20);
        circle2.draw();
        circle2.setColor(Color.YELLOW);
        circle2.fill();
        Ellipse circle3 = new Ellipse(x+80, y+70, 20,20);
        circle3.draw();
        circle3.setColor(Color.PINK);
        circle3.fill();
        Ellipse circle4 = new Ellipse(x+120, y+70, 20,20);
        circle4.draw();
        circle4.setColor(Color.PINK);
        circle4.fill();
        Ellipse circle5 = new Ellipse(x+100, y+90, 20,20);
        circle5.draw();
        circle5.setColor(Color.PINK);
        circle5.fill();
        Line stem = new Line(x+110, y+110, x+110,y+170);
        stem.draw();
        stem.setColor(Color.GREEN);

        //how to change the stroke weight?



    }


}