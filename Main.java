package ru.evstafeva.main;

import ru.evstafeva.house.House2;
import ru.evstafeva.errors.Check;
import ru.evstafeva.gun.Gun2;
import ru.evstafeva.gun.Gun2W;
import ru.evstafeva.gun.Gun2W2;
import ru.evstafeva.gun.Automat;
import ru.evstafeva.gun.AutomatW;
import ru.evstafeva.array.ImmutableListOfValues;
import ru.evstafeva.gun.Shooter;
import ru.evstafeva.point.Point;
import ru.evstafeva.main.Block25;
import ru.evstafeva.mathematics.Pow;
import java.util.Scanner;
import java.util.Arrays;

public class Main {
    private static String[] savedArgs;
    public static void main(String[] args) { //строка определяющая точку входа
        savedArgs = args;
        int floors, choice, choice2, returned, excess, capacity, maxCapacity, initialBullets, bulletsToLoad, shots, reload;
        boolean subtask, running1, created2, reload2, shoot2, created4, running4;
        double X1, Y1, X2, Y2;
        Scanner scanner = new Scanner(System.in);
        Check check = new Check();
        while (true) {
            System.out.println("\nНомер задания:");
            System.out.println("1 - 1.1/1.5: Дом и Пистолет");
            System.out.println("2 - 2.1: Неизменяемый массив");
            System.out.println("3 - 3.4: Автомат");
            System.out.println("4 - 4.1: Оружие");
            System.out.println("5 - 5.8: Стрелок");
            System.out.println("6 - 6.2: Сравнение точек");
            System.out.println("7 - Преобразование программы");
            System.out.println("8 - 8.2: Патроны наследникам. ");
            System.out.println("0 - Выход");
            System.out.print("Ваш выбор: ");

            choice = check.checkAnInteger();
            switch (choice) {
                case 1: {
                    subtask = true;
                    while (subtask) {
                        System.out.println("\nНомер подзадания:");
                        System.out.println("1 - Дом");
                        System.out.println("2 - Пистолет");
                        System.out.println("0 - Выход");
                        System.out.print("Ваш выбор: ");
                        choice2 = check.checkAnInteger();
                        switch (choice2) {
                            case 1: {
                                System.out.println();
                                System.out.println("Измените сущность Дом из задачи 1.4.3. Гарантируйте, что у дома всегда будет положительное\n" +
                                        "количество этажей. В случае попытки указать отрицательное количество этажей должна\n" +
                                        "выбрасываться соответствующая ошибка. Продемонстрируйте работоспособность решения на\n" +
                                        "примерах.\n");
                                House2 house1 = new House2(1);
                                House2 house2 = new House2(1000);

                                System.out.println(house1.toString());
                                System.out.println(house2.toString());

                                System.out.print("Введите количество этажей: ");
                                floors = check.checkAnInteger();
                                try {
                                    System.out.println();
                                    House2 userHouse = new House2(floors);
                                    System.out.println(userHouse.toString());
                                } catch (IllegalArgumentException e) {
                                    System.out.println("Недопустимое значение. " + e.getMessage());
                                }
                                break;
                            }
                            case 2: {
                                System.out.println();
                                System.out.println("Измените сущность Пистолет из задачи 1.5.1. Модификация предполагает внесение следующих\n" +
                                        "дополнительных требований:\n" +
                                        "\uF0B7 Имеет максимальное количество патронов. Максимальное количество устанавливается во\n" +
                                        "время создания пистолета и не может быть изменено позднее. У пистолета можно узнать,\n" +
                                        "какое максимальное количество он вмещает.\n" +
                                        "\uF0B7 Может быть перезаряжен. Для перезарядки необходимо передать пистолету число,\n" +
                                        "которое будет означать количество заряжаемых патронов. Если передано отрицательное\n" +
                                        "число, необходимо выбросить ошибку, объясняющую, что отрицательного числа\n" +
                                        "патронов быть не может. Если передано слишком большое число патронов – необходимо\n" +
                                        "лишние вернуть.\n" +
                                        "\uF0B7 Может быть разряжен. Это приводит к обнулению патронов в пистолете и возврате\n" +
                                        "нужного числа пользователю.\n" +
                                        "\uF0B7 Можно узнать сколько сейчас заряжено патронов.\n" +
                                        "\uF0B7 Можно узнать заряжен он или разряжен.\n" +
                                        "Создайте пистолет вместимостью 7, зарядите три патрона, выстрелите из него пять раз, затем\n" +
                                        "зарядите в него 8 патронов, выстрелите еще 2 раза, разрядите его, сделайте контрольный\n" +
                                        "выстрел.\n" +
                                        "Если все выполнено верно, то должно быть выведено: Бах! Бах! Бах! Клац! Клац! Бах! Бах! Клац!\n");

                                System.out.println("\n--------Демонстрационный вариант работы пистолета--------\n");

                                Gun2 gun = new Gun2(0, 7);

                                // зарядите три патрона
                                excess = gun.reload(3);
                                gun.strReload();
                                System.out.println("Остаток: " + excess);

                                // выстрелите из него пять раз
                                for (int i = 0; i < 5; i++) {
                                    gun.shoot();
                                }

                                // затем зарядите в него 8 патронов
                                excess = gun.reload(8);
                                gun.strReload();
                                System.out.println("Остаток: " + excess);

                                // выстрелите еще 2 раза
                                for (int i = 0; i < 2; i++) {
                                    gun.shoot();
                                }

                                // разрядите его
                                returned = gun.unload();
                                System.out.println("Разряжено. Возвращено патронов: " + returned);

                                // сделайте контрольный выстрел
                                gun.shoot();

                                // Дополнительная информация
                                System.out.println("Текущее количество патронов: " + gun.getBulletCount());
                                System.out.println("Максимальная вместимость: " + gun.getMaxCapacity());
                                gun.isLoaded();
                                // Создание собственного пистолета
                                System.out.println("\n--------Создание собственного пистолета--------\n");
                                Gun2 myGun = null;

                                created2 = false;
                                while (!created2) {
                                    System.out.print("Введите максимальную вместимость пистолета: ");
                                    maxCapacity = check.checkAnInteger();
                                    System.out.print("Введите начальное количество патронов (0-" + maxCapacity + "):");
                                    initialBullets = check.checkAnInteger();
                                    try {
                                        System.out.println();
                                        myGun = new Gun2(initialBullets, maxCapacity);
                                        created2 = true;
                                    } catch (IllegalArgumentException e) {
                                        System.out.println("Недопустимое значение. " + e.getMessage());
                                    }
                                }

                                System.out.println("Пистолет создан успешно!");
                                myGun.strReload();
                                System.out.println("Максимальная вместимость: " + myGun.getMaxCapacity());

                                // Интерактивное меню
                                running1 = true;
                                while (running1) {
                                    System.out.println("\n-----Действия с пистолетом------------");
                                    System.out.println("1 - Зарядить патроны");
                                    System.out.println("2 - Выстрелить");
                                    System.out.println("3 - Разрядить");
                                    System.out.println("4 - Проверить состояние");
                                    System.out.println("5 - Информация о пистолете");
                                    System.out.println("6 - Многократная стрельба");
                                    System.out.println("0 - Выход");
                                    System.out.print("Выберите действие: ");
                                    int choice3 = check.checkAnInteger();
                                    switch (choice3) {
                                            case 1: {
                                                // Зарядка патронов
                                                reload2 = false;
                                                System.out.print("Сколько патронов зарядить? ");
                                                while (!reload2) {
                                                    bulletsToLoad = check.checkAnInteger();
                                                    try {
                                                        reload = myGun.reload(bulletsToLoad);
                                                        if (reload != 0) {
                                                            System.out.println("Пистолет полностью заряжен. Возвращено патронов - " + reload);
                                                        }
                                                        myGun.strReload();
                                                        reload2 = true;
                                                    } catch (IllegalArgumentException e) {
                                                        System.out.println("Недопустимое значение. " + e.getMessage());
                                                    }
                                                }
                                                break;
                                            }
                                            case 2: {
                                                // Выстрел
                                                System.out.print("Выстрел: ");
                                                myGun.shoot();
                                                break;
                                            }
                                            case 3: {
                                                // Разрядка
                                                int returned2 = myGun.unload();
                                                System.out.println("Пистолет разряжен. Возвращено патронов: " + returned2);
                                                break;
                                            }
                                            case 4: {
                                                // Проверка состояния
                                                myGun.isLoaded();
                                                break;
                                            }
                                            case 5: {
                                                // Информация о пистолете
                                                System.out.println("Текущее количество патронов: " + myGun.getBulletCount());
                                                System.out.println("Максимальная вместимость: " + myGun.getMaxCapacity());
                                                System.out.println("Состояние: " + myGun.toString());
                                                break;
                                            }
                                            case 6: {
                                                // Многократная стрельба
                                                shoot2 = false;
                                                while (!shoot2) {
                                                    System.out.print("Сколько раз выстрелить? ");
                                                    shots = check.checkAnInteger();
                                                    if (shots < 0) {
                                                        System.out.println("Недопустимое значение. Количество выстрелов не может быть отрицательным!");
                                                    } else {
                                                        System.out.println("Производим " + shots + " выстрелов:");
                                                        for (int i = 0; i < shots; i++) {
                                                            myGun.shoot();
                                                        }
                                                        shoot2 = true;
                                                    }
                                                }
                                                break;
                                            }
                                            case 0: {
                                                // Выход
                                                running1 = false;
                                                System.out.println("Выход из программы. До свидания!");
                                                break;
                                            }
                                            default:
                                                System.out.println("Ошибка: неверный выбор! Попробуйте снова.");
                                                break;
                                        }
                                }
                                break;
                            }
                            case 0: {
                                System.out.println("Выход из задания");
                                subtask = false;
                                break;
                            }
                            default: {
                                System.out.println("Неверный выбор, попробуйте снова");
                                break;
                            }
                        }
                    }
                    break;
                }
                case 2: {
                    System.out.println("\nНеизменяемый массив.\n" +
                            "Необходимо разработать сущность НеизменяемыйСписокЗначений, представляющий собой\n" +
                            "обертку над массивом целых чисел, который сохранит функциональные возможности массивов,\n" +
                            "но добавит некоторые дополнительные возможности.\n" +
                            "Состояние сущности описывают следующие сведения:\n" +
                            "\uF0B7 Имеет массив целых чисел. Именно он используется для хранения значений.\n" +
                            "Инициализация сущности может быть выполнена следующим образом:\n" +
                            "\uF0B7 С указанием значений в виде массива целых чисел.\n" +
                            "\uF0B7 С указанием перечня чисел как независимых значений (через запятую)\n" +
                            "\uF0B7 С указанием другого Списка, в этом случае копируются все значения указанного списка.\n" +
                            "Поведение сущности описывают следующие действия:\n" +
                            "\uF0B7 Получение значения из позицииN. Позиция должна попадать в диапазон от 0 до N-1, где\n" +
                            "N–текущее количество значений, иначе выкинуть ошибку.\n" +
                            "\uF0B7 Замена значения в позиции N на новое значение. Позиция должна попадать в диапазон от\n" +
                            "0 до N-1, где N–текущее количество значений, иначе выкинуть ошибку.\n" +
                            "\uF0B7 Может быть приведен к строке. Строка должна представлять собой полный перечень всех\n" +
                            "хранимых чисел, причем первый символ строки это ”[“, а последний “]”.\n" +
                            "\uF0B7 Можно проверить пуст Список или нет. Список пуст если его размер 0.\n" +
                            "\uF0B7 Можно узнать текущий размер.\n" +
                            "\uF0B7 Все хранящиеся значения можно запросить в виде стандартного массива.\n" +
                            "Продемонстрируйте работоспособность решения на примерах.\n");
                    ImmutableListOfValues list = null;
                    System.out.println("\n---------Создание нового списка---------\n");
                    System.out.println("1 - Создать из массива чисел");
                    System.out.println("2 - Создать из отдельных чисел (через запятую)");
                    System.out.println("3 - Создать пустой список");
                    System.out.println("4 - Создать из другого списка (копия)");
                    System.out.print("Выберите способ создания: ");
                    int creationChoice = check.checkAnInteger();
                    switch (creationChoice) {
                        case 1: {
                            // Создание из массива чисел
                            System.out.print("Введите количество элементов: ");
                            int count = check.checkAnInteger();
                            if (count < 0) {
                                System.out.println("Недопустимое значение. Количество не может быть отрицательным!");
                            } else if (count == 0) {
                                list = new ImmutableListOfValues();
                                System.out.println("Список создан: " + list);
                            } else {
                                int[] array = new int[count];
                                for (int i = 0; i < count; i++) {
                                    System.out.print("Введите элемент [" + i + "]: ");
                                    array[i] = check.checkAnInteger();
                                }
                                list = new ImmutableListOfValues(array);
                                System.out.println("Список создан: " + list);
                            }
                            break;
                        }
                        case 2: {
                            // Создание из чисел через запятую
                            System.out.print("Введите числа через запятую: ");
                            scanner.nextLine();
                            String input = scanner.nextLine().trim();
                            if (input.isEmpty()) {
                                list = new ImmutableListOfValues();
                                System.out.println("Создан пустой список: " + list);
                            } else {
                                try {
                                    String[] parts = input.split(",");
                                    int[] numbers = new int[parts.length];
                                    for (int i = 0; i < parts.length; i++) {
                                        numbers[i] = Integer.parseInt(parts[i].trim());
                                    }
                                    list = new ImmutableListOfValues(numbers);
                                    System.out.println("Список создан: " + list);
                                } catch (NumberFormatException e) {
                                    System.out.println("Недопустимый ввод. Введите целые числа через запятую.");
                                }
                            }
                            break;
                        }
                        case 3: {
                            // Пустой список
                            list = new ImmutableListOfValues();
                            System.out.println("Создан пустой список: " + list);
                            break;
                        }
                        case 4: {
                            // Создание копии
                            ImmutableListOfValues listOrig = new ImmutableListOfValues(1, 2, 3, 4, 5);
                            System.out.print("Оригинальный список: ");
                            System.out.println(listOrig);
                            list = new ImmutableListOfValues(listOrig);
                            System.out.print("Скопированный список: ");
                            System.out.println(list);
                            break;
                        }
                        default:
                            System.out.println("Недопустимый выбор.");
                            break;
                    }
                    boolean running = true;
                    while (running) {
                        System.out.println("\n-----Действия со списком------");
                        System.out.println("1 - Получить значение по индексу");
                        System.out.println("2 - Заменить значение по индексу");
                        System.out.println("3 - Проверить пустоту списка");
                        System.out.println("4 - Получить размер списка");
                        System.out.println("5 - Получить массив значений");
                        System.out.println("6 - Вывести список как строку");
                        System.out.println("0 - Выход");
                        System.out.print("Выберите действие: ");
                        int choice4 = check.checkAnInteger();
                        switch (choice4) {
                            case 1: {
                                // Получение значения по индексу
                                if (list == null) {
                                    System.out.println("Список пуст.");
                                } else {
                                    System.out.print("Список: ");
                                    System.out.println(list);
                                    System.out.print("Введите индекс для получения значения (0-" + (list.size() - 1) + "): ");
                                    int index = check.checkAnInteger();
                                    try {
                                        int value = list.positionN(index);
                                        System.out.println("Значение по индексу " + index + ": " + value);
                                    } catch (IndexOutOfBoundsException e) {
                                        System.out.println("Недопустимое значение. " + e.getMessage());
                                    }
                                }
                                break;
                            }
                            case 2: {
                                // Замена значения по индексу
                                if (list == null) {
                                    System.out.println("Список пуст.");
                                } else {
                                    System.out.print("Список: ");
                                    System.out.println(list);
                                    System.out.print("Введите индекс для замены (0-" + (list.size()-1) + "): ");
                                    int index = check.checkAnInteger();
                                    System.out.print("Введите новое значение: ");
                                    int newValue = check.checkAnInteger();
                                    try {
                                        ImmutableListOfValues newList = list.replacementValue(index, newValue);
                                        System.out.println("Исходный список: " + list);
                                        System.out.println("Новый список: " + newList);
                                    } catch (IndexOutOfBoundsException e) {
                                        System.out.println("Недопустимое значение. " + e.getMessage());
                                    }
                                }
                                break;
                            }
                            case 3: {
                                // Проверка пустоты
                                System.out.println("Список пуст: " + list.isEmpty());
                                break;
                            }
                            case 4: {
                                // Получение размера
                                System.out.println("Размер списка: " + list.size());
                                break;
                            }
                            case 5: {
                                // Получение массива значений
                                if (list == null) {
                                    System.out.println("Список пуст.");
                                } else {
                                    int[] array = list.toArray();
                                    System.out.println("Массив значений: " + Arrays.toString(array));
                                }
                                break;
                            }
                            case 6: {
                                // Вывод как строки
                                if (list == null) {
                                    System.out.println("Список пуст");
                                } else {
                                    System.out.println("Список как строка: " + list.toString());
                                }
                                break;
                            }
                            case 0: {
                                System.out.println("Выход из задания");
                                running = false;
                                break;
                            }
                            default: {
                                System.out.println("Неверный выбор, попробуйте снова");
                                break;
                            }
                        }
                    }
                }
                case 3: {
                    System.out.println("\nАвтомат. Создайте такой подвид сущности Пистолет из задачи 2.1.5, которая будет совпадать с\n" +
                            "ней во всех отношениях, кроме следующего:\n" +
                            "\uF0B7 Имеет скорострельность (целое число, неизменяемое) которое обозначает количество\n" +
                            "выстрелов в секунду, поддерживаемое данным автоматом. Скорострельность всегда\n" +
                            "положительное число.\n" +
                            "\uF0B7 При вызове Стрелять количество выстрелов соответствует скорострельности (например,\n" +
                            "при скорострельности 3 выводится три строки с текстом выстрела).\n" +
                            "\uF0B7 Умеет Стрелять N секунд, что приводит к количеству выстрелов равному N умноженное\n" +
                            "на скорострельность.\n" +
                            "\uF0B7 Инициализация может быть выполнены следующими способами:\n" +
                            "a) Без параметров. Скорострельность 30, вместимость 30.\n" +
                            "b) С указанием максимального числа патронов. Скорострельность будет равна\n" +
                            "половине обоймы\n" +
                            "c) С указанием максимального количества патронов в обойме и скорострельности. ");
                    Automat automat = null;
                    System.out.println("\n---------Создание автомата---------\n");
                    System.out.println("*Для упрощения демонстрации автомат будет полностью заряжен*");
                    System.out.println("1 - Создать по умолчанию (вместимость - 30, скорострельность - 30");
                    System.out.println("2 - Создать с указанием только вместимости (скорострельность - половина обоймы)");
                    System.out.println("3 - Создать с указанием и вместимости и скорострельности");
                    System.out.print("Выберите способ создания: ");
                    int creationChoice2 = check.checkAnInteger();
                    switch (creationChoice2) {
                        case 1: {
                            // Создание по умолчанию (вместимость - 30, скорострельность - 30
                            automat = new Automat();
                            break;
                        }
                        case 2: {
                            // Создание с указанием только вместимости (скорострельность - половина обоймы)
                            boolean created = false;
                            while (!created) {
                                System.out.print("Введите вместимость автомата: ");
                                capacity = check.checkAnInteger();
                                try {
                                    automat = new Automat(capacity);
                                    created = true;
                                } catch (IllegalArgumentException e) {
                                    System.out.println("Недопустимое значение. " + e.getMessage());
                                }
                            }
                            break;
                        }
                        case 3: {
                            // Создание с указанием и вместимости и скорострельности
                            boolean created = false;
                            while (!created) {
                                System.out.print("Введите вместимость автомата: ");
                                capacity = check.checkAnInteger();
                                System.out.print("Введите скорострельность автомата: ");
                                int rateOfFire = check.checkAnInteger();
                                try {
                                    automat = new Automat(capacity, rateOfFire);
                                    created = true;
                                } catch (IllegalArgumentException e) {
                                    System.out.println("Недопустимое значение. " + e.getMessage());
                                }
                            }
                            break;
                        }
                        default:
                            System.out.println("Недопустимый выбор.");
                            break;
                    }
                    System.out.println(automat);
                    boolean running = true;
                    while (running) {
                        System.out.println("\n-----Действия с автоматом------");
                        System.out.println("1 - Вызов <Стрелять>: количество вызовов = скорострельности");
                        System.out.println("2 - Стрелять определенное количество секунд");
                        System.out.println("0 - Выход");
                        System.out.print("Выберите действие: ");
                        int choice5 = check.checkAnInteger();
                        switch (choice5) {
                            case 1: {
                                System.out.println(automat);
                                automat.shootAuto();
                                maxCapacity = automat.getMaxCapacity(); //перезарядка до максимума
                                int currentBullets = automat.getBulletCount();
                                if (currentBullets < maxCapacity) {
                                    bulletsToLoad = maxCapacity - currentBullets;
                                    automat.reload(bulletsToLoad);
                                }
                                break;
                            }
                            case 2: {
                                System.out.println(automat);
                                int seconds = 0;
                                while (true) {
                                    System.out.print("Введите количество секунд для стрельбы: ");
                                    seconds = check.checkAnInteger();
                                    if (seconds > 0) {
                                        break;
                                    } else {
                                        System.out.println("Недопустимое значение. Количество секунд должно быть положительным числом!");
                                    }
                                }

                                System.out.println("Стрельба в течение " + seconds + " секунд:");
                                automat.shootForSeconds(seconds);

                                maxCapacity = automat.getMaxCapacity(); //перезарядка до максимума
                                int currentBullets = automat.getBulletCount();
                                if (currentBullets < maxCapacity) {
                                    bulletsToLoad = maxCapacity - currentBullets;
                                    automat.reload(bulletsToLoad);
                                }
                                break;
                            }
                            case 0: {
                                System.out.println("Выход из задания");
                                running = false;
                                break;
                            }
                            default: {
                                System.out.println("Неверный выбор, попробуйте снова");
                                break;
                            }
                        }
                    }
                    break;
                }
                case 4: {
                    System.out.println("\nОружие.\n" +
                            "Измените сущность Пистолет, полученную в задаче 2.1.5 таким образом, чтобы она наследовалась\n" +
                            "от класса Weapon описанного на рисунке:\n");
                    System.out.println("\n--------Создание собственного оружия--------\n");
                    Gun2W myGunW = null;

                    created4 = false;
                    while (!created4) {
                        System.out.print("Введите максимальную вместимость оружия: ");
                        maxCapacity = check.checkAnInteger();
                        System.out.print("Введите начальное количество патронов (0-" + maxCapacity + "):");
                        initialBullets = check.checkAnInteger();
                        try {
                            System.out.println();
                            myGunW = new Gun2W(initialBullets, maxCapacity);
                            created4 = true;
                        } catch (IllegalArgumentException e) {
                            System.out.println("Недопустимое значение. " + e.getMessage());
                        }
                    }

                    System.out.println("Оружие создано успешно!");
                    myGunW.strReload();
                    System.out.println("Максимальная вместимость: " + myGunW.getMaxCapacity());
                    running4 = false;
                    while(!running4) {
                        System.out.println("\n-----Действия с оружием------------");
                        System.out.println("1 - Зарядить патроны");
                        System.out.println("2 - Выстрелить");
                        System.out.println("3 - Разрядить");
                        System.out.println("4 - Полностью перезарядить");
                        System.out.println("5 - Проверить состояние");
                        System.out.println("6 - Информация о пистолете");
                        System.out.println("7 - Многократная стрельба");
                        System.out.println("0 - Выход");
                        System.out.print("Выберите действие: ");
                        int choice3 = check.checkAnInteger();
                        switch (choice3) {
                            case 1: {
                                // Зарядка патронов
                                reload2 = false;
                                System.out.print("Сколько патронов зарядить? ");
                                while (!reload2) {
                                    bulletsToLoad = check.checkAnInteger();
                                    try {
                                        reload = myGunW.reload(bulletsToLoad);
                                        if (reload != 0) {
                                            System.out.println("Пистолет полностью заряжен. Возвращено патронов - " + reload);
                                        }
                                        myGunW.strReload();
                                        reload2 = true;
                                    } catch (IllegalArgumentException e) {
                                        System.out.println("Недопустимое значение. " + e.getMessage());
                                    }
                                }
                                break;
                            }
                            case 2: {
                                // Выстрел
                                System.out.print("Выстрел: ");
                                myGunW.shoot();
                                break;
                            }
                            case 3: {
                                // Разрядка
                                int returned2 = myGunW.unload();
                                System.out.println("Пистолет разряжен. Возвращено патронов: " + returned2);
                                break;
                            }
                            case 4: {
                                //полная перезарядка
                                reload2 = false;
                                System.out.print("Сколько патронов зарядить? ");
                                while (!reload2) {
                                    bulletsToLoad = check.checkAnInteger();
                                    try {
                                        myGunW.setBulletCount(bulletsToLoad);
                                        myGunW.strReload();
                                        reload2 = true;
                                    } catch (IllegalArgumentException e) {
                                        System.out.println("Недопустимое значение. " + e.getMessage());
                                    }
                                }
                                break;
                            }
                            case 5: {
                                // Проверка состояния
                                myGunW.isLoaded();
                                break;
                            }
                            case 6: {
                                // Информация о пистолете
                                System.out.println("Текущее количество патронов: " + myGunW.getBulletCount());
                                System.out.println("Максимальная вместимость: " + myGunW.getMaxCapacity());
                                System.out.println("Состояние: " + myGunW.toString());
                                break;
                            }
                            case 7: {
                                // Многократная стрельба
                                shoot2 = false;
                                while (!shoot2) {
                                    System.out.print("Сколько раз выстрелить? ");
                                    shots = check.checkAnInteger();
                                    if (shots < 0) {
                                        System.out.println("Недопустимое значение. Количество выстрелов не может быть отрицательным!");
                                    } else {
                                        System.out.println("Производим " + shots + " выстрелов:");
                                        for (int i = 0; i < shots; i++) {
                                            myGunW.shoot();
                                        }
                                        shoot2 = true;
                                    }
                                }
                                break;
                            }
                            case 0: {
                                // Выход
                                running4 = true;
                                System.out.println("Выход из программы.");
                                break;
                            }
                            default:
                                System.out.println("Неверный выбор! Попробуйте снова.");
                                break;
                        }
                    }
                    break;
                }
                case 5: {
                    System.out.println("\nЛучший стрелок.\n" +
                            "Создайте сущность Стрелок, которая описывается:\n" +
                            "\uF0B7 Имя, строка\n" +
                            "\uF0B7 Оружие, из задачи 2.4.1.\n" +
                            "\uF0B7 При создании объекта необходимо указать ему имя\n" +
                            "\uF0B7 Имя и оружие можно поменять и получить в любой момент без ограничения.\n" +
                            "Основная способность Стрелка - умение стрелять. Если оружие есть, то выстрел происходит по\n" +
                            "правилам оружия, если его нет – то выводится текст “не могу участвовать в перестрелке”.\n" +
                            "Создайте трех стрелков: одного без оружия, одного с пистолетом и одного с автоматом, и пусть\n" +
                            "каждый из них выстрелит.\n");
                    //Создаём стрелков
                    Shooter shooter1 = new Shooter("Петр");
                    Shooter shooter2 = new Shooter("Витя");
                    Shooter shooter3 = new Shooter("Сашка");

                    // Выдаем оружие через сеттеры
                    shooter2.setWeapon(new Gun2W());    // пистолет по умолчанию (5 патронов)
                    shooter3.setWeapon(new AutomatW());  // автомат по умолчанию (0 патронов)

                    // Заряжаем автомат для демонстрации
                    ((AutomatW)shooter3.getWeapon()).reload(10);

                    System.out.println("\n-----Стрелки-----");
                    System.out.println("1. " + shooter1);
                    System.out.println("2. " + shooter2);
                    System.out.println("3. " + shooter3);

                    System.out.println("\n-----Выстрел каждого-----");
                    System.out.println("Первый стрелок (" + shooter1.getName() + "):");
                    shooter1.shoot();  // "не могу участвовать в перестрелке"

                    System.out.println("\nВторой стрелок (" + shooter2.getName() + "):");
                    shooter2.shoot();  // выстрел из пистолета

                    System.out.println("\nТретий стрелок (" + shooter3.getName() + "):");
                    shooter3.shoot();  // выстрел из автомата
                    break;
                }
                case 6:{
                    System.out.println("\nСравнение точек.\n" +
                            "Измените сущность Точка из задачи 1.4.1. Переопределите метод сравнения объектов по\n" +
                            "состоянию таким образом, чтобы две точки считались одинаковыми тогда, когда они\n" +
                            "расположены в одинаковых координатах.");
                    System.out.println("\n-----Создание первой точки для сравнения-----");
                    System.out.print("Введите координату X:");
                    X1 = check.checkDouble();
                    System.out.print("Введите координату Y:");
                    Y1 = check.checkDouble();
                    Point point1 = new Point(X1, Y1);

                    System.out.println("\n-----Создание второй точки для сравнения-----");
                    System.out.print("Введите координату X:");
                    X2 = check.checkDouble();
                    System.out.print("Введите координату Y:");
                    Y2 = check.checkDouble();
                    Point point2 = new Point(X2, Y2);

                    System.out.println("\n-----Сравнение-----");
                    System.out.println("Точка 1:" + point1);
                    System.out.println("Точка 2:" + point2);
                    System.out.println("\nОдинаковые точки? - " + point1.equals(point2));
                    break;
                }
                case 7:{
                    subtask = true;
                    while (subtask) {
                        System.out.println("\nНомер подзадания:");
                        System.out.println("1 - Навести порядок");
                        System.out.println("2 - Главный метод");
                        System.out.println("3 - Возведение в степень");
                        System.out.println("0 - Выход");
                        System.out.print("Ваш выбор: ");
                        choice2 = check.checkAnInteger();
                        switch (choice2) {
                            case 1: {
                                System.out.println("\nНавести порядок.\n" +
                                        "Данная задача предполагает реорганизацию ранее написанных классов. Расположите все ранее\n" +
                                        "написанные классы по пакетам таким образом, чтобы логически близкие классы оказались\n" +
                                        "сгруппированы друг с другом. Имена пакетов должны иметь как минимум трехсоставную форму,\n" +
                                        "вида: ru.surname.type. Вместо surname следует подставить свою фамилию, а вместо type\n" +
                                        "подставить название логического блока. Например, классы описывающие точку, линию, ломаную\n" +
                                        "линию, фигуру, квадрат, треугольник, круг и прямоугольник можно расположить в пакете\n" +
                                        "ru.surname.geometry. ");
                                break;
                            }
                            case 2: {
                                System.out.println("\nГлавный метод.\n" +
                                        "Создайте пакет ru.surname.main (вместо surname необходимо подставить собственную\n" +
                                        "фамилию) в котором расположить класс с точкой входа в исполнение программы (public static void\n" +
                                        "main). Также следует проверить, что ни в одном другом пакете нет классов имеющих точку входа\n" +
                                        "в исполнение программы. В этом же пакете необходимо расположить класс (или интерфейс) с\n" +
                                        "методами из задач блока 2.5 и продемонстрировать их работоспособность. ");
                                Block25 demonstrate = new Block25();
                                demonstrate.demonstrateThreeShooters();
                                demonstrate.demonstrateAutomaticFire();
                                break;
                            }
                            case 3: {
                                System.out.println("\nВозведение в степень.\n" +
                                        "Создайте метод принимающий две строки, в которых будут записаны числа X и Y. Возвращает\n" +
                                        "метод результат возведения X в степень Y. Для преобразования строки в число следует\n" +
                                        "использовать метод Integer.parseInt, а для возведения в степень метод Math.pow. Вызовите\n" +
                                        "разработанный метод передав туда параметры командной строки полученные точкой входа в\n" +
                                        "программу. Реализуйте метод так, что бы для возведения в степень и преобразования строки\n" +
                                        "использовались короткие имена статических методов.\n");
                                //если есть аргументы в командной строке
                                if (savedArgs.length == 2) {
                                    System.out.println("Используются аргументы командной строки:");
                                    double result = Pow.power(args[0], args[1]);
                                    System.out.printf("%s ^ %s = %.0f\n", args[0], args[1], result);
                                }
                                //если нет аргументов - прошу ввести с консоли
                                else {
                                    System.out.print("Введите число: ");
                                    String xStr = scanner.nextLine();
                                    System.out.print("Введите степень: ");
                                    String yStr = scanner.nextLine();

                                    double result = Pow.power(xStr, yStr);
                                    System.out.printf("%s ^ %s = %.0f\n", xStr, yStr, result);
                                }

                                break;
                            }
                            case 0: {
                                System.out.println("Выход из задания");
                                subtask = false;
                                break;
                            }
                            default: {
                                System.out.println("Неверный выбор, попробуйте снова");
                                break;
                            }
                        }
                    }
                    break;
                }
                case 8: {
                    System.out.println("\nПатроны наследникам.\n" +
                            "Измените класс Weapon из задачи 2.4.1 таким образом, что бы любой класс наследник мог\n" +
                            "непосредственно работать с полем хранящим количество патронов заряженном в оружии.\n" +
                            "Обратите внимание, что метод разрядки Пистолет, усложнившийся при решении задачи\n" +
                            "2.4.1 снова можно упростить.\n");
                    System.out.println("\n--------Создание собственного оружия--------\n");
                    Gun2W2 myGunW2 = null;

                    created4 = false;
                    while (!created4) {
                        System.out.print("Введите максимальную вместимость оружия: ");
                        maxCapacity = check.checkAnInteger();
                        System.out.print("Введите начальное количество патронов (0-" + maxCapacity + "):");
                        initialBullets = check.checkAnInteger();
                        try {
                            System.out.println();
                            myGunW2 = new Gun2W2(initialBullets, maxCapacity);
                            created4 = true;
                        } catch (IllegalArgumentException e) {
                            System.out.println("Недопустимое значение. " + e.getMessage());
                        }
                    }

                    System.out.println("Оружие создано успешно!");
                    myGunW2.strReload();
                    System.out.println("Максимальная вместимость: " + myGunW2.getMaxCapacity());
                    running4 = false;
                    while(!running4) {
                        System.out.println("\n-----Действия с оружием------------");
                        System.out.println("1 - Зарядить патроны");
                        System.out.println("2 - Выстрелить");
                        System.out.println("3 - Разрядить");
                        System.out.println("4 - Полностью перезарядить");
                        System.out.println("5 - Проверить состояние");
                        System.out.println("6 - Информация о пистолете");
                        System.out.println("7 - Многократная стрельба");
                        System.out.println("0 - Выход");
                        System.out.print("Выберите действие: ");
                        int choice3 = check.checkAnInteger();
                        switch (choice3) {
                            case 1: {
                                // Зарядка патронов
                                reload2 = false;
                                System.out.print("Сколько патронов зарядить? ");
                                while (!reload2) {
                                    bulletsToLoad = check.checkAnInteger();
                                    try {
                                        reload = myGunW2.reload(bulletsToLoad);
                                        if (reload != 0) {
                                            System.out.println("Пистолет полностью заряжен. Возвращено патронов - " + reload);
                                        }
                                        myGunW2.strReload();
                                        reload2 = true;
                                    } catch (IllegalArgumentException e) {
                                        System.out.println("Недопустимое значение. " + e.getMessage());
                                    }
                                }
                                break;
                            }
                            case 2: {
                                // Выстрел
                                System.out.print("Выстрел: ");
                                myGunW2.shoot();
                                break;
                            }
                            case 3: {
                                // Разрядка
                                int returned2 = myGunW2.unload();
                                System.out.println("Пистолет разряжен. Возвращено патронов: " + returned2);
                                break;
                            }
                            case 4: {
                                //полная перезарядка
                                reload2 = false;
                                System.out.print("Сколько патронов зарядить? ");
                                while (!reload2) {
                                    bulletsToLoad = check.checkAnInteger();
                                    try {
                                        myGunW2.setBulletCount(bulletsToLoad);
                                        myGunW2.strReload();
                                        reload2 = true;
                                    } catch (IllegalArgumentException e) {
                                        System.out.println("Недопустимое значение. " + e.getMessage());
                                    }
                                }
                                break;
                            }
                            case 5: {
                                // Проверка состояния
                                myGunW2.isLoaded();
                                break;
                            }
                            case 6: {
                                // Информация о пистолете
                                System.out.println("Текущее количество патронов: " + myGunW2.getBulletCount());
                                System.out.println("Максимальная вместимость: " + myGunW2.getMaxCapacity());
                                System.out.println("Состояние: " + myGunW2.toString());
                                break;
                            }
                            case 7: {
                                // Многократная стрельба
                                shoot2 = false;
                                while (!shoot2) {
                                    System.out.print("Сколько раз выстрелить? ");
                                    shots = check.checkAnInteger();
                                    if (shots < 0) {
                                        System.out.println("Недопустимое значение. Количество выстрелов не может быть отрицательным!");
                                    } else {
                                        System.out.println("Производим " + shots + " выстрелов:");
                                        for (int i = 0; i < shots; i++) {
                                            myGunW2.shoot();
                                        }
                                        shoot2 = true;
                                    }
                                }
                                break;
                            }
                            case 0: {
                                // Выход
                                running4 = true;
                                System.out.println("Выход из программы.");
                                break;
                            }
                            default:
                                System.out.println("Неверный выбор! Попробуйте снова.");
                                break;
                        }
                    }
                    break;
                }
                case 0: {
                    System.out.println("Выход из программы");
                    return;
                }
                default:
                    System.out.println("Неверный выбор, попробуйте снова");
            }
        }

    }
}