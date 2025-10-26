package ru.evstafeva.gun;

public class Gun2W2 extends Weapon2 {
    private final int maxCapacity;

    public Gun2W2() {
        this(5, 7);
    }

    public Gun2W2(int bulletCount) {
        this(bulletCount, 7);
    }

    public Gun2W2(int bulletCount, int maxCapacity) {
        super(bulletCount);
        this.maxCapacity = maxCapacity;
        if (bulletCount > maxCapacity) {
            this.ammo = maxCapacity;
            System.out.println("Пистолет полностью заряжен. Остаток патронов - " + (bulletCount - maxCapacity));
        } else {
            this.ammo = bulletCount;
        }
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public int getBulletCount() {
        return ammo;
    }

    public void isLoaded() {
        if (ammo > 0) { // прямой доступ
            strReload();
        } else {
            System.out.println("Пистолет разряжен.");
        }
    }

    public void setBulletCount(int bulletCount) {
        if (bulletCount < 0) {
            System.out.println("Недопустимое значение. Количество патронов не может быть отрицательным числом.");
            ammo = 0;
        } else if (bulletCount > maxCapacity) {
            ammo = maxCapacity;
            System.out.println("Пистолет полностью заряжен. Возвращено патронов - " + (bulletCount - maxCapacity));
        } else {
            ammo = bulletCount;
        }
    }

    public int reload(int bulletsToLoad) {
        if (bulletsToLoad < 0) {
            throw new IllegalArgumentException("Отрицательного числа патронов быть не может");
        }
        int remains = maxCapacity - ammo;
        if (bulletsToLoad <= remains) {
            ammo += bulletsToLoad;
            return 0;
        } else {
            int excess = bulletsToLoad - remains;
            ammo = maxCapacity;
            return excess;
        }
    }

    public void strReload() {
        int bulletCount = ammo;
        if (bulletCount == 0) {
            System.out.println("Пистолет заряжен " + bulletCount + " патронов");
        } else if (bulletCount % 10 == 1 && bulletCount % 100 != 11) {
            System.out.println("Пистолет заряжен " + bulletCount + " патроном");
        } else {
            System.out.println("Пистолет заряжен " + bulletCount + " патронами");
        }
    }

    public int unload() {
        int bulletsReturned = ammo;
        ammo = 0;
        return bulletsReturned;
    }

    @Override
    public void shoot() {
        if (ammo > 0) {
            System.out.println("Бах!");
            getAmmo();
        } else {
            System.out.println("Клац!");
        }
    }

    @Override
    public String toString() {
        int bulletCount = ammo;
        if (bulletCount == 0) {
            return "Стреляет пистолет с " + bulletCount + " патронов";
        } else if (bulletCount % 10 == 1 && bulletCount % 100 != 11) {
            return "Стреляет пистолет с " + bulletCount + " патроном";
        } else {
            return "Стреляет пистолет с " + bulletCount + " патронами";
        }
    }
}
