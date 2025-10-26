package ru.evstafeva.main;

import ru.evstafeva.gun.Shooter;
import ru.evstafeva.gun.AutomatW;
import ru.evstafeva.gun.Gun2W;

public class Block25 {

    public static Shooter createShooter(String name) { //создание стрелка
        return new Shooter(name);
    }

    public static void setWeapon(Shooter shooter, Gun2W weapon) { //выдача пистолета
        shooter.setWeapon(weapon);
    }

    public static void setWeapon(Shooter shooter, AutomatW weapon) { //выдача автомата
        shooter.setWeapon(weapon);
    }

    public static void shoot(Shooter shooter) {
        shooter.shoot();
    }

    public static String getShooterInfo(Shooter shooter) {
        return shooter.toString();
    }

    public static void demonstrateThreeShooters() {
        System.out.println("-----Создание стрелков-----");

        Shooter shooter1 = createShooter("Дмитрий");
        Shooter shooter2 = createShooter("Сергей");
        Shooter shooter3 = createShooter("Михаил");

        shooter2.setWeapon(new Gun2W());
        shooter3.setWeapon(new AutomatW());

        System.out.println("Созданы стрелки:");
        System.out.println("1. " + getShooterInfo(shooter1));
        System.out.println("2. " + getShooterInfo(shooter2));
        System.out.println("3. " + getShooterInfo(shooter3));

        System.out.println("\nВыстрелы:");
        shoot(shooter1);
        shoot(shooter2);
        shoot(shooter3);
    }

    public static void demonstrateAutomaticFire() {
        System.out.println("\n-----Автоматическая стрельба-----");

        Shooter shooter4 = createShooter("Владимир");
        shooter4.setWeapon(new AutomatW());
        AutomatW automat = (AutomatW) shooter4.getWeapon();
        automat.reload(15);

        System.out.println(getShooterInfo(shooter4));
        System.out.println("Автоматическая стрельба:");
        automat.shootAuto();
    }
}
