package oop.interfaces.sort.gameClans;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Weapon axe = new Weapon("Axe", 2235);
        Weapon heavySword = new Weapon("HeavySword", 1800);
        Weapon claw = new Weapon("Claw", 1912);
        Weapon javelin = new Weapon("HyperionJavelin", 2732);
        ArrayList<Weapon> weapons = new ArrayList<>();
        Collections.addAll(weapons, axe, heavySword, claw, javelin);
        HealerHero healerHero = new HealerHero("Healer", 350);
        Warrior warrior = new Warrior("Warrior", 900, weapons);
        Palladin palladin = new Palladin("Palladin", 700);
        Dragon dragon = new Dragon("Dragon", 1500);
        Goblin goblin = new Goblin("Goblin", 400);
        Orc orc = new Orc("Orc", 600, weapons);
        ArrayList<Personage> personages = new ArrayList<>();
        Collections.addAll(personages, healerHero, warrior, palladin, dragon, goblin, orc);


        for (; ; ) {
            boolean isHeroAlive = false;
            boolean isDarkHeroAlive = false;
            for (Personage personage : personages) {
                if (personage.isAlive()) {
                    if (personage.isHero()) {
                        isHeroAlive = true;
                    } else isDarkHeroAlive = true;
                }
            }
            if (!isHeroAlive) {
                System.out.println("Dark hero win ");
                return;
            }
            if (!isDarkHeroAlive) {
                System.out.println("Light hero win ");
                return;
            }
            for (Personage personage : personages) {
                ArrayList<Personage> targets = new ArrayList<>();
                ArrayList<Personage> alias = new ArrayList<>();
                if (!personage.isAlive())
                    continue;
                for (Personage personage1 : personages) {
                    if (personage1 == personage) {
                        continue;
                    }
                    if (!personage1.isAlive()) {
                        continue;
                    }
                    if (personage.isHero() == personage1.isHero()) {
                        alias.add(personage1);
                        continue;
                    }
                    targets.add(personage1);
                }
                if (targets.isEmpty()) {
                    continue;
                }
//                System.out.println(" ");
                Personage randomTarget = targets.get(new Random().nextInt(targets.size()));
                if (personage instanceof BattleMagician) {
                    BattleMagician paladin = (BattleMagician) personage;
                    paladin.attack(randomTarget);
                    if (alias.size() == 0) {
                        System.out.println(" Don't have alias ");
                    } else paladin.heal(alias.get(new Random().nextInt(alias.size())));
                } else if (personage instanceof Healer) {
                    Healer healer = (Healer) personage;
                    if (alias.size() == 0) {
                        System.out.println(" Don't have alias ");
                    } else healer.heal(alias.get(new Random().nextInt(alias.size())));
                } else if (personage instanceof Attacker) {
                    Attacker attacker = (Attacker) personage;
                    attacker.attack(randomTarget);
                }
            }
        }
    }
}
