package models.multi;

public class Knight extends EnemyCharacter {

    private String meleeWeapon;

    public Knight(String enemyName, int maxHP , int currentHP, int maxStamina, int currentStamina, String meleeWeapon) {
        super(enemyName, maxHP, currentHP, maxStamina, currentStamina);
        setMeleeWeapon(meleeWeapon);
    }

    public String getMeleeWeapon() {
        return meleeWeapon;
    }

    public void setMeleeWeapon(String meleeWeapon) {
        if(meleeWeapon == null || meleeWeapon.isBlank()) throw new IllegalArgumentException("Weapon's name is required");

        this.meleeWeapon = meleeWeapon;
    }

    @Override
    public String toString() {
        return "Knight " + getEnemyName() +
                ", HP: " + getCurrentHP() + "/" + getMaxHP() +
                " Stamina: " + getCurrentStamina() + "/" + getMaxStamina();
    }
}
