package ru.evstafeva.gun;

public class AutomatW extends Weapon {
    private final int maxCapacity;
    private final int fireRate;

    public AutomatW() {
        this(30, 30);
    }

    public AutomatW(int maxCapacity) {
        this(maxCapacity, maxCapacity / 2);
    }

    public AutomatW(int maxCapacity, int fireRate) {
        super(0); // начинаем с пустого автомата
        if (maxCapacity < 1) {
            throw new IllegalArgumentException("Вместимость может быть минимум единицей");
        }
        if (fireRate < 1) {
            throw new IllegalArgumentException("Скорострельность может быть минимум единицей");
        }
        this.maxCapacity = maxCapacity;
        this.fireRate = fireRate;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public int getFireRate() {
        return fireRate;
    }

    public int getBulletCount() {
        return ammo();
    }

    public void setBulletCount(int bulletCount) {
        if (bulletCount < 0) {
            System.out.println("Недопустимое значение. Количество патронов не может быть отрицательным числом.");
            load(0);
        } else if (bulletCount > maxCapacity) {
            load(maxCapacity);
            System.out.println("Автомат полностью заряжен. Возвращено патронов - " + (bulletCount - maxCapacity));
        } else {
            load(bulletCount);
        }
    }

    public int reload(int bulletsToLoad) {
        if (bulletsToLoad < 0) {
            throw new IllegalArgumentException("Отрицательного числа патронов быть не может");
        }
        int remains = maxCapacity - ammo();
        if (bulletsToLoad <= remains) {
            load(ammo() + bulletsToLoad);
            return 0;
        } else {
            int excess = bulletsToLoad - remains;
            load(maxCapacity);
            return excess;
        }
    }

    public int unload() {
        int bulletsReturned = ammo();
        load(0);
        return bulletsReturned;
    }

    @Override
    public void shoot() {
        if (ammo() > 0) {
            System.out.println("Бах!");
            getAmmo();
        } else {
            System.out.println("Клац!");
        }
    }

    public void shootAuto() {
        System.out.println("Автоматическая стрельба (" + fireRate + " выстр/сек):");
        int shotsFired = 0;
        for (int i = 0; i < fireRate; i++) {
            if (ammo() > 0) {
                shoot();
                shotsFired++;
            } else {
                System.out.println("Клац!");
                break;
            }
        }
        System.out.println("Произведено выстрелов: " + shotsFired);
    }

    public void shootForSeconds(int seconds) {
        if (seconds <= 0) {
            System.out.println("Время стрельбы должно быть положительным");
            return;
        }

        int totalShots = seconds * fireRate;
        System.out.println("Стрельба в течение " + seconds + " сек (" + totalShots + " выстрелов):");

        for (int i = 0; i < totalShots; i++) {
            shoot();
        }
    }

    @Override
    public String toString() {
        int bulletCount = ammo();
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
                " (вместимость: " + maxCapacity +
                ", скорострельность: " + fireRate + " выстр/сек)";
    }
}
