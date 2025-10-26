package ru.evstafeva.gun;

public class Gun2W extends Weapon {
    private final int maxCapacity; //оставляем только максимальную вместимость

    public Gun2W() {
        this(5, 7); // количество - 5, макс. вместимость - 7
    }

    public Gun2W(int bulletCount) {
        this(bulletCount, 7); // заданное количество, макс. вместимость - 7
    }

    public Gun2W(int bulletCount, int maxCapacity) {
        super(bulletCount); //вызов конструктора родительского класса
        this.maxCapacity = maxCapacity;
        setBulletCount(bulletCount);
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public int getBulletCount() { //возврат параметра родительского класса
        return ammo();
    }

    public void isLoaded() {
        if (ammo() > 0) { //проверка условия на параметре родительского класса
            strReload();
        } else {
            System.out.println("Пистолет разряжен.");
        }
    }

    public void setBulletCount(int bulletCount) { //полная перезарядка с помощью родительского метода load
        if (bulletCount < 0) {
            System.out.println("Недопустимое значение. Количество патронов не может быть отрицательным числом.");
            load(0);
        } else if (bulletCount > maxCapacity) {
            load(maxCapacity);
            System.out.println("Пистолет полностью заряжен. Возвращено патронов - " + (bulletCount - maxCapacity));
        } else {
            load(bulletCount);
        }
    }

    public int reload(int bulletsToLoad) { //добавляем боеприпасы при помощи родительского метода load
        if (bulletsToLoad < 0) {
            throw new IllegalArgumentException("Отрицательного числа патронов быть не может");
        }
        int remains = maxCapacity - ammo();
        if (bulletsToLoad <= remains) {
            load(ammo() + bulletsToLoad);
            return 0; // все патроны поместились
        } else {
            int excess = bulletsToLoad - remains;
            load(maxCapacity);
            return excess; // возвращаем лишние патроны
        }
    }

    public void strReload() {
        int bulletCount = ammo(); //параметр из родительского класса
        if (bulletCount == 0) {
            System.out.println("Пистолет заряжен " + bulletCount + " патронов");
        } else if (bulletCount % 10 == 1 && bulletCount % 100 != 11) {
            System.out.println("Пистолет заряжен " + bulletCount + " патроном");
        } else {
            System.out.println("Пистолет заряжен " + bulletCount + " патронами");
        }
    }

    public int unload() { //разряжаем с помощью родительского параметра
        int bulletsReturned = ammo();
        load(0);
        return bulletsReturned;
    }

    @Override
    public void shoot() { //реализуем в классе-наследнике
        if (ammo() > 0) {
            System.out.println("Бах!");
            getAmmo();
        } else {
            System.out.println("Клац!");
        }
    }

    @Override
    public String toString() { //выводим информацию при помощи родительского параметра
        int bulletCount = ammo();
        if (bulletCount == 0) {
            return "Стреляет пистолет с " + bulletCount + " патронов";
        } else if (bulletCount % 10 == 1 && bulletCount % 100 != 11) {
            return "Стреляет пистолет с " + bulletCount + " патроном";
        } else {
            return "Стреляет пистолет с " + bulletCount + " патронами";
        }
    }
}
