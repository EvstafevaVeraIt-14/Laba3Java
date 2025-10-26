package ru.evstafeva.gun;

abstract class Weapon{
    private int ammo;

    public Weapon(int ammo) { //конструктор с указанием количества боеприпасов
        if (ammo < 0) {
            throw new RuntimeException("Недопустимое значение. Количество боеприпасов не может быть отрицательным.");
        }
        this.ammo = ammo;
    }

    abstract void shoot(); //абстрактный метод выстрела (реализуется в классах-наследниках)

    public int ammo() {  //количество боеприпасов
        return ammo;
    }

    public boolean getAmmo() { //вынимаем боеприпас
        if (ammo == 0) {
            return false;
        }
        ammo--;
        return false;
    }

    public int load(int ammo) { //полная перезарядка (старое количество боеприпасов заменяется на новое)
        if (ammo < 0) {
            throw new RuntimeException("Недопустимое значение. Количество боеприпасов не может быть отрицательным.");
        }
        int tmp = ammo;
        this.ammo = ammo;
        return tmp;
    }
}
