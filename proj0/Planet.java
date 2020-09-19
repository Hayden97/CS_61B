public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    // Planet constructor
    public Planet(double xP, double yP, double xV, double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Planet(Planet p) {
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }

    // calculates the distance between two Planets
    public double calcDistance(Planet p) {
        double disSquare = (xxPos - p.xxPos) * (xxPos - p.xxPos) + (yyPos - p.yyPos) * (yyPos - p.yyPos);
        return Math.sqrt(disSquare);
    }

    // calculates the force exerted on this planet by the given planet
    public double calcForceExertedBy(Planet p) {
        double distance = this.calcDistance(p);
        double G = 6.67e-11;
        return (G * this.mass * p.mass) / (distance * distance);
    }

    // calculate force exerted in the X direction
    public double calcForceExertedByX(Planet p) {
        double force = this.calcForceExertedBy(p);
        double r = this.calcDistance(p);
        return force * (p.xxPos - this.xxPos) / r;
    }

    // calculate force exerted in the Y direction
    public double calcForceExertedByY(Planet p) {
        double force = this.calcForceExertedBy(p);
        double r = this.calcDistance(p);
        return force * (p.yyPos - this.yyPos) / r;
    }

    // calculate the net X force exerted by all planets in that array upon the current Planet
    public double calcNetForceExertedByX(Planet[] planets) {
        double total = 0;
        for (Planet p : planets) {
            if (this.equals(p)) {
                continue;
            }
            total += this.calcForceExertedByX(p);
        }
        return total;
    }

    // calculate the net Y force exerted by all planets in that array upon the current Planet
    public double calcNetForceExertedByY(Planet[] planets) {
        double total = 0;
        for (Planet p : planets) {
            if (this.equals(p)) {
                continue;
            }
            total += this.calcForceExertedByY(p);
        }
        return total;
    }

    // determines how much the forces extend on the planet will cause that planet to accelerate
    public void update(double dt, double fX, double fY) {
        double aX = fX / mass;
        double aY = fY / mass;
        xxVel += aX * dt;
        yyVel += aY * dt;
        xxPos += xxVel * dt;
        yyPos += yyVel * dt;
    }

    // draw itself at its appropriate position
    public void draw() {
        StdDraw.picture(xxPos, yyPos, "images/" + imgFileName);
    }
}
