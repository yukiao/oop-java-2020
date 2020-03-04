public class Box {
    double width;
    double height;
    double depth;
    double mass;
    double density;

    public Box(double width, double height, double depth){
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    public void setWidth(double width){
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setDepth(double depth) {
        this.depth = depth;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    public void setDensity(double density) {
        this.density = density;
    }

    public double getDensity() {
        density = mass/(width*height*depth);
        return density;
    }
    
}