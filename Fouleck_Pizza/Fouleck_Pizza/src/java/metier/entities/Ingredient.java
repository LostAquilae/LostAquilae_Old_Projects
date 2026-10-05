/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier.entities;

/**
 *
 * @author slx
 */
public class Ingredient {
    private int id;
    private String nom;
    
    public Ingredient()
    { }

    public Ingredient(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }
    
    
}
