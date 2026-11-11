public class Person {
    public String name;
    public int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //jezeli napisze ...printlnt(lista_z_person) to kazdy obiekt tej listy bedzie wypisywac sie tak:
    @Override
    public String toString() {
        //dokladnie tak bedzie wypisywac sie
        return "imie: " + name + ", wiek: " + age;
    }

}
