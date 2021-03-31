package ru.itcube.DataSource;

public class User {

    private String name;
    private boolean sex;
    private String fullname;
    private int old;
    private String favoriteColor;


    public User(String name, boolean sex, String fullname, int old, String favoriteColor) {
        this.name = name;
        this.sex = sex;
        this.fullname = fullname;
        this.old = old;
        this.favoriteColor = favoriteColor;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public int getOld() {
        return old;
    }

    public void setOld(int old) {
        this.old = old;
    }

    public String getFavoriteColor() {
        return favoriteColor;
    }

    public void setFavoriteColor(String favoriteColor) {
        this.favoriteColor = favoriteColor;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (isSex() != user.isSex()) return false;
        if (getOld() != user.getOld()) return false;
        if (getName() != null ? !getName().equals(user.getName()) : user.getName() != null) return false;
        if (getFullname() != null ? !getFullname().equals(user.getFullname()) : user.getFullname() != null)
            return false;
        return getFavoriteColor() != null ? getFavoriteColor().equals(user.getFavoriteColor()) : user.getFavoriteColor() == null;
    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + (isSex() ? 1 : 0);
        result = 31 * result + (getFullname() != null ? getFullname().hashCode() : 0);
        result = 31 * result + getOld();
        result = 31 * result + (getFavoriteColor() != null ? getFavoriteColor().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", sex=" + sex +
                ", fullname='" + fullname + '\'' +
                ", old=" + old +
                ", favoriteColor='" + favoriteColor + '\'' +
                '}';
    }
}
