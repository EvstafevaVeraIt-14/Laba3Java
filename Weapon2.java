package ru.evstafeva.gun;

abstract class Weapon2{
    protected int ammo; //protected - наследники видят это поле

    public Weapon2(int ammo) {
        if (ammo < 0) {
            throw new RuntimeException("Недопустимое значение. Количество боеприпасов не может быть отрицательным.");
        }
        this.ammo = ammo;
    }

    abstract void shoot();

    public int ammo() {
        return ammo;
    }

    public boolean getAmmo() {
        if (ammo == 0) {
            return false;
        }
        ammo--;
        return false;
    }

    public int load(int ammo) {
        if (ammo < 0) {
            throw new RuntimeException("Недопустимое значение. Количество боеприпасов не может быть отрицательным.");
        }
        int tmp = this.ammo;
        this.ammo = ammo;
        return tmp;
    }
}
