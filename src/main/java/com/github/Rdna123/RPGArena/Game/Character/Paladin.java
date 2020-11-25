/*
 * Copyright 2020 Robert Kimura
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.github.Rdna123.RPGArena.Game.Character;


public class Paladin extends Player {
    private final int defense;
    private int Inspiration;

    public Paladin(int str, int def){
        super(str, def);
        setClassName("Paladin ");
        int strength = str - 4;
        setStrength(strength);
        this.defense = def+2;
        setDefense(this.defense);
        this.health = 100-1;
        setHealth(this.health);
    }

    @Override
    public int takeDamage(int damage) {
        boolean Block = (int) (Math.random() * 10000) >= Inspiration - this.health;
        Inspiration = (int) (Math.random() * 10000);
        if (Block){
            System.out.println(this.name + " receives half damage");
            int damageTaken = (damage - this.defense)/2;
            if (damageTaken > 0) {
                this.health -= damageTaken;
                return damageTaken;
            } else if (damageTaken < 0) {
                return 0;
            }
        }else {
            int damageTaken = damage - this.defense;
            if (damageTaken > 0) {
                this.health -= damageTaken;
                return damageTaken;
            } else if (damageTaken < 0) {
                return 0;
            }
        }
        return 0;
    }

    public int getInspiration() {
        return Inspiration;
    }

    public void setInspiration(int Inspiration) {
        this.Inspiration = Inspiration;
    }
}
