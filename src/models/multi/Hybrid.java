package models.multi;

public class Hybrid extends Knight implements IWizard {

    private String currentWeapon;

    // Wizard attributes
    private String castingStaff;

    private int currentMana, maxMana;

    public Hybrid(String enemyName, int maxHP , int currentHP, int maxStamina, int currentStamina,
                  String castingStaff, int maxMana, int currentMana,
                  String meleeWeapon, String currentWeapon)
    {
        super(enemyName, maxHP, currentHP, maxStamina, currentStamina, meleeWeapon);
        setCastingStaff(castingStaff);
        setCurrentWeapon(currentWeapon);

        setMaxMana(maxMana);
        setCurrentMana(currentMana);
    }

    public String getCurrentWeapon() {
        return currentWeapon;
    }

    private void setCurrentWeapon(String currentWeapon) { // private
        if(currentWeapon == null || currentWeapon.isBlank()) throw new IllegalArgumentException("Current weapon is required");
        if(!currentWeapon.equals(getMeleeWeapon()) && !currentWeapon.equals(getCastingStaff()))
            throw new IllegalArgumentException("Current weapon has to be a weapon belonging to this character");

        this.currentWeapon = currentWeapon;
    }

    public void swapCurrentWeapon() { // instead of a standard setter I provide a void method which causes a swap
        if(currentWeapon.equals(getMeleeWeapon())) {
            this.currentWeapon = getCastingStaff();
        } else {
            this.currentWeapon = getMeleeWeapon();
        }
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
        return "Hybrid character " + getEnemyName() +
                ", HP: " + getCurrentHP() + "/" + getMaxHP() +
                " Stamina: " + getCurrentStamina() + "/" + getMaxStamina() +
                " Mana: " + getCurrentMana() + "/" + getMaxMana() +
                ", Current weapon: " + getCurrentWeapon();
    }
}
