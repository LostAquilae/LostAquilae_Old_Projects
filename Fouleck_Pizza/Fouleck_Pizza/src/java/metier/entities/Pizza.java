package metier.entities;

import java.util.List;

public class Pizza
{
    private int id;
    private String nom;
    private String description;
    private String img;
    private float prix;
    private List<Ingredient> ingredients;
    
    public Pizza()
    { }
    
    public Pizza(int id, String nom, String description, String img, float prix, List<Ingredient> ingredients)
    {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.img = img;
        this.prix = prix;
        this.ingredients = ingredients;
    }
    
    public int getId()
    { return this.id; }
    
    public String getNom()
    { return this.nom; }
    
    public String getDescription()
    { return this.description; }
    
    public String getImg()
    { return this.img; }
    
    public float getPrix()
    { return this.prix; }
    
    public List<Ingredient> getIngredients()
    { return this.ingredients; }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
}
