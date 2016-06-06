
import java.util.Scanner;

public class Interface {

    private Tournament tour;
    private Scanner reader;

    public Interface(Tournament tour, Scanner reader) {
        this.tour = tour;
        this.reader = reader;
    }

    public void start() {
        System.out.println("Kumpula ski jumping week\n"
                + "\n"
                + "Write the names of the participants one at a time; "
                + "an empty string brings you to the jumping phase.");
        while (true) {
            System.out.print("  Participant name: ");
            String participant = reader.nextLine();
            if (participant.isEmpty()) {
                System.out.println("");
                break;
            }
            tour.addJumper(new Jumper(participant));
        }

        System.out.println("The tournament begins!\n");

        while (true) {
            System.out.print("Write \"jump\" to jump; otherwise you quit: ");
            String command = reader.nextLine();
            if (command.equals("quit")) {
                System.out.println("");
                break;
            }
            if (command.equals("jump")) {
                printRound();
            }
        }
        printResults();
    }

    public void printRound() {
        System.out.println("");
        System.out.println("Round " + tour.getRoundCounter());
        System.out.println("");
        System.out.println("Jumping order:");
        tour.sort();
        for (int i = 0; i < tour.getplayerList().size(); i++) {
            System.out.println("  " + (i+1) + ". " + tour.getplayerList().get(i));
        }
        System.out.println("");
        System.out.println("Results of round " + tour.getRoundCounter());
        tour.round();
        for (Jumper jumper : tour.getplayerList()) {
            System.out.println("  " + jumper.getName());
            System.out.println("    " + "length: " + jumper.getLJ());
            System.out.println("    " + "judge votes: " + jumper.getLV());
        }
        tour.calculatePoints();
        System.out.println("");
    }

    public void printResults() {
        System.out.println("Thanks!\n");
        System.out.println("Tournament results:");
        System.out.println("Position    Name");
        tour.reverseSort();
        for (int i = 0; i < tour.getplayerList().size(); i++) {
            System.out.println(i + 1 + "           " + tour.getplayerList().get(i));
            String jumps = "";
            for (int x : tour.getplayerList().get(i).getJumps()) {
                jumps += x + " m, ";
            }
            System.out.println("            jump lengths: " + jumps);
        }
    }
}
