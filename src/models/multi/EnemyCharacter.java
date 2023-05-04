package models.multi;

public abstract class EnemyCharacter {

    private String enemyName;

    private int currentHP, maxHP, currentStamina, maxStamina;

    public EnemyCharacter(String enemyName, int maxHP, int currentHP, int maxStamina, int currentStamina) {
        setEnemyName(enemyName);

        // first set Max as current is dependent on it
        setMaxHP(maxHP);
        setCurrentHP(currentHP);

        setMaxStamina(maxStamina);
        setCurrentStamina(currentStamina);
    }

    public String getEnemyName() {
        return enemyName;
    }

    public void setEnemyName(String enemyName) {
        if(enemyName == null || enemyName.isBlank()) throw new IllegalArgumentException("Enemy character's name is required");

        this.enemyName = enemyName;
    }

    public int getCurrentHP() {
        return currentHP;
    }

    public void setCurrentHP(int currentHP) {
        if(currentHP < 0) throw new IllegalArgumentException("HP cannot be a negative number");
        if(currentHP > this.maxHP) throw new IllegalArgumentException("Current HP cannot exceed the maximum HP of the character");

        this.currentHP = currentHP;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public void setMaxHP(int maxHP) {
        if(maxHP < 0) throw new IllegalArgumentException("HP cannot be a negative number");

        // when we lower max health below the current number of health points
        if(this.currentHP > maxHP) this.currentHP = maxHP;

        this.maxHP = maxHP;
    }

    public int getCurrentStamina() {
        return currentStamina;
    }

    public void setCurrentStamina(int currentStamina) {
        if(currentStamina < 0) throw new IllegalArgumentException("Stamina cannot be a negative number");
        if(currentStamina > this.maxStamina) throw new IllegalArgumentException("Current stamina cannot exceed the maximum stamina of the character");

        this.currentStamina = currentStamina;
    }

    public int getMaxStamina() {
        return maxStamina;
    }

    public void setMaxStamina(int maxStamina) {
        if(maxStamina < 0) throw new IllegalArgumentException("Stamina cannot be a negative number");

        if(this.currentStamina > maxStamina) this.currentStamina = maxStamina;

        this.maxStamina = maxStamina;
    }
}
