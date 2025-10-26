package ru.evstafeva.gun;

public class Automat extends Gun2 {
    private final int fireRate; // скорострельность (выстрелов в секунду)

    public Automat() { // конструктор без параметров: Скорострельность - 30, вместимость - 30.
        super(30, 30); // вызываем конструктор родителя: 0 патронов, вместимость 30
        this.fireRate = 30;
    }

    public Automat(int maxCapacity) { //конструктор с указанием вместимости, скорострельность - половина вместимости.
        super(maxCapacity, maxCapacity); // начинаем с пустого автомата
        if (maxCapacity < 1) {
            throw new IllegalArgumentException("Вместимость может быть минимум единицей");
        }
        this.fireRate = Math.max(1, maxCapacity / 2);
    }

    public Automat(int maxCapacity, int fireRate) { //конструктор с указанием максимального количества патронов и скорострельности
        super(maxCapacity, maxCapacity); // начинаем с пустого автомата
        if (maxCapacity < 1) {
            throw new IllegalArgumentException("Вместимость может быть минимум единицей");
        }
        if (fireRate < 1) {
            throw new IllegalArgumentException("Скорострельность может быть минимум единицей");
        }

        this.fireRate = fireRate;
    }

    public int getFireRate() {
        return fireRate;
    }

    public void shootAuto() { //количество выстрелов соответствует скорострельности
        System.out.println("Автоматическая стрельба (" + fireRate + " выстр/сек):");
        int shotsFired = 0;
        for (int i = 0; i < fireRate; i++) {
            if (getBulletCount() > 0) {
                shoot(); // используем метод shoot() родительского класса
                shotsFired++;
            } else {
                System.out.println("Клац!");
                break;
            }
        }
        System.out.println("Произведено выстрелов: " + shotsFired);
    }

    public void shootForSeconds(int seconds) { // стрельба N секунд - количество выстрелов = N * скорострельность
        if (seconds <= 0) {
            System.out.println("Время стрельбы должно быть положительным");
            return;
        }

        int totalShots = seconds * fireRate;
        System.out.println("Стрельба в течение " + seconds + " сек (" + totalShots + " выстрелов):");

        int shotsFired = 0;
        for (int i = 0; i < totalShots; i++) {
            shoot();
        }
    }

    @Override // переопределяем метод для вывода информации об автомате
    public String toString() {
        int bulletCount = getBulletCount();
        String bulletWord;

        if (bulletCount % 10 == 1 && bulletCount % 100 != 11) {
            bulletWord = "патроном";
        } else if (bulletCount % 10 >= 2 && bulletCount % 10 <= 4 &&
                (bulletCount % 100 < 10 || bulletCount % 100 >= 20)) {
            bulletWord = "патронами";
        } else {
            bulletWord = "патронов";
        }

        return "Автомат с " + bulletCount + " " + bulletWord +
                " (вместимость: " + getMaxCapacity() +
                ", скорострельность: " + fireRate + " выстр/сек)";
    }

}
