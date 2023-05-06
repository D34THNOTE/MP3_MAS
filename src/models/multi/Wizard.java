package models.multi;

public class Wizard extends EnemyCharacter implements IWizard {

    private String castingStaff;

    private int currentMana, maxMana;

    public Wizard(String enemyName, int maxHP , int currentHP, int maxStamina, int currentStamina, String castingStaff, int maxMana, int currentMana) {
        super(enemyName, maxHP, currentHP, maxStamina, currentStamina);
        setCastingStaff(castingStaff);

        setMaxMana(maxMana);
        setCurrentMana(currentMana);
    }

    @Override
    public String getCastingStaff() {
        return castingStaff;
    }

    @Override
    public void setCastingStaff(String castingStaff) {
        if(castingStaff == null || castingStaff.isBlank()) throw new IllegalArgumentException("Staff's name is required");

        this.castingStaff = castingStaff;
    }

    @Override
    public int getCurrentMana() {
        return currentMana;
    }

    @Override
    public void setCurrentMana(int currentMana) {
        if(currentMana < 0) throw new IllegalArgumentException("Mana cannot be a negative number");
        if(currentMana > this.maxMana) throw new IllegalArgumentException("Current mana cannot exceed the maximum mana of the character");

        this.currentMana = currentMana;
    }

    @Override
    public int getMaxMana() {
        return maxMana;
    }

    @Override
    public void setMaxMana(int maxMana) {
        if(maxMana < 0) throw new IllegalArgumentException("Mana cannot be a negative number");

        if(this.currentMana > maxMana) this.currentMana = maxMana;

        this.maxMana = maxMana;
    }

    @Override
    public String toString() {
        return "Wizard: " + getEnemyName() +
                ", HP: " + getCurrentHP() + "/" + getMaxHP() +
                " Stamina: " + getCurrentStamina() + "/" + getMaxStamina() +
                " Mana: " + getCurrentMana() + "/" + getMaxMana() +
                ", Staff: " + getCastingStaff();
    }
}
