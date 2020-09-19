public class NBody {
    // read the file and return the radius of the universe
    public static double readRadius(String fileName) {
        In in = new In(fileName);
        in.readDouble();
        double radius = in.readDouble();
        return radius;
    }

    // read the file and return an array of planets
    public static Planet[] readPlanets(String fileName) {
        In in = new In(fileName);
        int numberPlanets = in.readInt();
        // skip the radius
        in.readDouble();

        Planet[] planets = new Planet[numberPlanets];
        // read each line of data and initialize a new planet
        for (int i = 0; i < numberPlanets; i += 1) {
            double xxPos = in.readDouble();
            double yyPos = in.readDouble();
            double xxVel = in.readDouble();
            double yyVel = in.readDouble();
            double mass = in.readDouble();
            String imgFileName = in.readString();
            planets[i] = new Planet(xxPos, yyPos, xxVel, yyVel, mass, imgFileName);
        }

        return planets;
    }

    public static void main(String[] args) {
        // read the essential things from the files
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        double radiusUniverse = readRadius(filename);
        Planet[] planets = readPlanets(filename);
        int numberPlanets = planets.length;

        // draw the initial background
        String imageToDraw = "images/starfield.jpg";
        StdDraw.setScale(-radiusUniverse, radiusUniverse);
        StdDraw.clear();
        StdDraw.picture(0, 0, imageToDraw);

        // draw each planet
        for (Planet planet : planets) {
            planet.draw();
        }

        // create an animation
        StdDraw.enableDoubleBuffering();
        double time = 0;
        double[] xForces = new double[numberPlanets];
        double[] yForces = new double[numberPlanets];

        while (time < T) {
            // calc net force in the two directions for each planet
            for (int i = 0; i < numberPlanets; i += 1) {
                xForces[i] = planets[i].calcNetForceExertedByX(planets);
                yForces[i] = planets[i].calcNetForceExertedByY(planets);
            }

            // update each planet
            for (int i = 0; i < numberPlanets; i += 1) {
                planets[i].update(dt, xForces[i], yForces[i]);
            }

            // draw the background
            StdDraw.clear();
            StdDraw.picture(0, 0, imageToDraw);

            // draw each planet
            for (Planet planet : planets) {
                planet.draw();
            }

            // show the offscreen buffer and pause the animation
            StdDraw.show();
            StdDraw.pause(1);

            time += dt;
        }

        // print the output
        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", radiusUniverse);
        for (int i = 0; i < planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                    planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
        }
    }
}
