import java.util.ArrayList;
import java.util.Iterator;

public class SolarSystem {
    private ArrayList <CelestialBody> celestialBodies;
    public SolarSystem()
    {
        celestialBodies = new ArrayList<>();
    }

    public void addCelestialBody(CelestialBody celestialBody){
        celestialBodies.add(celestialBody);
    }

    public void printCelestialBodies(){
        for(CelestialBody celestialBody: celestialBodies)
        {
            System.out.println(celestialBody);
        }
    }
    public static void main(String[] args) {
        SolarSystem solarSystem = new SolarSystem();

        CelestialBody sun = new CelestialBody("Sun", 1.989e30);
        solarSystem.addCelestialBody(sun);

        CelestialBody earth = new CelestialBody("Earth", 5.972e24);
        sun.addToOrbit(earth, 1.496e8);
        solarSystem.addCelestialBody(earth);

        CelestialBody moon = new CelestialBody("Moon", 7.342e22);
        earth.addToOrbit(moon, 3844e5);
        solarSystem.addCelestialBody(moon);

        solarSystem.printCelestialBodies();

    }
}

class CelestialBody
{
    private ArrayList <CelestialBody> bodiesInOrbit;
    private CelestialBody bodyOrbited;
    private String name;
    private double mass;
    private double combinedMass;
    private double radiusFromParent;

    public CelestialBody()
    {
        bodiesInOrbit = new ArrayList<>();
    }

    public CelestialBody(String name)
    {
        this.name = name;
        bodiesInOrbit = new ArrayList<>();

    }

    public CelestialBody(String name, double mass)
    {
        this.name = name;
        this.mass = mass;
        bodiesInOrbit = new ArrayList<>();

    }

    public void setBodyOrbited(CelestialBody bodyOrbited)
    {
        this.bodyOrbited = bodyOrbited;
    }

    public void setRadiusFromParent(double radiusFromParent)
    {
        this.radiusFromParent = radiusFromParent;
    }

    public void addToOrbit(CelestialBody newOrbiter, double radius)
    {
        newOrbiter.setBodyOrbited(this);
        newOrbiter.setRadiusFromParent(radius);
        this.bodiesInOrbit.add(newOrbiter);
    }

    public void removeFromOrbit(CelestialBody c)
    {
        bodiesInOrbit.remove(c);
    }

    public Iterator<CelestialBody> bodies()
    {
        return bodiesInOrbit.iterator();
    }

    @Override
    public String toString(){
        return "CelestialBody {name: " + name + " mass: " + mass + "} \nbodyOrbited: " + 
                ((bodyOrbited != null)? bodyOrbited : "None") + "\n"; 
    }

}