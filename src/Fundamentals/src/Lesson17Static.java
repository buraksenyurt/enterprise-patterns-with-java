public class Lesson17Static {
    public static void run() {
        Actor[] actors = {
                new Actor("Can Cey Rambo", 34.50),
                new Actor("Van Two Dome", 24.29),
        };
        System.out.println("There is " + Actor.totalActor + " actors in game.");

        var bruce = new Actor("Burus Li", 51.30);
        System.out.println("There is " + Actor.totalActor + " actors in game.");

        var averageScore = Algebra.Avg(actors[0].score, actors[1].score, bruce.score);
        System.out.printf("The average score of actors is %.2f", averageScore);
    }
}

class Actor {
    static int totalActor;

    String name;
    double score;

    Actor(String name, double score) {
        this.name = name;
        this.score = score;
        System.out.println("Actor " + name + " is created");
        totalActor++;
    }
}

class Algebra {
    static double Avg(double... numbers) {
        double total = 0;
        for (double number : numbers) {
            total += number;
        }
        return total / numbers.length;
    }
}
