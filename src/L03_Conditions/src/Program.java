void main() {
    Scanner scanner = new Scanner(System.in);

    // If conditions
    System.out.println("Bana adını söyler misin? ");
    String name = scanner.nextLine();
    if (name.isEmpty()) {
        System.out.println("Tekrar gel. İsmini öğrenmeden ilerlemek istemem");
        System.exit(0);
    }

    System.out.println("Hoşgeldin " + name);

    IO.println("Hangi yöne gitmek istersin (Kuzey, Güney, Doğu, Batı)? ");
    String line = scanner.nextLine().toUpperCase();
    char direction = line.charAt(0);

    if (direction == 'K') {
        IO.println("Kuzeye gidiyoruz");
    } else if (direction == 'G') {
        IO.println("Güneye gidiyoruz. Tatill!!!");
    } else if (direction == 'B') {
        IO.println("Güneşin battığı yöne gidiyoruz");
    } else if (direction == 'D') {
        IO.println("Hadi güneşin doğuşunu izlemeye gidelim");
    } else {
        IO.println("Hangi yöne gideceğimi bilemedim şimdi. Duralım.");
    }

    // Switch Case Sample
    switch (direction) {
        case 'K':
            System.out.println("North");
            break;
        case 'G':
            System.out.println("South");
            break;
        case 'B':
            System.out.println("West");
            break;
        case 'D':
            System.out.println("East");
            break;
    }
}
