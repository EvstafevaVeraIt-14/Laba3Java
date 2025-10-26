package ru.evstafeva.gun;

public class Gun2 {
    private int bulletCount;
    private final int maxCapacity;

    public Gun2() {
        this(5, 7); // количество - 5, макс. вместимость - 7
    }

    public Gun2(int bulletCount) {
        this(bulletCount, 7); // заданное количество, макс. вместимость - 7
    }

    public Gun2(int bulletCount, int maxCapacity) {
        if (maxCapacity <= 0) {
            throw new IllegalArgumentException("Максимальная вместимость не может быть отрицательным числом.");
        }
        this.maxCapacity = maxCapacity;
        setBulletCount(bulletCount);
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public int getBulletCount() {
        return bulletCount;
    }

    public void isLoaded() {
        if (bulletCount > 0) {
            strReload();
        } else {
            System.out.println("Пистолет разряжен.");
        }
    }

    public void setBulletCount(int bulletCount) {
        if (bulletCount < 0) {
            System.out.println("Недопустимое значение. Количество патронов не может быть отрицательным числом. Заряжено - 0 патронов");
            this.bulletCount = 0;
        } else if (bulletCount > maxCapacity) {
            this.bulletCount = maxCapacity;
            System.out.println("Пистолет полностью заряжен. Возвращено патронов - " + (bulletCount - maxCapacity));
        } else {
            this.bulletCount = bulletCount;
        }
    }

    public int reload(int bulletsToLoad) { //зарядка
        if (bulletsToLoad < 0) {
            throw new IllegalArgumentException("Отрицательного числа патронов быть не может");
        }

        int remains = maxCapacity - bulletCount;
        if (bulletsToLoad <= remains) {
            bulletCount += bulletsToLoad;
            return 0; // все патроны поместились
        } else {
            int excess = bulletsToLoad - remains;
            bulletCount = maxCapacity;
            return excess; // возвращаем лишние патроны
        }
    }
    public void strReload(){
        if (bulletCount == 0) {
            System.out.println("Пистолет заряжен " + bulletCount + " патронов");
        } else if (bulletCount % 10 == 1 && bulletCount % 100 != 11) {
            System.out.println("Пистолет заряжен " + bulletCount + " патроном");
        } else {
            System.out.println("Пистолет заряжен " + bulletCount + " патронами");
        }
    }

    public int unload() { //разрядка
        int bulletsReturned = bulletCount;
        bulletCount = 0;
        return bulletsReturned;
    }

    public void shoot() {
        if (bulletCount > 0) {
            System.out.println("Бах!");
            bulletCount--;
        } else {
            System.out.println("Клац!");
        }
    }

    @Override
    public String toString() {
        if (bulletCount == 0) {
            return "Стреляет пистолет с " + bulletCount + " патронов";
        } else if (bulletCount % 10 == 1 && bulletCount % 100 != 11) {
            return "Стреляет пистолет с " + bulletCount + " патроном";
        } else {
            return "Стреляет пистолет с " + bulletCount + " патронами";
        }
    }
}
