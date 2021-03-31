package ru.itcube.DataSource;

public class Cats implements Comparable<Cats> {

    private String name;
    private Integer old;
    private String furColor;
    private String favoriteFood;


    public Cats(String name, int old, String furColor, String favoriteFood) {
        this.name = name;
        this.old = old;
        this.furColor = furColor;
        this.favoriteFood = favoriteFood;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOld() {
        return old;
    }

    public void setOld(int old) {
        this.old = old;
    }

    public String getFurColor() {
        return furColor;
    }

    public void setFurColor(String furColor) {
        this.furColor = furColor;
    }

    public String getFavoriteFood() {
        return favoriteFood;
    }

    public void setFavoriteFood(String favoriteFood) {
        this.favoriteFood = favoriteFood;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cats cats = (Cats) o;

        if (getOld() != cats.getOld()) return false;
        if (getName() != null ? !getName().equals(cats.getName()) : cats.getName() != null) return false;
        if (getFurColor() != null ? !getFurColor().equals(cats.getFurColor()) : cats.getFurColor() != null)
            return false;
        return getFavoriteFood() != null ? getFavoriteFood().equals(cats.getFavoriteFood()) : cats.getFavoriteFood() == null;
    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + getOld();
        result = 31 * result + (getFurColor() != null ? getFurColor().hashCode() : 0);
        result = 31 * result + (getFavoriteFood() != null ? getFavoriteFood().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Cats{" +
                "name='" + name + '\'' +
                ", old=" + old +
                ", furColor='" + furColor + '\'' +
                ", favoriteFood='" + favoriteFood + '\'' +
                '}';
    }

    @Override
    public int compareTo(Cats o) {
        if (o.equals(this)) return 0;
        if (old < o.getOld()) return -1;
        return 1;
    }
}
