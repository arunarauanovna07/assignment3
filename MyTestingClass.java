package assignment2;
public class MyTestingClass {
    private int id;
    private String name;
    public MyTestingClass(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public int hashCode() {
        int hash = 17;
        hash = 31 * hash + id;
        hash = 31 * hash + (name == null ? 0 : name.hashCode());
        hash ^= (hash >>> 20) ^ (hash >>> 12);
        hash = hash ^ (hash >>> 7) ^ (hash >>> 4);
        return hash;
    }
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        MyTestingClass that = (MyTestingClass) obj;
        return id == that.id && (name != null ? name.equals(that.name) : that.name == null);
    }
    public String toString() {
        return "MyTestingClass{id=" + id + ", name='" + name + "'}";
    }
}